package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class NewLLAcknowledgementPage extends BasePage {

	BasePage basepage = new BasePage();

	WebDriver driver;

	boolean stepstatus;

	public NewLLAcknowledgementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(how = How.XPATH, using = "(//button[@id='trsaction_ack_nextStatus'])")
	WebElement clickonNextButton;

	public void click_on_NextButton() {
		stepstatus = basepage.clickElement(clickonNextButton);
		reportEvent(stepstatus, "Able to click on NextButton ", "Unable to click on NextButton", driver, true);

	}
	
	@FindBy(how = How.XPATH, using = "//button[@value = 'Home']")
	WebElement clickonHomeButton;

	public void click_on_HomeButton() {
		stepstatus = basepage.clickElement(clickonHomeButton);
		reportEvent(stepstatus, "Able to click on HomeButton ", "Unable to click on HomeButton", driver, true);

	}
	
	

	public void CaptureDetails() {
		wait(1);
		AppNum = App_NO(driver, "//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]");
		System.out.println(AppNum);
		DOB = DOB(driver, "//table/tbody/tr[2]/td[3]/following-sibling::td");
		System.out.println(DOB);
		String title = driver.getTitle();
		if (title.equals("New LL Acknowledgement")) {
	
			setdata("ApplicationNo", AppNum.substring(3).trim());
			setdata("DateofBirth", DOB.substring(3).trim());
			//NewLLRegistrtionPage.setdata("StatusofApplication", "Success");

		} else {
			System.out.println("New LL Acknowledgement is not Generated");
			///NewLLRegistrtionPage.setdata("StatusofApplication", "Fail");
			driver.close();
		}
	}
}


