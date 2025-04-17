package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class FeepaymentTermsandconditionsPage  extends BasePage{

	
	WebDriver driver;

	boolean stepstatus;

	public FeepaymentTermsandconditionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	WebElement Checkbox;

	public void ClickonCheckbox_Termsandconditions() {
		stepstatus = clickElement(Checkbox);
		reportEvent(stepstatus, "Able to click Paynow button", "Unable to click Paynow button", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='button1']")
	WebElement Proceedforpayment;
	public void Clickon_Proceedforpayment() {
		stepstatus = clickElement(Proceedforpayment);
		reportEvent(stepstatus, "Able to click Paynow button", "Unable to click Paynow button", driver, true);
		wait(7);
		if (alertExist(driver)) {
			acceptAlert(driver);
		} else {
			dismissAlert(driver);
		}
	}
}
