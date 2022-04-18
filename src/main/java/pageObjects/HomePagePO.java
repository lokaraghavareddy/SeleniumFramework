package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePagePO {
	public WebDriver driver;

	public HomePagePO(WebDriver driver) {
		this.driver = driver;
		

	}

	private @FindBy(xpath = "//a[@class='item_1 ytvlo_one']") @CacheLookup
	WebElement signInToYourTvLicensing;
	
	public void clickOnSignInToYourTvLicensing(){
		signInToYourTvLicensing.click();
		
	}
}
