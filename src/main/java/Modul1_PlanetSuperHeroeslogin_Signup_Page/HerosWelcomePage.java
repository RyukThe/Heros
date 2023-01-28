package Modul1_PlanetSuperHeroeslogin_Signup_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerosWelcomePage
{
	
	@FindBy(xpath = "//input") private WebElement mailorphone;
	@FindBy(xpath="//button") private WebElement Continue;
	@FindBy(xpath="(//button)[2]") private WebElement register;
	@FindBy(xpath="//div[@class='col-12 col-lg-12']") private WebElement WelcomeTitle;

	public HerosWelcomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHerosWelcomePageTitle()
	{
		String act = WelcomeTitle.getText();
		
		return act;
	}
	
	public void inpHerosWelcomePagemailorphone(String email)
	{
		mailorphone.sendKeys(email);
	}
	
	
	public void clickHerosWelcomePageContinuebtn()
	{
		Continue.click();
		
	}
	public void clickHerosWelcomePageregisterbtn()
	{
		register.click();
	}
	
	
}
