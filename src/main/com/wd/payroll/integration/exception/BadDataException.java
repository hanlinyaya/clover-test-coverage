package main.com.wd.payroll.integration.exception;

public class BadDataException extends RuntimeException {

    public BadDataException(String message) {
        super(message);
    }

}
