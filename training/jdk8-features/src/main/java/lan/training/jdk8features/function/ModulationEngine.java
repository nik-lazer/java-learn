package lan.training.jdk8features.function;

import java.util.function.Function;

/**
 * Created by nik-lazer on 2/11/2016.
 */
public class ModulationEngine {
    private static String AWESOME_PLACE = "Berlin";
    private static long AWESOME_CODE = 54L;

    private static Function<OperationData, OperationData> locationModulator = data -> {
        // Berlin is cool
        double factor = (data.getLocation().getLocation().equals(AWESOME_PLACE)?data.getFactor() * 1.1:data.getFactor());
        return OperationData.of(data.getLocation(), data.getType(), factor);
    };
    private static Function<OperationData, OperationData> typeModulator = data -> {
        double factor = (data.getType().getId().equals(AWESOME_CODE)?data.getFactor()+1:data.getFactor());
        return OperationData.of(data.getLocation(), data.getType(), factor);
    };
    private static Function<OperationData, Double> aggregatorModulator = data -> data.getFactor();

    public double processAndThenData(OperationData operationData) {
        Double result = locationModulator // calls first
                .andThen(typeModulator) // calls second
                .andThen(aggregatorModulator) // calls third
                .apply(operationData);
        return result;
    }

    public double processComposedData(OperationData operationData) {
        Double result = aggregatorModulator  // calls third
                .compose(typeModulator) // calls second
                .compose(locationModulator) // calls first
                .apply(operationData);
        return result;
    }
}
