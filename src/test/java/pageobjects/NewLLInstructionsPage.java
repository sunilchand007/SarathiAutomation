package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class NewLLInstructionsPage extends BasePage {


	WebDriver driver;

	boolean stepstatus;

	public NewLLInstructionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelements
	@FindBy(how = How.XPATH, using = "//input[@value='Continue']")
	WebElement Continue;

	public void clickonContinue() {
		stepstatus = clickElement(Continue);
		reportEvent(stepstatus, "Able to click Continue Button ", "Unable to click Continue Button", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@value='Home']")
	WebElement Homebutton;

	public void CheckHomebuttonisEnabled() {
		stepstatus = isEnabled(Homebutton);
		reportEvent(stepstatus, "Able to click Homebutton and it is Enabled ",
				"Unable to click Homebutton and it is not Enabled", driver, true);
	}
	

}
