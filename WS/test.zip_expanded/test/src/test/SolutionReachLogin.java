package test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
public class SolutionReachLogin {
	public static void main(String[] args) throws InterruptedException {
	//Script to login to SolutionReach incorrectly and validate incorrect login display
	//Config------------------
		//Determine OS
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("You're running this on " + os);
		if (os.contains("mac")) {
			//Gecko (Mac)
			System.setProperty("webdriver.gecko.driver", "/Users/josh/Documents/KMS/Selenium/geckodriver");
		} else {
			//Gecko (Windows)
			System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\xlive\\Documents\\1KMS\\Selenium\\geckodriver.exe");
		}
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
	//End Config----------------
		
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		//Variables
		String url = "https://login.solutionreach.com";
		String user = "peteboys3@comcast.net";
		String pass = "wrong123";
		
		
		//  Wait For Page To Load
		// Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception 
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// Navigate to URL
		driver.get(url);
		System.out.println("Getting" + url);
		
		// Maximize the window.
		driver.manage().window().maximize();
		
		// Enter UserName
		driver.findElement(By.id("okta-signin-username")).sendKeys(user);
		System.out.println("Entered User: " + user);
		
		// Enter Password
		driver.findElement(By.id("okta-signin-password")).sendKeys(pass);
		System.out.println("Entered Pwd: " + pass);
		
		// Wait adjustment For Page To Load
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Click on 'Sign In' button
		driver.findElement(By.id("okta-signin-submit")).click();
		//Find Incorrect Login <p>.
		//OLD: driver.findElement(By.xpath("//span/p[contains(text(),'Sign in failed!')]")).click(); //The password you've entered is incorrect.
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement errorPopup = driver.findElement(By.xpath("//p[contains(text(),'Sign in failed!')]"));
		boolean isPresent = errorPopup.isDisplayed();
		System.out.println("Login Failed: " + isPresent);
		if (isPresent == true) {
			driver.quit();
		} else {
			System.out.println("keep tryin / are u sure credentials are incorrect?");
		}
		//Boolean isPresent = errorPopup.getSize() > 0;
		
		// Click on the image icon present in the top right navigation Bar
		//driver.findElement(By.xpath("//div[@class='gb_1 gb_3a gb_nc gb_e']/div/a")).click();
		//Click on 'Logout' Button
		//driver.findElement(By.xpath("//*[@id='gb_71']")).click();
		//Close the browser.
		
	}
}