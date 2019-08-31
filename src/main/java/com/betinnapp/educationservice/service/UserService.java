package com.betinnapp.educationservice.service;

import com.betinnapp.educationservice.model.User;
import com.betinnapp.educationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByToken(UUID token) {
        return userRepository.findByToken(token);
    }

    public UUID findUserIdByToken(UUID token) {
        return userRepository.findByToken(token).getId();
    }
}
