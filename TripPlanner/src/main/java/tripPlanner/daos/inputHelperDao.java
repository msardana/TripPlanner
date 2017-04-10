package tripPlanner.daos;

import tripPlanner.models.Cities;

public interface inputHelperDao {

	
	
	Cities[] getCitiesForState(int stateid);
	
}
