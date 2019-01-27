package com.codecool;

public class BookProduct extends Product{

    private int numOfPages;

    public BookProduct(String name, int price, int numOfPages){
        super(name, price);
        this.numOfPages = numOfPages;
    }

    public int getNumOfPages(){
        return  this.numOfPages;
    }

    public String toString(){
        return super.toString() + " " + String.valueOf(this.getNumOfPages());
    }
}
