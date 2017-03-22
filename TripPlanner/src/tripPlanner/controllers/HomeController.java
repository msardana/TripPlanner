package tripPlanner.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.model.TravelMode;

import tripPlanner.interfaces.MapService;
import tripPlanner.interfaces.PlanRoundTripInterface;
import tripPlanner.models.GoogleDirections;
import tripPlanner.services.googlemaps.GoogleMapService;

@RestController
public class HomeController {
 
    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }
    
    
    /*
     * Incomplete mapping.........................
     */
    @RequestMapping(value="/mapsdata",method = RequestMethod.GET, produces = "application/json")
    public GoogleDirections mapsdata(String origin, ArrayList<String> waypoints) throws Exception {
    	MapService m = new GoogleMapService();
    	PlanRoundTripInterface p;
    	p = m.getService(origin, waypoints);
		return p.calcRoundTrip(origin, waypoints, TravelMode.DRIVING);
    }
    
}