package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class ApplicationFeePaymentSuccessAckPage extends BasePage {

	WebDriver driver;

	boolean stepstatus;
	
	public ApplicationFeePaymentSuccessAckPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@value='Next']")
	WebElement Nextbutton;
	
	public void Clickon_NextbuttoninApplicationFeePaymentSuccessAck() {
		stepstatus = clickElement(Nextbutton);
		reportEvent(stepstatus, "Able to click Next button", "Unable to click Next button", driver, true);
	}

	
	
	
	
}


