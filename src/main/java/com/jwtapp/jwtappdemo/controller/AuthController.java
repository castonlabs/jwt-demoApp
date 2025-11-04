package com.jwtapp.jwtappdemo.controller;

import com.jwtapp.jwtappdemo.dtos.UserRequest;
import com.jwtapp.jwtappdemo.dtos.UserResponse;
import com.jwtapp.jwtappdemo.service.AuthService;
import com.jwtapp.jwtappdemo.service.CustomerUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
   private final AuthService authService;
   @PostMapping("/register")
    public ResponseEntity<?>registerUser(@RequestBody UserRequest request){
       authService.registerUser(request);
        return ResponseEntity.ok("users registered successfully");

    }
}
