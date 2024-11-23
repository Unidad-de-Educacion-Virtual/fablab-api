package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(createErrorResponse("Ocurrió un error inesperado: " + ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(createErrorResponse("Error en la ejecución: " + ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(createErrorResponse("Recurso no encontrado: " + ex.getMessage()), HttpStatus.NOT_FOUND);
    }
    
    private ErrorResponse createErrorResponse(String message) {
        return new ErrorResponse(true, message);
    }

   
    private static class ErrorResponse {
        private boolean error;
        private String message;

        public ErrorResponse(boolean error, String message) {
            this.error = error;
            this.message = message;
        }

        @SuppressWarnings("unused")
		public boolean isError() {
            return error;
        }

        @SuppressWarnings("unused")
		public String getMessage() {
            return message;
        }
    }
}
