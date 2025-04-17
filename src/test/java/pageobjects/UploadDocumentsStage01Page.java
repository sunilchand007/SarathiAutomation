package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class UploadDocumentsStage01Page extends BasePage {


	WebDriver driver;

	boolean stepstatus;

	public UploadDocumentsStage01Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(how = How.XPATH, using = "//input[@id='submitbtn']")
	WebElement Submit1;

	public void click_on_SubmitButtoninUploadDocument01() {
		stepstatus = clickElement(Submit1);
		reportEvent(stepstatus, "Able to click on SubmitButtoninUploadDocument01 ", "Unable to click on SubmitButtoninUploadDocument01", driver, true);

	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='method:displayDocuments']")
	WebElement Ok;
	
	public void click_okbutton() {
		
	stepstatus = clickElement(Ok);
	reportEvent(stepstatus, "Able to click on ok button ", "Unable to click on ok button", driver, true);

	}
}


