package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import base.BaseClass;
import pageObjects.HomePagePO;

public class SampleTest5 extends BaseClass{
	
	public WebDriver driver;
	
	@Test
	public void sampe() {
		driver = initializeDriver();
		HomePagePO homePagePO = PageFactory.initElements(driver,HomePagePO.class);
		homePagePO.clickOnSignInToYourTvLicensing();
	}
	@AfterTest
	public void tearDown() {
		driver.quit();;
		
	}

}
