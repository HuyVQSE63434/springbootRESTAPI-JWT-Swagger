package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.RequestMethod;



@RestController
public class ProductController {

    public List<Product> PRODUCTLIST = Product.getProductListContant();

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return PRODUCTLIST;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product)
    {
        boolean isContaintID = PRODUCTLIST.stream().filter(x -> x.getId() == product.getId()).toArray().length > 0;
        if(isContaintID){
            return new ResponseEntity<>("Duplicate id",HttpStatus.BAD_REQUEST);
        }
        PRODUCTLIST.add(product);
        return new ResponseEntity<>(PRODUCTLIST,HttpStatus.OK);
    }
    
}
