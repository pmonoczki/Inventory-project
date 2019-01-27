package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class StoreManager {

    private StoreCapable sc;

    public void addStorage(StoreCapable storage){
        this.sc = storage;
    }

    public int getTotalPrice(){

        int sum = 0;
        for (Product p : sc.getAllProducts()){
            sum += p.getPrice();
        }

        return sum;
    }

    public void addCDProduct(String name, int price, int tracks){
        sc.storeCDProduct(name, price, tracks);
    }

    public void addBookProduct(String name, int price, int pages){
        sc.storeBookProduct(name, price, pages);
    }

    public List<String> listProducts(){
        List<String> l = new ArrayList<String>();
        for(Product p : sc.getAllProducts()){
            l.add(p.toString());
        }
        return l;


    }


}
