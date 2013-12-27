package thirdparty.oauth;

import java.util.List;

public interface OauthHelper {
	public Arg generateAuthorizationHeader(String method, String url,
			List<Arg> params, String seprater, AccessToken accessToken);
}
