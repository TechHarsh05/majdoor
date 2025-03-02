package com.jspider.spring_boot_simple_crud_with_mysql.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;

import com.jspider.spring_boot_simple_crud_with_mysql.entity.Student;
import com.jspider.spring_boot_simple_crud_with_mysql.repository.entity.StudentRepository;

@Repository
public class StudentDao {
	
	@Autowired
	private StudentRepository repository;
	
	public Student saveStudentDao(Student student) {
		return repository.save(student);
	}
	
	public List<Student> saveMultipleStudentDao(List<Student> students) {
		return repository.saveAll(students);
	
	}
	
	public List<Student> getAllStudentDao(){
		return repository.findAll();
	}
	
	public List<Student> getAllStudentAscByPhoneDao(String phone){
		return repository.findAll(Sort.by(Direction.DESC, phone));
	}
	
	public Page<Student> fatchStudentWithPageSizeDao(int pageNumber, int pageSize){
		
		return repository.findAll(PageRequest.of(pageNumber, 4));
	}

	public void deleteStudentByIdDao(int id) {
		
		repository.deleteById(id);
		
	}

	public String updateStudentNameDao(String name, int id) {
		Optional<Student> student = repository.findById(id);
		if(student.isPresent()) {
			Student update = student.get();
			update.setName(name);
			repository.save(update);
			return "Updated";
		}else {
			return "Could Not Updated";
		}
	}

}
