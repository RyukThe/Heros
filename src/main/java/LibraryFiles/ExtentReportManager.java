package LibraryFiles;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import bsh.Capabilities;
import net.bytebuddy.implementation.bytecode.Throw;

public class ExtentReportManager extends BaseClass implements ITestListener
{
	public ExtentSparkReporter sparkRepoter;
	public ExtentReports repoter;
	public ExtentTest test;
	public String reportName;
	
	
	public void onTestStart(ITestResult result) 
	{
		String TimeSatmp= new SimpleDateFormat("yyyy.MM.HH.mm.ss").format(new Date());
		reportName="Test-Report"+TimeSatmp;
		sparkRepoter= new ExtentSparkReporter("D:\\eclipse\\heros\\Reports\\"+reportName+".htlm");
		sparkRepoter.config().setDocumentTitle("Automation-Report");
		sparkRepoter.config().setReportName("Heros");
		sparkRepoter.config().setTheme(Theme.DARK);
		
		repoter= new ExtentReports();
		repoter.attachReporter( sparkRepoter);
		try {
			repoter.setSystemInfo("Application", UtilityClass.getPropertyFileData("URL"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 org.openqa.selenium.Capabilities cp = ((RemoteWebDriver)m).getCapabilities();
		repoter.setSystemInfo("Browser", cp.getBrowserName());
		repoter.setSystemInfo("Browser version :", cp.getBrowserVersion());
	//	System.getProperties().list(System.out); this will give all information about system like os version user name and java version
		repoter.setSystemInfo("UserName", System.getProperty("user.name"));
		repoter.setSystemInfo("Java Version", System.getProperty("java.version"));
	}

	public void onTestSuccess(ITestResult result)
	{
		test=repoter.createTest(result.getName());
		test.assignAuthor("Saurav");
		test.assignCategory("Regression");
		test.assignDevice("Windows11");
		test.log(Status.PASS, "Hurry!! Test Case passed");
		test.pass(result.getThrowable());
		test.pass("Passed");
		
	}

	public void onTestFailure(ITestResult result)
	{
		test=repoter.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Case Failed");
		test.createNode(result.getName());
		test.fail("Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	
	
		try {
			String img = new BaseClass().cpatureScreen(result.getName());
			test.addScreenCaptureFromPath(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result)
	{
		test=repoter.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Case Skipped");
		test.skip("Test Case Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	
	public void onFinish(ITestContext context)
	{
		repoter.flush();
	}

	
	
	
}
