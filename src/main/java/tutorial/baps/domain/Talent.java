package tutorial.baps.domain;

import java.util.ArrayList;
import java.util.List;
import tutorial.baps.assertion.Assert;

public class Talent {

    private final Long id;
    private final String name;
    private final String description;
    private final Long damage;
    private final Long heal;
    private final Long shield;
    private final Long cooldown;
    private final Spell spell;
    private final TalentType type;
    private final List<Talent> children;

    private Talent(TalentBuilder builder) {

        Assert.notNull("Id", builder.id);
        Assert.notBlank("Name", builder.name);
        Assert.notBlank("Description", builder.description);
        Assert.notNull("Type", builder.type);
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.damage = builder.damage;
        this.heal = builder.heal;
        this.shield = builder.shield;
        this.cooldown = builder.cooldown;
        this.spell = builder.spell;
        this.type = builder.type;
        this.children = builder.children;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getDamage() {
        return damage;
    }

    public Long getHeal() {
        return heal;
    }

    public Long getShield() {
        return shield;
    }

    public Long getCooldown() {
        return cooldown;
    }

    public Spell getSpell() {
        return spell;
    }

    public TalentType getType() {
        return type;
    }

    public List<Talent> getChildren() {
        return children;
    }

    public static TalentBuilder builder() {
        return new TalentBuilder();
    }

    public static class TalentBuilder {

        private Long id;
        private String name;
        private String description;
        private Long damage;
        private Long heal;
        private Long shield;
        private Long cooldown;
        private Spell spell;
        private TalentType type;
        private List<Talent> children = new ArrayList<>();

        public TalentBuilder() {
        }

        public TalentBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TalentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TalentBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TalentBuilder damage(Long damage) {
            this.damage = damage;
            return this;
        }

        public TalentBuilder heal(Long heal) {
            this.heal = heal;
            return this;
        }

        public TalentBuilder shield(Long shield) {
            this.shield = shield;
            return this;
        }

        public TalentBuilder cooldown(Long cooldown) {
            this.cooldown = cooldown;
            return this;
        }

        public TalentBuilder spell(Spell spell) {
            this.spell = spell;
            return this;
        }

        public TalentBuilder type(TalentType type) {
            this.type = type;
            return this;
        }

        public TalentBuilder children(List<Talent> children) {
            this.children = children;
            return this;
        }

        public Talent build() {
            return new Talent(this);
        }
    }
}
