package lan.training.jdk8features.cfeature;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nik-lazer on 2/24/2016.
 */
public class EventRepository {
    public List<SomeEvent> getByType(long type) throws ModulatorRuntimeException {
        if (type <= 0) {
            throw new ModulatorRuntimeException("type must be above zero");
        }
        return Arrays.asList(new SomeEvent(type, 5, 1.1), new SomeEvent(type, 3, 1.2), new SomeEvent(type, 3, 1.0), new SomeEvent(type, 5, 2));
    }

    public List<SomeEvent> getByTypeStrict(long type) throws ModulatorCheckedException {
        if (type <= 0) {
            throw new ModulatorCheckedException("type must be above zero");
        }
        return Arrays.asList(new SomeEvent(type, 5, 1.1), new SomeEvent(type, 3, 1.2), new SomeEvent(type, 3, 1.0), new SomeEvent(type, 5, 2));
    }
}
