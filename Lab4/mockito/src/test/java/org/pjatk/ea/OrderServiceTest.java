package org.pjatk.ea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OrderServiceTest {

    @Mock
    private InventoryService inventoryService;
    @Mock
    private PaymentService paymentService;
    @Mock
    private NotificationService notificationService;

    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(inventoryService, paymentService, notificationService);
    }

    @Test
    public void testPlaceOrderSuccess() {
        // Given
        String productId = "product123";
        double amount = 100.0;

        when(inventoryService.isProductAvailable(productId)).thenReturn(true);
        when(paymentService.processPayment(anyString(), eq(amount))).thenReturn(true);

        // When
        String result = orderService.placeOrder(productId, amount);

        // Then
        assertEquals("Order placed successfully", result);
        verify(notificationService).sendNotification(anyString());
    }

    @Test
    public void testPlaceOrderProductNotAvailable() {
        // Given
        String productId = "product123";
        double amount = 100.0;

        when(inventoryService.isProductAvailable(productId)).thenReturn(false);

        // When
        String result = orderService.placeOrder(productId, amount);

        // Then
        assertEquals("Product not available", result);
        verify(paymentService, never()).processPayment(anyString(), anyDouble());
        verify(notificationService, never()).sendNotification(anyString());
    }

    @Test
    public void testPlaceOrderPaymentFailed() {
        // Given
        String productId = "product123";
        double amount = 100.0;

        when(inventoryService.isProductAvailable(productId)).thenReturn(true);
        when(paymentService.processPayment(anyString(), eq(amount))).thenReturn(false);

        // When
        String result = orderService.placeOrder(productId, amount);

        // Then
        assertEquals("Payment failed", result);
        verify(notificationService, never()).sendNotification(anyString());
    }

    @Test
    public void testPlaceOrderPaymentThrowsException() {
        // Given
        String productId = "product123";
        double amount = 100.0;

        when(inventoryService.isProductAvailable(productId)).thenReturn(true);
        when(paymentService.processPayment(anyString(), eq(amount)))
                .thenThrow(new RuntimeException("Payment processing error"));

        // When
        String result = orderService.placeOrder(productId, amount);

        // Then
        assertEquals("Payment failed", result);
        verify(notificationService, never()).sendNotification(anyString());
    }

}