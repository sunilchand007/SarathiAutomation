package pageobjects;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class InstructionsforDLServicePage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public InstructionsforDLServicePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(how = How.XPATH, using = "//input[@value='Continue']")
	WebElement Continue;
	public void Clickon_ContinuebuttoninInstructionsPage() throws IOException, InterruptedException {
		stepstatus = basepage.clickElement(Continue);
		reportEvent(stepstatus, "Able to click on Continue", "Unable to click on Continue", driver, true);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


