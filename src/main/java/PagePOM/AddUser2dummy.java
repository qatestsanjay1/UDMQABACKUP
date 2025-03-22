package PagePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUser2dummy {
	
	//Variable Declaration
	
	@FindBy (xpath="(//a[@class='link dropdown-item'])[5]")
	private WebElement Settings;
	
	@FindBy (xpath="(//a[@class='link dropdown-item'])[7]")
	private WebElement UserManagement;
	
	@FindBy (xpath="//button[text()=' Add User ']")
	private WebElement AddUserbutton;
	
	
	
	//Variable Initialization
	
	WebDriver driver;
	public AddUser2dummy(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;  
	}
	
	// Variable Utilize
		
	public void ClickOnSettings () {
		Settings.click();
		
     }
	public void ClickOnUserManagement () {
		UserManagement.click();
     }
	
		
	
}