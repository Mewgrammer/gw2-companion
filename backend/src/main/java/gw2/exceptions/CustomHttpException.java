package gw2.exceptions;

import org.springframework.http.HttpStatus;

public class CustomHttpException extends Exception {

    private HttpStatus statusCode;

    public CustomHttpException(String reason, HttpStatus statuscode) {
        super(reason);
        this.statusCode = statuscode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return String.format("HTTP Exception\nStatus: %s\nMessage:%s", statusCode, getMessage());
    }
}
