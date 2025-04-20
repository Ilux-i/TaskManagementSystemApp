package com.example.TaskManagementSystem.service;

import com.example.TaskManagementSystem.entity.User;
import com.example.TaskManagementSystem.repository.UserRepo;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService
{
    @Resource
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User userFindByUsername = userRepo.findByUsername(username);
        //Остальные поиски

        if(userFindByUsername != null)
        {
            return userFindByUsername;
        }
        //Остальные проверки
        return null;
    }
}