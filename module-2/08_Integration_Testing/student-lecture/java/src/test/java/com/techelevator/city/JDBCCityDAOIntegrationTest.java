package com.techelevator.city;

/*
 * Integration Testing - Testing to ensure your code interacts with external processes correctly
 * 
 * You want to be sure that your code doesn't break when working with external code
 * 
 * Unit Testing - ensure that your class methods work as intended within the context of the application program
 * 
 * When using DAO's, we are interacting with an external resource/process called a data base manager
 * 
 * We need to verify that any INSERT, UPDATE, or DELETE we did was done correctly in the data base manager
 * 
 * You can use the DAO interface to determine which methods you need to test = they interact with the database
 * 
 * We will use JUnit with some additional techniques and methods
 * 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JDBCCityDAOIntegrationTest {
	
	// Define data with values you know will not and cannot be in the data base for testing

	private static final String TEST_COUNTRY = "XYZ";	// We know that there is no countrycode "XYZ" in the database
														// so we need a countrycode for a test we'll use this constant 

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction 
	 * 
	 * previously we used a BasicDataSource
	 * 
	 * We use the SingleConnectionDataSource due to it's efficiencies over the BasicDataSource
	 * 					and to give you an example of another data source
	 * 
	 * Both data sources have the same constructor format
	 * 
	 */
	private static SingleConnectionDataSource dataSource;	// Define a reference to the data source
															// 	the datasource object is instantiated and assigned in a setup method
	private JDBCCityDAO dao;								// Define a reference to the DAO we are testing
															// 	the DAO is instantiated and assigned before use 

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass	// Tells JUnit to do this once before it does anything else at the start of testing
					// put setup that all tests need to be done once before they start
					// When testing DAOs, instantiating and assigning datasource is a common process in @BeforeClass
	public static void setupDataSource() {					// name of the JUnit test method
		dataSource = new SingleConnectionDataSource();		// Instantiating and assigning the data source to our reference
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");	// Set the connection string for the datasource
		dataSource.setUsername("postgres");								// Set the database owner of the database we are using
		dataSource.setPassword("postgres1");							// Set the password for the database owner of the data we are using
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);		// tells the datasource NOT to automatically commit after each interaction
												// 		We want to control the commit 
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass		// Tells JUnit to do this once at the end of all tests before you end the testing session
					// Usually this is where you disconnect from the database manager to avoid resource leak by leaving connection open
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();		// Disconnect the datasource from the database manager
	}

	// Do not use "live" data in the database for your tests - it might change between tests - tests must be reliable
	// Add data to the database, specifically for the tests, so you know the data is there and won't change 
	//		Add data with values that you know are NOT or CANNOT be in the database already
	// Rollback any test data you added when the test completes
	
	
	@Before		// Do this before every JUnit Test - setup the database with data to be used in the tests
	public void setup() {
		// Add a row to country table with the TEST_COUNTRY value so we can use the row in our tests
		String sqlInsertCountry = "INSERT INTO country "
								+ "(code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) "
								+ "VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);
		
		// Instantiate an object for the DAO containing the methods we want to test
		// We do this before each test so we get a clean, unused datasource for each test
		// 		to be sure no remains of a prior test remain in the JDBC/DAO
		// 		if we share the same JDBC/DAO with all tests, the results may differ due to values left in the JDBC/DAo after use
		dao = new JDBCCityDAO(dataSource);
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After		// Do this after every JUnit Test - rollback any data added for the tests
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	// This is the start of our testing
	
	@Test	// Test the save method in the DAO
	public void save_new_city_and_read_it_back() throws SQLException {
		
		// Arrange - setup the data needed to test
		City theCity = getCity("SQL Station", "South Dakota", "USA", 65535);

		// Act - Perform the process / call the method you are testing
		dao.save(theCity);			// calling the DAO save method with the new City object we created for the test
		
		// Assert - verify that the process/method did what it was supposed to
		City savedCity = dao.findCityById(theCity.getId());	// Get the row just added to the database 
															//	with the id in the object used

		assertNotEquals(null, theCity.getId());		// Be sure the id added was not null
		assertCitiesAreEqual(theCity, savedCity);	// Be sure the data retrieved from the database matches the data we sent
													//		using a helper method
	}

	@Test		// test can we find a city by country code
	public void returns_cities_by_country_code() {
		// Arrange - set up data neeeded for the test
		
		// Instantiate a city using the test countrycode - that way we know it's the only city with that country code
		City theCity = getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);

		// Save the test city to the datatbase
		dao.save(theCity);
		
		// Act - Perform the process / call the method you are testing
		//		Try to get all the cities with the test country code - we know there should be only one
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);

		
		// Assert - verify process did what it was supposed to
		assertNotNull(results);						// Verify that something was returned - at least on City in the List
		assertEquals(1, results.size());			// Verify that exactly 1 City was returned - only one can have the test country code
		City savedCity = results.get(0);			// Get the City out of the list that was returned
		assertCitiesAreEqual(theCity, savedCity);	// 		and be sure it matches the City we sent to be stored
	}

	@Test
	public void returns_multiple_cities_by_country_code() {
		
		// Arrange
		
		// Instantiate multiple new cities with the test country - they will be only ones in the table with the test country code
		// and add them to the database
		dao.save(getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535));
		dao.save(getCity("Postgres Point", "North Dakota", TEST_COUNTRY, 65535));
		
		// Act - get all the cities with the test country code - we know there should only be 2
		
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
		
		
		// Assert 
		assertNotNull(results);				// Did at least one City get returned in the List?
		assertEquals(2, results.size());	// Did exactly 2 City objects get returned?
		
		// Frank would also do this...
		// 		but we can't because we did not instantiate separate objects to be saved
//		City savedCity = results.get(0);			// Get the City out of the list that was returned
//		assertCitiesAreEqual(theCity, savedCity);	// 		and be sure it matches the City we sent to be stored
//	
//		savedCity = results.get(1);			// Get the City out of the list that was returned
//		assertCitiesAreEqual(theCity, savedCity);	// 		and be sure it matches the City we sent to be stored

		
	}

	@Test
	public void returns_cities_by_district() {
		String testDistrict = "Tech Elevator";
		City theCity = getCity("SQL Station", testDistrict, TEST_COUNTRY, 65535);
		dao.save(theCity);

		List<City> results = dao.findCityByDistrict(testDistrict);

		assertNotNull(results);
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}
/**************************************************************************************************
 * Helper methods used to setup data for the tests - commonly needed process
 * 
 * There methods are actually testing any DAO methods - they are helping the tests with needed processing
 **************************************************************************************************/

	// Helper method to create a new City object when a test needs one
	private City getCity(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(countryCode);
		theCity.setPopulation(population);
		return theCity;
	}
	// Helper method to test if two City objects are equal
	private void assertCitiesAreEqual(City expected, City actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDistrict(), actual.getDistrict());
		assertEquals(expected.getCountryCode(), actual.getCountryCode());
		assertEquals(expected.getPopulation(), actual.getPopulation());
	}
}
