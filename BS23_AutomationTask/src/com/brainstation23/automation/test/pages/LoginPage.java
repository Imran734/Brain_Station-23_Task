package com.brainstation23.automation.test.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	WebDriver driver;
	String email;
	String password;
	String chromeDriverPath = "G:\\\\Imran\\\\Self Learning\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe";
	By loginOption = By.className("login");
	By createEmailField = By.id("email_create");
	By createSubmit = By.id("SubmitCreate");
	By emailField = By.id("email");
	By passwordField = By.id("passwd");
	By loginSubmit = By.id("SubmitLogin");
	By firstName = By.id("customer_firstname");
	By lastName = By.id("customer_lastname");
	By passwordCreate = By.id("passwd");
	By address = By.id("address1");
	By city = By.id("city");
	By state = By.id("id_state");
	By postalCode = By.id("postcode");
	By mobile = By.id("phone_mobile");
	By register = By.id("submitAccount");
	
	
	LoginPage(String email, String password){
		this.email=email;
		this.password=password;
	}
	
	public void setupProperty() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		goToLoginPage();
	}
	
	public void goToLoginPage() {
		driver.findElement(loginOption).click();
		createAccount();
	}
	
	public void createAccount() {
		driver.findElement(createEmailField).sendKeys(email);;
		driver.findElement(createSubmit).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String expectedURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		String crtURL = driver.getCurrentUrl();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(expectedURL.equals(crtURL)) {
			loginCheck();
		}
		else {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(firstName).sendKeys("MD");
			driver.findElement(lastName).sendKeys("Imran");
			driver.findElement(passwordCreate).sendKeys(password);
			driver.findElement(address).sendKeys("Banasree");
			driver.findElement(city).sendKeys("Dhaka");
			Select stateName = new Select(driver.findElement(state));
			stateName.selectByVisibleText("Arizona");
			stateName.selectByValue("3");;
			driver.findElement(postalCode).sendKeys("1212");
			driver.findElement(mobile).sendKeys("01700600200");
			driver.findElement(register).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			loginCheck();
		}
	}
	
	public void loginCheck() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginSubmit).click();
		MyAccountPage map = new MyAccountPage(driver);
		map.goToCasualDress();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	

}
