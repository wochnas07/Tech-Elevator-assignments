package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// This is the integration test for the JDBCDepartmentDAO

import java.sql.SQLException;

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
		private JDBCDepartmentDAO deptDAO;
	
		// Before any tests are run, this method initializes the datasource for testing
		@BeforeClass
		public static void setupDataSource() {
			dataSource = new SingleConnectionDataSource();
			dataSource.setUrl("jdbc:postgressql://localhost:5432/world");
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
			deptDAO = new JDBCDepartmentDAO(dataSource);
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
			Department newDept = new Department();					// instantiate an empty new department
			newDept.setDepartment_name("Jasons Meatballs");			// use setters to assign value in the new department
																	// We do not set the value for the primary key
																	//			because the data base manager does it
			Department returnedDept;								// Hold the department returned from the method
			// Act - actually run the method
			returnedDept = deptDAO.createDepartment(newDept);		// call the method to test with parameters it needs	
																	// and save whatever it returns
			
			// Assert - verify the method did what it was supposed to
			
			// Check to see if a Department object is returned
			//		if it was, the data was probably added to the database
			assertNotNull(returnedDept);	// true if the reference is not null - if object was returned, it's not null
			
			// Was the new Department stored correctly -
			assertEquals(newDept.getDepartment_name(), returnedDept.getDepartment_name());
		}
		
		
		
		
		
		
		
		

}
