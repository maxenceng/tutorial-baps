package tutorial.baps.response;

public final class SpellResponseFixture {
    public static SpellResponse spellResponse() {
        return new SpellResponse(
                "name",
                "description",
                112L,
                298L,
                1405L,
                30L,
                true,
                true
        );
    }
}
