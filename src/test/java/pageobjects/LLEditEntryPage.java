package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class LLEditEntryPage extends BasePage{

	WebDriver driver;
	boolean stepstatus;
	BasePage basepage = new BasePage();
	
	
	public LLEditEntryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'licNumber']")
	WebElement editLlNumber;
	public void editLlNumber(String llNumber) {
		stepstatus = setText(editLlNumber, llNumber);
		reportEvent(stepstatus, "Able to Enter LL Number", "Unable to Enter LL Number", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'dobForm']")
	WebElement editLlDob;
	public void editLlDob(String llDob) {
		stepstatus = setText(editLlDob, llDob);
		reportEvent(stepstatus, "Able to Enter DateofBirth", "Unable to Enter DateofBirth", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//label[@id='processRequestll_req_dob']")
	WebElement tocloseDOBcalendar;
	public void click_tocloseDOBcalendar() {
		stepstatus = clickElement(tocloseDOBcalendar);
		reportEvent(stepstatus, "Able to click the tocloseDOBcalendar", "Unable to click the tocloseDOBcalendar", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='stateSelected']")
	WebElement selectState;
	public void editSelectStatename(String llEditSelectState) {
		stepstatus = basepage.setValueInSelectBox(selectState, llEditSelectState);
		reportEvent(stepstatus, "Able to Select Statename in LL Edit Entry", "Unable to Select Statename in LL Edit Entry", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='rtoSelected']")
	WebElement rtoSelected;
	public void editRtoSelected(String llEditRtoSelected) {
		stepstatus = basepage.setValueInSelectBox(rtoSelected, llEditRtoSelected);
		reportEvent(stepstatus, "Able to Select RTO in LL Edit Entry", "Unable to Select RTO in LL Edit Entry", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//button[@id='generateotp']")
	WebElement otpGeneratedForEditLLButton;
	public void clickOnOtpGeneratedForEditLLButton() {
		stepstatus = clickElement(otpGeneratedForEditLLButton);
		reportEvent(stepstatus, "Able to click on Generate OTP for LL edit", "Unable to click on Generate OTP for LL edit", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'entcaptxt']")
	WebElement editLlCaptcha;
	public void editLlCaptcha(String llCaptcha) {
		stepstatus = setText(editLlCaptcha, llCaptcha);
		reportEvent(stepstatus, "Able to Enter Captcha in LL Edit Entry", "Unable to Enter Captcha in LL Edit Entry", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='otpNumberForDlEdit']")
	WebElement editLlOtpNumberForDlEdit;
	public void editLlOtp(String otpDlCaptcha) {
		stepstatus = setText(editLlOtpNumberForDlEdit, otpDlCaptcha);
		reportEvent(stepstatus, "Able to Enter OTP for LL Edit", "Unable to Enter OTP for LL Edit", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//label[@id='processRequestll_label_enterotp']")
	WebElement llEditClickOnLabelForOTP;
	public void clickOnOtpLabel() {
		stepstatus = clickElement(llEditClickOnLabelForOTP);
		reportEvent(stepstatus, "Able to click on OTP label", "Unable to click on OTP label", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='submitll']")
	WebElement llEditClickOnSubmitLL;
	public void clickOnSubmitLL() {
		stepstatus = clickElement(llEditClickOnSubmitLL);
		
		/*
		 * if (editLlNumber.getText().equals("") ) {
		 * System.out.println("Please check the LL Number"); }else if
		 * (editLlDob.getText().equals("")) {
		 * System.out.println("Please check the DOB"); }else if
		 * (selectState.getText().equals("--Select--")) {
		 * System.out.println("Please select the state"); }
		 */
		reportEvent(stepstatus, "Able to click on Submit LL Button", 
				"Unable to click on Submit LL Button", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='resetDl']")
	WebElement llEditClickOnResetLL;
	public void clickOnResetLL() {
		
		boolean resetBtnStatus = clickElement(llEditClickOnResetLL);
		reportEvent(resetBtnStatus, "Able to click on Reset LL Button", "Unable to click on Reset LL Button", driver, true);
		
		if (resetBtnStatus) {
			editLlNumber("");
			editLlDob("");
			editSelectStatename("-1");
			editRtoSelected("-1");
			editLlCaptcha("");
			
			
		}
	}
	
	public void submitButton() {
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='exit2Public']")
	WebElement llEditClickOnExit;
	public void clickOnExit() {
		stepstatus = clickElement(llEditClickOnExit);
		reportEvent(stepstatus, "Able to click on Exit Button", "Unable to click on Exit Button", driver, true);
	}
	
	// -----------------   LL Edit Request Page   -------------------
	
	/* ---------------------- Correction Of Address -------------------- */
	
	
	
	/*
	 * @FindBy(how = How.XPATH, using = "//input[@id='corrAddr']") WebElement
	 * selectChangeOfAddress; public void clickOnCorrectionOfAddressCheckbox() {
	 * scrooldown(driver); wait(1); stepstatus =
	 * clickElement(selectChangeOfAddress); reportEvent(stepstatus,
	 * "Able to click on Change Of Address", "Unable to click on Change Of Address",
	 * driver, true);
	 * 
	 * }
	 */
	
	@FindBy(how = How.XPATH, using = "//*[@id='corrMisc']")
	WebElement selectChangeOfMisc;
	public boolean clickOnCorrectionOfMisc() {
		wait(1);
		return clickElement(selectChangeOfMisc);
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='corrName']")
	WebElement selectChangeOfName;
	public boolean clickOnCorrectionOfNameCheckbox() {
		wait(1);
		return clickElement(selectChangeOfName);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='corrDob']")
	WebElement selectChangeOfDob;
	public boolean clickOnCorrectionOfDobCheckbox() {
		wait(1);
		return clickElement(selectChangeOfDob);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='corrAddr']")
	WebElement selectChangeOfAddress;
	public boolean clickOnCorrectionOfAddressCheckbox() {
		wait(1);
		return clickElement(selectChangeOfAddress);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='corrVald']")
	WebElement selectValidities;
	public boolean clickOnSelectChangeInValidities() {
		wait(1);
		return clickElement(selectValidities);
	}

	
	@FindBy(how = How.XPATH, using = "//*[@id='corrCovs']")
	WebElement selectAddCov;
	public boolean clickOnSelectAddCov() {
		wait(1);
		return clickElement(selectAddCov);
	}

	
	@FindBy(how = How.XPATH, using = "//*[@id='submitReq']")
	WebElement llEntrySubmit;
	public void clickOnLLEditEntrySubmit() {
		scrooldown(driver);
		wait(1);
		stepstatus = clickElement(llEntrySubmit);
		reportEvent(stepstatus, "Able to click on LL Edit Entry Submit Button",
				"Unable to click on LL Edit Entry Submit Button", driver, true);
		
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='leaEditReason']")
	WebElement remarksAdded;
	public void remarksAddedForSubmission(String remarks) {
		stepstatus = setText(remarksAdded, remarks);
		reportEvent(stepstatus, "Able to Enter Remarks", "Unable to Enter Remarks", driver, true);
	}
	
	
	
	}
	


	

