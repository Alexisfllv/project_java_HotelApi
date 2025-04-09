package edu.com.hotelapi.Exception.Errors;

public class ExDataNotFoundException extends RuntimeException {
    public ExDataNotFoundException(String message) {
        super(message);
    }
}