package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;



import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;



public class UtilityClass 
{
	public static String getData(String SheetName,int  rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream("D:\\eclipse\\heros\\TestData\\sele.xlsx");
		String value = WorkbookFactory.create(file).getSheet( SheetName).getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		return value;
	}
	
	public static String getPropertyFileData(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("D:\\eclipse\\heros\\PlanetSuperHeroes.properties");
	
		Properties p= new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		
		return value;
	
	}
	
	public static void captureScreeShot(WebDriver driver, int TCID) throws IOException
	{
File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dec=new File("D:\\eclipse\\heros\\FailedTestCasesSS\\Heros-"+ TCID +".png");
		FileHandler.copy(src,dec);
		
	}
	
	
	public static void getHandelDropDown(WebDriver Driver, WebElement WElemenet)
	{
		Actions act= new Actions(Driver);
		act.moveToElement(WElemenet).perform();
	}
	
	public static void getclikonWebElement(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.click(element).perform();
		
		
		
		
	}
	
	public static void scrollToElement(WebDriver driver , WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void searc(WebDriver driver,WebElement search)
	{
		Actions act=new Actions(driver);
		act.sendKeys(search, Keys.ENTER).perform();;
	}
	
	public static void getScreenshot(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dsx= new File("D:\\eclipse\\heros\\FailedTestCasesSS\\HerosTCID"+TCID+".png");
		
		
		FileHandler.copy(src, dsx);
	
	}
	



}
