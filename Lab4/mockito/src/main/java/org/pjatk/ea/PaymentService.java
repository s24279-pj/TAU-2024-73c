package org.pjatk.ea;

public interface PaymentService {
    boolean processPayment(String orderId, double amount);
}
