package com.tripplanner.googlemaps;

import java.util.ArrayList;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;


/**
 * RoundTrip class is a service that calculates the optimal round trip to 
 * cover places based on the input, places priority based on the 
 * the group diversity (in case all can not be covered) and any other factors 
 * stored in a data structure/model.  
 */


public class RoundTrip {

	
	private String origin;
	private ArrayList<String> wayPoints;
	private String API_KEY;
	
	//to be used later
	//private Stack<String> placeOfInterest;
	

	public void setAPI_KEY(String aPI_KEY) {
		API_KEY = aPI_KEY;
	}

	public RoundTrip(String orgin, ArrayList<String> wayPoints) {
		super();
		this.origin = orgin;
		this.wayPoints = wayPoints;
	}
	
	public DirectionsRoute calcRoundTrip() throws Exception 
	{
		GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
		DirectionsApiRequest req =  DirectionsApi.getDirections(context, origin, origin);
		req.optimizeWaypoints(true);
		req.waypoints(wayPoints.toArray(new String[wayPoints.size()]));
		DirectionsResult result = req.await();
		
		return result.routes[0];
		
	}
	
	
	
	
	
	
	
	
}
