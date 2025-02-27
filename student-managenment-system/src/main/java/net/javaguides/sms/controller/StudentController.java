package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.service.StudentService;

@Controller
public class StudentController {

	private StudentService  studentService;

	public StudentController(StudentService studentService) { //constructor creation for the class
		super();
		this.studentService = studentService;
	}
	
	
	 
	
	//handler method to handle list students and return mode and view //1//
	@GetMapping("/students")
	public String listStudents(Model  model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
		
	}
	
	
 	//handler method to handle the new student  add //
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		
		
		//create student objects to hold student form data//
		Student student= new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student")Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	
	//create student objects edit the data ...update 1 //
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model ) {
	model.addAttribute("student",studentService.getStudentById(id));
	return "edit_student";
	}
	
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student")Student student,Model model) { 
    Student existingStudent =studentService.getStudentById(id);   	
    existingStudent.setId(id);
    existingStudent.setFirstName(student.getFirstName());
    existingStudent.setLastName(student.getLastName());
    existingStudent.setEmail(student.getEmail());
    
    //save update student object
    
    studentService.updateStudent(existingStudent);
    return "redirect:/students";
    	
    }
	
  //  handler method to handle delete student request
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
    	studentService.deleteStudentById(id);
    	return "redirect:/students";
    	
    	
    }
    
    
}

