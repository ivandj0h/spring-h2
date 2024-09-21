package com.ivandjoh.springh2.controller;

import com.ivandjoh.springh2.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping({ "/", "/api", "/api/v1" })
public class HomeController {

  // Method untuk root URL
  @GetMapping
  public ResponseEntity<Map<String, Object>> home() {
    Map<String, Object> response = new LinkedHashMap<>();
    response.put("status", 200);
    response.put("message", "Welcome to SpringH2");
    response.put("data", Collections.emptyList());

    return ResponseEntity.ok(response);
  }

  // Method untuk URL /success
  @GetMapping("/success")
  public ResponseEntity<ApiResponse<List<String>>> successResponse() {
    List<String> data = List.of("Item1", "Item2");
    return ResponseEntity.ok(ApiResponse.success(data));
  }

  // Method untuk URL /my-home
  @GetMapping("/dashboard")
  public String getDashboard() {
    return "Welcome to My Home...";
  }

  // Method untuk URL /not-found
  @GetMapping("/not-found")
  public ResponseEntity<ApiResponse<Void>> notFoundResponse() {
    return ResponseEntity.status(404).body(ApiResponse.notFound("This resource was not found"));
  }

  // Method untuk URL /server-error
  @GetMapping("/server-error")
  public ResponseEntity<ApiResponse<Void>> serverErrorResponse() {
    return ResponseEntity.status(500).body(ApiResponse.internalServerError("Something went wrong"));
  }

  // Method untuk URL /no-content
  @GetMapping("/no-content")
  public ResponseEntity<ApiResponse<Void>> noContentResponse() {
    return ResponseEntity.status(204).body(ApiResponse.noContent());
  }
}