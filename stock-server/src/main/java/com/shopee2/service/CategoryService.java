package com.shopee2.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.shopee2.model.Category;
import com.shopee2.stock.DocumentNotFoundException;
import com.shopee2.stock.IdentifierMutationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CategoryService {

    private final String COLLECTION = "categories";

    public void createCategory(Category category) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = db
                .collection(COLLECTION)
                .document(Integer.toString(category.getId()))
                .set(category);
    }

    public List<Category> getCategories() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference documentReference = db.collection(COLLECTION);

        ApiFuture<QuerySnapshot> future = documentReference.get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<Category> result = new ArrayList<>();

        if (!documents.isEmpty())
            for (DocumentSnapshot snapshot : documents)
                result.add(snapshot.toObject(Category.class));

        return result;
    }

    public Category getCategory(int id) throws InterruptedException, ExecutionException, DocumentNotFoundException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference documentReference = db.collection(COLLECTION).document(Integer.toString(id));
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        if (document.exists()) return document.toObject(Category.class);
        else throw new DocumentNotFoundException();
    }

    public void updateCategory(int id, Category category) throws IdentifierMutationException {
        if (id != category.getId()) {
            throw new IdentifierMutationException();
        } else {
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> collectionsApiFuture = db
                    .collection(COLLECTION)
                    .document(Integer.toString(id))
                    .set(category);
        }
    }

    public void deleteCategory(int id) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection(COLLECTION).document(Integer.toString(id)).delete();
    }

}
