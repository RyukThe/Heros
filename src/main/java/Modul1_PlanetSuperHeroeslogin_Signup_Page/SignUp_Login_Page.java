package Modul1_PlanetSuperHeroeslogin_Signup_Page;


import java.util.List;

import org.openqa.selenium.By;import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import LibraryFiles.UtilityClass;

public class SignUp_Login_Page
{
	@FindBy(xpath="//div[@class='col-2']") private WebElement logo;
	@FindBy(xpath = "//input[@type='search']") private WebElement searchfeild;
	@FindBy(xpath="//ul[@role='listbox']") private WebElement suggation;
	@FindBy(xpath="//span[text()='Profile']") private WebElement profile;
	@FindBy(xpath="//button[text()='LOGIN/SIGNUP']") private WebElement login_singupbtn;
	@FindBy(xpath = "//a[@href='javascript:void(0);']") private WebElement shop;
	@FindBy(xpath = "//button[text()='PSH Kids']") private WebElement PSH_Kids;
	@FindBy(xpath="//div[text()='Stores']") private WebElement store;
	
	public SignUp_Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifylSignUp_Login_Pagelogo()
	{
		boolean actRe = logo.isDisplayed();
		return actRe;
		
		
	}
	
	public void clickOnSignUp_Login_PageLogo()
	{
		logo.click();
	}
	
	public void inpSignUp_Login_PageserachField(String prod)
	{
		searchfeild.sendKeys(prod);
		
	}
	
	public void autosuggSignUp_Login_Page(String prod) throws InterruptedException
	{
			List<WebElement> sug = suggation.findElements(By.xpath("//li"));
			for(WebElement sugg:sug)
			{
				String str = sugg.getText();
				
				if(str.equals(prod))
				{
					
					sugg.click();
					
					break;
				}
			}
	
		
	}
	
	public WebElement clickSignUp_Login_Pageprofile()
	{
		 return profile;
	}
	
	
	public void login_signSignUp_Login_Page()
	{
	
		login_singupbtn.click();
	}
	
	
	public WebElement SignUp_Login_PageShopsection()
	{
		return shop;
	}
	
	public void clickSignUp_Login_PSH_Kids()
	{
		 PSH_Kids.click();;
	}

	public WebElement searchWeb()
	{
		return searchfeild;
	}
	
	public void  clickSignUp_Login_Pagestore()
	{
		store.click();
	}

}
