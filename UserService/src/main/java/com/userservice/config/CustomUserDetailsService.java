package com.userservice.config;

import com.userservice.entity.UserEntity;
import com.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // Your JPA repository

    @Autowired
    private CentralConfig centralConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByUseremail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

        return User.builder()
                .username(user.getUseremail()) // Using email as username
                .password(centralConfig.passwordEncoder().encode(user.getPassword())) // Password should be encrypted
                .roles(user.getRole()) // Ensure roles are correctly formatted
                .build();
    }
}

