package com.example.crud_v2.service;

import com.example.crud_v2.dto.CustomerDto;
import com.example.crud_v2.entity.Customer;
import com.example.crud_v2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {
@Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }




    public void createUser(CustomerDto customerDto) {
        Customer customer = new Customer();
       customer.setName(customerDto.getName());
       customer.setEmail(customerDto.getEmail());

       customerRepository.save(customer);

    }

    public CustomerDto getCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
      customerDto.setName(customer.getName());
      customerDto.setEmail(customer.getEmail());
       customerDto.setCustomer_id(customer.getCustomer_id());
        return customerDto;
    }

    public List<CustomerDto> getAllUsers() {
        List<Customer> allCustomers = customerRepository.findAll();

        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : allCustomers) {
            customerDtos.add(getCustomerDto(customer));
        }
        return customerDtos;
    }

    public void updateCustomer(Long customerId, CustomerDto customerDto) throws Exception {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        // throw an exception if product does not exists
        if (!customerOptional.isPresent()) {
            throw new Exception("customer not present");
        }
        Customer customer = customerOptional.get();

      customer.setName(customerDto.getName());
      customer.setEmail(customerDto.getEmail());
        customerRepository.save(customer);
    }


    public void deleteCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if (!exists) {
            throw new IllegalStateException("customer with id" + customerId + "doesn't exists");

        }

        customerRepository.deleteById(customerId);
    }
    public Customer findCustomerById(Long customerId) throws Exception {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        // throw an exception if product does not exists
        if (!customerOptional.isPresent()) {
            throw new Exception("customer not present");
        }
      return customerOptional.get();
    }
public void saveCustomer(Customer customer){
        customerRepository.save(customer);
}

}
