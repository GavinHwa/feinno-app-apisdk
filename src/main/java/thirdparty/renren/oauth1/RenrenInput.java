/**
 * 
 */
package thirdparty.renren.oauth1;

import config.MessageConfig;
import thirdparty.Input;
import thirdparty.oauth.Arg;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.SinaOrder.java
 *
 * date		| author	| version	|  
 * 2012-9-24	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-9-24 下午6:17:46
 *
 */
public abstract class RenrenInput extends Input {
	protected static String api_key = MessageConfig.renrenAppKey;//申请应用时分配的api_key，调用接口时候代表应用的唯一身份
	protected static String client_secret = MessageConfig.renrenAppSecret;
	protected static String v = "1.0"; //API的版本号，固定值为1.0
	protected static String format = "JSON";//返回值的格式。请指定为JSON或者XML，推荐使用JSON，缺省值为XML
	
	protected String getSignature(List<Arg> paramList){

		 List<String> pList = new ArrayList<String>();
		 for(Arg paramArg : paramList)
		 {
			 pList.add(paramArg.getName()+"="+paramArg.getValue());
		 }
		 Collections.sort(pList);
		 StringBuffer buffer = new StringBuffer();
		 for (String param : pList) {
		     buffer.append(param);  //将参数键值对，以字典序升序排列后，拼接在一起
		 }
		 buffer.append(client_secret);  //符串末尾追加上应用的Secret Key
		 
		 try {            //下面是将拼好的字符串转成MD5值，然后返回
		    java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		    StringBuffer result = new StringBuffer();
		    try {
		        for (byte b : md.digest(buffer.toString().getBytes("UTF-8"))) {
		            result.append(Integer.toHexString((b & 0xf0) >>> 4));
		            result.append(Integer.toHexString(b & 0x0f));
		        }
		    } catch (Exception e) {
		        for (byte b : md.digest(buffer.toString().getBytes())) {
		            result.append(Integer.toHexString((b & 0xf0) >>> 4));
		            result.append(Integer.toHexString(b & 0x0f));
		        }
		    }
		    return result.toString();
		} catch (NoSuchAlgorithmException ex) {
			LOGGER.error(ex.getMessage()); 
		}
		return "";
	}

	/* (non-Javadoc)
	 * @see thirdparty.Input#getUrl()
	 */
	protected static String API = "https://api.renren.com/restserver.do";
	@Override
	protected String getUrl() {
		return API;
	}
	
	@Override
	public void reNewInput(){
	}
}
