package com.techelevator.projects.model;

import java.time.LocalDate;

public class Project {
	// TODO: Place code to describe the columns in the table row here
	
	private long	project_id;
	private String	project_name;
	private String	from_date;
	private String	to_date;
	
	public Project(long project_id, String project_name, String from_date, String to_date) {
		this.project_id 	= project_id;
		this.project_name 	= project_name;
		this.from_date 		= from_date;
		this.to_date 		= to_date;
	}
	
	public String toString(Project Table) {
		return project_name;
	}
	
}
