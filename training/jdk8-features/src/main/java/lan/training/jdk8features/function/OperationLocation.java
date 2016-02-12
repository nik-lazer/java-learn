package lan.training.jdk8features.function;

/**
 * Created by nik-lazer on 2/11/2016.
 */
public class OperationLocation {
    private String location;

    public OperationLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public static OperationLocation of(String location) {
        return new OperationLocation(location);
    }
}
