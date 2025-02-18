package tutorial.baps.exception;

import org.springframework.http.HttpStatus;

/**
 * This is an example of a descriptive exception, returning the information on a missing talent for a given ID
 */
public class TalentNotFoundException extends BaseException {
    public TalentNotFoundException(Long id) {
        super("Talent with id %d not found".formatted(id), HttpStatus.NOT_FOUND);
    }
}
