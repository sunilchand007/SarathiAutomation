package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class LLTestAcknowledgementPage extends BasePage {
	WebDriver driver;
	
	boolean stepstatus;
	
	public LLTestAcknowledgementPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@value='NEXT']")
	WebElement Next;
//	LLTestAppointmentProvisionalSlip
	public void Clickon_NextinAcknowledgementPage() {
		stepstatus = clickElement(Next);
		reportEvent(stepstatus, "Able to click Next", "Unable to  click Next", driver, true);
	}
	
	
	
	
	
}
