package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class state_wiseLanguage_reporton_stallconductedPage  extends BasePage {

	
	BasePage basepage = new BasePage();
	WebDriver driver;

	boolean stepstatus;

	public state_wiseLanguage_reporton_stallconductedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'radio22']")
	WebElement clickonFromRadiobutton;

	public void clickon_From_Radiobutton() {
		stepstatus = basepage.clickElement(clickonFromRadiobutton);
		reportEvent(stepstatus, "Able to click on From Radiobutton", "Unable to click on From Radiobutton", driver, true);
	}

	
	@FindBy(how = How.XPATH, using = "//input[@id = 'from']")
	WebElement setfromdate;
	public void setfromdate(String StrValue) {
		stepstatus = basepage.setText(setfromdate, StrValue);
		reportEvent(stepstatus, "Able to setfromdate ", "Unable to set from date ", driver, true);
	}

	
	@FindBy(how = How.XPATH, using = "//input[@id = 'to']")
	WebElement settodate;
	public void settodate(String StrValue) {
		stepstatus = basepage.setText(settodate, StrValue);
		reportEvent(stepstatus, "Able to set to date ", "Unable to set to date ", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='submit']")
	WebElement submitbutton;
	public void clickon_submitbutton() {
		stepstatus = basepage.clickElement(submitbutton);
		reportEvent(stepstatus, "Able to click submit button ", "Unable to click submit button ", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//h3[text() = 'STATE wise Language Report generated for Stall Conducted Between ']")
	WebElement Reportlinkmsg;
	public void getreport_genearted_message() {
		String getreport_genearted_message =  basepage.getLinkText(Reportlinkmsg);
		System.out.println(getreport_genearted_message);
		reportEvent(stepstatus, "Able to click submit button ", "Unable to click submit button ", driver, true);
	}
	
	
}
