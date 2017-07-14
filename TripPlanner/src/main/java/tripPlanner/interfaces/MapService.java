package tripPlanner.interfaces;

import java.util.ArrayList;

public interface MapService {

	PlanRoundTripInterface getService(String orgin, ArrayList<String> wayPoints);
}
