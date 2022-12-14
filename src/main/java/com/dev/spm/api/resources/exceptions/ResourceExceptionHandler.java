package com.dev.spm.api.resources.exceptions;

import com.dev.spm.api.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String path = request.getRequestURI() + "/" + request.getQueryString();
        StandardError error = new StandardError(System.currentTimeMillis(), status.value(), e.getMessage(), path);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DecodeParamException.class)
    public ResponseEntity<StandardError> decodeException(DecodeParamException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String path = request.getRequestURI() + "/" + request.getQueryString();
        StandardError error = new StandardError(System.currentTimeMillis(), status.value(), e.getMessage(), path);
        return ResponseEntity.status(status).body(error);
    }

}
