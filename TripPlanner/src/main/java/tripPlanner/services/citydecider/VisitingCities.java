package tripPlanner.services.citydecider;

import tripPlanner.interfaces.CityVisitingInterface;
import tripPlanner.interfaces.KnapsackInterface;

public class VisitingCities implements CityVisitingInterface {

	
	
	@Override
	public KnapsackInterface get_zero_oneknapsack() {
		return new ZeroOneKnapsack();
	}
	
	
	@Override
	public KnapsackInterface get_fractionalknapsack() {
		
		return new FractionalKnapsack();
	}
	
}


	
