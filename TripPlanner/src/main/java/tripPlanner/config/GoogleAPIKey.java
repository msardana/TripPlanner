package tripPlanner.config;

public class GoogleAPIKey {

	String API_KEY;

	public GoogleAPIKey(String apikey) {
		this.API_KEY=apikey;
	}

	public String getAPI_KEY() {
		return System.getenv("GOOGLE_API_KEY");
	}

	public void setAPI_KEY(String aPI_KEY) {
		API_KEY = aPI_KEY;
	}
	
	
	
}
