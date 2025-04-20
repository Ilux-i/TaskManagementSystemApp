package com.example.TaskManagementSystem.config;

import com.example.TaskManagementSystem.repository.UserRepo;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.web.SecurityFilterChain;

import java.security.AuthProvider;

@EnableWebSecurity
@Configuration
public class SecurityConfig  {

    @Resource
    private AuthProvider authProvider;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private OAuth2ClientContext oAuth2ClientContext;

    @Resource
    private UserRepo userRepo;

    @Bean
    PasswordEncoder passwordEncoder()
    {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/resources/**", "/", "/login**", "/registration").permitAll()
                        .anyRequest().authenticated()
                        .and().formLogin().loginPage("/login")
                        .defaultSuccessUrl("/notes").failureUrl("/login?error").permitAll()
                        .and().logout().logoutSuccessUrl("/").permitAll();
        return http.build();
    }

    @Bean
    protected void configure(AuthenticationManagerBuilder auth)
    {
        auth.authenticationProvider((AuthenticationProvider) authProvider);
    }

}
