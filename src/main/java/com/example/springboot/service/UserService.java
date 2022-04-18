package com.example.springboot.service;


import com.example.springboot.models.User;

import java.util.List;

public interface UserService {
    List<User> index();

    User show(int id);

    void save(User user);

    void update(int id, User updatedUser);

    void delete(int id);
}
