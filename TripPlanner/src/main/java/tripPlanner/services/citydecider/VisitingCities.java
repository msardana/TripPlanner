package tripPlanner.services.citydecider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;

import tripPlanner.interfaces.CityVisitingInterface;
import tripPlanner.interfaces.KnapsackInterface;
import tripPlanner.models.City;

/*
 *	Decides which cities to visit and which cities not to,
 *	based on minimum and maximum coverage of a city
*/


public class VisitingCities implements CityVisitingInterface {

	private int days_incities[];
	private int priority_scores[];

	
	
	/**
	 * 	 getCitytoVisit() takes 2 arguments: 
	 * 		1) A list of cities containing average coverage time of each city 
	 * 	 	2) Total number of days the customer can spend
	*/
	@Override
	public List<City> getCitiestoVisit(List<City> cities,int totaldays) {
		
		/**
		 * Since the average coverage distance can be a floating point we multiply 
		 * all the average coverage and totaldays by 100. 
		 * This multiplication only affects the computation
		 * However it will not reflect in the output.
		*/
		totaldays = totaldays*100;  								
		ArrayList<Integer> w=new ArrayList<Integer>();
		ArrayList<Integer> p=new ArrayList<Integer>();		
		for(City c:cities){
			w.add((int) (c.getCoverage()*100));
			p.add(c.getScore());
		}
		days_incities = Ints.toArray(w);
		priority_scores = Ints.toArray(p);
		
		
		//KnapsackInterface k = new FractionalKnapsack();
		KnapsackInterface k = new ZeroOneKnapsack();		/*Suitable Knapsack Algorithm can be used according to the need */
		
		/**
		 * Represents the solution matrix of the cities to visit. 
		 * 0 represents do not visit the city
		 * 1 or a fraction represents visit the city
		*/
		double visit[] = k.optimize(days_incities, priority_scores, totaldays);
		
		List<Double> list = Doubles.asList(visit);
	    Iterator<City> iterc = cities.iterator();
	    Iterator<Double> iterd = list.iterator();
	    
	    /**
	     * Removes the city which cannot be visited in the given time. 
	     * Criteria: decided by the algorithm based on average coverage for each city
	    */
		 while(iterc.hasNext() && iterd.hasNext()){
			 iterc.next();
		        if(iterd.next().doubleValue()==0){
		            iterc.remove();
		        }
		    }
		  
		return cities;	//returning the list of cities that can be visited during the given time i.e totaldays
	} 
		
}


	
