package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworkLibrary.BasePage;

public class IDPLicenceDetailsPage extends BasePage{

	WebDriver driver;

	boolean stepstatus;
	
	
	@FindBy(how = How.XPATH, using = "//input[@name='dlNo']")
	WebElement DLNumber_IDP;

	public void Enter_DLNumber_IDP(String data) {
		stepstatus =SetTextAndTAB(DLNumber_IDP, data);
		reportEvent(stepstatus, "Able to Enter DLNumber_IDP  ", "Unable to Enter DLNumber_IDP", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='idpNo']")
	WebElement IDP_No;

	public void Enter_IDP_No(String data) {
		stepstatus =SetTextAndTAB(IDP_No, data);
		reportEvent(stepstatus, "Able to Enter IDP_No  ", "Unable to Enter IDP_No", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='dateOfBirth']")
	WebElement IDP_DOB;

	public void Enter_IDP_DOB(String data) {
		stepstatus =SetTextAndTAB(IDP_DOB, data);
		reportEvent(stepstatus, "Able to Enter IDP_DOB  ", "Unable to Enter IDP_DOB", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement IDP_Submit;

	public void Clickon_IDP_Submit() {
		stepstatus =clickElement(IDP_Submit);
		reportEvent(stepstatus, "Able to click on IDP_Submit", "Unable to click on IDP_Submit", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@value='Print']")
	WebElement IDP_Print;

	public void Clickon_IDP_Print() {
		scrooldown(driver);
		stepstatus =clickElement(IDP_Print);
		reportEvent(stepstatus, "Able to click on IDP_Print", "Unable to click on IDP_Print", driver, true);
	}
}
