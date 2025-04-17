package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class ShowSelectedLLservicesPage02 extends BasePage {
	WebDriver driver;

	boolean stepstatus;
	
	public ShowSelectedLLservicesPage02(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(how = How.XPATH, using = "//input[@id= 'addressType1']")
	WebElement present_address_radiobutton;

	public void click_Present_address_radiobutton() {
		stepstatus = clickElement(present_address_radiobutton);
		reportEvent(stepstatus, "Able to click submit button", "Unable to click submit", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='presSubDistrict']")
	WebElement subDistrict;

	public void select_Dropdown_subdistrict(String subdistrict) {
		wait(7);
		stepstatus =setOptionInSelectBox(subDistrict, subdistrict);
		reportEvent(stepstatus, "Able to select subdistrict", "Unable to select subdistrict", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='presLocation']")
	WebElement location;

	public void enterLoacation(String locationtext) {
		wait(5);
		stepstatus = setText(location, locationtext);
		reportEvent(stepstatus, "Able to enter text", "Unable to enter text", driver, true);
	}
	

	@FindBy(how = How.XPATH, using = "//input[@id = 'presPinCode']")
	WebElement pincode;

	public void enterPincode(String pincodetext) {
		stepstatus = setText(pincode, pincodetext);
		reportEvent(stepstatus, "Able to enter pincode", "Unable to enter pincode", driver, true);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'btn_confirm_coa']")
	WebElement confirmbutton;

	public void clickconfirmbutton() {
		stepstatus = clickElement(confirmbutton);
		reportEvent(stepstatus, "Able to enter pincode", "Unable to enter pincode", driver, true);
	}


}
