package com.codeforges.iservice.api.partsManager.item;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Item was not found")
public class ItemNotFoundException extends Exception {
}
