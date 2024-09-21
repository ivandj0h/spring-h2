package com.ivandjoh.springh2.service.user;

import com.ivandjoh.springh2.model.Comment;
import com.ivandjoh.springh2.model.Post;
import com.ivandjoh.springh2.model.User;
import com.ivandjoh.springh2.repository.CommentRepository;
import com.ivandjoh.springh2.repository.PostRepository;
import com.ivandjoh.springh2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final RestTemplate restTemplate;
    private final String jsonPlaceholderUrl;

    public UserServiceImpl(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository,
                           RestTemplate restTemplate, @Value("${jsonplaceholder.url}") String jsonPlaceholderUrl) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
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
        User[] users = restTemplate.getForObject(jsonPlaceholderUrl + "/users", User[].class);
        if (users != null) {
            for (User user : users) {
                userRepository.save(user);
            }
        }
    }

    private User fetchAndSaveUserById(int id) {
        String url = jsonPlaceholderUrl + "/users/" + id;
        User user = restTemplate.getForObject(url, User.class);
        if (user != null) {
            userRepository.save(user);
        }
        return user;
    }

    private void fetchAndSavePostsByUserId(Long userId) {
        String url = jsonPlaceholderUrl + "/posts?userId=" + userId;
        Post[] posts = restTemplate.getForObject(url, Post[].class);
        if (posts != null) {
            for (Post post : posts) {
                postRepository.save(post);
            }
        }
    }

    private void fetchAndSaveCommentsByPostId(Long postId) {
        String url = jsonPlaceholderUrl + "/comments?postId=" + postId;
        Comment[] comments = restTemplate.getForObject(url, Comment[].class);
        if (comments != null) {
            for (Comment comment : comments) {
                commentRepository.save(comment);
            }
        }
    }
}
