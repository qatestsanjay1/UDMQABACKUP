package TestClass;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

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
import PagePOM.AddUser;
import PagePOM.ChangePassword;
import PagePOM.DeviceOnboard;
import PagePOM.LoginPage;
import PagePOM.UpdateAccount;
import Utils.Utility;

public class Login_and_Add_DeleteUserTest extends Base {
	
	WebDriver driver;
	LoginPage login;
	DeviceOnboard devieceon;
	AddUser adduser;
	UpdateAccount updateaccount;
	ChangePassword changepassword;
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
        adduser=new AddUser(driver);
        updateaccount=new UpdateAccount(driver);
        changepassword=new ChangePassword(driver);
		
	}
	
	@BeforeMethod
	public void Open_the_Application() throws InterruptedException {
		System.out.println("Before Method-3");
		driver.get("https://jioudmentsit.jio.com/#/");
		Thread.sleep(8000);
		
        soft=new SoftAssert();
       
	}
	@Test(priority=1)
	public void To_verify_application_allow_to_click_on_Disagree_button() throws InterruptedException, IOException {
		TESTID="TEST-TC-01";
		login.ClickOnDisagreeButton();    Thread.sleep(4000);
		
		String AgreeToast1 = login.AgreeToast();
		System.out.println("Toast Message: " + AgreeToast1);
		soft.assertEquals(AgreeToast1, "Please Agree to proceed.", "Toast message mismatch");

	}
	@Test(priority=2)
	public void To_verify_application_allow_to_click_on_Privacy_Policy_Terms_and_Condition_link() throws InterruptedException, IOException {
		TESTID="TEST-TC-02";
		login.ClickOnAgreeButton();            Thread.sleep(3000);
		login.ClickOnTermsandConditionLink();  Thread.sleep(2000);
		
		// Get all window handles
	    Set<String> windowHandles = driver.getWindowHandles();
	    Iterator<String> iterator = windowHandles.iterator();

	    String mainWindow = iterator.next(); // Main window handle
	    String newTab = iterator.next();     // New tab handle

	    // Switch to the new tab
	    driver.switchTo().window(newTab);
	    
	    // Close the new tab and switch back to the main window
	    driver.close();
	    driver.switchTo().window(mainWindow);
	}
		
		
	@Test(priority=3)
	public void To_Verify_On_Acknowledgement_page_application_allow_to_click_on_Agree_button() throws InterruptedException, IOException {
		TESTID="TEST-TC-03";
		driver.navigate().refresh();      Thread.sleep(3000);
		login.ClickOnAgreeButton();       Thread.sleep(3000);
		String actualTitle=driver.getTitle();
		String expectedTitle="UDM";
		soft.assertEquals(actualTitle, expectedTitle,"Title Is Wrong");
		soft.assertAll(); 
	
	}
	@Test(priority=4)
	public void To_verify_application_allow_to_login_without_passing_username_password_data_in_input_fields() throws InterruptedException, IOException {
		TESTID="TEST-TC-04";
		login.ClickOnSendOTP();      Thread.sleep(2000);
		String ReqToast = login.UsernamePasswordRequiredTOAST();
		System.out.println("Toast Message: " + ReqToast);
		soft.assertEquals(ReqToast, "Username/ Password is required", "Toast message mismatch");

	}
	@Test(priority=5)
	public void To_verify_application_allow_to_click_on_Forgot_Password_link() throws InterruptedException, IOException {
		TESTID="TEST-TC-05";
		login.ClickOnForgotPassword(); Thread.sleep(4000);
		
		String ForgotPasswordurl =driver.getCurrentUrl();
		System.out.println("Forgot Password URL: " + ForgotPasswordurl);
		soft.assertEquals(ForgotPasswordurl, "https://jioudmentsit.jio.com/#/forgot-password", "Forgot Password link did not get clicked.");

	}
	@Test(priority=6)
	public void To_verify_application_allow_to_navigate_on_login_page() throws InterruptedException, IOException {
		TESTID="TEST-TC-06";
		Thread.sleep(3000);
		driver.navigate().back();       Thread.sleep(4000);

	}
	@Test(priority=7)
	public void To_verify_application_allow_to_pass_data_in_username_input_field() throws InterruptedException, IOException {
		TESTID="TEST-TC-07";
		driver.navigate().refresh();    Thread.sleep(3000);
		login.ClickOnAgreeButton();     Thread.sleep(3000);
		login.SendOnUsername("sanjay10");
		Thread.sleep(2000);

	}
	
	@Test(priority=8)
	public void To_verify_application_allow_to_pass_data_in_Password_input_field() throws InterruptedException, IOException {
		TESTID="TEST-TC-08";
		login.SendOnPassword("Pass@123");
		Thread.sleep(2000);

	}
	@Test(priority=9)
	public void To_verify_application_allow_to_click_on_send_otp() throws InterruptedException, IOException {
		TESTID="TEST-TC-09";
		Thread.sleep(2000);
		login.ClickOnSendOTP(); Thread.sleep(2000);
		String otpToast = login.OTPTOAST();
		System.out.println("Toast Message: " + otpToast);
		soft.assertEquals(otpToast, "OTP sent successfully", "Toast message mismatch");
		
		
	}
	@Test(priority=10)
	public void To_verify_after_passing_OTP_application_allow_to_click_on_login_button() throws InterruptedException, IOException {
		TESTID="TEST-TC-10";
		Thread.sleep(10000);
		login.ClickOnLoginButton();
		Thread.sleep(8000);
	}
	@Test(priority=11)
	public void To_verify_application_allow_to_click_on_settings_and_then_User_management_tab() throws InterruptedException, IOException {
		TESTID="TEST-TC-11";
		Thread.sleep(3000);
		driver.navigate().refresh();     Thread.sleep(3000);
		adduser.ClickOnSettings();       Thread.sleep(2000);
		adduser.ClickOnUserManagement(); Thread.sleep(8000);
		
	}
	@Test(priority=12)
	public void To_verify_application_allow_to_click_on_add_user_button() throws InterruptedException, IOException {
		TESTID="TEST-TC-12";
		driver.navigate().back();  Thread.sleep(2000);
		adduser.ClickOnAddUserbutton(); Thread.sleep(3000);
		
	}
	@Test(priority=13)
	public void To_verify_application_allow_to_create_New_user_after_passing_valid_data_in_all_input_fields() throws InterruptedException, IOException {
		TESTID="TEST-TC-13";
		adduser.SendOnFirstname("QASanjay");
		adduser.SendOnLastname("tests");
		adduser.SendOnUsername("QATSanjay");
		adduser.SendOnEmail("sanjaytest123");
		adduser.SendOnPassword("Pass@123");
		adduser.SendOnConfirmPassword("Pass@123");
		adduser.SendOnPhoneno("9828283828"); Thread.sleep(2000);
		adduser.ClickOnSavebutton();        Thread.sleep(5000);
		
	    String SuccessToastUser = adduser.AddUserToast();
		System.out.println("Add user toast: " + SuccessToastUser);		
		soft.assertEquals(SuccessToastUser, "User Added Successfully", "User not added");

	}
	@Test(priority=14)
	public void To_verify_created_user_showing_in_user_list() throws InterruptedException, IOException {
		TESTID="TEST-TC-14";
		driver.navigate().refresh();      Thread.sleep(4000);
		adduser.ClickOnSettings();        Thread.sleep(2000);
		adduser.ClickOnUserManagement();  Thread.sleep(2000);
		
		String AdduserToast = adduser.AddNewUser();
		System.out.println("Add UserName: " + AdduserToast);
		soft.assertEquals(AdduserToast, "QATSanjay", "User Not created");
	   
	}
	
	@Test(priority=15)
	public void To_verify_search_functionality_if_we_pass_invalid_username_in_search_bar() throws InterruptedException, IOException {
		TESTID="TEST-TC-15";
		driver.navigate().refresh();      Thread.sleep(4000);
		adduser.ClickOnSettings();        Thread.sleep(2000);
		adduser.ClickOnUserManagement();  Thread.sleep(2000);
		adduser.SearchUser("TESTERUSER");
		adduser.ClickOnSearchButton();
		
		String NodataToast = adduser.NoDataToast();
		System.out.println("Toast Message: " + NodataToast);
		soft.assertEquals(NodataToast, "No data found", "No data toast not showing");
		
	}
	
	@Test(priority=16)
	public void To_verify_search_functionality_if_we_pass_valid_username_in_search_bar() throws InterruptedException, IOException {
		TESTID="TEST-TC-16";
		driver.navigate().back();       Thread.sleep(2000);
		adduser.SearchUser("QATSanjay");
		adduser.ClickOnSearchButton();  Thread.sleep(3000);
	}
	
	@Test(priority=17)
	public void To_verify_application_showing_Unlock_user_in_account_status() throws InterruptedException, IOException {
		TESTID="TEST-TC-17";
		driver.navigate().back();       Thread.sleep(2000);
		adduser.SearchUser("QATSanjay");
		adduser.ClickOnSearchButton();  Thread.sleep(3000);
		adduser.ClickOnLockUser();      Thread.sleep(4000);
		
		
	}
		
	@Test(priority=18)
	public void To_verify_application_allow_to_delete_user() throws InterruptedException, IOException {
		TESTID="TEST-TC-18";
		driver.navigate().back();  Thread.sleep(2000);
		adduser.SearchUser("QATSanjay");
		adduser.ClickOnSearchButton();  Thread.sleep(3000);
		adduser.ClickOnDeleteUser();    Thread.sleep(2000);
		adduser.ClickOnDeleteYesButton();Thread.sleep(2000);
		
	}
	
	@Test(priority=19)
	public void To_verify_application_allow_to_click_on_update_account_tab() throws InterruptedException, IOException {
		TESTID="TEST-TC-19";
		driver.navigate().refresh();    Thread.sleep(4000);
		updateaccount.ClickOnSettings();     Thread.sleep(2000);
		updateaccount.ClickOnUpdateAccount();Thread.sleep(3000);
		
		String Updateaccurl =driver.getCurrentUrl();
		System.out.println("Update account URL: " + Updateaccurl);
		soft.assertEquals(Updateaccurl, "https://jioudmentsit.jio.com/#/update-account", "Update account tab did not get clicked.");
		
			
	}
	
	@Test(priority=20)
	public void To_verify_application_allow_to_click_on_edit_button() throws InterruptedException, IOException {
		TESTID="TEST-TC-20";
		driver.navigate().back();  Thread.sleep(2000);
		updateaccount.ClickOnEditbutton();  
		Thread.sleep(2000);
		
	}
	
	@Test(priority=21)
	public void To_verify_whether_application_allows_editing_data_in_customer_care_field_and_updates_it_successfully_or_not() throws InterruptedException, IOException {
		TESTID="TEST-TC-21";
		driver.navigate().back();  Thread.sleep(2000);
		updateaccount.ClickOnEditbutton(); Thread.sleep(2000);
		updateaccount.SendOnCustomareCareContactfield("9838389494");
        updateaccount.ClickOnSubmitButton();Thread.sleep(4000);
		
		String SuccessToast = updateaccount.SuccessToast();
		System.out.println("Toast Message: " + SuccessToast);
		soft.assertEquals(SuccessToast, "Success", "Account not updated");
		
	}
	
	@Test(priority=22)
	public void To_verify_whether_application_allows_editing_data_in_the_logo_input_field_and_updates_it_successfully_or_not() throws InterruptedException, IOException {
		TESTID="TEST-TC-22";
		driver.navigate().back();  Thread.sleep(3000);
		updateaccount.ClickOnEditbutton(); Thread.sleep(2000);
		updateaccount.SendOnlogofield("https://icicitest.com");
		updateaccount.ClickOnSubmitButton();Thread.sleep(2000);
		
		String SuccessToast = updateaccount.SuccessToast();
		System.out.println("Toast Message: " + SuccessToast);
		soft.assertEquals(SuccessToast, "Success", "Account not updated");
		
	}
	
	@Test(priority=23)
	public void To_verify_application_allow_to_click_on_change_password_tab() throws InterruptedException, IOException {
		TESTID="TEST-TC-23";
		driver.navigate().refresh();            Thread.sleep(3000);
		changepassword.ClickOnSettings();       Thread.sleep(2000);
		changepassword.ClickOnChangePassword(); Thread.sleep(2000);
		
		String changepassurl =driver.getCurrentUrl();
		System.out.println("Change Password URL: " + changepassurl);
		soft.assertEquals(changepassurl, "https://jioudmentsit.jio.com/#/change-password", "Change Password tab did not get clicked.");
	}
	
	@Test(priority=24)
	public void To_verify_application_allow_to_click_and_pass_data_in_current_password_input_field() throws InterruptedException, IOException {
		TESTID="TEST-TC-24";
		driver.navigate().back();    Thread.sleep(3000);
		changepassword.SendOnCurrentPassword("Pass@1234567");
	
	}
	
	@Test(priority=25)
	public void To_verify_application_allow_to_click_and_pass_data_in_new_password_input_field() throws InterruptedException, IOException {
		TESTID="TEST-TC-25";
		driver.navigate().back();    Thread.sleep(3000);
		changepassword.SendOnCurrentPassword("Pass@123");
		changepassword.SendOnNewPassword("Pass@123");
	}
	
	
	@Test(priority=26)
	public void To_verify_change_password_functionality_if_we_pass_invalid_current_password_while_changing_password() throws InterruptedException, IOException {
		TESTID="TEST-TC-26";
		driver.navigate().back();    Thread.sleep(3000);
		changepassword.SendOnCurrentPassword("Pass@1234567");
		changepassword.SendOnNewPassword("Pass@12345");
		changepassword.SendOnConfirmPassword("Pass@12345");
		changepassword.ClickOnSubmitbutton(); Thread.sleep(2000);
		
		String InvalidPassToast = changepassword.InvalidpasswordToast();
		System.out.println("Toast Message: " + InvalidPassToast);
		soft.assertEquals(InvalidPassToast, "Invalid current password. Please provide a valid current password", 
				"Invalid Password Toast not showed");
		Thread.sleep(3000);
		}
	
	@Test(priority=27)
	public void To_verify_change_password_functionality_if_we_pass_valid_data_in_all_fields() throws InterruptedException, IOException {
		TESTID="TEST-TC-27";
		driver.navigate().back();    Thread.sleep(3000);
		changepassword.SendOnCurrentPassword("Pass@123");
		changepassword.SendOnNewPassword("Pass@12345");
		changepassword.SendOnConfirmPassword("Pass@12345");
		changepassword.ClickOnSubmitbutton(); Thread.sleep(2000);
		
		String SuccessPassToast = changepassword.SuccessToast();
		System.out.println("Toast Message: " + SuccessPassToast);
		soft.assertEquals(SuccessPassToast, "Success", "Password not changed");
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


	
	


