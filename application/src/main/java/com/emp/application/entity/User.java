package com.emp.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

	@Id
	private long id;
	private String name;
	private String email;
	private String password;
	private long phone;
}
