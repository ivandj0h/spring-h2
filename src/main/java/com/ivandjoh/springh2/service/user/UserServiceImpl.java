package com.ivandjoh.springh2.service.user;

import com.ivandjoh.springh2.utils.PaginationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<List<Map<String, Object>>> getUsers(int page, int size) {
        String url = "https://jsonplaceholder.typicode.com/users";
        ResponseEntity<Map[]> response = restTemplate.getForEntity(url, Map[].class);

        // Pagination logic using helper method
        List<Map<String, Object>> paginatedUsers = PaginationUtils.paginate(response.getBody(), page, size);

        return ResponseEntity.ok(paginatedUsers);
    }
}