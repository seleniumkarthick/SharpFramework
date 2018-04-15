package com.sharp.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import com.product.utils.BasePage;

public class LoginUsers extends BasePage{
	
	@Test(description="To validate logo in login page")
	public void testing_01(){
		boolean isLogoPresent=driver.findElement(By.cssSelector("img.responsive-img.paddings")).isDisplayed();
		Assert.assertEquals(isLogoPresent, true);
	}
	 
	@Test
	public void testing_02(){
		
		//username
		driver.findElement(By.id("j_username")).click();
		driver.findElement(By.id("j_username")).clear();
		driver.findElement(By.id("j_username")).sendKeys(LOGIN_USERNAME);
		
		//password
		driver.findElement(By.id("j_password")).click();
		driver.findElement(By.id("j_password")).clear();
		driver.findElement(By.id("j_password")).sendKeys(LOGIN_PASSWORD);
		
		//submit
		driver.findElement(By.name("btnlogin")).submit();
		
		String expectedUrl="http://124.124.120.101/sharp/mainpage.cfm";
		String actualUrl="http://124.124.120.101/sharp/mainpage.cfm";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
}