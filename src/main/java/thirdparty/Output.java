/*
 * Fetion Connect
 *  
 * Create by 李会军  Jun 7, 2011
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package thirdparty;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;

/**
 * 这个商品是把各家的output当作了商品卖给OauthUser了
 * 
 * @author shangrenpeng
 * @date 2012-9-22 下午7:43:06
 * 
 */
public abstract class Output extends JsonSerializableClass implements HttpConvertibleOutput {

	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	protected static ObjectMapper mapper = new ObjectMapper();
	protected Input retryInput = null;
	private int retryTimes = 0;
	
	static{
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	protected static Output acquire(Type type) {
		//TODO 等对象池，从对象池获取就行
		return null;
	}
	
	/**
	 * 返回值是否正确？如果不正确就要进行错误处理了
	 * 
	 * @return
	 */
	public abstract boolean outputOK();

	/**
	 * 看看好不好吃，不好吃的顾客可以选择重做
	 * 
	 * @return 是否需要重试
	 */
	public boolean needRetry() {
		if (retryTimes-- > 0 && null != retryInput){
			return true;
		}
		return false;
	}

	/**
	 * 如果需要记录日志，则返回true
	 * 
	 * @return
	 */
	public abstract boolean needLog();

	/**
	 * 记录当前返回错误中的问题
	 */
	public abstract void logError();

	/**
	 * 判断是否需要用户知晓错误
	 * 
	 * @return
	 */
	public abstract boolean needUserKnow();

	/**
	 * 让用户知道错误情况 TODO 暂时没有规定怎么给前端展示
	 */
	public abstract void letUserKnow();

	public Input getRetryInput() {
		return retryInput;
	}

	public void setRetryInput(Input retryInput) {
		this.retryInput = retryInput;
	}

	public int getRetryTimes() {
		return retryTimes;
	}

	public void setRetryTimes(int retryTimes) {
		this.retryTimes = retryTimes;
	}
}
