package lan.training.jdk8features.cfeature;

/**
 * Created by nik-lazer on 2/24/2016.
 */
public class SomeEvent {
    private long type;
    private int level;
    private double factor;

    public SomeEvent(long type, int level, double factor) {
        this.type = type;
        this.level = level;
        this.factor = factor;
    }

    public long getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public double getFactor() {
        return factor;
    }
}
