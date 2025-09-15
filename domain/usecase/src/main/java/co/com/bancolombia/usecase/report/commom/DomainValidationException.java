package co.com.bancolombia.usecase.report.commom;

public class DomainValidationException extends RuntimeException {
    public DomainValidationException(String message) {
        super(message);
    }
}