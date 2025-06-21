package com.orchid.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderItems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    private Double price;

    // Getters and setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}


// package com.orchid.model;

// import jakarta.persistence.*;
// import java.math.BigDecimal;

// @Entity
// @Table(name = "OrderItems")
// public class OrderItem {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer id;

//     @ManyToOne
//     @JoinColumn(name = "order_id")
//     private Order order;

//     @ManyToOne
//     @JoinColumn(name = "product_id")
//     private Product product;

//     private Integer quantity;

//     @Column(precision = 10, scale = 2)
//     private BigDecimal price;

//     // Getters and Setters
//     public Integer getId() { return id; }
//     public void setId(Integer id) { this.id = id; }

//     public Order getOrder() { return order; }
//     public void setOrder(Order order) { this.order = order; }

//     public Product getProduct() { return product; }
//     public void setProduct(Product product) { this.product = product; }

//     public Integer getQuantity() { return quantity; }
//     public void setQuantity(Integer quantity) { this.quantity = quantity; }

//     public BigDecimal getPrice() { return price; }
//     public void setPrice(BigDecimal price) { this.price = price; }
// }

