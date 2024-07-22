package net.javaguides.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagenmentSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagenmentSystemApplication.class, args);
	}
	
	@Autowired //2 all list data bhejna//
	private StudentRepository studentRepository;
	
	@Override
	public void run(String...args)throws Exception{

		Student student1=new Student("Sakeena","bibi","syedsakeenabibi123@gmail.com");
		studentRepository.save(student1);
		
	
		Student student2=new Student("amreen","syed","Amreen@gmail.com");
		studentRepository.save(student2);
		
		Student student3=new Student("honey","syed","Honey@gmail.com");
		studentRepository.save(student3);
		
		Student student4=new Student("bibi","syed","Honey@gmail.com");
		studentRepository.save(student4); 
	}
}
