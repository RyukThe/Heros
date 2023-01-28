package Modul_PlanetSuperHeroesShop_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanetSuperHerosShopPage
{
	@FindBy(xpath = "//button[text()='Apparel']") private WebElement Apparel;
	@FindBy(xpath="//div[text()='Women T-Shirts']") private WebElement Women_T_Shirts;
	@FindBy(xpath = "(//div[@class='row'])[3]")  private WebElement WomenTShirtsTile;
	@FindBy(xpath = "//div[text()='No Products Found']") private WebElement NoProductsFound;
	@FindBy(xpath = "//div[text()='T-Shirts']") private WebElement TShirts;
	@FindBy(xpath = "//div[contains(@class,'text-muted ff')]") private WebElement Tshirtscount;
	@FindBy(xpath = "//div[text()='Joggers']") private WebElement joggers;
	@FindBy(xpath = "//div[text()='Faster Returns']") private WebElement fastReturn;
	@FindBy(xpath = "//div[text()='Price: High to Low']") private WebElement highto_low;
	@FindBy(xpath = "//button[text()='Collectibles']") private WebElement Collectibles;
	@FindBy(xpath = "//div[text()='Kotobukiya']") private WebElement Kotobukiya;
	@FindBy(xpath = "//div[contains(text(),'Oh s')]") private WebElement KotobuiyaPage;
	public PlanetSuperHerosShopPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickPlanetSuperHerosShopPageApparel()
	{
		Apparel.click();
	}
	
	public void clickPlanetSuperHerosShopPageWomen_T_Shirts()
	{
		Women_T_Shirts.click();
		
		
	}
	
	public String verifyPlanetSuperHerosShopPageWomenTShirtsTile()
	{
		String acttxt = WomenTShirtsTile.getText();
		return acttxt;
	}
	
	public String verifyPlanetSuperHerosShopPageNoProductsFound()
	{
		String actResult = NoProductsFound.getText();
		
		return actResult;
	}
	
	public void clickPlanetSuperHerosShopPageTshirt()
	{
		TShirts.click();
	}
	
	public String veryfyPlanetSuperHerosShopPageTshirtCount()
	{
		String count = Tshirtscount.getText();
		return count;
	}
	
	public void clickPlanetSuperHerosShopPageJoggers()
	{
		joggers.click();
	}
	
	public WebElement scrolltoPlanetSuperHerosShopPagefastreturn()
	{
		return fastReturn;
	}
	
	public WebElement scrollToPlanetSuperHerosShopPageHightolow()
	{
		return highto_low;
	}
	
	public void clickPlanetSuperHerosShopPageCollectibles()
	{
		Collectibles.click();
	}
	
	
	public void clickPlanetSuperHerosShopPageKotobukiya()
	{
		Kotobukiya.click();
	}

	public String verifyProductonKotobukiyapage()
	{
		String actTxt = KotobuiyaPage.getText();
		return actTxt;
	}
}
