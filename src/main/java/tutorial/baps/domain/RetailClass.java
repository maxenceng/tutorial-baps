package tutorial.baps.domain;

import tutorial.baps.assertion.Assert;
import java.util.List;

public class RetailClass {

    private final Long id;
    private final String name;
    private final String description;
    private final List<Specialization> specializations;
    private final List<Talent> talents;
    private final List<Spell> spells;

    private RetailClass (RetailClassBuilder builder) {

        Assert.notNull("Id", builder.id);
        Assert.notBlank("Name", builder.name);
        Assert.notBlank("Description", builder.description);
        Assert.notEmpty("Specializations", builder.specializations);
        Assert.notEmpty("Spells", builder.spells);
        Assert.notEmpty("Talents", builder.talents);
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.specializations = builder.specializations;
        this.talents = builder.talents;
        this.spells = builder.spells;

    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<Specialization> getSpecializations() { return specializations; }
    public List<Talent> getTalents() { return talents; }
    public List<Spell> getSpells() { return spells; }

    public static RetailClassBuilder builder() {
        return new RetailClassBuilder();
    }

    public static class RetailClassBuilder {

        private Long id;
        private String name;
        private String description;
        private List<Specialization> specializations;
        private List<Talent> talents;
        private List<Spell> spells;

        public RetailClassBuilder() {}

        public RetailClassBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public RetailClassBuilder name(String name) {
            this.name = name;
            return this;
        }
        public RetailClassBuilder description(String description) {
            this.description = description;
            return this;
        }
        public RetailClassBuilder specializations(List<Specialization> specializations) {
            this.specializations = specializations;
            return this;
        }
        public RetailClassBuilder talents(List<Talent> talents) {
            this.talents = talents;
            return this;
        }
        public RetailClassBuilder spells(List<Spell> spells) {
            this.spells = spells;
            return this;
        }
        public RetailClass build() {
            return new RetailClass(this);
        }

    }
}
