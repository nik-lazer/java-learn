package lan.training.jdk8features.cfeature;

import lan.training.jdk8features.function.OperationData;
import lan.training.jdk8features.function.OperationType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 2/24/2016.
 */
public class CompletableFeatureTest {
    private CompletableFutureModulationEngine engine = new CompletableFutureModulationEngine();

    @Test
    public void simpleTest() {
        OperationData operationData = new OperationData(null, new OperationType(1L), 0);
        assertEquals(2.2, engine.processData(operationData), 0.1);
    }

    @Test
    public void problemTest() {
        OperationData operationData = new OperationData(null, new OperationType(-1L), 0);
        assertEquals(0, engine.processData(operationData), 0.1);
    }

    @Test
    public void simpleCheckedTest() {
        OperationData operationData = new OperationData(null, new OperationType(1L), 0);
        assertEquals(2.2, engine.processCheckedData(operationData), 0.1);
    }

    @Test
    public void problemCheckedTest() {
        OperationData operationData = new OperationData(null, new OperationType(-1L), 0);
        assertEquals(0, engine.processCheckedData(operationData), 0.1);
    }
}
