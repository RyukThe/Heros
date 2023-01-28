package PlanetSuperHerosPSHKidsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanetsSuperHerosPSH_KidsPage
{
	@FindBy(xpath = "//div[@class='col-2']") private WebElement logoPHSKIDS;
	@FindBy(xpath = "((//div[@class='container'])//div)[47]") private WebElement price;
	@FindBy(xpath = "//div[contains(text(),'Disn')]") private WebElement disney;
	
	public PlanetsSuperHerosPSH_KidsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPlanetsSuperHerosPSH_KidsPagelogo()
	{
		boolean actResult = logoPHSKIDS.isDisplayed();
		return actResult;
	}
	
	public void clcikPlanetsSuperHerosPSH_KidsPageDisny()
	{
		disney.click();
	}
	
	public String vrifyPlanetsSuperHerosPSH_KidsPageprice()
	{
		String actResult = price.getText();
		
		return actResult;
	}
	
	
	
}
