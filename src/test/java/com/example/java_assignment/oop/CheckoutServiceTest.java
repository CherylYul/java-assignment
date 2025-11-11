package com.example.java_assignment.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutServiceTest {

    @Test
    void testCreditCardPayment() {
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        CheckoutService checkoutService = new CheckoutService(creditCardPayment);
        assertTrue(checkoutService.checkout(500));
    }

    @Test
    void testPaypalPayment() {
        PaypalPayment paypalPayment = new PaypalPayment();
        CheckoutService checkoutService = new CheckoutService(paypalPayment);
        assertTrue(checkoutService.checkout(200));
    }

    @Test
    void testAddNewPaymentType() {
        MomoPayment momoPayment = new MomoPayment();
        CheckoutService checkoutService = new CheckoutService(momoPayment);
        assertTrue(checkoutService.checkout(300));
    }
}
