package CodingChallenge.TestVagrant;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Elementslist.Hotel;

public class hotelSearch {
	

	public WebDriver driver;
	String URL = "https://www.cleartrip.com/";
	String chromedriverpath = "//Users//monikachaudhary//Downloads//chromedriver";
	 
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
	public void HotelSearch () throws InterruptedException {
		
		
		driver.get(URL);
		//driver.findElement(By.xpath("//ul[@class='navGroup productNav withArrows']//li[2]//a[1]")).click();
		//driver.findElement(By.xpath("//input[@id='Tags']")).click();
		//driver.findElement(By.xpath("//input[@id='CheckInDate']")).click();
		
		Hotel hs= new Hotel(driver);
		hs.hotelLink().click();
		hs.localityTextBox().sendKeys("Indiranagar");
		Thread.sleep(5000);
		hs.localityTextBox().sendKeys(Keys.ENTER); 
		hs.checkin().click();
		hs.checkindate().click();
		hs.checkout().click();
		hs.checkoutdate().click();
		hs.travellerSelection().click();
		hs.oneroom2adults().click();
		hs.searchButton().submit();
		
		//verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));
		
	}
	
	private boolean isElementPresent(By by) {
        try {
         driver.findElement(by);
         return true;
       }  catch (NoSuchElementException e) {
         return false;
     }
}
	 @AfterTest
     public void driverQuit() {
  	   
     //close the browser
	   driver.quit();
	
     }}
	 
