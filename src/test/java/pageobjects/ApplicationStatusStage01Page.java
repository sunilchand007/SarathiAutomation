package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class ApplicationStatusStage01Page extends BasePage {


	WebDriver driver;

	boolean stepstatus;

	public ApplicationStatusStage01Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='applNum']")
	WebElement Application_Number;

	public void Set_Application_Number(String ApplicationNo) {
		String existingText = Application_Number.getAttribute("value");
		if(existingText.isEmpty()) {
			stepstatus = setText(Application_Number, ApplicationNo);
			reportEvent(stepstatus, "Able to Enter Application Number ", "Unable to Enter Application Number", driver);
		}else {
			
			System.out.println("Text field already contains text: " + existingText + ". No action taken.");
		}
		
	}

	@FindBy(how = How.XPATH, using = "//input[@name='dateOfBirth']")
	WebElement DateofBirth;

	public void Set_DateofBirth(String DOB ) {
		String existingText = DateofBirth.getAttribute("value");
		if(existingText.isEmpty()) {
		stepstatus = SetTextAndTAB(DateofBirth, DOB);
		reportEvent(stepstatus, "Able to Enter Date of Birth ", "Unable to Enter Date of Birth", driver);
		}else {
			
			System.out.println("Text field already contains text: " + existingText + ". No action taken.");

		}
	}

	@FindBy(how = How.XPATH, using = "//input[@id='submit']")
	WebElement Submit;

	public void Clickon_Submit_Button() {
		stepstatus = clickElement(Submit);
		reportEvent(stepstatus, "Able to click submit button", "Unable to click submit button", driver);
		// wait(10);
		// scrooldown(driver);

	}

	@FindBy(how = How.XPATH, using = "//input[@id = 'entcaptxt']")
	WebElement captcha;

	public void enterCaptcha(String text) {
		stepstatus = setText(captcha, text);
		reportEvent(stepstatus, "Able enter captcha", "Unable to enter captcha", driver, true);

	}
	
	public void enterdetails_In_Applicationstaus() {
		
		Set_Application_Number(getdata("ApplicationNo"));
		Set_DateofBirth(getdata("DOB"));
		enterCaptcha("123456");
		Clickon_Submit_Button();
	}

}
