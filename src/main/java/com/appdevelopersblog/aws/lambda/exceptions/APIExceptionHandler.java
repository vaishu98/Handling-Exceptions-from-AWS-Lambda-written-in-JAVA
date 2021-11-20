package com.appdevelopersblog.aws.lambda.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value = {MyException.class})
    public ResponseEntity<Object> handleMyException(MyException e){
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        MyExceptionResponse res = new MyExceptionResponse(e.getMessage(),e.getStackTrace(), badRequest);
        return new ResponseEntity<>(res, badRequest);
    }
}