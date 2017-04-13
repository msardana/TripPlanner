package tripPlanner.services.citydecider;

import java.util.Iterator;
import java.util.List;

import tripPlanner.interfaces.CityVisitingInterface;
import tripPlanner.interfaces.KnapsackInterface;
import tripPlanner.models.City;


public class VisitingCities implements CityVisitingInterface {

	private int days_incities[];
	private int priority_scores[];

	@Override
	public List<City> getCitiestoVisit(List<City> cities,int totaldays) {
		int i=0;
		Iterator<City> iter = cities.iterator();
		while(iter.hasNext()){
			City c = iter.next();
			days_incities[i] = (int) c.getCoverage();
			priority_scores[i] = c.getScore();	
			i++;
		}
		KnapsackInterface k = new ZeroOneKnapsack();
		double visit[] = k.optimize(days_incities, priority_scores, totaldays);
		iter = cities.iterator();
		i=0;
		while(iter.hasNext()){
			if(visit[i]==0){
				iter.remove();
			}
			i++;
		}
		return cities;
	} 
		
}


	
