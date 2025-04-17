package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class InstructionsForOnlinePaymentPage  extends BasePage{

	BasePage basepage = new BasePage();
	WebDriver driver;

	boolean stepstatus;

	public InstructionsForOnlinePaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='EPAYMENT ']")
	WebElement EPayments;

	public void Clickon_EPayment() {
		stepstatus = basepage.clickElement(EPayments);
		reportEvent(stepstatus, "Able to click EPayments", "Unable to click EPayments", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='APPLICATION FEE']")
	WebElement ApplicationFee;

	public void Clickon_ApplicationFee() {
		stepstatus = basepage.clickElement(ApplicationFee);
		reportEvent(stepstatus, "Able to click ApplicationFee", "Unable to click ApplicationFee", driver, true);
	}

}
