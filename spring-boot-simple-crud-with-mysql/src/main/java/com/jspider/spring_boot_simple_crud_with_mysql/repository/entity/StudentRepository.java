package com.jspider.spring_boot_simple_crud_with_mysql.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.spring_boot_simple_crud_with_mysql.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
