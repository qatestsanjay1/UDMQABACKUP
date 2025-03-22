package TestClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BrowserSetup.Base;
import PagePOM.BroadcastMessage;
import PagePOM.DeviceOnboard;
import PagePOM.LoginPage;
import Utils.Utility;

public class DeviceOnboardTest extends Base {
	
	WebDriver driver;
	LoginPage login;
	DeviceOnboard devieceon;
	BroadcastMessage broadcast;
	SoftAssert soft;
	String TESTID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	
	
	@Parameters("browser")
	@BeforeTest
	
	public void OpenBrowser(String BrowserName) {
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		System.out.println("Before Test-3");
		if(BrowserName.equals("Chrome"))
		{
			driver=OpenChromeBrowser();
		}
		if(BrowserName.equals("Firefox"))
	    {
			driver=OpenFirefoxBrowser();
		}
			
	    driver.manage().window().maximize();
		
	}
	
	@BeforeClass
	public void createPOMObject() {
		System.out.println("Before Class-3");
        login=new LoginPage(driver);
		devieceon=new DeviceOnboard(driver);
		broadcast=new BroadcastMessage(driver);
		
	}
	
	@BeforeMethod
	public void Open_the_Application() throws InterruptedException {
		System.out.println("Before Method-3");
		driver.get("https://jioudmentsit.jio.com/#/");
		Thread.sleep(8000);
		soft=new SoftAssert();
       
	}
	
	@Test(priority=28)
	public void To_Verify_On_Acknowledgement_page_application_allow_to_click_on_Agree_button() throws InterruptedException, IOException {
		TESTID="TEST-TC-28";
		login.ClickOnAgreeButton();       Thread.sleep(2000);
		driver.navigate().refresh();      Thread.sleep(2000);
	
}
	@Test(priority=29)
	public void To_Verify_The_login_functionality_after_changing_password() throws InterruptedException, IOException {
		TESTID="TEST-TC-29";
		login.ClickOnAgreeButton();       Thread.sleep(2000);
		login.SendOnUsername("sanjay10");        Thread.sleep(3000);
		login.SendOnPassword("Pass@12345");        Thread.sleep(3000);
		devieceon.ClickOnSendOTP1();              
		Thread.sleep(30000);
		login.ClickOnLoginButton();
		Thread.sleep(10000);

	}
	
	@Test(priority=30)
	public void To_Verify_Search_functionality_by_passing_imei() throws InterruptedException, IOException {
		TESTID="TEST-TC-30";
		driver.navigate().refresh();    Thread.sleep(3000);
		devieceon.SearchIMEI("818181002200204");
		devieceon.ClickOnSearchButton();
		Thread.sleep(2000);

	}
	@Test(priority=31)
	public void To_verify_after_search_imei_is_reset_button_working_as_expected() throws InterruptedException, IOException {
		TESTID="TEST-TC-31";
		driver.navigate().back();  Thread.sleep(3000);
		devieceon.ClickOnResetButton();
	}
	@Test(priority=32)
	public void To_verify_application_allow_to_click_on_device_onboard_tab() throws InterruptedException, IOException {
		TESTID="TEST-TC-32";
		driver.navigate().back();  Thread.sleep(3000);
		devieceon.ClickOnDevices();           Thread.sleep(3000);
		devieceon.ClickOnDeviceOnboard();     Thread.sleep(3000);
		
		String DeviceOnboardURL =driver.getCurrentUrl();
		System.out.println("Device Onboard Page URL: " + DeviceOnboardURL);
		soft.assertEquals(DeviceOnboardURL, "https://jioudmentsit.jio.com/#/device-onboard", "Device Onboard tab did not get clicked.");
	}
	
	@Test(priority=33)
	public void To_verify_application_allow_to_enter_data_in_imei1_input_field() throws InterruptedException, IOException {
		TESTID="TEST-TC-33";
		driver.navigate().back();  Thread.sleep(2000);
		devieceon.SendOnIMEI1("818181002200204");      Thread.sleep(2000);
		
	}
	
	@Test(priority=34)
	public void To_verify_application_allow_to_enter_data_in_imei2_input_field() throws InterruptedException, IOException {
		TESTID="TEST-TC-34";
		driver.navigate().back();  Thread.sleep(2000);
		devieceon.SendOnIMEI2("818181002200204");   Thread.sleep(2000);
		
	}
	
	@Test(priority=35)
	public void To_verify_application_allow_to_enter_data_in_manufacture_input_field() throws InterruptedException, IOException {
		TESTID="TEST-TC-35";
		driver.navigate().back();  Thread.sleep(2000);
		devieceon.SendOnManufacture("AutomationDevice");   Thread.sleep(2000);
		
	}
	
	@Test(priority=36)
	public void To_verify_application_allow_to_select_device_type() throws InterruptedException, IOException {
		TESTID="TEST-TC-36";
		driver.navigate().back();  Thread.sleep(2000);
		devieceon.SelectDeviceType();   Thread.sleep(2000);
		
	}
	
	@Test(priority=37)
	public void To_verify_Is_application_allow_to_enroll_alreday_exists_device_on_portal() throws InterruptedException, IOException {
		TESTID="TEST-TC-37";
		driver.navigate().back();  Thread.sleep(2000);
		devieceon.SendOnIMEI1("818181002200204");
		devieceon.SendOnIMEI2("818181002200204");
		devieceon.SendOnManufacture("AutomationDevice"); 
		devieceon.SelectDeviceType();  Thread.sleep(2000);
		devieceon.ClickOnSubmitButton();  Thread.sleep(2000);
		
		String AlradyExistsDeviceToast = devieceon.DeviceAlreadyExistsToast();
		System.out.println("Already exists device Toast Message : " + AlradyExistsDeviceToast);
		soft.assertEquals(AlradyExistsDeviceToast, "IMEI 818181002200204 already exists with us. Try another.", 
				"Device not exists on database ");	
	}
	
	@Test(priority=38)
	public void To_verify_Is_application_allow_to_click_on_device_list_tab() throws InterruptedException, IOException {
		TESTID="TEST-TC-38";
		driver.navigate().back();     Thread.sleep(2000);
		devieceon.ClickOnDevices();
		devieceon.ClickOnDeviceList(); Thread.sleep(2000);
		
		String DeviceListURL =driver.getCurrentUrl();
		System.out.println("Device List Page URL: " + DeviceListURL);
		soft.assertEquals(DeviceListURL, "https://jioudmentsit.jio.com/#/device-list", "Device List tab did not get clicked.");
	}
	
	@Test(priority=39)
	public void To_verify_Is_application_allow_to_click_on_action_option() throws InterruptedException, IOException {
		TESTID="TEST-TC-39";
		driver.navigate().back();     Thread.sleep(2000);
		devieceon.SearchIMEI("818181002200204");
		devieceon.ClickOnSearchButton();
		Thread.sleep(2000);
		devieceon.ClickOnAction();
		
	}
	
	@Test(priority=40)
	public void To_verify_application_allow_to_click_on_view_device_option_via_action() throws InterruptedException, IOException {
		TESTID="TEST-TC-40";
		driver.navigate().back();     Thread.sleep(2000);
		devieceon.SearchIMEI("818181002200204");
		devieceon.ClickOnSearchButton();      Thread.sleep(2000);
		devieceon.ClickOnAction();            Thread.sleep(2000);
		devieceon.ClickOnViewDevice();  Thread.sleep(3000);
		
		
	}
	
	@Test(priority=41)
	public void To_verify_on_view_device_page_application_allow_to_click_on_close_button() throws InterruptedException, IOException {
		TESTID="TEST-TC-41";
		devieceon.ClickOnDeviceDetailsPageClosebutton();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=42)
	public void To_verify_application_allow_to_send_reboot_device_command_to_device_via_action() throws InterruptedException, IOException {
		TESTID="TEST-TC-42";
		driver.navigate().back();     Thread.sleep(3000);
		devieceon.SearchIMEI("818181002200204");
		devieceon.ClickOnSearchButton();      Thread.sleep(2000);
		devieceon.ClickOnAction();            Thread.sleep(2000);
		devieceon.ClickOnRebootDeviceCommand();                  Thread.sleep(3000);
		devieceon.SendOnCommandMessage("Rebooy device by QA");   Thread.sleep(3000);
		devieceon.ClickOnSubmitButton();   Thread.sleep(3000);
		
		String SuccessCommandToast = devieceon.CommandSentSuccessToast();
		System.out.println("Toast Message Command: " + SuccessCommandToast);
		soft.assertEquals(SuccessCommandToast, "Command enforced successfully. It will be reflected on device[s] within 24 hrs.", 
				"Reboot command not sent to device");
		                          
	}
	
	@Test(priority=43)
	public void To_verify_application_allow_to_send_wipe_data_command_to_device_via_action() throws InterruptedException, IOException {
		TESTID="TEST-TC-43";
		driver.navigate().back();     Thread.sleep(3000);
		devieceon.SearchIMEI("818181002200204");
		devieceon.ClickOnSearchButton();      Thread.sleep(2000);
		devieceon.ClickOnAction();            Thread.sleep(2000);
		devieceon.ClickOnWipeDataCommand();                      Thread.sleep(3000);
		devieceon.SendOnCommandMessage("Wipe data by QA");       Thread.sleep(3000);
		devieceon.ClickOnSubmitButton();                         Thread.sleep(3000);
		
		String SuccessCommandToast = devieceon.CommandSentSuccessToast();
		System.out.println("Toast Message Command: " + SuccessCommandToast);
		soft.assertEquals(SuccessCommandToast, "Command enforced successfully. It will be reflected on device[s] within 24 hrs.", 
				"Wipe Data command not sent to device");
		                           
	}
	
	@Test(priority=44)
	public void To_verify_application_allow_to_send_lock_command_to_device_via_action() throws InterruptedException, IOException {
		TESTID="TEST-TC-44";
		driver.navigate().back();     Thread.sleep(3000);
		devieceon.SearchIMEI("818181002200204");
		devieceon.ClickOnSearchButton();      Thread.sleep(2000);
		devieceon.ClickOnAction();            Thread.sleep(2000);
		devieceon.ClickOnLockDeviceCommand();                    Thread.sleep(3000);
		devieceon.SendOnCommandMessage("Lock by QA");            Thread.sleep(3000);
		devieceon.ClickOnSubmitButton();                         Thread.sleep(6000);
		                          
	}
	
	@Test(priority=45)
	public void To_verify_application_allow_to_send_Unlock_command_to_device_via_action() throws InterruptedException, IOException {
		TESTID="TEST-TC-45";
		driver.navigate().back();     Thread.sleep(3000);
		devieceon.SearchIMEI("818181002200204");
		devieceon.ClickOnSearchButton();      Thread.sleep(2000);
		devieceon.ClickOnAction();            Thread.sleep(2000);
		devieceon.ClickOnUnockDeviceCommand();                   Thread.sleep(3000);
		devieceon.SendOnCommandMessage("Unock by QA");            Thread.sleep(3000);
		devieceon.ClickOnSubmitButton();                         Thread.sleep(3000);
		
		String SuccessCommandToast = devieceon.CommandSentSuccessToast();
		System.out.println("Toast Message Command: " + SuccessCommandToast);
		soft.assertEquals(SuccessCommandToast, "Command enforced successfully. It will be reflected on device[s] within 24 hrs.", 
				"Unlock command not sent to device");
		                          
	}
	
	@Test(priority=46)
	public void To_verify_application_allow_to_click_on_view_command_status_via_action() throws InterruptedException, IOException {
		TESTID="TEST-TC-46";
		driver.navigate().back();     Thread.sleep(3000);
		devieceon.SearchIMEI("818181002200204");
		devieceon.ClickOnSearchButton();      Thread.sleep(2000);
		devieceon.ClickOnAction();            Thread.sleep(2000);
		devieceon.ClickOnViewCommandStatus();              Thread.sleep(3000);
		
	}
	
	@Test(priority=47)
	public void To_verify_on_view_command_status_page_application_allow_to_click_on_close_button() throws InterruptedException, IOException {
		TESTID="TEST-TC-47";
		devieceon.ClickOnViewCommandStatusClosebutton();
		Thread.sleep(3000);
	}
	
	@Test(priority=48)
	public void To_verify_is_application_allow_to_click_on_command_history_tab() throws InterruptedException, IOException {
		TESTID="TEST-TC-48";
		driver.navigate().back();     Thread.sleep(2000);
		devieceon.ClickOnCommandHistoryTab(); Thread.sleep(2000);
		
		String CommandHistoryURL =driver.getCurrentUrl();
		System.out.println("Command History Page URL: " + CommandHistoryURL);
		soft.assertEquals(CommandHistoryURL, "https://jioudmentsit.jio.com/#/command-history", "Command History tab did not get clicked.");
	}
	
	@Test(priority=49)
	public void To_verify_after_search_imei_then_command_history_show_for_specific_device() throws InterruptedException, IOException {
		TESTID="TEST-TC-49";
		driver.navigate().back();                              Thread.sleep(2000);
		devieceon.SearchIMEICommandHistory("818181002200204"); Thread.sleep(2000);
		devieceon.ClickOnSearchButtonHistorypage();            Thread.sleep(2000);
		
	}
	
	@Test(priority=50)
	public void To_Verify_application_allow_to_click_on_broadcast_message_tab() throws InterruptedException, IOException {
		TESTID="TEST-TC-50";
		driver.navigate().refresh();    Thread.sleep(3000);
		broadcast.ClickOnBroadcastMessagetab();
		
		String BroadcastMessageURL =driver.getCurrentUrl();
		System.out.println("Broadcast Message Page URL: " + BroadcastMessageURL);
		soft.assertEquals(BroadcastMessageURL, "https://jioudmentsit.jio.com/#/broadcast-message", "Broadcast Message tab did not get clicked.");
		

	}
	@Test(priority=51)
	public void To_verify_application_allow_to_create_broadcast_message() throws InterruptedException, IOException {
		TESTID="TEST-TC-51";
		driver.navigate().back();            Thread.sleep(3000);
		broadcast.ClickOnComposeMessageButton();
		broadcast.SendOnMessageTextfield("InfoTest1");
		broadcast.ClickOnPriorityselect();    Thread.sleep(3000);
		broadcast.SelectMIDPriority();        Thread.sleep(3000);
		broadcast.ClickOnSubmitButton();
		
		String BroadcastmessageToast = broadcast.BroadcastMessageSuccessToast();
		System.out.println("Broadcast message create Toast Message : " + BroadcastmessageToast);
		soft.assertEquals(BroadcastmessageToast, "Broadcast message request is accepted successfully, device[s] will receive this message within 24 hrs.", 
				"Broadcast message did not create successfully");		
		}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshot(driver, TESTID);
		}
		System.out.println("After Method-6");
	}
	
	@AfterClass
	public void clearObject() {
		System.out.println("After class-6");
		login=null;
	}
		
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test-6");
		driver.quit();
		driver=null;
		System.gc();
	}

}


	
	


