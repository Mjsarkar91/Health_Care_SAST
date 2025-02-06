package com.healthcare.exceptions;

import com.healthcare.models.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleAllExceptions(Exception ex) {
        ApiResponse response = new ApiResponse("error", "An unexpected error occurred: " + ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiResponse response = new ApiResponse("error", "Resource not found: " + ex.getResourceName());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse> handleValidationException(ValidationException ex) {
        ApiResponse response = new ApiResponse("error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<ApiResponse> handleUnauthorizedAccess(UnauthorizedAccessException ex) {
        ApiResponse response = new ApiResponse("error", "Unauthorized access attempt detected!");
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(OrderProcessingException.class)
    public ResponseEntity<ApiResponse> handleOrderProcessingException(OrderProcessingException ex) {
        ApiResponse response = new ApiResponse("error", "Order processing failed: " + ex.getOrderId());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PaymentFailedException.class)
    public ResponseEntity<ApiResponse> handlePaymentFailedException(PaymentFailedException ex) {
        ApiResponse response = new ApiResponse("error", "Payment failed for transaction ID: " + ex.getTransactionId());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public static class ResourceNotFoundException extends RuntimeException {
        private String resourceName;

        public ResourceNotFoundException(String resourceName) {
            super("Resource not found: " + resourceName);
            this.resourceName = resourceName;
        }

        public String getResourceName() {
            return resourceName;
        }
    }

    public static class ValidationException extends RuntimeException {
        public ValidationException(String message) {
            super(message);
        }
    }

    public static class UnauthorizedAccessException extends RuntimeException {
        public UnauthorizedAccessException(String message) {
            super(message);
        }
    }

    public static class OrderProcessingException extends RuntimeException {
        private String orderId;

        public OrderProcessingException(String orderId) {
            super("Error processing order: " + orderId);
            this.orderId = orderId;
        }

        public String getOrderId() {
            return orderId;
        }
    }

    public static class PaymentFailedException extends RuntimeException {
        private String transactionId;

        public PaymentFailedException(String transactionId) {
            super("Payment failed for transaction ID: " + transactionId);
            this.transactionId = transactionId;
        }

        public String getTransactionId() {
            return transactionId;
        }
    }
}
