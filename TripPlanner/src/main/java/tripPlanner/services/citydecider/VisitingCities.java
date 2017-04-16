package tripPlanner.services.citydecider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;

import tripPlanner.interfaces.CityVisitingInterface;
import tripPlanner.interfaces.KnapsackInterface;
import tripPlanner.models.City;


public class VisitingCities implements CityVisitingInterface {

	private int days_incities[];
	private int priority_scores[];

	@Override
	public List<City> getCitiestoVisit(List<City> cities,int totaldays) {
		ArrayList<Integer> w=new ArrayList<Integer>();
		ArrayList<Integer> p=new ArrayList<Integer>();		
		//System.out.println("Hello I am here size :  "+cities.size());
		for(City c:cities){
			w.add((int) c.getCoverage());
			p.add(c.getScore());
		}
		days_incities = Ints.toArray(w);
		priority_scores = Ints.toArray(p);
		KnapsackInterface k = new ZeroOneKnapsack();
		double visit[] = k.optimize(days_incities, priority_scores, totaldays);
		List<Double> list = Doubles.asList(visit);
	    //System.out.println(visit.length);
	    Iterator<City> iterc = cities.iterator();
	    Iterator<Double> iterd = list.iterator();
		 while(iterc.hasNext() && iterd.hasNext()){
			 iterc.next();
		        if(iterd.next().intValue()==0){
		            iterc.remove();
		        }
		    }
		return cities;
	} 
		
}


	
