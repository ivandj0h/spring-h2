package com.ivandjoh.springh2.service.comment;

import com.ivandjoh.springh2.model.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    List<Comment> getCommentsByPostId(Long postId);
    Comment getCommentById(Long id);
}
