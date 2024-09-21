package com.ivandjoh.springh2.service.post;

import com.ivandjoh.springh2.model.Post;
import com.ivandjoh.springh2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final RestTemplate restTemplate;
    private final String jsonPlaceholderUrl;

    public PostServiceImpl(PostRepository postRepository, RestTemplate restTemplate,
                           @Value("${jsonplaceholder.url}/posts") String jsonPlaceholderUrl) {
        this.postRepository = postRepository;
        this.restTemplate = restTemplate;
        this.jsonPlaceholderUrl = jsonPlaceholderUrl;
    }

    @Override
    public List<Post> getAllPosts() {
        if (postRepository.count() == 0) {
            fetchAndSavePosts();
        }
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseGet(() -> fetchAndSavePostById(id));
    }

    private void fetchAndSavePosts() {
        Post[] posts = restTemplate.getForObject(jsonPlaceholderUrl, Post[].class);
        if (posts != null) {
            for (Post post : posts) {
                postRepository.save(post);
            }
        }
    }

    private Post fetchAndSavePostById(Long id) {
        String url = jsonPlaceholderUrl + "/" + id;
        Post post = restTemplate.getForObject(url, Post.class);
        if (post != null) {
            postRepository.save(post);
        }
        return post;
    }
}
