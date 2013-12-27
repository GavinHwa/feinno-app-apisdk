package thirdparty;

import com.ning.http.client.Response;

/*
 * 
 * Create by www
 * 
 * Author: Nathan Wong
 *
 * 2012-10-11
 *
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
public interface HttpConvertibleOutput {
	
	public void fromHttpResponse(Response response, Throwable throwable);
	
}
