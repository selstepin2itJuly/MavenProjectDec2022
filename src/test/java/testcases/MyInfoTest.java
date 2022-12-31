package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testbase.DriverProvider;
import utilities.TestUtility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

//@Test(singleThreaded=true)
public class MyInfoTest extends Base {
  @Test(priority=1, description="Verify My info menu count", enabled=true)
  public void myInfoMenuItemCount() throws IOException {
	  lp.enterUsername(test.username);
	  lp.enterPassword(test.password);
	  lp.clickOnLoginButton();
	  mip.clickOnMyInfo();
	  int a =mip.getItemCountMyInfo();
	  TestUtility.attacheSceenshot();
	  Assert.assertEquals(a, 11);
  }
  
  @Test(priority=2, description="My Info Menu Text validation")
  public void myInfoMenuItemText() throws IOException {
	  lp.enterUsername(test.username);
	  lp.enterPassword(test.password);
	  lp.clickOnLoginButton();
	  mip.clickOnMyInfo();
	   List<String> act = mip.getSideMenuTextMyInfo();
	   List<String> exp = new ArrayList<String>();
	   exp.add("Personal Details");
	   exp.add("Contact Details");
	   exp.add("Emergency Contact");
	   exp.add("Dependents");
	   exp.add("Immigration");
	   exp.add("Job");
	   exp.add("Salary");
	   exp.add("Tax Exemptions");
	   exp.add("Report-to");
	   exp.add("Qualifications");
	   exp.add("Membership");
	   
	   //Assert.assertEquals(act, exp);
	   SoftAssert sa = new SoftAssert();
	   for(int i=0;i<exp.size();i++)
	   {
		  sa.assertEquals(act.get(i), exp.get(i)); 
	   }
	   sa.assertAll();
	   TestUtility.attacheSceenshot();
	   }


 
}
