package com.ivandjoh.springh2.controller;

import com.ivandjoh.springh2.dto.ApiMessages;
import com.ivandjoh.springh2.dto.ApiResponse;
import com.ivandjoh.springh2.model.Comment;
import com.ivandjoh.springh2.service.comment.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    public ResponseEntity<ApiResponse<List<Comment>>> getComments(@RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "3") int size) {
        List<Comment> comments = commentService.getAllComments();

        ApiResponse<List<Comment>> response = ApiResponse.success(comments, ApiMessages.RESOURCES_FETCHED);
        return ResponseEntity.ok(response);
    }
}
