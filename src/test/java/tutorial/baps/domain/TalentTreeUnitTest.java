/*
package tutorial.baps.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tutorial.baps.assertion.MissingMandatoryValueException;
import tutorial.baps.domain.fixture.TalentTreeFixture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static tutorial.baps.domain.fixture.TalentTreeFixture.talentTree;
import static tutorial.baps.domain.fixture.TalentTreeFixture.talentTreeBuilder;

public class TalentTreeUnitTest {

    @DisplayName("Should throw MissingMandatoryValueException if every attribute is null")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfEveryAttributeIsNull() {
        assertThatThrownBy(() -> TalentTree.builder().build()).isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("Should throw MissingMandatoryValueException if every attribute is empty")
    @Test
    void shouldThrowMissingMandatoryValueExceptionIfEveryAttributeIsEmpty() {
        assertThatThrownBy(() -> TalentTree.builder()
                .classTree(List.of())
                .specTree(List.of())
                .build()).isExactlyInstanceOf(MissingMandatoryValueException.class);
    }

    @DisplayName("Should build if classTree is not empty")
    @Test
    void shouldBuildIfClassTreeIsNotEmpty() {
        assertThatCode(() -> talentTreeBuilder()
                .specTree(List.of())
                .build()).doesNotThrowAnyException();
    }

    @DisplayName("Should build if specTree is not empty")
    @Test
    void shouldBuildIfClassTreeIsNotEmpty() {
        assertThatCode(() -> talentTreeBuilder()
                .classTree(List.of())
                .build()).doesNotThrowAnyException();
    }

    @DisplayName("Should build if every attribute is filled")
    @Test
    void shouldBuildIfEveryAttributeIsFilled() {
        assertThatCode(TalentTreeFixture::talentTree).doesNotThrowAnyException();
    }

    @DisplayName("All attributes are filled correctly")
    @Test
    void shouldFillAllAttributesCorrectly() {
        TalentTree talentTreeToVerify = talentTree();

        assertThat(talentTreeToVerify.getClassTree()).isNotNull();
        assertThat(talentTreeToVerify.getClassTree()).isNotEmpty();
        assertThat(talentTreeToVerify.getSpecTree()).isNotNull();
        assertThat(talentTreeToVerify.getSpecTree()).isNotEmpty();
    }
}
*/