package com.example.crud_v2.controller;

import com.example.crud_v2.dto.AddToCartDto;
import com.example.crud_v2.dto.CartCustomerDto;
import com.example.crud_v2.dto.CustomerDto;
import com.example.crud_v2.service.CartService;
import com.example.crud_v2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/customer")
public class CustomerController {
    private final CustomerService customerService;

@Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

}


    @PostMapping
    public void createCustomer(@RequestBody CustomerDto customerDto) {

        customerService.createUser(customerDto);

    }
    @GetMapping
    public List<CustomerDto> getALlCustomers(){
        return customerService.getAllUsers();
    }
    @DeleteMapping(path = "/delete/{customer_id}")
    public void deleteItem(@PathVariable("customer_id")Long customerId) {
        customerService.deleteCustomer(customerId);
    }
    @PutMapping(path = "/update/{customer_id}")
    public void updateItem(@PathVariable("customer_id")Long customerId,
                           @RequestBody CustomerDto customerDto) throws Exception {
       customerService.updateCustomer(customerId,customerDto);

    }


}
