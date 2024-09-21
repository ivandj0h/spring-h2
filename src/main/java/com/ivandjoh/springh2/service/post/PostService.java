package com.ivandjoh.springh2.service.post;

import com.ivandjoh.springh2.model.Post;
import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
}
