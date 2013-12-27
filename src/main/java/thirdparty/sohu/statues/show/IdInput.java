package thirdparty.sohu.statues.show;


import thirdparty.oauth.AccessToken;
import thirdparty.sohu.SohuInput;

/**
 * @author : shangrenpengsq
 *         Date: 13-12-2
 *         Time: 下午2:47
 * @describe :这个类有两种Output，如果是page方式请求，请使用
 * <p/>
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */
public class IdInput extends SohuInput {
    private String apiURL = "http://api.t.sohu.com/statuses/show/%s.json";
    private String id;//feedid

    public IdInput(String accessToken, String accessSecret,String id){
        this.userAccessToken = new AccessToken(accessToken,accessSecret);
        this.id = id;

        httpMethod = "GET";

        apiURL = String.format(apiURL,this.id);

        headers.add(oauthHelper.generateAuthorizationHeader(httpMethod,
                apiURL, bodyArgs,seperator, userAccessToken));
    }

    @Override
    protected String getUrl() {
        return apiURL;
    }
}
