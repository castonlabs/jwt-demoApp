package com.jwtapp.jwtappdemo.service;

import com.jwtapp.jwtappdemo.dtos.UserRequest;
import com.jwtapp.jwtappdemo.model.AppUser;
import com.jwtapp.jwtappdemo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
@Transactional
    public void registerUser(UserRequest userRequest) {
            if(userRepository.existsByUserName(userRequest.getUserName())){
                throw new IllegalArgumentException("the user name provided  is already taken");
            }

            AppUser appUser = new AppUser()
                    .builder()
                    .firstName(userRequest.getFirstName())
                    .userName(userRequest.getUserName())
                    .password(passwordEncoder.encode(userRequest.getPassword()))
                    .role(userRequest.getRole())
                    .build();
            userRepository.save(appUser);



    }

}
