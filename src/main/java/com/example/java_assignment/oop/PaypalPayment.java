package com.example.java_assignment.oop;

public class PaypalPayment implements PaymentService {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using Paypal.");
        return true;
    }
}
