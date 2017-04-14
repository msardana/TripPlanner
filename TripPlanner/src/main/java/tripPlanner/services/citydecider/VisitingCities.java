package tripPlanner.services.citydecider;

import java.util.ArrayList;
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
		ArrayList<Integer> w=new ArrayList<Integer>();
		ArrayList<Integer> p=new ArrayList<Integer>();
		System.out.println("Hello I am here list size :  "+cities.size());
		Iterator<City> iter = cities.iterator();
		for(City c:cities){
			w.add((int) c.getCoverage());
			p.add(c.getScore());
		}
		for(int i:w){
			System.out.println("Weight : "+ i);
		}
		for(int i:p){
			System.out.println("Profit : "+ i);
		}
		KnapsackInterface k = new ZeroOneKnapsack();
		System.out.println("Hello I am here 2 ");
		/*double visit[] = k.optimize(days_incities, priority_scores, totaldays);
		iter = cities.iterator();
		i=0;
		while(iter.hasNext()){
			if(visit[i]==0){
				iter.remove();
			}
			i++;
		}
		return cities;*/
		return null;
	} 
		
}


	
