package com.example.crud_v2.service;

public class ProductNotExistsException extends IllegalArgumentException {
    public ProductNotExistsException(String s) {
        super(s);
    }
}
