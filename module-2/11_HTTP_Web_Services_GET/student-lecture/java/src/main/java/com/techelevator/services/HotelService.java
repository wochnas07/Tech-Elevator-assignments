package com.techelevator.services;

import com.techelevator.models.City;
import com.techelevator.models.Hotel;
import com.techelevator.models.Review;
import org.springframework.web.client.RestTemplate;		// Incluse the code to support API calls

public class HotelService {

	// Hold the base/main part of the server URL the user wants us to use
    private final String API_BASE_URL;
    
    // Instantiate an object of a class containing all the code to support API calls
    // REST is a protocol for doing API calls - we learn more about this later
    // RestTemplate is a framework class to support API calls
    // When we want to do an API call we use this RestTemplate objet
    private RestTemplate callAPI = new RestTemplate();

    
    // Constructor - accepts the main/base part of the URL the user wants us to use
    public HotelService(String apiURL) {
        API_BASE_URL = apiURL;		// Assigns the main/base part og the URL to our instance variable above
    }
    // This method goes to the API server, gets all the Hotel data and returns it in an Array of Hotel objects
    public Hotel[] listHotels() {
    	// the URL path http://localhost:3000/hotels will return all the Hotels from the API server
    	// the "http://localhost:300/" is stored in our API_BASE_URL variable
    	// We need to ass the "hotels" to the API_BASE_URL and send it to the API server using our callAPI object
    	// The API returns JSON formatted data which we need to convert to an Array of Hotel objects
    	
    	// The RestTemplate class has a method called getForObject() that given a URL will do API GET request to the URL
    	//		and return data in any Java data format we pick. It will convert the JSON to Java data format automatically
    	
    	// The format of getFormatObjects() method: getForObject(String-with_URL, datatype-you-want-returned)
    	
    	
    	//							 API_URL			   , datatype-to-return
        return callAPI.getForObject(API_BASE_URL + "hotels", Hotel[].class);	// Hotel[].class - array of Hotel class objects
    }

    
    // Returns all the Reviews as an Array of Review Objects
    public Review[] listReviews() {
        return callAPI.getForObject(API_BASE_URL + "reviews", Review[].class);
    }

    
    // Return information on a specific hotel whose id is passed to the method
    public Hotel getHotelById(int id) {
    	// We need to add the "hotels/id" to the API_BASE_URL and send it to the API server using the callAPI object
        return callAPI.getForObject(API_BASE_URL + "hotels/"+id, Hotel.class);	// Hotel.class - a single Hotel class object
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        return null;
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        return null;
    }

    public City getWithCustomQuery(){
        return null;
    }

}
