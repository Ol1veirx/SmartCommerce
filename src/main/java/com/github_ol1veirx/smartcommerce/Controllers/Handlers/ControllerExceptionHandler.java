package com.github_ol1veirx.smartcommerce.Controllers.Handlers;

import com.github_ol1veirx.smartcommerce.DTO.CustomError;
import com.github_ol1veirx.smartcommerce.Services.Exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
