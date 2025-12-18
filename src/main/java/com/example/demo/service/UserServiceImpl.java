package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity registerUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity getUserById(Long id) {
        // Return null if user not found
        return userRepository.findById(id).orElse(null);
    }
}