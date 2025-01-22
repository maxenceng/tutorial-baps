package tutorial.baps.domain;

import java.util.ArrayList;
import java.util.List;
import tutorial.baps.assertion.Assert;

public class TalentTree {

    private final List<Talent> classTree;
    private final List<Talent> specTree;

    private TalentTree(TalentTreeBuilder builder) {

        if (List.of().equals(builder.classTree)) {
            Assert.notEmpty("SpecTree", builder.specTree);
        }
        if (List.of().equals(builder.specTree)) {
            Assert.notEmpty("Tree", builder.classTree);
        }
        this.classTree = builder.classTree;
        this.specTree = builder.specTree;

    }

    public List<Talent> getClassTree() {
        return classTree;
    }

    public List<Talent> getSpecTree() {
        return specTree;
    }

    public static TalentTreeBuilder builder() {
        return new TalentTreeBuilder();
    }

    public static class TalentTreeBuilder {

        private List<Talent> classTree = new ArrayList<>();
        private List<Talent> specTree = new ArrayList<>();

        public TalentTreeBuilder() {
        }

        public TalentTreeBuilder classTree(List<Talent> classTree) {
            this.classTree = classTree;
            return this;
        }

        public TalentTreeBuilder specTree(List<Talent> specTree) {
            this.specTree = specTree;
            return this;
        }

        public TalentTree build() {
            return new TalentTree(this);
        }

    }
}