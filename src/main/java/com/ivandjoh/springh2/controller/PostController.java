package com.ivandjoh.springh2.controller;

import com.ivandjoh.springh2.dto.ApiMessages;
import com.ivandjoh.springh2.dto.ApiResponse;
import com.ivandjoh.springh2.model.Post;
import com.ivandjoh.springh2.service.post.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<ApiResponse<List<Post>>> getPosts(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "3") int size) {
        List<Post> posts = postService.getAllPosts();

        ApiResponse<List<Post>> response = ApiResponse.success(posts, ApiMessages.RESOURCES_FETCHED);
        return ResponseEntity.ok(response);
    }
}
