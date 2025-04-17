package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class SBHIntroPage extends BasePage {

	
	WebDriver driver;
	
	boolean stepstatus;
	
	public SBHIntroPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//img[@alt='Continue to Login']")
	WebElement ContinuetoLogin;

	public void Clickon_ContinuetoLogin_Button() {
		stepstatus = clickElement(ContinuetoLogin);
		reportEvent(stepstatus, "Able to click ContinuetoLogin button", "Unable to click ContinuetoLogin button",
				driver, true);
	}
	
	
}
