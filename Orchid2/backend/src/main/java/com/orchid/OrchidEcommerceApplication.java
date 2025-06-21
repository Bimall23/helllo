package com.orchid;

// import java.sql.Driver;
// import java.sql.DriverManager;
// import java.util.Enumeration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.orchid.repository")
//@EntityScan("com.orchid.model")
//@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = { "com.test.demo.repo.db1" })
@EnableJpaRepositories(basePackages = {"com.orchid.repository"}) 
@EntityScan(basePackages = {"com.orchid.model"}) 
public class OrchidEcommerceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrchidEcommerceApplication.class, args);
        // System.out.println("Drivers:");
        // Enumeration<Driver> drivers = DriverManager.getDrivers();
        // while (drivers.hasMoreElements()) {
        //     System.out.println(" -> " + drivers.nextElement().getClass().getName());
        // }

    }
}
