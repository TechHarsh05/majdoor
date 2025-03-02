package com.jspider.spring_boot_simple_crud_with_mysql.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.ScrollPosition.Direction;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.spring_boot_simple_crud_with_mysql.dao.StudentDao;
import com.jspider.spring_boot_simple_crud_with_mysql.entity.Student;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/studentController")
@CrossOrigin(value = "http://localhost:5173")
@OpenAPIDefinition(info = @Info(description = "STUDENT CRUD OPERATION WITH SPRING BOOT"), servers = @Server(description = "http://localhost:3306/student-controller"))
public class StudentController {
	
	@Autowired
	private StudentDao dao;

	/*
	
//	List<Student> students = new ArrayList<Student>();
	
	@RequestMapping(value = "/getStudentDob", method=RequestMethod.GET)	
	public String getStudentDob() {
		return LocalDate.parse("2000-10-10") + "";
	}
	
	
//	@PostMapping(value =  "/addition/{a}/{b}")
//	public Integer additionOfTwoNumbers(@PathVariable(name = "a") Integer a,@PathVariable(name = "b") Integer b) {
//		return a+b;
//	}

//	@PostMapping ("/saveStudent")
//	public Student saveStudentController(@RequestBody Student student) {
		
//		System.out.println(student);
//		students.add(student);
//		return student;
		
//		return dao.saveStudentDao(student);
//	}
	
//	@PostMapping ("/saveMultipleStudent")
//	public List<Student> saveStudentController(@RequestBody List<Student> students) {
//		this.students.addAll(students);
//		System.out.println(students);
//		return this.students;
		
//	}
	
//	@RequestMapping("getAllStudent")
//	public List<Student> getAllStudent(){
//		return students;
//	}
	
//	@PostMapping(value = "deleteStudentById/{id1}")
//	public String deleteStudentById(@PathVariable(name = "id1") Integer id1){
//		
//		for (Student student : students) {			
//			int id = student.getId();
//			System.out.println(id + "");
//		if(id == id1) {
//			students.remove(student);
//			return "Deleted !";
//		}		
//	}
//		return "Could Not Get Id";
//	}
	
	
	*/
	
//	@PostMapping ("/saveStudent")
//	public Student saveStudentController(@RequestBody Student student) {
//		
//		return dao.saveStudentDao(student);
//	}
	
	@Operation(
			summary = "GET STUDENT DETAILS INSIDE MYSQL DB TABLE",
			description = "JSUT CHECK THE INFORMATION OF STUDENT",
			responses = {
					
				@ApiResponse(responseCode = "200", description = "Data Get Successfully"),
				@ApiResponse(responseCode = "404", description = "When URL Does Not Match"),
				@ApiResponse(responseCode = "500", description = "When An Exception Occured")
			}
			)
	@RequestMapping(value = "/getStudentDob", method=RequestMethod.GET)	
	public String getStudentDob() {
		return LocalDate.parse("2000-10-10") + "";
	}
	
	@PostMapping ("/saveStudent")
	public Student saveStudentController(@RequestBody Student student) {
	return dao.saveStudentDao(student);
	}
	
	@PostMapping ("/saveMultipleStudent")
	public List<Student> saveStudentController(@RequestBody List<Student> students) {
	return dao.saveMultipleStudentDao(students);
}
	
	@RequestMapping("getAllStudent")
	public List<Student> getAllStudentController(){
		return dao.getAllStudentDao();
	}
	
	@DeleteMapping(value = "/deleteStudentById/{id}")
	public void deleteStudentByNameController(@PathVariable(name ="id") int id) {
		dao.deleteStudentByIdDao(id);
//		return 
	}
	
	@PostMapping (value = "/getAllStudentByPhoneAsc/{phone}")
	public List<Student> getAllStudentAscByPhoneDao(@PathVariable(name = "phone") String phone){
		
		return dao.getAllStudentAscByPhoneDao(phone);
	}
	
	@PostMapping (value = "/fetchStudentWithPageSize/{pageNumber}/{pageSize}")
	public Page<Student> getAllStudentAscByPhoneDao(@PathVariable(name = "pageNumber") int pageNumber, @PathVariable(name = "pageSize") int pageSize){
		
		return dao.fatchStudentWithPageSizeDao(pageNumber, pageSize);
	}
	
	@PutMapping("/updateStudentName/{name}/{id}")
	public String updateStudentNameController(@PathVariable(name ="name") String name, @PathVariable(name = "id") int id) {
	    return dao.updateStudentNameDao(name, id);
	}

	
}
