package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class ApplicationCancellationPage extends BasePage{

	WebDriver driver;
	BasePage basepage = new BasePage();
	boolean stepstatus;
	
	public ApplicationCancellationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@name='applNum']")
	WebElement Application_Numberr;
	public void Set_Application_Number() {
		stepstatus = basepage.setText(Application_Numberr, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to Enter Application Number ", "Unable to Enter Application Number", driver);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='dateOfBirth']")
	WebElement DateoFBirth;
	public void Set_DateofBirth() {
		stepstatus = basepage.SetTextAndTAB(DateoFBirth, getdata("DateofBirth"));
		reportEvent(stepstatus, "Able to Enter Date of Birth ", "Unable to Enter Date of Birth", driver);
	}

	
	@FindBy(how = How.XPATH, using = "//input[@name = 'captcha']")
	WebElement captcha_applcancellation;
	public void set_captcha_in_applicationcancellation(String text) {
		stepstatus = basepage.SetTextAndTAB(captcha_applcancellation , text);
		reportEvent(stepstatus, "Able to Enter text in captcha field ", "Unable to Enter text in captcha field", driver);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='submit']")
	WebElement Submitbttn;
	public void Clickon_Submit_Button() {
		stepstatus = basepage.clickElement(Submitbttn);
		wait(1);
		scrooldown(driver);
		reportEvent(stepstatus, "Able to click submit button", "Unable to click submit button", driver);
	}
}
