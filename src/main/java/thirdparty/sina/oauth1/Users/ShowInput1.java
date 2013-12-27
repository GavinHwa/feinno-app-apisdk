package thirdparty.sina.oauth1.Users;


import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.sina.oauth1.SinaOauth1Input;

/**
 * Created with IntelliJ IDEA.
 * User: shangrenpeng
 * Date: 13-6-17
 * Time: 下午3:58
 * To change this template use File | Settings | File Templates.
 */
public class ShowInput1 extends SinaOauth1Input {
    private final static String apiURL = "http://api.t.sina.com.cn/users/show.json";

    private long user_id;//false 	int64 	用户ID，主要是用来区分用户ID跟微博昵称。当微博昵称为数字导致和用户ID产生歧义，特别是当微博昵称和用户ID一样的时候，建议使用该参数
    private String screen_name;//false 	string 	微博昵称，主要是用来区分用户UID跟微博昵称，当二者一样而产生歧义的时候，建议使用该参数

    public ShowInput1(String accessToken, String accessSecret, String screen_name){
        httpMethod = "GET";
        this.screen_name = screen_name;
        this.userAccessToken = new AccessToken(accessToken, accessSecret);
        bodyArgs.add(new Arg("screen_name", this.screen_name));
        headers.add(oauthHelper.generateAuthorizationHeader( httpMethod, apiURL,bodyArgs,
                seperator, userAccessToken));
    }

    public ShowInput1(String accessToken, String accessSecret, long user_id){
        httpMethod = "GET";
        this.user_id = user_id;
        this.userAccessToken = new AccessToken(accessToken, accessSecret);
        bodyArgs.add(new Arg("user_id", String.valueOf(this.user_id)));
        headers.add(oauthHelper.generateAuthorizationHeader( httpMethod, apiURL,bodyArgs,
                seperator, userAccessToken));
    }


    /* (non-Javadoc)
     * @see thirdparty.Input#getUrl()
     */
    @Override
    protected String getUrl() {
        return apiURL;
    }

}
