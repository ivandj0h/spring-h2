package com.ivandjoh.springh2.dto;

public class ApiResponse<T> {

    private int status;
    private String message;
    private T data;

    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    // Factory method for success responses
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(200, message, data);
    }

    // Factory method for not found responses
    public static <T> ApiResponse<T> notFound(String message) {
        return new ApiResponse<>(404, message, null);
    }

    // Factory method for internal server error
    public static <T> ApiResponse<T> internalServerError(String message) {
        return new ApiResponse<>(500, message, null);
    }

    // Factory method for no content
    public static ApiResponse<Void> noContent() {
        return new ApiResponse<>(204, ApiMessages.NO_CONTENT, null);
    }
}