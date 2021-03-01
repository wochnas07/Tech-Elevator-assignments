package com.techelevator.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Department;
import com.techelevator.model.DepartmentDAO;


/**
 * Controller to handle API requests for Department resources 
 */
@RestController	// Tells the server this file contains controllers

public class DepartmentController {
	
	DepartmentDAO deptDAO;		// Define a reference to the deptDAO so we can access it's methods
	
	// Constructor for this class - public, same name as the class
	// Use Spring dependency injection to instantiate a DepartmentDAO object and pass it to ctor
	//			We need to include the @Component annotation in the JDBCDepartmentDAO so Spring knows 
	//					it's a candidate for dependency injection
	
	public DepartmentController(DepartmentDAO deptDAO) {	// Receive a DepartmentDAO object as a parameter
		this.deptDAO = deptDAO;		// assign to our reference the deptDAO passed to the ctor
	}
	
	
	// This controller will handle the path
	//	to send back all the Departments (as an array, a List, a Map, a Queue, or a Stack)
	
	@RequestMapping (path="/departments", method = RequestMethod.GET)	// This function will handle /departments path
	public List<Department> listAllDepartments() {
		
		logAPICall("Called with path: /departments");	// log the API call to the server
		
		// use the Department DAO to get all the Departments from the data base and return them
		List<Department> theDepartments;
		
		theDepartments = deptDAO.getAllDepartments(); // Use the DAO method to retrieve all the Departments from the Department resources
		
		return theDepartments;
	}
	
	// This controller will get a specific department from the Department resource based on it's id
	// Use the DepartmentDAO getDepartmentById() method
	// 
	// The path the API will use to invoke this is: /departments/{id}
	// {id} indicates that the value will be included in the path and we want to call it id
	// We use the @PathVariable in the method parameter list to retrieve the value from the path
	// A user will call us to get department #3 to get /departments/3
	@RequestMapping (path="/departments/{id}", method = RequestMethod.GET) 
	public Department getDepartmentById(@PathVariable Long id) {
		logAPICall("Called with the path: /departments/"+id);
		return deptDAO.getDepartmentById(id);	// Call the DAO method to get the department with the id given and return it
	}
	
	
	
public void logAPICall(String message) {	// Write a message with a time stamp to the server log
	 LocalDateTime now = LocalDateTime.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy HH:mm:ss.A");
     String timeNow = now.format(formatter);
     System.out.println(timeNow + "-" + message);
 }
}


