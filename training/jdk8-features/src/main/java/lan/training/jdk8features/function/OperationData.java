package lan.training.jdk8features.function;

/**
 * Created by nik-lazer on 2/11/2016.
 */
public class OperationData {
    private OperationLocation location;
    private OperationType type;
    private double factor = 1;

    public OperationData(OperationLocation location, OperationType type, double factor) {
        this.location = location;
        this.type = type;
        this.factor = factor;
    }

    public OperationLocation getLocation() {
        return location;
    }

    public OperationType getType() {
        return type;
    }

    public double getFactor() {
        return factor;
    }

    public static OperationData of(OperationLocation location, OperationType type, double factor) {
        return new OperationData(location, type, factor);
    }
}
