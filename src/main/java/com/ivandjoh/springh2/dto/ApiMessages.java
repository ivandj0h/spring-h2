package com.ivandjoh.springh2.dto;

public class ApiMessages {

    // Success Messages
    public static final String OPERATION_SUCCESS = "Operation successful";
    public static final String RESOURCE_CREATED = "Resource created successfully";
    public static final String RESOURCE_UPDATED = "Resource updated successfully";
    public static final String RESOURCE_DELETED = "Resource deleted successfully";
    public static final String RESOURCES_FETCHED = "Resources fetched successfully";
    public static final String RESOURCE_FETCHED = "Resource fetched successfully";

    // Error Messages
    public static final String RESOURCE_NOT_FOUND = "The requested resource was not found";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error occurred";

    // No Content Message
    public static final String NO_CONTENT = "No content available";

    // Private constructor to prevent instantiation
    private ApiMessages() {
        // Throw an exception if this ever *is* called
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}