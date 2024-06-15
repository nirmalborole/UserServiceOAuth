package com.example.userserviceoauth.services;

import com.example.userserviceoauth.models.User;

public interface UserService {
    public User signUp(String name, String email, String password) throws Exception;
}
