package tripPlanner.services.googlemaps;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import tripPlanner.config.GoogleAPIKey;
import tripPlanner.interfaces.PlanRoundTripInterface;
import tripPlanner.models.GoogleDirections;

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


public class RoundTripCreator implements PlanRoundTripInterface{
	
	@Autowired
	GoogleAPIKey apiKey;

	/*
	private String origin;
	private ArrayList<String> wayPoints;
	private TravelMode modeofTransport=TravelMode.DRIVING;
	private String API_KEY;
	private DirectionsResult result=null;*/
	
	
	public RoundTripCreator() {
		super();
	}

/*	public RoundTripCreator(String orgin, ArrayList<String> wayPoints) {
		super();
		this.origin = orgin;
		this.wayPoints = wayPoints;
	}*/
	
/*	@Override
	public void setAPI_KEY(String aPI_KEY) {
		API_KEY = aPI_KEY;
	}*/

	/*@Override
	public void setModeofTransport(String mode) {
		if(mode.equalsIgnoreCase("Driving") || mode.equalsIgnoreCase("Road") || mode.equalsIgnoreCase("Car") || mode.equalsIgnoreCase("Bike"))
			modeofTransport = TravelMode.DRIVING;	
		else if(mode.equalsIgnoreCase("walking"))
			modeofTransport = TravelMode.WALKING;
		else if(mode.equalsIgnoreCase("bicycling") || mode.equalsIgnoreCase("bicycle") || mode.equalsIgnoreCase("cycle"))
			modeofTransport = TravelMode.BICYCLING;
		else
			modeofTransport = TravelMode.TRANSIT;
	}*/
	
	
	/*public DirectionsRoute[] getResult() {
		return result.routes;
	}
	*/
	@Override
	public GoogleDirections calcRoundTrip(String origin,ArrayList<String> wayPoints,TravelMode modeofTransport) throws Exception 
	{
		GeoApiContext context = new GeoApiContext().setApiKey(apiKey.getAPI_KEY());
		DirectionsApiRequest req =  DirectionsApi.getDirections(context, origin, origin);
		DirectionsResult result = new DirectionsResult();
		req.mode(modeofTransport);
		
		req.optimizeWaypoints(true);
		req.waypoints(wayPoints.toArray(new String[wayPoints.size()]));
		
		result = req.await();
		GoogleDirections gd = new GoogleDirections();
		gd.setResult(result);
		return gd;
	}
	
	
}
