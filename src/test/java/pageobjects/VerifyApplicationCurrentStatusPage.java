package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class VerifyApplicationCurrentStatusPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;
	LoginRTO RTO;
	public VerifyApplicationCurrentStatusPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Verify_ApplicationCurrentStatus() throws IOException, InterruptedException {
		wait(1);
		
		 if (driver.getPageSource().contains("Application is under processing at RTO Level.")) {
			 System.out.println("Applicatioin is under processing at RTO Level.Please wait Logging into for RTO process");
				scrooldown(driver);
				Login();
		 }
		 }
	

	public void Login() {
		RTO = new LoginRTO(driver);
		driver.navigate().to(prop.getProperty(getdata("CASENV")));
		RTO.setUserName(getdata("UserName"));
		RTO.setpassword(getdata("Password"));
		RTO.ClickonLogin();
	}
	
	
	
	
}