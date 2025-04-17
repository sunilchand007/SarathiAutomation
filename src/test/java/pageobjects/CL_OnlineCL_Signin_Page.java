package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CL_OnlineCL_Signin_Page extends BasePage{
	
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public CL_OnlineCL_Signin_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='CL Application Number']")
	WebElement CL_ApplicationNumber ;
	
	public void Enter_CL_ApplicationNumber(String value) {
		stepstatus = basepage.setText(CL_ApplicationNumber, value);
		reportEvent(stepstatus, "Able to Enter CL_ApplicationNumber", "Unable to Enter CL_ApplicationNumber", driver, true);
		
	}
	
	@FindBy(how=How.XPATH, using = "//input[@id='entcaptxt']")
	WebElement Captcha;
	public void Enter_Captcha(String value) {
		stepstatus = basepage.setText(Captcha, value);
		reportEvent(stepstatus, "Able to Enter Captcha", "Unable to Enter Captcha", driver, true);
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement Submit;
	public void Clickon_Submit() {
		stepstatus = basepage.clickElement(Submit);
		reportEvent(stepstatus, "Able to click Submit button ", "Unable to click Submit button ", driver, true);
		
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}
		
	    reportEvent(stepstatus, "Able to Click Ok button", "Unable to Click Ok button", driver, true);
	}
	
	
}
