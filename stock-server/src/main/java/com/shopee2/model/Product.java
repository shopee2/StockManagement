package com.shopee2.model;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private int id;
    private String sku;
    private String name;
    private String description;
    private String imageUrl;
    private double weight;
    private double price;
    private int stock;
    private int shopId;
    private int categoryId;

    public Product() {
        super();
    }

    public Product(
            int id,
            String sku,
            String name,
            String description,
            String imageUrl,
            double weight,
            double price,
            int stock,
            int shopId,
            int categoryId
    ) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.weight = weight;
        this.price = price;
        this.stock = stock;
        this.shopId = shopId;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
