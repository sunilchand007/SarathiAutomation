package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class OnlineTestForLLPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	String nextFlow;
	int remainingFlows=0;
	boolean stepstatus;

	public OnlineTestForLLPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}

	@FindBy(how = How.XPATH, using = "//a[text()=' Learner Licence ']")
	WebElement LearnerLicence;

	public void Mouserhoveron_LearnerLicence() {
		stepstatus = basepage.mouseHover(LearnerLicence, driver);
		reportEvent(stepstatus, "Able to do Mousehover action on Learner Licence",
				"Unable to do Mousehover action on Leaner Licence", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//a[text()=' Learner Licence ']/following::a[text()='Online LLTest(STALL)']")
	WebElement OnlineLLTest;

	public void Clickon_OnlineLLTest() {
		stepstatus = basepage.clickElement(OnlineLLTest);
		reportEvent(stepstatus, "Able to click on OnlineLLTest", "Unable to click on OnlineLLTest", driver, true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
