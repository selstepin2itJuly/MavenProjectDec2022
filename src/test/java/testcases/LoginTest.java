package testcases;

import org.testng.annotations.Test;

import utilities.TestUtility;


import java.io.IOException;

import org.testng.Assert;

//@Test(singleThreaded=true)
public class LoginTest extends Base {
  @Test(priority = 1, description="Verify Successful Login")
  public void loginTestSuccess_001() throws IOException {
	  lp.enterUsername(test.username)
	  .enterPassword(test.password)
	  .clickOnLoginButton();
	  TestUtility.attacheSceenshot();
	  boolean b = dp.isDashboardTextVisbile();
	  TestUtility.attacheSceenshot();
	  Assert.assertTrue(b);
	  dp.logout();
	  TestUtility.attacheSceenshot();
  }
  
  @Test(priority=0, description="Verify Unsuccessful Login")
  public void loginTestUnSuccessful_002() throws IOException {
	  lp.enterUsername(test.invalidUsername)
	  .enterPassword(test.invalidPassword)
	  .clickOnLoginButton();
	  TestUtility.attacheSceenshot();
	  boolean b = dp.isDashboardTextVisbile();
	  TestUtility.attacheSceenshot();
	  Assert.assertFalse(b);
  }

}
