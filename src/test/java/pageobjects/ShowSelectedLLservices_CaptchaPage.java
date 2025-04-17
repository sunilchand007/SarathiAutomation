package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;
import utility.Utilitymethods;

public class ShowSelectedLLservices_CaptchaPage extends BasePage {
	WebDriver driver;

	boolean stepstatus;
	
	public ShowSelectedLLservices_CaptchaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'btn_save']")
	WebElement submit;

	public void clickSubmitbutton_aftercapctha() {
		stepstatus = clickElement(submit);
		reportEvent(stepstatus, "Able to click Submitbutton_aftercapctha", "Unable to click Submitbutton_aftercapctha", driver,
				true);
		if(alertExist(driver)) {
			
			acceptAlert(driver);
		}
		else {
			
			System.out.println("There is no alert");
		}
	}
	
}
