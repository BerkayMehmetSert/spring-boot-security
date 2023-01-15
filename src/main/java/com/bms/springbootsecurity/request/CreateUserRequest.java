package com.bms.springbootsecurity.request;

import com.bms.springbootsecurity.model.Role;

public class CreateUserRequest {
    private String username;
    private String password;
    private Role role;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
