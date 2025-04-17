package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworkLibrary.BasePage;

public class DLsearchPage extends BasePage{
	WebDriver driver;

	boolean stepstatus;

	@FindBy(how = How.XPATH, using = "//a[text()='DL Search']")
	WebElement dlsearch;

	public void Clickon_DLSearch() {
		stepstatus = clickElement(dlsearch);
		reportEvent(stepstatus, "Able to click dlsearch", "Unable to click dlsearch", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='licNo']")
	WebElement dllicno;

	public void Enter_DL_Licno(String value) {
		stepstatus = setText(dllicno, value);
		reportEvent(stepstatus, "Able to Enter DL Number ", "Unable to Enter DL Number", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	WebElement name;

	public void Enter_Licence_Holder_Name(String value) {
		stepstatus = setText(name, value);
		reportEvent(stepstatus, "Able to Enter Licence_Holder_Name ", "Unable to Enter Licence_Holder_Name", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='dob']")
	WebElement dob_dl;

	public void Enter_DateofBirth(String value) {
		stepstatus = setText(dob_dl, value);
		reportEvent(stepstatus, "Able to Enter DOB ", "Unable to Enter DOB", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='otpmobileno']")
	WebElement MobileOTP;

	public void Enter_MobileNo(String value) {
		stepstatus = setText(MobileOTP, value);
		reportEvent(stepstatus, "Able to Enter Mobile No ", "Unable to Enter Mobile No", driver, true);
	}
}
