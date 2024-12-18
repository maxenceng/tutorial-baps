package tutorial.baps.domain;

import tutorial.baps.assertion.Assert;

public class Spell {
    private final String name;

    private Spell(SpellBuilder builder) {
        Assert.notBlank(builder.name, "Name must not be blank"); // C'est faux, c'est pas comme ça Assert
        this.name = builder.name;
        /**
         * FIXME
         * Add other attributes here !
         */
    }

    public String getName() {
        return name;
    }

    public static SpellBuilder builder() {
        return new SpellBuilder();
    }

    public static class SpellBuilder {
        private String name;

        /**
         * FIXME
         * Add other attributes here !
         */

        private SpellBuilder() {}

        public SpellBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Spell build() {
            return new Spell(this);
        }
    }
}
