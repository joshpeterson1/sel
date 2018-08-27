package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import test.POM;

public class SRLog {

	public static void main(String[] args) {
		POM.setProperties();
		WebDriver driver;
	    POM objLogin;
	    
	    String url = "https://www.smilereminder.com/sr/login.jsp";
		String user = "peteboys3@comcast.net";
		String pass = "wrong123";

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(url);
        
        //Create Login Page object
        objLogin = new POM(driver);

        //attempt login
        objLogin.loginAction(user, pass);
    
        boolean isError = objLogin.assertSignInError();
        System.out.println("Login Error is displayed: " + isError);
    
        driver.close();

    }
}