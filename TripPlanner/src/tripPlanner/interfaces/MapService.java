package tripPlanner.interfaces;

import java.util.ArrayList;

public interface MapService {

	PlanRoundTrip getService(String orgin, ArrayList<String> wayPoints);
}
