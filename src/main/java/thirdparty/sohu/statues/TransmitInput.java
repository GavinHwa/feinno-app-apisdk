package thirdparty.sohu.statues;


import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.oauth.OauthHelperOne;
import thirdparty.sohu.SohuInput;

/**
 * @author : shangrenpengsq
 *         Date: 13-12-2
 *         Time: 下午2:47
 * @describe :这个类有两种Output，如果是page方式请求，请使用
 * <p/>
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */
public class TransmitInput extends SohuInput {
    private String apiURL = "http://api.t.sohu.com/statuses/transmit/%s.json";
    private String status;
    private String id;

    public TransmitInput(String accessToken, String accessSecret, String id, String status){
        this.userAccessToken = new AccessToken(accessToken,accessSecret);
        this.status = OauthHelperOne.encode(status);
        this.id = id;

        bodyArgs.add(new Arg("status", this.status));
        apiURL = String.format(apiURL,this.id);

        headers.add(oauthHelper.generateAuthorizationHeader(httpMethod,
                apiURL, bodyArgs, seperator, userAccessToken));
    }

    @Override
    protected String getUrl() {
        return apiURL;
    }
}
