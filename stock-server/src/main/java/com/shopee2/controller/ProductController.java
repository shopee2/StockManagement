package com.shopee2.controller;

import com.shopee2.model.Product;
import com.shopee2.service.ProductService;
import com.shopee2.stock.DocumentNotFoundException;
import com.shopee2.stock.IdentifierMutationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<Product> getProducts() {
        try {
            return productService.getProducts();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/product")
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        try {
            return productService.getProduct(id);
        } catch (DocumentNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product/{id}")
    public void updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        try {
            productService.updateProduct(id, product);
        } catch (IdentifierMutationException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
    }

    @DeleteMapping("/product/")
    public void deleteProducts(@RequestBody List<Integer> ids) {
        productService.deleteProducts(ids);
    }
}
