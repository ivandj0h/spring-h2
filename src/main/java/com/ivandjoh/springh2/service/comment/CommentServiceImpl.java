package com.ivandjoh.springh2.service.comment;

import com.ivandjoh.springh2.model.Comment;
import com.ivandjoh.springh2.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final RestTemplate restTemplate;
    private final String jsonPlaceholderUrl;

    public CommentServiceImpl(CommentRepository commentRepository, RestTemplate restTemplate,
                              @Value("${jsonplaceholder.url}/comments") String jsonPlaceholderUrl) {
        this.commentRepository = commentRepository;
        this.restTemplate = restTemplate;
        this.jsonPlaceholderUrl = jsonPlaceholderUrl;
    }

    @Override
    public List<Comment> getAllComments() {
        if (commentRepository.count() == 0) {
            fetchAndSaveComments();
        }
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseGet(() -> fetchAndSaveCommentById(id));
    }

    private void fetchAndSaveComments() {
        Comment[] comments = restTemplate.getForObject(jsonPlaceholderUrl, Comment[].class);
        if (comments != null) {
            for (Comment comment : comments) {
                commentRepository.save(comment);
            }
        }
    }

    private Comment fetchAndSaveCommentById(Long id) {
        String url = jsonPlaceholderUrl + "/" + id;
        Comment comment = restTemplate.getForObject(url, Comment.class);
        if (comment != null) {
            commentRepository.save(comment);
        }
        return comment;
    }
}
