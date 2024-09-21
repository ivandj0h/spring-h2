package com.ivandjoh.springh2.service.user;

import com.ivandjoh.springh2.dto.ApiResponse;
import com.ivandjoh.springh2.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getAllUsers(int page, int size);
    User getUserById(int id);
}