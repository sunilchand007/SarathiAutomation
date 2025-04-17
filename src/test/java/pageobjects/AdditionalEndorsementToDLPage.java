package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class AdditionalEndorsementToDLPage extends BasePage {

		
		WebDriver driver;
		boolean stepstatus;
	
		public AdditionalEndorsementToDLPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(how = How.XPATH, using = "//input[@id='addcovdet']")
		WebElement LLNumCheckBox;
		@FindBy(how = How.XPATH, using = "//INPUT[@VALUE='Confirm']")
		WebElement CONFIRM;
		
		public void LLNumCheckBox() {
			stepstatus = clickElement(LLNumCheckBox);
			reportEvent(stepstatus, "Able to Click On LLNumCheckBox", "Unable to Click On LLNumCheckBox", driver, true);
		}
		
		public void ClickonCONFIRM() {
			stepstatus = clickElement(CONFIRM);
			reportEvent(stepstatus, "Able to Click On Confirm", "Unable to Click On Confirm", driver, true);
		}
}
