package com.codeforges.iservice.api.common.auth;

import com.codeforges.iservice.api.common.user.*;
import com.codeforges.iservice.api.common.user.exceptions.GoogleUserEmailNotVerifiedException;
import com.codeforges.iservice.api.common.user.exceptions.GoogleUserNotVerifiedException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    UserDto signInUser(String idToken) throws GoogleUserNotVerifiedException, GoogleUserEmailNotVerifiedException {
        GoogleUserIdTokenDto googleUserIdTokenDto = userService.verifyGoogleUser(idToken);
        UserDto userDto = userService.findByGoogleUserId(googleUserIdTokenDto.getSub());

        if (!googleUserIdTokenDto.isEmail_verified()) {
            throw new GoogleUserEmailNotVerifiedException();
        }

        if (userDto == null) {
            User user = UserMapper.googleUserIdTokenToUser(googleUserIdTokenDto);
            return userService.createUser(user);
        }

        return userDto;
    }
}
