package thirdparty.sohu.statues;


import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.sohu.SohuInput;

/**
 * @author : shangrenpengsq
 *         Date: 13-12-2
 *         Time: 下午2:47
 * @describe :这个类有两种Output，如果是page方式请求，请使用
 * <p/>
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */
public class FriendsTimelineInput extends SohuInput {
    private final static String apiURL = "http://api.t.sohu.com/statuses/friends_timeline.json";
    private String max_id;//最大微博id，传递这个id之后，会返回比指定微博更早的
    // 微博。在传递了max_id之后，cursor和page都将不再起作用，它具有最高优先级。
    private String since;//更新起始时间点，只获取since时间之后的更新，但是since
    // 必须是24小时内的某个时间，时间格式：Fri Mar 12 22:21:42 +0800 2010
    private String since_id;//获取指定的文章id之后的更新，这是一个长整型变量。
    private int page;//当前的页数(一旦传递了cursor值，page方式将会失效）
    private String cursor;//下一页的cursor_id(cursor分页方式，点击查看更多)
    private int count;//每页条数

    public FriendsTimelineInput(String accessToken, String accessSecret,
                                int page, int count){
        this.userAccessToken = new AccessToken(accessToken,accessSecret);
        this.page = page;
        this.count = count;

        httpMethod = "GET";

        bodyArgs.add(new Arg("page", String.valueOf(this.page)));
        bodyArgs.add(new Arg("count", String.valueOf(this.count)));

        headers.add(oauthHelper.generateAuthorizationHeader( httpMethod,
                apiURL, bodyArgs,seperator, userAccessToken));
    }

    /**
     * 必须带有page，如果不带有page参数搜狐微博就无法运行了
     * @param accessToken
     * @param accessSecret
     * @param since_id
     * @param page
     * @param count
     */
    public FriendsTimelineInput(String accessToken, String accessSecret,
                                String since_id, int page, int count){
        this.userAccessToken = new AccessToken(accessToken,accessSecret);
        this.page = page;
        this.count = count;
        this.since_id = since_id;

        httpMethod = "GET";

        bodyArgs.add(new Arg("page", String.valueOf(this.page)));
        bodyArgs.add(new Arg("count", String.valueOf(this.count)));
        bodyArgs.add(new Arg("since_id",this.since_id));

        headers.add(oauthHelper.generateAuthorizationHeader( httpMethod,
                apiURL, bodyArgs,seperator, userAccessToken));
    }

    @Override
    protected String getUrl() {
        return apiURL;
    }
}
