/*
 * Fetion Connect
 *  
 * Create by 李会军  Jun 7, 2011
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package thirdparty.renren.renrenAPIv2;

import com.fasterxml.jackson.databind.ObjectReader;
import com.ning.http.client.Response;
import thirdparty.Output;

/**
 * 这个类实现了对人人的错误码的解析。因为任意一个人人的接口都会返回这个错误
 * 码，因此它也会被继承到各个返回值内。
 * 
 * @author	shangrenpeng
 * @date	2012-9-20 下午4:18:12
 *
 */
public abstract class RenRenOutput extends Output {

    private RennError error;

    public RennError getError() {
        return error;
    }

    public void setError(RennError error) {
        this.error = error;
    }

    /* (non-Javadoc)
         * @see thirdparty.Merchandise#MerchandiseOK()
         */
	@Override
	public boolean outputOK() {
		return error == null;
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
		return error != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.feinno.app.sync.engine.ErrorResponse#logError()
	 */
	@Override
	public void logError() {
		LOGGER.error(error.getMessage());
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
                error = new RennError("0",e.getMessage());
				return;
			}
		} else {
			try {
				ObjectReader reader = mapper.readerForUpdating(this);
				reader.readValue(response.getResponseBody("UTF-8"));
				return;
			} catch (Exception e) {
				LOGGER.error(response.getStatusCode() + "\n" + e.getMessage());
                error = new RennError("0",e.getMessage());
				return;
			}
		}
	}

}
