/*
 * Fetion Connect
 *  
 * Create by 李会军  Jun 7, 2011
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package thirdparty.tencent;

import com.fasterxml.jackson.databind.ObjectReader;
import thirdparty.Output;
import com.ning.http.client.Response;

/**
 * 这个类实现了对新浪的错误码的解析。因为任意一个新浪的接口都会返回这个错误
 * 码，因此它也会被继承到各个返回值内。
 * 
 * @author	shangrenpeng
 * @date	2012-9-20 下午4:18:12
 *
 */
public abstract class TencentOutput extends Output {

	protected int ret;//返回码，正常是0
	protected String msg;//返回说明，正常是ok
	protected int errcode;//错误码，正常是0
	
	/**
	 * @return the ret
	 */
	public int getRet() {
		return ret;
	}

	/**
	 * @param ret the ret to set
	 */
	public void setRet(int ret) {
		this.ret = ret;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the errcode
	 */
	public int getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode the errcode to set
	 */
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	/* (non-Javadoc)
	 * @see thirdparty.Merchandise#MerchandiseOK()
	 */
	@Override
	public boolean outputOK() {
		return ret == 0;
	}
	
	final private static int[] whatNeedRetry = {
			2,4,
		};
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.feinno.app.sync.engine.ErrorResponse#needRetry()
	 */
	@Override
	public boolean needRetry() {
		for (int needRetry : whatNeedRetry) {
			if (ret == needRetry){
				return true;
			}
		}
		
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.feinno.app.sync.engine.ErrorResponse#needLog()
	 */
	@Override
	public boolean needLog() {
		return ret != 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.feinno.app.sync.engine.ErrorResponse#logError()
	 */
	@Override
	public void logError() {
		if (msg != null){
			LOGGER.error("ret=" + ret + ";errcode=" + errcode + ";" + msg);
		}else{
			LOGGER.error("Net I/O Exception!");
		}
		
	}

	final private static int[] whatNeedToKnow = {
			2,3,4,5,7,
	};
	
	/* (non-Javadoc)
	 * @see com.feinno.app.sync.engine.ErrorResponse#needUserKnow()
	 */
	@Override
	public boolean needUserKnow() {
		for (int needRetry : whatNeedToKnow) {
			if (ret == needRetry){
				return true;
			}
		}
		
		return false;
		
	}

	/* (non-Javadoc)
	 * @see com.feinno.app.sync.engine.ErrorResponse#letUserKnow()
	 */
	@Override
	public void letUserKnow() {
		//TODO 暂时不需要前端展示。可以通过缓存来展示
	}
	
	/* (non-Javadoc)
	 * @see com.feinno.message.HttpConvertibleOutput#fromHttpResponse(com.ning.http.client.Response, java.lang.Throwable)
	 */
	@Override
	public void fromHttpResponse(Response response, Throwable throwable) {
		if (throwable != null){
			LOGGER.error(throwable.getMessage());
			return;
		}
		if (response.getStatusCode() == 200) {
			try {
				String content;
				if ((content = response.getResponseBody("UTF-8")) != null) {
						ObjectReader reader = mapper.readerForUpdating(this);
						reader.readValue(content);
				}
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				return;
			}
		} else {
			try {
				ObjectReader reader = mapper.readerForUpdating(this);
				reader.readValue(response.getResponseBody("UTF-8"));
				return;
			} catch (Exception e) {
				LOGGER.error(response.getStatusCode() + "\n" + e.getMessage());
				return;
			}
		}
	}
}
