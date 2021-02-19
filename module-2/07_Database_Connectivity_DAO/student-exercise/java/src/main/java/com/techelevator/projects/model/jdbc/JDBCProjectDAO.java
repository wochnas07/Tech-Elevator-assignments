package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		ArrayList<Project> listOfProjects = new ArrayList<>();
		String getAllProjects =	"SELECT project_id, project_name, from_date, to_date " +
								"FROM project ";
		
		SqlRowSet allProjects = jdbcTemplate.queryForRowSet(getAllProjects);
		while(allProjects.next()) {
			Project aProject = mapRowToProject(allProjects);
			listOfProjects.add(aProject);
		}
		return new lisOfProjects;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String removeEmployee = 	"DELETE " +
									"FROM project_employee " +
									"WHERE project_id = ? " +
									"AND employee_id = ? ";
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String addEmployeeToProject = 	"INSERT INTO project_employee(project_id, employee_id) " +
										"VALUES(?, ?) ";
		
		jdbcTemplate.update(addEmployeeToProject, projectId, employeeId);
		
	}
	
	private Project mapRowToProject(SqlRowSet results) {
		Project theProject;
		theProject = new Project();
		theProject.setProject_id(results.getLong("project_id"));
		theProject.setProject_name(results.getString("project_name"));
		
		if(results.getDate("from_date") != null) {
			theProject.setFrom_date(results.getDate("from_date").toLocalDate());
		} 
		if(results.getDate("to_date") != null) {
			theProject.setTo_date(results.getDate("to_date").toLocalDate());
		}
		return theProject;
			
	}

}
