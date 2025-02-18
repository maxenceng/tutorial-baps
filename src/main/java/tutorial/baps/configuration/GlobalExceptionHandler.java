package tutorial.baps.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tutorial.baps.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @param e Exception to catch
     * @return a message your front-end will be able to interpret
     */
    @ExceptionHandler(BaseException.class)
    private ResponseEntity<String> handleInvalidCreationException(final BaseException e) {
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }
}
