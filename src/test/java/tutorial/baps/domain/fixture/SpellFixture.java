package tutorial.baps.domain.fixture;


import tutorial.baps.domain.Spell;
import tutorial.baps.domain.Spell.SpellBuilder;

/**
 * Fixture are helpers to create mock objects
 */
public final class SpellFixture {
    public static SpellBuilder spellMinimalBuilder() {
        return Spell.builder()
                .id(1L)
                .name("spellName")
                .description("spellDescription")
                .active(true)
                .passive(true);
    }

    public static Spell spellMinimal() {
        return spellMinimalBuilder().build();
    }

    public static SpellBuilder spellBuilder() {
        return spellMinimalBuilder()
                .damage(12L)
                .heal(156L)
                .shield(492L)
                .cooldown(145L);
    }

    public static Spell spell() {
        return spellBuilder().build();
    }
}
