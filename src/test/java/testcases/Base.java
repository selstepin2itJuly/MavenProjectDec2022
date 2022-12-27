package testcases;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;
import testbase.DriverProvider;
import testbase.TestData;

public class Base {

	public LoginPage lp;
	public DashboardPage dp;
	public TestData test;
	public MyInfoPage mip;
	public Base()
	{
		lp = new LoginPage(DriverProvider.getInstance().getDriver());
		dp = new DashboardPage(DriverProvider.getInstance().getDriver());
		test = new TestData();
		mip = new MyInfoPage(DriverProvider.getInstance().getDriver());
	}
}
