package tutorial.baps.response;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import tutorial.baps.domain.Talent;
import tutorial.baps.domain.TalentType;

/**
 * FIXME: Adapt this if needed
 */
@Schema(name = "Talent Response")
public record TalentResponse(
        @Parameter(name = "Name", example = "Tiger's Fury", required = true)
        String name,
        @Parameter(name = "Description", example = "Restores 50 energy, increases damage on all attacks by 15%, lasts 10s", required = true)
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
        SpellResponse spell,
        @Parameter(name = "Type", required = true)
        TalentType type,
        @Parameter(name = "Linked children talents")
        List<TalentResponse> children
) {
    public static TalentResponse from(Talent talent) {
        return new TalentResponse(
                talent.getName(),
                talent.getDescription(),
                talent.getDamage(),
                talent.getHeal(),
                talent.getShield(),
                talent.getCooldown(),
                SpellResponse.from(talent.getSpell()),
                talent.getType(),
                talent.getChildren().stream().map(TalentResponse::from).toList()
        );
    }
}
