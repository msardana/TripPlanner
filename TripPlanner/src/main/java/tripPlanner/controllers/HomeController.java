package tripPlanner.controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;

import tripPlanner.daos.CityDAO;
import tripPlanner.interfaces.CityVisitingInterface;
import tripPlanner.interfaces.PlanRoundTripInterface;
import tripPlanner.models.City;


@RestController
public class HomeController {
	
	@Autowired
	PlanRoundTripInterface roundTrip;
 
	@Autowired
	CityDAO cd;
	
	@Autowired
	CityVisitingInterface v;
	
 /*   @RequestMapping(value = "/home" , method = RequestMethod.GET)
    public ModelAndView  index(ModelAndView model, HttpServletRequest req, HttpServletResponse res) {
    	model.setViewName("index");
    	return model;
    }*/
    
    
    
    
    
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
    @RequestMapping(value = "/googlemaps")
    public ModelAndView loadmap(ModelAndView model, HttpServletRequest req, HttpServletResponse res) {
    	model.setViewName("directions");
    	return model;
    }
    
    
    @RequestMapping(value="/cities")
    public @ResponseBody List<String> getCitiesForState(ModelAndView model, HttpServletRequest req, HttpServletResponse res) throws Exception 
    {
	     String state = req.getParameter("state");
	     String origin= req.getParameter("origin");
	     List<City>cities = v.getCitiestoVisit(cd.getCoverageMeasure(10, Integer.parseInt(state),"Friends"), 10);		//test data
	     System.out.println("City Id\t\tCity Name\t\tCity Coverage\t\tCity Score");
	    
	     
	     for(City c: cities){
	     	System.out.println(c.getCityId()+"\t"+c.getCityname()+"\t"+c.getCoverage()+"\t"+c.getScore());
	     }
	     
	     
	     List<String> city = new LinkedList<String>();
	     city.add(origin);
	     for(City c:cities){
	    	 city.add(c.getCityname());
	     }
	     
	     return city;
    }
     
    
}