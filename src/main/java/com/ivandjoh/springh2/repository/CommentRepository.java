package com.ivandjoh.springh2.repository;

import com.ivandjoh.springh2.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Method to find comments by postId
    List<Comment> findByPostId(Long postId);

    // Method to count comments by postId
    long countByPostId(Long postId);
}