package tripPlanner.interfaces;

import java.util.ArrayList;

import tripPlanner.models.GoogleDirections;

import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.TravelMode;

public interface PlanRoundTripInterface {
//
	//void setAPI_KEY(String aPI_KEY);
	
	
	//void setModeofTransport(String mode);
	
	
	//GoogleDirections calcRoundTrip() throws Exception;

	//public DirectionsRoute[] getResult();

	GoogleDirections calcRoundTrip(String origin, ArrayList<String> wayPoints,
			TravelMode modeofTransport) throws Exception;
}
