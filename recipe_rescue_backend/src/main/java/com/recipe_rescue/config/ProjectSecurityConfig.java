package com.recipe_rescue.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf
                        .ignoringRequestMatchers(PathRequest.toH2Console())
                        .ignoringRequestMatchers("/v1/api/**"))
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/v1/api/**").permitAll()
                        .requestMatchers(PathRequest.toH2Console()).permitAll())
                .httpBasic(httpBasic -> httpBasic.disable());

        http.headers(headersConfigurer -> headersConfigurer
                .frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));

        return http.build();
    }
}
