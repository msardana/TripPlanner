package tripPlanner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tripPlanner.services.citydecider.VisitingCities;
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
