package com.example.crud_v2.dto;




public class ProductDto {
    private Long item_id;
    private String name;
    private String description;

    private double price;

    public ProductDto(Long item_id, String name, String description, double price) {
        this.item_id = item_id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductDto() {
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}