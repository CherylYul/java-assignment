package com.example.java_assignment.oop;

public class CreditCardPayment implements PaymentService {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
        return true;
    }
}
