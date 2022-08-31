package com.codecool.shop.controller.api;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Item;
import com.codecool.shop.model.Product;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;


@WebServlet(name = "AddToCartServlet", urlPatterns = {"/api/addToCart"}, loadOnStartup = 1)
public class AddToCartApi extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductDaoMem productDaoMem = ProductDaoMem.getInstance();
        CartDaoMem cartDataStore = CartDaoMem.getInstance();

        List<Product> allProducts = productDaoMem.getAll();

        StringBuffer buffer = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String bufferID = buffer.substring(7, 8);
        String bufferQuantity = buffer.substring(21, 22);

        for (Product product : allProducts) {
            if (product.getId()==Integer.parseInt(bufferID)){
                Item item = new Item(product, Integer.parseInt(bufferQuantity));
                if (cartDataStore.getAll().contains(item)){
                    cartDataStore.find(item.getProductId()).setQuantity(cartDataStore.find(item.getId()).getQuantity()+1);
                }
                else{
                    cartDataStore.add(item);
                }
            }
        }



        response.setContentType("application/json");
        String dataToRespond = "{\"id\":15,\"result\":\"SUCCESS\"}";
        PrintWriter out = response.getWriter();
        out.println(dataToRespond);
    }
}