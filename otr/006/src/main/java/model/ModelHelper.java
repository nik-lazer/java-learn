package model;

import java.util.ArrayList;
import java.util.List;

import static org.fluentjava.FluentUtils.list;

/**
 * @author Alexey Pobedyonny 25.02.2014
 */
public class ModelHelper {
	public static List<Group> createModel(){
		List<Group> grp = new ArrayList<Group>();
		grp.add(new Group("Математика", list("Иванов", "Петров"), "Сидоров", null));
		grp.add(new Group("Информатика", list("Кузнецов", "Абырвалг"), "Петров", "Петрова"));
		grp.add(new Group("Философия", list("Степанов", "Антонов"), "Еромолаев", null));
		return grp;

	}
}
