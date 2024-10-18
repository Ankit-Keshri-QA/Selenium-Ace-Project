package com.scripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.BaseTestNG;

public class RegisterPageTest extends BaseTestNG {

	@Test(groups = { "regression" })
	public void successRegister() throws InterruptedException {
		driver.get(registerUrl);
		driver.findElement(By.id("firstname")).sendKeys("NewUser");
		driver.findElement(By.id("lastname")).sendKeys("LastUser");
		driver.findElement(By.id("emailId")).sendKeys("email@gmail.com");
		driver.findElement(By.id("contactNumber")).sendKeys("9877161611");
		driver.findElement(By.id("usr")).sendKeys("username11");
		driver.findElement(By.id("pwd")).sendKeys("password123");

		driver.findElement(By.cssSelector("[value='Submit']")).click();
		Thread.sleep(1000);

		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://anupdamoda.github.io/AceOnlineShoePortal/RegistrationSuccessfulmessage.html");

		String successMsg = driver.findElement(By.cssSelector("center h1")).getText();

		Assert.assertEquals(successMsg, "User Registered Successfully !!!");

	}

}
