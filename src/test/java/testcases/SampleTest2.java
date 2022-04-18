package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;
import base.BaseClass;

import pageObjects.HomePagePO;

public class SampleTest2 extends BaseClass{
	
	public WebDriver driver;
	 public static Logger log =LogManager.getLogger(SampleTest2.class.getName());
	
	@Test
	public void sampe() {
		driver = initializeDriver();
		HomePagePO homePagePO = PageFactory.initElements(driver,HomePagePO.class);
		homePagePO.clickOnSignInToYourTvLicensing();
		log.info("navigated to sign");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
