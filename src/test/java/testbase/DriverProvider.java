package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverProvider {

	private DriverProvider()
	{
		
	}
	private static DriverProvider instance = new DriverProvider();
	public static Properties prop;
	//private static String URL;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>()
			{
				@Override
				public WebDriver initialValue()
				{
					String config = "./src/main/resources/config/config.properties";
					FileInputStream inputStream = null;
				//	WebDriver driver = null;
					prop = new Properties();
					//URL = prop.getProperty("url");
					try {
						inputStream = new FileInputStream(new File(config));
						prop.load(inputStream);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
					{
						System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeagent"));
						return new ChromeDriver();
					}else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
					{
						System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxagent"));
						FirefoxOptions opt = new FirefoxOptions();
						opt.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
						return new FirefoxDriver(opt);
					}else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
					{
						System.setProperty("webdriver.edge.driver", prop.getProperty("edgeagent"));
						return new EdgeDriver();
					}else
					{
						return null;
					}
					
										
				}
		
			};
	public static DriverProvider getInstance() 
	{
		return instance;
	}

	public static String getURL() 
	{
		return prop.getProperty("url");
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public void closeDriver()
	{
		driver.get().quit();
		driver.remove();
		
	}
}
