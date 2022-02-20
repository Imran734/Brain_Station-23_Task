package com.brainstation23.automation.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class User_BS23 {
	String email;
	String password;
	WebDriver driver;
	
	public User_BS23(String email, String password) {
		this.email=email;
		this.password=password;
	}
	
	public void createAccount() {
		/*Please change the following setProperty parameter according to your chrome driver location*/
		System.setProperty("webdriver.chrome.driver", "G:\\Imran\\Self Learning\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys(email);
		driver.findElement(By.id("SubmitCreate")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)", "");
		WebElement accountText = driver.findElement(By.cssSelector("#create_account_error > ol > li"));
		if(accountText.isDisplayed()) {
			loginCheck();
		}
		else {
			System.out.println("Not matched");
		}
	}
	
	public void loginCheck() {
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
		
		WebElement casualDresses = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
		Actions a = new Actions(driver);
		a.moveToElement(casualDresses).perform();
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")).click();
		
	}

	public static void main(String[] args) {
		User_BS23 user1 = new User_BS23("imranafccl@gmail.com","12345");
		user1.createAccount();
		//User_BS23 user2 = new User_BS23();
		

	}

}
