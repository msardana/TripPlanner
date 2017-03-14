package tripPlanner.services.googlemaps;

import java.util.ArrayList;

import tripPlanner.interfaces.MapService;
import tripPlanner.interfaces.PlanRoundTrip;

public class GoogleMapService implements MapService {
	
	
	public PlanRoundTrip getService(String orgin, ArrayList<String> wayPoints)
	{
		return new RoundTrip(orgin,wayPoints);
	}
		
}
