package tripPlanner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

<<<<<<< HEAD
import tripPlanner.services.citydecider.VisitingCities;
=======
import tripPlanner.interfaces.KnapsackInterface;
import tripPlanner.services.citydecider.FractionalKnapsack;
import tripPlanner.services.citydecider.VisitingCities;
import tripPlanner.services.citydecider.ZeroOneKnapsack;
>>>>>>> branch 'master' of https://github.com/kirankn8/TripPlanner.git
import tripPlanner.services.googlemaps.RoundTripCreator;

@Configuration
public class BeanConfig {

	@Bean
	RoundTripCreator getRoundTripCreator()
	{
		return new RoundTripCreator();
	}
	
	
	@Bean
	VisitingCities getvisitingcities()
	{
		return new VisitingCities();
	}
	
    @Bean
    GoogleAPIKey getGoogleAPIKey()
    {
    	return new GoogleAPIKey(System.getenv("GOOGLE_API_KEY"));
    	
    }
}
