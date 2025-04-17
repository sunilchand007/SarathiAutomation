package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CL_CLApprovalPage extends BasePage{
	
	BasePage basepage = new BasePage();

	WebDriver driver;
	boolean stepstatus;

	public CL_CLApprovalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='applicationNumber']")
	WebElement Application_Number;
	public void Set_Application_Number(String value) {
		stepstatus = basepage.setText(Application_Number, value);
		reportEvent(stepstatus, "Able to Enter Application_Number", "Unable to Enter Application_Number", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='proceed']")
	WebElement Proceedbutton;
	public void Clickon_Proceedbutton() {
		stepstatus = basepage.clickElement(Proceedbutton);
		reportEvent(stepstatus, "Able to click on Proceedbutton", "Unable to click on Proceedbutton", driver, true);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='Approve']")
	WebElement Approvebutton;
	public void Clickon_Approvebutton() {
		stepstatus = basepage.clickElement(Approvebutton);
		reportEvent(stepstatus, "Able to click on Proceedbutton", "Unable to click on Proceedbutton", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='pending']")
	WebElement PendingForWantOfbutton;
	public void ClickonPendingForWantOfbutton() {
		stepstatus = basepage.clickElement(PendingForWantOfbutton);
		reportEvent(stepstatus, "Able to click on PendingForWantOfbutton", "Unable to click on PendingForWantOfbutton", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='Reject']")
	WebElement Rejectbutton;
	public void ClickonRejectbutton() {
		stepstatus = basepage.clickElement(Rejectbutton);
		reportEvent(stepstatus, "Able to click on Rejectbutton", "Unable to click on Rejectbutton", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='Exit']")
	WebElement Exitbutton;
	public void ClickonExitbutton() {
		stepstatus = basepage.clickElement(Rejectbutton);
		reportEvent(stepstatus, "Able to click on Rejectbutton", "Unable to click on Rejectbutton", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='Home']")
	WebElement Homebutton;
	public void ClickonHomebutton() {
		stepstatus = basepage.clickElement(Homebutton);
		reportEvent(stepstatus, "Able to click on Homebutton", "Unable to click on Homebutton", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='pendingList']")
	WebElement PendingForWantOfdropdown;
	public void Set_PendingForWantOfdropdown(String option) {
		stepstatus = basepage.setOptionInSelectBox(PendingForWantOfdropdown, option);
		reportEvent(stepstatus, "Able to Select TestResult", "Unable to Select TestResult", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='addToRightLabel']")
	WebElement PendingForWantOf_PutUpbutton;
	public void Clickon_PendingForWantOf_PutUpbutton() {
		stepstatus = basepage.clickElement(PendingForWantOf_PutUpbutton);
		reportEvent(stepstatus, "Able to click on PendingForWantOf_PutUpbutton", "Unable to click on PendingForWantOf_PutUpbutton", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='addToLeftLabel']")
	WebElement PendingForWantOf_PutBackbutton;
	public void Clickon_PendingForWantOf_PutBackbutton() {
		stepstatus = basepage.clickElement(PendingForWantOf_PutBackbutton);
		reportEvent(stepstatus, "Able to click on PendingForWantOf_PutUpbutton", "Unable to click on PendingForWantOf_PutUpbutton", driver, true);
	}
	
	
	
	
	
	
	
	
}
