package br.com.eventox.application.exceptions;


public class NotFoundException extends AppException {
    public NotFoundException(String code, String message) {
        super(code, message);
    }
}
