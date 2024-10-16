package com.scripts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.BaseTestNG;

public class BasicTest extends BaseTestNG {

	@Test
	public void enterLoginForm() throws InterruptedException {
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href*='Sign']")).click();
	}

	@Test(dependsOnMethods = { "enterLoginForm" })
	public void doLogin() throws InterruptedException {
		driver.findElement(By.id("usr")).sendKeys("Marshal");
		Thread.sleep(1000);
		driver.findElement(By.id("pwd")).sendKeys("Marshal123");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);
	}

	@Test(dependsOnMethods = { "enterLoginForm", "doLogin" })
	public void productsPage() {
		List<WebElement> products = driver.findElements(By.tagName("h3"));
		Assert.assertEquals(products.size(), 3);

		for (WebElement prod : products) {
			System.out.println(prod.getText());
		}

	}

	@Test(dependsOnMethods = { "productsPage" })
	public void goToCart() throws InterruptedException {

		Thread.sleep(2000);
		WebElement hoverElement = driver.findElement(By.xpath("//button[@class='btn btn-info FormalShoes']"));
		Actions actions = new Actions(driver);

		actions.moveToElement(hoverElement).click().build().perform();

		List<WebElement> shoeType = driver.findElements(By.xpath("//tbody/tr/td[1]"));

		for (WebElement shoes : shoeType) {
			System.out.println(shoes.getText());
		}

		Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Formal Shoes");

	}

	@Test(dependsOnMethods = { "goToCart" })
	public void performCartOperation() throws InterruptedException {
		WebElement buyingShoe = driver.findElement(By.xpath("//tbody/tr[3]/td[1]"));
		buyingShoe.click();
		Thread.sleep(1000);

		List<WebElement> list = driver.findElements(By.xpath("//td/button"));
		list.get(2).click();

		Thread.sleep(2000);

		String successMsg = driver.findElement(By.cssSelector("center h1")).getText();
		Assert.assertEquals(successMsg, "Added to Cart Successfully !!!");

	}

}
