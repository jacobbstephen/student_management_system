package student_management_system.manager;

import student_management_system.entity.Student;
import student_management_system.exceptions.DuplicateStudentException;
import student_management_system.exceptions.StorageFullException;
import student_management_system.exceptions.StudentNotFoundException;
import student_management_system.service.StudentService;

public class StudentManager implements StudentService {
	
	private int MAX_STUDENTS = 10;
	private Student[] students = new Student[MAX_STUDENTS];
	int count = 0;
	
	public Student[] trimArray(Student[] array, int size) {
		Student[] trimmed = new Student[size]; 
		for(int i = 0; i < size; i++) {
			trimmed[i] = array[i];
		}
		return trimmed;
	}
	
	public boolean checkDuplicate(Student student) {
		for(int i = 0; i < count; i++) {
			if(students[i].getAdmissionNumber() == student.getAdmissionNumber()) return true;
		}
		return false;
	}
	
	public void addStudent(Student student) throws DuplicateStudentException, StorageFullException{
		if(count > MAX_STUDENTS) throw new StorageFullException("Database is full. Cannot add any more students");
		if(checkDuplicate(student)) {
			String message =  "Student Already exists. Cannot add the student { " + student.getName() + ": " + student.getAdmissionNumber() + " }" ;
			throw new DuplicateStudentException(message);
		}
		students[count++] = student;
		
	}
	public Student[] searchStudentByName(String name) throws StudentNotFoundException{
		Student result[] = new Student[MAX_STUDENTS];
		int resultCount = 0;
		
		for(int i = 0; i < count; i++) {
			if(students[i].getName().equals(name))
				result[resultCount++] = students[i];
		}
		
		if(resultCount == 0) throw new StudentNotFoundException("Student by the name { " + name + " } not found");
		return trimArray(result, resultCount);
		
	}
	public Student searchStudentByAdmissonNumber(String admissionNumber) throws StudentNotFoundException{
		for(int i = 0; i < count; i++) {
			if(students[i].getAdmissionNumber().equals(admissionNumber)) {
				return students[i];
			}
		}
		
		throw new StudentNotFoundException("No Student found with this admission number {" + admissionNumber + "}");
	}
}
