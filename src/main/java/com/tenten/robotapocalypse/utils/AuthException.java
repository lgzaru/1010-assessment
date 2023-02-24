package com.tenten.robotapocalypse.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthException extends RuntimeException {
    final Logger logger = LoggerFactory.getLogger(AuthException.class);

    public AuthException(String message) {
        super(message);
        logger.warn(message);
    }
}
