package aptika.example.laporpak.controller;


import aptika.example.laporpak.model.UserModel;
import aptika.example.laporpak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Lapor Pak Nizam API Java";
    }


    // get all list users
    @GetMapping("users")
    public List<UserModel> getAllUsers() {
        return userService.getAllUserData();
    }

    // get user by id
    @GetMapping("users/{userId}")
    public Optional<UserModel> getUserById(@PathVariable("userId") String userId) {
        return userService.getUserById(userId);
    }

    // creating user
    @PostMapping("users/create")
    public ResponseEntity<?> createUser(@RequestBody UserModel user) {
        try {
            UserModel createUser = userService.createUser(user);
            return ResponseEntity.ok(createUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("users/{userId}/update")
    // updating the users detail
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody UserModel updatedUser) {
        try {
            UserModel updatedUserData = userService.updateUser(userId, updatedUser);
            return ResponseEntity.ok(updatedUserData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user: " + e.getMessage());
        }
    }

    // delete user by id
    @DeleteMapping("users/{userId}/delete")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUserById(userId);
    }
}
