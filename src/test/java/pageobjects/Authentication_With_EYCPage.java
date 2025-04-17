package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class Authentication_With_EYCPage extends BasePage{

	WebDriver driver;
	boolean stepstatus;
	
	public Authentication_With_EYCPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='authenticateWithTypeA']")
	WebElement AadharNumber;

	public void SelectAadharNumber() {
		stepstatus = clickElement(AadharNumber);
		reportEvent(stepstatus, "Able to click AadharNumber", "Unable to click AadharNumber", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='authenticateWithTypeV']")
	WebElement VirtualNumber;

	public void SelectVirtualNumber() {
		stepstatus = clickElement(VirtualNumber);
		reportEvent(stepstatus, "Able to click VirtualNumber", "Unable to click VirtualNumber", driver, true);
	}
	

	@FindBy(how = How.XPATH, using = "//input[@id='aadharNumber']")
	WebElement inputAadharorVirtualNumber;

	public void Enter_AadharorVirtualNumber(String Value) {
		stepstatus = SetTextAndTAB(inputAadharorVirtualNumber, Value);
		reportEvent(stepstatus, "Able to Enter AadharorVirtualNumber", "Unable to click AadharorVirtualNumber", driver,
				true);
	}
	@FindBy(how = How.XPATH, using = "//input[@id='authenticateWithTypeV']/following::div[5]/div/button")
	WebElement OTPButton;

	public void ClickonGenerateotpButton() {
		stepstatus = clickElement(OTPButton);
		reportEvent(stepstatus, "Able to click OTPButton", "Unable to click OTPButton", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@value='Authenticate']")
	WebElement authenticate;

	public void ClickonAuthenticate() {
		stepstatus = clickElement(authenticate);
		reportEvent(stepstatus, "Able to click authenticate", "Unable to click authenticate", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='saveid']")
	WebElement btnProceed;

	public void Clickon_Proceedbutton() {
		stepstatus = clickElement(btnProceed);
		reportEvent(stepstatus, "Able to click Proceed", "Unable to click Proceed", driver, true);
	}
}
