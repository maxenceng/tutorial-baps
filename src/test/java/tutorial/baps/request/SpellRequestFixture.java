package tutorial.baps.request;

public final class SpellRequestFixture {
    public static SpellRequest spellRequest() {
        return new SpellRequest(
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
