package com.rosoa0475.exceptionadvice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class CustomException extends RuntimeException{
    private int code;
    private String message;
    private HttpStatusCode statusCode;
    public CustomException(int code, String message, HttpStatusCode statusCode) {
        super(message);
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
