package thirdparty.oauth;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OAuthTencent implements OauthHelper{

	private static final String HMAC_SHA1 = "HmacSHA1";
	private String consumerKey;
	private String consumerSecret;
	private static final Arg OAUTH_SIGNATURE_METHOD = new Arg(
			"oauth_signature_method", "HMAC-SHA1");

	public OAuthTencent(String consumerKey, String consumerSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}

	public static String encode(String value) {
		String encoded = null;
		try {
			encoded = URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException ignore) {
		}
		StringBuffer buf = new StringBuffer(encoded.length());
		char focus;
		for (int i = 0; i < encoded.length(); i++) {
			focus = encoded.charAt(i);
			if (focus == '*') {
				buf.append("%2A");
			} else if (focus == '+') {
				buf.append("%20");
			} else if (focus == '%' && (i + 1) < encoded.length()
					&& encoded.charAt(i + 1) == '7'
					&& encoded.charAt(i + 2) == 'E') {
				buf.append('~');
				i += 2;
			} else {
				buf.append(focus);
			}
		}
		return buf.toString();
	}

	private static final Charset UTF8 = Charset.forName("UTF-8");

	public String generateSignature(String data, AccessToken token) {
		byte[] byteHMAC = null;
		try {
			Mac mac = Mac.getInstance(HMAC_SHA1);

			String oauthSignature = encode(consumerSecret) + "&";
			if (token != null) {
				oauthSignature += encode(token.getTokenSecret());
			}

			SecretKeySpec spec = new SecretKeySpec(oauthSignature.getBytes(),
					HMAC_SHA1);

			mac.init(spec);

			byteHMAC = mac.doFinal(data.getBytes());

		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException ignore) {
			// should never happen
		}

		return new String(Base64.encodeBase64(byteHMAC), UTF8);
	}

	private void parseGetParameters(String url,
			List<Arg> signatureBaseParams) {
		int queryStart = url.indexOf("?");
		if (-1 != queryStart) {
			String[] queryStrs = url.substring(queryStart + 1).split("&");
			try {
				for (String query : queryStrs) {
					String[] split = query.split("=");
					if (split.length == 2) {
						signatureBaseParams.add(new Arg(URLDecoder.decode(
								split[0], "UTF-8"), URLDecoder.decode(split[1],
								"UTF-8")));
					} else {
						signatureBaseParams.add(new Arg(URLDecoder.decode(
								split[0], "UTF-8"), ""));
					}
				}
			} catch (UnsupportedEncodingException ignore) {
			}
		}
	}

	private String normalizeRequestParameters(List<Arg> params) {
		Collections.sort(params);
		return encodeParameters(params);
	}

	private String encodeParameters(List<Arg> postParams) {
		return encodeParameters(postParams, "&", false);
	}

	private String encodeParameters(List<Arg> postParams, String splitter,
			boolean quot) {
		StringBuffer buf = new StringBuffer();
		for (Arg param : postParams) {
			if (buf.length() != 0) {
				if (quot) {
					buf.append("\"");
				}
				buf.append(splitter);
			}
			buf.append(encode(param.name)).append("=");
			if (quot) {
				buf.append("\"");
			}
			buf.append(encode(param.value));
		}
		if (buf.length() != 0) {
			if (quot) {
				buf.append("\"");
			}
		}
		return buf.toString();
	}

	private String constructRequestURL(String url) {
		int index = url.indexOf("?");
		if (-1 != index) {
			url = url.substring(0, index);
		}
		int slashIndex = url.indexOf("/", 8);
		String baseURL = url.substring(0, slashIndex).toLowerCase();
		int colonIndex = baseURL.indexOf(":", 8);
		if (-1 != colonIndex) {
			// url contains port number
			if (baseURL.startsWith("http://") && baseURL.endsWith(":80")) {
				// http default port 80 MUST be excluded
				baseURL = baseURL.substring(0, colonIndex);
			} else if (baseURL.startsWith("https://")
					&& baseURL.endsWith(":443")) {
				// http default port 443 MUST be excluded
				baseURL = baseURL.substring(0, colonIndex);
			}
		}
		url = baseURL + url.substring(slashIndex);

		return url;
	}

	private Random RAND = new Random();

	public String generateAuthorizationHeaderTencent(String method, String url,
			List<Arg> params, AccessToken token) {
		long timestamp = System.currentTimeMillis() / 1000;
		long nonce = timestamp + RAND.nextInt();
		return generateAuthorizationHeader(method, url, params,
				String.valueOf(nonce), String.valueOf(timestamp), token);
	}

	private String generateAuthorizationHeader(String method, String url,
			List<Arg> params, String nonce, String timestamp,
			AccessToken otoken) {

		List<Arg> oauthHeaderParams = new ArrayList<Arg>(5);
		oauthHeaderParams.add(new Arg("oauth_consumer_key", consumerKey));
		oauthHeaderParams.add(OAUTH_SIGNATURE_METHOD);
		oauthHeaderParams.add(new Arg("oauth_timestamp", timestamp));
		oauthHeaderParams.add(new Arg("oauth_nonce", nonce));
		oauthHeaderParams.add(new Arg("oauth_version", "1.0"));
		if (otoken != null) {
			oauthHeaderParams
					.add(new Arg("oauth_token", otoken.getToken()));
		}

		List<Arg> signatureBaseParams = null;
		if (params != null) {
			signatureBaseParams = new ArrayList<Arg>(
					oauthHeaderParams.size() + params.size());
			signatureBaseParams.addAll(oauthHeaderParams);
			signatureBaseParams.addAll(params);
			parseGetParameters(url, signatureBaseParams);
		} else {
			signatureBaseParams = new ArrayList<Arg>(
					oauthHeaderParams.size());
			signatureBaseParams.addAll(oauthHeaderParams);
			parseGetParameters(url, signatureBaseParams);
		}

		Collections.sort(signatureBaseParams);
		StringBuffer base = new StringBuffer(method)
				.append("&")
				.append(encode(constructRequestURL(url)))
				.append("&")
				.append(encode(normalizeRequestParameters(signatureBaseParams)));

		String signature = generateSignature(base.toString(), otoken);

		if (params != null){
			oauthHeaderParams.addAll(params);
		}
		Collections.sort(oauthHeaderParams);
		oauthHeaderParams.add(new Arg("oauth_signature", signature));
		params.clear();
		params.addAll(oauthHeaderParams);//可以把oauth参数加入到entity内
		return encodeParameters(oauthHeaderParams, "&", false);
	}

	/* (non-Javadoc)
	 * @see thirdparty.oauth.OauthHelper#generateAuthorizationHeader(java.lang.String, java.lang.String, java.util.List, java.lang.String, thirdparty.oauth.AccessToken)
	 */
	@Override
	public Arg generateAuthorizationHeader(String method, String url,
			List<Arg> params, String seprater, AccessToken accessToken) {
		// TODO Auto-generated method stub
		return null;
	}
}
