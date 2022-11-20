package com.example.crud_v2.dto;

import java.util.List;

public class CartCustomerDto {


    private static List<ViewProductLine> viewProductLines;
    private double total_price;
    private int quantity;

    public List<ViewProductLine> getViewItemLines() {
        return viewProductLines;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static void setViewItemLines(List<ViewProductLine> viewProductLines) {
        CartCustomerDto.viewProductLines = viewProductLines;
    }

    public CartCustomerDto() {
    }


}