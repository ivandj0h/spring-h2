package com.ivandjoh.springh2.repository;

import com.ivandjoh.springh2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
