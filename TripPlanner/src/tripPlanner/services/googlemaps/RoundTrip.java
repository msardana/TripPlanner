package com.tripplanner.googlemaps;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.TravelMode;


/**
 * RoundTrip class is a service that calculates the optimal round trip to 
 * cover places based on the input, places priority based on the 
 * the group diversity (in case all can not be covered) and any other factors 
 * stored in a data structure/model.  
 */


public class RoundTrip implements PlanRoundTrip{

	
	private String origin;
	private ArrayList<String> wayPoints;
	private TravelMode modeofTransport=TravelMode.DRIVING;
	private String API_KEY;
	private DirectionsResult result=null;
	
	
	public RoundTrip(String orgin, ArrayList<String> wayPoints) {
		super();
		this.origin = orgin;
		this.wayPoints = wayPoints;
	}
	
	@Override
	public void setAPI_KEY(String aPI_KEY) {
		API_KEY = aPI_KEY;
	}

	@Override
	public void setModeofTransport(String mode) {
		if(mode.equalsIgnoreCase("Driving") || mode.equalsIgnoreCase("Road") || mode.equalsIgnoreCase("Car") || mode.equalsIgnoreCase("Bike"))
			modeofTransport = TravelMode.DRIVING;	
		else if(mode.equalsIgnoreCase("walking"))
			modeofTransport = TravelMode.WALKING;
		else if(mode.equalsIgnoreCase("bicycling") || mode.equalsIgnoreCase("bicycle") || mode.equalsIgnoreCase("cycle"))
			modeofTransport = TravelMode.BICYCLING;
		else
			modeofTransport = TravelMode.TRANSIT;
	}
	
	@Override
	public DirectionsRoute calcRoundTrip() throws Exception 
	{
		GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
		DirectionsApiRequest req =  DirectionsApi.getDirections(context, origin, origin);
		DirectionsResult result = new DirectionsResult();
		req.mode("driving");
		
		req.optimizeWaypoints(true);
		req.waypoints(wayPoints.toArray(new String[wayPoints.size()]));
		
		result = req.await();
		this.result = result;
		return result.routes[0];
		
	}
	
	@Override
	public String getJson()
	{
		Gson gson = new Gson();
		String jsonString = gson.toJson(result);
		return jsonString;
	}
	
}
