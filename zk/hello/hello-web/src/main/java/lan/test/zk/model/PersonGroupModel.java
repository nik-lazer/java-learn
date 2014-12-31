package lan.test.zk.model;

import lan.test.zk.domain.Gender;
import lan.test.zk.domain.Person;
import org.zkoss.zul.AbstractGroupsModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Custom group model for grid
 * @author nik-lazer  30.12.2014   17:57
 */
public class PersonGroupModel extends AbstractGroupsModel {
	private Map<Gender, List<Person>> data = new HashMap<Gender, List<Person>>();

	public PersonGroupModel(List<Person> persons) {
		data.put(Gender.MALE, new ArrayList<Person>());
		data.put(Gender.FEMALE, new ArrayList<Person>());
		for (Person person: persons) {
			data.get(person.getGender()).add(person);
		}
	}

	public Object getGroup(int groupIndex) {
		return getGenderByIndex(groupIndex);
	}

	public int getGroupCount() {
		return data.keySet().size();
	}

	public Object getChild(int groupIndex, int index) {
		Gender gender = getGenderByIndex(groupIndex);
		return data.get(gender).get(index);
	}

	public int getChildCount(int groupIndex) {
		Gender gender = getGenderByIndex(groupIndex);
		return data.get(gender).size();
	}

	public Object getGroupfoot(int groupIndex) {
		return null;
	}

	public boolean hasGroupfoot(int groupIndex) {
		return false;
	}

	public boolean isGroupOpened(int groupIndex) {
		return true;
	}

	public boolean addOpenGroup(int groupIndex) {
		return false;
	}

	public boolean removeOpenGroup(int groupIndex) {
		return false;
	}

	private Gender getGenderByIndex(int groupIndex) {
		Gender gender = null;
		switch (groupIndex) {
			case 0:
				gender = Gender.MALE;
				break;
			case 1:
				gender = Gender.FEMALE;
				break;
			default:
				gender = Gender.MALE;
		}
		return gender;
	}
}
