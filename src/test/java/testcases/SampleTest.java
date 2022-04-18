package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import dataProvider.ExcelDataProvider;
import pageObjects.HomePagePO;

public class SampleTest extends BaseClass{
	
	public WebDriver driver;
	 public static Logger log =LogManager.getLogger(SampleTest.class.getName());
	
	@Test
	public void sampe() {
		driver = initializeDriver();
		log.info("browser opend and maximized");
		HomePagePO homePagePO = PageFactory.initElements(driver,HomePagePO.class);
		homePagePO.clickOnSignInToYourTvLicensing();
		ExcelDataProvider exe = new ExcelDataProvider();
		Assert.assertEquals(driver.getCurrentUrl(), "LOka");
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
