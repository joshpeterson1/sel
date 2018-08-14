package test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Login {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\xlive\\Documents\\1KMS\\Selenium\\geckodriver.exe");
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		//  Wait For Page To Load
		// Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Navigate to URL
		driver.get("https://facebook.com");
		// Maximize the window.
		driver.manage().window().maximize();
		// Enter UserName
		driver.findElement(By.id("email")).sendKeys("peteboys3@comcast.net");
		// Enter Password
		driver.findElement(By.id("pass")).sendKeys("wrong123");
		// Wait For Page To Load
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Click on 'Sign In' button
		driver.findElement(By.id("u_0_2")).click();
		//Find Incorrect Login DIV.
		driver.findElement(By.xpath("//div[contains(text(),'The password you’ve entered is incorrect. ')]")).click(); //The password you’ve entered is incorrect.
		//WebElement errorPopup = driver.findElement(By.xpath("//div[contains(text(),'The password you’ve entered is incorrect. ')]"));
		boolean isPresent = false; 
		if (isPresent = false) {
			isPresent = driver.findElements(By.xpath("//div[contains(text(),'The password you’ve entered is incorrect. ')]")).size() > 0;
		 }

		//Boolean isPresent = errorPopup.getSize() > 0;
		
		// Click on the image icon present in the top right navigational Bar
		//driver.findElement(By.xpath("//div[@class='gb_1 gb_3a gb_nc gb_e']/div/a")).click();
		//Click on 'Logout' Button
		//driver.findElement(By.xpath("//*[@id='gb_71']")).click();
		//Close the browser.
		driver.close();
	}
}