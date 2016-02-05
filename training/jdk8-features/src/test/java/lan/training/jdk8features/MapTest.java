package lan.training.jdk8features;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by nik-lazer on 2/4/2016.
 */
public class MapTest {
    private Map<Integer, String> map;
    @Before
    public void init() {
        map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((id, val) -> System.out.println(id + "->" + val));
    }

    @Test
    public void changeTest() {
        map.computeIfPresent(3, (num, val) -> val + num);
        assertEquals("val33", map.get(3));

        map.computeIfPresent(9, (num, val) -> null);
        assertFalse(map.containsKey(9));

        map.computeIfAbsent(23, num -> "val" + num);
        assertTrue(map.containsKey(23));
        assertEquals("val23", map.get(23));

        map.computeIfAbsent(3, num -> "bam");
        assertEquals("val33", map.get(3));

        map.remove(3, "val3");
        assertTrue(map.containsKey(3));
        assertEquals("val33", map.get(3));

        map.remove(3, "val33");
        assertNull(map.get(3));

        assertEquals("not found", map.getOrDefault(42, "not found"));

        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        assertEquals("val9", map.get(9));

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        assertEquals("val9concat", map.get(9));
    }
}
