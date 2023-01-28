package Modul2_PlanetSuperHeroesRegistration_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;

import Modul1_PlanetSuperHeroeslogin_Signup_Page.HerosWelcomePage;
import Modul1_PlanetSuperHeroeslogin_Signup_Page.SignUp_Login_Page;

public class HerosRegistrationTest extends BaseClass
{
	SignUp_Login_Page slp;
	HerosWelcomePage wel;
	Modul2_PlanetSuperHeroesRegistration_Page.HerosRegistartionPage reg;
	int TCID;
	
	
	
	@Test
	public void test() throws IOException, InterruptedException
	{
		openBrowser();
		slp= new SignUp_Login_Page(m);
		wel= new HerosWelcomePage(m);
		reg= new Modul2_PlanetSuperHeroesRegistration_Page.HerosRegistartionPage(m);
		TCID=6;
		boolean actR = slp.verifylSignUp_Login_Pagelogo();
		Assert.assertTrue(actR);
		
		UtilityClass.getHandelDropDown(m, slp.clickSignUp_Login_Pageprofile());
		slp.login_signSignUp_Login_Page();
		
		
		Thread.sleep(3000);
		wel.clickHerosWelcomePageregisterbtn();
	}
	
	
	@Test(dependsOnMethods = "test")
	public void RegistrationTitle() throws EncryptedDocumentException, IOException
	{
		String title = reg.verifyHerosRegistartionPageTitle();
		
		Assert.assertEquals(title, UtilityClass.getData("Sheet6", 0, 6));
		if(title.equals( UtilityClass.getData("Sheet6", 0, 6)))
		{
			Reporter.log("ReRegistration Title is present",true);
		}
		
		
		
	}
	
	
	@Test(dependsOnMethods = "RegistrationTitle")
	public void Registration() throws EncryptedDocumentException, IOException
	{
		reg.inpHerosRegistartionPagefirstname(UtilityClass.getData("Sheet6", 0, 0));
		reg.inpHerosRegistartionPageLastName(UtilityClass.getData("Sheet6", 0, 1));
		reg.inpHerosRegistartionPagemailid(UtilityClass.getData("Sheet6", 0, 2));
		reg.inpHerosRegistartionPagemobilenumber(UtilityClass.getData("Sheet6", 0, 3));
		reg.inpHerosRegistartionPagepassword(UtilityClass.getData("Sheet6", 0, 4));
		reg.inpHerosRegistartionPageReEnterPassword(UtilityClass.getData("Sheet6", 0, 5));
		reg.clickHerosRegistartionPageCreateAnAccountbtn();
		
		
		

	}

	
	@AfterMethod
	public void FailTcScreenShot(ITestResult status) throws IOException
	
	{
		if(status.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreeShot(m, TCID);
		}
		
	}
}
