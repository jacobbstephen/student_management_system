package student_management_system.service;

import student_management_system.entity.Student;
import student_management_system.exceptions.DuplicateStudentException;
import student_management_system.exceptions.StorageFullException;
import student_management_system.exceptions.StudentNotFoundException;

public interface StudentService {
	void addStudent(Student student) throws DuplicateStudentException, StorageFullException;
	Student[] searchStudentByName(String name) throws StudentNotFoundException;
	Student searchStudentByAdmissonNumber(String admissionNumber) throws StudentNotFoundException;
	Student[] trimArray(Student[] array, int size);
	boolean checkDuplicate(Student student);
}
