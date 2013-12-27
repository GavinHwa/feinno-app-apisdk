package thirdparty.oauth;

public class AppToken {
	private String token;
	private String tokenSecret;
	
	public AppToken(String appKey, String appSecret) {
		token = appKey;
		tokenSecret = appSecret;
	}
	public AppToken setToken(String token) {
		this.token = token;
		return this;
	}
	public String getToken() {
		return token;
	}
	public AppToken setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
		return this;
	}
	public String getTokenSecret() {
		return tokenSecret;
	}
	
}
