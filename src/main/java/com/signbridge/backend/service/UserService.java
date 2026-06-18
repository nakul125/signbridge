package com.signbridge.backend.service;

import com.signbridge.backend.dto.RegisterRequest;
import com.signbridge.backend.dto.UserResponse;
import com.signbridge.backend.exception.DuplicateResourceException;
import com.signbridge.backend.model.User;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.signbridge.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(RegisterRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new DuplicateResourceException("Email already exists" + request.getEmail());
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(encodedPassword)
                .role(User.Role.USER)
                .isActive(true)
                .build();

        User savedUser = userRepository.save(user);
    }
}
