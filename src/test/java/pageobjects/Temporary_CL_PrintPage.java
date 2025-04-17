package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class Temporary_CL_PrintPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;

	boolean stepstatus;

	public Temporary_CL_PrintPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='Tempclsearch_clsearchopt1']")
	WebElement Application_radiobutton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='webrefnum']")
	WebElement Application_No;

	@FindBy(how = How.XPATH, using = "//input[@id='Tempclsearch_0']")
	WebElement View_Applications_button;
	@FindBy(how = How.XPATH, using = "//*[@id=\"licDetTable\"]/tbody/tr/td[6]/a")
	WebElement CL_Print_Link;
	
	
	public void ProvisionalCL_Print() {
		
		stepstatus = basepage.clickElement(Application_radiobutton);
		reportEvent(stepstatus, "Able to click Application_radiobutton", "Unable to click Application_radiobutton", driver, true);
		stepstatus = basepage.setText(Application_No, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to enter Application_No", "Unable to enter Application_No", driver, true);
		
		stepstatus = basepage.clickElement(View_Applications_button);
		reportEvent(stepstatus, "Able to click View_Applications_button", "Unable to click View_Applications_button", driver, true);
		
		stepstatus = basepage.clickElement(CL_Print_Link);
		reportEvent(stepstatus, "Able to click CL_Print_Link", "Unable to click CL_Print_Link", driver, true);
		
	}
	
	
}
