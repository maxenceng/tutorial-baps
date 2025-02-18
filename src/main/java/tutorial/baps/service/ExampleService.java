package tutorial.baps.service;

import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import tutorial.baps.domain.Talent;
import tutorial.baps.exception.InvalidActivationException;
import tutorial.baps.exception.InvalidCreationException;
import tutorial.baps.exception.InvalidDeleteException;
import tutorial.baps.exception.InvalidUpdateException;
import tutorial.baps.exception.TalentNotFoundException;
import tutorial.baps.request.TalentRequest;
import tutorial.baps.response.TalentResponse;

/**
 * FIXME These methods are only used to represent an example
 */
@Service
public class ExampleService {

    public List<TalentResponse> getAll() {
        return List.of();
    }

    public TalentResponse getOne(Long id) {
        throw new TalentNotFoundException(id);
    }

    public TalentResponse create(TalentRequest talentRequest) {
        Talent talent = talentRequest.toDomain();
        // do something here instead...
        if (Objects.equals(talent.getName(), "invalid")) {
            throw new InvalidCreationException();
        }
        return TalentResponse.from(talent);
    }

    public TalentResponse update(Long id, TalentRequest talentRequest) {
        Talent talent = talentRequest.toDomain();
        // do something here instead...
        if (Objects.equals(id, 0L)) {
            throw new InvalidUpdateException();
        }
        return TalentResponse.from(talent);
    }

    public TalentResponse activation(Long id) {
        if (Objects.equals(id, 0L)) {
            throw new InvalidActivationException();
        }
        return null;
    }

    public void delete(Long id) {
        if (Objects.equals(id, 0L)) {
            throw new InvalidDeleteException();
        }
    }
}
