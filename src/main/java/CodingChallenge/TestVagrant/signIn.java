package CodingChallenge.TestVagrant;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class signIn {
	
	
	public WebDriver driver;
	String URL = "https://www.cleartrip.com/";
	String chromedriverpath = "//Users//monikachaudhary//Downloads//chromedriver";
	String expectederror = "There were errors in your submission\n" + 
			"Your username is a required field\n" + 
			"Your account password is a required field";
	
	 
	@BeforeTest
	public void browserinititae(){
		
	   if (Platform.MAC!= null) {
		    System.setProperty("webdriver.chrome.driver", chromedriverpath);
		    driver = new  ChromeDriver();}
	   else if (Platform.WINDOWS!= null) {
		    System.setProperty("webdriver.chrome.driver", chromedriverpath);
		    driver = new  ChromeDriver();}
	   else if (Platform.LINUX!= null) {
		    System.setProperty("webdriver.chrome.driver", chromedriverpath);
		    driver = new  ChromeDriver();}
	   }
	
	@Test 
	public void signin() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(URL);
		driver.findElement(By.id("userAccountLink")).click();
		WebElement signin  = driver.findElement(By.id("SignIn"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", signin);
		Thread.sleep(5000);

		driver.switchTo().frame("modal_window");
		WebElement signInButton =driver.findElement(By.xpath("//button[@id='signInButton']"));
		js.executeScript("arguments[0].click();", signInButton);
	    driver.findElement(By.xpath("//button[@id='signInButton']")).click();
	    

        //get error message
		String error = driver.findElement(By.id("errors1")).getText();
		Assert.assertEquals(error, expectederror);
		driver.quit();
		
		
		
	}

}
