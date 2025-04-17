package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class DLEndorsementApprove extends BasePage {
	

	WebDriver driver;

	public DLEndorsementApprove(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelementss
	@FindBy(how = How.XPATH, using = "//input[@id='approveBtnid']")
	WebElement Approve;
	boolean stepstatus;

	public void Clickon_Approve() {
		stepstatus = clickElement(Approve);
		reportEvent(stepstatus, "Able to click on Approve button", "Unable to click on Approve button", driver, true);
	}

}
