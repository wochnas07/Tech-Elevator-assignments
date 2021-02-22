package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// This is the integration test for the JDBCDepartmentDAO

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
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;

	@FixMethodOrder(MethodSorters.NAME_ASCENDING)		// list the tests in alphabetical order when you run them
														// tests are listed in the order they are defined in this file
	
public class TestJDBCDepartmentDAO {
		
/************************************************************************************************************
 * Set up for the data base access
 ************************************************************************************************************/
		
		// Define a reference to a data source to use in the tests
		private static SingleConnectionDataSource dataSource;
		
		// Define a reference to the JDBC/DAO we want to test
		private JDBCDepartmentDAO departmentDAO;
	
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
			
			// Instantiate a new JDBCTemplate object for use in the test
			JdbcTemplate theDataBase = new JdbcTemplate(dataSource);
			
			// Instantiate an object containing the methods we want to test and assign it to the reference above
			departmentDAO = new JDBCDepartmentDAO(dataSource);
		}
		
		@After
		public void testTakeDown() throws SQLException {
			dataSource.getConnection().rollback();	// Rollback after every test so test data is not permanently stored in the database
		}
		
/*************************************************************************************************************
* Now that all the setup is done, we can start writing test for the methods in the JDBC/DAO
*************************************************************************************************************/
		
		// Test the createDepartment() method
		@Test
		public void testCreateDepartment() {
			
			// Arrange - set up data for the test
			// Create a new department to add to the data base
			Department newDepartment = new Department();					// instantiate an empty new department
			newDepartment.setName("Jasons Meatballs");			// use setters to assign value in the new department
																	// We do not set the value for the primary key
																	//			because the data base manager does it
			Department returnedDept;								// Hold the department returned from the method
			// Act - actually run the method
			returnedDept = departmentDAO.createDepartment(newDepartment);		// call the method to test with parameters it needs	
																	// and save whatever it returns
			
			// Assert - verify the method did what it was supposed to
			
			// Check to see if a Department object is returned
			//		if it was, the data was probably added to the database
			assertNotNull(returnedDept);	// true if the reference is not null - if object was returned, it's not null
			
			// Was the new Department stored correctly -
			assertEquals(newDepartment.getName(), returnedDept.getName());
		}
		
		// Test the saveDepartment() method
		@Test
		public void testSaveDepartment() {
			// Arrange 
			Department newDepartment = new Department();
			newDepartment.setName("Department of Redundancy Department");
			departmentDAO.saveDepartment(newDepartment);
			List<Department> results = departmentDAO.searchDepartmentsByName(newDepartment.getName());
			assertNotNull(results);
			assertEquals(newDepartment.getName(), results.get(0).getName());
		}
		
		//Test the getAllDepartments() method
		@Test
		public void testGetAllDepartments() {
			// Arrange
			List<Department> results = departmentDAO.getAllDepartments();
			assertNotNull(results);
			assertEquals(departmentDAO.getAllDepartments().size(), results.size());
			
		}
		
		// Test the searchDepartmentByName() method
		@Test
		public void testSearchDepartmentByName() {
			Department newDepartment = new Department();
			newDepartment.setName("Department of Redundancy Department");
			List<Department> results = departmentDAO.searchDepartmentsByName(newDepartment.getName());
			assertEquals(newDepartment.getName(), results.get(0).getName());
		}
		
		// Test the getDepartartmentById() method
		@Test
		public void testGetDepartmentById() {
			// Arrange
			Department newDepartment = new Department();
			newDepartment.setDepartment_id((long) 10);
			Department results = departmentDAO.getDepartmentById(newDepartment.getDepartment_id());
			assertEquals(newDepartment.getName(), results.getName());
		}		

		
		
		
		
		
		
		
		
		
		
		
		
		

}
