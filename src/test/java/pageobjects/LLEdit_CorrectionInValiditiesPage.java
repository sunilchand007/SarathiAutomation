package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class LLEdit_CorrectionInValiditiesPage extends BasePage{

	WebDriver driver;
	boolean stepstatus;
	
	public LLEdit_CorrectionInValiditiesPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(how = How.XPATH, using = "//*[@id='corrVald']")
	WebElement selectValidities;
	public boolean clickOnSelectChangeInValidities() {
		wait(1);
		return clickElement(selectValidities);
	}


	@FindBy(how = How.XPATH, using = "//*[@id='llFrm']")
	WebElement llValidityFrom;
	public void llFromValidity(String llValidFrom) {
		stepstatus = setText(llValidityFrom, llValidFrom);
		reportEvent(stepstatus, "Able to Enter LL From Validity", "Unable to Enter LL From Validity", driver, true);
	}
	
	public boolean clickOnSelectChangeInVal() {
		wait(1);
		return clickElement(llValidityFrom);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='llTo']")
	WebElement llValidityTo;
	public void llToValidity(String llValidTo) {
		stepstatus = setText(llValidityTo, llValidTo);
		reportEvent(stepstatus, "Able to Enter LL To Validity", "Unable to Enter LL To Validity", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='leaEditReason']")
	WebElement remarksAdded;
	public void remarksAddedForSubmission(String remarks) {
		stepstatus = setText(remarksAdded, remarks);
		reportEvent(stepstatus, "Able to Enter Remarks", "Unable to Enter Remarks", driver, true);
	}
	
}
