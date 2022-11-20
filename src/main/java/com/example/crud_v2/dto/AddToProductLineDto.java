package com.example.crud_v2.dto;

public class AddToProductLineDto {
    private Long id;
    private Long product_id;
    private int quantity;
private Long customer_id;

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public AddToProductLineDto(Long id, Long product_id, int quantity) {
        this.id = id;
        this.product_id = product_id;
        this.quantity = quantity;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public AddToProductLineDto() {
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


}
