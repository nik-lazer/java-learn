package lan.training.jdk8features;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Stream creation examples
 * @author nik-lazer  19.11.2015   16:59
 */
public class StreamCreationTest {
	@Test
	public void createFromValuesTest() {
		Stream<String> stream = Stream.of("a1", "a2", "a3");
		assertEquals("[a1, a2, a3]", stream.collect(Collectors.toList()).toString());
	}

	@Test
	public void createArrayTest() {
		String[] array = {"a1", "a2", "a3"};
		Stream<String> stream = Arrays.stream(array);
		assertEquals("[a1, a2, a3]", stream.collect(Collectors.toList()).toString());
	}

	@Test
	public void  createFromFileTest() throws URISyntaxException, IOException {
		URL url = getClass().getClassLoader().getResource("data.txt");
		Stream<String> stream = Files.lines(Paths.get(url.toURI()));
		assertEquals("[a1, a2, a3, a4, a5]", stream.collect(Collectors.toList()).toString());
	}

	@Test
	public void createFromCollectionTest() {
		List<String> list = Arrays.asList("a1", "a2", "a3");
		Stream<String> stream = list.stream();
		assertEquals("[a1, a2, a3]", stream.collect(Collectors.toList()).toString());
	}

	@Test
	public void createFromBuilderTest() {
		Stream.Builder<String> builder = Stream.builder();
		Stream<String> stream = builder.add("a1").add("a2").add("a3").build();
		assertEquals("[a1, a2, a3]", stream.collect(Collectors.toList()).toString());
	}

	@Test
	public void streamGenerateTest() {
		Stream<String> streamFromGenerate = Stream.generate(() -> "a1");
		assertEquals("[a1, a1, a1]", streamFromGenerate.limit(3).collect(Collectors.toList()).toString());
	}

	@Test
	public void createEmpty() {
		Stream<Stream> stream = Stream.empty();
		assertEquals("[]", stream.collect(Collectors.toList()).toString());
	}

	@Test
	public void intFromChars() {
		IntStream intStream = "123".chars();
		assertEquals(150, intStream.sum());
	}
}
