package com.ivandjoh.springh2.controller;

import com.ivandjoh.springh2.dto.ApiMessages;
import com.ivandjoh.springh2.dto.ApiResponse;
import com.ivandjoh.springh2.model.User;
import com.ivandjoh.springh2.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<User>>> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {

        List<User> users = userService.getAllUsers(page, size);

        ApiResponse<List<User>> response = ApiResponse.success(users, ApiMessages.RESOURCES_FETCHED);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable int id) {

        User user = userService.getUserById(id);
        ApiResponse<User> response = ApiResponse.success(user, ApiMessages.RESOURCE_FETCHED);

        return ResponseEntity.ok(response);
    }
}