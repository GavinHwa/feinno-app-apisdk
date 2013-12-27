/*
 * Fetion Connect
 *  
 * Create by 李会军  Jun 7, 2011
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package thirdparty.renren.oauth1;

import com.fasterxml.jackson.databind.ObjectReader;
import thirdparty.Output;
import com.ning.http.client.Response;

/**
 * 这个类实现了对人人的错误码的解析。因为任意一个人人的接口都会返回这个错误
 * 码，因此它也会被继承到各个返回值内。
 * 
 * @author	shangrenpeng
 * @date	2012-9-20 下午4:18:12
 *
 */
public abstract class RenRenOutput extends Output {

	protected String error_code;//错误码
	protected String error_msg;//错误说明

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getErrorCode() {
		return this.getError_code();
	}

	public void setErrorCode(String value) {
		this.setError_code(value);
	}

	
	/* (non-Javadoc)
	 * @see thirdparty.Merchandise#MerchandiseOK()
	 */
	@Override
	public boolean outputOK() {
		return getError_code() == null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.feinno.app.sync.engine.ErrorResponse#needRetry()
	 */
	@Override
	public boolean needRetry() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.feinno.app.sync.engine.ErrorResponse#needLog()
	 */
	@Override
	public boolean needLog() {
		return error_code != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.feinno.app.sync.engine.ErrorResponse#logError()
	 */
	@Override
	public void logError() {
		LOGGER.error(getError_msg());
	}

	/* (non-Javadoc)
	 * @see com.feinno.app.sync.engine.ErrorResponse#needUserKnow()
	 */
	@Override
	public boolean needUserKnow() {
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
				error_code = "0";
				setError_msg(e.getMessage());
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

	public String getError_msg() {
		return error_msg;
	}

	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}
}
