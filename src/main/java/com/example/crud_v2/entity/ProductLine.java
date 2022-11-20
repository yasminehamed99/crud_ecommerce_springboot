package com.example.crud_v2.entity;

import javax.persistence.*;

@Entity(name = "item_line")
@Table
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public ProductLine() {
    }



    @OneToOne
    @JoinColumn(name = "item_item_id")
    private Product product;
    private int quantity;
    private double total_price;

    public ProductLine(Product product, int quantity, double total_price) {
        this.product = product;
        this.quantity = quantity;
        this.total_price = total_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
       double total_price=0.0;
      total_price=getQuantity()*getItem().getPrice();
      return total_price;

    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public Product getItem() {
        return product;
    }

    public void setItem(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

