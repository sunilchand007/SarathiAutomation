package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class LLTestAppointmentDetailsPage extends BasePage {
	WebDriver driver;
	
	boolean stepstatus;
	
	public LLTestAppointmentDetailsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	LLTestAppointmentDetails
	@FindBy(how = How.XPATH, using = "//input[@id='dispappldetform_PROCEEDTOBOOK']")
	WebElement ProceedtoBookSlot;
	
	public void Clickon_ProceedtoBookSlot_Button() {
			stepstatus = clickElement(ProceedtoBookSlot);
			reportEvent(stepstatus, "Able to click ProceedtoBookSlot button", "Unable to click ProceedtoBookSlot button",
					driver, true);

		}
	
}
