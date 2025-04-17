package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CL_ExtractApprovalPage extends BasePage{

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public CL_ExtractApprovalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='approve']")
	WebElement SubmitorPrintbtn;

	public void Clickon_SubmitorPrintbtn() {
		stepstatus = basepage.clickElement(SubmitorPrintbtn);
		reportEvent(stepstatus, "Able to click SubmitorPrint Button", "Unable to click SubmitorPrint Button", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='approve']")
	WebElement Homebtn;

	public void Clickon_Homebtn() {
		stepstatus = basepage.clickElement(SubmitorPrintbtn);
		reportEvent(stepstatus, "Able to click Home Button", "Unable to click Home Button", driver, true);
	}
	
}
