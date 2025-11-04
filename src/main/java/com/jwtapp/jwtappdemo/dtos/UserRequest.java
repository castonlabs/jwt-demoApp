package com.jwtapp.jwtappdemo.dtos;

import com.jwtapp.jwtappdemo.model.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotBlank(message = "Full name is required")
    @Size(min = 3, max = 50, message = "Full name must be between 3 and 50 characters")
    private String firstName;


    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 10, message = "Username must be between 3 and 10 characters")
    private String userName;


    @NotBlank(message = "Password is required")
    @Size(min = 3, message = "Password must be at least 3 characters")
    private String password;

    private UserRole role;


}
