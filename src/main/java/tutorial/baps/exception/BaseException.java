package tutorial.baps.exception;

import org.springframework.http.HttpStatus;

/**
 * This can be kept to indicate there was an exception in your application, it can be more complex.
 * It must extend RuntimeException
 */
public class BaseException extends RuntimeException {

    /**
     * Indicates which status should be sent back
     */
    private final HttpStatus status;

    public BaseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
