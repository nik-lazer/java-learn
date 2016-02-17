package lan.training.jdk8features.function;

import java.util.Objects;
import java.util.function.Function;

/**
 * Created by nik-lazer on 2/15/2016.
 */
@FunctionalInterface
public interface Modulator<T, R> extends Function<T, R> {
    default <V> Modulator<V, R> modulate(Modulator<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }
}
