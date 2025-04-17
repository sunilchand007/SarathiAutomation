package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class LLEdit_CorrectionOfMiscPage extends BasePage{
	WebDriver driver;
	boolean stepstatus;
	BasePage basepage;
	public LLEdit_CorrectionOfMiscPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='qualDesc']")
	WebElement Qualification;
	public void selectQualification(String llEditRtoSelected) {
		stepstatus = basepage.setValueInSelectBox(Qualification, llEditRtoSelected);
		reportEvent(stepstatus, "Able to Select RTO in LL Edit Entry", "Unable to Select RTO in LL Edit Entry", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='bloodGrp']")
	WebElement BloodGrp;
	public void selectBloodGrp(String llEditRtoSelected) {
		stepstatus = basepage.setValueInSelectBox(BloodGrp, llEditRtoSelected);
		reportEvent(stepstatus, "Able to Select RTO in LL Edit Entry", "Unable to Select RTO in LL Edit Entry", driver, true);
	}
	
}
