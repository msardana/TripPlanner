package tripPlanner.interfaces;

import java.util.List;

import tripPlanner.models.City;

public interface CityVisitingInterface {

	public List<City> getCitiestoVisit(List<City> cities , int totaldays);
}
