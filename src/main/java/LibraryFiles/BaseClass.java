package LibraryFiles;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseClass
{
	public static WebDriver m;
	public ChromeOptions op;
	public void openBrowser() throws IOException
	{op= new ChromeOptions();

	op.addArguments("--remote-allow-origins=*");
	m=new  ChromeDriver(op);
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		m.get(UtilityClass.getPropertyFileData("URL"));
	}
	
	public void openBrowser(String BrowserName) throws IOException
	{
		if(BrowserName.equals("chrome"))
		{
			m= new ChromeDriver();
		
		}
		else if(BrowserName.equals("edge"))
		{
			m=new EdgeDriver();
		}
		else if(BrowserName.equals("firefox"))
		{
			m= new FirefoxDriver();
		}
		m.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		m.get(UtilityClass.getPropertyFileData("URL"));
	}

	
	
	public String cpatureScreen(String TestName) throws IOException
	{
		String timeStamp=new  SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File src = ((TakesScreenshot)m).getScreenshotAs(OutputType.FILE);
		String des="D:\\eclipse\\heros\\FailedTestCasesSS\\"+timeStamp+"-"+TestName+".png";
		
		FileHandler.copy(src, new File(des));
		return des;
	}
}
