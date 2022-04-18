package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import factory.DataProviderfactory;

public class BaseClass {
	public WebDriver driver;
	
	public WebDriver initializeDriver() {
		
		if(DataProviderfactory.getConfig().getBrowser().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(DataProviderfactory.getConfig().getBrowser().equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(DataProviderfactory.getConfig().getUrl());
		driver.manage().window().maximize();
		return driver;
		
		
		
	}
	public String getScreenshot(String name, WebDriver Idriver) {
		TakesScreenshot ts = (TakesScreenshot) Idriver;
		String destination = System.getProperty("user.dir")+"Screenshots/"+name+".png";
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
	

}
