package com.example.demo.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable{
    

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Product() {
    }


    public Product(Long id, String name, Long price, String brand, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.color = color;
    }

    private Long id;
    private String name;
    private Long price;
    private String brand;
    private String color;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static List<Product> getProductListContant() {
        List<Product> productsList = new ArrayList<Product>();
        for (int i = 1; i < 11; ++i){
            Product product = new Product(Long.valueOf(i), "product "+i, Long.valueOf(i*1000), "Channel", "red");
            productsList.add(product);
        }
        return productsList;
    }
}
