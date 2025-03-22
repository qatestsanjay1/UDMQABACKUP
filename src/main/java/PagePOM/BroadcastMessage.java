package PagePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BroadcastMessage {
	
	//Variable Declare
	
	@FindBy (xpath="//li[@routerlink='/broadcast-message']")
	private WebElement BroadcastMessage;
	
	@FindBy (xpath="//button[text()=' Compose Message']")
	private WebElement ComposeMessageButton;
	
	@FindBy (xpath="//textarea[@placeholder='Message Text']")
	private WebElement MessageText;
	
	@FindBy (xpath="//select[@id='priority']")
	private WebElement priorityselect;
	
	@FindBy (xpath="//option[text()='MID']")
	private WebElement MIDPriority;
	
	@FindBy (xpath="//button[text()='Submit']")
	private WebElement SubmitButton;
	
	
	@FindBy (xpath="//div[text()='Broadcast message request is accepted successfully, device[s] will receive this message within 24 hrs.']")
	private WebElement BroadMessageToast;
	
	
	//Variable Initialization
	
	WebDriver driver;
	public BroadcastMessage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;  
	}
	
	// Variable Utilize
		
	public void ClickOnBroadcastMessagetab () {
		BroadcastMessage.click();
		
     }
	public void ClickOnComposeMessageButton () {
		ComposeMessageButton.click();
     }
	
	public void ClickOnPriorityselect () {
		priorityselect.click();
     }
	
	public void SendOnMessageTextfield (String MESSAGETEXT) throws InterruptedException {
		MessageText.click();
		MessageText.sendKeys(MESSAGETEXT);
		
     }
	
	public void SelectMIDPriority () {
		MIDPriority.click();
     }
	
	public void ClickOnSubmitButton () {
		SubmitButton.click();
		
     }
	
	public String BroadcastMessageSuccessToast () {
		String BroadMessageSuccessToast1=BroadMessageToast.getText();
		return BroadMessageSuccessToast1;
	}
	
	
	
		
	
}