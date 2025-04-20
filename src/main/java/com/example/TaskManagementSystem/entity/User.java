package com.example.TaskManagementSystem.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "user")
public class User implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String name;
    private boolean active;
    private String googleName;
    private String googleUsername;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    //Геттеры, сеттеры, toString(), equals(), hashcode(), имплементация UserDetails
    public void setId(Long id){this.id = id;}
    public Long getId(){return id;}

    public void setUsername(String username) {this.username = username;}
    public String getUsername() {return username;}

    public void setPassword(String password) {this.password = password;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {return password;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setActive(boolean b) {active = b;}
    public boolean getActive() {return active;}

    public void setRoles(Collection<Role> roles) {this.roles = (Set<Role>) roles;}
}