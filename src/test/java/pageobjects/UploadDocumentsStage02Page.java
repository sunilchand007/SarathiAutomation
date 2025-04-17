package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class UploadDocumentsStage02Page extends BasePage {

	
	WebDriver driver;

	boolean stepstatus;

	public UploadDocumentsStage02Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(how = How.XPATH, using = "//input[@id='ok']")
	WebElement Ok;

	public void click_on_SubmitButtoninUploadDocument02() {
		stepstatus = clickElement(Ok);
		reportEvent(stepstatus, "Able to click on OkinUploadDocument02 ", "Unable to click on OkButtoninUploadDocument02", driver, true);

	}
}


