package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class POM {

    WebDriver driver;

    By userName = By.id("okta-signin-username");
    By password = By.id("okta-signin-password");
    By titleText =By.className("barone");
    By login = By.id("okta-signin-submit");
    
    
    public POM(WebDriver driver){
        this.driver = driver;
    }

    //Set user name in textbox
    public void setUserName(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }

    //Set password in password textbox
    public void setPassword(String strPassword){
         driver.findElement(password).sendKeys(strPassword);
    } 

    //Click on login button
    public void clickLogin(){
            driver.findElement(login).click();
    }

    //Get the title of Login Page
    public String getLoginTitle(){
     return    driver.findElement(titleText).getText();
    }

    public void loginAction(String strUserName,String strPasword){
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();        
    }
    
    public boolean assertSignInError() {
    	WebElement errorPopup = driver.findElement(By.xpath("//p[contains(text(),'Sign in failed!')]"));
    	return errorPopup.isDisplayed();
    }
    
    public static void setProperties() {
    	String os = System.getProperty("os.name").toLowerCase();
		System.out.println("You're running this on " + os);
		if (os.contains("mac")) {
			//Gecko (Mac)
			System.setProperty("webdriver.gecko.driver", "/Users/josh/Documents/KMS/sel/Selenium/geckodriver");
		} else {
			//Gecko (Windows)
			System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\xlive\\Documents\\1KMS\\sel\\Selenium\\geckodriver.exe");
		}
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
    }

}