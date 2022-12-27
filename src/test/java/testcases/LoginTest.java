package testcases;

import org.testng.annotations.Test;

import testbase.DriverProvider;
import testbase.TestData;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest extends Base {
  @Test(priority = 1, description="Verify Successful Login")
  public void loginTestSuccess_001() throws IOException {
	  lp.enterUsername(test.username);
	  lp.enterPassword(test.password);
	  TestUtility.attacheSceenshot();
	  lp.clickOnLoginButton();
	  boolean b = dp.isDashboardTextVisbile();
	  TestUtility.attacheSceenshot();
	  Assert.assertTrue(b);
	  dp.logout();
	  TestUtility.attacheSceenshot();
  }
  
  @Test(priority=0, description="Verify Unsuccessful Login")
  public void loginTestUnSuccessful_002() throws IOException {
	  lp.enterUsername(test.invalidUsername);
	  lp.enterPassword(test.invalidPassword);
	  TestUtility.attacheSceenshot();
	  lp.clickOnLoginButton();
	  boolean b = dp.isDashboardTextVisbile();
	  TestUtility.attacheSceenshot();
	  Assert.assertFalse(b);
  }
  @BeforeMethod //pre condition
  public void beforeMethod() {
	  DriverProvider.getInstance().getDriver();
  }

  @AfterMethod //post condition
  public void afterMethod() throws IOException {
	 // DriverProvider.getInstance().closeDriver();
  }

}
