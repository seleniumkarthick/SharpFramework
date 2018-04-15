package com.product.utils;

import java.io.*;
import java.util.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BasePage extends CommonFunctions {
	
	public WebDriver driver;
	static Properties prop;
	
	public static String LOGIN_USERNAME;
	public static String LOGIN_PASSWORD;
	public static String GECKO_DRIVER;
	public static String APPLICATION_URL;
	
	@BeforeTest
	public void setup() throws Exception{
		
		prop = new Properties();
	    ClassLoader loader = Thread.currentThread().getContextClassLoader();           
	    InputStream stream = loader.getResourceAsStream("uat\\application.properties");
	    prop.load(stream);  
	    LOGIN_USERNAME=prop.getProperty("admin_username");
	    LOGIN_PASSWORD=prop.getProperty("admin_password");
	    GECKO_DRIVER=prop.getProperty("gecko_driver");
	    APPLICATION_URL=prop.getProperty("url");
	    
		System.setProperty("webdriver.gecko.driver", GECKO_DRIVER);
		driver = new FirefoxDriver();
		driver.get(APPLICATION_URL);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	}
	
	@AfterTest
	public void teardown(){
		driver.quit();
	}
	
}
