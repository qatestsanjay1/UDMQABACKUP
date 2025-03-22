package PagePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Variable Declare
	
	@FindBy (xpath="//button[text()='DISAGREE']")
	private WebElement DisagreeButton;
	
	@FindBy (xpath="//div[text()='Please Agree to proceed.']")
	private WebElement AgreeToast;
	
	@FindBy (xpath="//a[@class='btn btn-link']")
	private WebElement PrivacyPolicyandTermConditionlink;
	
	@FindBy (xpath="//button[text()='AGREE']")
	private WebElement AgreeButton;
	
	@FindBy (xpath="//div[text()='Username/ Password is required']")
	private WebElement Usernamepassrequired;
	
	@FindBy (xpath="//a[text()='Forgot Password?']")
	private WebElement ForgotPassword;
	
	@FindBy (xpath="//input[@formcontrolname='username']")
	private WebElement ForgotPassUsername;
	
	@FindBy (xpath="//button[@class='btn btn-link bi bi-arrow-left-square-fill']")
	private WebElement BackToLogin;
	
	@FindBy (xpath="//input[@placeholder='Username']")
	private WebElement UserName;
	
	@FindBy (xpath="//input[@placeholder='Password']")
	private WebElement Password;
	
	@FindBy (xpath="//a[@class='link float-right mt-1 small-font pointer']")
	private WebElement SendOTP;
	
	@FindBy (xpath="//div[text()='OTP sent successfully']")
	private WebElement OTPToast;
	
	@FindBy (xpath="//button[text()='Login']")
	private WebElement LoginButton;
	
	@FindBy (xpath="//title[text()='Secure Shield Management Console']")
	private WebElement LoginPageTitle;
	
	@FindBy (xpath="//button[text()=' Reset ']")
	private WebElement ResetButton;
	
	
	//Variable Initialization
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;  
	}
	
	// Variable Utilize
	
	public void ClickOnDisagreeButton () {
		DisagreeButton.click();
	}
		
	public void ClickOnAgreeButton () {
		AgreeButton.click();
	}
	
	public void ClickOnTermsandConditionLink () {
		PrivacyPolicyandTermConditionlink.click();
	}
	public void ClickOnForgotPassword () {
		ForgotPassword.click();
	}
	
	public void SendOnForgotPassUsername (String ForUSERNAME) {
		ForgotPassUsername.click();
		ForgotPassUsername.sendKeys(ForUSERNAME);
     }
	public void ClickOnBackToLogin () {
		BackToLogin.click();
	}
	
	public void SendOnUsername (String USERNAME) {
		UserName.click();
		UserName.sendKeys(USERNAME);
     }
	
	public void SendOnPassword (String PASSWORD) {
		Password.click();
		Password.sendKeys(PASSWORD);
     }
	public void ClickOnSendOTP () {
		SendOTP.click();
     }
	
	public void ClickOnLoginButton () {
		LoginButton.click();
		
     }
	
	public void ClickOnResetButton () {
		ResetButton.click();
		
     }
	public String TitleOfLoginPage () {
		String title=LoginPageTitle.getText();
		return title;
	}
	
	public String AgreeToast () {
		String AgreeToast1=AgreeToast.getText();
		return AgreeToast1;
	}
	
	public String UsernamePasswordRequiredTOAST () {
		String 	UPRequireToast=Usernamepassrequired.getText();
		return UPRequireToast;
	}
	public String OTPTOAST () {
		String OTPToast1=OTPToast.getText();
		return OTPToast1;
	}
	
	
	
	
	
	
	
	
	
	
	
}