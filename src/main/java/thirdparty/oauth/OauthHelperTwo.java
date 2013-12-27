package thirdparty.oauth;

import com.ning.http.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class OauthHelperTwo implements OauthHelper {
	// 不会变的参数
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OauthHelperTwo.class);
	private static final String HMAC_SHA1 = "HmacSHA1";
	private static final String oauth_consumer_key = "oauth_consumer_key";
	private static final String oauth_timestamp = "oauth_timestamp";
	private static final String oauth_nonce = "oauth_nonce";
	private static final Charset UTF8 = Charset.forName("UTF-8");
	private static final Arg OAUTH_SIGNATURE_METHOD = new Arg(
			"oauth_signature_method", "HMAC-SHA1");
	private static final String oauth_version = "1.0";
	// 会变的参数
	protected Random RAND = new Random();
	private AppToken appToken = null;

	public OauthHelperTwo(AppToken appToken) {
		this.appToken = appToken;
	}

	public OauthHelperTwo(String appKey, String appSecret) {
		this.appToken = new AppToken(appKey, appSecret);
	}

	@Override
	public Arg generateAuthorizationHeader(String method, String url,
			List<Arg> params, String seprater, AccessToken accessToken) {
		long timestamp = System.currentTimeMillis() / 1000;
		long nonce = timestamp + RAND.nextInt();
		return new Arg("Authorization", generateAuthorizationHeader(method,
				url, params, String.valueOf(nonce), String.valueOf(timestamp),
				seprater, accessToken));
	}

	protected String generateAuthorizationHeader(String method, String url,
			List<Arg> params, String nonce, String timestamp, String seprater,
			AccessToken accessToken) {

		List<Arg> oauthHeaderParams = new ArrayList<Arg>(5);
		if (accessToken != null) {
			oauthHeaderParams.add(new Arg(oauth_consumer_key, appToken
					.getToken()));
		}
		oauthHeaderParams.add(OAUTH_SIGNATURE_METHOD);
		oauthHeaderParams.add(new Arg(oauth_timestamp, timestamp));
		oauthHeaderParams.add(new Arg(oauth_nonce, nonce));
		oauthHeaderParams.add(new Arg("oauth_version", oauth_version));
		if (accessToken != null) {
			oauthHeaderParams
					.add(new Arg("oauth_token", accessToken.getToken()));
		}

		List<Arg> signatureBaseParams = null;
		if (params != null) {
			signatureBaseParams = new ArrayList<Arg>(oauthHeaderParams.size()
					+ params.size());
			signatureBaseParams.addAll(oauthHeaderParams);
			signatureBaseParams.addAll(params);
			parseGetParameters(url, signatureBaseParams);
		} else {
			signatureBaseParams = new ArrayList<Arg>(oauthHeaderParams.size());
			signatureBaseParams.addAll(oauthHeaderParams);
			parseGetParameters(url, signatureBaseParams);
		}

		StringBuffer base = new StringBuffer(method)
				.append("&")
				.append(encode(constructRequestURL(url)))
				.append("&")
				.append(encode(normalizeRequestParameters(signatureBaseParams)));

		String signature = generateSignature(base.toString(), accessToken);

		oauthHeaderParams.add(new Arg("oauth_signature", signature));
		return "OAuth " + encodeParameters(oauthHeaderParams, seprater, true);// 默认逗号，但是腾讯需要&
	}

	protected void parseGetParameters(String url, List<Arg> signatureBaseParams) {
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
			} catch (UnsupportedEncodingException e) {
				LOGGER.error("不支持的编码，检查下是不是UTF8？");
			}
		}
	}

	protected String normalizeRequestParameters(List<Arg> params) {
		Collections.sort(params);
		return encodeParameters(params);
	}

	private String encodeParameters(List<Arg> postParams) {
		return encodeParameters(postParams, "&", false);
	}

	protected String encodeParameters(List<Arg> postParams, String splitter,
			boolean quot) {
		StringBuffer buf = new StringBuffer();
		for (Arg param : postParams) {
			if (buf.length() != 0) {
				if (quot) {
					buf.append("\"");
				}
				buf.append(splitter);
			}
			buf.append(encode(param.getName())).append("=");
			if (quot) {
				buf.append("\"");
			}
			if (param.getValue() != null) {
				buf.append(encode(param.getValue()));
			}
		}
		if (buf.length() != 0) {
			if (quot) {
				buf.append("\"");
			}
		}
		return buf.toString();
	}

	protected String constructRequestURL(String url) {
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

	protected String generateSignature(String data, AccessToken token) {
		byte[] byteHMAC = null;
		try {
			Mac mac = Mac.getInstance(HMAC_SHA1);

			String oauthSignature = encode(appToken.getTokenSecret()) + "&";
			if (token != null) {
				oauthSignature += encode(token.getTokenSecret());
			}

			SecretKeySpec spec = new SecretKeySpec(oauthSignature.getBytes(),
					HMAC_SHA1);

			mac.init(spec);

			byteHMAC = mac.doFinal(data.getBytes());

		} catch (InvalidKeyException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("不支持的算法，检查下是不是HMAC_SHA1？");
		}

		return new String(Base64.encode(byteHMAC).getBytes(), UTF8);
		// return new String(Base64.encodeBase64(byteHMAC), UTF8);
	}

	public static String encode(String value) {
		String encoded = null;
		try {
			encoded = URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException ignore) {
			return "";
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
}
