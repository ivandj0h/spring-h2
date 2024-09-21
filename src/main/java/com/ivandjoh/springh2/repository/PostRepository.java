package com.ivandjoh.springh2.repository;

import com.ivandjoh.springh2.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // Method to find posts by userId
    List<Post> findByUserId(Long userId);

    // Method to count posts by userId
    long countByUserId(Long userId);
}
