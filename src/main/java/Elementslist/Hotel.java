package Elementslist;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hotel {
	
	
	
		WebDriver driver;
		public Hotel(WebDriver driver) {
		this.driver=driver; 
		PageFactory.initElements(driver, this);}
		
    //Click on hotel 
	@FindBy(xpath = "//ul[@class='navGroup productNav withArrows']//li[2]//a[1]") 
    private WebElement hotelLink;
	
    //Select where filed
    @FindBy(xpath = "//input[@id='Tags']")
    private WebElement localityTextBox;
    
    //Click checkin date
    @FindBy (xpath = "//input[@id='CheckInDate']")
    private WebElement checkin;
    
    //Select checkin date
    @FindBy (xpath = "//a[contains(@class,'ui-state-default ui-state-highlight ui-state-active')]")
    private WebElement checkindate;
    
   //Select checkout date
    @FindBy (xpath = "//a[contains(@class,'ui-state-default ui-state-active')]")
    private WebElement checkoutdate;
    
    
    //Click checkout date
    @FindBy (xpath = "//input[@id='CheckOutDate']")
    private WebElement checkout;
    
    //Click travle selection
    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
    
    //select 1 room, 2 adults
    @FindBy (xpath ="//option[contains(text(),'1 room, 2 adults')]")
    private WebElement oneroom2adults;
     
    //click search button
    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    
    public WebElement hotelLink() {
    	return hotelLink;
    }
    
    public WebElement localityTextBox() {
    	return localityTextBox;
    }
    
    public WebElement checkin() {
    	return checkin;
    }
    
    public WebElement checkindate() {
    	return checkindate;
    }
    
    public WebElement checkout() {
    	return checkout ;
    	}
    
    public WebElement checkoutdate() {
        return checkoutdate;
        }
    public WebElement travellerSelection() {
        return travellerSelection;
        }
    public WebElement oneroom2adults() {
        return oneroom2adults;
        }
    
    public WebElement searchButton() {
    	return searchButton;
    }
    	
    

    

    


}
