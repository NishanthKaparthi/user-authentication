package com.project.authentication.user_auth_app.service;

import com.project.authentication.user_auth_app.model.dto.UserRequestDto;
import com.project.authentication.user_auth_app.model.entity.User;
import com.project.authentication.user_auth_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean createUser(UserRequestDto userRequestDto) {
        if (userRepository.existsByEmail(userRequestDto.email())) {
            return false;
        }

        User user = new User();
        user.setName(userRequestDto.name());
        user.setEmail(userRequestDto.email());
        user.setPassword(passwordEncoder.encode(userRequestDto.password()));
        User savedUser = userRepository.save(user);

        return true;
    }

}
