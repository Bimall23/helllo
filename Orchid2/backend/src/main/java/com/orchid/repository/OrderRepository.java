package com.orchid.repository;

import com.orchid.model.Order;
import com.orchid.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUser(User user);
}


// package com.orchid.repository;

// import com.orchid.model.Order;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.List;

// @Repository
// public interface OrderRepository extends JpaRepository<Order, Integer> {
//     List<Order> findByUserId(int userId);
// }
