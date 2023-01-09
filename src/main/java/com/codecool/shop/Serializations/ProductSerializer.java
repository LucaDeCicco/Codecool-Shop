package com.codecool.shop.Serializations;

import com.codecool.shop.model.Product;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ProductSerializer implements JsonSerializer<Product> {

    @Override
    public JsonElement serialize(Product product, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", product.getId());
        jsonObject.addProperty("name", product.getName());
        jsonObject.addProperty("description", product.getDescription());
        jsonObject.addProperty("defaultPrice", product.getDefaultPrice());
        jsonObject.addProperty("defaultCurrency", product.getDefaultCurrency().toString());
        jsonObject.addProperty("productCategory", product.getProductCategory().toString());
        jsonObject.addProperty("supplier", product.getSupplier().toString());

        return jsonObject;
    }
}
