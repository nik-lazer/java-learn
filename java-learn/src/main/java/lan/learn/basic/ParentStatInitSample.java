package lan.learn.basic;

/**
 * Sample for init blocks order checking
 * @author lazarev_nv  15.12.2014   13:33
 */
public class ParentStatInitSample {

	public static void main(String args[]) {
		ChildStatInitSample s = new ChildStatInitSample();
	}

	public ParentStatInitSample() {
		System.out.print("1");
	}

	{
		System.out.print("2");
	}
}

class ChildStatInitSample extends ParentStatInitSample {
	public ChildStatInitSample() {
		System.out.print("3");
	}

	{
		System.out.print("4");
	}
}
