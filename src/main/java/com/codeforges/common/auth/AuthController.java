package com.codeforges.common.auth;

import com.codeforges.common.config.ApiConfig;
import com.codeforges.common.user.UserDto;
import com.codeforges.common.user.exceptions.GoogleUserEmailNotVerifiedException;
import com.codeforges.common.user.exceptions.GoogleUserNotVerifiedException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(ApiConfig.URL + "/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // TODO: Requires session to store the token ?
    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public UserDto signIn(@RequestParam(value = "id_token") String idToken)
            throws GoogleUserNotVerifiedException, GoogleUserEmailNotVerifiedException {

        return authService.signInUser(idToken);
    }
}
