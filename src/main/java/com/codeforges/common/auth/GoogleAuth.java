package com.codeforges.common.auth;

import com.codeforges.common.user.GoogleUserIdTokenDto;
import com.codeforges.common.user.UserDto;
import com.codeforges.common.user.UserRole;
import com.codeforges.common.user.UserService;
import com.codeforges.common.user.exceptions.GoogleUserNotVerifiedException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class GoogleAuth {
    private HttpServletRequest request;
    private AuthService authService;
    private UserService userService;

    GoogleAuth(HttpServletRequest request,
               UserService userService,
               AuthService authService) {
        this.authService = authService;
        this.request = request;
        this.userService = userService;
    }

    public boolean hasRole(UserRole userRole) throws GoogleUserNotVerifiedException {
        String token = request.getHeader("googleToken");
        GoogleUserIdTokenDto googleUserIdTokenDto = authService.verifyGoogleUser(token);
        UserDto userDto = this.userService.findByGoogleUserId(googleUserIdTokenDto.getSub());

        return userRole == userDto.getUserRole();
    }
}