package com.shopee2.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.shopee2.model.Category;
import com.shopee2.model.Product;
import com.shopee2.stock.DocumentNotFoundException;
import com.shopee2.stock.IdentifierMutationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ProductService {

    private final String COLLECTION = "products";

    public void createProduct(Product product) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = db
                .collection(COLLECTION)
                .document(Integer.toString(product.getId()))
                .set(product);
    }

    public List<Product> getProducts() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference documentReference = db.collection(COLLECTION);

        ApiFuture<QuerySnapshot> future = documentReference.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<Product> result = new ArrayList<>();

        if (!documents.isEmpty())
            for (DocumentSnapshot snapshot : documents)
                result.add(snapshot.toObject(Product.class));

        return result;
    }

    public Product getProduct(int id) throws InterruptedException, ExecutionException, DocumentNotFoundException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference documentReference = db.collection(COLLECTION).document(Integer.toString(id));
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        if (document.exists()) return document.toObject(Product.class);
        else throw new DocumentNotFoundException();
    }

    public void updateProduct(int id, Product product) throws IdentifierMutationException {
        if (id != product.getId()) {
            throw new IdentifierMutationException();
        } else {
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> collectionsApiFuture = db
                    .collection(COLLECTION)
                    .document(Integer.toString(id))
                    .set(product);
        }
    }

    public void deleteProduct(int id) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection(COLLECTION).document(Integer.toString(id)).delete();
    }

    public void deleteProducts(List<Integer> productIds) {
        for (int id : productIds) {
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> writeResult = db.collection(COLLECTION).document(Integer.toString(id)).delete();
        }
    }

    public List<Product> getProductInCategory(int categoryId) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference documentReference = db.collection(COLLECTION);

        ApiFuture<QuerySnapshot> future = documentReference.whereEqualTo("categoryId", categoryId).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<Product> result = new ArrayList<>();
        if (!documents.isEmpty())
            for (DocumentSnapshot snapshot : documents)
                result.add(snapshot.toObject(Product.class));
        return result;
    }

    public int countProduct(int categoryId) throws ExecutionException, InterruptedException {
        return this.getProductInCategory(categoryId).size();
    }

}
