package thirdparty.sohu;

import com.feinno.app.feed.activitystreams.Activity;
import thirdparty.SnsException;
import thirdparty.ThirdPartyFeed;

import java.util.List;

/**
 * @author : shangrenpengsq
 *         Date: 13-12-2
 *         Time: 下午5:01
 * @describe :
 * <p/>
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */
public class Status implements ThirdPartyFeed{
    private String created_at;//Wed Nov 09 10:41:04 +0800 2011
    private String id;//2235572853
    private String text;//分享图片
    private String source;//搜狐微博
    private boolean favorited;//false
    private boolean truncated;//false
    private String in_relpy_to_status_id;
    private String in_reply_to_user_id;
    private String in_reply_to_screen_name;
    private String in_reply_to_status_text;
    private String small_pic;//http://s1.t.itc.cn/mblog/pic/201111_9_10/f_6032719662565615.jpg
    private String middle_pic;//http://s1.t.itc.cn/mblog/pic/201111_9_10/m_6032719662565615.jpg
    private String original_pic;//http://s1.t.itc.cn/mblog/pic/201111_9_10/6032719662565615.jpg
    private User user;
    //    private String coordinates;
    private boolean in_reply_to_has_image;//false
    private List<Pic> pics;
    private Status retweeted_status;

    @Override
    public Activity toActivity() throws SnsException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAvailable() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public String getIn_relpy_to_status_id() {
        return in_relpy_to_status_id;
    }

    public void setIn_relpy_to_status_id(String in_relpy_to_status_id) {
        this.in_relpy_to_status_id = in_relpy_to_status_id;
    }

    public String getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    public void setIn_reply_to_user_id(String in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public String getIn_reply_to_screen_name() {
        return in_reply_to_screen_name;
    }

    public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    public String getIn_reply_to_status_text() {
        return in_reply_to_status_text;
    }

    public void setIn_reply_to_status_text(String in_reply_to_status_text) {
        this.in_reply_to_status_text = in_reply_to_status_text;
    }

    public String getSmall_pic() {
        return small_pic;
    }

    public void setSmall_pic(String small_pic) {
        this.small_pic = small_pic;
    }

    public String getMiddle_pic() {
        return middle_pic;
    }

    public void setMiddle_pic(String middle_pic) {
        this.middle_pic = middle_pic;
    }

    public String getOriginal_pic() {
        return original_pic;
    }

    public void setOriginal_pic(String original_pic) {
        this.original_pic = original_pic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isIn_reply_to_has_image() {
        return in_reply_to_has_image;
    }

    public void setIn_reply_to_has_image(boolean in_reply_to_has_image) {
        this.in_reply_to_has_image = in_reply_to_has_image;
    }

    public List<Pic> getPics() {
        return pics;
    }

    public void setPics(List<Pic> pics) {
        this.pics = pics;
    }

    public Status getRetweeted_status() {
        return retweeted_status;
    }

    public void setRetweeted_status(Status retweeted_status) {
        this.retweeted_status = retweeted_status;
    }
}
