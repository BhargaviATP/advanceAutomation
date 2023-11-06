package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListenerUtility extends BaseClass implements ITestListener {
	ExtentReports report;
	 
	public void onStart(ITestContext context) {

		ExtentSparkReporter reporter=new ExtentSparkReporter("./report/ExtentDemo.html");

		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("This is Sample report");
		reporter.config().setReportName("Selenium is my Name");

		report=new ExtentReports();
		report.attachReporter(reporter);
	}
	public void onTestStart(ITestResult result) {
		logger=report.createTest(result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS, "The test " +result.getName()+" is Passed");
	}
	public void onTestFailure(ITestResult result) {
		logger.log(Status.FAIL, "The test " +result.getName()+" is Failed");
		logger.addScreenCaptureFromPath(ScreenShot.capturingScreenShot(result.getName()));
	}
	public void onFinish(ITestContext context) {
		report.flush();
	}
}
