package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		ArrayList<Employee> listOfEmployees = new ArrayList<>();
		String sqlGetAllEmployees 	= "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
									"FROM employee";
		
		SqlRowSet allEmployees = jdbcTemplate.queryForRowSet(sqlGetAllEmployees);
		while(allEmployees.next()) {
			Employee theEmployee = mapRowToEmployee(allEmployees);
			listOfEmployees.add(theEmployee);
		}
		return listOfEmployees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		ArrayList<Employee> listOfEmployees = new ArrayList<>();
		String searchEmployeeNameSql =	"SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
										"FROM employee " +
										"WHERE first_name ilike ? " +
										"AND last_name ilike ? ";
		
		SqlRowSet theEmployees = jdbcTemplate.queryForRowSet(searchEmployeeNameSql, "%" + firstNameSearch + "%", "%", lastNameSearch + "%");
		if(theEmployees.next()) {
			Employee anEmployee = new Employee();
			anEmployee = mapRowToEmployee(theEmployees);
			listOfEmployees.add(anEmployee);
			
		}
		return listOfEmployees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		ArrayList<Employee> listOfEmployees = new ArrayList<>();
		String searchEmployeeByDeptId = 	"SELECT employee_id, first_name, last_name, birth_date, gender, hire_date " +
											"FROM employee " +
											"WHERE department_id = ?";
		SqlRowSet theEmployees = jdbcTemplate.queryForRowSet(searchEmployeeByDeptId, id);
		if(theEmployees.next()) {
			Employee = anEmployee = new Employee();
			anEmployee = mapRowToEmployee(theEmployees);
		}
		return listOfEmployees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
																	// DONT FORGET THIS!!!!!!!
		return new ArrayList<>();
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		ArrayList<Employee> listOfEmployees = new ArrayList<>();
		String searchEmployeeByProjectId =	"SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
											"FROM employee INNER JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
											"WHERE project_id = ?";
		SqlRowSet theEmployees = jdbcTemplate.queryForRowSet(searchEmployeeByProjectId, projectId);
		if(theEmployees.next()) {
			Employee anEmployee = new Employee();
			anEmployee = mapRowToEmployee(theEmployees);
			listOfEmployees.add(anEmployee);
		}
		
		return listOfEmployees;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String changeEmployeeDept =	"UPDATE employee " +
									"SET department_id = ? " +
									"WHERE employee_id = ? ";
		jdbcTemplate.update(changeEmployeeDept, departmentId, employeeId);
	}
	
	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee = theEmployee;
		theEmployee = new Employee();
		theEmployee.setEmployee_id(results.getLong("employee_id"));
		theEmployee.setDepartment_id(results.getLong("department_id"));
		theEmployee.setFirst_name(results.getString("first_name"));
		theEmployee.setLast_name(results.getString("last_name"));
		theEmployee.setBirth_date(results.getDate("birth_date").toLocalDate());
		theEmployee.setGender(results.getString("gender"));
		theEmployee.setHire_date(results.getDate("hire_date").toLocalDate());
		return theEmployee;
	}

}














