/**
 * 
 */
package com.tripplanner.googlemaps;

import com.google.maps.model.DirectionsRoute;

/**
 * @author kirankn
 *
 */
public interface PlanRoundTrip {

	void setAPI_KEY(String aPI_KEY);
	
	
	void setModeofTransport(String mode);
	
	
	void calcRoundTrip() throws Exception;

	public DirectionsRoute[] getResult();

	public String getJson();
}
