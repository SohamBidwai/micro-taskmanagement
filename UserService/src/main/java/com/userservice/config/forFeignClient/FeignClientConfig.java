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
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("Feign Interceptor running. Auth: " + authentication);

            if (authentication != null && authentication.getCredentials() instanceof String) {
                String jwtToken = (String) authentication.getCredentials();

                /*In above line we get an token as null because, we set null credentials to
                new UsernamePasswordAuthenticationToken() method in JWTAuthenticationFilter as follows.*/
                //UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                //SO Instead of above line used following line,
                //UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, token, userDetails.getAuthorities());

                System.out.println("JWT being sent to TaskService: " + jwtToken);
                requestTemplate.header("Authorization", "Bearer " + jwtToken);
            } else {
                System.out.println("❌ No JWT found in SecurityContextHolder");
            }
        };
    }
}

