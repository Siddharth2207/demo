package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

	
@RestController
@Service
public class StudentController {
	
	@Autowired
	public StudentRepository studentRepository ; 

	@GetMapping(value="/all")
	public List<Student> getAllStudents() {
		return studentRepository.findAll() ; 
	}
	
	@GetMapping(value="/getStudent/{id}")
	public Optional<Student> getStudent(@PathVariable(value = "id") long id) {
		Optional<Student> foundStudent = studentRepository.findById(id) ;
		return foundStudent ; 
	}
	
	@PostMapping(value ="/create")
	public String createStudent(@RequestBody Student student){
		Student insertedStudent = studentRepository.insert(student) ;
		return "Student created : " + insertedStudent.getName() 	; 
	} 
	
	@DeleteMapping(value = "/deleteStudent/{id}")
	public void deleteStudent(@PathVariable(value = "id") long id) {
		studentRepository.deleteById(id) ;  
	}
	
	@PutMapping(value = "/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") long id , @RequestBody Student student) throws Exception{
		Student stud = studentRepository.findById(id).orElseThrow(() -> new Exception()) ; 
		stud.setName(student.getName()) ; 
		stud.setAge(student.getAge()) ; 
		stud.setGrade(student.getGrade()) ; 
		final Student  updatedStudent = studentRepository.save(stud) ; 
		return ResponseEntity.ok(updatedStudent) ; 
		
	}
	
}
