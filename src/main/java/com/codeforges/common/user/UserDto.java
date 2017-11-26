package com.codeforges.common.user;


public class UserDto {
    private Long id;
    private String email;
    private UserRole userRole;
    private String name;
    private String picture;

    public UserDto() {
    }

    public UserDto(Long id,
                   String email,
                   UserRole userRole,
                   String name,
                   String picture) {
        this.id = id;
        this.email = email;
        this.userRole = userRole;
        this.name = name;
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
