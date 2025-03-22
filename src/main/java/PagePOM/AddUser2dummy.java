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
	
	@FindBy (xpath="//button[text()=' Reset ']")
	private WebElement Resetbutton;
	
	@FindBy (xpath="//input[@formcontrolname='firstName']")
	private WebElement FirstName;
	
	@FindBy (xpath="//input[@formcontrolname='lastName']")
	private WebElement LastName;
	
	@FindBy (xpath="//input[@formcontrolname='userName']")
	private WebElement UserName;
	
	@FindBy (xpath="//input[@formcontrolname='email']")
	private WebElement Email;
	
	@FindBy (xpath="//input[@formcontrolname='password']")
	private WebElement Password;
	
	@FindBy (xpath="//input[@formcontrolname='confirmPassword']")
	private WebElement Confirmpassword;
	
	@FindBy (xpath="//input[@formcontrolname='phoneNo']")
	private WebElement Phoneno;
	
	@FindBy (xpath="//button[text()='Save']")
	private WebElement SaveButton;
	
	@FindBy (xpath="//div[text()='User Added Successfully']")
	private WebElement addusertoast;
	
	@FindBy (xpath="//td[text()=' QATSanjay ']")
	private WebElement addnewuser;
	
	@FindBy (xpath="//input[@placeholder='Username/ Email/ Phone']")
	private WebElement searchuser;
	
	@FindBy (xpath="//button[text()='Search']")
	private WebElement SearchButton;
	
	@FindBy (xpath="//button[text()=' Reset ']")
	private WebElement ResetButton;
	
	@FindBy (xpath="//div[text()='No data found']")
	private WebElement Nodatatoast;
	
	@FindBy (xpath="//td//a[@class='bi bi-unlock-fill']")
	private WebElement Lockuser;
	
	@FindBy (xpath="//td//a[@class='bi bi-lock-fill']")
	private WebElement Unlockuser;
	
	@FindBy (xpath="//a[@ngbtooltip='Edit User']")
	private WebElement Editnewuser;
	
	@FindBy (xpath="//span[@ngbtooltip='Delete User']")
	private WebElement Deletenewuser;
	
	@FindBy (xpath="//button [text()='Yes']")
	private WebElement DeleteYesButton;
	
	
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
	
	public void ClickOnResetButton () {
		Resetbutton.click();
     }
	
	public void ClickOnAddUserbutton () {
		AddUserbutton.click();
		
     }
	
	public void SendOnFirstname (String FIRSTNAME) {
		FirstName.click();
		FirstName.sendKeys(FIRSTNAME);
     }
	
	public void SendOnLastname (String LASTNAME) {
		LastName.click();
		LastName.sendKeys(LASTNAME);
     }
	
	public void SendOnUsername (String USERNAME1) {
		UserName.click();
		UserName.sendKeys(USERNAME1);
     }
	
	public void SendOnEmail (String EMAIL) {
		Email.click();
		Email.sendKeys(EMAIL);
     }
	public void SendOnPassword (String PASSWORD) {
		Password.click();
		Password.sendKeys(PASSWORD);
     }
	
	public void SendOnConfirmPassword (String CONFIRMPASSWORD) {
		Confirmpassword.click();
		Confirmpassword.sendKeys(CONFIRMPASSWORD);
     }
	
	public void SendOnPhoneno (String PHONENO) {
		Phoneno.click();
		Phoneno.sendKeys(PHONENO);
     }
	
	public void ClickOnSavebutton () {
		SaveButton.click();
		
     }
	
	public void SearchUser (String SEARCHUSER) {
		searchuser.click();
		searchuser.sendKeys(SEARCHUSER);
     }
	public void ClickOnSearchButton () {
		SearchButton.click();
		
     }
	public void ClickOnResetButtonUserpage () {
		ResetButton.click();
		
     }
	
	public void ClickOnLockUser () {
		Lockuser.click();
		
     }
	public void ClickOnUnlockUser () {
		Unlockuser.click();
		
     }
	
	public void ClickOnEditUser () {
		Editnewuser.click();
		}
	public void ClickOnDeleteUser () {
		Deletenewuser.click();
	 }
	public void ClickOnDeleteYesButton () {
		DeleteYesButton.click();
		
     }
	
	public String AddUserToast () {
		String userToast1=addusertoast.getText();
		return userToast1;
	}
	
	public String AddNewUser () {
		String newuseradd=addnewuser.getText();
		return newuseradd;
	}
	
	public String NoDataToast () {
		String nodataToast1=Nodatatoast.getText();
		return nodataToast1;
	}
	
		
	
}