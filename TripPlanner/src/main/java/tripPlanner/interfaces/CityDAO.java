package tripPlanner.interfaces;

import java.util.List;

import tripPlanner.models.Cities;

public interface CityDAO {
	
	public void addCity(Cities city);
	
	public void deleteCity(int cityId);
    
    public Cities getCity(int cityId);
     
    public List<Cities> listAllCity();
}
