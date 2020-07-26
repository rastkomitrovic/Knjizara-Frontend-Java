package com.fon.knjizarafrontend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class UserSecurity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private int enabled;

    @Column(name = "email", nullable = false)
    private String email;
}
