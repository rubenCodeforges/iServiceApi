package com.codeforges.iservice.api.common.user;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

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

    public Collection<UserDto> findAll() {
        ModelMapper mapper = new ModelMapper();
        Collection<UserDto> users = mapper.map(userRepository.findAll(), new TypeToken<List<UserDto>>() {
        }.getType());
        return users;
    }
}
