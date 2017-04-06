package tripPlanner.models;

public class City {

	private Integer  cityid;
	private String cityname;
	private String citycoordinates;
	private Integer coveragemindays;
	private Integer coveragemaxdays;
	private Integer stateid;
	private Integer score;
	
	
	
	public Integer getCityid() {
		return cityid;
	}
	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getCitycoordinates() {
		return citycoordinates;
	}
	public void setCitycoordinates(String citycoordinates) {
		this.citycoordinates = citycoordinates;
	}
	public Integer getCoveragemindays() {
		return coveragemindays;
	}
	public void setCoveragemindays(Integer coveragemindays) {
		this.coveragemindays = coveragemindays;
	}
	public Integer getCoveragemaxdays() {
		return coveragemaxdays;
	}
	public void setCoveragemaxdays(Integer coveragemaxdays) {
		this.coveragemaxdays = coveragemaxdays;
	}
	public Integer getStateid() {
		return stateid;
	}
	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}

}
