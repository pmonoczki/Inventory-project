package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class StoreManager {

    private StoreCapable sc;

    public void addStorage(StoreCapable storage){
        this.sc = storage;
    }

    public int getTotalPrice() throws NoStorageException {

        checkRaise();
        int sum = 0;
        for (Product p : sc.getAllProducts()){
            sum += p.getPrice();
        }

        return sum;
    }

    public void addCDProduct(String name, int price, int tracks) throws NoStorageException {

        checkRaise();
        sc.storeCDProduct(name, price, tracks);
    }

    public void addBookProduct(String name, int price, int pages) throws NoStorageException {

        checkRaise();
        sc.storeBookProduct(name, price, pages);
    }

    public String listProducts() throws NoStorageException {
        checkRaise();
        StringBuilder sb = new StringBuilder();
        for(Product p : sc.getAllProducts()){
            sb.append(p.toString());
        }
        return sb.toString();


    }


    private void checkRaise() throws NoStorageException {
        if (this.sc == null){
            throw new NoStorageException("No storage has been added");
        }
    }


}
