package tripPlanner.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;

import tripPlanner.interfaces.PlanRoundTripInterface;

@Controller
public class HomeController {
	
	@Autowired
	PlanRoundTripInterface roundTrip;
 
    @RequestMapping(value = "/home" , method = RequestMethod.GET)
    public ModelAndView  index(ModelAndView model, HttpServletRequest req, HttpServletResponse res) {
    	model.setViewName("index");
    	return model;
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
    public ModelAndView loadmap(ModelAndView model, HttpServletRequest req, HttpServletResponse res) {
    	model.setViewName("directions");
    	return model;
    }
    
    
    
    @RequestMapping(value="/directions")
    public @ResponseBody DirectionsResult mapsdata() throws Exception 
    {
    	String origin = "Delhi";
    	ArrayList<String> waypoints = new ArrayList<String>();		
    	waypoints.add("Gwalior");
    	waypoints.add("Sanchi");
    	waypoints.add("Pachmarhi");
    	waypoints.add("Jabalpur");
    	waypoints.add("Khajuraho");
    //	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
    //	PlanRoundTripInterface pt = ctx.getBean(PlanRoundTripInterface.class);
    //	ctx.close();
    	DirectionsResult directions= roundTrip.calcRoundTrip(origin, waypoints, TravelMode.DRIVING).getResult();
    	System.out.println(directions.routes[0].legs[0].endAddress);
    	return directions;
    	
    }
    
}