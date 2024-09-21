package com.ivandjoh.springh2.service.user;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserService {
    ResponseEntity<List<Map<String, Object>>> getUsers(int page, int size);
}