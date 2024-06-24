package com.rosoa0475.exceptionadvice;

import com.rosoa0475.exceptionadvice.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public ResponseEntity<Object> handleError() {
        throw new CustomException(1, "CustomError", HttpStatus.ACCEPTED);
    }
}
