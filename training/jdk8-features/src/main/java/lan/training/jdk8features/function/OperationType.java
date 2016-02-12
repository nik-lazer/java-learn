package lan.training.jdk8features.function;

/**
 * Created by nik-lazer on 2/11/2016.
 */
public class OperationType {
    private Long id;

    public OperationType(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public static OperationType of(long id) {
        return new OperationType(id);
    }
}
