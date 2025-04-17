package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CL_Services_DuplicateCLPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public CL_Services_DuplicateCLPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using = "//div[@class='row collapse_bar']")
	WebElement ShoworHidePersonalandLicenceDetails;
	public void Clickon_ShoworHidePersonalandLicenceDetails() {
		stepstatus = basepage.clickElement(ShoworHidePersonalandLicenceDetails);
		reportEvent(stepstatus, "Able to click ShoworHidePersonalandLicenceDetails Button", "Unable to click ShoworHidePersonalandLicenceDetails Button", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//select[@id='reasonForDuplicate']")
	WebElement ReasonForDuplicateCL;
	
    public void Select_ReasonForDuplicateCL(String value) {
		stepstatus = basepage.setOptionInSelectBox(ReasonForDuplicateCL, value);
		reportEvent(stepstatus, "Able to Select ReasonForDuplicateCL", "Unable to Select ReasonForDuplicateCL", driver, true);
	}
    
 
    @FindBy(how=How.XPATH, using = "//input[@id='btn_confirm_dupcl']")
	WebElement Confirm;
	public void Clickon_Confirm() {
		stepstatus = basepage.clickElement(Confirm);
		reportEvent(stepstatus, "Able to click Confirm Button", "Unable to click Confirm Button", driver, true);
		
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}
		
	    reportEvent(stepstatus, "Able to Click Ok button", "Unable to Click Ok button", driver, true);
		}
	
	
	
	
	@FindBy(how=How.XPATH, using = "//input[@id='btn_refresh_dupcl']")
	WebElement Refresh;
	public void Clickon_Refresh() {
		stepstatus = basepage.clickElement(Refresh);
		reportEvent(stepstatus, "Able to click Refresh Button", "Unable to click Refresh Button", driver, true);
		}
	
	
	
	@FindBy(how=How.XPATH, using = "//input[@id='btn_cancel_dupcl']")
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
