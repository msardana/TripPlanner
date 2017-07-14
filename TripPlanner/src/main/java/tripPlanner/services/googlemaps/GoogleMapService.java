package tripPlanner.services.googlemaps;

import java.util.ArrayList;

import tripPlanner.interfaces.MapService;
import tripPlanner.interfaces.PlanRoundTripInterface;

public class GoogleMapService implements MapService {
	
	
	public PlanRoundTripInterface getService(String orgin, ArrayList<String> wayPoints)
	{
		return new RoundTripCreator();
	}
		
}
