package lan.training.jdk8features.stream;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by nik-lazer on 2/5/2016.
 */
public class SubModel {
    private String subField;
    private List<SubSubModel> subSubModels;

    public SubModel(String subField, List<SubSubModel> subSubModels) {
        this.subField = subField;
        this.subSubModels = subSubModels;
    }

    public String getSubField() {
        return subField;
    }

    public List<SubSubModel> getSubSubModels() {
        return subSubModels;
    }

    public boolean isSuitable(Predicate<SubSubModel> predicate) {
        return subSubModels.stream().anyMatch(predicate);
    }
}
