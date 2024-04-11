
package AISS.VimeoMiner;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "uri",
    "active",
    "type",
    "base_link",
    "sizes",
    "resource_key",
    "default_picture"
})
@Generated("jsonschema2pojo")
public class Header {

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("type")
    private String type;
    @JsonProperty("base_link")
    private String baseLink;
    @JsonProperty("sizes")
    private List<Size__2> sizes;
    @JsonProperty("resource_key")
    private String resourceKey;
    @JsonProperty("default_picture")
    private Boolean defaultPicture;

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("base_link")
    public String getBaseLink() {
        return baseLink;
    }

    @JsonProperty("base_link")
    public void setBaseLink(String baseLink) {
        this.baseLink = baseLink;
    }

    @JsonProperty("sizes")
    public List<Size__2> getSizes() {
        return sizes;
    }

    @JsonProperty("sizes")
    public void setSizes(List<Size__2> sizes) {
        this.sizes = sizes;
    }

    @JsonProperty("resource_key")
    public String getResourceKey() {
        return resourceKey;
    }

    @JsonProperty("resource_key")
    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    @JsonProperty("default_picture")
    public Boolean getDefaultPicture() {
        return defaultPicture;
    }

    @JsonProperty("default_picture")
    public void setDefaultPicture(Boolean defaultPicture) {
        this.defaultPicture = defaultPicture;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Header.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append(',');
        sb.append("active");
        sb.append('=');
        sb.append(((this.active == null)?"<null>":this.active));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("baseLink");
        sb.append('=');
        sb.append(((this.baseLink == null)?"<null>":this.baseLink));
        sb.append(',');
        sb.append("sizes");
        sb.append('=');
        sb.append(((this.sizes == null)?"<null>":this.sizes));
        sb.append(',');
        sb.append("resourceKey");
        sb.append('=');
        sb.append(((this.resourceKey == null)?"<null>":this.resourceKey));
        sb.append(',');
        sb.append("defaultPicture");
        sb.append('=');
        sb.append(((this.defaultPicture == null)?"<null>":this.defaultPicture));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
