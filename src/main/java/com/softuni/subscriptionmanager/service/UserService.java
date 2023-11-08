package com.softuni.subscriptionmanager.service;

import com.softuni.subscriptionmanager.model.dto.UserRegisterDTO;
import com.softuni.subscriptionmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerAndLogin(UserRegisterDTO userModel) {


    }
}
