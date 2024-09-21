package com.ivandjoh.springh2.service.user;

import com.ivandjoh.springh2.dto.ApiResponse;
import com.ivandjoh.springh2.utils.PaginationUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    // Inject URL from application.properties
    @Value("${jsonplaceholder.url}")
    private String jsonPlaceholderUrl;

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<ApiResponse<List<Map<String, Object>>>> getUsers(int page, int size) {
        String url = jsonPlaceholderUrl + "/users";
        ResponseEntity<Map[]> response = restTemplate.getForEntity(url, Map[].class);

        // Pagination logic using helper method
        List<Map<String, Object>> paginatedUsers = PaginationUtils.paginate(response.getBody(), page, size);

        // Create custom response with dynamic message
        String message = "Users fetched successfully"; // Dynamic message for fetching all users
        ApiResponse<List<Map<String, Object>>> apiResponse = new ApiResponse<>(200, message, paginatedUsers);

        return ResponseEntity.ok(apiResponse);
    }

    @Override
    public ResponseEntity<ApiResponse<Map<String, Object>>> getUserById(int id) {
        String url = jsonPlaceholderUrl + "/users/" + id;

        // Use ParameterizedTypeReference to avoid unchecked cast warning
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Object>>() {}
        );

        // Create custom response with dynamic message
        String message = "User with ID " + id + " fetched successfully"; // Dynamic message for fetching user by ID
        ApiResponse<Map<String, Object>> apiResponse = new ApiResponse<>(200, message, response.getBody());

        return ResponseEntity.ok(apiResponse);
    }
}