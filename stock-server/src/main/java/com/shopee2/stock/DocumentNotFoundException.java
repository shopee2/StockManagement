package com.shopee2.stock;

public class DocumentNotFoundException extends Exception {
    public DocumentNotFoundException() {
        super();
    }

    public DocumentNotFoundException(String message) {
        super(message);
    }
}
