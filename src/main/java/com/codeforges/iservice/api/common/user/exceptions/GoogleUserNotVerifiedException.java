package com.codeforges.iservice.api.common.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Google user not verified")
public class GoogleUserNotVerifiedException extends Exception {
}
