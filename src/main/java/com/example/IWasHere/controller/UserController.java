package com.example.IWasHere.controller;

import com.example.IWasHere.dto.UserDTO;
import com.example.IWasHere.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@AllArgsConstructor
@CrossOrigin("*")
public class UserController {

    private UserService userService;

    @PostMapping("register")
    public void createUser(@RequestBody UserDTO user) {
        userService.createUser(user);
    }

}
