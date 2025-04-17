package pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class EndorsementToDriveInHillRegionDLPage extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;


	public EndorsementToDriveInHillRegionDLPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='hillcertificate']")
	WebElement HillCertificateNumber;
	@FindBy(how = How.XPATH, using = "//select[@id='hilldrivingschool']")
	WebElement IssuedBy;
	@FindBy(how = How.XPATH, using = "//INPUT[@VALUE='Confirm']")
	WebElement CONFIRM;
	@FindBy(how = How.XPATH, using = "//input[@name='hillissueDate']")
	WebElement calendarElement;
	@FindBy(how = How.XPATH, using = "//a[text()='1']")
	WebElement dateElement;

	public void Enter_HillCertificateNumber() {
		stepstatus = basepage.SetTextAndTAB(HillCertificateNumber, getdata("CertificateNo"));
		reportEvent(stepstatus, "Able to Enter HillCertificateNumber ", "Unable to Enter HillCertificateNumber", driver,
				true);
	}

	public void selectDate() {
		stepstatus = basepage.clickElement(calendarElement);
		wait(2);
		stepstatus = basepage.clickElement(dateElement);
		reportEvent(stepstatus, "Able to Click On Date", "Unable to Click On Date", driver, true);
	}

	public void IssuedBy() throws Exception {
		
		stepstatus = basepage.clickElement(IssuedBy);
		reportEvent(stepstatus, "Able to Click IssuedBy", "Unable to Click IssuedBy", driver, true);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        wait(3);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
		wait(3);
	}

	public void ClickonCONFIRM() {
		stepstatus = basepage.clickElement(CONFIRM);
		reportEvent(stepstatus, "Able to Click On Confirm", "Unable to Click On Confirm", driver, true);
	}
}
