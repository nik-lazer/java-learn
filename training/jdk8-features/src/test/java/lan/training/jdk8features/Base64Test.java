package lan.training.jdk8features;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Base64;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 2/4/2016.
 */
public class Base64Test {
    private final String ENCODING_NAME = "utf-8";
    @Test
    public void encodeTest() {
        String toEncode = "Hello, world!";
        String result = Base64.getEncoder().encodeToString(toEncode.getBytes(Charset.forName(ENCODING_NAME)));
        assertEquals("SGVsbG8sIHdvcmxkIQ==", result);
    }

    @Test
    public void decodeTest() {
        String encoded = "SGVsbG8sIHdvcmxkIQ==";
        byte[] result = Base64.getDecoder().decode(encoded.getBytes(Charset.forName(ENCODING_NAME)));
        assertEquals("Hello, world!", new String(result, Charset.forName(ENCODING_NAME)));
    }
}
