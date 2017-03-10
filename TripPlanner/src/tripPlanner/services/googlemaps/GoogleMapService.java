package com.tripplanner.googlemaps;

import java.util.ArrayList;

public class GoogleMapService implements MapService {
	
	
	public PlanRoundTrip getService(String orgin, ArrayList<String> wayPoints)
	{
		return new RoundTrip(orgin,wayPoints);
	}
		
}
