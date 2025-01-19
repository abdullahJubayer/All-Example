package com.example.desing_pattern.behavioral.observer;


import java.util.ArrayList;
import java.util.List;

/*
------------Observer-------------------
The Observer Design Pattern is a behavioral design pattern
that defines a one-to-many dependency between objects.
When one object (observable) changes state,
all its dependents (observers) are notified and updated automatically.
------------Observer-------------------
 */
public class Main {
    public static void main(String[] args) {

        DhakaStockExchange stockMarket = new DhakaStockExchange();
        StockObserver investor1 = new StockObserverImp();
        StockObserver investor2 = new StockObserverImp();
        stockMarket.addStockObserver(investor1);
        stockMarket.addStockObserver(investor2);

        stockMarket.setData("INFY", 1250.0);
        stockMarket.removeStockObserver(investor1);
        stockMarket.setData("WIPRO", 700.0); // On

    }
}

interface StockObserver{
    void update(String stockName, double stockPrice);
}

class StockObserverImp implements StockObserver{
    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("StockName : "+stockName +" StockPrice : "+stockPrice);
    }
}

interface StockMarket{
    void addStockObserver(StockObserver stockObserver);
    void removeStockObserver(StockObserver stockObserver);
    void notifyChanges();
}

class DhakaStockExchange implements StockMarket{
    private List<StockObserver> observers = new ArrayList<>();
    @Override
    public void addStockObserver(StockObserver stockObserver) {
        observers.add(stockObserver);
    }

    @Override
    public void removeStockObserver(StockObserver stockObserver) {
        observers.remove(stockObserver);
    }

    @Override
    public void notifyChanges() {
        for (StockObserver observer : observers){
            observer.update("ABC",200);
        }
    }

    public void setData(String stockName,double value){
        notifyChanges();
    }
}

