package com.orchid.controller;

import com.orchid.model.User;
import com.orchid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Username already exists!";
        }
        userRepository.save(user);
        return "User registered successfully.";
    }

    @PostMapping("/login")
    public User login(@RequestBody User credentials) {
        User user = userRepository.findByUsername(credentials.getUsername());
        if (user != null && user.getPassword().equals(credentials.getPassword())) {
            return user; // simple return, no token
        }
        return null; // frontend should handle null as invalid login
    }
}

// package com.orchid.controller;

// import com.orchid.model.User;
// import com.orchid.repository.UserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/users")
// @CrossOrigin(origins = "*")
// public class UserController {

//     @Autowired
//     private UserRepository userRepository;

//     // User login - basic auth check
//     @PostMapping("/login")
//     public User login(@RequestBody User user) {
//         User foundUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//         if (foundUser != null) {
//             return foundUser;
//         } else {
//             throw new RuntimeException("Invalid username or password");
//         }
//     }

//     // User registration
//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         User existingUser = userRepository.findByUsername(user.getUsername());
//         if (existingUser != null) {
//             throw new RuntimeException("Username already exists");
//         }
//         return userRepository.save(user);
//     }
// }
// `
