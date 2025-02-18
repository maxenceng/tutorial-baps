package tutorial.baps.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import tutorial.baps.domain.Talent;
import tutorial.baps.domain.TalentType;

/**
 * FIXME: Adapt this if needed
 */
@Schema(name = "Talent Request")
public record TalentRequest(
        @Parameter(name = "Name", example = "Tiger's Fury", required = true)
        @NotBlank
        String name,
        @Parameter(name = "Description", example = "Restores 50 energy, increases damage on all attacks by 15%, lasts 10s", required = true)
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
        @Parameter(name = "Spell linked to this talent")
        @Valid
        SpellRequest spell,
        @Parameter(name = "Type", required = true)
        TalentType type,
        @Parameter(name = "Linked children talents")
        @Valid
        List<TalentRequest> children
) {
    public Talent toDomain() {
        return Talent.builder()
                .id(-5L)
                .name(name)
                .description(description)
                .damage(damage)
                .heal(heal)
                .shield(shield)
                .cooldown(cooldown)
                .spell(spell.toDomain())
                .type(type)
                .children(children.stream()
                        .map(TalentRequest::toDomain)
                        .toList()
                )
                .build();
    }
}
