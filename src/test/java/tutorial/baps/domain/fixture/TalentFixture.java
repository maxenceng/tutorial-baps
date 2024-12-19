
package tutorial.baps.domain.fixture;

import java.util.List;
import tutorial.baps.domain.Talent;
import tutorial.baps.domain.Talent.TalentBuilder;
import tutorial.baps.domain.TalentType;

import static tutorial.baps.domain.fixture.SpellFixture.spell;

public final class TalentFixture {
    public static TalentBuilder talentMinimalBuilder() {
        return Talent.builder()
                .id(1L)
                .name("talentName")
                .description("talentDescription")
                .type(TalentType.CLASS);
    }

    public static Talent talentMinimal() {
        return talentMinimalBuilder().build();
    }

    public static TalentBuilder talentBuilder() {
        return talentMinimalBuilder()
                .damage(12L)
                .heal(156L)
                .shield(492L)
                .cooldown(145L)
                .spell(spell())
                .children(List.of(
                        talentMinimal(),
                        talentMinimalBuilder().id(2L).build()));
    }

    public static Talent talent() {
        return talentBuilder().build();
    }
}
