package lan.training.format;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by nik-lazer on 3/28/2016.
 */
public class NumberFormatTest {
    @Test
    public void apostropheTest() {
        double number = 123456.45;
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();
        formatSymbols.setGroupingSeparator('\'');
        DecimalFormat format = new DecimalFormat("###,###.###", formatSymbols);
        String formatted = format.format(number);
        assertEquals("123'456.45", formatted);
    }
}
