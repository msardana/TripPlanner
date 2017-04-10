package tripPlanner.daos;

import tripPlanner.models.City;

public interface inputHelperDao {

	
	
	City[] getCitiesForState(int stateid);
	
}
