package tripPlanner.daos;

import java.util.List;

import tripPlanner.models.City;

public interface CityDAO {
	
	public void addCity(City city);
	
	public void deleteCity(int cityId);
    
    public City getCity(int cityId);
     
    public List<City> listAllCity();
}
