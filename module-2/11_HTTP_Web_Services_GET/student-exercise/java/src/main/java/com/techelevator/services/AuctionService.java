package com.techelevator.services;

import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.models.Auction;

public class AuctionService {

    public static final String BASE_URL = "http://localhost:3000/auctions";
    public RestTemplate callAPI = new RestTemplate();
    private final ConsoleService console = new ConsoleService();


    public Auction[] listAllAuctions() {
    	return callAPI.getForObject(BASE_URL, Auction[].class);
    }

    public Auction listDetailsForAuction(int id) {
        return callAPI.getForObject(BASE_URL + "/" + id, Auction.class);
    }

    public Auction[] findAuctionsSearchTitle(String title) {
        return callAPI.getForObject(BASE_URL + "?title_like="  + title, Auction[].class);
    }

    public Auction[] findAuctionsSearchPrice(double price) {
       return callAPI.getForObject(BASE_URL + "?currentBid_lte=" + price, Auction[].class);
    }

}
