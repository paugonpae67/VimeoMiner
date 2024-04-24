
package AISS.VimeoMiner.model.vimeo.comment;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pictures {
    @JsonProperty("uri")
    private String uri;

    @JsonProperty("base_link")
    private String link;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLink(){ return link;}

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "uri='" + uri + '\'' +
                '}';
    }
}
