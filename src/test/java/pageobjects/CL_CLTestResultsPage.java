package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class CL_CLTestResultsPage extends BasePage {
	
	BasePage basepage = new BasePage();

	WebDriver driver;
	boolean stepstatus;

	public CL_CLTestResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='app_no']")
	WebElement Application_Number;
	public void Set_Application_Number(String value) {
		stepstatus = basepage.setText(Application_Number, value);
		reportEvent(stepstatus, "Able to Enter Application_Number", "Unable to Enter Application_Number", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='fetch']")
	WebElement Fetchbutton;
	public void ClickonFetchbutton() {
		stepstatus = basepage.clickElement(Fetchbutton);
		reportEvent(stepstatus, "Able to click on Fetchbutton", "Unable to click on Fetchbutton", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//select[@name='app_result']")
	WebElement TestResult;
	public void Set_TestResult() {
		stepstatus = basepage.setOptionInSelectBox(TestResult, getdata("TestResult"));
		reportEvent(stepstatus, "Able to Select TestResult", "Unable to Select TestResult", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='llDate']")
	WebElement DateOFCLTest;
	public void Set_DateOF_CLTest() {
		stepstatus = basepage.setText(DateOFCLTest, getdata("DateOF_CLTest"));
		reportEvent(stepstatus, "Able to Enter DateOF_CLTest", "Unable to Enter DateOF_CLTest", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement Submit;
	
	public void ClickonSubmitbutton() {
		stepstatus = basepage.clickElement(Submit);
		reportEvent(stepstatus, "Able to Enter Submit button", "Unable to Enter Submit button", driver, true);
	}
}
