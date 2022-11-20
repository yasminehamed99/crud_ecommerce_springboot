package com.example.crud_v2.controller;

import com.example.crud_v2.dto.AddToProductLineDto;
import com.example.crud_v2.dto.ViewProductLine;
import com.example.crud_v2.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/iteml")
public class ProductLineController {
    @Autowired
    private ProductLineService productLineService;
    @PostMapping
    public void addToItemLine(@RequestBody AddToProductLineDto itemLineDto) throws Exception {
        productLineService.addToItemLine(itemLineDto);
    }
    @GetMapping
    public List<ViewProductLine> getALlItemLines(){
        return productLineService.getAllItemLines();
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deleteProductLine(@PathVariable("id")Long productLineId) {
        productLineService.deleteProductLine(productLineId);
    }
    @PutMapping(path = "/update/{id}")
    public void updateProductLine(@PathVariable("id")Long productLineId,
                           @RequestBody AddToProductLineDto addToProductLineDto) throws Exception {
        productLineService.updateProductLine(productLineId, addToProductLineDto);

    }

}
