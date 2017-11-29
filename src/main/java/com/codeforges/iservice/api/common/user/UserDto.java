package com.codeforges.iservice.api.common.user;


public class UserDto {
    private Long id;
    private String email;
    private UserRole userRole;

    public UserDto() {
    }

    public UserDto(Long id,
                   String email,
                   UserRole userRole) {
        this.id = id;
        this.email = email;
        this.userRole = userRole;
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
}
