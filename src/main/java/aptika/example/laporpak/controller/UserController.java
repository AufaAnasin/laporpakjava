package aptika.example.laporpak.controller;


import aptika.example.laporpak.model.UserModel;
import aptika.example.laporpak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Lapor Pak Nizam API Java";
    }

    @GetMapping("users")
    public List<UserModel> getAllUsers() {
        return userService.getAllUserData();
    }
}
