package com.jwtapp.jwtappdemo.dtos;

import com.jwtapp.jwtappdemo.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String firstName;


    private String userName;


    private String password;

    private UserRole userRole;


}
