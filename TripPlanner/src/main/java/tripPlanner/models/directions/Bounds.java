
package tripPlanner.models.directions;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "south",
    "west",
    "north",
    "east"
})
public class Bounds {

    @JsonProperty("south")
    private Double south;
    @JsonProperty("west")
    private Double west;
    @JsonProperty("north")
    private Double north;
    @JsonProperty("east")
    private Double east;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("south")
    public Double getSouth() {
        return south;
    }

    @JsonProperty("south")
    public void setSouth(Double south) {
        this.south = south;
    }

    @JsonProperty("west")
    public Double getWest() {
        return west;
    }

    @JsonProperty("west")
    public void setWest(Double west) {
        this.west = west;
    }

    @JsonProperty("north")
    public Double getNorth() {
        return north;
    }

    @JsonProperty("north")
    public void setNorth(Double north) {
        this.north = north;
    }

    @JsonProperty("east")
    public Double getEast() {
        return east;
    }

    @JsonProperty("east")
    public void setEast(Double east) {
        this.east = east;
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
