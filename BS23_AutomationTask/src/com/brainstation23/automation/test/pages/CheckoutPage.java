package com.brainstation23.automation.test.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;
	By checkoutFromSummary = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span");
	By checkoutAddress = By.xpath("//*[@id=\"center_column\"]/form/p/button/span");
	By shipping = By.xpath("//*[@id=\"form\"]/p/button/span");
	By termOfService = By.id("cgv");
	By paymentMethod = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a");
	By confirmOrder = By.xpath("//*[@id=\"cart_navigation\"]/button/span");
	By signout = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
	
	
	CheckoutPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void checkoutFromSummary() {
		driver.findElement(checkoutFromSummary).click();
		checkoutFromAddress();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void checkoutFromAddress() {
		driver.findElement(checkoutAddress).click();
		checkoutFromShipping();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void checkoutFromShipping() {
		driver.findElement(termOfService).click();
		driver.findElement(shipping).click();
		checkoutAfterPayment();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void checkoutAfterPayment() {
		driver.findElement(paymentMethod).click();
		confirmingOrder();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void confirmingOrder() {
		driver.findElement(confirmOrder).click();
		driver.findElement(signout).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
