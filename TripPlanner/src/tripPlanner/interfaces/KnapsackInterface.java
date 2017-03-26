package tripPlanner.interfaces;

import tripPlanner.models.CityVisitingOrder;

public interface KnapsackInterface {

	
	public CityVisitingOrder optimize(int[] weight,int[] profit,int W);
}
