package com.codecool;

import java.util.List;

public interface StoreCapable {

    List<Product> getAllProducts();

    void storeCDProduct(String name, int price, int tracks);

    void storeBookProduct(String name, int price, int pages);
}
