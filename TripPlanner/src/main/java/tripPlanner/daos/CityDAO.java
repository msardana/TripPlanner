package tripPlanner.daos;

import java.util.List;

import tripPlanner.models.City;

/**
 * Represents City DAO methods
*/

public interface CityDAO {
	
	/**
	 * Add a city to the database with City model as its argument
	*/
	public void addCity(City city);
	
	/**
	 * Delete single city from the database based on cityId
	*/
	public void deleteCity(int cityId);
	
	
	/**
	 * Add a single city from the database given cityId
	*/
    public City getCity(int cityId);
    
    
    /**
	 * List  all the cities in the database based on stateId
	*/
    public List<City> listAllCities(int stateid);
    
    
    
    /**
	 * List all the cities in a given state based based on total days and coverage
	*/
    public List<City> getCoverageMeasure(int totaldays, int stateid);
    
    
    
    
}
