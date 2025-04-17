package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CL_Services_ChangeOfNamePage extends BasePage {
	
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public CL_Services_ChangeOfNamePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.XPATH, using = "//div[@class='row collapse_bar']")
	WebElement ShoworHidePersonalandLicenceDetails;
	public void Clickon_ShoworHidePersonalandLicenceDetails() {
		stepstatus = basepage.clickElement(ShoworHidePersonalandLicenceDetails);
		reportEvent(stepstatus, "Able to click ShoworHidePersonalandLicenceDetails Button", "Unable to click ShoworHidePersonalandLicenceDetails Button", driver, true);
	}
	
	
	

	@FindBy(how = How.XPATH, using = "//input[@id='fullNameEntry']")
	WebElement NewFullName ;
	
	public void Enter_NewFullName(String value) {
		stepstatus = basepage.setText(NewFullName, value);
		reportEvent(stepstatus, "Able to Enter NewFullName", "Unable to Enter NewFullName", driver, true);
		}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='fname']")
	WebElement FirstName ;
	
	public void Enter_FirstName(String value) {
		stepstatus = basepage.setText(FirstName, value);
		reportEvent(stepstatus, "Able to Enter FirstName", "Unable to Enter FirstName", driver, true);
		}
	
	@FindBy(how = How.XPATH, using = "//input[@id='mname']")
	WebElement MiddleName ;
	
	public void Enter_MiddleName(String value) {
		stepstatus = basepage.setText(MiddleName, value);
		reportEvent(stepstatus, "Able to Enter MiddleName", "Unable to Enter MiddleName", driver, true);
		}
	
	@FindBy(how = How.XPATH, using = "//input[@id='lname']")
	WebElement LastName ;
	
	public void Enter_LastName(String value) {
		stepstatus = basepage.setText(LastName, value);
		reportEvent(stepstatus, "Able to Enter LastName", "Unable to Enter LastName", driver, true);
		}
	
	@FindBy(how = How.XPATH, using = "//select[@id='relationTypeEntry']")
	WebElement Relation ;
	

	public void Select_Relation(String value) {
		stepstatus = basepage.setOptionInSelectBox(Relation, value);
		reportEvent(stepstatus, "Able to Select Relation", "Unable to Select Relation", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='swdfName']")
	WebElement RelationFirstName ;
	
	public void Enter_RelationFirstName(String value) {
		stepstatus = basepage.setText(RelationFirstName, value);
		reportEvent(stepstatus, "Able to Enter RelationFirstName", "Unable to Enter RelationFirstName", driver, true);
		}
	
	@FindBy(how = How.XPATH, using = "//input[@id='swdmName']")
	WebElement RelationMiddleName ;
	
	public void Enter_RelationMiddleName(String value) {
		stepstatus = basepage.setText(RelationMiddleName, value);
		reportEvent(stepstatus, "Able to Enter RelationMiddleName", "Unable to Enter RelationMiddleName", driver, true);
		}
	
	@FindBy(how = How.XPATH, using = "//input[@id='swdlName']")
	WebElement RelationLastName ;
	
	public void Enter_RelationLastName(String value) {
		stepstatus = basepage.setText(RelationLastName, value);
		reportEvent(stepstatus, "Able to Enter RelationLastName", "Unable to Enter RelationLastName", driver, true);
		}
	
	@FindBy(how = How.XPATH, using = "//select[@id='reason']")
	WebElement ReasonForChangeOfName ;
	public void Select_ReasonForChangeOfName(String value) {
		stepstatus = basepage.setOptionInSelectBox(ReasonForChangeOfName, value);
		reportEvent(stepstatus, "Able to Select ReasonForChangeOfName", "Unable to Select ReasonForChangeOfName", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='effectDate']")
	WebElement EffectiveDate ;
	
	public void Enter_EffectiveDate(String value) {
		stepstatus = basepage.setText(EffectiveDate, value);
		reportEvent(stepstatus, "Able to Enter EffectiveDate", "Unable to Enter EffectiveDate", driver, true);
		}
	
	
	@FindBy(how=How.XPATH, using = "//input[@id='btn_confirm_con']")
	WebElement Confirm;
	public void Clickon_Confirm() {
		stepstatus = basepage.clickElement(Confirm);
		reportEvent(stepstatus, "Able to click Confirm Button", "Unable to click Confirm Button", driver, true);
		wait(3);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}
		
	    reportEvent(stepstatus, "Able to Click Ok button", "Unable to Click Ok button", driver, true);
	}
	
	
	
	
	@FindBy(how=How.XPATH, using = "//input[@id='btn_refresh_con']")
	WebElement Refresh;
	public void Clickon_Refresh() {
		stepstatus = basepage.clickElement(Refresh);
		reportEvent(stepstatus, "Able to click Refresh Button", "Unable to click Refresh Button", driver, true);
	}
	
	
	@FindBy(how=How.XPATH, using = "//input[@id='btn_cancel_con']")
	WebElement Cancel;
	public void Clickon_Cancel() {
		stepstatus = basepage.clickElement(Cancel);
		reportEvent(stepstatus, "Able to click Cancel Button", "Unable to click Cancel Button", driver, true);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}

		reportEvent(stepstatus, "Able to Click Ok button", "Unable to Click Ok button", driver, true);
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='btn_save']")
	WebElement Submit;
	public void Clickon_Submit() {
		stepstatus = basepage.clickElement(Submit);
		reportEvent(stepstatus, "Able to click Submit Button", "Unable to click Submit Button", driver, true);
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
	
	@FindBy(how=How.XPATH, using = "//input[@id='btn_exit']")
	WebElement Exit;
	public void Clickon_Exit() {
		stepstatus = basepage.clickElement(Exit);
		reportEvent(stepstatus, "Able to click Exit Button", "Unable to click Exit Button", driver, true);
		
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}

		reportEvent(stepstatus, "Able to Click Ok button", "Unable to Click Ok button", driver, true);
		
	}
	
	
	
}
