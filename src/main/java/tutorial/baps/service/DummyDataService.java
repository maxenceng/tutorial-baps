package tutorial.baps.service;

import java.util.List;
import java.util.stream.IntStream;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import tutorial.baps.domain.Spell;

// FIXME: Transform into a Spring service in Step 2
public class DummyDataService {

    public DummyDataService() {
    }
/*
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
                .heal(RandomUtils.secure().randomLong())
                .cooldown(RandomUtils.secure().randomLong())
                .build();
    }
/*
    public List<Talent> generateTalents() {
        return IntStream.range(0, 10)
                .mapToObj(i -> generateTalent())
                .toList();
    }

    public Talent generateTalent() {
        return Talent.builder()
                .id(RandomUtils.secure().randomLong())
                .name(RandomStringUtils.secure().nextAlphanumeric(10))
                .description(RandomStringUtils.secure().nextAlphanumeric(10))
                .damage(RandomUtils.secure().randomLong())
                .heal(RandomUtils.secure().randomLong())
                .heal(RandomUtils.secure().randomLong())
                .cooldown(RandomUtils.secure().randomLong())
                .spell(generateSpell())
                .children(List.of(generateTalentWithoutChildren()))
                .build();
    }

    public Talent generateTalentWithoutChildren() {
        return Talent.builder()
                .id(RandomUtils.secure().randomLong())
                .name(RandomStringUtils.secure().nextAlphanumeric(10))
                .description(RandomStringUtils.secure().nextAlphanumeric(10))
                .active(RandomUtils.secure().randomBoolean())
                .passive(RandomUtils.secure().randomBoolean())
                .damage(RandomUtils.secure().randomLong())
                .heal(RandomUtils.secure().randomLong())
                .heal(RandomUtils.secure().randomLong())
                .cooldown(RandomUtils.secure().randomLong())
                .build();
    }

    public List<Specialization> generateSpecializations() {
        return IntStream.range(0, 3)
                .mapToObj(i -> generateSpecialization())
                .toList();
    }
    public Specialization generateSpecialization() {
        return Specialization.builder()
                .id(RandomUtils.secure().randomLong())
                .name(RandomStringUtils.secure().nextAlphanumeric(10))
                .description(RandomStringUtils.secure().nextAlphanumeric(10))
                .talents(generateTalents())
                .spells(generateSpells())
                .build();
    }

    public List<RetailClass> generateRetailClasses() {
        return IntStream.range(0, 10)
                .mapToObj(i -> generateRetailClass())
                .toList();
    }

    public RetailClass generateRetailClass() {
        return RetailClass.builder()
                .id(RandomUtils.secure().randomLong())
                .name(RandomStringUtils.secure().nextAlphanumeric(10))
                .description(RandomStringUtils.secure().nextAlphanumeric(10))
                .talents(generateTalents())
                .spells(generateSpells())
                .specializations(generateSpecializations())
                .build();
    }

 */
}
