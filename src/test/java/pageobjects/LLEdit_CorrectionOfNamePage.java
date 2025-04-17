package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class LLEdit_CorrectionOfNamePage extends BasePage{

	WebDriver driver;
	boolean stepstatus;
	
	public LLEdit_CorrectionOfNamePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='corrName']")
	WebElement selectChangeOfName;
	public boolean clickOnCorrectionOfNameCheckbox() {
		wait(1);
		return clickElement(selectChangeOfName);
	}

	
	@FindBy(how = How.XPATH, using = "//*[@id='fname']")
	WebElement firstNameWE;
	public void firstName(String fName) {
		stepstatus = setText(firstNameWE, fName);
		reportEvent(stepstatus, "Able to Enter First Name", "Unable to Enter First Name", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='mname']")
	WebElement middleNameWE;
	public void middleName(String mName) {
		stepstatus = setText(middleNameWE, mName);
		reportEvent(stepstatus, "Able to Enter Middle Name", "Unable to Enter Middle Name", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='lname']")
	WebElement lastNameWE;
	public void lastName(String lName) {
		stepstatus = setText(lastNameWE, lName);
		reportEvent(stepstatus, "Able to Enter Last Name", "Unable to Enter Last Name", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='swdRel']")
	WebElement selectRelWE;
	
	public void selectRelation(String relation) {
		scrooldown(driver);
		wait(1);
		stepstatus = setValueInSelectBox(selectRelWE, relation);
		reportEvent(stepstatus, "Able to select Relation", "Unable to select Relation", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='swdFname']")
	WebElement relFNameWE;
	
	public void relFirstName(String relFName) {
		stepstatus = setText(relFNameWE, relFName);
		reportEvent(stepstatus, "Able to Enter Relation First Name", "Unable to Enter Relation First Name", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='swdMname']")
	WebElement relMNameWE;
	
	public void relMiddleName(String relMName) {
		stepstatus = setText(relMNameWE, relMName);
		reportEvent(stepstatus, "Able to Enter Relation Middle Name", "Unable to Enter Relation Middle Name", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='swdLname']")
	WebElement relLNameWE;
	
	public void relLastName(String relLName) {
		stepstatus = setText(relLNameWE, relLName);
		reportEvent(stepstatus, "Able to Enter Relation Last Name", "Unable to Enter Relation Last Name", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='leaEditReason']")
	WebElement remarksAdded;
	public void remarksAddedForSubmission(String remarks) {
		stepstatus = setText(remarksAdded, remarks);
		reportEvent(stepstatus, "Able to Enter Remarks", "Unable to Enter Remarks", driver, true);
	}
}
