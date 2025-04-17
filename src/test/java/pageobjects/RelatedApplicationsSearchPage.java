package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworkLibrary.BasePage;

public class RelatedApplicationsSearchPage extends BasePage{
	
	WebDriver driver;

	boolean stepstatus;
	
	@FindBy(how = How.XPATH, using = "//select[@name='relation']")
	WebElement SearchCretiria;

	public void SelectSearchTypee(String Option) {
		stepstatus = setOptionInSelectBox(SearchCretiria, Option);
		reportEvent(stepstatus, "Able to Select SearchCretiria", "Unable to Select SearchCretiria", driver, true);
	}
	

	@FindBy(how = How.XPATH, using = "//input[@name='commonnum']")
	WebElement Type;

	public void Enter_SelectedType(String value) {
		stepstatus =SetTextAndTAB(Type, value);
		reportEvent(stepstatus, "Able to Enter Application/LL/DL Number ", "Unable to Enter Application/LL/DL Number",
				driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='dateOfBirth']")
	WebElement dob;

	public void Enter_Dateofbirth(String value) {
		stepstatus = SetTextAndTAB(dob, value);
		reportEvent(stepstatus, "Able to Enter dob ", "Unable to Enter dob", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement Submit;

	public void Clickon_Submit() {
		stepstatus = clickElement(Submit);
		reportEvent(stepstatus, "Able to click Submit", "Unable to click Submit", driver, true);
	}
}
