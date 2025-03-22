package PagePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateAccount {
	
	//Variable Declare
	
	@FindBy (xpath="(//a[@class='link dropdown-item'])[5]")
	private WebElement Settings;
	
	@FindBy (xpath="(//a[@class='link dropdown-item'])[6]")
	private WebElement UpdateAccount;
	
	@FindBy (xpath="//a[@class='btn btn btn-outline-primary']")
	private WebElement EditButton;
	
	@FindBy (xpath="//input[@formcontrolname='customerCareNo']")
	private WebElement CustomareCareContactfield;
	
	@FindBy (xpath="//input[@formcontrolname='logo']")
	private WebElement logofield;
	
	@FindBy (xpath="//button[text()='Submit']")
	private WebElement SubmitButton;
	
	@FindBy (xpath="//div[text()='Success']")
	private WebElement Successtoast;
	
	
	//Variable Initialization
	
	WebDriver driver;
	public UpdateAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;  
	}
	
	// Variable Utilize
		
	public void ClickOnSettings () {
		Settings.click();
		
     }
	public void ClickOnUpdateAccount () {
		UpdateAccount.click();
     }
	
	public void ClickOnEditbutton () {
		EditButton.click();
     }
	
	public void SendOnCustomareCareContactfield (String CustomareCareContact) throws InterruptedException {
		CustomareCareContactfield.click();
		CustomareCareContactfield.clear(); Thread.sleep(2000);
		CustomareCareContactfield.sendKeys(CustomareCareContact);
		
     }
	public void SendOnlogofield (String LOGO) throws InterruptedException {
		logofield.click();
		logofield.clear(); Thread.sleep(2000);
		logofield.sendKeys(LOGO);
     }
	
	public void ClickOnSubmitButton () {
		SubmitButton.click();
		
     }
	
	public String SuccessToast () {
		String SuccessToast1=Successtoast.getText();
		return SuccessToast1;
	}
	
	
	
		
	
}