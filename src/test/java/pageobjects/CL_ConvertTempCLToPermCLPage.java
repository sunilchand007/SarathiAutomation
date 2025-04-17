package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CL_ConvertTempCLToPermCLPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public CL_ConvertTempCLToPermCLPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//textarea[@id='remarks']")
	WebElement Remarks;

	public void enter_Remarks(String value) {
		stepstatus = basepage.setText(Remarks, value);
		reportEvent(stepstatus, "Able to Enter Remarks", "Unable to Enter Remarks", driver, true);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='Approve']")
	WebElement SubmitBtn;

	public void clickon_SubmitBtn() {
		stepstatus = basepage.clickElement(SubmitBtn);
		reportEvent(stepstatus, "Able to click Submit Button", "Unable to click Submit Button", driver, true);

		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {
			basepage.dismissAlert(driver);
		}

		reportEvent(stepstatus, "Able to Click Ok button", "Unable to Click Ok button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='Exit']")
	WebElement ExitBtn;

	public void clickon_ExitBtn() {
		stepstatus = basepage.clickElement(ExitBtn);
		reportEvent(stepstatus, "Able to click Exit Button", "Unable to click Exit Button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='Home']")
	WebElement HomeBtn;

	public void clickon_HomeBtn() {
		stepstatus = basepage.clickElement(HomeBtn);
		reportEvent(stepstatus, "Able to click Home Button", "Unable to click Home Button", driver, true);
	}

}
