package thirdparty.renren.renrenAPIv2;

import com.feinno.HtmlHelper;
import com.feinno.app.feed.activitystreams.*;
import thirdparty.ThirdPartyFeed;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: srp
 * Date: 13-9-3
 * Time: 下午6:08
 */
public class Feed implements ThirdPartyFeed {
    private static ActivitySource feedSource;

    static {
        feedSource = new ActivitySource();
        feedSource.setId("26");
        feedSource.setIcon("/service/icon/pre_renren_16.png");
        feedSource.setPermalink("http://renren.com");
        feedSource.setTitle("人人网");
    }

    /**
     * 新鲜事的id,eg:23559979661
     */
    private long id;
    /**
     * 新鲜事类型,eg:SHARE_VIDEO
     */
    private FeedType type;
    /**
     * 新鲜事触发时间2013-09-03 17:51
     */
    private String time;
    /**
     * 触发新鲜事的用户,用户对象中只有id name avatar 字段有效，其他字段无效
     */
    private User sourceUser;
    /**
     * 新鲜事内容 eg:这是飞信同步测试，请工作人员请不要删除！16
     */
    private String message;
    /**
     * 新鲜事中包含的缩略图 eg:"http://g2.ykimg.com/0100641F4650D86C7EDE28024DD1A6B4E48219-3EA9-8B95-D31A-93CC591E33FE"
     */
    private String thumbnailUrl;
    /**
     * 新鲜事中包含的资源
     */
    private FeedResource resource;
    /**
     * 新鲜事中的附加内容
     */
    private List<FeedAttachment> attachment;
    /**
     * 新鲜事来源
     */
    private Source source;
    /**
     * lbs信息
     */
    private Lbs lbs;
    /**
     * 新鲜事评论列表，只返回第一条及最后一条
     */
    private List<FeedComment> comments;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setType(FeedType type) {
        this.type = type;
    }

    public FeedType getType() {
        return this.type;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }

    public void setSourceUser(User sourceUser) {
        this.sourceUser = sourceUser;
    }

    public User getSourceUser() {
        return this.sourceUser;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setResource(FeedResource resource) {
        this.resource = resource;
    }

    public FeedResource getResource() {
        return this.resource;
    }

    public void setAttachment(List<FeedAttachment> attachment) {
        this.attachment = attachment;
    }

    public List<FeedAttachment> getAttachment() {
        return this.attachment;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Source getSource() {
        return this.source;
    }

    public void setLbs(Lbs lbs) {
        this.lbs = lbs;
    }

    public Lbs getLbs() {
        return this.lbs;
    }

    public void setComments(List<FeedComment> comments) {
        this.comments = comments;
    }

    public List<FeedComment> getComments() {
        return this.comments;
    }


    @Override
    public Activity toActivity() {
        Activity activity = new Activity();
        activity.setVerb("post");
        activity.setPublished(time + ":00");//因为原本这里就是2013-09-06 13:16,但是同窗需要2013-09-06 13:16:00这样
        activity.setSource(feedSource);

        ActivityAuthor author = sourceUser.getThirdPartyAuthor();

        activity.setCategory("status:publish");

        ActivityStatus feedContent = new ActivityStatus();

        activity.setObject(feedContent);

        feedContent.setSummary(HtmlHelper.encode(message));

        if (attachment != null && attachment.size() != 0) {

            for(FeedAttachment attach : attachment){
                appendVideoAndPhoto(feedContent, attach);
            }
        }

        return activity;
    }

    private void appendVideoAndPhoto(ActivityStatus feedContent, FeedAttachment attach) {
        switch (attach.getType()){
            case VIDEO:
                if (attach.getUrl() != null) {
                    if (feedContent.getVideo() != null) {
                        ActivityVideo video = new ActivityVideo();
                        video.setUrl(attach.getUrl());
                        feedContent.setVideo(video);
                    }
                }
                break;
            case ALBUM:
            case LINK:
                if (attach.getUrl() != null) {
                    message += attach.getUrl();
                }
                break;
            case PHOTO:
                if (attach.getOrginalUrl() != null){
                    if (feedContent.getPhoto() != null){
                        ActivityPhoto photo = new ActivityPhoto(attach.getOrginalUrl(),attach.getOrginalUrl(),
                                attach.getOrginalUrl());
                        feedContent.setPhoto(photo);
                    }
                }
                break;
            case STATUS:
                break;
            default:
                throw new RuntimeException(attach.getType() + " is not a valid attachment Type!");
        }
    }

    @Override
    public boolean isAvailable() {
        return !(noAuthor() || noMessage());
    }

    private boolean noMessage() {
        return message == null;
    }

    private boolean noAuthor() {
        return sourceUser == null;
    }
}