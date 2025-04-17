package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import frameworkLibrary.BasePage;



public class IssueofPSVBadgeToDriverDLPage extends BasePage{
	
	WebDriver driver;
	boolean stepstatus;

	public IssueofPSVBadgeToDriverDLPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(how = How.XPATH, using = "//input[@name='issPsvDet']")
	WebElement CheckBoxTransCOV;
	
	@FindBy(how = How.XPATH, using = "//select[@name='firstTrngInstt']")
	WebElement firstAidTrainingCertificate;
	@FindBy(how = How.XPATH, using = "//input[@name='enrollno']")
	WebElement EnterEnrollno;
	@FindBy(how = How.XPATH, using = "//input[@name='enrollDt']")
	WebElement EnterEnrollDt;
	@FindBy(how = How.XPATH, using = "//input[@name='certno']")
	WebElement EnterCertno;
	@FindBy(how = How.XPATH, using = "//input[@name='certDt']")
	WebElement EntercertDt;
	@FindBy(how = How.XPATH, using = "//input[@value='Confirm']")
	WebElement ConfirminIssueofPSVBadge;
	
	@FindBy(how = How.XPATH, using = "//input[@name='applNum']")
	WebElement AppNo;
	@FindBy(how = How.XPATH, using = "//input[@name='app_no']")
	WebElement AppNo1;
	@FindBy(how = How.XPATH, using = "//select[@name='app_result']")
	WebElement testreele;
	@FindBy(how = How.XPATH, using = "//select[@name='appTestType']")
	WebElement testtype;
	
	public void selectTestType() {
		Select testresult = new Select(testtype);
		testresult.selectByVisibleText("OnLine");
	}
	public void selectResult() {
		Select testresult = new Select(testreele);
	testresult.selectByVisibleText("PASS");
	}
	
	public void Enter_ApplicationNumber1() {
		stepstatus = SetTextAndTAB(AppNo1, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to enter AppNo", "Unable to enter AppNo", driver, true);
	}
	public void Enter_ApplicationNumber(String ApplicationNo) {
		stepstatus = SetTextAndTAB(AppNo, ApplicationNo);
		reportEvent(stepstatus, "Able to enter AppNo", "Unable to enter AppNo", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//input[@name='testDate']")
	WebElement TestDate;

	public void Enter_TestDate() {
		scrooldown(driver);
//		stepstatus =SetTextAndTAB(TestDate, getdata("TestDate"));
		stepstatus = SetTextAndTAB(TestDate, "28-03-2024");
		reportEvent(stepstatus, "Able to enter TestDate", "Unable to enter TestDate", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//input[@value='Confirm']")
	WebElement Sub;

	public void Clickon_Submit() {
		stepstatus = clickElement(Sub);
		System.out.println(stepstatus);
		reportEvent(stepstatus, "Able to click on Submit", "Unable to click on Submit", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//input[@value='Submit' and @id='Submit']")
	WebElement Sub2;

	public void Clickon_Submit2() {
		stepstatus =clickElement(Sub2);
		System.out.println(stepstatus);
		reportEvent(stepstatus, "Able to click on Submit", "Unable to click on Submit", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//input[@value='Submit' and @id='psvBadgeOffLineRec_fetch']")
	WebElement Sub3;

	public void Clickon_Submit3() {
		stepstatus =clickElement(Sub3);
		System.out.println(stepstatus);
		reportEvent(stepstatus, "Able to click on Submit", "Unable to click on Submit", driver, true);
	}
	
	public void ClickonTransCOVCheckboxinDLService(){
		stepstatus =clickElement(CheckBoxTransCOV);
reportEvent(stepstatus, "Able to click on Confirm", "Unable to click on Confirm", driver, true);
		}
	public void firstAidTrainingCertificate() {

		stepstatus =setOptionInSelectBox(firstAidTrainingCertificate, "ST JOHN AMBULANCE");
		reportEvent(stepstatus, "Able to Select firstAidTrainingCertificate",
				"Unable to Select firstAidTrainingCertificate", driver, true);

	}
	public void EnterEnrollno() {
		stepstatus =setText(EnterEnrollno, "123456");
		reportEvent(stepstatus, "Able to Enter EnterEnrollno In DLService Submission",
				"Unable to Enter EnterEnrollno In DLService Submission", driver, true);
	}
	public void EnterEnrollDt() {
		stepstatus =setText(EnterEnrollDt, "01-01-2024");
		reportEvent(stepstatus, "Able to Enter EnterEnrollDt In DLService Submission",
				"Unable to Enter EnterEnrollDt In DLService Submission", driver, true);
	}
	public void EnterCertno() {
		stepstatus =setText(EnterCertno, "123456");
		reportEvent(stepstatus, "Able to Enter EnterCertno In DLService Submission",
				"Unable to Enter EnterCertno In DLService Submission", driver, true);
	}
	public void EntercertDt() {
		stepstatus =setText(EntercertDt, "01-01-2024");
		reportEvent(stepstatus, "Able to Enter EntercertDt In DLService Submission",
				"Unable to Enter EntercertDt In DLService Submission", driver, true);
	}
	public void ClickConfirmButton() {
		stepstatus =clickElement(ConfirminIssueofPSVBadge);
		reportEvent(stepstatus, "Able to click on Confirm", "Unable to click on Confirm", driver, true);
	}
	
	
	
}
