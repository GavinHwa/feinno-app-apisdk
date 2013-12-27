package thirdparty.renren.renrenAPIv2;

/**
 * 新鲜事包含的资源
 */
public class FeedResource {

    /**
     * 资源id eg:16345698797
     */
    private long id;
    /**
     * 资源标题 eg:【WoDotA荣誉出品】每周DotA Top10第一百二十弹
     */
    private String title;
    /**
     * 资源的内容 eg:各位平安夜快乐！今天给各位带来吊炸天的一期Top10~~愿你平安夜不孤单！！！！
     */
    private String content;
    /**
     * 资源的url地址 eg:"http://share.renren.com/share/389414346/16345698797?from=0101010302&ref=newsfeed&sfet=110&fin=0&fid=23559979661&ff_id=389414346&platform=8&expose_time=1378259500
     */
    private String url;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}