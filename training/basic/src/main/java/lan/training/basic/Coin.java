package lan.training.basic;

/**
 * Methods overloading
 * @author nik-lazer  08.10.2015   15:42
 */
public class Coin {
	public static String overload(Head side) {
		return side.getSide();
	}
	public static String overload(Tail side) {
		return side.getSide();
	}
	public static String overload(Side side) {
		return "Side";
	}
	public static String overload(Object side) {
		return "Object";
	}
}

interface Side { String getSide(); }

class Head implements Side {
	public String getSide() {
		return "Head";
	}
}

class Tail implements Side {
	public String getSide() {
		return "Tail";
	}
}

