package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import testbase.DriverProvider;


public class TestUtility{

	public static void scrollToElement(WebElement ele)
	{
		JavascriptExecutor je = (JavascriptExecutor) DriverProvider.getInstance().getDriver();
		je.executeScript("arguments[0].scrollIntoView(false);", ele);
		je.executeScript("window.scrollBy(0,300)", "");
	}

	public static void clickOnElementJS(WebElement ele)
	{
		JavascriptExecutor je = (JavascriptExecutor) DriverProvider.getInstance().getDriver();
		je.executeScript("arguments[0].click();", ele);
		
	}
	
	public static void captureSceenshot() throws IOException
	{
		File f = new File("screenshot");
		if(!f.isDirectory())
		{
			System.out.println("creating folder");
			f.mkdir();
		}else
		{
			System.out.println("folder exist!");
		}
		TakesScreenshot ts = (TakesScreenshot) DriverProvider.getInstance().getDriver();
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("./"+f+"/"+getDate()+"_image.png")); //jpg and png
	}
	
	public static void attacheSceenshot() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) DriverProvider.getInstance().getDriver();
		String file = ts.getScreenshotAs(OutputType.BASE64);
		String tag = "<img src=\"data:image/png;base64,"+file+"\" height=\"600\" width=\"800\" />";
		Reporter.log(tag);
	}
	
	public static String getDate()
	{
		Date dt = new Date();
		//System.out.println(dt);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MMM_dd_HH_mm_ss_SSS");
		String s = sdf.format(dt);
		//System.out.println(s);
		return s;
	}
}
