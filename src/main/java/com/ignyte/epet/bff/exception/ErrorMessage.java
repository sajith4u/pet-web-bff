package com.ignyte.epet.bff.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Builder
@AllArgsConstructor
public class ErrorMessage {

    private String message;
    private String title;
    private HttpStatus error;
    private int status;
    private String code;
    private String timestamp;
    private Object data;

    public ErrorMessage() {
    }

    public ErrorMessage(String message, String title, int status, String code, String timestamp) {
        this.message = message;
        this.title = title;
        this.status = status;
        this.code = code;
        this.timestamp = timestamp;
    }

    public ErrorMessage(ApiError error) {
        this.message = error.getMessage();
        this.title = error.getTitle();
        this.error = error.getHttpStatus();
        this.status = error.getHttpStatus().value();
        this.code = error.getCode();
        this.timestamp = new Date().toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HttpStatus getError() {
        return error;
    }

    public int getStatus() {
        return error.value();
    }

    public void setStatus(int status) {
        this.status = status;
        this.error = HttpStatus.valueOf(status);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimestamp() {
        return new Date().toString();
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "message='" + message + '\'' +
                ", title='" + title + '\'' +
                ", error=" + error +
                ", status=" + status +
                ", code='" + code + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", data=" + data +
                '}';
    }
}
