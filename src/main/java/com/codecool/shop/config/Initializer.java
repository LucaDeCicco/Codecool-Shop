package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();



        //setting up a new supplier
        //setting up a new supplier
        Supplier dior = new Supplier("Dior", "An internationally renowned brand since 1946, the French fashion house acclaimed for its elegance and timeless femininity.");
        supplierDataStore.add(dior);
        Supplier versace = new Supplier("Versace", "The Versace name was born as an audacious and unapologetic brand, fusing street style with high fashion to create bombastic, avant-garde designs.");
        supplierDataStore.add(versace);
        Supplier paccoRabanne = new Supplier("Pacco Rabanne", "Francisco Rabaneda Cuervo (born 18 February 1934), more commonly known under the pseudonym of Paco Rabanne, is a Spanish fashion designer who became known as an enfant terrible of the 1960s French fashion world.");
        supplierDataStore.add(paccoRabanne);
        Supplier jeanPaulGaultier = new Supplier("Jean Paul Gaultier", "Jean Paul Gaultier, (born April 24, 1952, Arcueil, France), French fashion designer whose iconoclastic collections in the late 20th and early 21st centuries celebrated androgyny, blended street styles with haute couture, and juxtaposed other seemingly contradictory cultural symbols.");
        supplierDataStore.add(jeanPaulGaultier);


        //setting up a new product category
        ProductCategory men = new ProductCategory("Men", "Perfume", "Perfumes can be defined as substances that emit and diffuse a pleasant and fragrant odor.");
        productCategoryDataStore.add(men);

        ProductCategory women = new ProductCategory("Women", "Perfume", "Perfumes can be defined as substances that emit and diffuse a pleasant and fragrant odor.");
        productCategoryDataStore.add(women);

        //setting up products and printing it
        productDataStore.add(new Product("Sauvage Dior", new BigDecimal("49.9"), "EUR", "Fantastic price.", men, dior));
        productDataStore.add(new Product("Pacco Rabanne Million", new BigDecimal("52"), "EUR", "Best price", men, paccoRabanne));
        productDataStore.add(new Product("Versace Eros", new BigDecimal("45"), "EUR", "Versace Eros is a fragrance for a strong, passionate man, who is master of himself.", men, versace));

        productDataStore.add(new Product("Million Female", new BigDecimal("53"), "EUR", "Best price", women, paccoRabanne));
        productDataStore.add(new Product("Pacco Rabanne Scandal", new BigDecimal("78"), "EUR", "Fantastic price.", women, jeanPaulGaultier));

    }
}
