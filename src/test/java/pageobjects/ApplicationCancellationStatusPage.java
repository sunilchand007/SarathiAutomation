package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class ApplicationCancellationStatusPage extends BasePage{

	WebDriver driver;
	BasePage basepage = new BasePage();
	boolean stepstatus;
	
	public ApplicationCancellationStatusPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	

	@FindBy(how = How.XPATH, using = "//input[@Value='Cancel Application']")
	WebElement cancelapplnumber;

	public void Clickon_CancelApplication_No() {
		stepstatus = basepage.clickElement(cancelapplnumber);
		reportEvent(stepstatus, "Able to click CancelApplication_Number", "Unable to click CancelApplication_Number",
				driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "(//button[text()='Proceed for Cancel'])[2]")
	WebElement Prcdcancelapplnumber;

	public void Clickon_Proceed_CancelApplication_No() {
		wait(30);
		stepstatus = basepage.clickElement(Prcdcancelapplnumber);
		reportEvent(stepstatus, "Able to click Prcdcancelapplnumber", "Unable to click Prcdcancelapplnumber", driver,
				true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='otptext']")
	WebElement enterOTP;
	public void setOtp(String text) {
		stepstatus = basepage.setText(enterOTP, text);
		reportEvent(stepstatus, "Able to Enter text in otp field ", "Unable to Enter text in otp field", driver);
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='otpsubmit']")
	WebElement submitbuttonafterotp;

	public void Clickon_submit_button() {
		wait(20);
		stepstatus = basepage.clickElement(submitbuttonafterotp);
		reportEvent(stepstatus, "Able to click submit button", "Unable to click submitbutton", driver,
				true);
	}
	
}
