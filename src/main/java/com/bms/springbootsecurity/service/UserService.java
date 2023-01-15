package com.bms.springbootsecurity.service;

import com.bms.springbootsecurity.dto.UserDto;
import com.bms.springbootsecurity.model.User;
import com.bms.springbootsecurity.repository.UserRepository;
import com.bms.springbootsecurity.request.CreateUserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository,
                       JwtService jwtService,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto createUser(final CreateUserRequest request) {
        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getRole()
        );

        userRepository.save(user);

        var token = jwtService.generateToken(user);

        return new UserDto(user.getId(), user.getUsername(), user.getPassword(), user.getRole(), token);
    }
}
