package tutorial.baps.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import tutorial.baps.domain.TalentTree;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class TalentTreeServiceUnitTest {

    @InjectMocks
    private TalentTreeService talentTreeService;

    @DisplayName("Should return both talent trees for class and spec")
    @Test
    void shouldReturnBothTalentTreesForClassAndSpec() {
        long classId = 1L;
        long specId = 1L;

        TalentTree talentTree = talentTreeService.getTalentTrees(classId, specId, TalentTreeFilter.ALL);

        assertThat(talentTree.getClassTree()).isNotEmpty();
        assertThat(talentTree.getSpecTree()).isNotEmpty();
    }

    @DisplayName("Should return only talent tree for class")
    @Test
    void shouldReturnOnlyTalentTreeForClass() {
        long classId = 1L;
        long specId = 1L;

        TalentTree talentTree = talentTreeService.getTalentTrees(classId, specId, TalentTreeFilter.CLASS);

        assertThat(talentTree.getClassTree()).isNotEmpty();
        assertThat(talentTree.getSpecTree()).isEmpty();
    }

    @DisplayName("Should return only talent tree for spec")
    @Test
    void shouldReturnOnlyTalentTreeForSpec() {
        long classId = 1L;
        long specId = 1L;

        TalentTree talentTree = talentTreeService.getTalentTrees(classId, specId, TalentTreeFilter.SPECIALIZATION);

        assertThat(talentTree.getClassTree()).isEmpty();
        assertThat(talentTree.getSpecTree()).isNotEmpty();
    }
}
