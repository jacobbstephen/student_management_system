package student_management_system.entity;

public class Student {
	private String name;
	private String admissionNumber;
	
	public Student(String name, String admissionNumber) {
		this.name = name;
		this.admissionNumber = admissionNumber;
	}

	public String getName() {
		return name;
	}

	public String getAdmissionNumber() {
		return admissionNumber;
	}
	
	@Override
	public String toString() {
		return name + ": " + admissionNumber;
	}
}
