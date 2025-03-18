// package com.example.bank;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;

// import io.sentry.Sentry;

// @ControllerAdvice
// public class GlobalExceptionHandler {
    
//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<String> handleException(Exception ex) {

//         Sentry.captureException(ex);
//         // Handle the exception or log it in your own way
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
//     }
// }



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
        
        // Capture the exception and add the request URL to the context
        Sentry.withScope(scope -> {
            scope.setExtra("api_path", request.getRequestURI());
            scope.setExtra("method", request.getMethod());  // Optionally add request method (GET, POST, etc.)
            // You can also add more context, like headers or parameters, here if needed
            Sentry.captureException(ex);
        });
        
        // Handle the exception and respond with a generic error message
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    }
}
