package com.techelevator.projects.model;

import java.time.LocalDate;

public class Employee {
	// TODO: Place code to describe the columns in the table row here
	
	private long	employee_id;
	private long	department_id;
	private String	first_name;
	private String	last_name;
	private String	birth_date;
	private String	gender;
	private String	hire_date;
	
	public Employee(long employee_id, long department_id, String first_name, String last_name,
					String birth_date, String gender, String hire_date) {
		this.employee_id 	= employee_id;
		this.department_id 	= department_id;
		this.first_name		= first_name;
		this.last_name 		= last_name;
		this.birth_date 	= birth_date;
		this.gender 		= gender;
		this.hire_date 		= hire_date;
	}

	public long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}
	public long getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(long department_id) {
		this.department_id = department_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	
	public String toString(Employee Table) {
		return last_name + first_name;
	}
	
	
}
