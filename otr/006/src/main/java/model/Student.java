package model;

/**
 * @author Alexey Pobedyonny 25.02.2014
 */
public class Student {
	private String name;
	private String marks;

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof Student)) return false;
		Student otherStudent = (Student) obj;
		if ((getName()==null) || otherStudent.getName() == null) return false;
		return getName().equals(otherStudent.getName());
	}
}
