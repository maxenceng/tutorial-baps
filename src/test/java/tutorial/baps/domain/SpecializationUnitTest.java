package tutorial.baps.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tutorial.baps.assertion.MissingMandatoryValueException;
import tutorial.baps.domain.fixture.SpecializationFixture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static tutorial.baps.domain.fixture.SpecializationFixture.specialization;
import static tutorial.baps.domain.fixture.SpecializationFixture.specializationBuilder;

public class SpecializationUnitTest {

    @DisplayName("should throw MissingMandatoryValueException if every attribute is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfEveryAttributeIsNull() {
        assertThatThrownBy(() -> Specialization.builder().build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if name is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfNameIsNull() {
        assertThatThrownBy(() -> specializationBuilder()
                .name(null)
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if name is blank")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfNameIsBlank() {
        assertThatThrownBy(() -> specializationBuilder()
                .name("")
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if description is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfDescriptionIsNull() {
        assertThatThrownBy(() -> specializationBuilder()
                .description(null)
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if description is blank")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfDescriptionIsBlank() {
        assertThatThrownBy(() -> specializationBuilder()
                .description("")
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if talents is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfTalentsIsNull() {
        assertThatThrownBy(() -> specializationBuilder()
                .talents(null)
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if talents is empty")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfTalentsIsEmpty() {
        assertThatThrownBy(() -> specializationBuilder()
                .talents(List.of())
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if spells is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfSpellsIsNull() {
        assertThatThrownBy(() -> specializationBuilder()
                .spells(null)
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if spells is empty")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfSpellsIsEmpty() {
        assertThatThrownBy(() -> specializationBuilder()
                .spells(List.of())
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("Should build with the full specialization build")
    @Test
    void shouldBuildWitFullSpecializationBuild() {
        assertThatCode(SpecializationFixture::specialization).doesNotThrowAnyException();
    }

    @DisplayName("All required attributes are filled correctly")
    @Test
    void shouldFillAllRequiredAttributesCorrectly() {
        Specialization specializationToVerify = specialization();

        assertThat(specializationToVerify.getId()).isNotNull();
        assertThat(specializationToVerify.getId()).isNotEqualTo(0L);
        assertThat(specializationToVerify.getName()).isNotNull();
        assertThat(specializationToVerify.getDescription()).isNotNull();
        assertThat(specializationToVerify.getTalents()).isNotNull();
        assertThat(specializationToVerify.getTalents()).hasSize(2);
        assertThat(specializationToVerify.getSpells()).isNotNull();
        assertThat(specializationToVerify.getSpells()).hasSize(2);
    }
}
