package com.example.desing_pattern.creational.builder;


    /*
    -------------Factory Pattern-------------
        The builder pattern used to construct complex objects step by step.
        It allows the creation of an object with a large number of optional
        and required parameters, often making the object construction process cleaner and more readable.
    ------------Factory Pattern--------------
    */

public class Main {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.RetrofitBuilder()
                .setClient("client")
                .setLogger("logger")
                .build();
    }
}
