package com.example.crud_v2.service;

import com.example.crud_v2.dto.AddToProductLineDto;
import com.example.crud_v2.dto.ViewProductLine;
import com.example.crud_v2.entity.Product;
import com.example.crud_v2.entity.ProductLine;
import com.example.crud_v2.repository.ProductLineRepository;
import com.example.crud_v2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductLineService {


@Autowired
private final ProductRepository productRepository;
private final ProductLineRepository productLineRepository;
private final ProductService productService;
@Autowired
    public ProductLineService(ProductRepository productRepository, ProductLineRepository productLineRepository, ProductService productService) {
    this.productRepository = productRepository;

    this.productLineRepository = productLineRepository;
    this.productService = productService;
}
    public ViewProductLine getItemDto(ProductLine productLine) {
        ViewProductLine viewProductLine =new ViewProductLine();
        viewProductLine.setId(productLine.getId());
        viewProductLine.setQuantity(productLine.getQuantity());
       viewProductLine.setProduct_id(productLine.getItem().getItem_id());
       viewProductLine.setTotal_price(productLine.getTotal_price());

        return viewProductLine;
    }
    public void addToItemLine(AddToProductLineDto addToProductLineDto) throws Exception {
    Product product = productService.findItemById(addToProductLineDto.getProduct_id());
        ProductLine productLine =new ProductLine();
        productLine.setItem(product);
        productLine.setQuantity(addToProductLineDto.getQuantity());
        productLineRepository.save(productLine);
    }
    public List<ViewProductLine> getAllItemLines() {
        List<ProductLine> allProductLines = productLineRepository.findAll();

        List<ViewProductLine> viewProductLinesDtos = new ArrayList<>();
        for (ProductLine productLine : allProductLines) {
            viewProductLinesDtos.add(getItemDto(productLine));
        }
        return viewProductLinesDtos;
    }
    public void deleteProductLine(Long productLineId) {
        boolean exists = productLineRepository.existsById(productLineId);
        if (!exists) {
            throw new IllegalStateException("productLine with id" + productLineId + "doesn't exists");

        }

        productLineRepository.deleteById(productLineId);
    }
    public void updateProductLine(Long productLineId, AddToProductLineDto addToProductLineDto) throws Exception {
        Optional<ProductLine> itemLineOptional = productLineRepository.findById(productLineId);
        // throw an exception if product does not exists
        if (!itemLineOptional.isPresent()) {
            throw new Exception("productLine not present");
        }
        ProductLine productLine = itemLineOptional.get();
        Product product = productService.findItemById(addToProductLineDto.getProduct_id());
        productLine.setItem(product);
        productLine.setQuantity(addToProductLineDto.getQuantity());
        productLineRepository.save(productLine);
    }
    public List<ProductLine> getAllItems(){
    return productLineRepository.findAll();
    }

}
