package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class LLEdit_CorrectionOfDobPage extends BasePage{

	WebDriver driver;
	boolean stepstatus;
	
	public LLEdit_CorrectionOfDobPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='corrDob']")
	WebElement selectChangeOfDob;
	public boolean clickOnCorrectionOfDobCheckbox() {
		wait(1);
		return clickElement(selectChangeOfDob);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='dob']")
	WebElement clickDob;
	public boolean clickOnDob() {
		wait(1);
		return clickElement(clickDob);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@class = 'ui-datepicker-month']")
	WebElement selectMonthWE;
	@FindBy(how = How.XPATH, using = "//select[@class = 'ui-datepicker-year']")
	WebElement selectYearWE;
	@FindBy(how = How.XPATH, using = "//a[text() = '1']")
	WebElement clickDay;
	
	public void selectDate(String selectedMonth,String selectedYear) {
//		scrooldown(driver);
		wait(1);
		stepstatus = setValueInSelectBox(selectMonthWE, selectedMonth);
		reportEvent(stepstatus, "Able to select Month", "Unable to select Month", driver, true);
		stepstatus = setValueInSelectBox(selectYearWE, selectedYear);
		reportEvent(stepstatus, "Able to select Year", "Unable to select Year", driver, true);
		wait(1);
	    clickElement(clickDay);
	    reportEvent(stepstatus, "Able to Click Day", "Unable to Click Day", driver, true);
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='dob']")
	WebElement dobWE;
	public void dob(String dateOfBirth) {
		stepstatus = setText(dobWE, dateOfBirth);
		reportEvent(stepstatus, "Able to Enter Date Of Birth", "Unable to Enter Date Of Birth", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='leaEditReason']")
	WebElement remarksAdded;
	public void remarksAddedForSubmission(String remarks) {
		stepstatus = setText(remarksAdded, remarks);
		reportEvent(stepstatus, "Able to Enter Remarks", "Unable to Enter Remarks", driver, true);
	}
}
