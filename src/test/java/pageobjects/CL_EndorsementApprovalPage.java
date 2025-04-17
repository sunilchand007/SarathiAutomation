package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class CL_EndorsementApprovalPage extends BasePage {
	
	BasePage basepage = new BasePage();
	WebDriver driver;

	boolean stepstatus;

	public CL_EndorsementApprovalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='approveButton']")
	WebElement EndorsementApproval;
	public void Clickon_CL_EndorsementApproval() {
		scrooldown(driver);
		stepstatus = basepage.clickElement(EndorsementApproval);
		reportEvent(stepstatus, "Able to click on Approve", "Unable to click on Approve", driver, true);
		
	}

}
