package com.codecool.shop.dao;

import com.codecool.shop.model.Item;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.List;

public interface CartDao {
    void add(Item item);

    Item find(int id);

    void remove(int id);

    List<Item> getAll();

}
