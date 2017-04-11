package tripPlanner.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import tripPlanner.models.City;


public class CityDAOImpl implements CityDAO {

	private JdbcTemplate jdbcTemplateObject;

	public CityDAOImpl(DataSource dataSource) {
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void addCity(City city) {
		String sql = "INSERT INTO city (CITYNAME,CITYCOORDINATES,COVERAGEMINDAYS,COVERAGEMAXDAYS,STATEID,SCORE)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(sql, city.getCityname(),city.getCitycoordinates(),city.getCoveragemindays(),city.getCoveragemaxdays(),city.getStateid(),city.getScore());
	}

	@Override
	public void deleteCity(int cityId) {
		String sql = "DELETE FROM City WHERE cityid=?";
		jdbcTemplateObject.update(sql, cityId);		
	}


	private static final class CityMapExtractor implements ResultSetExtractor<City> {
		@Override
        public City extractData(ResultSet rs) throws SQLException,
                DataAccessException {
            if (rs.next()) {
            	City city = new City();
                city.setCityId(rs.getInt("CITYID"));
                city.setCityname(rs.getString("CITYNAME"));
                city.setCitycoordinates(rs.getString("CITYCOORDINATES"));
                city.setCoveragemindays(rs.getInt("COVERAGEMINDAYS"));
                city.setCoveragemaxdays(rs.getInt("COVERAGEMAXDAYS"));
                city.setStateid(rs.getInt("STATEID"));
                city.setScore(rs.getInt("SCORE"));
           
                return city;
            }
 
            return null;
        }
	}
	
	@Override
	public City getCity(int cityId) {
	    String sql = "SELECT * FROM City WHERE cityId=" + cityId;
	    return jdbcTemplateObject.query(sql, new CityMapExtractor());
	}
	
	
	private static final class AllCityMapExtractor implements RowMapper<City> {
		@Override
		public City mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				City city = new City();
	
				city.setCityId(rs.getInt("CITYID"));
		        city.setCityname(rs.getString("CITYNAME"));
		        city.setCitycoordinates(rs.getString("CITYCOORDINATES"));
		        city.setCoveragemindays(rs.getInt("COVERAGEMINDAYS"));
		        city.setCoveragemaxdays(rs.getInt("COVERAGEMAXDAYS"));
		        city.setScore(rs.getInt("SCORE"));
		        
		        
		        return city;
			}
	}
	
	
	@Override
	public List<City> listAllCities(int stateid) {
		String sql = "SELECT * FROM city where stateid="+stateid;
		List<City> listCity = jdbcTemplateObject.query(sql, new AllCityMapExtractor());
		return listCity;
	}

	@Override
	public List<City> getCoverageMeasure(final int totaldays,final int stateid) {
		String sql = "select CITYNAME,CITYCOORDINATES,((COVERAGEMINDAYS+COVERAGEMAXDAYS)/2.0) COVERAGE,STATEID,SCORE from city where ((COVERAGEMINDAYS+COVERAGEMAXDAYS)/2.0)<= ? and stateid= ?";
		List<City> listCity = jdbcTemplateObject.query(sql, 
				new PreparedStatementSetter() {
						public void setValues(PreparedStatement preparedStatement) throws SQLException {
							preparedStatement.setInt(1, totaldays);
							preparedStatement.setInt(2, stateid);
						}
        		},
				new AllCityMapExtractor());
		return listCity;
	}

	
	 
}
