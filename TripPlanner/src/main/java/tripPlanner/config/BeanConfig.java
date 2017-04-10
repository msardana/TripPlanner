package tripPlanner.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import tripPlanner.daos.CityDAOImpl;
import tripPlanner.interfaces.CityDAO;
import tripPlanner.services.citydecider.VisitingCities;
import tripPlanner.services.googlemaps.RoundTripCreator;


@EnableWebMvc
@Configuration
@ComponentScan({ "tripPlanner.*" })
public class BeanConfig extends WebMvcConfigurerAdapter {

	@Bean
	RoundTripCreator getRoundTripCreator()
	{
		return new RoundTripCreator();
	}
	
	
	@Bean
	VisitingCities getVisitingCities()
	{
		return new VisitingCities();
	}
	
    @Bean
    GoogleAPIKey getGoogleAPIKey()
    {
    	return new GoogleAPIKey(System.getenv("GOOGLE_API_KEY"));
    }
    
    @Bean
    public ViewResolver getViewResolver(){
          InternalResourceViewResolver resolver = new InternalResourceViewResolver();
          resolver.setPrefix("/WEB-INF/views/");
          resolver.setSuffix(".jsp");
          return resolver;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
          registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    /*
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("");  				database URL
        dataSource.setUsername("root");			database Username
        dataSource.setPassword("P@ssw0rd");	    database Password
         
        return dataSource;
    }
    
    @Bean
    public CityDAO getCityDAO() {
        return new CityDAOImpl(getDataSource());
    }*/
    
}