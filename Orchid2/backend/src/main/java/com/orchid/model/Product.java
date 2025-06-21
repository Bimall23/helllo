package com.orchid.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double price;
    private String imageUrl;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}


// package com.orchid.model;

// import jakarta.persistence.*;
// import java.math.BigDecimal;

// @Entity
// @Table(name = "Products")
// public class Product {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer id;

//     @Column(nullable = false)
//     private String name;

//     @Column(nullable = false, precision = 10, scale = 2)
//     private BigDecimal price;

//     private String imageUrl;

//     // Getters and Setters
//     public Integer getId() { return id; }
//     public void setId(Integer id) { this.id = id; }

//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }

//     public BigDecimal getPrice() { return price; }
//     public void setPrice(BigDecimal price) { this.price = price; }

//     public String getImageUrl() { return imageUrl; }
//     public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
// }
