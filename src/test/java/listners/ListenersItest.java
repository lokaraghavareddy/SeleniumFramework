package listners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import base.ExtentReporterNG;


public class ListenersItest extends BaseClass implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getExtentObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test =extent.createTest(result.getMethod().getMethodName()+System.getProperty("browser"));
		extentTest.set(test);
		
		
	}
		
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	
		
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver1 = null;
		try {
			driver1 = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().fail(result.getThrowable());
		extentTest.get().addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(), driver1), result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
