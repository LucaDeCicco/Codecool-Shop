package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public List<Product> filterByBrand(String criteria) {
        filteredList = new ArrayList<>();
        for (Product product : allProducts) {
            if (Objects.equals(product.getSupplier().getName(), criteria)){
                filteredList.add(product);
            }
        }
        return filteredList;
    }

    public List<Product> orderByPrice(String criteria) {
        filteredList = new ArrayList<>();

        if (Objects.equals(criteria, "Low to High")){
            List<Product> sortedList = allProducts.stream()
                    .sorted(Comparator.comparing(Product::getDefaultPrice))
                    .collect(Collectors.toList());
            filteredList = sortedList;
        }
        else {
            List<Product> sortedList = allProducts.stream()
                    .sorted(Comparator.comparing(Product::getDefaultPrice).reversed())
                    .collect(Collectors.toList());
            filteredList = sortedList;
        }

        return filteredList;
    }
}
