package tripPlanner.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import tripPlanner.daos.CityDAO;
import tripPlanner.daos.CityDAOImpl;
import tripPlanner.daos.inputHelperDaOImpl;
import tripPlanner.daos.inputHelperDao;
import tripPlanner.interfaces.CityVisitingInterface;
import tripPlanner.services.citydecider.VisitingCities;
import tripPlanner.services.googlemaps.RoundTripCreator;


@EnableWebMvc
@Configuration
@ComponentScan({ "tripPlanner.*" })
public class BeanConfig extends WebMvcConfigurerAdapter {

	
	
	@Bean
	public DataSource getDataSource()   {
		String nonVCAPLocalRemoteFlag = "Development"; // "Development"; //Test;
	
		//log.info("SX_DB_USED: " + SX_DB_USED);
		//System.out.println("SX_DB_USED: " + SX_DB_USED);
		//log.info("VCAP_SERVICES content: " + VCAP_SERVICES);
		
       String 	SX_DB_USED = "dashDB-Development";
       
       
			//log.info("VCAP_SERVICES is null hence Initializing by hard coding");
			if(nonVCAPLocalRemoteFlag.equalsIgnoreCase("Development")){
				System.out.println("dashDB-Development Called!!");
			    SX_DB_USED = "dashDB_TripBook-Development"; 
			} else if(nonVCAPLocalRemoteFlag.equalsIgnoreCase("test")){
				System.out.println("DashDB-Test Called");
			    SX_DB_USED = "dashDB_Tripbook-test";
			}
			else {
				// mostly used by developers
			    SX_DB_USED = "dashDB_TripBook-Development";
			}
		
	
		
		//log.info(" SX_DB_USED " + SX_DB_USED);
	    DataSource dataSource = null;
	    JndiTemplate jndi = new JndiTemplate();
        try {
        	dataSource = (DataSource) jndi.lookup("jdbc/" + SX_DB_USED);
        } catch (NamingException e) {
        	e.printStackTrace();
        	//log.info("Error in JNDI Lookup for getDataSource for service: " + SX_DB_USED );
        //	throw new AppException(IException.KEY_JNDIEXCEPTION);
        } 
		
        return dataSource;
	}
	
	@Bean
	public inputHelperDao getInputHelperDao()  {
		return new inputHelperDaOImpl(getDataSource());
	}
	
	
	@Bean
	public CityDAO getCityDao()  {
		return new CityDAOImpl(getDataSource());
	}
	
	
	@Bean
	public RoundTripCreator getRoundTripCreator()
	{
		return new RoundTripCreator();
	}
	
	
	@Bean
	public CityVisitingInterface getVisitingCities()
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

}
