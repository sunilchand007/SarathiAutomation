package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class Commom_RTO_Menu extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public Commom_RTO_Menu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Misc ')]")
	WebElement clickonmisc;

	public void Clickon_Misc() {
		if (driver.getPageSource().contains("Misc")) {
			stepstatus = basepage.clickElement(clickonmisc);
			reportEvent(stepstatus, "Able to clickonmisc", "Unable to click on misc", driver, true);
		} else {
			System.out.println("There is Misc menu");
		}
	}

	@FindBy(how = How.XPATH, using = "//a[text()='APPLICATION STATUS']")
	WebElement clickonapplicationstatus;

	public void Click_on_applicationstatus() {
		wait(5);
		stepstatus = basepage.clickElement(clickonapplicationstatus);
		reportEvent(stepstatus, "Able to clickonapplicationstatus", "Unable to click on applicationstatus", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "(//input[@name='papplno'])[1]")
	WebElement setapplno;

	public void EnterApplicationNumber(String value) {
		stepstatus = basepage.setText(setapplno, value);
		reportEvent(stepstatus, "Able to set text", "Unable to set text", driver, true);
	}

	@FindBy(how = How.XPATH, using = "(//input[@name='View Flows'])")
	WebElement clickonviewflows;

	public void Click_on_viewflows() {
		if (isEnabled(clickonviewflows) == true) {
			stepstatus = basepage.clickElement(clickonviewflows);
			reportEvent(stepstatus, "Able to click on view flows ", "Unable to click on view flows", driver, true);
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Process Flow']")
	WebElement clickonprocessflows;

	public void Click_on_processflow() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", clickonprocessflows);
		wait(2);
		stepstatus = basepage.clickElement(clickonprocessflows);
		reportEvent(stepstatus, "Able to click on process flows ", "Unable to click on process flows", driver, true);
	}

}
