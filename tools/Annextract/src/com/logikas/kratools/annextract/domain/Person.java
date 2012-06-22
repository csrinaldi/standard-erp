package com.logikas.kratools.annextract.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {
	
	private String name;
	
	private String surname;
	
	@Size(min = 12, message = "debe tener al menos {0} caracteres")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Size(min = 12, message = "debe tener al menos {0} caracteres")
	@Pattern(regexp = "hello")
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
}
