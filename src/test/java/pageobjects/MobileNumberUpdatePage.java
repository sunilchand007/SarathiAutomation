package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworkLibrary.BasePage;

public class MobileNumberUpdatePage extends BasePage {

	WebDriver driver;

	boolean stepstatus;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Mobile Number Update']")
	WebElement mobilenoupdate;

	public void Clickon_Mobile_Number_Update() {
		stepstatus =clickElement(mobilenoupdate);
		reportEvent(stepstatus, "Able to click Mobile_Number_Update", "Unable to click Mobile_Number_Update", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='licType']")
	WebElement SelectCriteria;

	public String Select_Criteria(String Option) {
		stepstatus =setValueInSelectBox(SelectCriteria, Option);
		reportEvent(stepstatus, "Able to  SelectCriteria", "Unable to  SelectCriteria", driver, true);
		return Option;

	}

	@FindBy(how = How.XPATH, using = "//input[@name='licIssueDate']")
	WebElement Licence_Issue_Date;

	public void Enter_Licence_Issue_Date() {
		stepstatus =setText(Licence_Issue_Date, getdata("LicIssueDate"));
		reportEvent(stepstatus, "Able to Enter Licence_Issue_Date ", "Unable to Enter Licence_Issue_Date", driver);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='licNo']")
	WebElement LicenNumber;

	public void Enter_LicNumber() {
		stepstatus =setText(LicenNumber, getdata("LLNumber"));
		reportEvent(stepstatus, "Able to Enter LLNumber ", "Unable to Enter LLNumber", driver);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='dob']")
	WebElement DOB;

	public void Enter_DateOFbirth() {
		stepstatus =setText(DOB, getdata("DOB"));
		reportEvent(stepstatus, "Able to Enter Date of Birth ", "Unable to Enter Date of birth", driver);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='Submit']")
	WebElement Submitbutton;

	public void Clickon_Submitbutton() {
		stepstatus =clickElement(Submitbutton);
		reportEvent(stepstatus, "Able to click Submitbutton", "Unable to click Submitbutton", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='Proceed']")
	WebElement Proceedbutton;

	public void Clickon_Proceedbutton() {
		stepstatus =clickElement(Proceedbutton);
		reportEvent(stepstatus, "Able to click Proceedbutton", "Unable to click Proceedbutton", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='newMobNum']")
	WebElement NewMobileNo;

	public void Enter_NewMobileNo() {
		stepstatus =setText(NewMobileNo, getdata("NewMobileNumber"));
		reportEvent(stepstatus, "Able to Enter NewMobileNo ", "Unable to Enter NewMobileNo", driver);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='cnfMobNum']")
	WebElement ConfNewMobileNo;

	public void Enter_ConfNewMobileNo() {
		stepstatus =setText(ConfNewMobileNo, getdata("NewMobileNumber"));
		reportEvent(stepstatus, "Able to Enter Conf NewMobileNo ", "Unable to Enter Conf NewMobileNo", driver);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='reason']")
	WebElement reasonforchange;

	public void Enter_Reasonforchange() {
		stepstatus =setText(reasonforchange, getdata("ReasonforChange"));
		reportEvent(stepstatus, "Able to Enter Reasonforchange ", "Unable to Enter Reasonforchange", driver);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='button1']")
	WebElement ProceedbuttonatConf;

	public void Clickon_ProceedbuttonatConf() {
		stepstatus =clickElement(ProceedbuttonatConf);
		reportEvent(stepstatus, "Able to click Proceedbutton", "Unable to click Proceedbutton", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='finalProceedBt']")
	WebElement finalProceedbuttonatConf;

	public void Clickon_finalProceedbuttonatConf() {
		stepstatus =clickElement(finalProceedbuttonatConf);
		reportEvent(stepstatus, "Able to click Proceedbutton", "Unable to click Proceedbutton", driver, true);
	}
}
