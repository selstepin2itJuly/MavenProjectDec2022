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
	
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>()
			{
				@Override
				public WebDriver initialValue()
				{
					String config = "./src/main/resources/config/config.properties";
					FileInputStream inputStream = null;
					WebDriver driver = null;
					Properties prop = new Properties();
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
						driver = new ChromeDriver();
					}else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
					{
						System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxagent"));
						FirefoxOptions opt = new FirefoxOptions();
						opt.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
						driver = new FirefoxDriver(opt);
					}else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
					{
						System.setProperty("webdriver.edge.driver", prop.getProperty("edgeagent"));
						driver = new EdgeDriver();
					}else
					{
						Throwable thr = new Throwable();
						thr.initCause(null);
					}
					driver.manage().window().maximize();
					//driver.manage().window().setSize(new Dimension(1024, 768));
					driver.get(prop.getProperty("url"));
					//implicit wait time
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
					return driver;
					
				}
		
			};
	public static DriverProvider getInstance() 
	{
		return instance;
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
