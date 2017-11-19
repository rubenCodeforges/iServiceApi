package com.codeforges.iservice.api.common.auth;

import com.codeforges.iservice.api.Api;
import com.codeforges.iservice.api.common.user.*;
import com.codeforges.iservice.api.common.user.exceptions.GoogleUserEmailNotVerifiedException;
import com.codeforges.iservice.api.common.user.exceptions.GoogleUserNotVerifiedException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class AuthService {
    private UserService userService;
    private RestTemplate restTemplate;


    public AuthService(UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    UserDto signInUser(String idToken) throws GoogleUserNotVerifiedException, GoogleUserEmailNotVerifiedException {
        GoogleUserIdTokenDto googleUserIdTokenDto = verifyGoogleUser(idToken);
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

    GoogleUserIdTokenDto verifyGoogleUser(String idToken) throws GoogleUserNotVerifiedException {
        UriComponentsBuilder uriComponentsBuilder =
                UriComponentsBuilder.fromHttpUrl(Api.GOOGLE_ID_TOKEN_VERFEFICATION_URL);
        uriComponentsBuilder.queryParam("id_token", idToken);
        ResponseEntity<GoogleUserIdTokenDto> response;

        try {
            response = restTemplate.getForEntity(uriComponentsBuilder.build().toUriString(), GoogleUserIdTokenDto.class);
        } catch (Exception e) {
            throw new GoogleUserNotVerifiedException();
        }

        return response.getBody();
    }
}
