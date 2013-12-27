package thirdparty.renren.renrenAPIv2;

/**
 * 新鲜事的评论
 */
public class FeedComment {

    /**
     * 评论id
     */
    private long id;
    /**
     * 评论时间
     */
    private String time;
    /**
     * 评论的用户，用户对象中只有id name avatar 字段有效，其他字段无效
     */
    private User author;
    /**
     * 评论内容
     */
    private String content;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getAuthor() {
        return this.author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }
}