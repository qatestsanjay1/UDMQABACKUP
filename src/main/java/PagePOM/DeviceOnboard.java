package PagePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeviceOnboard {
	
	//Variable Declare
	
	@FindBy (xpath="//a[@class='link float-right mt-1 small-font pointer']")
	private WebElement SendOTP1;
	
	@FindBy (xpath="(//a[@class='link dropdown-item active'])[1]")
	private WebElement Devices;
	
	@FindBy (xpath="//input[@placeholder='IMEI']")
	private WebElement SearchIMEI;
	
	@FindBy (xpath="//button[text()=' Search ']")
	private WebElement SearchButton;
	
	@FindBy (xpath="//button[text()=' Reset ']")
	private WebElement ResetButton;
	
	@FindBy (xpath="//li[@routerlink='/device-onboard']")
	private WebElement DevicesOnboard;
	
	@FindBy (xpath="//li[@routerlink='/device-list']")
	private WebElement DevicesList;
	
	@FindBy (xpath="//input[@placeholder='IMEI1']")
	private WebElement IMEI1;
	
	@FindBy (xpath="//input[@placeholder='IMEI2']")
	private WebElement IMEI2;
	
	@FindBy (xpath="//input[@placeholder='Manufacturer Name']")
	private WebElement ManufacturerName;
	
	@FindBy (xpath="//input[@id='dropdownBasic1']")
	private WebElement DeviceType;
	
	@FindBy (xpath="//button[text()=' 18 : AndroidT ']")
	private WebElement selectdevicetype;
	
	@FindBy (xpath="//button[text()=' Submit ']")
	private WebElement Submitbutton;
	
	@FindBy (xpath="//div[text()='IMEI 818181002200204 already exists with us. Try another.']")
	private WebElement IMEIExitsToast;
	
	@FindBy (xpath="//button[@id='actions']")
	private WebElement Actiontab;
	
	@FindBy (xpath="//button[text()=' View Device ']")
	private WebElement ViewDevice;
	
	@FindBy (xpath="//button[@class='btn-close']")
	private WebElement ClosePageButton;
	
	@FindBy (xpath="//button[@class='btn-close']")
	private WebElement ClosePageButton1;
	
	@FindBy (xpath="//button[text()=' Reboot Device ']")
	private WebElement RebootDevice;
	
	@FindBy (xpath="//button[text()=' Wipe Data ']")
	private WebElement WipeData;
	
	@FindBy (xpath="//button[text()=' Lock Device ']")
	private WebElement LockDevice;
	
	@FindBy (xpath="//button[text()=' Unlock Device ']")
	private WebElement UnlockDevice;
	
	@FindBy (xpath="//button[text()=' View Command Status ']")
	private WebElement ViewCommandStatus;
	
	@FindBy (xpath="//input[@formcontrolname='message']")
	private WebElement CommandMessage;
	
	@FindBy (xpath="//div[text()='Command enforced successfully. It will be reflected on device[s] within 24 hrs.']")
	private WebElement CommandSentToast;
	
	@FindBy (xpath="//li[@routerlink='/command-history']")
	private WebElement CommandHistory;
	
	@FindBy (xpath="//input[@placeholder='IMEI Search']")
	private WebElement IMEISearchHistory;
	
	@FindBy (xpath="//button[@class='input-group-text bg-transparent search-button search-field']")
	private WebElement IMEISearchButton1;
	
	
	//Variable Initialization
	
	WebDriver driver;
	public DeviceOnboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;  
	}
	
	// Variable Utilize
	
	public void ClickOnSendOTP1 () {
		SendOTP1.click();
     }
		
	public void ClickOnDevices () {
		Devices.click();
		
     }
	public void ClickOnDeviceOnboard () {
		DevicesOnboard.click();
		
     }
	
	public void ClickOnDeviceList () {
		DevicesList.click();
		
     }
	public void SearchIMEI (String IMEISEARCH) {
		SearchIMEI.click();
		SearchIMEI.sendKeys(IMEISEARCH);
     }
	
	public void SendOnIMEI1 (String IMEIS1) {
		IMEI1.click();
		IMEI1.sendKeys(IMEIS1);
     }
	
	public void ClickOnSearchButton () {
		SearchButton.click();
	}
	
	public void ClickOnResetButton () {
		ResetButton.click();
	}
	public void SendOnIMEI2 (String IMEIS2) {
		IMEI2.click();
		IMEI2.sendKeys(IMEIS2);
     }
	
	public void SendOnManufacture (String Manufactures) {
		ManufacturerName.click();
		ManufacturerName.sendKeys(Manufactures);
     }
	public void SelectDeviceType () {
		DeviceType.click();
		selectdevicetype.click();
     }
	
	public void ClickOnSubmitButton () {
		Submitbutton.click();
	}
	
	public void ClickOnAction () {
		Actiontab.click();
	}
	
	public void ClickOnViewDevice () {
		ViewDevice.click();
	}
	
	public void ClickOnDeviceDetailsPageClosebutton () {
		ClosePageButton.click();
	}
	public void ClickOnViewCommandStatusClosebutton () {
		ClosePageButton1.click();
	}
	public void ClickOnRebootDeviceCommand () {
		RebootDevice.click();
	}
	
	public void ClickOnWipeDataCommand () {
		WipeData.click();
	}
	
	public void ClickOnLockDeviceCommand () {
		LockDevice.click();
	}
	
	public void ClickOnUnockDeviceCommand () {
		UnlockDevice.click();
	}
	
	public void ClickOnViewCommandStatus () {
		ViewCommandStatus.click();
	}
	
	public void SendOnCommandMessage (String COMMANDMESSAGE) {
		CommandMessage.click();
		CommandMessage.sendKeys(COMMANDMESSAGE);
     }
	
	public String DeviceAlreadyExistsToast () {
		String deviceexistToast1=IMEIExitsToast.getText();
		return deviceexistToast1;
	}
	
	public String CommandSentSuccessToast () {
		String CommandSuccessToast1=CommandSentToast.getText();
		return CommandSuccessToast1;
	}
	
	public void ClickOnCommandHistoryTab () {
		CommandHistory.click();
	}
	
	public void SearchIMEICommandHistory (String IMEISEARCH1) {
		IMEISearchHistory.click();
		IMEISearchHistory.sendKeys(IMEISEARCH1);
     }
	public void ClickOnSearchButtonHistorypage () {
		IMEISearchButton1.click();
	}
	
	
	
}