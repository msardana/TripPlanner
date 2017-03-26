package tripPlanner.controllers;

import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;

import tripPlanner.config.BeanConfig;
import tripPlanner.interfaces.PlanRoundTripInterface;
import tripPlanner.models.GoogleDirections;

@RestController
public class HomeController {
 
    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }
    
    
    
    
    
    /*
     * Incomplete mapping.........................
    
    @RequestMapping(value="/mapsdata",method = RequestMethod.GET, produces = "application/json")
    public GoogleDirections mapsdata(String origin, ArrayList<String> waypoints) throws Exception 
    {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
    	PlanRoundTripInterface pt = ctx.getBean(PlanRoundTripInterface.class);
    	return pt.calcRoundTrip(origin, waypoints, TravelMode.DRIVING);
    } */
    
    
    
    /*temporary mapping*/
    @RequestMapping(value = "/loadmap")
    public String loadmap() {
        return "directions.html";
    }
    
    
    
    @RequestMapping(value="/directions")
    public DirectionsResult mapsdata() throws Exception 
    {
    	String origin = "Bangalore";
    	ArrayList<String> waypoints = new ArrayList<String>();		
    	waypoints.add("Mysore");
    	waypoints.add("Andhra Pradesh");
    	waypoints.add("Telangana");
    	waypoints.add("Goa");
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
    	PlanRoundTripInterface pt = ctx.getBean(PlanRoundTripInterface.class);
    	ctx.close();
    	return pt.calcRoundTrip(origin, waypoints, TravelMode.DRIVING).getResult();
    	
    }
    
}