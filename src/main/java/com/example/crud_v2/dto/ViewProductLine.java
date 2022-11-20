package com.example.crud_v2.dto;

public class ViewProductLine {
    private Long id;
    private Long product_id;
    private int quantity;
    private double total_price;

    public ViewProductLine(Long id, Long product_id, int quantity, double total_price) {
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.total_price = total_price;
    }

    public ViewProductLine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
}
