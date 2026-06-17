package com.signbridge.backend.service;

import com.signbridge.backend.dto.RegisterRequest;
import com.signbridge.backend.exception.DuplicateResourceException;
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
    }
}
