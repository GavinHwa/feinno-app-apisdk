package thirdparty.sohu.statues;


import thirdparty.sohu.SohuOutput;
import thirdparty.sohu.User;

/**
 * @author : shangrenpengsq
 *         Date: 13-12-2
 *         Time: 下午2:54
 * @describe :
 * <p/>
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */
public class CommentOutput extends SohuOutput {
    private String id;//1093373
    private String text;
    private String source;
    private boolean favorited;
    private boolean truncated;
    private String created_at;//Tue Mar 16 17:45:55 +0800 2010
    private User user;

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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
