package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FilterMem {

    private static FilterMem instance = null;

    private List<Product> filteredList = new ArrayList<>();

    private List<Product> allProducts = ProductDaoMem.getInstance().getAll();

    public FilterMem() {
    }

    public static FilterMem getInstance() {
        if (instance == null) {
            instance = new FilterMem();
        }
        return instance;
    }

    public List<Product> getFilteredList() {
        return filteredList;
    }

    public void setFilteredList(List<Product> filteredList) {
        this.filteredList = filteredList;
    }

    public List<Product> filterByCriteria(String criteria){
        filteredList = new ArrayList<>();
        for (Product product : allProducts) {
            if (Objects.equals(product.getProductCategory().getName(), criteria)){
                filteredList.add(product);
            }
        }
        return filteredList;
    }
}
