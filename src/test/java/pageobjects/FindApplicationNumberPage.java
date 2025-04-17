package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworkLibrary.BasePage;

public class FindApplicationNumberPage extends BasePage{

	
	WebDriver driver;

	boolean stepstatus;


	@FindBy(how = How.XPATH, using = "//a[text()='Find Application Number']")
	WebElement findappNo;

	public void Clickon_Find_Application_Number() {
		stepstatus =clickElement(findappNo);
		reportEvent(stepstatus, "Able to click findappNo", "Unable to click findappNo", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='state_name']")
	WebElement SelectState;

	public void Select_State(String Option) {
		stepstatus =setValueInSelectBox(SelectState, Option);
		reportEvent(stepstatus, "Able to  SelectState", "Unable to  SelectState", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='rto_name']")
	WebElement SelectRTO;

	public void Select_RTO(String Option) {
		stepstatus =setValueInSelectBox(SelectRTO, Option);
		reportEvent(stepstatus, "Able to  SelectRTO", "Unable to  SelectRTO", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='applFname']")
	WebElement FirstName;

	public void Enter_FirstName(String value) {
		stepstatus =setText(FirstName, value);
		reportEvent(stepstatus, "Able to Enter FirstName ", "Unable to Enter FirstName", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='applLname']")
	WebElement LastName;

	public void Enter_LastName(String value) {
		stepstatus =setText(LastName, value);
		reportEvent(stepstatus, "Able to Enter LastName ", "Unable to Enter LastName", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='dob']")
	WebElement DateOfBirth;

	public void Enter_DateOfBirth(String value) {
		stepstatus =setText(DateOfBirth, value);
		reportEvent(stepstatus, "Able to Enter LastName ", "Unable to Enter LastName", driver, true);
	}

	@FindBy(how = How.XPATH, using = "(//input[@value='submit'])[1]")
	WebElement Sub;

	public void Clickon_Submit_button() {
		stepstatus =clickElement(Sub);
		reportEvent(stepstatus, "Able to click Submit", "Unable to click Submit", driver, true);
	}

}
