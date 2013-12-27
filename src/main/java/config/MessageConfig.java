/**
 * 
 */
package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : shangrenpeng
 * @fileName : config.MessageConfig.java
 *
 * date		| author	| version	|  
 * 2013-3-7	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

/**
 * @author shangrenpeng
 * @date 2013-3-7 下午5:29:48
 * 
 */
/**
 * @author	shangrenpeng
 * @date	2013-3-8 下午1:39:43
 *
 */
public class MessageConfig {
	static ConfigurationManager4API config = new ConfigurationManager4API("message");
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageConfig.class);

    public static String debugHost;
    public static int debugPort;
    public static boolean debugEnable;

    public static String crackGFWHost;
    public static int crackGFWHostPort;
    public static boolean crackGFWHostEnable;

    public static String defaultProfileImg;

    public static String sinaAppKey;
    public static String sinaAppSecret;
    public static String kaixinAppKey;
    public static String kaixinAppSecret;
    public static String tencentAppKey;
    public static String tencentAppSecret;
    public static String neteaseAppKey;
    public static String neteaseAppSecret;
    public static String sohuAppKey;
    public static String sohuAppSecret;
    public static String mobileAppKey;
    public static String mobileAppSecret;
    public static String renrenAppKey;
    public static String renrenAppSecret;
    public static String xinhuaAppKey;
    public static String xinhuaAppSecret;

    public static String facebookAppId;
    public static String youtubeId;
    public static String youkuId;
    public static String tudouAppKey;
    public static String sinaPid;
    public static String pomoboType;
    public static String xiyouPid;

    public static String webHost;



    public static int sinaServiceId;
    public static int kaixinServiceId;
    public static int tencentServiceId;
    public static int neteaseServiceId;
    public static int sohuServiceId;
    public static int mobileServiceId;
    public static int renrenServiceId;
    public static int xinhuaServiceId;
    public static int rssServiceId;

    public static String sinaAccessToken1;
    public static String sinaAccessSecret1;
    public static String sinaAccessToken2;
    public static String sinaAccessSecret2;
    public static String kaixinAccessToken;
    public static String kaixinAccessSecret;
    public static String tencentAccessToken;
    public static String tencentAccessSecret;
    public static String neteaseAccessToken;
    public static String neteaseAccessSecret;
    public static String sohuAccessToken;
    public static String sohuAccessSecret;
    public static String mobileAccessToken;
    public static String mobileAccessSecret;
    public static String renrenAccessToken;
    public static String renrenAccessSecret;
    public static String xinhuaAccessToken;
    public static String xinhuaAccessSecret;

    static {
        try{
            debugHost = config.getProperty("debugHost");
            debugPort = config.getInt("debugPort");
            debugEnable = config.getBoolean("debugEnable");
        }catch (Exception e){
            LOGGER.error("missing debug interface");
        } 
        try{
            crackGFWHost = config.getProperty("crackGFWHost");
            crackGFWHostPort = config.getInt("crackGFWHostPort");
            crackGFWHostEnable = config.getBoolean("crackGFWHostEnable");
        }catch (Exception e){
            LOGGER.error("missing crack GFW interface");
        }

        try{
            defaultProfileImg = config.getProperty("defaultProfileImg");
        }catch (Exception e){
            LOGGER.error("missing default profile image interface");
        }

        try{
            sinaAppKey = config.getProperty("sinaAppKey");
            sinaAppSecret = config.getProperty("sinaAppSecret");
        }catch (Exception e){
            LOGGER.error("missing sina app authorization");
        }
        try{
            kaixinAppKey = config.getProperty("kaixinAppKey");
            kaixinAppSecret = config.getProperty("kaixinAppSecret");
        }catch (Exception e){
            LOGGER.error("missing kaixin app authorization");
        }
        try{
            tencentAppKey = config.getProperty("tencentAppKey");
            tencentAppSecret = config.getProperty("tencentAppSecret");
        }catch (Exception e){
            LOGGER.error("missing tencent app authorization");
        }
        try{
            neteaseAppKey = config.getProperty("neteaseAppKey");
            neteaseAppSecret = config.getProperty("neteaseAppSecret");
        }catch (Exception e){
            LOGGER.error("missing netease app authorization");
        }
        try{
            sohuAppKey = config.getProperty("sohuAppKey");
            sohuAppSecret = config.getProperty("sohuAppSecret");
        }catch (Exception e){
            LOGGER.error("missing sohu app authorization");
        }
        try{
            mobileAppKey = config.getProperty("mobileAppKey");
            mobileAppSecret = config.getProperty("mobileAppSecret");
        }catch (Exception e){
            LOGGER.error("missing mobile app authorization");
        }
        try{
            renrenAppKey = config.getProperty("renrenAppKey");
            renrenAppSecret = config.getProperty("renrenAppSecret");
        }catch (Exception e){
            LOGGER.error("missing renren app authorization");
        }
        try{
            xinhuaAppKey = config.getProperty("xinhuaAppKey");
            xinhuaAppSecret = config.getProperty("xinhuaAppSecret");
        }catch (Exception e){
            LOGGER.error("missing renren app authorization");
        }

        try{
            facebookAppId = config.getProperty("facebookAppId");
        }catch (Exception e){
            LOGGER.error("missing facebookAppId");
        }
        try{
            youtubeId = config.getProperty("youtubeId");
        }catch (Exception e){
            LOGGER.error("missing youtubeId");
        }
        try{
            youkuId = config.getProperty("youkuId");
        }catch (Exception e){
            LOGGER.error("missing youkuId");
        }
        try{
            tudouAppKey = config.getProperty("tudouAppKey");
        }catch (Exception e){
            LOGGER.error("missing tudouAppKey");
        }
        try{
            sinaPid = config.getProperty("sinaPid");
        }catch (Exception e){
            LOGGER.error("missing sinaPid");
        }
        try{
            pomoboType = config.getProperty("pomoboType");
        }catch (Exception e){
            LOGGER.error("missing pomoboType");
        }
        try{
            xiyouPid = config.getProperty("xiyouPid");
        }catch (Exception e){
            LOGGER.error("missing xiyouPid");
        }

        try{
            webHost = config.getProperty("webHost");
        }catch (Exception e){
            LOGGER.error("missing webHost");
        }

        try{
            sinaServiceId = config.getInt("sinaServiceId");
            kaixinServiceId = config.getInt("kaixinServiceId");
            tencentServiceId = config.getInt("tencentServiceId");
            neteaseServiceId = config.getInt("neteaseServiceId");
            sohuServiceId = config.getInt("sohuServiceId");
            mobileServiceId = config.getInt("mobileServiceId");
            renrenServiceId = config.getInt("renrenServiceId");
            xinhuaServiceId = config.getInt("xinhuaServiceId");
            rssServiceId = config.getInt("rssServiceId");
        }catch (Exception e){
            LOGGER.error("missing servicesIds",e);
        }

        try{
            sinaAccessToken1 = config.getProperty("sinaAccessToken1");
            sinaAccessSecret1 = config.getProperty("sinaAccessSecret1");
            sinaAccessToken2 = config.getProperty("sinaAccessToken2");
            sinaAccessSecret2 = config.getProperty("sinaAccessSecret2");
            kaixinAccessToken = config.getProperty("kaixinAccessToken");
            kaixinAccessSecret = config.getProperty("kaixinAccessSecret");
            tencentAccessToken = config.getProperty("tencentAccessToken");
            tencentAccessSecret = config.getProperty("tencentAccessSecret");
            neteaseAccessToken = config.getProperty("neteaseAccessToken");
            neteaseAccessSecret = config.getProperty("neteaseAccessSecret");
            sohuAccessToken = config.getProperty("sohuAccessToken");
            sohuAccessSecret = config.getProperty("sohuAccessSecret");
            mobileAccessToken = config.getProperty("mobileAccessToken");
            mobileAccessSecret = config.getProperty("mobileAccessSecret");
            renrenAccessToken = config.getProperty("renrenAccessToken");
            renrenAccessSecret = config.getProperty("renrenAccessSecret");
            xinhuaAccessToken = config.getProperty("xinhuaAccessToken");
            xinhuaAccessSecret = config.getProperty("xinhuaAccessSecret");
        }catch (Exception e){
            LOGGER.error("missing testkeys");
        }

    }
}
