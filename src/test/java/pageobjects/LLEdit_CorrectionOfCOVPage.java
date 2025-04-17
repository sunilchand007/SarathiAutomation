package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class LLEdit_CorrectionOfCOVPage extends BasePage{

	WebDriver driver;
	boolean stepstatus;
	
	public LLEdit_CorrectionOfCOVPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='corrCovs']")
	WebElement selectAddCov;
	public boolean clickOnSelectAddCov() {
		wait(1);
		return clickElement(selectAddCov);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='addCov']")
	WebElement selectCovWE;
	
	public void selectCov(String cov) {
		scrooldown(driver);
		wait(1);
		stepstatus = setOptionInSelectBox(selectCovWE, cov);
		reportEvent(stepstatus, "Able to select COV", "Unable to select COV", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='addCovButton']")
	WebElement llEditClickOnAddCov;
	public void clickOnAddCov() {
		stepstatus = clickElement(llEditClickOnAddCov);
	
		reportEvent(stepstatus, "Able to click on Add Cov Button", 
				"Unable to click on Add Cov Button", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='leaEditReason']")
	WebElement remarksAdded;
	public void remarksAddedForSubmission(String remarks) {
		stepstatus = setText(remarksAdded, remarks);
		reportEvent(stepstatus, "Able to Enter Remarks", "Unable to Enter Remarks", driver, true);
	}
}
