package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworkLibrary.BasePage;

public class DLextractDetailsPage extends BasePage {

	WebDriver driver;

	boolean stepstatus;
	
	@FindBy(how = How.XPATH, using = "//input[@name='appno']")
	WebElement DLExtractrePrint_applicationno;

	public void Enter_DLExtractrePrint_applicationno(String data) {
		stepstatus =SetTextAndTAB(DLExtractrePrint_applicationno, data);
		reportEvent(stepstatus, "Able to Enter DLExtractrePrint_applicationno  ", "Unable to Enter DLExtractrePrint_applicationno", driver,
				true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement DLExtractrePrint_Submit;

	public void Clickon_DLExtractrePrint_Submit() {
		stepstatus =clickElement(DLExtractrePrint_Submit);
		reportEvent(stepstatus, "Able to click on DLExtractrePrint_Submit", "Unable to click on DLExtractrePrint_Submit", driver, true);
	}
}
