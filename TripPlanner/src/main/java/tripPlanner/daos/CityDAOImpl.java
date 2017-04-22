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

	private JdbcTemplate jdbcTemplate;

	
	public CityDAOImpl(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	/**
	 * Add a city to the database with City model as its argument
	*/
	@Override
	public void addCity(City city) {
		String sql = "INSERT INTO city (CITYNAME,CITYCOORDINATES,COVERAGEMINDAYS,COVERAGEMAXDAYS,STATEID,SCORE)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, city.getCityname(),city.getCitycoordinates(),city.getCoveragemindays(),city.getCoveragemaxdays(),city.getStateid(),city.getScore());
	}

	
	/**
	 * Delete single city from the database based on cityId
	*/
	@Override
	public void deleteCity(int cityId) {
		String sql = "DELETE FROM City WHERE cityid=?";
		jdbcTemplate.update(sql, cityId);		
	}
	
	/**
	 * Add a single city from the database given cityId
	*/
	@Override
	public City getCity(int cityId) {
	    String sql = "SELECT * FROM City WHERE cityId=" + cityId;
	    return jdbcTemplate.query(sql, new CityMapExtractor());
	}

	
	/**
	 * List  all the cities in the database based on stateId
	*/
	@Override
	public List<City> listAllCities(int stateid) {
		String sql = "SELECT * FROM city where stateid="+stateid;
		List<City> listCity = jdbcTemplate.query(sql, new AllCityMapExtractor());
		return listCity;
	}

	
	
	/**
	 * List all the cities in a given state based based on total days
	 * Criteria : Average Coverage <= totaldays to travel
	 * 			  Cities belong to a particular state i.e stateid
	*/
	@Override
	public List<City> getCoverageMeasure(final int totaldays,final int stateid,final String category) {
		//String sql = "select CITYID,CITYNAME,CITYCOORDINATES,((COVERAGEMINDAYS+COVERAGEMAXDAYS)/2.0) COVERAGE,SCORE from city where ((COVERAGEMINDAYS+COVERAGEMAXDAYS)/2.0)<= ? and stateid= ?";
		String sql =	"select city.cityid,city.cityname,city.citycoordinates,((city.coveragemindays+city.coveragemaxdays)/2.0) Coverage,COALESCE(city.score+citycategoryrank.score,city.score,citycategoryrank.score,0) score\n" + 
				"from citycategoryrank\n" + 
				"left outer join category on category.categoryid=citycategoryrank.categoryid\n" + 
				"join city on city.cityid=citycategoryrank.cityid\n" + 
				"where ((city.coveragemindays+city.coveragemaxdays)/2.0)<=? and stateid=? and category.categoryname=? \n" + 
				"order by cityid";
		
		List<City> listCity = jdbcTemplate.query(sql, 
				new PreparedStatementSetter() {
						public void setValues(PreparedStatement preparedStatement) throws SQLException {
							preparedStatement.setInt(1, totaldays);
							preparedStatement.setInt(2, stateid);
							preparedStatement.setString(3, category);
						}
        		},
				new CityMeasureExtractor());
		return listCity;
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
	
	
	private static final class CityMeasureExtractor implements RowMapper<City> {
		@Override
		public City mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				City city = new City();
	
				city.setCityId(rs.getInt("CITYID"));
		        city.setCityname(rs.getString("CITYNAME"));
		        city.setCitycoordinates(rs.getString("CITYCOORDINATES"));
		        city.setCoverage(rs.getFloat("COVERAGE"));
		        city.setScore(rs.getInt("SCORE"));
		        
		        
		        return city;
			}
	}
	
	
	 
}
