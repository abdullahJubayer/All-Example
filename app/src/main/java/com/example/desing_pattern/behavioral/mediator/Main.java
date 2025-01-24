package com.example.desing_pattern.behavioral.mediator;


import java.util.ArrayList;
import java.util.List;

/*
------------Mediator-------------------
The Mediator Design Pattern is used to reduce
coupling between object by introducing a mediator
object that handles communication between them.
Instead of communicating directly with each other,
hey communicate through the mediator.
------------Mediator-------------------
 */
public class Main {
    public static void main(String[] args) {
        Auction auction = new CricketAuction();

        Bidder bidder = new CrickBidder("A",auction);
        Bidder bidder2 = new CrickBidder("B",auction);
        Bidder bidder3 = new CrickBidder("C",auction);

        bidder.bid(500);
        bidder2.bid(600);
    }
}

interface Auction{
    void register(Bidder bidder);
    void bid(double amount);
}

class CricketAuction implements Auction{
    private List<Bidder> bidderList = new ArrayList<>();
    @Override
    public void register(Bidder bidder) {
        bidderList.add(bidder);
    }

    @Override
    public void bid(double amount) {
        for (Bidder b : bidderList){
            b.receiveMessage(b.getName()+" placed a bid for $"+amount);
        }
    }
}

interface Bidder{
    String getName();
    void receiveMessage(String message);
    void bid(double amount);
}

class CrickBidder implements Bidder{
    private String name;
    private Auction auction;

    public CrickBidder(String name,Auction auction){
        this.name = name;
        this.auction = auction;
        auction.register(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void bid(double amount) {
        auction.bid(amount);
    }
}