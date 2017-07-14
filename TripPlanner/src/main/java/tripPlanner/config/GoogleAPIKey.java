package tripPlanner.config;

/*
 * Stores GoogleAPIKey to access google maps API
 * See <a href="https://console.developers.google.com/" >Google API</a>
*/

public class GoogleAPIKey {

	String API_KEY=null;

	public GoogleAPIKey(String apikey) {
		this.API_KEY=apikey;
	}

	public String getAPI_KEY() {
		
		if(this.API_KEY!=null)
		{
			return this.API_KEY;
		}
			
		String key = System.getenv("GOOGLE_API_KEY");
		if(key!=null)
		{
			return key;
		}
		
		return "AIzaSyAYBpc3Ve0q2PjngqgyaXU9pG_VuxhWtks";
	}

	public void setAPI_KEY(String aPI_KEY) {
		API_KEY = aPI_KEY;
	}
	
	
	
}
