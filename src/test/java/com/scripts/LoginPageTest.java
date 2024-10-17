package com.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.BaseTestNG;

public class LoginPageTest extends BaseTestNG {

	@Test
	public void successLogin() {
		driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/SignIn.html");
		driver.findElement(By.id("usr")).sendKeys("Marshal");
		driver.findElement(By.id("pwd")).sendKeys("Pass123");

		driver.findElement(By.cssSelector("[value='Login']")).click();

		String currentURL = driver.getCurrentUrl();

		Assert.assertTrue(currentURL.contains("ShoeTypes.html"));
		
		driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
	}

	@Test(timeOut = 2000)
	public void emptyCredentialTest() {
		driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/SignIn.html");
		driver.findElement(By.cssSelector("[value='Login']")).click();

		WebElement errorText = driver.findElement(By.xpath("//span[@class]"));
		String errorMsg = errorText.getText();

		Assert.assertTrue(errorText.isDisplayed());

		Assert.assertEquals(errorMsg, "Both Username and Password field are required");
	}

}
