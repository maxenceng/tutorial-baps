package tutorial.baps.service;

import java.util.List;
import java.util.stream.IntStream;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import tutorial.baps.domain.RetailClass;
import tutorial.baps.domain.Specialization;
import tutorial.baps.domain.Spell;
import tutorial.baps.domain.Talent;
import tutorial.baps.domain.TalentType;

public class DummyDataService {

    public DummyDataService() {
    }

    public List<Spell> generateSpells() {
        return IntStream.range(0, 10)
                .mapToObj(i -> generateSpell())
                .toList();
    }

    public Spell generateSpell() {
        return Spell.builder()
                .id(RandomUtils.secure().randomLong())
                .name(RandomStringUtils.secure().nextAlphanumeric(10))
                .description(RandomStringUtils.secure().nextAlphanumeric(10))
                .active(RandomUtils.secure().randomBoolean())
                .passive(RandomUtils.secure().randomBoolean())
                .damage(RandomUtils.secure().randomLong())
                .heal(RandomUtils.secure().randomLong())
                .shield(RandomUtils.secure().randomLong())
                .cooldown(RandomUtils.secure().randomLong())
                .build();
    }

    public List<Talent> generateSpecTalents() {
        return IntStream.range(0, 10)
                .mapToObj(i -> generateSpecTalent())
                .toList();
    }

    public List<Talent> generateClassTalents() {
        return IntStream.range(0, 10)
                .mapToObj(i -> generateClassTalent())
                .toList();
    }

    public Talent generateClassTalent() {
        return Talent.builder()
                .id(RandomUtils.secure().randomLong())
                .name(RandomStringUtils.secure().nextAlphanumeric(10))
                .description(RandomStringUtils.secure().nextAlphanumeric(10))
                .damage(RandomUtils.secure().randomLong())
                .heal(RandomUtils.secure().randomLong())
                .shield(RandomUtils.secure().randomLong())
                .cooldown(RandomUtils.secure().randomLong())
                .spell(generateSpell())
                .children(List.of(generateTalentWithoutChildren()))
                .type(TalentType.CLASS)
                .build();
    }

    public Talent generateSpecTalent() {
        return Talent.builder()
                .id(RandomUtils.secure().randomLong())
                .name(RandomStringUtils.secure().nextAlphanumeric(10))
                .description(RandomStringUtils.secure().nextAlphanumeric(10))
                .damage(RandomUtils.secure().randomLong())
                .heal(RandomUtils.secure().randomLong())
                .shield(RandomUtils.secure().randomLong())
                .cooldown(RandomUtils.secure().randomLong())
                .spell(generateSpell())
                .children(List.of(generateTalentWithoutChildren()))
                .type(TalentType.SPEC)
                .build();
    }

    public Talent generateTalentWithoutChildren() {
        return Talent.builder()
                .id(RandomUtils.secure().randomLong())
                .name(RandomStringUtils.secure().nextAlphanumeric(10))
                .description(RandomStringUtils.secure().nextAlphanumeric(10))
                .damage(RandomUtils.secure().randomLong())
                .heal(RandomUtils.secure().randomLong())
                .shield(RandomUtils.secure().randomLong())
                .cooldown(RandomUtils.secure().randomLong())
                .spell(generateSpell())
                .build();
    }

    public List<Specialization> generateSpecializations(List<Long> ids) {
        return ids.stream()
                .map(this::generateSpecialization)
                .toList();
    }

    public Specialization generateSpecialization(Long id) {
        return Specialization.builder()
                .id(id)
                .name(RandomStringUtils.secure().nextAlphanumeric(10))
                .description(RandomStringUtils.secure().nextAlphanumeric(10))
                .talents(generateSpecTalents())
                .spells(generateSpells())
                .build();
    }

    public RetailClass generateRetailClass(Long id, List<Long> specIds) {
        return RetailClass.builder()
                .id(id)
                .name(RandomStringUtils.secure().nextAlphanumeric(10))
                .description(RandomStringUtils.secure().nextAlphanumeric(10))
                .talents(generateClassTalents())
                .spells(generateSpells())
                .specializations(generateSpecializations(specIds))
                .build();
    }
}
