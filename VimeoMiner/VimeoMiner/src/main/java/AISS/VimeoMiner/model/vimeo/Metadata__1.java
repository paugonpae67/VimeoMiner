
package AISS.VimeoMiner;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connections"
})
@Generated("jsonschema2pojo")
public class Metadata__1 {

    @JsonProperty("connections")
    private Connections__1 connections;

    @JsonProperty("connections")
    public Connections__1 getConnections() {
        return connections;
    }

    @JsonProperty("connections")
    public void setConnections(Connections__1 connections) {
        this.connections = connections;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Metadata__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("connections");
        sb.append('=');
        sb.append(((this.connections == null)?"<null>":this.connections));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
