package com.codeforges.iservice.api.common.auth;

import com.codeforges.iservice.api.common.user.UserDto;
import com.codeforges.iservice.api.common.user.exceptions.GoogleUserEmailNotVerifiedException;
import com.codeforges.iservice.api.common.user.exceptions.GoogleUserNotVerifiedException;
import com.codeforges.iservice.api.config.ApiConfig;
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
