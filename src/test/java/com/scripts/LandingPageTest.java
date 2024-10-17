package com.scripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.BaseTestNG;

public class LandingPageTest extends BaseTestNG {

	@Test
	public void verifyTitle() {
		driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Ace Online Shoe Portal");

	}

	@Test
	public void verifyLandingPageTexts() {
		String heading = driver.findElement(By.id("MainPageText")).getText();
		Assert.assertEquals(heading, "One Stop Shop for all your Shoes needs!");

		String header = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(header, "Ace Online Shoe Portal");
	}

}
