package PlanetSuperHerossStoreTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Modul1_PlanetSuperHeroeslogin_Signup_Page.SignUp_Login_Page;

import PlanetsSuperHerosStorePage.PlanetsSuperHerosStorePage;

public class PlanetsSuperHerosStoreTest extends BaseClass
{
	
	int TCID;
	SignUp_Login_Page slp;
	PlanetsSuperHerosStorePage store;
	SoftAssert soft;
	
	@BeforeClass
	public void openBroswer() throws IOException
	{
		openBrowser();
		
		slp= new SignUp_Login_Page(m);
		store= new PlanetsSuperHerosStorePage(m);
		soft= new SoftAssert();
	}
	
	@Test
	public void verifyTitleFindStore() throws IOException
	{
		
		
		slp.clickSignUp_Login_Pagestore();
		TCID=21;
		
		String Store = store.verifyPlanetsSuperHerosStorePagefinstoretitle();
		
		Assert.assertEquals(Store, UtilityClass.getData("Sheet6", 8, 0));
		
		
	}
	
	
	@Test(dataProvider = "input")
	public void verifyPinAndCity(String input) throws EncryptedDocumentException, IOException
	{
		TCID=20;
		slp.clickSignUp_Login_Pagestore();
		store.inpPlanetsSuperHerosStorePagePincode(input);
		store.clickPlanetsSuperHerosStorePageFindstoreBtn();
		
		String actResult = store.verifyLocationPlanetsSuperHerosStorePagenoStore();
		
		
		soft.assertEquals(actResult, UtilityClass.getData("Sheet7", 2, 0));

		soft.assertAll();
	}
	
	@DataProvider(name = "input")
	public Object[] inputs() throws EncryptedDocumentException, IOException
	{
		Object inp[]= {
				UtilityClass.getData("Sheet7", 0, 0),
				UtilityClass.getData("Sheet7", 1, 0),
				UtilityClass.getData("Sheet7", 2, 0)
				
		};
		
		return inp;
	}
	
	
	@Test
	public void VerifyPinAndCity() throws EncryptedDocumentException, IOException
	{
		TCID=33;
		slp.clickSignUp_Login_Pagestore();
		
		store.inpPlanetsSuperHerosStorePagePincode(UtilityClass.getData("Sheet7", 0, 0));
		store.clickPlanetsSuperHerosStorePageFindstoreBtn();
		
		String actResult = store.verifyLocationPlanetsSuperHerosStorePagenoStore();
		
		
		soft.assertEquals(actResult, UtilityClass.getData("Sheet7", 2, 0));

		soft.assertAll();
	}
	@AfterMethod
	public void failedtestCasesSS(ITestResult s) throws IOException, InterruptedException
	{
		
		if(s.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.getScreenshot(m, TCID);	
		}
		
	}
	
	
	@AfterClass
	public void closeBroswer()
	{
		m.quit();
	}
}
