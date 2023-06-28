package br.com.eventox.application.exceptions;


public class DomainException extends AppException {
    public DomainException(String code, String message) {
        super(code, message);
    }
}
