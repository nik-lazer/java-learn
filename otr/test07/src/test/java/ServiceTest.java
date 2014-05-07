import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alexey Pobedyonny 07.05.2014
 */
public class ServiceTest {

	@Test
	public void testEval() throws Exception {
		Service service = new Service();
		Object _result = service.eval(new TestObject(10), "val+15");
		Assert.assertEquals(Integer.class, _result.getClass());
		Assert.assertEquals(25, _result);
	}

	public static class TestObject {
		private int val = 0;

		public TestObject(int val) {
			this.val = val;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}
	}
}
