package com.codeforges.iservice.api.common.user;

import com.codeforges.iservice.api.Api;
import com.codeforges.iservice.api.common.user.exceptions.GoogleUserNotVerifiedException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserService {
    private RestTemplate restTemplate;
    private UserRepository userRepository;

    public UserService(RestTemplate restTemplate,
                       UserRepository userRepository) {
        this.restTemplate = restTemplate;
        this.userRepository = userRepository;
    }

    public GoogleUserIdTokenDto verifyGoogleUser(String idToken) throws GoogleUserNotVerifiedException {
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

    public UserDto createUser(User user) {
        User newUser = userRepository.save(user);
        return UserMapper.userToDto(newUser);
    }

    public UserDto findByGoogleUserId(String googleUserId) {
        User user = userRepository.findByGoogleUserId(googleUserId);
        return UserMapper.userToDto(user);
    }
}
