package tutorial.baps.domain.fixture;

import java.util.List;
import tutorial.baps.domain.TalentTree;
import tutorial.baps.domain.TalentTree.TalentTreeBuilder;

import static tutorial.baps.domain.fixture.TalentFixture.talent;

public final class TalentTreeFixture {
    public static TalentTreeBuilder talentTreeBuilder() {
        return TalentTree.builder()
                .classTree(List.of(talent()))
                .specTree(List.of(talent()));
    }

    public static TalentTree talentTree() {
        return talentTreeBuilder().build();
    }
}
