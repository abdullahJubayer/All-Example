package com.example.desing_pattern.creational.factory;

import androidx.annotation.Nullable;

class NoSuchPaymentException extends NoSuchMethodException{
    @Nullable
    @Override
    public String getMessage() {
        return "No Payment Method Found!";
    }
}