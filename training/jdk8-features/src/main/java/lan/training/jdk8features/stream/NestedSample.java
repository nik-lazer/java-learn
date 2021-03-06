package lan.training.jdk8features.stream;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by nik-lazer on 2/5/2016.
 */
public class NestedSample {
    public String getByLoops(List<MainModel> mainModelList, MainModel cMainModel, SubModel cSubModel, SubSubModel cSubSubModel) {
        String result = "";
        for (MainModel mainModel: mainModelList) {
            if (mainModel.getMainField().equals(cMainModel.getMainField())) {
                for (SubModel subModel: mainModel.getSubModels()) {
                    if (subModel.getSubField().equals(cSubModel.getSubField())) {
                        for (SubSubModel subSubModel: subModel.getSubSubModels()) {
                            if (subSubModel.getSubSubField().equals(cSubSubModel.getSubSubField())) {
                                result += mainModel.getMainField() + "[" + mainModel.getValue() + "]";
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public String getByStraightStreams(List<MainModel> mainModelList, MainModel cMainModel, SubModel cSubModel, SubSubModel cSubSubModel) {
        StringBuilder newResult = new StringBuilder();
        mainModelList.stream()
                .filter(mainModel -> mainModel.getMainField().equals(cMainModel.getMainField()))
                .filter(mainModel3 -> mainModel3.getSubModels().stream().filter(
                        subModel1 -> subModel1.getSubField().equals(cSubModel.getSubField())).anyMatch(
                        subModel2 -> subModel2.getSubSubModels().stream().anyMatch(
                                subSubModel -> subSubModel.getSubSubField().equals(cSubSubModel.getSubSubField()))))
                .forEach(mainModel1 -> newResult.append(mainModel1.getMainField() + "[" + mainModel1.getValue() + "]"));
        return newResult.toString();
    }

    public String getBySimplerStreams(List<MainModel> mainModelList, MainModel cMainModel, SubModel cSubModel, SubSubModel cSubSubModel) {
        StringBuilder newResult = new StringBuilder();
        mainModelList.stream()
                .filter(mainModel -> mainModel.getMainField().equals(cMainModel.getMainField()))
                .filter(mainModel3 -> mainModel3.isSuitable(
                        subModel2 -> subModel2.getSubField().equals(cSubModel.getSubField())
                                && subModel2.isSuitable(subSubModel -> subSubModel.getSubSubField().equals(cSubSubModel.getSubSubField()))))
                .forEach(getPrintConsumer(newResult));
        return newResult.toString();
    }

    private Consumer<MainModel> getPrintConsumer(StringBuilder stringBuilder) {
        return mainModel -> stringBuilder.append(mainModel.getMainField() + "[" + mainModel.getValue() + "]");
    }
}
