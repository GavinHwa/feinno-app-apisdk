package thirdparty.renren.renrenAPIv2;

/**
 * 新鲜事来源
 */
public class Source {

    /**
     * 来源的url
     */
    private String url;
    /**
     * 来源的文案
     */
    private String text;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}