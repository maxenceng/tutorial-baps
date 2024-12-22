package tutorial.baps.service;

import tutorial.baps.domain.Specialization;
import tutorial.baps.domain.TalentTree;
import tutorial.baps.domain.RetailClass;

public class TalentTreeService {



    public TalentTreeService() {}

    public TalentTree getTalentTrees(Long classId, Long specId, TalentTreeFilter Filter) {

        // Appeler Max c'est le delbor
        TalentTree NewTree;

        for (RetailClass retailClass : AllRetailClasses) {
            if (retailClass.getId().equals(classId)) {
                for (Specialization specialization : AllSpecializations) {
                    if (specialization.getId().equals(specId)){
                        NewTree.classTree = retailClass.talents;
                        NewTree.specTree = specialization.talents;
                        return NewTree;
                    }
                }
            }
        }

        if (Filter == TalentTreeFilter.ALL) {}

        if (Filter == TalentTreeFilter.CLASS) {}

        if (Filter == TalentTreeFilter.SPECIALIZATION) {}
    }
}
