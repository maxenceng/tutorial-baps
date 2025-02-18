package tutorial.baps.exception;

import org.springframework.http.HttpStatus;

/**
 * FIXME: This is an example, it should inform the user of what happened here, and on which object.
 * This should not be this generic
 */
public class InvalidUpdateException extends BaseException {
    public InvalidUpdateException() {
        super("Could not update object", HttpStatus.BAD_REQUEST);
    }
}
