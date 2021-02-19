package com.techelevator.projects.model;

public class Department {
// TODO: Place code to describe the columns in the table row here
	
	private Long	department_id;
	private String	department_name;
	
	public Department(Long department_id, String department_name) {
		this.department_id = department_id;
		this.department_name = department_name;
	}
	public Department() {
	}
	
	public Department(Long department_id) {
		this.department_id = department_id;
	}
	public Department(String department_name) {
		this.department_name = department_name;
	}
	public Long getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String toString(Department Table) {
		return department_name;
	}
}