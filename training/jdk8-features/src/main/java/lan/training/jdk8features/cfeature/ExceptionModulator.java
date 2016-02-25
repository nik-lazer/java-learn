package lan.training.jdk8features.cfeature;

/**
 * Created by nik-lazer on 2/24/2016.
 */
public interface ExceptionModulator<T, R> {
    R modulate(T t) throws ModulatorCheckedException;
}
