package BrowserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver OpenChromeBrowser() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
		
	public static WebDriver OpenFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Automation\\geckodriver-v0.35.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
		

}
