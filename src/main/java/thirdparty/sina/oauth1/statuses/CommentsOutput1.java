/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectReader;
import thirdparty.sina.oauth1.SinaOauth1Output;
import com.ning.http.client.Response;
import thirdparty.sina.Comment;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.HomeTimelineMerchandise.java
 *
 * date		| author	| version	|  
 * 2012-9-24	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * 使用status的数组形式就行，不用类封装了
 * 
 * @author shangrenpeng
 * @date 2012-9-24 下午5:24:30
 * 
 */

public class CommentsOutput1 extends SinaOauth1Output {

	private List<Comment> comments = new LinkedList<Comment>();

	static TypeReference<List<Comment>> type = new TypeReference<List<Comment>>() {
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
				error = e.getMessage();
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
				comments = (mapper.readValue(content, type));
			} catch (JsonMappingException e) {//正常的status解析不出来，估计就是error返回了，解析一下error吧！
				ObjectReader reader = mapper.readerForUpdating(this);
				reader.readValue(content);
			}
		}
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}