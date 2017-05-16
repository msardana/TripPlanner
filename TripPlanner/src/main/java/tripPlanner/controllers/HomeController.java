package tripPlanner.controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;
import tripPlanner.daos.CityDAO;
import tripPlanner.interfaces.CityVisitingInterface;
import tripPlanner.interfaces.PlanRoundTripInterface;
import tripPlanner.models.City;
import tripPlanner.models.directions.Directions;


@Controller
public class HomeController {
	
	@Autowired
	PlanRoundTripInterface roundTrip;
 
	@Autowired
	CityDAO cd;
	
	@Autowired
	CityVisitingInterface v;
	
    @RequestMapping(value = "/home" , method = RequestMethod.GET)
    public ModelAndView  index(ModelAndView model, HttpServletRequest req, HttpServletResponse res) {
    	model.setViewName("index");
    	return model;
    }
    
    @RequestMapping(value = "/googlemaps")
    public ModelAndView loadmap(ModelAndView model, HttpServletRequest req, HttpServletResponse res) {
    	model.setViewName("directions");
    	return model;
    }
    
    
    @RequestMapping(value = "/getjson" , method = RequestMethod.POST)
    public @ResponseBody void getJson(@RequestBody Directions mapresult) throws Exception {
    	System.out.println(mapresult.getRoutes().get(0).getSummary());
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