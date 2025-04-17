package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;
import utility.Utilitymethods;

public class ShowSelectedLLservicesPage01 extends BasePage {
	WebDriver driver;

	boolean stepstatus;
	
	public ShowSelectedLLservicesPage01(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='otptext']")
	WebElement Enterotphere;

	public void enterOtp() throws IOException {
		Utilitymethods utility = new Utilitymethods(driver);
		String otp = utility.Getlogotp("OTP (One Time Password) for update details",209,216);
		System.out.println("Otp from log is "+ otp);
		stepstatus = setText(Enterotphere, otp);
		reportEvent(stepstatus, "Able to Enterotp", "Unable to Enter otp", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id = 'otpsubmit']")
	WebElement submit;

	public void clickSubmitbutton_afterOtp() {
		stepstatus = clickElement(submit);
		reportEvent(stepstatus, "Able to click submit button", "Unable to click submit", driver,
				true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id = 'reasonForDuplicateLL']")
	WebElement reasonforduplicateLL;

	public void selectreasonforduplicateLL(String value) {
		stepstatus = setValueInSelectBox(reasonforduplicateLL, value);
		reportEvent(stepstatus, "Able to select reason for duplicate LL ", "Unable to to select reason for duplicate LL", driver,
				true);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'btn_confirm_dupll']")
	WebElement confirmbutton;

	public void clickconfirmbutton_after_selecting_reason() {
		stepstatus = clickElement(confirmbutton);
		reportEvent(stepstatus, "Able to click confirmbutton_after_selecting_reason", "Unable to confirmbutton_after_selecting_reason", driver,
				true);
		
		if(alertExist(driver)) {
			acceptAlert(driver);
		}else {
			
			System.out.println("There is no alert");
		}
	}
}
