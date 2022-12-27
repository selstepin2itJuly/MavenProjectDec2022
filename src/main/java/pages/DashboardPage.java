package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	private WebDriver driver;
	public DashboardPage(WebDriver dr)
	{
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement dashboardText;
	
	@FindBy(css="span[class='oxd-userdropdown-tab']>i")
	private WebElement arrow;
	
	@FindBy(css="a[class='oxd-userdropdown-link'][href$='logout']")
	private WebElement logout;
	
	public Boolean isDashboardTextVisbile()
	{
		boolean b = false;
		try {
			b = dashboardText.isDisplayed();
		}catch(Exception e)
		{
			e.getStackTrace();
		}
		return b;
	}
	
	public void logout()
	{
		arrow.click();
		logout.click();
	}
	
	public int getDashboardMenuItemCount()
	{
		return 0;
	}
	
	public List<String> getDashboardItemText()
	{
		List<String> tmp = new ArrayList<String>();
		return tmp;
	}
}
