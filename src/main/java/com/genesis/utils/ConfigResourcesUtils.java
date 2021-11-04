package com.genesis.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigResourcesUtils {

	public static String coincapToken;
	public static String coincapAssetUrl;
	
	public ConfigResourcesUtils() {
		
		try (InputStream input = ConfigResourcesUtils.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            coincapToken = prop.getProperty("coincap_token");
            coincapAssetUrl = prop.getProperty("coincap_asset_url");
 

        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

	
	
	
	
}
