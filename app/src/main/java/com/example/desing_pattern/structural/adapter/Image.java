package com.example.desing_pattern.structural.adapter;

public class Image {
    public void applyFilter(Filter filter){
        filter.apply();
    }
}

interface Filter{
    void apply();
}

class BlackAndWhite implements Filter{
    @Override
    public void apply() {
        System.out.println("Implements Black & White");
    }
}

class Blur implements Filter{
    private BlurFilter filter;

    public Blur(BlurFilter filter){
        this.filter=filter;
    }

    @Override
    public void apply() {
        filter.applyBlur();
    }
}