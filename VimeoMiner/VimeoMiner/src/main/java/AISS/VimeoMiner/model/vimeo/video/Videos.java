
package AISS.VimeoMiner.model.vimeo.video;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Videos {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("paging")
    private Paging paging;
    @JsonProperty("data")
    private List<Video> videos;

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    @JsonProperty("per_page")
    public Integer getPerPage() {
        return perPage;
    }

    @JsonProperty("per_page")
    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    @JsonProperty("paging")
    public Paging getPaging() {
        return paging;
    }

    @JsonProperty("paging")
    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    @JsonProperty("data")
    public List<Video> getData() {
        return videos;
    }

    @JsonProperty("data")
    public void setData(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Videos.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("total");
        sb.append('=');
        sb.append(((this.total == null)?"<null>":this.total));
        sb.append(',');
        sb.append("page");
        sb.append('=');
        sb.append(((this.page == null)?"<null>":this.page));
        sb.append(',');
        sb.append("perPage");
        sb.append('=');
        sb.append(((this.perPage == null)?"<null>":this.perPage));
        sb.append(',');
        sb.append("paging");
        sb.append('=');
        sb.append(((this.paging == null)?"<null>":this.paging));
        sb.append(',');
        sb.append("videos");
        sb.append('=');
        sb.append(((this.videos == null)?"<null>":this.videos));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
