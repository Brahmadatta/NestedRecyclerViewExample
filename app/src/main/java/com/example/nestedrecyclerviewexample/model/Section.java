package com.example.nestedrecyclerviewexample.model;

import java.util.List;

public class Section {

    public String product_name;

    public List<Product> product_items;

    public Section(String product_name, List<Product> product_items) {
        this.product_name = product_name;
        this.product_items = product_items;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public List<Product> getProduct_items() {
        return product_items;
    }

    public void setProduct_items(List<Product> product_items) {
        this.product_items = product_items;
    }

    @Override
    public String toString() {
        return "Section{" +
                "product_name='" + product_name + '\'' +
                ", product_items=" + product_items +
                '}';
    }
}
