package tutorial.baps.response;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import tutorial.baps.domain.Spell;

/**
 * FIXME: Adapt this if needed
 */
@Schema(name = "Spell Response")
public record SpellResponse(
        @Parameter(name = "Name", example = "Ferocious Bite", required = true)
        String name,
        @Parameter(name = "Description", example = "Finishing move, damage based on combo points", required = true)
        String description,
        @Parameter(name = "Damage", example = "112")
        Long damage,
        @Parameter(name = "Heal", example = "298")
        Long heal,
        @Parameter(name = "Shield", example = "1405")
        Long shield,
        @Parameter(name = "Cooldown", example = "30")
        Long cooldown,
        @Parameter(name = "Is this spell active", example = "true", required = true)
        Boolean active,
        @Parameter(name = "Is this a passive", example = "true", required = true)
        @NotNull
        Boolean passive
) {
    public static SpellResponse from(Spell spell) {
        return new SpellResponse(
                spell.getName(),
                spell.getDescription(),
                spell.getDamage(),
                spell.getHeal(),
                spell.getShield(),
                spell.getCooldown(),
                spell.getActive(),
                spell.getPassive()
        );
    }
}
