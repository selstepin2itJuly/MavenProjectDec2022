package testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;
import testbase.DriverProvider;
import testbase.TestData;
import utilities.TestUtility;

public class Base {

	public LoginPage lp;
	public DashboardPage dp;
	public TestData test;
	public MyInfoPage mip;
		
	@BeforeMethod
	public void beforeTest(Method result) throws InterruptedException {	
		
		
		WebDriver dr = DriverProvider.getInstance().getDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		dr.get(DriverProvider.getURL());
		lp = new LoginPage(dr);
		dp = new DashboardPage(dr);
		test = new TestData();
		mip = new MyInfoPage(dr);
		
		
	}
	
	
	@AfterMethod
	public void afterTest(ITestResult res) throws IOException {
		 int status = res.getStatus();
		 
		System.out.println(status);
		if(status!=1) {
			TestUtility.attacheSceenshot();
		}
		DriverProvider.getInstance().closeDriver();
		
		 
	}
}
