package pageobjects;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CommonPortal_ServiceEnablingPage extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;
	Properties prop;

	public CommonPortal_ServiceEnablingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(how = How.XPATH, using = "//a[text()='Switch to']")
	WebElement Switch_to;

	public void Clickon_Switchto() {
		stepstatus = basepage.clickElement(Switch_to);
		reportEvent(stepstatus, "Able to click on Switchto", "Unable to click on Switchto", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='modal-content']/div/div/div/div/a[text()='Common Portal']")
	WebElement CommonPortal;

	public void Navigate_CommonPortal() {
		stepstatus = basepage.clickElement(CommonPortal);
		reportEvent(stepstatus, "Able to click on CommonPortal", "Unable to click on CommonPortal", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Skip']")
	WebElement Skip;

	public void Skip() {
		stepstatus = basepage.clickElement(Skip);
		reportEvent(stepstatus, "Able to click on Skip", "Unable to click on Skip", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Master Management ']")
	WebElement MasterManagement;

	public void HovertoMasterManagement() {
		stepstatus = basepage.mouseHover(MasterManagement, driver);
		reportEvent(stepstatus, "Able to hover on MasterManagement", "Unable to hover on MasterManagement", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Master Management ']/following::ul/li[6]/a")
	WebElement ServiceEnabling;

	public void ClickonServiceEnabling() {
		stepstatus = basepage.clickElement(ServiceEnabling);
		reportEvent(stepstatus, "Able to click on ServiceEnabling", "Unable to click on ServiceEnabling", driver, true);
	}

	public void Enable_Service() {
		List<WebElement> SNO = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		int totalsnos = SNO.size();
		for (int i = 1; i < totalsnos; i++) {
			String servicetxt = driver.findElement(By.xpath("//table/tbody/tr[" + 1 + "+" + i + "]/td[1]")).getText();
			if (servicetxt.equals(getdata("SNO"))) {

				try {
					driver.findElement(By.xpath("//table/tbody/tr[" + 1 + "+" + i + "]/td[4]/input[1]")).click();
					ClickonSave();
					ClickonConfirm();
				} catch (ElementNotInteractableException e) {
					System.out.println("Service not Applicable to Enable");
					setdata("StatusMessage", "Invalid Input");
				}
				break;
			}

		}

	}

	@FindBy(how = How.XPATH, using = "//input[@value='Save']")
	WebElement Save;

	public void ClickonSave() {
		stepstatus = basepage.clickElement(Save);
		reportEvent(stepstatus, "Able to click on Save", "Unable to click on Save", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='CONFIRM']")
	WebElement Confirm;

	@FindBy(how = How.XPATH, using = "//h4[text()='You have choosen the following Services for Enable']")
	WebElement ifenabledmessage;

	@FindBy(how = How.XPATH, using = "//h4[text()='You have not enabled any of the services']")
	WebElement ifnotenabledmessage;

	public void ClickonConfirm() {
		if (isDisplayed(ifenabledmessage) == true) {
			stepstatus = basepage.clickElement(Confirm);
			GetMessage();
			reportEvent(stepstatus, "Able to click on Confirm", "Unable to click on Confirm", driver, true);
		} else if (isDisplayed(ifnotenabledmessage) == true) {
			stepstatus = basepage.clickElement(Confirm);
			GetMessage();
			
		} else {
			System.out.println("Check your input once");
		}

	}

	@FindBy(how = How.XPATH, using = "//h4[normalize-space(text())='Services Enabled Successfully']")
	WebElement Success;

	@FindBy(how = How.XPATH, using = "//h4[@class='text-success bold']")
	WebElement disablingservicemessage;

	public void GetMessage() {

		try {
			if (isDisplayed(Success) == true) {
				setdata("StatusMessage", Success.getText().trim());
			} else if (isDisplayed(disablingservicemessage) == true) {
				setdata("StatusMessage", disablingservicemessage.getText().trim());
			} else {
				setdata("StatusMessage", "Fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
