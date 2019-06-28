package com.gurubanking.utilities;

import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFile {
	
Properties prop;
	
	public ReadConfigFile()
	{
		try {
			
			prop = new Properties();
			InputStream in= getClass().getClassLoader().getResourceAsStream("com/gurubanking/resources/config.properties");
			prop.load(in);
			
			if(prop==null)
			{
				System.out.println("Prop is null");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public String getApplicationURL() {
		
		String url= prop.getProperty("baseURL");
		return url;
		
	}
	
	public String getUsername()
	{
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getbrowser()
	{
		String browser = prop.getProperty("browser");
		return browser;
	}

}
