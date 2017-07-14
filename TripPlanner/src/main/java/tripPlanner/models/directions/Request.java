
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
    "origin",
    "destination",
    "waypoints",
    "optimizeWaypoints",
    "travelMode"
})
public class Request {

    @JsonProperty("origin")
    private String origin;
    @JsonProperty("destination")
    private String destination;
    @JsonProperty("waypoints")
    private List<Waypoint> waypoints = null;
    @JsonProperty("optimizeWaypoints")
    private Boolean optimizeWaypoints;
    @JsonProperty("travelMode")
    private String travelMode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("origin")
    public String getOrigin() {
        return origin;
    }

    @JsonProperty("origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @JsonProperty("destination")
    public String getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @JsonProperty("waypoints")
    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    @JsonProperty("waypoints")
    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    @JsonProperty("optimizeWaypoints")
    public Boolean getOptimizeWaypoints() {
        return optimizeWaypoints;
    }

    @JsonProperty("optimizeWaypoints")
    public void setOptimizeWaypoints(Boolean optimizeWaypoints) {
        this.optimizeWaypoints = optimizeWaypoints;
    }

    @JsonProperty("travelMode")
    public String getTravelMode() {
        return travelMode;
    }

    @JsonProperty("travelMode")
    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
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
