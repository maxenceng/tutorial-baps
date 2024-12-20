package tutorial.baps.domain;

import tutorial.baps.assertion.Assert;
import java.util.List;

public class Specialization {

    private final Long id;
    private final String name;
    private final String description;
    private final List<Spell> spells;
    private final List<Talent> talents;

    private Specialization(SpecializationBuilder builder) {

        Assert.notNull("Id", builder.id);
        Assert.notBlank("Name", builder.name);
        Assert.notBlank("Description", builder.description);
        Assert.notEmpty("Spells", builder.spells);
        Assert.notEmpty("Talents", builder.talents);
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.spells = builder.spells;
        this.talents = builder.talents;

    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<Spell> getSpells() { return spells; }
    public List<Talent> getTalents() { return talents; }

    public static SpecializationBuilder builder() {
        return new SpecializationBuilder();
    }

    public static class SpecializationBuilder {

        private Long id;
        private String name;
        private String description;
        private List<Spell> spells;
        private List<Talent> talents;

        public SpecializationBuilder() {}

        public SpecializationBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public SpecializationBuilder name(String name) {
            this.name = name;
            return this;
        }
        public SpecializationBuilder description(String description) {
            this.description = description;
            return this;
        }
        public SpecializationBuilder spells(List<Spell> spells) {
            this.spells = spells;
            return this;
        }
        public SpecializationBuilder talents(List<Talent> talents) {
            this.talents = talents;
            return this;
        }
        public Specialization build() {
            return new Specialization(this);
        }

    }
}
