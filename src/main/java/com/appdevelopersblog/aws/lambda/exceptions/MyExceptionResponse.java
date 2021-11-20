package com.appdevelopersblog.aws.lambda.exceptions;

import org.springframework.http.HttpStatus;

public class MyExceptionResponse {
    private final String message;
    private final StackTraceElement[] trace;
    private final HttpStatus httpStatus;

    public MyExceptionResponse(String message, StackTraceElement[] trace, HttpStatus httpStatus) {
        this.message = message;
        this.trace = trace;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public StackTraceElement[] getTrace() {
        return trace;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

