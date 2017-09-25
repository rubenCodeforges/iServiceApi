package com.codeforges.iservice.api.common.auth;

import com.codeforges.iservice.api.Api;
import com.codeforges.iservice.api.common.user.UserDto;
import com.codeforges.iservice.api.common.user.exceptions.GoogleUserEmailNotVerifiedException;
import com.codeforges.iservice.api.common.user.exceptions.GoogleUserNotVerifiedException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(Api.URL + "/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public UserDto signIn(@RequestParam(value = "id_token") String idToken)
            throws GoogleUserNotVerifiedException, GoogleUserEmailNotVerifiedException {

        return authService.signInUser(idToken);
    }
}
