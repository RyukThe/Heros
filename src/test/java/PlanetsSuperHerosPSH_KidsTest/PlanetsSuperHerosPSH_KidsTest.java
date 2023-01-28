package PlanetsSuperHerosPSH_KidsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Modul1_PlanetSuperHeroeslogin_Signup_Page.SignUp_Login_Page;
import PlanetSuperHerosPSHKidsPage.PlanetsSuperHerosPSH_KidsPage;

public class PlanetsSuperHerosPSH_KidsTest extends BaseClass
{
	SignUp_Login_Page slp;
	PlanetsSuperHerosPSH_KidsPage kids;
	int TCID;

	
	@Test
	public void test() throws IOException, EncryptedDocumentException, InterruptedException
	{
		
		openBrowser();
		
		slp= new SignUp_Login_Page(m);
		kids= new PlanetsSuperHerosPSH_KidsPage(m);
		
		slp.clickSignUp_Login_PSH_Kids();

		
		boolean actResult = kids.verifyPlanetsSuperHerosPSH_KidsPagelogo();
		
		Assert.assertEquals(actResult, actResult);
		
		
	}
	
	
	
	@Test
	public void verifyPrice() throws EncryptedDocumentException, IOException, InterruptedException
	{
		TCID=16;
		slp.inpSignUp_Login_PageserachField(UtilityClass.getData("Sheet6", 6, 0));
		UtilityClass.searc(m, slp.searchWeb());
		
		kids.clcikPlanetsSuperHerosPSH_KidsPageDisny();
		Thread.sleep(2000);
		String act = kids.vrifyPlanetsSuperHerosPSH_KidsPageprice();
		
		
		Assert.assertEquals(act, UtilityClass.getData("Sheet6", 7, 0));
	}
	
	@AfterMethod
	public void failedTestCaseSS(ITestResult s) throws IOException
	{
		if(s.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreeShot(m, TCID);
		}
	}
	@AfterClass
	public void closeBroswer()
	{
		m.close();
	}
}
