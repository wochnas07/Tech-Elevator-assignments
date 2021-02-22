package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestJDBCEmployeeDAO {

	/************************************************************************************************************
	 * Set up for the data base access
	 ************************************************************************************************************/
			
			private String		test_first_name		= "Jeff";
			private String		test_last_name		= "Winger";
			private String		test_birth_date		= "(2020, 01, 01)";
			private String		test_gender			= "M";
			private String		test_hire_date		= "(2020, 02, 01)";
			private long		test_department_id	= 1;
			private long		test_employee_id	= 14;
			
			// Define a reference to a data source to use in the tests
			private static SingleConnectionDataSource dataSource;
			
			// Define a reference to the JDBC/DAO we want to test
			private JDBCEmployeeDAO employeeDAO;
		
			// Before any tests are run, this method initializes the datasource for testing
			@BeforeClass
			public static void setupDataSource() {
				dataSource = new SingleConnectionDataSource();
				dataSource.setUrl("jdbc:postgresql://localhost:5432/projectsDAO");
				dataSource.setUsername("postgres");
				dataSource.setPassword("postgres1");
				dataSource.setAutoCommit(false);
			}
			
			// After all tests have finished running, this method will close the DataSource
			@AfterClass
			public static void closeDataSource() throws SQLException {
				dataSource.destroy();
			}

	/************************************************************************************************************
	* Set up anything we need to do before and after every test
	************************************************************************************************************/
			@Before
			public void testSetUp() {
				String sqlInsertEmployee = 	"Insert INTO employee " +
											"(employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) " +
											"VALUES (14 , 1, 'Jeff', 'Winger', '2020,  01, 01', 'M', '2020, 02, 01')";
				
				// Instantiate a new JDBCTemplate object for use in the test
				JdbcTemplate theDataBase = new JdbcTemplate(dataSource);
				theDataBase.update(sqlInsertEmployee);
				
				// Instantiate an object containing the methods we want to test and assign it to the reference above
				employeeDAO = new JDBCEmployeeDAO(dataSource);
			}
			
			@After
			public void testTakeDown() throws SQLException {
				dataSource.getConnection().rollback();	// Rollback after every test so test data is not permanently stored in the database
			}
			
	/*************************************************************************************************************
	* Now that all the setup is done, we can start writing test for the methods in the JDBC/DAO
	*************************************************************************************************************/

			@Test
			public void testGetAllEmployees() {
				List<Employee> result = employeeDAO.getAllEmployees();
				assertNotNull(result);
				assertEquals(employeeDAO.getAllEmployees().size(), result.size());
				
			}		

			@Test
			public void searchEmployeesByName() {
				
				Employee aEmployee = new Employee();
				
				aEmployee.setFirst_name(test_first_name);
				aEmployee.setLast_name(test_last_name);;
				aEmployee.setBirth_date(test_birth_date);;
				aEmployee.setGender(test_gender);
				aEmployee.setHire_date(test_hire_date);
				aEmployee.setDepartment_id(test_department_id);
				
				List<Employee> result = employeeDAO.searchEmployeesByName(aEmployee.getFirst_name(), aEmployee.getLast_name());
				
				assertNotNull(result);
				assertEquals(1, result.size());
				assertEquals(result.get(0).getFirst_name(), aEmployee.getFirst_name());
				assertEquals(result.get(0).getLast_name(), aEmployee.getLast_name());
				
			}
			
			@Test
			public void getEmployeesByDepartmentId() {

			}


			@Test
			public void getEmployeesWithoutProjects() {
				Employee aEmployee = new Employee();
				employeeDAO.getEmployeesWithoutProjects();
				List<Employee> result = employeeDAO.getEmployeesWithoutProjects();
				assertEquals(1, result.size());
			}


			@Test
			public void getEmployeesByProjectId() {
	
			}

			
			@Test
			public void changeEmployeeDepartment() {
				Employee aEmployee = new Employee();
				employeeDAO.changeEmployeeDepartment(1L, 3L);
				List<Employee> result = employeeDAO.searchEmployeesByName("Fredrick",  "Keppard");
				assertEquals(3, result.get(0).getDepartment_id());
			}
				
}
