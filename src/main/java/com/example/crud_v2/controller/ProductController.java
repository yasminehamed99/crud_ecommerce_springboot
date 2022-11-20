package com.example.crud_v2.controller;

import com.example.crud_v2.dto.ProductDto;
import com.example.crud_v2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/item")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
//    @PostMapping
//    public void addNewItem(@RequestBody Product item){
//    itemService.addNewItem(item);
//    }

    @PostMapping
    public void createItem(@RequestBody ProductDto productDto) {

        productService.createProduct(productDto);

    }
    @GetMapping
    public List<ProductDto> getALlItems(){
        return productService.getAllItems();
    }
    @DeleteMapping(path = "/delete/{item_id}")
    public void deleteItem(@PathVariable("item_id")Long itemId) {
        productService.deleteItem(itemId);
    }
    @PutMapping(path = "/update/{item_id}")
    public void updateItem(@PathVariable("item_id")Long itemId,
                           @RequestBody ProductDto productDto) throws Exception {
        productService.updateItem(itemId, productDto);

    }
}
