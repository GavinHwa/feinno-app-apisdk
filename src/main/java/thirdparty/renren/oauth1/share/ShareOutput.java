/**
 * 
 */
package thirdparty.renren.oauth1.share;


/**
 * @author : shangrenpeng
 * @fileName : com.feinno.messages.thirdparty.sina.oauth2.remind.UnreadCount.java
 *
 * date		| author	| version	|  
 * 2012-9-20	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.renren.oauth1.RenRenOutput;

/**
 * @author shangrenpeng
 * @date 2012-9-20 下午5:48:44
 * 
 */
public class ShareOutput extends RenRenOutput {
    private long id;//	long	分享的ID
    private int user_id;//	int	发起本次分享的用户ID
    private int original_user_id;//	int	最初发起此分享的用户ID，若为0，表示user_id即为original_user_id
    private long resource_id;//	long	被分享资源的ID
    private int resource_owner_id;//	int	被分享资源所有者的用户ID
    private String title;//	string	分享的标题
    private String url;//	string	分享的链接地址
    private String thumbnail_url;//	string	分享的缩略图
    private String summary;//	string	分享的内容的摘要
    private int comment_count;//	int	分享被评论的次数
    private String share_time;//	string	分享产生的时间
    private int my_like;//	int	当前access_token(或session_key)对应用户是否like（赞）
    private int like_count;//	int	分享被like（赞）的次数

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOriginal_user_id() {
        return original_user_id;
    }

    public void setOriginal_user_id(int original_user_id) {
        this.original_user_id = original_user_id;
    }

    public long getResource_id() {
        return resource_id;
    }

    public void setResource_id(long resource_id) {
        this.resource_id = resource_id;
    }

    public int getResource_owner_id() {
        return resource_owner_id;
    }

    public void setResource_owner_id(int resource_owner_id) {
        this.resource_owner_id = resource_owner_id;
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

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getShare_time() {
        return share_time;
    }

    public void setShare_time(String share_time) {
        this.share_time = share_time;
    }

    public int getMy_like() {
        return my_like;
    }

    public void setMy_like(int my_like) {
        this.my_like = my_like;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }
}
