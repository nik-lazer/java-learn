package lan.training.jdk8features.cfeature;

import lan.training.jdk8features.function.OperationData;

import java.util.OptionalInt;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executors;

/**
 * Created by nik-lazer on 2/24/2016.
 */
public class CompletableFutureModulationEngine {
    private EventRepository eventRepository = new EventRepository();
    public double processData(OperationData operationData) {
        CompletableFuture<Double> cf3 = CompletableFuture
                .supplyAsync(() -> eventRepository.getByType(operationData.getType().getId()), Executors.newSingleThreadExecutor())
                .thenApplyAsync(someEvents -> {
                    OptionalInt max = someEvents.stream().mapToInt(value -> value.getLevel()).max();
                    return someEvents.stream().filter(someEvent -> someEvent.getLevel() == max.getAsInt());
                })
                .thenApply(someEventStream -> someEventStream.mapToDouble(value -> value.getFactor()))
                .thenApply(doubleStream -> doubleStream.reduce(1, (left, right) -> left * right))
                .exceptionally(throwable -> {
                    System.out.println(throwable.getMessage());
                    return 0.0;
                });
        return cf3.join();
    }

    public double processCheckedData(OperationData operationData) {
        CompletableFuture<Double> cf3 = new CompletableFuture();
        cf3.supplyAsync(() -> {
                    try {
                        return eventRepository.getByTypeStrict(operationData.getType().getId());
                    } catch (ModulatorCheckedException e) {
                        e.printStackTrace();
                        throw new CompletionException(e);
                    }
                }, Executors.newSingleThreadExecutor())
                .thenApplyAsync(someEvents -> {
                    OptionalInt max = someEvents.stream().mapToInt(value -> value.getLevel()).max();
                    return someEvents.stream().filter(someEvent -> someEvent.getLevel() == max.getAsInt());
                })
                .thenApply(someEventStream -> someEventStream.mapToDouble(value -> value.getFactor()))
                .thenApply(doubleStream -> doubleStream.reduce(1, (left, right) -> left * right))
                .whenComplete((aDouble, throwable) -> {
                    if (throwable == null) {
                        cf3.complete(aDouble);
                    } else {
                        cf3.complete(0.0);
                    }
        });
        return cf3.join();
    }
}
