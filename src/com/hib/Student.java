package com.hib;

public class Student {

	private Integer id;
	private String firstName;
	private String lastName;
	private String university;
	
	public Student(){
	}
	
	public Student(Integer id, String firstName, String lastName, String university){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.university = university;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
}
