package com.web.fetchyback.service;

import java.util.List;

import com.web.fetchyback.models.User;

public interface IUserService {
    List<User> getAll();
    void save(User user);
}
