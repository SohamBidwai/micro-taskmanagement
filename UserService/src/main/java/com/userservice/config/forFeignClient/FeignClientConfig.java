package com.userservice.config.forFeignClient;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            // Get the security context to fetch the authenticated user's JWT
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.getCredentials() instanceof String) {
                String jwtToken = (String) authentication.getCredentials();
                requestTemplate.header("Authorization", "Bearer " + jwtToken);
            }
        };
    }
}

