package tutorial.baps.domain;

import tutorial.baps.assertion.Assert;

public class Spell {

    private final Long id;
    private final String name;
    private final String description;
    private final Long damage;
    private final Long heal;
    private final Long shield;
    private final Long cooldown;
    private final Boolean active;
    private final Boolean passive;

    private Spell(SpellBuilder builder) {

        Assert.notNull("Id", builder.id);
        Assert.notBlank("Name", builder.name);
        Assert.notBlank("Description", builder.description);
        Assert.notNull("Active", builder.active);
        Assert.notNull("Passive", builder.passive);
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.damage = builder.damage;
        this.heal = builder.heal;
        this.shield = builder.shield;
        this.cooldown = builder.cooldown;
        this.active = builder.active;
        this.passive = builder.passive;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Long getDamage() { return damage; }
    public Long getHeal() { return heal; }
    public Long getShield() { return shield; }
    public Long getCooldown() { return cooldown; }
    public Boolean getActive() { return active; }
    public Boolean getPassive() { return passive; }

    public static SpellBuilder builder() {
        return new SpellBuilder();
    }

    public static class SpellBuilder {

        private Long id;
        private String name;
        private String description;
        private Long damage;
        private Long heal;
        private Long shield;
        private Long cooldown;
        private Boolean active;
        private Boolean passive;

        private SpellBuilder() {}

        public SpellBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public SpellBuilder name(String name) {
            this.name = name;
            return this;
        }
        public SpellBuilder description(String description) {
            this.description = description;
            return this;
        }
        public SpellBuilder damage(Long damage) {
            this.damage = damage;
            return this;
        }
        public SpellBuilder heal(Long heal) {
            this.heal = heal;
            return this;
        }
        public SpellBuilder shield(Long shield) {
            this.shield = shield;
            return this;
        }
        public SpellBuilder cooldown(Long cooldown) {
            this.cooldown = cooldown;
            return this;
        }
        public SpellBuilder active(Boolean active) {
            this.active = active;
            return this;
        }
        public SpellBuilder passive(Boolean passive) {
            this.passive = passive;
            return this;
        }

        public Spell build() {
            return new Spell(this);
        }
    }
}
