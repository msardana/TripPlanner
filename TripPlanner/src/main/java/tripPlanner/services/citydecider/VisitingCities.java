package tripPlanner.services.citydecider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		System.out.println("Hello I am here size :  "+cities.size());
		for(City c:cities){
			w.add((int) c.getCoverage());
			p.add(c.getScore());
		}
		days_incities = Ints.toArray(w);;
		priority_scores = Ints.toArray(p);
		KnapsackInterface k = new ZeroOneKnapsack();
		double visit[] = k.optimize(days_incities, priority_scores, totaldays);
		System.out.println(visit.length);
		int i=0;
		for (Iterator<City> it = cities.iterator(); it.hasNext(); ) {
			if(visit[i]==0){
				it.remove();
			}
			i++;
		}
		return cities;
	} 
		
}


	
