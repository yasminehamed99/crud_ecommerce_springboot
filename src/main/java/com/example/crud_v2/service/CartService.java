package com.example.crud_v2.service;

import com.example.crud_v2.dto.AddToCartDto;
import com.example.crud_v2.dto.CartCustomerDto;
import com.example.crud_v2.entity.Cart;
import com.example.crud_v2.entity.Customer;
import com.example.crud_v2.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {
   private final ProductLineService productLineService;
   private final CustomerService customerService;
   private final CartRepository cartRepository;

   public CartService(ProductLineService productLineService, CustomerService customerService, CartRepository cartRepository) {
      this.productLineService = productLineService;
      this.customerService = customerService;
      this.cartRepository = cartRepository;
   }
      public void addToCart(AddToCartDto addToCartDto) throws Exception {
       Cart cart=new Cart();
      cart.setItemLines(productLineService.getAllItems());
         cartRepository.save(cart);
      Customer c=customerService.findCustomerById(addToCartDto.getCustomer_id());

      c.setCart(cart);
      customerService.saveCustomer(c);
   }
   public CartCustomerDto getCartInfo(Long customId) throws Exception {
       Cart cart=customerService.findCustomerById(customId).getCart();
      CartCustomerDto customerDto=new CartCustomerDto();
     CartCustomerDto.setViewItemLines(productLineService.getAllItemLines());
     customerDto.setQuantity(cart.getQuantity());
     customerDto.setTotal_price(cart.getTotal_price());

      return customerDto;
   }
    public void deleteCart(Long cartId) {
        boolean exists = cartRepository.existsById(cartId);
        if (!exists) {
            throw new IllegalStateException("cart with id" + cartId + "doesn't exists");

        }

        cartRepository.deleteById(cartId);
    }
}
