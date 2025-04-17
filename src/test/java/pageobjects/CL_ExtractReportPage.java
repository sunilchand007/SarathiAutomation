package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CL_ExtractReportPage extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public CL_ExtractReportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='chooseFlow1']")
	WebElement FlowRadiobtn;

	public void Clickon_FlowRadiobtn() {
		stepstatus = basepage.clickElement(FlowRadiobtn);
		reportEvent(stepstatus, "Able to click FlowRadiobtn Button", "Unable to click FlowRadiobtn Button", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='chooseFlow2']")
	WebElement DirectRadiobtn;

	public void Clickon_DirectRadiobtn() {
		stepstatus = basepage.clickElement(DirectRadiobtn);
		reportEvent(stepstatus, "Able to click DirectRadiobtn Button", "Unable to click DirectRadiobtn Button", driver, true);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='appno']")
	WebElement ApplicationNo;

	public void Enter_ApplicationNo() {
		stepstatus = basepage.setText(ApplicationNo, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to Enter ApplicationNo", "Unable to Enter ApplicationNo", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='clnumber']")
	WebElement CLNo;

	public void Enter_CLNo(String value) {
		stepstatus = basepage.setText(CLNo, value);
		reportEvent(stepstatus, "Able to Enter CLNo", "Unable to Enter CLNo", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement Submitbtn;

	public void Clickon_Submitbtn() {
		stepstatus = basepage.clickElement(Submitbtn);
		reportEvent(stepstatus, "Able to click Submit Button", "Unable to click Submit Button", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@value='Home']")
	WebElement Homebtn;

	public void Clickon_Homebtn() {
		stepstatus = basepage.clickElement(Homebtn);
		reportEvent(stepstatus, "Able to click Home Button", "Unable to click Home Button", driver, true);
	}
	
}
