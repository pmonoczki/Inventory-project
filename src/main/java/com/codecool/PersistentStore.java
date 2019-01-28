package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class PersistentStore extends Store{

    private List<Product> productList;

    private final String CD_TYPE = "CD";

    private final String BOOK_TYPE = "Book";

    public PersistentStore(){
        this.productList = new ArrayList<Product>();
    }

    public List<Product> getAllProducts() {
        return loadProducts();
    }

    public void storeCDProduct(String name, int price, int tracks) {
        store(createProduct(CD_TYPE,name,price,tracks));
    }

    public void storeBookProduct(String name, int price, int pages) {
        store(createProduct(BOOK_TYPE,name, price, pages));
    }

    public void storeProduct(Product product){
        this.productList.add(product);
    }
}
