package tutorial.baps.exception;

import org.springframework.http.HttpStatus;

/**
 * FIXME: This is an example, it should inform the user of what happened here, and on which object.
 * This should not be this generic
 */
public class InvalidActivationException extends BaseException {
    public InvalidActivationException() {
        super("Could not activate/deactivate object", HttpStatus.BAD_REQUEST);
    }
}
