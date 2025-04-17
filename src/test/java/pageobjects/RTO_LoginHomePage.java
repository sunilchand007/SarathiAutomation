package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class RTO_LoginHomePage extends BasePage {
	WebDriver driver;
	
	boolean stepstatus;
	
	public RTO_LoginHomePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Misc ']")
	WebElement clickonmisc;

	public void Clickon_Misc() {
		if (driver.getPageSource().contains("Misc")) {
			stepstatus = clickElement(clickonmisc);
			reportEvent(stepstatus, "Able to clickonmisc", "Unable to click on misc", driver, true);
		} else {
			System.out.println("There is Misc menu");
		}
	}

	@FindBy(how = How.XPATH, using = "//a[text()='APPLICATION STATUS']")
	WebElement clickonapplicationstatus;

	public void Click_on_applicationstatus() {
		wait(2);
		stepstatus = clickElement(clickonapplicationstatus);
		reportEvent(stepstatus, "Able to clickonapplicationstatus", "Unable to click on applicationstatus", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "(//input[@name='papplno'])[1]")
	WebElement setapplno;

	public void EnterApplicationNumber(String ApplicationNo) {
		stepstatus = setText(setapplno, ApplicationNo);
		reportEvent(stepstatus, "Able to set text", "Unable to set text", driver, true);
	}

	@FindBy(how = How.XPATH, using = "(//input[@name='View Flows'])")
	WebElement clickonviewflows;

	public void Click_on_viewflows() {
		if (isEnabled(clickonviewflows) == true) {
			stepstatus = clickElement(clickonviewflows);
			reportEvent(stepstatus, "Able to click on view flows ", "Unable to click on view flows", driver, true);
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Process Flow']")
	WebElement clickonprocessflows;

	public void Click_on_processflow() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", clickonprocessflows);
		wait(2);
		stepstatus = clickElement(clickonprocessflows);
		reportEvent(stepstatus, "Able to click on process flows ", "Unable to click on process flows", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li[3]/a")
	WebElement Stall;

	public void Clickon_Stall() {
		stepstatus = clickElement(Stall);
		reportEvent(stepstatus, "Able to click on Stall", "Unable to click on Stall", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//a[text()='PICK  CANDIDATE FOR LL TEST']")
	WebElement PickCandidate;

	public void Clickon_PickCandidate_for_LLTest() {
		stepstatus = clickElement(PickCandidate);
		reportEvent(stepstatus, "Able to click on PickCandidate for LL Test",
				"Unable to click on PickCandidate for LL Test", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//a[text()='DISPLAY LL TEST PASSWORD']")
	WebElement DisplayLLTestPassword;

	public void Clickon_DisplayLLTestPassword() {
		stepstatus = clickElement(DisplayLLTestPassword);
		reportEvent(stepstatus, "Able to click on DisplayLLTestPassword for LL Test",
				"Unable to click on DisplayLLTestPassword for LL Test", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[text() = 'Reports ']")
	WebElement clickonreports;

	public void Clickon_Reports() {
		stepstatus = clickElement(clickonreports);
		reportEvent(stepstatus, "Able to click on Reports", "Unable to click on Reports", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//a[text() = 'DL REDISPATCH REPORT']")
	WebElement clickon_DL_Redispatch_Report;

	public void clickon_DL_Redispatch_Report() {
		stepstatus = clickElement(clickonreports);
		reportEvent(stepstatus, "Able to click on DLRedispatchReport", "Unable to click on DLRedispatchReport", driver, true);
	}
	

	@FindBy(how = How.XPATH, using = "//a[text() = 'LANGWISE STALL CONDUCT - RTO']")
	WebElement LANGWISESTALLCONDUCTRTO;

	public void clickon_languagewise_stallconduct_rto() {
		stepstatus = clickElement(LANGWISESTALLCONDUCTRTO);
		reportEvent(stepstatus, "Able to clickon_LANGWISE_STALLCONDUCT_RTO", "Unable to clickon_LANGWISE_STALLCONDUCT_RTO", driver, true);
	}
	

	@FindBy(how = How.XPATH, using = "//a[text() = 'LANGWISE STALL CONDUCT - STATE']")
	WebElement LANGWISESTALLCONDUCTSTATE;

	public void clickon_languagewise_stallconduct_state() {
		stepstatus = clickElement(LANGWISESTALLCONDUCTSTATE);
		reportEvent(stepstatus, "Able to click on languagewise stall conducted state ", "Unable to click on languagewise state ", driver, true);
	}
	
}
