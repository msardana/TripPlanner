package tripPlanner.interfaces;

import java.util.List;

import tripPlanner.models.City;

public interface CityVisitingInterface {


	KnapsackInterface get_zero_oneknapsack();
	
	KnapsackInterface get_fractionalknapsack();
	
	public List<City> getCitiestoVisit(List<City> cities , int totaldays);
}
