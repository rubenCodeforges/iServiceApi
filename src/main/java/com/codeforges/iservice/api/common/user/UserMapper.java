package com.codeforges.iservice.api.common.user;

public class UserMapper {

    public static User googleUserIdTokenToUser(GoogleUserIdTokenDto googleUserIdTokenDto) {
        return new User(
                googleUserIdTokenDto.getSub(),
                googleUserIdTokenDto.getEmail(),
                googleUserIdTokenDto.isEmail_verified()
        );
    }

    public static UserDto userToDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getUserRole()
        );
    }
}
