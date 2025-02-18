package tutorial.baps.request;


import java.util.List;
import tutorial.baps.domain.TalentType;

import static tutorial.baps.request.SpellRequestFixture.spellRequest;

public final class TalentRequestFixture {
    public static TalentRequest talentRequest() {
        return new TalentRequest(
                "name",
                "description",
                112L,
                298L,
                1405L,
                30L,
                spellRequest(),
                TalentType.CLASS,
                List.of()
        );
    }

    public static TalentRequest invalidTalentRequest() {
        return new TalentRequest(
                "invalid",
                "description",
                112L,
                298L,
                1405L,
                30L,
                spellRequest(),
                TalentType.CLASS,
                List.of()
        );
    }
}