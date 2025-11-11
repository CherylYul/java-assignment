package com.example.java_assignment.oop;

public class CheckoutService {
    private final PaymentService paymentService;

    public CheckoutService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean checkout(double amount) {
        return paymentService.pay(amount);
    }
}
