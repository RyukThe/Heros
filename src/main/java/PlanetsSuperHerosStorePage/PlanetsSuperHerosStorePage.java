package PlanetsSuperHerosStorePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanetsSuperHerosStorePage 
{
	
	@FindBy(xpath = "(//div/h1)[1]") private WebElement findstore;
	@FindBy(xpath = "//input[@name='pincode']") private WebElement pincode;
	@FindBy(xpath = "//button[text()='Find stores ']") private WebElement findstoreBtn;
	@FindBy(xpath = "//div[text()='No stores available in your area']") private WebElement nostore;
	public PlanetsSuperHerosStorePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyPlanetsSuperHerosStorePagefinstoretitle()
	{
		String actText = findstore.getText();
		return actText;
	}
	
	public void inpPlanetsSuperHerosStorePagePincode(String  pin)
	{
		pincode.sendKeys(pin);
	}
	
	public void clickPlanetsSuperHerosStorePageFindstoreBtn()
	{
		findstoreBtn.click();
	}

	public String verifyLocationPlanetsSuperHerosStorePagenoStore()
	{
		String actresult = nostore.getText();
		return actresult;
	}
	
}
