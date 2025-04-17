package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CL_RegularizeProvisionalCLPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public CL_RegularizeProvisionalCLPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clNumber']")
	WebElement TempCLNumber;

	public void enter_TemporaryCL(String value) {
		stepstatus = basepage.setText(TempCLNumber, value);
		reportEvent(stepstatus, "Able to Enter TempCLNumber", "Unable to Enter TempCLNumber", driver, true);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='applicationNumber']")
	WebElement ApplicationNumber;

	public void enter_TempApplicationNumber(String value) {
		stepstatus = basepage.setText(ApplicationNumber, value);
		reportEvent(stepstatus, "Able to Enter TempApplicationNumber", "Unable to Enter TempApplicationNumber", driver,
				true);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='captcha']")
	WebElement Captcha;

	public void enter_Captcha(String value) {
		stepstatus = basepage.setText(Captcha, "123456");
		reportEvent(stepstatus, "Able to Enter Captcha", "Unable to Enter Captcha", driver, true);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='proceed']")
	WebElement ProceedBtn;

	public void clickon_ProceedBtn() {
		stepstatus = basepage.clickElement(ProceedBtn);
		reportEvent(stepstatus, "Able to click Proceed Button", "Unable to click Proceed Button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='tempCLEditResult_0']")
	WebElement HomeBtn;

	public void clickon_HomeBtn() {
		stepstatus = basepage.clickElement(HomeBtn);
		reportEvent(stepstatus, "Able to click Home Button", "Unable to click Home Button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//img[@title='Click Here to Refresh Captcha']")
	WebElement RefreshBtn;

	public void clickon_RefreshBtn() {
		stepstatus = basepage.clickElement(RefreshBtn);
		reportEvent(stepstatus, "Able to click Refresh Button", "Unable to click Refresh Button", driver, true);
	}

}
