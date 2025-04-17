package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class CL_CLPrintPage extends BasePage{

	BasePage basepage = new BasePage();

	WebDriver driver;
	boolean stepstatus;

	public CL_CLPrintPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='clsearch_clsearchopt1']")
	WebElement Application_Number;
	
	public void Clickon_ApplicationNoRadiobtn() {
		stepstatus = basepage.clickElement(Application_Number);
		reportEvent(stepstatus, "Able to click ApplicationNoRadiobtn", "Unable to click ApplicationNoRadiobtn", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='clsearch_clsearchopt2']")
	WebElement ConductorLicenceNumber;
	
	public void Clickon_ConductorLicenceNoRadiobtn() {
		stepstatus = basepage.clickElement(ConductorLicenceNumber);
		reportEvent(stepstatus, "Able to click ConductorLicenceNoRadiobtn", "Unable to click ConductorLicenceNoRadiobtn", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='clsearch_clsearchopt3']")
	WebElement OnDate;
	
	public void Clickon_OnDateRadiobtn() {
		stepstatus = basepage.clickElement(OnDate);
		reportEvent(stepstatus, "Able to click OnDateRadiobtn", "Unable to click OnDateRadiobtn", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='clsearch_ondatesub1']")
	WebElement OnApplicationDate;
	
	public void Clickon_OnApplicationDateRadiobtn() {
		stepstatus = basepage.clickElement(OnApplicationDate);
		reportEvent(stepstatus, "Able to click OnApplicationDateRadiobtn", "Unable to click OnApplicationDateRadiobtn", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='clsearch_ondatesub2']")
	WebElement OnCLApprovedDate;
	
	public void Clickon_OnCLApprovedDateRadiobtn() {
		stepstatus = basepage.clickElement(OnCLApprovedDate);
		reportEvent(stepstatus, "Able to click OnCLApprovedDateRadiobtn", "Unable to click OnCLApprovedDateRadiobtn", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='webrefnum']")
	WebElement ApplicationNo;
	public void Set_Application_No() {
		stepstatus = basepage.setText(ApplicationNo, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to Enter Application_Number", "Unable to Enter Application_Number", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='clicnum']")
	WebElement ConductorLicenceNo;
	public void Set_ConductorLicenceNumber(String value) {
		stepstatus = basepage.setText(ConductorLicenceNo, value);
		reportEvent(stepstatus, "Able to Enter ConductorLicenceNo", "Unable to Enter ConductorLicenceNo", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='ondateId']")
	WebElement OnDate_date;
	public void Set_OnDate_date(String value) {
		stepstatus = basepage.setText(OnDate_date, value);
		reportEvent(stepstatus, "Able to Enter OnDate_date", "Unable to Enter OnDate_date", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='ondateId']")
	WebElement OnCLApproved_date;
	public void Set_OnCLApproved_date(String value) {
		stepstatus = basepage.setText(OnCLApproved_date, value);
		reportEvent(stepstatus, "Able to Enter OnCLApproved_date", "Unable to Enter OnCLApproved_date", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='clsearch_clsearchopt4']")
	WebElement OnBetweenDate;
	
	public void Clickon_OnBetweenDateRadiobtn() {
		stepstatus = basepage.clickElement(OnCLApprovedDate);
		reportEvent(stepstatus, "Able to click OnCLApprovedDateRadiobtn", "Unable to click OnCLApprovedDateRadiobtn", driver, true);
	}
	
	

	@FindBy(how = How.XPATH, using = "//input[@id='clsearch_betweendatesub1']")
	WebElement OnBetweenDate_AppDate;
	
	public void Clickon_OnBetweenDate_AppDateRadiobtn() {
		stepstatus = basepage.clickElement(OnBetweenDate_AppDate);
		reportEvent(stepstatus, "Able to click OnBetweenDate_AppDate", "Unable to click OnBetweenDate_AppDate", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='clsearch_betweendatesub2']")
	WebElement OnBetweenDate_CLApproveDate;
	
	public void Clickon_OnBetweenDate_CLApproveDateRadiobtn() {
		stepstatus = basepage.clickElement(OnBetweenDate_CLApproveDate);
		reportEvent(stepstatus, "Able to click OnBetweenDate_CLApproveDate", "Unable to click OnBetweenDate_CLApproveDate", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='fromDateId']")
	WebElement OnBetweenDate_FromDate;
	
	public void Set_OnBetweenDate_FromDate(String value) {
		stepstatus = basepage.setText(OnBetweenDate_FromDate, value);
		reportEvent(stepstatus, "Able to Enter OnBetweenDate_FromDate", "Unable to Enter OnBetweenDate_FromDate", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='toDateId']")
	WebElement OnBetweenDate_ToDate;
	
	public void Set_OnBetweenDate_ToDate(String value) {
		stepstatus = basepage.setText(OnBetweenDate_ToDate, value);
		reportEvent(stepstatus, "Able to Enter OnBetweenDate_ToDate", "Unable to Enter OnBetweenDate_ToDate", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='clsearch_0']")
	WebElement ViewApplicationsButton;
	
	public void Clickon_ViewApplicationsButton() {
		stepstatus = basepage.clickElement(ViewApplicationsButton);
		reportEvent(stepstatus, "Able to click ViewApplicationsButton", "Unable to click ViewApplicationsButton", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//table[@id='licDetTable']/tbody/tr/td[6]/a")
	WebElement printCL;
	
	public void Clickon_CLNumberLink() {
		stepstatus = basepage.clickElement(printCL);
		wait(3);	
		reportEvent(stepstatus, "Able to click printCL link", "Unable to click printCL link", driver, true);
	}
	
	
	
}
