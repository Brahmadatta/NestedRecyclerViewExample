package com.example.nestedrecyclerviewexample.model;

public class Product {

    public String product_name;

    public int product_image;


    public Product(String product_name, int product_image) {
        this.product_name = product_name;
        this.product_image = product_image;
    }


    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_image() {
        return product_image;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_name='" + product_name + '\'' +
                ", product_image=" + product_image +
                '}';
    }
}
