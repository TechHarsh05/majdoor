package com.jspider.spring_boot_simple_crud_with_mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
	
	@Id
	private int id;
	private String name;
	private String email;
	private long phone;
}
