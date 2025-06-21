package com.orchid.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Order() {}
    // Getters and setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

    public String getBillingAddress() { return billingAddress; }
    public void setBillingAddress(String billingAddress) { this.billingAddress = billingAddress; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) {
        this.items = items;
        if(items != null) {
            for(OrderItem item : items) {
                item.setOrder(this);
            }
        }
    }
}


// package com.orchid.model;

// import jakarta.persistence.*;
// import java.util.Date;
// import java.util.List;

// @Entity
// @Table(name = "Orders")
// public class Order {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer id;

//     @ManyToOne
//     @JoinColumn(name = "user_id")
//     private User user;

//     private String shippingAddress;
//     private String billingAddress;

//     @Temporal(TemporalType.TIMESTAMP)
//     private Date createdAt;

//     @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//     private List<OrderItem> orderItems;

//     // Getters and Setters
//     public Integer getId() { return id; }
//     public void setId(Integer id) { this.id = id; }

//     public User getUser() { return user; }
//     public void setUser(User user) { this.user = user; }

//     public String getShippingAddress() { return shippingAddress; }
//     public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

//     public String getBillingAddress() { return billingAddress; }
//     public void setBillingAddress(String billingAddress) { this.billingAddress = billingAddress; }

//     public Date getCreatedAt() { return createdAt; }
//     public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

//     public List<OrderItem> getOrderItems() { return orderItems; }
//     public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }
// }
