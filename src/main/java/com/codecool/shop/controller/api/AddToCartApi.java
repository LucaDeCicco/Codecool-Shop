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
        List<Item> cart = cartDataStore.getAll();

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

        String bufferID = buffer.toString().split("\"")[3];
        String bufferQuantity = buffer.toString().split("\"")[6].split(":")[1].split("}")[0];
        boolean added = false;
        for (Product product : allProducts) {
            if (product.getId()==Integer.parseInt(bufferID)){
                if (cart.size()>0){
                    for (Item item : cart) {
                        if (item.getProductId()== product.getId()){
                            added = true;
                            item.setQuantity(item.getQuantity()+1);
                            System.out.println("e ok");
                        }
                        else {
                            System.out.println("nu e ok");
                        }
                    }
                }

                if (!added){
                    Item item = new Item(product, Integer.parseInt(bufferQuantity));
                    cartDataStore.add(item);
                }
            }
        }

        System.out.println("futu-i mama ");
        System.out.println(cartDataStore.getAll());

        log(String.valueOf(cart));
        response.setContentType("application/json");
        String dataToRespond = "{\"id\":15,\"result\":\"SUCCESS\"}";
        PrintWriter out = response.getWriter();
        out.println(dataToRespond);
    }
}