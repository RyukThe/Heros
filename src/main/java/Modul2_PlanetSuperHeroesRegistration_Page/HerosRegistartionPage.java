package Modul2_PlanetSuperHeroesRegistration_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerosRegistartionPage 
{	
	@FindBy(xpath = "//div[@class='col-6']") private WebElement title;
	@FindBy(xpath = "//input[@name='firstName']")  private WebElement firstname;
	@FindBy(xpath="(//input)[2]") private WebElement LastName;
	@FindBy(xpath = "(//input)[3]") private WebElement mailid;
	@FindBy(xpath = "(//input)[4]") private WebElement mobilnumber;
	@FindBy(xpath = "(//input)[5]") private WebElement password;
	@FindBy(xpath = "(//input)[6]") private WebElement reEnterPassword;
	@FindBy(xpath = "//button")  private WebElement CreateAnAccount;
	
	public HerosRegistartionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public String verifyHerosRegistartionPageTitle()
	{
		String actText = title.getText();
		return actText;
	}
	public void inpHerosRegistartionPagefirstname(String first)
	{
		firstname.sendKeys(first);
	}
	
	public void inpHerosRegistartionPageLastName(String lastname)
	{
		LastName.sendKeys(lastname);
	}
	
	public void inpHerosRegistartionPagemailid(String email)
	{
		mailid.sendKeys(email);
	}
	
	public void inpHerosRegistartionPagemobilenumber(String mob)
	{
		mobilnumber.sendKeys(mob);
	}
	
	public void inpHerosRegistartionPagepassword(String Password)
	{
		password.sendKeys(Password);
	}
	
	public void inpHerosRegistartionPageReEnterPassword(String Password)
	{
		reEnterPassword.sendKeys(Password);
	}
	
	public void clickHerosRegistartionPageCreateAnAccountbtn()
	{
		CreateAnAccount.click();
	}
	
	
}
