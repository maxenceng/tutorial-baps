package tutorial.baps.response;


import java.util.List;
import tutorial.baps.domain.TalentType;

import static tutorial.baps.response.SpellResponseFixture.spellResponse;


public final class TalentResponseFixture {
    public static TalentResponse talentResponse() {
        return new TalentResponse(
                "name",
                "description",
                112L,
                298L,
                1405L,
                30L,
                spellResponse(),
                TalentType.CLASS,
                List.of()
        );
    }
}