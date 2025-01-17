package com.example.desing_pattern.creational.builder;

public class Main {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.RetrofitBuilder()
                .setClient("client")
                .setLogger("logger")
                .build();
    }
}
