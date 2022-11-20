package com.example.crud_v2.repository;

import com.example.crud_v2.entity.Cart;
import com.example.crud_v2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
