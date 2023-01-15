package com.bms.springbootsecurity.dto;

import com.bms.springbootsecurity.model.Role;

public record UserDto(
        Integer id,
        String username,
        String password,
        Role role,
        String token
) {
}
