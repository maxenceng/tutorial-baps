package tutorial.baps.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tutorial.baps.assertion.MissingMandatoryValueException;
import tutorial.baps.domain.fixture.TalentFixture;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static tutorial.baps.domain.fixture.TalentFixture.talent;
import static tutorial.baps.domain.fixture.TalentFixture.talentMinimal;
import static tutorial.baps.domain.fixture.TalentFixture.talentMinimalBuilder;

public class TalentUnitTest {

    @DisplayName("should throw MissingMandatoryValueException if every attribute is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfEveryAttributeIsNull() {
        assertThatThrownBy(() -> Talent.builder().build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if name is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfNameIsNull() {
        assertThatThrownBy(() -> talentMinimalBuilder()
                .name(null)
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if name is blank")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfNameIsBlank() {
        assertThatThrownBy(() -> talentMinimalBuilder()
                .name("")
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if description is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfDescriptionIsNull() {
        assertThatThrownBy(() -> talentMinimalBuilder()
                .description(null)
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if description is blank")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfDescriptionIsBlank() {
        assertThatThrownBy(() -> talentMinimalBuilder()
                .description("")
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if type is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfTypeIsNull() {
        assertThatThrownBy(() -> talentMinimalBuilder()
                .type(null)
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("Should build with the minimal Talent build")
    @Test
    void shouldBuildWithMinimalTalentBuild() {
        assertThatCode(TalentFixture::talentMinimal).doesNotThrowAnyException();
    }

    @DisplayName("Should build with the full talent build")
    @Test
    void shouldBuildWitFullTalentBuild() {
        assertThatCode(TalentFixture::talent).doesNotThrowAnyException();
    }

    @DisplayName("All required attributes are filled correctly")
    @Test
    void shouldFillAllRequiredAttributesCorrectly() {
        Talent talentToVerify = talentMinimal();

        assertThat(talentToVerify.getId()).isNotNull();
        assertThat(talentToVerify.getId()).isNotEqualTo(0L);
        assertThat(talentToVerify.getName()).isNotNull();
        assertThat(talentToVerify.getDescription()).isNotNull();
        assertThat(talentToVerify.getType()).isNotNull();
        assertThat(talentToVerify.getChildren()).isEmpty();
    }

    @DisplayName("All attributes are filled correctly")
    @Test
    void shouldFillAllAttributesCorrectly() {
        Talent talentToVerify = talent();

        assertThat(talentToVerify.getId()).isNotNull();
        assertThat(talentToVerify.getId()).isNotEqualTo(0L);
        assertThat(talentToVerify.getName()).isNotNull();
        assertThat(talentToVerify.getDescription()).isNotNull();
        assertThat(talentToVerify.getType()).isNotNull();
        assertThat(talentToVerify.getDamage()).isNotNull();
        assertThat(talentToVerify.getHeal()).isNotNull();
        assertThat(talentToVerify.getShield()).isNotNull();
        assertThat(talentToVerify.getCooldown()).isNotNull();
        assertThat(talentToVerify.getChildren()).hasSize(2);
    }
}
