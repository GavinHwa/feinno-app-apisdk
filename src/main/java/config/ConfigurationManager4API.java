/*
 * Fetion Open Platform
 *  
 * Create by 李会军 2011-3-6
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * 实现对.properties配置文件的读取
 * 
 * @author 李会军
 */
public class ConfigurationManager4API {

	private Properties properties;
	private FileOutputStream outputFile;

	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationManager4API.class);
	public static final String CONFIG_ROOT = System.getProperty("user.dir") + File.separator;

	public ConfigurationManager4API(String app) {
		
		properties = new Properties();
		
		//增加了环境变量
		String configPath = "";
		String debugPath = System.getenv("FEINNO_CONFIG_PATH");
		
		if(debugPath == null)
			debugPath = System.getProperty("feinno.config.path");
		
		if(debugPath == null) {
			configPath = CONFIG_ROOT + app + ".properties";
		}else{
			configPath = debugPath + File.separator + app + ".properties";
		}
		try {
			FileInputStream in = new FileInputStream(configPath);
			properties.load(in);
		} catch (FileNotFoundException ex) {
			//try to find from classpath
			InputStream in = ConfigurationManager4API.class.getClassLoader().getResourceAsStream(app + ".properties");
			if(in != null){
				try{
					properties.load(in);
				}catch(Exception e){
					LOGGER.error(e.getMessage(), e);
				}
			}else
				LOGGER.error(ex.getMessage(), ex);
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
		}
	}

    public Properties getProperties() {
        return properties;
    }

    public void clearProperties() {
        properties.clear();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public Object setProperty(String key, String value) {
        return properties.setProperty(key, value);
    }

    public int getInt(String key) {
        String value = this.properties.getProperty(key);
        int ret = Integer.parseInt(value);
        return ret;
    }

    public boolean getBoolean(String key) {
        String value = this.properties.getProperty(key);
        boolean ret = Boolean.parseBoolean(value);
        return ret;
    }

	public void saveFile(String fileName, String description) {
		try {
			outputFile = new FileOutputStream(fileName);
			properties.store(outputFile, description);
			outputFile.close();
		} catch (FileNotFoundException ex) {
			LOGGER.error(ex.getMessage(), ex);
		} catch (IOException ex) {
			LOGGER.error(ex.getMessage(), ex);
		}
	}
}
