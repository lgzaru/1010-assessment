package com.tenten.robotapocalypse.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ConnectionException extends RuntimeException {
    final Logger logger = LoggerFactory.getLogger(ConnectionException.class);

    public ConnectionException(String message) {
        super(message);
        message = "Connection error, please check your connection and try again:- " + message;
        logger.warn(message);
    }
}
