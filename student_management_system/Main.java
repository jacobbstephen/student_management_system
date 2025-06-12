package student_management_system;

import student_management_system.entity.Student;
import student_management_system.exceptions.StudentException;
import student_management_system.manager.StudentManager;

public class Main {

	public static void main(String[] args) {
		Student s1 = new Student("Jacob", "210441"); 
		Student s2 = new Student("Jeev", "210444"); 
		Student s3 = new Student("Vidhya", "210456"); 
		Student s4 = new Student("Reshma", "235460"); 
		Student s5 = new Student("Rosh", "147896"); 
		Student s6 = new Student("Kannuz", "210442"); 
		
		try {
			StudentManager studentManager = new StudentManager();
			studentManager.addStudent(s1);
			studentManager.addStudent(s2);
			studentManager.addStudent(s3);
			studentManager.addStudent(s4);
			studentManager.addStudent(s5);
			studentManager.addStudent(s6);
			
			Student students[] = studentManager.searchStudentByName("Kannuz");
			for(Student student: students) System.out.println(student);
			System.out.println(studentManager.searchStudentByAdmissonNumber("210441"));
			
		}catch(StudentException e) {
			System.err.println(e.getMessage());
		}

	}

}
