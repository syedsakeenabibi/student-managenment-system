package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	
	private StudentRepository studentRepository;
	
	
	
	public StudentServiceImpl(StudentRepository studentRepository) {  // create constructor for student  
		super();
		this.studentRepository = studentRepository;
	}



	@Override
	public List<Student> getAllStudents() { //deyayso method ku apply karna
		
		return studentRepository.findAll();     //call the student repository;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	
	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}
	
	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	
	}
	
	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}
	
}

