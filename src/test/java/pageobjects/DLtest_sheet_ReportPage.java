package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworkLibrary.BasePage;

public class DLtest_sheet_ReportPage extends BasePage{
	WebDriver driver;
	boolean stepstatus;
	

	@FindBy(how = How.XPATH, using = "//input[@name='applno']")
	WebElement DrivingLicenceTestSheetapplicationno;

	public void Enter_DrivingLicenceTestSheet_ApplicationNo(String data) {
		stepstatus =SetTextAndTAB(DrivingLicenceTestSheetapplicationno, data);
		reportEvent(stepstatus, "Able to Enter DrivingLicenceTestSheetapplicationno  ", "Unable to Enter DrivingLicenceTestSheetapplicationno", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='dob']")
	WebElement DrivingLicenceTestSheetdob;

	public void Enter_DrivingLicenceTestSheetdob(String data) {
		stepstatus =SetTextAndTAB(DrivingLicenceTestSheetdob, data);
		reportEvent(stepstatus, "Able to Enter DrivingLicenceTestSheetdob  ", "Unable to Enter DrivingLicenceTestSheetdob", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement DrivingLicenceTestSheet_Submit;

	public void Clickon_DrivingLicenceTestSheet_Submit() {
		stepstatus =clickElement(DrivingLicenceTestSheet_Submit);
		reportEvent(stepstatus, "Able to click on DrivingLicenceTestSheet_Submit", "Unable to click on DrivingLicenceTestSheet_Submit", driver, true);
	}
}
