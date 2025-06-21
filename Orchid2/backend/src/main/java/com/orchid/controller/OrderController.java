package com.orchid.controller;

import com.orchid.model.Order;
import com.orchid.model.OrderItem;
import com.orchid.model.Product;
import com.orchid.model.User;
import com.orchid.repository.OrderRepository;
import com.orchid.repository.ProductRepository;
import com.orchid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Order placeOrder(@RequestBody OrderRequest orderRequest) {
        User user = userRepository.findById(orderRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();
        order.setUser(user);
        order.setShippingAddress(orderRequest.getShippingAddress());
        order.setBillingAddress(orderRequest.getBillingAddress());

        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderRequest.OrderItemDTO itemDTO : orderRequest.getItems()) {
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setPrice(itemDTO.getPrice());
            orderItems.add(orderItem);
        }
        order.setItems(orderItems);

        return orderRepository.save(order);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return orderRepository.findByUser(user);
    }

    // DTO class for request
    public static class OrderRequest {
        private Integer userId;
        private String shippingAddress;
        private String billingAddress;
        private List<OrderItemDTO> items;

        // getters and setters

        public Integer getUserId() { return userId; }
        public void setUserId(Integer userId) { this.userId = userId; }

        public String getShippingAddress() { return shippingAddress; }
        public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

        public String getBillingAddress() { return billingAddress; }
        public void setBillingAddress(String billingAddress) { this.billingAddress = billingAddress; }

        public List<OrderItemDTO> getItems() { return items; }
        public void setItems(List<OrderItemDTO> items) { this.items = items; }

        public static class OrderItemDTO {
            private Integer productId;
            private Integer quantity;
            private Double price;

            // getters and setters

            public Integer getProductId() { return productId; }
            public void setProductId(Integer productId) { this.productId = productId; }

            public Integer getQuantity() { return quantity; }
            public void setQuantity(Integer quantity) { this.quantity = quantity; }

            public Double getPrice() { return price; }
            public void setPrice(Double price) { this.price = price; }
        }
    }
}
