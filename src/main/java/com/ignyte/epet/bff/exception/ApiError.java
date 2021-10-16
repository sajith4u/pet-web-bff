package com.ignyte.epet.bff.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiError {
    CONTENT_MODULE_CONNECTION_ERROR("Internal Server Error", "B1001", "Content Module Connectivity Issue", HttpStatus.INTERNAL_SERVER_ERROR);
    private String title;
    private String code;
    private String message;
    private HttpStatus httpStatus;

    ApiError(String title, String code, String message, HttpStatus httpStatus) {
        this.title = title;
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", httpStatus=" + httpStatus +
                '}';
    }
}
