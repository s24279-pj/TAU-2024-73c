package org.pjatk.ea;

public class OrderService {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    public OrderService(InventoryService inventoryService, PaymentService paymentService, NotificationService notificationService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    public String placeOrder(String productId, double amount) {
        if (!inventoryService.isProductAvailable(productId)) {
            return "Product not available";
        }

        String orderId = "order123"; // Just for testing purposes
        boolean paymentSuccessful;

        try {
            paymentSuccessful = paymentService.processPayment(orderId, amount);
        } catch (RuntimeException e) {
            return "Payment failed";
        }

        if (!paymentSuccessful) {
            return "Payment failed";
        }

        notificationService.sendNotification("Order placed successfully: " + orderId);
        return "Order placed successfully";
    }
}
