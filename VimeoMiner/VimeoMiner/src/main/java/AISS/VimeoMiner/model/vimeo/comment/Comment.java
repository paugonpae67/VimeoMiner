
package AISS.VimeoMiner.model.vimeo.comment;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    @JsonProperty("created_on")
    private String createdOn;

    @JsonProperty("text")
    private String text;

    @JsonProperty("uri")
    private String uri;

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "createdOn='" + createdOn + '\'' +
                ", text='" + text + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}