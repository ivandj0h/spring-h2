package com.ivandjoh.springh2.service.user;

import com.ivandjoh.springh2.model.User;
import com.ivandjoh.springh2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final String jsonPlaceholderUrl;

    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate,
                           @Value("${jsonplaceholder.url}/users") String jsonPlaceholderUrl) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
        this.jsonPlaceholderUrl = jsonPlaceholderUrl;
    }

    @Override
    public List<User> getAllUsers(int page, int size) {
        if (userRepository.count() == 0) {
            fetchAndSaveUsers();
        }
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable).getContent();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById((long) id).orElseGet(() -> fetchAndSaveUserById(id));
    }

    private void fetchAndSaveUsers() {
        User[] users = restTemplate.getForObject(jsonPlaceholderUrl, User[].class);
        if (users != null) {
            for (User user : users) {
                userRepository.save(user);
            }
        }
    }

    private User fetchAndSaveUserById(int id) {
        String url = jsonPlaceholderUrl + "/" + id;
        User user = restTemplate.getForObject(url, User.class);
        if (user != null) {
            userRepository.save(user);
        }
        return user;
    }
}