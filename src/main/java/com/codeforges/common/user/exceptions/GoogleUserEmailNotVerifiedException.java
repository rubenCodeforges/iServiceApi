package com.codeforges.common.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Google user has not verified its email")
public class GoogleUserEmailNotVerifiedException extends Exception {
}
