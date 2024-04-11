
package AISS.VimeoMiner;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connections",
    "interactions"
})
@Generated("jsonschema2pojo")
public class Metadata__2 {

    @JsonProperty("connections")
    private Connections__2 connections;
    @JsonProperty("interactions")
    private Object interactions;

    @JsonProperty("connections")
    public Connections__2 getConnections() {
        return connections;
    }

    @JsonProperty("connections")
    public void setConnections(Connections__2 connections) {
        this.connections = connections;
    }

    @JsonProperty("interactions")
    public Object getInteractions() {
        return interactions;
    }

    @JsonProperty("interactions")
    public void setInteractions(Object interactions) {
        this.interactions = interactions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Metadata__2 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("connections");
        sb.append('=');
        sb.append(((this.connections == null)?"<null>":this.connections));
        sb.append(',');
        sb.append("interactions");
        sb.append('=');
        sb.append(((this.interactions == null)?"<null>":this.interactions));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
