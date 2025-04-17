package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworkLibrary.BasePage;

public class DLclubbingPage extends BasePage{
	WebDriver driver;
	boolean stepstatus;
	
	@FindBy(how = How.XPATH, using = "//select[@name='stateSelected']")
	WebElement selectst;

	public void select_State(String Option) {
		stepstatus = setOptionInSelectBox(selectst, Option);
		reportEvent(stepstatus, "Able to select State", "Unable to select state", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='rtoSelected']")
	WebElement rto;

	public void select_RTO(String Option) {
		stepstatus = setValueInSelectBox(rto, Option);
		reportEvent(stepstatus, "Able to select rto", "Unable to select rto", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='licNo1']")
	WebElement LIC1;

	public void Enter_Licnoone(String data) {
		stepstatus = SetTextAndTAB(LIC1, data);
		reportEvent(stepstatus, "Able to Enter LIC1  ", "Unable to Enter LIC1", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='licNo2']")
	WebElement LIC2;

	public void Enter_Licnotwo(String data) {
		stepstatus = SetTextAndTAB(LIC2, data);
		reportEvent(stepstatus, "Able to Enter LIC2  ", "Unable to Enter LIC2", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement Submitbtn;
	


	public void Clickon_Submitbutton() {
		stepstatus = clickElement(Submitbtn);
		wait(3);
		if (alertExist(driver)) {
			if (alertGetText(driver).equalsIgnoreCase(
					"The DL Numbers mentioned seem to be of different persons. Do you Want to Continue !")) {
				acceptAlert(driver);
			} else if (alertGetText(driver).equalsIgnoreCase("")) {
				acceptAlert(driver);
			} else {
				System.out.println("New Alert Text is found");
			}

		}
		if (alertExist(driver)) {
			acceptAlert(driver);
		}
		wait(2);
		Clickon_Confirmbutton();
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='dlClubConfirmButton']")
	WebElement Confirmbtn;

	public void Clickon_Confirmbutton() {
		JsScrollToWebElement(Confirmbtn, driver);
		JsclickElement(Confirmbtn, driver);
		wait(2);
		if (alertExist(driver)) {
			acceptAlert(driver);
		}
	}
}
