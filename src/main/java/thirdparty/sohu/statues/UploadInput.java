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
public class UploadInput extends SohuInput {
    private final static String apiURL = "http://api.t.sohu.com/statuses/upload.json";
    private String status;//feedid
    private byte[] pic;

    public UploadInput(String accessToken, String accessSecret, String status,byte[] pic){
        this.userAccessToken = new AccessToken(accessToken,accessSecret);
        this.status = OauthHelperOne.encode(status);
        this.pic = pic;

        bodyArgs.add(new Arg("status", this.status));

        headers.add(oauthHelper.generateAuthorizationHeader(httpMethod,
                apiURL, bodyArgs, seperator, userAccessToken));

        parts.addAll(getMultiParts(pic,bodyArgs));
        bodyArgs.clear();
    }

    @Override
    protected String getUrl() {
        return apiURL;
    }
}
