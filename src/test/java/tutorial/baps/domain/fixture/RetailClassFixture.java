package tutorial.baps.domain.fixture;

import java.util.List;
import tutorial.baps.domain.RetailClass;
import tutorial.baps.domain.RetailClass.RetailClassBuilder;

import static tutorial.baps.domain.fixture.SpecializationFixture.specialization;
import static tutorial.baps.domain.fixture.SpecializationFixture.specializationBuilder;
import static tutorial.baps.domain.fixture.SpellFixture.spell;
import static tutorial.baps.domain.fixture.SpellFixture.spellMinimal;
import static tutorial.baps.domain.fixture.TalentFixture.talent;
import static tutorial.baps.domain.fixture.TalentFixture.talentMinimal;

public final class RetailClassFixture {
    public static RetailClassBuilder retailClassBuilder() {
        return RetailClass.builder()
                .id(1L)
                .name("talentName")
                .description("talentDescription")
                .talents(List.of(talentMinimal(), talent()))
                .spells(List.of(spellMinimal(), spell()))
                .specializations(List.of(specialization(), specializationBuilder().id(2L).build()));
    }

    public static RetailClass retailClass() {
        return retailClassBuilder().build();
    }
}
