package com.brainstation23.automation.test.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TshirtPage {
	WebDriver driver;
	By blueFilter = By.id("layered_id_attribute_group_14");
	By shirtItem = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img");
	By addCartButton = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]/span");
	By checkOut = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
	
	TshirtPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void addFilter() {
		driver.findElement(blueFilter).click();
		addShirt();
		
	}
	
	public void addShirt() {
		WebElement shirt = driver.findElement(shirtItem);
		Actions a = new Actions(driver);
		a.moveToElement(shirt).perform();
		driver.findElement(addCartButton).click();
		goToCheckOut();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void goToCheckOut() {
		driver.findElement(checkOut).click();
		CheckoutPage cp = new CheckoutPage(driver);
		cp.checkoutFromSummary();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
