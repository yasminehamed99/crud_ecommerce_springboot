package com.example.crud_v2.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "cart")
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
   @OneToMany
   @JoinColumn(name = "itemLine_idd")
   private List<ProductLine> productLines;

    private int quantity;
    private double total_price;

    private List<ProductLine> getItemLines() {
        return productLines;
    }

    public void setItemLines(List<ProductLine> productLines) {
        this.productLines = productLines;
    }

    public int getQuantity() {
        return getItemLines().size();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        double price = 0;
        for(int i = 0; i< productLines.size(); i++){
            price+= productLines.get(i).getTotal_price();
        }
        return price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
