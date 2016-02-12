package lan.training.jdk8features.function;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 2/11/2016.
 */
public class ModulatorEngineTest {
    private ModulationEngine modulationEngine = new ModulationEngine();
    @Test
    public void equalityTest() {
        OperationData operationData = OperationData.of(OperationLocation.of("Berlin"), OperationType.of(54), 2);
        double andThen = modulationEngine.processAndThenData(operationData);
        double composed = modulationEngine.processComposedData(operationData);
        assertEquals(andThen, composed, 0.1);
        assertEquals(3.2, andThen,0.1);
    }

    @Test
    public void otherTest() {
        OperationData operationData = OperationData.of(OperationLocation.of("London"), OperationType.of(54), 2);
        double andThen = modulationEngine.processAndThenData(operationData);
        double composed = modulationEngine.processComposedData(operationData);
        assertEquals(andThen, composed, 0.1);
        assertEquals(3, andThen,0.1);
    }
}
