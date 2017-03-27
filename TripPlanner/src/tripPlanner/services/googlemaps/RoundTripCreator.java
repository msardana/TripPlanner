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
	
	
	public RoundTripCreator() {
		super();
	}


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
