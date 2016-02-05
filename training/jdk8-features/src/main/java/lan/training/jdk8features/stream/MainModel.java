package lan.training.jdk8features.stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by nik-lazer on 2/5/2016.
 */
public class MainModel {
    private String mainField;
    private int value;
    private List<SubModel> subModels;

    public MainModel(String mainField, int value, List<SubModel> subModels) {
        this.mainField = mainField;
        this.value = value;
        this.subModels = subModels;
    }

    public String getMainField() {
        return mainField;
    }

    public List<SubModel> getSubModels() {
        return subModels;
    }

    public int getValue() {
        return value;
    }

    public boolean isSuitable(Predicate<SubModel> predicate) {
        return subModels.stream().anyMatch(predicate);
    }
}
