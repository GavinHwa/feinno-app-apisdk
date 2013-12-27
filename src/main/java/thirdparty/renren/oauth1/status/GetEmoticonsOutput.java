/**
 * 
 */
package thirdparty.renren.oauth1.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectReader;
import com.ning.http.client.Response;
import thirdparty.ThirdPartyEmotions;
import thirdparty.oauth.Arg;
import thirdparty.renren.oauth1.Emotion;
import thirdparty.renren.oauth1.RenRenOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : shangrenpeng
 * @fileName : com.feinno.messages.thirdparty.sina.oauth2.remind.UnreadCount.java
 *
 * date		| author	| version	|  
 * 2012-9-20	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-9-20 下午5:48:44
 * 
 */
public class GetEmoticonsOutput extends RenRenOutput implements ThirdPartyEmotions {
	private List<Emotion> emotions;


	static TypeReference<List<Emotion>> type = new TypeReference<List<Emotion>>() {
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.message.HttpConvertibleOutput#fromHttpResponse(com.ning.http
	 * .client.Response, java.lang.Throwable)
	 */
	@Override
	public void fromHttpResponse(Response response, Throwable throwable) {
		if (throwable != null){
			LOGGER.error(throwable.getMessage());
			return;
		}
		if (response.getStatusCode() == 200) {
			try {
				parseResponse(response);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				error_msg = e.getMessage();
				return;
			}
		} else {
			try {
				ObjectReader reader = mapper.readerForUpdating(this);
				reader.readValue(response.getResponseBody("UTF-8"));
				return;
			} catch (Exception e) {
				LOGGER.error(response.getStatusCode() + "\n" + e.getMessage());
				error_code = "0";
				return;
			}
		}
	}

	/**
	 * 解析返回的内容，默认已经200返回了。如果解析不了，那么this中只有error对象不为空
	 * 
	 * @param response
	 * @throws IOException
	 */
	private void parseResponse(Response response) throws Exception {
		String content;
		if ((content = response.getResponseBody("UTF-8")) != null) {
			try {
				emotions = (mapper.readValue(content, type));
			} catch (JsonMappingException e) {//正常的status解析不出来，估计就是error返回了，解析一下error吧！
				ObjectReader reader = mapper.readerForUpdating(this);
				reader.readValue(content);
			}
		}
	}

	public void setEmotions(List<Emotion> emotions) {
		this.emotions = emotions;
	}

	/* (non-Javadoc)
	 * @see com.feinno.message.ThirdPartyEmotions#getEmotions()
	 */
	@Override
	public List<Arg> getEmotions() {
		List<Arg> returnEmotions = new ArrayList<Arg>(emotions.size());
		for (Emotion emotion : emotions) {
			returnEmotions.add(new Arg(emotion.getEmotion(),emotion.getIcon()));
		}
		return returnEmotions;
	}
	
}
