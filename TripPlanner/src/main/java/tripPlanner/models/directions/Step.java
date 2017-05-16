
package tripPlanner.models.directions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "distance",
    "duration",
    "end_location",
    "polyline",
    "start_location",
    "travel_mode",
    "encoded_lat_lngs",
    "path",
    "lat_lngs",
    "instructions",
    "maneuver",
    "start_point",
    "end_point"
})
public class Step {

    @JsonProperty("distance")
    private Distance_ distance;
    @JsonProperty("duration")
    private Duration_ duration;
    @JsonProperty("end_location")
    private EndLocation_ endLocation;
    @JsonProperty("polyline")
    private Polyline polyline;
    @JsonProperty("start_location")
    private StartLocation_ startLocation;
    @JsonProperty("travel_mode")
    private String travelMode;
    @JsonProperty("encoded_lat_lngs")
    private String encodedLatLngs;
    @JsonProperty("path")
    private List<Path> path = null;
    @JsonProperty("lat_lngs")
    private List<LatLng> latLngs = null;
    @JsonProperty("instructions")
    private String instructions;
    @JsonProperty("maneuver")
    private String maneuver;
    @JsonProperty("start_point")
    private StartPoint startPoint;
    @JsonProperty("end_point")
    private EndPoint endPoint;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("distance")
    public Distance_ getDistance() {
        return distance;
    }

    @JsonProperty("distance")
    public void setDistance(Distance_ distance) {
        this.distance = distance;
    }

    @JsonProperty("duration")
    public Duration_ getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Duration_ duration) {
        this.duration = duration;
    }

    @JsonProperty("end_location")
    public EndLocation_ getEndLocation() {
        return endLocation;
    }

    @JsonProperty("end_location")
    public void setEndLocation(EndLocation_ endLocation) {
        this.endLocation = endLocation;
    }

    @JsonProperty("polyline")
    public Polyline getPolyline() {
        return polyline;
    }

    @JsonProperty("polyline")
    public void setPolyline(Polyline polyline) {
        this.polyline = polyline;
    }

    @JsonProperty("start_location")
    public StartLocation_ getStartLocation() {
        return startLocation;
    }

    @JsonProperty("start_location")
    public void setStartLocation(StartLocation_ startLocation) {
        this.startLocation = startLocation;
    }

    @JsonProperty("travel_mode")
    public String getTravelMode() {
        return travelMode;
    }

    @JsonProperty("travel_mode")
    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    @JsonProperty("encoded_lat_lngs")
    public String getEncodedLatLngs() {
        return encodedLatLngs;
    }

    @JsonProperty("encoded_lat_lngs")
    public void setEncodedLatLngs(String encodedLatLngs) {
        this.encodedLatLngs = encodedLatLngs;
    }

    @JsonProperty("path")
    public List<Path> getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(List<Path> path) {
        this.path = path;
    }

    @JsonProperty("lat_lngs")
    public List<LatLng> getLatLngs() {
        return latLngs;
    }

    @JsonProperty("lat_lngs")
    public void setLatLngs(List<LatLng> latLngs) {
        this.latLngs = latLngs;
    }

    @JsonProperty("instructions")
    public String getInstructions() {
        return instructions;
    }

    @JsonProperty("instructions")
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @JsonProperty("maneuver")
    public String getManeuver() {
        return maneuver;
    }

    @JsonProperty("maneuver")
    public void setManeuver(String maneuver) {
        this.maneuver = maneuver;
    }

    @JsonProperty("start_point")
    public StartPoint getStartPoint() {
        return startPoint;
    }

    @JsonProperty("start_point")
    public void setStartPoint(StartPoint startPoint) {
        this.startPoint = startPoint;
    }

    @JsonProperty("end_point")
    public EndPoint getEndPoint() {
        return endPoint;
    }

    @JsonProperty("end_point")
    public void setEndPoint(EndPoint endPoint) {
        this.endPoint = endPoint;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
