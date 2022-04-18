package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports extent;
	
	
	public static ExtentReports getExtentObject() {
		
		String path = System.getProperty("user.dir") +"/Reports/Report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
		
		
	}

}
