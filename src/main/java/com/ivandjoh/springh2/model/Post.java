package com.ivandjoh.springh2.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "posts")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private Long userId;
}