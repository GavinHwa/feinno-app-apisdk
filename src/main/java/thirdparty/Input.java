/**
 *
 */
package thirdparty;

import com.ning.http.client.*;
import com.ning.http.multipart.StringPart;
import config.MessageConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thirdparty.oauth.Arg;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.Order.java
 *
 * date		| author	| version	|  
 * 2012-9-22	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * 这是所有的输入文件的基础
 * 
 * @author shangrenpeng
 * @date 2012-9-22 下午7:48:10
 * 
 */
public abstract class Input extends JsonSerializableClass implements HttpConvertibleInput {

	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	protected List<Arg> headers = new ArrayList<Arg>(7);
	protected List<Part> parts = new ArrayList<Part>(3);
	protected List<Arg> bodyArgs = new ArrayList<Arg>(7);
	protected String httpMethod = "POST";
    protected String body;

	private boolean debug = Boolean.valueOf(MessageConfig.debugEnable);//不知道为什么，直接getboolean会失败，提示没有方法
	private boolean gfwCrackerEnable = Boolean.valueOf(MessageConfig.crackGFWHostEnable);

	@Override
	public Request toHttpRequest() {
		RequestBuilder rb = new RequestBuilder();

		for (Arg arg : headers) {
			rb.addHeader(arg.getName(), arg.getValue());
		}
		rb.setMethod(httpMethod);

        if (null != body){
            try {
                rb.setBody(body.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                LOGGER.error(e.getMessage(),e);
            }
        }else{
            for (Part part : parts) {
                rb.addBodyPart(part);
            }

            for (Arg arg : bodyArgs) {
                if (httpMethod.equals("POST")){
                    rb.addParameter(arg.getName(), arg.getValue());
                }else{
                    rb.addQueryParameter(arg.getName(), arg.getValue());
                }

            }
        }



		rb.setUrl(getUrl());

		if (debug) {
			rb.setProxyServer(new ProxyServer(MessageConfig.debugHost, MessageConfig.debugPort));
		}
		
		if (isGfwCrackerEnable() ){
			rb.setProxyServer(new ProxyServer(MessageConfig.crackGFWHost, MessageConfig.crackGFWHostPort));
		}

		return rb.build();
	}

	/**
	 * 具体的Input指明具体的Url
	 * 
	 * @return
	 */
	protected abstract String getUrl();
	
	public abstract void reNewInput();

	public Input setDebug(boolean debug) {
		this.debug = debug;
		return this;
	}
	
	/**
	 * 发布图片的时候需要用这个方法来形成multipartForm。
	 * @param pic
	 * @param args
	 * @return
	 */
	protected List<Part> getMultiParts(byte[] pic, List<Arg> args) {
		List<Part> parts = new LinkedList<Part>();
		if (args != null) {
			for (Arg arg : args) {
				parts.add(new StringPart(arg.getName(), arg.getValue(),"UTF-8"));
			}
		}

		if (pic != null) {
			parts.add(new ByteArrayPart("pic", "pic.png", pic, "image/png",
					"UTF-8"));
		}
		return parts;
	}

	public boolean isGfwCrackerEnable() {
		return gfwCrackerEnable;
	}

	public Input setGfwCrackerEnable(boolean gfwCrackerEnable) {
		this.gfwCrackerEnable = gfwCrackerEnable;
		return this;
	}
}
