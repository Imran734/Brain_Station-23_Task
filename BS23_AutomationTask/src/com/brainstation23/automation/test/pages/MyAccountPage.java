package com.brainstation23.automation.test.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MyAccountPage {
	WebDriver driver;
	By dressMenu = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	By casualDresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a");
	MyAccountPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void goToCasualDress() {
		WebElement casDress = driver.findElement(dressMenu);
		Actions a = new Actions(driver);
		a.moveToElement(casDress).perform();
		driver.findElement(casualDresses).click();
		CasualDressesPage cdp = new CasualDressesPage(driver);
		cdp.addToCart();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	

}
