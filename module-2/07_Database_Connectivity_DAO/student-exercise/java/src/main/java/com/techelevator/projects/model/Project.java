package com.techelevator.projects.model;

import java.time.LocalDate;

public class Project {
	// TODO: Place code to describe the columns in the table row here
	
	private long	project_id;
	private String	name;
	private String	from_date;
	private String	to_date;
	
	public Project(long project_id, String name, String from_date, String to_date) {
		this.project_id 	= project_id;
		this.name 			= name;
		this.from_date 		= from_date;
		this.to_date 		= to_date;
	}
	public Project() {
		
	}
	
	public String toString() {
		return name;
	}
	public long getProject_id() {
		return project_id;
	}
	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	
}
