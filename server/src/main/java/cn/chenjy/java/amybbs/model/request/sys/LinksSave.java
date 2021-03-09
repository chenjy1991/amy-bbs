package cn.chenjy.java.amybbs.model.request.sys;

/**
 * @author ChenJY
 * @create 2021/3/9 5:24 下午
 * @DESCRIPTION
 */
public class LinksSave {
    private Integer id;
    private String title;
    private String url;
    private String summary;
    private String logo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
