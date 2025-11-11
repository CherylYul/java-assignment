package com.example.java_assignment.oop;

public class MomoPayment implements PaymentService {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using Momo service.");
        return true;
    }
}
