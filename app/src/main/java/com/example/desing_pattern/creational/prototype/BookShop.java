package com.example.desing_pattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Prototype
{
    private String name;
    private List<String> books;

    public BookShop(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    private BookShop(String name,List<String> books){
        this.name = name;
        this.books = books;
    }

    public void setName(String name) {
        this.name = name;
    }

    //suppose this method is so expensive
    public void loadData(){
        for (int i=0; i < 5;i++){
            books.add(""+i);
        }
    }

    public void sellBook(){
        books.remove(books.size()-1);
    }

    public List<String> getBooks() {
        return books;
    }

    @Override
    public BookShop shadowClone() {
        return new BookShop(this.name,this.books);
    }

    @Override
    public BookShop deepClone() {
        BookShop shop= new BookShop(this.name);
        shop.books.addAll(this.books);
        return shop;
    }
}
