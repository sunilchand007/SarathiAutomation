package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CL_Applicationfor_Serviceson_CLPage02 extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public CL_Applicationfor_Serviceson_CLPage02(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='mobileNumber']")
	WebElement MobileNumber ;
	
	public void Enter_MobileNumber(String value) {
		wait(2);
		stepstatus = basepage.setText(MobileNumber, value);
		reportEvent(stepstatus, "Able to Enter MobileNumber", "Unable to Enter MobileNumber", driver, true);
		
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='btn_confirm']")
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
	
	@FindBy(how=How.XPATH, using = "//input[@id='btn_cancel1']")
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
	
	@FindBy(how = How.XPATH, using = "//select[@id='stCd']")
	WebElement Statename;

	public void Select_Statename(String value) {
		stepstatus = basepage.setOptionInSelectBox(Statename, value);
		reportEvent(stepstatus, "Able to Select Statename", "Unable to Select Statename", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='clservicesRTO']")
	WebElement RtoOffice;

	public void Select_RtoOffice(String value) {
		stepstatus = basepage.setOptionInSelectBox(RtoOffice, value);
		reportEvent(stepstatus, "Able to Select RtoOffice", "Unable to Select RtoOffice", driver, true);
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='btn_go']")
	WebElement Go;
	public void Clickon_Go() {
		stepstatus = basepage.clickElement(Go);
		reportEvent(stepstatus, "Able to click Go Button", "Unable to click Go Button", driver, true);
		
	}
	
	
	@FindBy(how=How.XPATH, using = "//input[@id='renewalCL']")
	WebElement RenewalOfCL;
	public void Clickon_RenewalOfCL() {
		stepstatus = basepage.clickElement(RenewalOfCL);
		reportEvent(stepstatus, "Able to click RenewalOfCL checkbox ", "Unable to click RenewalOfCL checkbox", driver, true);
	}
	
	
	@FindBy(how=How.XPATH, using = "//input[@id='changeOfAddress']")
	WebElement ChangeOfAddress;
	public void Clickon_ChangeOfAddress() {
		stepstatus = basepage.clickElement(ChangeOfAddress);
		reportEvent(stepstatus, "Able to click ChangeOfAddress checkbox ", "Unable to click ChangeOfAddress checkbox", driver, true);
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='changeOfName']")
	WebElement ChangeOfName;
	public void Clickon_ChangeOfName() {
		stepstatus = basepage.clickElement(ChangeOfName);
		reportEvent(stepstatus, "Able to click ChangeOfName checkbox ", "Unable to click ChangeOfName checkbox", driver, true);
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='duplicateCL']")
	WebElement DuplicateCL;
	public void Clickon_DuplicateCL() {
		stepstatus = basepage.clickElement(DuplicateCL);
		reportEvent(stepstatus, "Able to click DuplicateCL checkbox ", "Unable to click DuplicateCL checkbox", driver, true);
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='biometricsCL']")
	WebElement ChangeOfBiometricsinCL;
	public void Clickon_ChangeOfBiometricsinCL() {
		stepstatus = basepage.clickElement(ChangeOfBiometricsinCL);
		reportEvent(stepstatus, "Able to click ChangeOfBiometricsinCL checkbox ", "Unable to click ChangeOfBiometricsinCL checkbox", driver, true);
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='extractCL']")
	WebElement ExtractCL;
	public void Clickon_ExtractCL() {
		stepstatus = basepage.clickElement(ExtractCL);
		reportEvent(stepstatus, "Able to click ExtractCL checkbox ", "Unable to click ExtractCL checkbox", driver, true);
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='btn_submit']")
	WebElement Submitbutton;
	public void Clickon_Submitbutton() {
		stepstatus = basepage.clickElement(Submitbutton);
		reportEvent(stepstatus, "Able to click Submitbutton  ", "Unable to click Submitbutton ", driver, true);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}
		
		reportEvent(stepstatus, "Able to Click Ok button", "Unable to Click Ok button", driver, true);
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='btn_cancel2']")
	WebElement Cancelbutton;
	public void Clickon_Cancelbutton() {
		stepstatus = basepage.clickElement(Cancelbutton);
		reportEvent(stepstatus, "Able to click Cancelbutton  ", "Unable to click Cancelbutton ", driver, true);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}
		
	    reportEvent(stepstatus, "Able to Click Ok button", "Unable to Click Ok button", driver, true);
	}
	
	
	
}
