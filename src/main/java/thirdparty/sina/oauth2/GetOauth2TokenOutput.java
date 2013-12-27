/**
 * 
 */
package thirdparty.sina.oauth2;

import thirdparty.ThirdPartyRefreshToken;
import thirdparty.sina.oauth1.SinaOauth1Output;

/**
 * @author : shangrenpeng
 * @fileName : com.feinno.message.thirdparty.sina.oauth2.statuses.Update.java
 *
 * date		| author	| version	|  
 * 2012-9-20	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-9-20 下午8:34:16
 *
 */
public class GetOauth2TokenOutput extends SinaOauth1Output implements ThirdPartyRefreshToken {
	private String access_token;//用户token
	private String refresh_token;//用户刷新token
	private long expires_in;//过期时间
	/**
	 * @return the access_token
	 */
	public String getAccess_token() {
		return access_token;
	}
	/**
	 * @param access_token the access_token to set
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	/**
	 * @return the refresh_token
	 */
	public String getRefresh_token() {
		return refresh_token;
	}
	/**
	 * @param refresh_token the refresh_token to set
	 */
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	/**
	 * @return the expires_in
	 */
	public long getExpires_in() {
		return expires_in;
	}
	/**
	 * @param expires_in the expires_in to set
	 */
	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}

    @Override
    public String getAccessToken() {
        return access_token;
    }

    @Override
    public long getExpireIn() {
        return expires_in * 1000 + System.currentTimeMillis();
    }

    @Override
    public String getRefreshToken() {
        return refresh_token;
    }
}
