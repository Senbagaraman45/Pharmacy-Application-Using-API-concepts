package com.example.PharmacyManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleApiException(ApiException ex) {
        HttpStatus status = ex.getStatus();
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), status.value());
        return new ResponseEntity<>(errorMessage, status);
    }

    // Optionally, handle other exceptions here

    public static class ErrorMessage {
        private final String message;
        private final int status;

        public ErrorMessage(String message, int status) {
            this.message = message;
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public int getStatus() {
            return status;
        }
    }
}
