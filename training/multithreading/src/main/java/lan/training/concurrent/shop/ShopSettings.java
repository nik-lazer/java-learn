package lan.training.concurrent.shop;

/**
 * Shop settings
 * @author nik-lazer  26.10.2015   09:36
 */
public class ShopSettings {
	private int cachBoxNumber;
	private StatOutputType statOutputType;

	public ShopSettings(int cachBoxNumber, StatOutputType statOutputType) {
		this.cachBoxNumber = cachBoxNumber;
		this.statOutputType = statOutputType;
	}

	public int getCachBoxNumber() {
		return cachBoxNumber;
	}

	public StatOutputType getStatOutputType() {
		return statOutputType;
	}
}
