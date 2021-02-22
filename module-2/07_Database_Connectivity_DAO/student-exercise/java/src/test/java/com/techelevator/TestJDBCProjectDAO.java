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
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestJDBCProjectDAO {

	/************************************************************************************************************
	 * Set up for the data base access
	 ************************************************************************************************************/
			
			// Define a reference to a data source to use in the tests
			private static SingleConnectionDataSource dataSource;
			
			// Define a reference to the JDBC/DAO we want to test
			private JDBCProjectDAO projDAO;
		
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
				projDAO = new JDBCProjectDAO(dataSource);
			}
			
			@After
			public void testTakeDown() throws SQLException {
				dataSource.getConnection().rollback();	// Rollback after every test so test data is not permanently stored in the database
			}
			
	/*************************************************************************************************************
	* Now that all the setup is done, we can start writing test for the methods in the JDBC/DAO
	*************************************************************************************************************/

			@Test
			public void testGetAllActiveProjects() {
			// Arrange
				List<Project> results = projDAO.getAllActiveProjects();
				assertNotNull(results);
				assertEquals(projDAO.getAllActiveProjects().size(), results.size());	
			}


			@Test
			public void testRemoveEmployeeFromProject() {
			}


			@Test
			public void testAddEmployeeToProject() {
			}

		
			
			
			
			
			
			
			
			
			
			
			
}
