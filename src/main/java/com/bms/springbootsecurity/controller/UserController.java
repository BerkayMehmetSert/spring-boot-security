package com.bms.springbootsecurity.controller;

import com.bms.springbootsecurity.dto.UserDto;
import com.bms.springbootsecurity.request.CreateUserRequest;
import com.bms.springbootsecurity.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @PostMapping("/get")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Get User");
    }
}
