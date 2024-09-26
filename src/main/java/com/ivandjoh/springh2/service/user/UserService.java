package com.ivandjoh.springh2.service.user;

import com.ivandjoh.springh2.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers(int page, int size);
    User getUserById(int id);
}