package com.example.springboot.service;


import com.example.springboot.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    void save(User user);

    void update(Long id, User updatedUser);

    void delete(Long id);
}
