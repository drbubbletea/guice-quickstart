package net.timeboxing.resource;

public class ClasspathResourceNotFoundException extends RuntimeException {
    public ClasspathResourceNotFoundException() {
    }

    public ClasspathResourceNotFoundException(String message) {
        super(message);
    }

    public ClasspathResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClasspathResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
