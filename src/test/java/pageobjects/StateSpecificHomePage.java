package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class StateSpecificHomePage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;

	boolean stepstatus;

	public StateSpecificHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelements

	@FindBy(how = How.XPATH, using = "(//button[@class='close popupclose'])")
	WebElement Displaypop;

	public void closeContactlessLicenceServicesPopup() {

		if (isDisplayed(Displaypop) == true) {

		stepstatus = basepage.clickElement(Displaypop);
			reportEvent(stepstatus, "Able to closeContactlessLicenceServicesPopup",
					"Unable to closeContactlessLicenceServicesPopup", driver, true);
			System.out.println("POP-UP Closed");
		} else {
			System.out.println("There is no POP-UP");
		}

	}

	@FindBy(how = How.XPATH, using = "((//a[@id='navbarDropdownMenuLink'])[1])")
	WebElement LearnerLicence;

	public void Mouserhoveron_LearnerLicence() {
		//waitForPageToLoad(driver);
		wait(30);
		stepstatus = basepage.mouseHover(LearnerLicence, driver);
		reportEvent(stepstatus, "Able to do Mousehover action on Learner Licence",
				"Unable to do Mousehover action on Learner Licence", driver, true);
		
	}

	@FindBy(how = How.XPATH, using = " //a[text() = ' Driving Licence '] ")
	WebElement mousehover_drivinglicence;

	public void Mouserhoveron_DrivingLicence() {
		//waitForPageToLoad(driver);
		wait(30);
		stepstatus = basepage.mouseHover(mousehover_drivinglicence, driver);
		reportEvent(stepstatus, "Able to do Mousehover action on driving Licence",
				"Unable to do Mousehover action on driving Licence", driver, true);
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[text()='Application for New Learner Licence']")
	WebElement ApplicationforNewLearnerLicence;

	public void Clickon_Application_for_New_LearnerLicence() {
		stepstatus = basepage.clickElement(ApplicationforNewLearnerLicence);
		reportEvent(stepstatus, "Able to click on ApplicationforNewLearnerLicence",
				"Unable to click on ApplicationforNewLearnerLicence", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[text() = 'DL Club']")
	WebElement clickon_dlclub;

	public void clickon_DLClub() {
		stepstatus = basepage.clickElement(clickon_dlclub);
		reportEvent(stepstatus, "Able to click on dl club",
				"Unable to click on dl club ", driver, true);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//a[text()='Services for Duplicate LL, Address change, etc']")
	WebElement ServicesforAddresschange;

	public void Clickon_Servicesfor_DuplicateLL_Addresschange_etc() {
		stepstatus = basepage.clickElement(ServicesforAddresschange);
		reportEvent(stepstatus, "Able to click on ServicesforAddresschange",
				"Unable to click on ServicesforAddresschange", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()=' Conductor Licence ']")
	WebElement conductorlicence;

	public void Mouserhoveron_ConductorLicence() {
		stepstatus = basepage.mouseHover(conductorlicence, driver);
		reportEvent(stepstatus, "Able to do Mousehover action on Conductor Licence",
				"Unable to do Mousehover action on Conductor Licence", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='New Conductor Licence']")
	WebElement NewConductorLicence;

	public void Clickon_NewConductorLicence() {
		stepstatus = basepage.clickElement(NewConductorLicence);
		reportEvent(stepstatus, "Able to click NewConductorLicence Link", "Unable to click NewConductorLicence Link",
				driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Temporary Conductor Licence']")
	WebElement TemporaryConductorLicence;


	public void Clickon_TemporaryConductorLicence() {
		stepstatus = basepage.clickElement(TemporaryConductorLicence);
		reportEvent(stepstatus, "Able to click TemporaryConductorLicence Link", "Unable to click TemporaryConductorLicence Link",
				driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Services on Conductor Licence']")
	WebElement ServicesOnConductorLicence;

	public void Clickon_ServicesOnConductorLicence() {
		stepstatus = basepage.clickElement(ServicesOnConductorLicence);
		reportEvent(stepstatus, "Able to click ServicesOnConductorLicence Link", "Unable to click ServicesOnConductorLicences Link",
				driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Online Conductor Licence Test']")
	WebElement OnlineConductorLicenceTest;

	public void Clickon_OnlineConductorLicenceTest() {
		stepstatus = basepage.clickElement(OnlineConductorLicenceTest);
		reportEvent(stepstatus, "Able to click OnlineConductorLicenceTest Link", "Unable to click OnlineConductorLicenceTest Link",
				driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Print Conductors Licence']")
	WebElement PrintConductorLicence;

	public void Clickon_PrintConductorLicence() {
		stepstatus = basepage.clickElement(PrintConductorLicence);
		reportEvent(stepstatus, "Able to click PrintConductorLicence Link", "Unable to click PrintConductorLicence Link",
				driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='CL Extract Print']")
	WebElement CLExtractPrint;

	public void Clickon_CLExtractPrint() {
		stepstatus = basepage.clickElement(CLExtractPrint);
		reportEvent(stepstatus, "Able to click CLExtractPrint Link", "Unable to click CLExtractPrint Link", driver, true);
		
	}
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Regularize Provisional CL']")
	WebElement RegularizeProvisionalCL;

	public void Clickon_RegularizeProvisionalCL() {
		stepstatus = basepage.clickElement(RegularizeProvisionalCL);
		reportEvent(stepstatus, "Able to click RegularizeProvisionalCL Link", "Unable to click RegularizeProvisionalCL Link", driver, true);
		
	}
	
	

	@FindBy(how = How.XPATH, using = "//a[text()=' Fee Payments ']")
	WebElement Payments;

	public void Mouserhoveron_FeePayments() {
		stepstatus = basepage.mouseHover(Payments, driver);
		reportEvent(stepstatus, "Able to do Mousehover action on Fee Payments",
				"Unable to do Mousehover action on Fee Payments", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//a[text()='Fee Payments']")
	WebElement FeePayment;

	public void Clickon_FeePayments() {
		stepstatus = basepage.clickElement(FeePayment);
		reportEvent(stepstatus, "Able to click FeePayment", "Unable to click FeePayment", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Verify Pay Status']")
	WebElement VerifyPaymentStatus;

	public void Clickon_Verify_Payment_Status() {
		stepstatus = basepage.clickElement(VerifyPaymentStatus);
		reportEvent(stepstatus, "Able to click VerifyPayStatus", "Unable to click VerifyPayStatus", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "(//a[@id='navbarDropdownMenuLink'])[10]")
	WebElement Application_Status;
	
	public void Clickon_Application_Status() {
		stepstatus = basepage.clickElement(Application_Status);
		reportEvent(stepstatus, "Able to click Application_Status", "Unable to click Application_Status", driver);
	}

	@FindBy(how = How.XPATH, using = "//a[text()=' Others ']")
	WebElement Others;

	public void Mouserhoveron_Others() {
		stepstatus = basepage.mouseHover(Others, driver);
		reportEvent(stepstatus, "Able to do Mousehover action on Others", "Unable to do Mousehover action on Others",
				driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Cancel Application']")
	WebElement cancelapplno;

	public void Clickon_CancelApplication_Number() {
		stepstatus = basepage.clickElement(cancelapplno);
		reportEvent(stepstatus, "Able to click CancelApplication_Number", "Unable to click CancelApplication_Number",
				driver, true);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//a[text() = 'Print Driving Licence']")
	WebElement printdrivinglicence;

	public void clickon_PrintDrivingLicence() {
		stepstatus = basepage.clickElement(printdrivinglicence);
		reportEvent(stepstatus, "Able to click print driving licence ", "Unable to click print driving licence",
				driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text() = 'Display IDP Details']")
	WebElement display_idp_details;

	public void Clickon_Display_IDP_Details() {
		stepstatus = basepage.clickElement(display_idp_details);
		reportEvent(stepstatus, "Able to click display idp details ", "Unable to click display idp details ",
				driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='DL Extract Print']")
	WebElement dl_extract_print;

	public void clickon_Dl_ExtractPrint() {
		stepstatus = basepage.clickElement(dl_extract_print);
		reportEvent(stepstatus, "Able to click dl extract print ", "Unable to click dl extract print ",
				driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[text()='Driving Licence Test Sheet']")
	WebElement drivinglicencesheet;

	public void clickon_DrivingLicenceSheet() {
		stepstatus = basepage.clickElement(drivinglicencesheet);
		reportEvent(stepstatus, "Able to click DrivingLicenceSheet", "Unable to click DrivingLicenceSheet ",
				driver, true);
	}
	@FindBy(how = How.XPATH, using = "//a[text() = 'LL Edit Entry']")
	WebElement clickonLLeditentry;

	public void clickon_LLEditEntry() {
		stepstatus = basepage.clickElement(clickonLLeditentry);
		reportEvent(stepstatus, "Able to click ll edit entry ", "Unable to click ll edit entry ",
				driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text() = 'Search Related Applications']")
	WebElement clickonsearchRelatedApplications;

	public void clickon_SearchRelatedApplications() {
		stepstatus = basepage.clickElement(clickonsearchRelatedApplications);
		reportEvent(stepstatus, "Able to  click on search RelatedApplications ", "Unable to click on search RelatedApplications",
				driver, true);
	}
	
	
	
	
	
}
