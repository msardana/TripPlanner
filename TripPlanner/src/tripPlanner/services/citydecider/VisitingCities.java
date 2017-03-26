package tripPlanner.services.citydecider;

import tripPlanner.interfaces.CityVisitingInterface;
import tripPlanner.interfaces.KnapsackInterface;

public class VisitingCities implements CityVisitingInterface {

	
	
	@Override
	public KnapsackInterface get_zero_oneknapsack() {
		// TODO Auto-generated method stub
		return new ZeroOneKnapsack();
	}
	
	
	@Override
	public KnapsackInterface get_fractionalknapsack() {
		// TODO Auto-generated method stub
		return new FractionalKnapsack();
	}
	
}


	

	
	
	
	
	
	
}
