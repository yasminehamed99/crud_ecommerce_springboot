package com.example.crud_v2.service;

import com.example.crud_v2.dto.ProductDto;
import com.example.crud_v2.entity.Product;
import com.example.crud_v2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);

    }

    public ProductDto getItemDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setItem_id(product.getItem_id());
        return productDto;
    }

    public List<ProductDto> getAllItems() {
        List<Product> allProducts = productRepository.findAll();

        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : allProducts) {
            productDtos.add(getItemDto(product));
        }
        return productDtos;
    }

    public void updateItem(Long itemId, ProductDto productDto) throws Exception {
        Optional<Product> itemOptional = productRepository.findById(itemId);
        // throw an exception if product does not exists
        if (!itemOptional.isPresent()) {
            throw new Exception("product not present");
        }
        Product product = itemOptional.get();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }


    public void deleteItem(Long itemId) {
        boolean exists = productRepository.existsById(itemId);
        if (!exists) {
            throw new IllegalStateException("item with id" + itemId + "doesn't exists");

        }

        productRepository.deleteById(itemId);
    }

    public Product findItemById(Long product_id) throws Exception {
        Optional<Product>optionalItem= productRepository.findById(product_id);
        if (!optionalItem.isPresent()) {
            throw new Exception("product not present");
        }

        return optionalItem.get();

    }

}
