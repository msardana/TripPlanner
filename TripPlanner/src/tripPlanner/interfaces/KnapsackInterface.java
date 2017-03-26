package tripPlanner.interfaces;

import tripPlanner.models.CitytoVisit;

public interface KnapsackInterface {

	
	public CitytoVisit optimize(int[] weight,int[] profit,int W);
}
