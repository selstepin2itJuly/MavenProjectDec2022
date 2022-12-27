package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {

	private WebDriver driver;
	public MyInfoPage(WebDriver dr)
	{
		this.driver = dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Info']")
	private WebElement myInfo;
	
	@FindBy(xpath="//div[@role='tablist']/div/a")
	private List<WebElement> sideMenu;
	
	public void clickOnMyInfo()
	{
		myInfo.click();
	}
	
	public int getItemCountMyInfo()
	{
		return sideMenu.size();
	}
	
	public List<String> getSideMenuTextMyInfo()
	{
		List<String> tmp = new ArrayList<String>();
		for(WebElement e:sideMenu)
		{
			tmp.add(e.getText().trim());
		}
		
		return tmp;
	}
	
}

