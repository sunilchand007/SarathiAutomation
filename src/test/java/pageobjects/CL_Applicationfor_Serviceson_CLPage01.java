package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CL_Applicationfor_Serviceson_CLPage01 extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public CL_Applicationfor_Serviceson_CLPage01(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clNumber']")
	WebElement CLNumber;

	public void Enter_ConductorLicencenumber(String value) {
		stepstatus = basepage.setText(CLNumber, value);
		reportEvent(stepstatus, "Able to Enter CLNumber", "Unable to Enter CLNumber", driver, true);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='dateOfBirth']")
	WebElement DateOfBirth;

	public void Enter_DateOfBirth(String value) {
		stepstatus = basepage.setText(DateOfBirth, value);
		reportEvent(stepstatus, "Able to Enter DateOfBirth", "Unable to Enter DateOfBirth", driver, true);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='captxt']")
	WebElement Captcha;

	public void Enter_Captcha(String value) {
		stepstatus = basepage.setText(Captcha, value);
		reportEvent(stepstatus, "Able to Enter Captcha", "Unable to Enter Captcha", driver, true);

	}

	@FindBy(how = How.XPATH, using = "//img[@title='Click Here to Refresh Captcha']")
	WebElement RefreshCaptcha;

	public void Clickon_RefreshCaptcha() {
		stepstatus = basepage.clickElement(RefreshCaptcha);
		reportEvent(stepstatus, "Able to click RefreshCaptcha Button", "Unable to click RefreshCaptcha Button", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='btn_proceed']")
	WebElement Proceed;

	public void Clickon_Proceed() {
		stepstatus = basepage.clickElement(Proceed);
		reportEvent(stepstatus, "Able to click Proceed Button", "Unable to click Proceed Button", driver, true);

		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}

		reportEvent(stepstatus, "Able to Click Ok button", "Unable to Click Ok button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='btn_refresh']")
	WebElement Refresh;

	public void Clickon_Refresh() {
		stepstatus = basepage.clickElement(Refresh);
		reportEvent(stepstatus, "Able to click Refresh Button", "Unable to click Refresh Button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='btn_cancel']")
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

}
