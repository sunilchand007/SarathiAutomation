package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class DisplayLLServicesPage extends BasePage {
	WebDriver driver;

	boolean stepstatus;
	

	public DisplayLLServicesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@name='llNumber']")
	WebElement LearnersLicencenumber;

	public void SetTextinLearnersLicencenumber(String Value) {
		stepstatus = setText(LearnersLicencenumber, Value);
		reportEvent(stepstatus, "Able to Enter LearnersLicencenumber", "Unable to Enter LearnersLicencenumber", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//*[@name='dateOfBirth']")
	WebElement DateofBirth;

	public void SetTextinDateofBirth(String Value) {
		stepstatus = setText(DateofBirth, Value);
		reportEvent(stepstatus, "Able to Enter DateofBirth", "Unable to Enter DateofBirth", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@value='Proceed']")
	WebElement Proceed;

	public void ClickonProceedbutton() {
		stepstatus = clickElement(Proceed);
		reportEvent(stepstatus, "Able to click on Proceed", "Unable to click on Proceed", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='btn_confirm']")
	WebElement Confirm;

	public void ClickonConfirmbtn() throws IOException {
		wait(5);
		stepstatus = clickElement(Confirm);
		 reportEvent(stepstatus, "Able to click on Confirm", "Unable to click on  Confirm", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='btn_go']")
	WebElement Go;

	public void ClickonGobutton() {
		wait(5);
		stepstatus = clickElement(Go);
		reportEvent(stepstatus, "Able to click on Gobutton", "Unable to click on Gobutton", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[text()='CHANGE OF ADDRESS IN LL']/preceding::input[2]")
	WebElement ChangeofAddressinLL;

	public void clickChangeofAddressinLLCheckbox() {

		stepstatus = clickElement(ChangeofAddressinLL);
		reportEvent(stepstatus, "Able to click on ChangeofAddressinLL", "Unable to click on ChangeofAddressinLL",
				driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[text()='DUPLICATE LL']/preceding::input[2]")
	WebElement duplicateLL;

	public void clickDuplicateLLinLLCheckbox() {

		stepstatus = clickElement(duplicateLL);
		reportEvent(stepstatus, "Able to click on duplicateLL", "Unable to click on duplicateLL",
				driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[text()='CHANGE OF NAME IN LL']/preceding::input[2]")
	WebElement changeofnameinLL;

	public void clickchangeofnameLLinLLCheckbox() {

		stepstatus = clickElement(changeofnameinLL);
		reportEvent(stepstatus, "Able to click on change of name in LL", "Unable to click on change of name inLL",
				driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='btn_submit']")
	WebElement SubmitbuttoninSelectService;

	public void ClickonSubmitbuttoninSelectService() {
		stepstatus = clickElement(SubmitbuttoninSelectService);
		reportEvent(stepstatus, "Able to click on SubmitbuttoninSelectService",
				"Unable to click on SubmitbuttoninSelectService", driver, true);
		if(alertExist(driver)) {
			acceptAlert(driver);
		}else {
			
			System.out.println("There is no alert");
		}
		
	}
}
