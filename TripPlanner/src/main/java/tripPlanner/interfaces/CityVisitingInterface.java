package tripPlanner.interfaces;

import java.util.List;

import tripPlanner.models.City;

/*
 *	Decides which cities to visit and which cities not to,
 *	based on minimum and maximum coverage of a city
*/


public interface CityVisitingInterface {

	public List<City> getCitiestoVisit(List<City> cities , int totaldays);
}
