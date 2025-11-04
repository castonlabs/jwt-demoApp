package com.jwtapp.jwtappdemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;
    @Column(name= "first-name", nullable=false)
    private String firstName;

    @Size(min = 5, max = 20,message = "max is 20 & min is 5")
    @Column(nullable = false, unique = true,name = "username")

    private String userName;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public AppUser(String firstName, String userName, String password, UserRole role) {
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;
        this.role = role;
        
    }



}
