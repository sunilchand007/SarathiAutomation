package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworkLibrary.BasePage;

public class Dlprint_citizenPage extends BasePage {

	WebDriver driver;
	boolean stepstatus;
	
	@FindBy(how = How.XPATH, using = "//input[@name='applno']")
	WebElement Dlprintapplicationno;

	public void Enter_DLPrint_ApplicationNo(String data) {
		stepstatus =SetTextAndTAB(Dlprintapplicationno, data);
		reportEvent(stepstatus, "Able to Enter Dlprintapplicationno  ", "Unable to Enter Dlprintapplicationno", driver,
				true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='dateOfBirth']")
	WebElement Dlprintdob;

	public void Enter_DLPrint_dob(String data) {
		stepstatus =SetTextAndTAB(Dlprintdob, data);
		reportEvent(stepstatus, "Able to Enter Dlprintdob  ", "Unable to Enter Dlprintdob", driver, true);
	}
	
	

	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement DLPrint_Submit;

	public void Clickon_DLPrint_Submit() {
		stepstatus =clickElement(DLPrint_Submit);
		
		reportEvent(stepstatus, "Able to click on DLPrint_Submit", "Unable to click on DLPrint_Submit", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@value='DL Print']")
	WebElement DLPrint_btn;

	public void Clickon_DLPrint_btn() {
		stepstatus = clickElement(DLPrint_btn);
		reportEvent(stepstatus, "Able to click on DLPrint_btn", "Unable to click on DLPrint_Submit", driver, true);
	}
	
}
