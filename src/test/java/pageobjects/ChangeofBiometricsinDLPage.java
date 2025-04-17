package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class ChangeofBiometricsinDLPage extends BasePage {

	WebDriver driver;
	boolean stepstatus;


	public ChangeofBiometricsinDLPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='cobreasoncd']")
	WebElement ReasonforChange;
	@FindBy(how = How.XPATH, using = "//INPUT[@VALUE='Confirm']")
	WebElement CONFIRM;

	public void SelectReasonforChangeofBiometrics() {
		wait(2);
		ReasonforChange.click();
		
		stepstatus =setOptionInSelectBox(ReasonforChange,
				prop.getProperty(getdata("ReasonforChangeofBiometrics")));
		reportEvent(stepstatus, "Able to Select ReasonforChangeofBiometrics",
				"Unable to Select ReasonforChangeofBiometrics", driver, true);
	}

	public void ClickonCONFIRM() {
		stepstatus =clickElement(CONFIRM);
	}
	
	public void SelectReasonforChangeofBiometrics2(String Option) {
		stepstatus =setOptionInSelectBox(ReasonforChange, Option);
		
		reportEvent(stepstatus, "Able to Select ReasonforChangeofBiometrics", "Unable to Select ReasonforChangeofBiometrics", driver, true);
	}
}
