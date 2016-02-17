package lan.training.jdk8features.function;

import java.util.Objects;

/**
 * Created by nik-lazer on 2/17/2016.
 */
@FunctionalInterface
public interface FullModulator<T, R> {
    R modulate(T t);

    default <V> FullModulator<V, R> composeModulator(FullModulator<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> modulate(before.modulate(v));
    }

    default <V> FullModulator<T, V> andThenModulate(FullModulator<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.modulate(modulate(t));
    }
}
