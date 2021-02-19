package com.techelevator.city;

import java.util.List;

public interface CityDAO {

	public void save(City newCity);		// Add a new row using a City object

	public City findCityById(long id);	// Search the database for City with the id given and return it

	public List<City> findCityByCountryCode(String countryCode);	// Search the database for City with the countrycode given and return it

	public List<City> findCityByDistrict(String district);	// Search the database for City with the district given and return it

	public void update(City city);		// Update the row in the database with the data in a City object passed to it

	public void delete(long id);		// Delete a row from the database for the id passed to it
}
