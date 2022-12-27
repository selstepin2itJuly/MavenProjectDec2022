package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	public LoginPage(WebDriver dr)
	{
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory approach
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(css="[type='submit']")
	private WebElement loginButton;
	
	public void enterUsername(String user)
	{
		username.sendKeys(user); 
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
}
