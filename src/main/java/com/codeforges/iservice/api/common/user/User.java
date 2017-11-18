package com.codeforges.iservice.api.common.user;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@CrossOrigin
@Entity
@Table(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String googleUserId;
    private String email;
    private boolean emailVerified;
    private UserRole userRole = UserRole.GUEST;

    public User() {
    }

    public User(String googleUserId,
                String email,
                boolean emailVerified) {
        this.googleUserId = googleUserId;
        this.email = email;
        this.emailVerified = emailVerified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoogleUserId() {
        return googleUserId;
    }

    public void setGoogleUserId(String googleUserId) {
        this.googleUserId = googleUserId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
