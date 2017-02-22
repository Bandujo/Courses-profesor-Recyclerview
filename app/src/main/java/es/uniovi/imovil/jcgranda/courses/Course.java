package es.uniovi.imovil.jcgranda.courses;

public class Course {
	
	private String name;
	private String teacher;
	
	public Course(String name, String teacher) {
		
		if (name == null || teacher == null || name.isEmpty() || teacher.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		this.name = name;
		this.teacher = teacher;
	}

	public String getName() {
		
		return name;
	}

	public String getTeacher() {
		
		return teacher;
	}	
}
