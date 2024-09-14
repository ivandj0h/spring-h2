package com.ivandjoh.springh2.dto;

public record ApiResponse<T>(int status, String message, T data) {

    // Factory method for success responses (default to status 200)
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "Operation successful", data);
    }

    // Factory method for custom responses
    public static <T> ApiResponse<T> of(int status, String message, T data) {
        return new ApiResponse<>(status, message, data);
    }

    // Factory method for 404 Not Found
    public static <T> ApiResponse<T> notFound(String message) {
        return new ApiResponse<>(404, message != null ? message : "Resource not found", null);
    }

    // Factory method for 500 Internal Server Error
    public static <T> ApiResponse<T> internalServerError(String message) {
        return new ApiResponse<>(500, message != null ? message : "Internal server error", null);
    }

    // Factory method for 204 No Content
    public static ApiResponse<Void> noContent() {
        return new ApiResponse<>(204, "No content", null);
    }
}
