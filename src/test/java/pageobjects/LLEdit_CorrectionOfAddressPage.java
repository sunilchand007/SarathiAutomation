package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class LLEdit_CorrectionOfAddressPage extends BasePage{
	
	WebDriver driver;
	boolean stepstatus;
	
	public LLEdit_CorrectionOfAddressPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='corrAddr']")
	WebElement selectChangeOfAddress;
	public boolean clickOnCorrectionOfAddressCheckbox() {
		wait(1);
		return clickElement(selectChangeOfAddress);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='permState']")
	WebElement selectPermState;
	
	public void selectPermAddrModifiedState(String value) {
		scrooldown(driver);
		wait(1);
		stepstatus = setValueInSelectBox(selectPermState, value);
		reportEvent(stepstatus, "Able to select State for permanent Address ", "Unable to select State for permanent Address", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='permDist']")
	WebElement selectPermDist;
	
	public void selectPermAddrModifiedDist(String value) {
		scrooldown(driver);
		wait(1);
//		stepstatus = setOptionInSelectBox(selectCopyOfPermAddr, value);
		stepstatus = setValueInSelectBox(selectPermDist, value);
		reportEvent(stepstatus, "Able to select District for permanent Address ", "Unable to select District for permanent Address", driver, true);
	}

	
	@FindBy(how = How.XPATH, using = "//select[@id='permMandal']")
	WebElement selectPermSubDist;
	
	public void selectPermAddrModifiedSubDist(String value) {
		scrooldown(driver);
		wait(1);
		stepstatus = setValueInSelectBox(selectPermSubDist, value);
//		stepstatus = setIndexValueInSelectBox(selectPermSubDist, Integer.parseInt(value));
		reportEvent(stepstatus, "Able to select Sub District for permanent Address ", "Unable to select Sub District for permanent Address", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='prmAddr3']")
	WebElement permAddr3;
	public void permAddress(String address) {
		stepstatus = setText(permAddr3, address);
		reportEvent(stepstatus, "Able to Enter Permanent Address", "Unable to Enter Permanent Address", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='permDoorNo']")
	WebElement houseNumber;
	public void permHouseNumber(String houseNum) {
		stepstatus = setText(houseNumber, houseNum);
		reportEvent(stepstatus, "Able to Enter Permanent House Number", "Unable to Enter Permanent House Number", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='permStreet']")
	WebElement permStreet;
	public void permStreet(String street) {
		stepstatus = setText(permStreet, street);
		reportEvent(stepstatus, "Able to Enter Permanent Street", "Unable to Enter Permanent Street", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='permPincode']")
	WebElement permPincode;
	public void permPincode(String pincode) {
		stepstatus = setText(permPincode, pincode);
		reportEvent(stepstatus, "Able to Enter Permanent Pincode", "Unable to Enter Permanent Pincode", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='sameasperm']")
	WebElement selectCopyOfPermAddr;
	public void clickOnPermanentAddressCheckbox() {
		scrooldown(driver);
		wait(1);
		stepstatus = clickElement(selectCopyOfPermAddr);
		reportEvent(stepstatus, "Able to click on Same as Permanent Address checkbox",
				"Unable to click on Same as Permanent Address checkbox", driver, true);
		
	}
	

	@FindBy(how = How.XPATH, using = "//*[@id='leaEditReason']")
	WebElement remarksAdded;
	public void remarksAddedForSubmission(String remarks) {
		stepstatus = setText(remarksAdded, remarks);
		reportEvent(stepstatus, "Able to Enter Remarks", "Unable to Enter Remarks", driver, true);
	}

	
}
