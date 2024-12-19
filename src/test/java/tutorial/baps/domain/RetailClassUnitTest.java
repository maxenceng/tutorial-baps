/*
package tutorial.baps.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tutorial.baps.assertion.MissingMandatoryValueException;
import tutorial.baps.domain.fixture.RetailClassFixture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static tutorial.baps.domain.fixture.RetailClassFixture.retailClass;
import static tutorial.baps.domain.fixture.RetailClassFixture.retailClassBuilder;

// Class is a reserved keyword, you have to name it something else, RetailClass fits here
class RetailClassUnitTest {

    @DisplayName("should throw MissingMandatoryValueException if every attribute is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfEveryAttributeIsNull() {
        assertThatThrownBy(() -> RetailClass.builder().build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if name is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfNameIsNull() {
        assertThatThrownBy(() -> retailClassBuilder()
                .name(null)
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if name is blank")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfNameIsBlank() {
        assertThatThrownBy(() -> RetailClassBuilder()
                .name("")
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if description is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfDescriptionIsNull() {
        assertThatThrownBy(() -> RetailClassBuilder()
                .description(null)
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if description is blank")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfDescriptionIsBlank() {
        assertThatThrownBy(() -> RetailClassBuilder()
                .description("")
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if talents is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfTalentsIsNull() {
        assertThatThrownBy(() -> RetailClassBuilder()
                .talents(null)
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if talents is empty")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfTalentsIsEmpty() {
        assertThatThrownBy(() -> RetailClassBuilder()
                .talents(List.of())
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if spells is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfSpellsIsNull() {
        assertThatThrownBy(() -> RetailClassBuilder()
                .spells(null)
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("should throw MissingMandatoryValueException if spells is empty")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfSpellsIsEmpty() {
        assertThatThrownBy(() -> RetailClassBuilder()
                .spells(List.of())
                .build())
                .isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("Should build with the full retailClass build")
    @Test
    void shouldBuildWitFullRetailClassBuild() {
        assertThatCode(RetailClassFixture::retailClass).doesNotThrowAnyException();
    }

    @DisplayName("All required attributes are filled correctly")
    @Test
    void shouldFillAllRequiredAttributesCorrectly() {
        RetailClass retailClassToVerify = retailClass();

        assertThat(retailClassToVerify.getId()).isNotNull();
        assertThat(retailClassToVerify.getId()).isNotEqualTo(0L);
        assertThat(retailClassToVerify.getName()).isNotNull();
        assertThat(retailClassToVerify.getDescription()).isNotNull();
        assertThat(retailClassToVerify.getTalents()).isNotNull();
        assertThat(retailClassToVerify.getTalents()).hasSize(2);
        assertThat(retailClassToVerify.getSpells()).isNotNull();
        assertThat(retailClassToVerify.getSpells()).hasSize(2);
        assertThat(retailClassToVerify.getSpecializations()).isNotNull();
        assertThat(retailClassToVerify.getSpecializations()).hasSize(2);
    }
}

 */
