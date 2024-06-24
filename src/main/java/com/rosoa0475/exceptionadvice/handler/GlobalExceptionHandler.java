package com.rosoa0475.exceptionadvice.handler;

import com.rosoa0475.exceptionadvice.exception.CustomException;
import com.rosoa0475.exceptionadvice.dto.ErrorResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "com.rosoa0475") // 이 어노테이션 안에 @Component 선언되어 있어서 자동으로 Bean으로 설정 됨.
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        ErrorResponse body = new ErrorResponse(ex.getCode(), ex.getMessage());
        return this.handleExceptionInternal(body, ex.getStatusCode());
    }
    private ResponseEntity<Object> handleExceptionInternal(ErrorResponse body, HttpStatusCode statusCode) {
        return ResponseEntity.status(statusCode)
                .body(body);
    }
}
