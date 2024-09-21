package com.ivandjoh.springh2.service.user;

import com.ivandjoh.springh2.dto.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    ResponseEntity<ApiResponse<List<Map<String, Object>>>> getUsers(int page, int size);
    ResponseEntity<ApiResponse<Map<String, Object>>> getUserById(int id);
}