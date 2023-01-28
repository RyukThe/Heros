package Modul1_PlanetSuperHeroeslogin_Signup_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Modul1_PlanetSuperHeroeslogin_Signup_Page.SignUp_Login_Page;

public class LoginPagTest extends BaseClass
{


	SignUp_Login_Page sgin;
	
	int TCID;
	
	@BeforeClass
	public void OpenB() throws IOException
	{
		
		
		
	}
	
	
	@Test(priority = 1)
	public void verifyLog() throws IOException
	{
			openBrowser();
		
		sgin=new SignUp_Login_Page(m);
		TCID=1;
		boolean logo = sgin.verifylSignUp_Login_Pagelogo();
		
		Assert.assertTrue(logo);
	}
	
	@Parameters("")
	@Test (priority = 2)
	public void serachfeild() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TCID=2;
		sgin.inpSignUp_Login_PageserachField(UtilityClass.getData("Sheet6", 1, 0));
		sgin.autosuggSignUp_Login_Page(UtilityClass.getData("Sheet6", 1, 0));
	
	}
	
	
	@Test (priority = 3)
	public void login_signUp() throws InterruptedException
	{
		TCID=3;
		UtilityClass.getHandelDropDown(m, sgin.clickSignUp_Login_Pageprofile());

	
		sgin.login_signSignUp_Login_Page();
		
	
	}
	
	@AfterMethod 
	public void failedTestCasesSS(ITestResult result) throws IOException
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreeShot(m, TCID);
		}
	}
	
	
	@AfterClass
	public void close() throws InterruptedException
	{
		Thread.sleep(7000);
		m.close();
	}
	
	
	
	
	
}
