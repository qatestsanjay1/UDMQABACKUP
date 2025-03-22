package PagePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePassword {
	
	//Variable Declare
	
	@FindBy (xpath="(//a[@class='link dropdown-item'])[5]")
	private WebElement Settings;
	
	@FindBy (xpath="(//a[@class='link dropdown-item'])[8]")
	private WebElement ChangePassword;
	
	@FindBy (xpath="//input[@placeholder='Current Password']")
	private WebElement CurrentPassword;
	
	@FindBy (xpath="//input[@placeholder='New Password']")
	private WebElement NewPassword;
	
	@FindBy (xpath="//input[@placeholder='Confirm Password']")
	private WebElement ConfirmPassword;
	
	@FindBy (xpath="//button[text()='Submit']")
	private WebElement SubmitButton;
	
	@FindBy (xpath="//div[text()='Invalid current password. Please provide a valid current password']")
	private WebElement InvaliPasswordtoast;
	
	@FindBy (xpath="//div[text()='Success']")
	private WebElement Successtoast;
	
	@FindBy (xpath="//i[@class='bi bi-eye-slash-fill pointer old-password-icon']")
	private WebElement Oldpasseyeicon;
	
	@FindBy (xpath="//i[@class='bi bi-eye-slash-fill pointer new-password-icon']")
	private WebElement Newpasseyeicon;
	
	
	//Variable Initialization
	
	WebDriver driver;
	public ChangePassword(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;  
	}
	
	// Variable Utilize
		
	public void ClickOnSettings () {
		Settings.click();
		
     }
	public void ClickOnChangePassword () {
		ChangePassword.click();
     }
	
	public void SendOnCurrentPassword (String CURRENTPASS) {
		CurrentPassword.click();
		CurrentPassword.clear();
		CurrentPassword.sendKeys(CURRENTPASS);
     }
	
	public void SendOnNewPassword (String NEWPASS) {
		NewPassword.click();
		NewPassword.sendKeys(NEWPASS);
     }
	
	public void SendOnConfirmPassword (String CONFIRMPASS) {
		ConfirmPassword.click();
		ConfirmPassword.sendKeys(CONFIRMPASS);
     }
	
	public void ClickOnSubmitbutton () {
		SubmitButton.click();
     }
	
	public String InvalidpasswordToast () {
		String invalidToast1=InvaliPasswordtoast.getText();
		return invalidToast1;
	}
	
	
	public String SuccessToast () {
		String SuccessToast1=Successtoast.getText();
		return SuccessToast1;
	}
		
	
}