package com.codeforges.iservice.api.common.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(User user) {
        User newUser = userRepository.save(user);
        return UserMapper.userToDto(newUser);
    }

    public UserDto findByGoogleUserId(String googleUserId) {
        User user = userRepository.findByGoogleUserId(googleUserId);
        return UserMapper.userToDto(user);
    }
}
