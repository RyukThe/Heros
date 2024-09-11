package PlanetSuperHerosShopTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.annotations.ITest;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Modul1_PlanetSuperHeroeslogin_Signup_Page.SignUp_Login_Page;
import Modul_PlanetSuperHeroesShop_Page.PlanetSuperHerosShopPage;

public class PlanetSuperHerosShopTest extends BaseClass
{
	PlanetSuperHerosShopPage shop;
	SignUp_Login_Page slp;
	SoftAssert sof;
	int TCID;
//	@Parameters("BrowserName")
	@BeforeClass
	public void shop( ) throws IOException
	{
		openBrowser();
		TCID=7;
		shop=new PlanetSuperHerosShopPage(m);
		slp=new SignUp_Login_Page(m);
		sof= new SoftAssert();
	}
		
		@Test(priority = 0)
		public void shop1() throws EncryptedDocumentException, IOException
		{
			
		
		UtilityClass.getHandelDropDown(m, slp.SignUp_Login_PageShopsection());
		
		shop.clickPlanetSuperHerosShopPageApparel();
		shop.clickPlanetSuperHerosShopPageWomen_T_Shirts();
		
		String actResult = shop.verifyPlanetSuperHerosShopPageWomenTShirtsTile();
		sof.assertEquals(actResult, UtilityClass.getData("Sheet6", 3, 0));
		
		sof.assertEquals(shop.verifyPlanetSuperHerosShopPageNoProductsFound(),UtilityClass.getData("Sheet6", 4, 0));
		
		
			
	}
	
	@Test(priority = 1)
	public void NoProductsFound() throws IOException, InterruptedException
	{
		TCID=8;
		if(shop.verifyPlanetSuperHerosShopPageWomenTShirtsTile().equals(UtilityClass.getData("Sheet6", 4, 0)))
		{
			
		
			UtilityClass.captureScreeShot(m, TCID);
		}
		slp.clickOnSignUp_Login_PageLogo();
		
		
		UtilityClass.getHandelDropDown(m, slp.SignUp_Login_PageShopsection());
		
		shop.clickPlanetSuperHerosShopPageTshirt();
		
		String count = shop.veryfyPlanetSuperHerosShopPageTshirtCount();
			System.out.println(count);
	}
	
	@Test(priority = 2)
	public void joggers() throws InterruptedException
	{
		TCID=9;
		slp.clickOnSignUp_Login_PageLogo();
		UtilityClass.getHandelDropDown(m, slp.SignUp_Login_PageShopsection());
		
		shop.clickPlanetSuperHerosShopPageJoggers();
		Thread.sleep(2000);
		UtilityClass.scrollToElement(m, shop.scrolltoPlanetSuperHerosShopPagefastreturn());
		Thread.sleep(500);
		UtilityClass.scrollToElement(m, shop.scrollToPlanetSuperHerosShopPageHightolow());
		
	}
	@Test(priority = 3)
	public void Collectibles() throws InterruptedException, EncryptedDocumentException, IOException
	
	{
		TCID=10;
		slp.clickOnSignUp_Login_PageLogo();
		
		Thread.sleep(2000);
		UtilityClass.getHandelDropDown(m, slp.SignUp_Login_PageShopsection());
		shop.clickPlanetSuperHerosShopPageCollectibles();
		shop.clickPlanetSuperHerosShopPageKotobukiya();
		
		String act = shop.verifyProductonKotobukiyapage();
		sof.assertEquals(act, UtilityClass.getData("Sheet6", 5, 0));
	}
	
	
	@AfterMethod 
	public void FailedTcSS(ITestResult s) throws IOException
	{
		if(s.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreeShot(m, TCID);
		}
	}
	
	
	@AfterClass
	public void closeBrowser()
	{
		m.close();
	}
	
}
