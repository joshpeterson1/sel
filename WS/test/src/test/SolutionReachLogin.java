package test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
public class SolutionReachLogin {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\xlive\\Documents\\1KMS\\sel\\Selenium\\geckodriver.exe");
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		//  Wait For Page To Load
		// Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Navigate to URL
		driver.get("https://login.solutionreach.com");
		// Maximize the window.
		driver.manage().window().maximize();
		// Enter UserName
		driver.findElement(By.id("okta-signin-username")).sendKeys("peteboys3@comcast.net");
		// Enter Password
		driver.findElement(By.id("okta-signin-password")).sendKeys("wrong123");
		// Wait For Page To Load
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Click on 'Sign In' button
		driver.findElement(By.id("okta-signin-submit")).click();
		//Find Incorrect Login DIV.
		//driver.findElement(By.xpath("//span/p[contains(text(),'Sign in failed!')]")).click(); //The password you�ve entered is incorrect.
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement errorPopup = driver.findElement(By.xpath("//p[contains(text(),'Sign in failed!')]"));
		boolean isPresent = errorPopup.isDisplayed();
		System.out.println("Login Failed: " + isPresent);

		//Boolean isPresent = errorPopup.getSize() > 0;
		
		// Click on the image icon present in the top right navigational Bar
		//driver.findElement(By.xpath("//div[@class='gb_1 gb_3a gb_nc gb_e']/div/a")).click();
		//Click on 'Logout' Button
		//driver.findElement(By.xpath("//*[@id='gb_71']")).click();
		//Close the browser.
		
	}
}