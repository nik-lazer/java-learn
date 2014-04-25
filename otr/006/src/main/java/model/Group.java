package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexey Pobedyonny 25.02.2014
 */
public class Group {
	private String name;
	private StundentCouncil council;
	private List<Student> students;

	public Group(String groupName, List<String> studentNames, String councilMember1, String councilMember2) {
		this.name = groupName;
		if(studentNames != null) {
			students = new ArrayList<Student>(studentNames.size());
			for (String student : studentNames) {
				students.add(new Student(student));
			}
		}
		if(council == null) {
			council = new StundentCouncil();
		}
		if(councilMember1 != null) {
			council.setMember1(new Student(councilMember1));
		}
		if(councilMember2 != null) {
			council.setMember2(new Student(councilMember2));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public StundentCouncil getCouncil() {
		return council;
	}

	@Override
	public String toString() {
		return name;
	}

	public class StundentCouncil {
		private Student member1;
		private Student member2;

		public Student getMember1() {
			return member1;
		}

		public void setMember1(Student member1) {
			this.member1 = member1;
		}

		public Student getMember2() {
			return member2;
		}

		public void setMember2(Student member2) {
			this.member2 = member2;
		}
	}
}
