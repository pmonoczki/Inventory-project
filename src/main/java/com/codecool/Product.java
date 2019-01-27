package com.codecool;

public abstract class Product {

    private String name;

    private int price;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }

    public String toString(){
        return this.getName() + " " +  String.valueOf(this.getPrice());
    }

}
