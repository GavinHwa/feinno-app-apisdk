package thirdparty.renren.renrenAPIv2;

/**
 * 新鲜事的附加内容
 */
public class FeedAttachment {

    /**
     * 附加内容id
     */
    private long id;
    /**
     * 附加内容类型
     */
    private FeedAttachmentType type;
    /**
     * 附加内容拥有者id
     */
    private long ownerId;
    /**
     * 附加内容url
     */
    private String url;
    /**
     * 图片地址或视频播放地址
     */
    private String orginalUrl;
    /**
     * 图片的大图地址
     */
    private String rawImageUrl;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setType(FeedAttachmentType type) {
        this.type = type;
    }

    public FeedAttachmentType getType() {
        return this.type;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public long getOwnerId() {
        return this.ownerId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setOrginalUrl(String orginalUrl) {
        this.orginalUrl = orginalUrl;
    }

    public String getOrginalUrl() {
        return this.orginalUrl;
    }

    public void setRawImageUrl(String rawImageUrl) {
        this.rawImageUrl = rawImageUrl;
    }

    public String getRawImageUrl() {
        return this.rawImageUrl;
    }
}