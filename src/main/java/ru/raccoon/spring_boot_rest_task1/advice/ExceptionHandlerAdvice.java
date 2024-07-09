package ru.raccoon.spring_boot_rest_task1.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.raccoon.spring_boot_rest_task1.exception.InvalidCredentials;
import ru.raccoon.spring_boot_rest_task1.exception.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials invalidCredentials) {
        return new ResponseEntity<>(invalidCredentials.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser unauthorizedUser) {
        return new ResponseEntity<>(unauthorizedUser.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
