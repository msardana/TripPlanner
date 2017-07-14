package tripPlanner.daos;

import javax.sql.DataSource;

import tripPlanner.models.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class inputHelperDaOImpl implements inputHelperDao {
	private JdbcTemplate  jdbcTemplate;
	 
    public inputHelperDaOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	@Override
	public City[] getCitiesForState(int stateid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
