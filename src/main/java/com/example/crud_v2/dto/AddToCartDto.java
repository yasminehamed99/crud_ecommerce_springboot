package com.example.crud_v2.dto;

import com.sun.istack.NotNull;

public class AddToCartDto {

    private @NotNull Long id;
    private @NotNull Long Customer_id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        Customer_id = customer_id;
    }
}

