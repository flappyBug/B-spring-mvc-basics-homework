package com.thoughtworks.capacity.gtb.mvc.exception;

public class RequestError extends RuntimeException {
    public RequestError(String message) {
        super(message);
    }
}
