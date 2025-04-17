package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CL_Services_ChangeOfAddressPage extends BasePage{
	

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public CL_Services_ChangeOfAddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how=How.XPATH, using = "//div[@class='row collapse_bar']")
	WebElement ShoworHidePersonalandLicenceDetails;
	public void Clickon_ShoworHidePersonalandLicenceDetails() {
		stepstatus = basepage.clickElement(ShoworHidePersonalandLicenceDetails);
		reportEvent(stepstatus, "Able to click ShoworHidePersonalandLicenceDetails Button", "Unable to click ShoworHidePersonalandLicenceDetails Button", driver, true);
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='addressType1']")
	WebElement PresentAddress;
	public void Clickon_PresentAddress() {
		stepstatus = basepage.clickElement(PresentAddress);
		reportEvent(stepstatus, "Able to click PresentAddress Button", "Unable to click PresentAddress Button", driver, true);
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='addressType2']")
	WebElement PermanentAddress;
	public void Clickon_PermanentAddress() {
		stepstatus = basepage.clickElement(PermanentAddress);
		reportEvent(stepstatus, "Able to click PremanentAddress Button", "Unable to click PremanentAddress Button", driver, true);
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='addressType3']")
	WebElement Both_PresentandPermanentAddress;
	public void Clickon_Both_PresentandPermanentAddress() {
		stepstatus = basepage.clickElement(Both_PresentandPermanentAddress);
		reportEvent(stepstatus, "Able to click Both_PresentandPermanentAddress Button", "Unable to click Both_PresentandPermanentAddress Button", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='presState']")
	WebElement PresentState;

	public void Select_PresentState(String value) {
		stepstatus = basepage.setOptionInSelectBox(PresentState, value);
		reportEvent(stepstatus, "Able to Select State", "Unable to Select State", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='presDistrict']")
	WebElement PresentDistrict;

	public void Select_PresentDistrict(String value) {
		stepstatus = basepage.setOptionInSelectBox(PresentDistrict, value);
		reportEvent(stepstatus, "Able to Select District", "Unable to Select District", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='presSubDistrict']")
	WebElement PresentSubDistrict;

	public void Select_PresentSubDistrict(String value) {
		stepstatus = basepage.setOptionInSelectBox(PresentSubDistrict, value);
		reportEvent(stepstatus, "Able to Select SubDistrict", "Unable to Select SubDistrict", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='presVillageOrTown1']")
	WebElement PresentVillageradiobutton;
	public void Clickon_PresentVillageradiobutton() {
		stepstatus = basepage.clickElement(PresentVillageradiobutton);
		reportEvent(stepstatus, "Able to click Villageradiobutton ", "Unable to click Villageradiobutton ", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='presVillageOrTown1']")
	WebElement PresentTownradiobutton;
	public void Clickon_PresentTownradiobutton() {
		stepstatus = basepage.clickElement(PresentTownradiobutton);
		reportEvent(stepstatus, "Able to click Townradiobutton ", "Unable to click Townradiobutton ", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//select[@id='presCity']")
	WebElement PresentVillageorTown;

	public void Select_PresentVillageorTown(String value) {
		stepstatus = basepage.setOptionInSelectBox(PresentVillageorTown, value);
		reportEvent(stepstatus, "Able to Select VillageorTown ", "Unable to Select VillageorTown", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='presLocation']")
	WebElement PresentLocation ;
	
	public void Enter_PresentLocation(String value) {
		stepstatus = basepage.setText(PresentLocation, value);
		reportEvent(stepstatus, "Able to Enter PresentLocation", "Unable to Enter PresentLocation", driver, true);
		
	}

	@FindBy(how = How.XPATH, using = "//input[@id='presHouseNo']")
	WebElement PresentHouseno ;
	
	public void Enter_PresentHouseno (String value) {
		stepstatus = basepage.setText(PresentHouseno, value);
		reportEvent(stepstatus, "Able to Enter PresentHouseno", "Unable to Enter PresentHouseno", driver, true);
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='presStreet']")
	WebElement PresentStreet ;
	
	public void Enter_PresentStreet(String value) {
		stepstatus = basepage.setText(PresentStreet, value);
		reportEvent(stepstatus, "Able to Enter PresentStreet", "Unable to Enter PresentStreet", driver, true);
		
	}
	

	@FindBy(how = How.XPATH, using = "//input[@id='presPinCode']")
	WebElement PresentPincode ;
	
	public void Enter_PresentPincode(String value) {
		stepstatus = basepage.setText(PresentPincode, value);
		reportEvent(stepstatus, "Able to Enter PresentPincode", "Unable to Enter PresentPincode", driver, true);
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='phoneNumber']")
	WebElement PresentPhonenumber ;
	
	public void Enter_PresentPhonenumber(String value) {
		stepstatus = basepage.setText(PresentPhonenumber, value);
		reportEvent(stepstatus, "Able to Enter PresentPhonenumber", "Unable to Enter PresentPhonenumber", driver, true);
		
	}
	

	@FindBy(how = How.XPATH, using = "//select[@id='permState']")
	WebElement PermanentState;

	public void Select_PermanentState(String value) {
		stepstatus = basepage.setOptionInSelectBox(PermanentState, value);
		reportEvent(stepstatus, "Able to Select PermanentState", "Unable to Select PermanentState", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='permDistrict']")
	WebElement PermanentDistrict;

	public void Select_PermanentDistrict(String value) {
		stepstatus = basepage.setOptionInSelectBox(PermanentDistrict, value);
		reportEvent(stepstatus, "Able to Select PermanentDistrict", "Unable to Select PermanentDistrict", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='permSubDistrict']")
	WebElement PermanentSubDistrict;

	public void Select_PermanentSubDistrict(String value) {
		stepstatus = basepage.setOptionInSelectBox(PermanentSubDistrict, value);
		reportEvent(stepstatus, "Able to Select PermanentSubDistrict", "Unable to Select PermanentSubDistrict", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='permVillageOrTown1']")
	WebElement PermanentVillageradiobutton;
	public void Clickon_PermanentVillageradiobutton() {
		stepstatus = basepage.clickElement(PermanentVillageradiobutton);
		reportEvent(stepstatus, "Able to click PermanentVillageradiobutton ", "Unable to click PermanentVillageradiobutton ", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='permVillageOrTown2']")
	WebElement PermanentTownradiobutton;
	public void Clickon_PermanentTownradiobutton() {
		stepstatus = basepage.clickElement(PermanentTownradiobutton);
		reportEvent(stepstatus, "Able to click PermanentTownradiobutton ", "Unable to click PermanentTownradiobutton ", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//select[@id='permCity']")
	WebElement PermanentVillageorTown;

	public void Select_PermanentVillageorTown(String value) {
		stepstatus = basepage.setOptionInSelectBox(PermanentVillageorTown, value);
		reportEvent(stepstatus, "Able to Select PermanentVillageorTown ", "Unable to Select PermanentVillageorTown", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='permLocation']")
	WebElement PermanentLocation ;
	
	public void Enter_PermanentLocation(String value) {
		stepstatus = basepage.setText(PermanentLocation, value);
		reportEvent(stepstatus, "Able to Enter PermanentLocation", "Unable to Enter PermanentLocation", driver, true);
		
	}

	@FindBy(how = How.XPATH, using = "//input[@id='permHouseNo']")
	WebElement PermanentHouseno ;
	
	public void Enter_PermanentHouseno (String value) {
		stepstatus = basepage.setText(PermanentHouseno, value);
		reportEvent(stepstatus, "Able to Enter PermanentHouseno", "Unable to Enter PermanentHouseno", driver, true);
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='permStreet']")
	WebElement PermanenttStreet ;
	
	public void Enter_PermanenttStreet(String value) {
		stepstatus = basepage.setText(PermanenttStreet, value);
		reportEvent(stepstatus, "Able to Enter PermanenttStreet", "Unable to Enter PermanenttStreet", driver, true);
		
	}
	

	@FindBy(how = How.XPATH, using = "//input[@id='permPinCode']")
	WebElement PermanentPincode ;
	
	public void Enter_PermanentPincode(String value) {
		stepstatus = basepage.setText(PermanentPincode, value);
		reportEvent(stepstatus, "Able to Enter PermanentPincode", "Unable to Enter PermanentPincode", driver, true);
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='permSameAsPres']")
	WebElement CopytoPermanentAddress ;
	
	public void Clickon_CopytoPermanentAddress() {
		stepstatus = basepage.clickElement(CopytoPermanentAddress);
		reportEvent(stepstatus, "Able to click CopytoPermanentAddress Checkbox ", "Unable to click CopytoPermanentAddress Checkbox ", driver, true);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='btn_confirm_coa']")
	WebElement Confirm;
	public void Clickon_Confirm() {
		stepstatus = basepage.clickElement(Confirm);
		reportEvent(stepstatus, "Able to click Confirm button ", "Unable to click Confirm button ", driver, true);
		
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}
		
	    reportEvent(stepstatus, "Able to Click Ok button", "Unable to Click Ok button", driver, true);
	}
	
	
	 
	
	@FindBy(how = How.XPATH, using = "//input[@id='btn_refresh_coa']")
	WebElement Refresh;
	public void Clickon_Refresh() {
		stepstatus = basepage.clickElement(Refresh);
		reportEvent(stepstatus, "Able to click Refresh button ", "Unable to click Refresh button ", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='btn_cancel_coa']")
	WebElement Cancel;
	public void Clickon_Cancel() {
		stepstatus = basepage.clickElement(Cancel);
		reportEvent(stepstatus, "Able to click Cancel button ", "Unable to click Cancel button ", driver, true);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}

		reportEvent(stepstatus, "Able to Click Ok button", "Unable to Click Ok button", driver, true);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='btn_save']")
	WebElement Submit;
	public void Clickon_Submit() {
		stepstatus = basepage.clickElement(Submit);
		reportEvent(stepstatus, "Able to click Submit button ", "Unable to click Submit button ", driver, true);
		
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}
		wait(2);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='btn_exit']")
	WebElement Exit;
	public void Clickon_Exit() {
		stepstatus = basepage.clickElement(Exit);
		reportEvent(stepstatus, "Able to click Exit button ", "Unable to click Exit button ", driver, true);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}

		reportEvent(stepstatus, "Able to Click Ok button", "Unable to Click Ok button", driver, true);
	}
	
	
	
	
}
