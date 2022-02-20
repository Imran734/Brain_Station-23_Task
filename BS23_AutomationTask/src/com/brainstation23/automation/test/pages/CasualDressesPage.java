package com.brainstation23.automation.test.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CasualDressesPage {
	WebDriver driver;
	By dressItem = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img");
	By cartButton = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]");
	By continueShopping = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span");
	By tshit = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a");
	
	CasualDressesPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void addToCart() {
		WebElement dress = driver.findElement(dressItem);
		Actions a = new Actions(driver);
		a.moveToElement(dress).perform();
		driver.findElement(cartButton).click();
		driver.findElement(continueShopping).click();
		goToTshirt();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void goToTshirt() {
		driver.findElement(tshit).click();
		TshirtPage tp = new TshirtPage(driver);
		tp.addFilter();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
