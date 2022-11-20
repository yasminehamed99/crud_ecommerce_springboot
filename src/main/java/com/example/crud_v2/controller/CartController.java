package com.example.crud_v2.controller;

import com.example.crud_v2.dto.AddToCartDto;
import com.example.crud_v2.dto.CartCustomerDto;
import com.example.crud_v2.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping(path = "/addToCart")
    public void addToCart(@RequestBody AddToCartDto addToCartDto) throws Exception {
        cartService.addToCart(addToCartDto);
    }
    @GetMapping(path = "/getCart/{customer_id}")
    public CartCustomerDto getCart(@PathVariable("customer_id")Long customerId) throws Exception {
        return cartService.getCartInfo(customerId);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteProductLine(@PathVariable("id")Long cartId) {
        cartService.deleteCart(cartId);
    }
}
