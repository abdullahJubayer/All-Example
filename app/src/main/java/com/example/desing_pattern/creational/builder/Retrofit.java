package com.example.desing_pattern.creational.builder;

public class Retrofit{
    private String client;
    private String logger;

    private Retrofit(RetrofitBuilder builder){
        this.client = builder.client;
        this.logger = builder.logger;
    }

    static class RetrofitBuilder{
        private String client;
        public String logger;

        public RetrofitBuilder setClient(String client) {
            this.client = client;
            return this;
        }

        public RetrofitBuilder setLogger(String logger) {
            this.logger = logger;
            return this;
        }

        public Retrofit build(){
            return new Retrofit(this);
        }
    }
}
