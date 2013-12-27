/**
 * 
 */
package thirdparty.sina;


/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.Status.java
 *
 * date		| author	| version	|  
 * 2012-9-28	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import config.MessageConfig;
import com.feinno.DateUtils;
import com.feinno.HtmlHelper;
import com.feinno.app.feed.activitystreams.Activity;
import com.feinno.app.feed.activitystreams.ActivityPhoto;
import com.feinno.app.feed.activitystreams.ActivitySource;
import com.feinno.app.feed.activitystreams.ActivityStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thirdparty.JsonSerializableClass;
import thirdparty.SnsException;
import thirdparty.ThirdPartyFeed;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author	shangrenpeng
 * @date	2012-9-28 下午5:36:07
 *
 */
public class Status extends JsonSerializableClass implements ThirdPartyFeed {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(Status.class);
	private String created_at;// 微博创建时间
	private String id;// 微博ID
	private String mid;// 微博MID
	private String idstr;// 字符串型的微博ID
	private String text;// 微博信息内容
	private String source;// 微博来源
	private boolean favorited;// 是否已收藏，true：是，false：否
	private boolean truncated;// 是否被截断，true：是，false：否
	private String in_reply_to_status_id;// 回复ID
	private String in_reply_to_user_id;// 回复人UID
	private String in_reply_to_screen_name;// 回复人昵称
	private String thumbnail_pic;// 缩略图片地址，没有时不返回此字段
	private String bmiddle_pic;// 中等尺寸图片地址，没有时不返回此字段
	private String original_pic;// 原始图片地址，没有时不返回此字段
	private Geo geo;// 地理信息字段
	private String uid;//如果trim_user开启，那么有uid而没有user对象
	private User user;// 微博作者的用户信息字段
	private Status retweeted_status;
	private String reposts_count;// 转发数
	private String comments_count;// 评论数
	private String attitudes_count;// 暂未支持
	private String mlevel;// 暂未支持
	private Visible visible;// 暂未支持

    private final static ActivitySource FROM_SINA = new ActivitySource();
    static {
        FROM_SINA.setId(String.valueOf(MessageConfig.sinaServiceId));
        FROM_SINA.setIcon("/service/icon/pre_weibo_16.png");
        FROM_SINA.setPermalink("http://weibo.com");
        FROM_SINA.setTitle("新浪微博");
    }

//	private List<Annotations> annotations;//暂时不实现
	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the mid
	 */
	public String getMid() {
		return mid;
	}
	/**
	 * @param mid the mid to set
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}
	/**
	 * @return the idstr
	 */
	public String getIdstr() {
		return idstr;
	}
	/**
	 * @param idstr the idstr to set
	 */
	public void setIdstr(String idstr) {
		this.idstr = idstr;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
     * 此处依赖json解析实现，是通过setText来保存的，因此会转义表情到飞信表情
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = SinaEmotionTransformer.transform2Our(text);
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the in_reply_to_status_id
	 */
	public String getIn_reply_to_status_id() {
		return in_reply_to_status_id;
	}
	/**
	 * @param in_reply_to_status_id the in_reply_to_status_id to set
	 */
	public void setIn_reply_to_status_id(String in_reply_to_status_id) {
		this.in_reply_to_status_id = in_reply_to_status_id;
	}
	/**
	 * @return the in_reply_to_user_id
	 */
	public String getIn_reply_to_user_id() {
		return in_reply_to_user_id;
	}
	/**
	 * @param in_reply_to_user_id the in_reply_to_user_id to set
	 */
	public void setIn_reply_to_user_id(String in_reply_to_user_id) {
		this.in_reply_to_user_id = in_reply_to_user_id;
	}
	/**
	 * @return the in_reply_to_screen_name
	 */
	public String getIn_reply_to_screen_name() {
		return in_reply_to_screen_name;
	}
	/**
	 * @param in_reply_to_screen_name the in_reply_to_screen_name to set
	 */
	public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
		this.in_reply_to_screen_name = in_reply_to_screen_name;
	}
	/**
	 * @return the thumbnail_pic
	 */
	public String getThumbnail_pic() {
		return thumbnail_pic;
	}
	/**
	 * @param thumbnail_pic the thumbnail_pic to set
	 */
	public void setThumbnail_pic(String thumbnail_pic) {
		this.thumbnail_pic = thumbnail_pic;
	}
	/**
	 * @return the bmiddle_pic
	 */
	public String getBmiddle_pic() {
		return bmiddle_pic;
	}
	/**
	 * @param bmiddle_pic the bmiddle_pic to set
	 */
	public void setBmiddle_pic(String bmiddle_pic) {
		this.bmiddle_pic = bmiddle_pic;
	}
	/**
	 * @return the original_pic
	 */
	public String getOriginal_pic() {
		return original_pic;
	}
	/**
	 * @param original_pic the original_pic to set
	 */
	public void setOriginal_pic(String original_pic) {
		this.original_pic = original_pic;
	}
	/**
	 * @return the geo
	 */
	public Geo getGeo() {
		return geo;
	}
	/**
	 * @param geo the geo to set
	 */
	public void setGeo(Geo geo) {
		this.geo = geo;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the reposts_count
	 */
	public String getReposts_count() {
		return reposts_count;
	}
	/**
	 * @param reposts_count the reposts_count to set
	 */
	public void setReposts_count(String reposts_count) {
		this.reposts_count = reposts_count;
	}
	/**
	 * @return the comments_count
	 */
	public String getComments_count() {
		return comments_count;
	}
	/**
	 * @param comments_count the comments_count to set
	 */
	public void setComments_count(String comments_count) {
		this.comments_count = comments_count;
	}
	/**
	 * @return the attitudes_count
	 */
	public String getAttitudes_count() {
		return attitudes_count;
	}
	/**
	 * @param attitudes_count the attitudes_count to set
	 */
	public void setAttitudes_count(String attitudes_count) {
		this.attitudes_count = attitudes_count;
	}
	/**
	 * @return the mlevel
	 */
	public String getMlevel() {
		return mlevel;
	}
	/**
	 * @param mlevel the mlevel to set
	 */
	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}
	/**
	 * @return the visible
	 */
	public Visible getVisible() {
		return visible;
	}
	/**
	 * @param visible the visible to set
	 */
	public void setVisible(Visible visible) {
		this.visible = visible;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Status getRetweeted_status() {
		return retweeted_status;
	}
	public void setRetweeted_status(Status retweeted_status) {
		this.retweeted_status = retweeted_status;
	}
	public boolean isFavorited() {
		return favorited;
	}
	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}
	public boolean isTruncated() {
		return truncated;
	}
	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}

    @Override
    public Activity toActivity() throws SnsException {
        if (isAvailable()){
            Activity activity = new Activity();

            activity.setVerb("post");
            try{
                activity.setPublished(DateUtils.long2String(getTimeStamp(created_at)));
            } catch (SnsException e){
                LOGGER.warn(e.getMessage(), e);
            }
            activity.setId(idstr);

            activity.setSource(FROM_SINA);

            activity.setAuthor(user.getThirdPartyAuthor());

            if (retweeted_status != null){//不需要再判断是否available，因为最外层的判断已经包含
                activity.setCategory("status:republish");
                activity.setObject(retweeted_status.toActivity());
                activity.setSummary(HtmlHelper.encode(text));
            } else {
            //有转发和没有转发的时候，summary的位置都不一样。
            // WARNING:原有设计不太合理，但是已经无法改动
                activity.setCategory("status:publish");
                ActivityStatus feedContent = new ActivityStatus();

                feedContent.setSummary(HtmlHelper.encode(text));

                if (containsPicture()) {
                    ActivityPhoto photo = new ActivityPhoto();
                    photo.setThumbnail(thumbnail_pic);
                    photo.setPermalink(bmiddle_pic);
                    photo.setUrl(original_pic);
                    feedContent.setPhoto(photo);
                }

                activity.setObject(feedContent);
            }
            return activity;
        }else{
            throw new SnsException(this.toJson());
        }
    }

    private boolean containsPicture() {
        return thumbnail_pic != null && bmiddle_pic != null
                && original_pic != null;
    }


    private long getTimeStamp(String created_at) throws SnsException {
        if (created_at != null) {
            DateFormat sdf = new SimpleDateFormat(
                    "EEE MMM dd HH:mm:ss ZZZZ yyyy", Locale.ENGLISH);

            try {
                Date date = sdf.parse(created_at);
                return date.getTime();
            } catch (ParseException e) {
                throw new SnsException("Parse Sina TimeError,Please Fix!It " +
                        "will be set to currentMillis now!",e);
            }
        }
        return System.currentTimeMillis();
    }


    @Override
    public boolean isAvailable() {
        if (missingEssentialArgs() || isHidden() || containsHarmfulCharactors()) {
            return false;
        }

        if (retweeted_status != null){
            return retweeted_status.isAvailable();
        }
        return true;
    }

    private static String[] harmfulCharactors = {"سمَـَّوُوُحخ"};

    private boolean containsHarmfulCharactors() {
        for(String harmfulString : harmfulCharactors){
            if (text.contains(harmfulString)){
                return true;
            }
        }
        return false;
    }

    /**
     * 即便是用户自己发布的动态，也不见得希望发布在同窗的公共领域。因此不需要
     * @return
     */
    private boolean isHidden() {
        if (visible != null){
            return !"0".equals(visible.getType());//0表示公开
        }
        return false;
    }

    private boolean missingEssentialArgs() {
        if (missingUser() || missingMessage()) {
            return true;
        }
        return false;
    }

    private boolean missingMessage() {
        return text == null;
    }

    private boolean missingUser() {
        return user == null || user.getId() == null;
    }
}
