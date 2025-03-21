package com.example.bank;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.sentry.Sentry;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex, HttpServletRequest request) {

        Sentry.withScope(scope -> {
            scope.setExtra("api_path", request.getRequestURI());
            scope.setExtra("method", request.getMethod());
            Sentry.captureException(ex);  // Send exception to Sentry
        });

        // Return a generic error message to the client
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("An error occurred while processing the request please check sentry.");
    }
}
