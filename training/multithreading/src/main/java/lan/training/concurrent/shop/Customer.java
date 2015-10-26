package lan.training.concurrent.shop;

/**
 * TCustomer model
 * @author nik-lazer  26.10.2015   09:34
 */
public class Customer {
	private int number;
	private long timeOfProcessing;

	public Customer(int number, long timeOfProcessing) {
		this.timeOfProcessing = timeOfProcessing;
		this.number = number;
	}

	public long getTimeOfProcessing() {
		return timeOfProcessing;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Customer{" +
		       "number=" + number +
		       '}';
	}
}
