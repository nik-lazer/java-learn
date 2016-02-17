package lan.training.jdk8features.function;

/**
 * Created by nik-lazer on 2/11/2016.
 */
public class FullModulationEngine {
    private static String AWESOME_PLACE = "Berlin";
    private static long AWESOME_CODE = 54L;

    private static FullModulator<OperationData, OperationData> locationModulator = data -> {
        // Berlin is cool
        double factor = (data.getLocation().getLocation().equals(AWESOME_PLACE)?data.getFactor() * 1.1:data.getFactor());
        return OperationData.of(data.getLocation(), data.getType(), factor);
    };
    private static FullModulator<OperationData, OperationData> typeModulator = data -> {
        double factor = (data.getType().getId().equals(AWESOME_CODE)?data.getFactor()+1:data.getFactor());
        return OperationData.of(data.getLocation(), data.getType(), factor);
    };
    private static FullModulator<OperationData, Double> aggregatorModulator = data -> data.getFactor();

    public double processAndThenData(OperationData operationData) {
        Double result = locationModulator // calls first
                .andThenModulate(typeModulator) // calls second
                .andThenModulate(aggregatorModulator) // calls third
                .modulate(operationData);
        return result;
    }

    public double processComposedData(OperationData operationData) {
        Double result = aggregatorModulator  // calls third
                .composeModulator(typeModulator) // calls second
                .composeModulator(locationModulator) // calls first
                .modulate(operationData);
        return result;
    }
}
