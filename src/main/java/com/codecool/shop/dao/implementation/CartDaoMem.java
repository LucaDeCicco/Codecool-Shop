package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Item;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartDaoMem implements CartDao {

    private List<Item> data = new ArrayList<>();


    private static CartDaoMem instance = null;

    public CartDaoMem() {
    }

    public double calculateTotal(){
        double total = 0;
        for (Item item : data) {
            total += item.getProduct().getPriceValue()*item.getQuantity();
        }
        return total;
    }

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }


    @Override
    public void add(Item item) {
        boolean addedItem = false;
        for (Item prod : data) {
            if (prod.getProductId() == item.getProductId()){
                prod.setQuantity(prod.getQuantity()+1);
                addedItem = true;
            }
        }
        if (!addedItem){
            item.setId(data.size() + 1);
            data.add(item);
        }
    }

    public void deleteFromCart(Item item){
        for (Item prod : data) {
            if (prod.getProductId() == item.getProductId()){
                prod.setQuantity(prod.getQuantity()-1);
            }
            if (prod.getQuantity()==0){
                data.remove(item);
            }
        }

    }

    @Override
    public Item find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Item> getAll() {
        return data;
    }
}
