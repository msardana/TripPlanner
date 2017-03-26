package tripPlanner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tripPlanner.interfaces.KnapsackInterface;
import tripPlanner.services.citydecider.FractionalKnapsack;
import tripPlanner.services.citydecider.ZeroOneKnapsack;
import tripPlanner.services.googlemaps.RoundTripCreator;

@Configuration
public class BeanConfig {

	@Bean
	RoundTripCreator getRoundTripCreator()
	{
		return new RoundTripCreator();
	}
	
	@Bean
	ZeroOneKnapsack get_zero_oneknapsack()
	{
		return new ZeroOneKnapsack();
		
	}

	@Bean
	FractionalKnapsack get_fractional_oneknapsack()
	{
		return new FractionalKnapsack();
		
	}
	
    @Bean
    GoogleAPIKey getGoogleAPIKey()
    {
    	return new GoogleAPIKey(System.getenv("GOOGLE_API_KEY"));
    	
    }
}
