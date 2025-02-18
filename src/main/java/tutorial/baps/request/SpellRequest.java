package tutorial.baps.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tutorial.baps.domain.Spell;

/**
 * FIXME: Adapt this if needed
 */
@Schema(name = "Spell Request")
public record SpellRequest(
        @Parameter(name = "Name", example = "Ferocious Bite", required = true)
        @NotBlank
        String name,
        @Parameter(name = "Description", example = "Finishing move, damage based on combo points", required = true)
        @NotBlank
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
        @NotNull
        Boolean active,
        @Parameter(name = "Is this a passive", example = "true", required = true)
        @NotNull
        Boolean passive
) {
    public Spell toDomain() {
        return Spell.builder()
                .id(-5L)
                .name(name)
                .description(description)
                .damage(damage)
                .heal(heal)
                .shield(shield)
                .cooldown(cooldown)
                .active(active)
                .passive(passive)
                .build();
    }
}
