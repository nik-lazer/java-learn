package lan.test.zk.domain;

/**
 * Food POJO from zkoss examples
 * @author nik-lazer  31.12.2014   13:38
 */
public class Food {
	String _category,  _name, _nutrients;
	int _percentageOfDaily, _calories;

	public Food(String cat, String nm, String nutr, int pod, int cal) {
		_category = cat;
		_name = nm;
		_nutrients = nutr;
		_percentageOfDaily = pod;
		_calories = cal;
	}
	public String getCategory() {
		return _category;
	}
	public String getName() {
		return _name;
	}
	public String getNutrients() {
		return _nutrients;
	}
	public int getPercentageOfDaily() {
		return _percentageOfDaily;
	}
	public int getCalories() {
		return _calories;
	}
}