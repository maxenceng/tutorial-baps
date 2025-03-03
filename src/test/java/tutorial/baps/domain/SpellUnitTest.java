package tutorial.baps.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tutorial.baps.assertion.MissingMandatoryValueException;
import tutorial.baps.domain.fixture.SpellFixture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static tutorial.baps.domain.fixture.SpellFixture.spell;
import static tutorial.baps.domain.fixture.SpellFixture.spellMinimal;
import static tutorial.baps.domain.fixture.SpellFixture.spellMinimalBuilder;

public class SpellUnitTest {
    @DisplayName("should throw MissingMandatoryValueException if every attribute is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfEveryAttributeIsNull() {
        assertThatThrownBy(() -> Spell.builder().build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if name is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfNameIsNull() {
        assertThatThrownBy(() -> spellMinimalBuilder()
                .name(null)
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if name is blank")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfNameIsBlank() {
        assertThatThrownBy(() -> spellMinimalBuilder()
                .name("")
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if description is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfDescriptionIsNull() {
        assertThatThrownBy(() -> spellMinimalBuilder()
                .description(null)
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if description is blank")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfDescriptionIsBlank() {
        assertThatThrownBy(() -> spellMinimalBuilder()
                .description("")
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("Should build with the minimal spell build")
    @Test
    void shouldBuildWithMinimalSpellBuild() {
        assertThatCode(SpellFixture::spellMinimal).doesNotThrowAnyException();
    }

    @DisplayName("Should build with the full spell build")
    @Test
    void shouldBuildWitFullSpellBuild() {
        assertThatCode(SpellFixture::spell).doesNotThrowAnyException();
    }

    @DisplayName("All required attributes are filled correctly")
    @Test
    void shouldFillAllRequiredAttributesCorrectly() {
        Spell spellToVerify = spellMinimal();

        assertThat(spellToVerify.getId()).isNotNull();
        assertThat(spellToVerify.getId()).isNotEqualTo(0L);
        assertThat(spellToVerify.getName()).isNotNull();
        assertThat(spellToVerify.getDescription()).isNotNull();
        assertThat(spellToVerify.getActive()).isTrue();
        assertThat(spellToVerify.getPassive()).isTrue();
    }

    @DisplayName("All attributes are filled correctly")
    @Test
    void shouldFillAllAttributesCorrectly() {
        Spell spellToVerify = spell();

        assertThat(spellToVerify.getId()).isNotNull();
        assertThat(spellToVerify.getId()).isNotEqualTo(0L);
        assertThat(spellToVerify.getName()).isNotNull();
        assertThat(spellToVerify.getDescription()).isNotNull();
        assertThat(spellToVerify.getActive()).isTrue();
        assertThat(spellToVerify.getPassive()).isTrue();
        assertThat(spellToVerify.getDamage()).isNotNull();
        assertThat(spellToVerify.getHeal()).isNotNull();
        assertThat(spellToVerify.getShield()).isNotNull();
        assertThat(spellToVerify.getCooldown()).isNotNull();
    }
}
