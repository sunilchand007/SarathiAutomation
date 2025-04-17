package pageobjects;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;
import utility.Flows;




public class Temporary_CL_ApprovalPage extends BasePage {
	
	BasePage basepage = new BasePage();
	WebDriver driver;
    boolean stepstatus;

	public Temporary_CL_ApprovalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how = How.XPATH, using = "//input[@id='Approve']")
	WebElement TemporaryCL_Approve;
	@FindBy(how = How.XPATH, using = "//input[@id='applicationNumber']")
	WebElement App_No;
	@FindBy(how = How.XPATH, using = "//input[@id='proceed']")
	WebElement Proceed_button;
	
	
	public void TemporaryCL_Approval() throws IOException, InterruptedException {
		stepstatus = basepage.setText(App_No, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to enter application number ", "Unable to enter application number", driver, true);
        stepstatus = basepage.clickElement(Proceed_button);
		reportEvent(stepstatus, "Able to click on Proceed button", "Unable to click on Proceed button", driver, true);
		stepstatus = basepage.clickElement(TemporaryCL_Approve);
		reportEvent(stepstatus, "Able to click on Temporary CL Approve button", "Unable to click on Temporary CL Approve button", driver, true);
		wait(2);
		if(driver.getPageSource().contains("Police verification details not available cannot proceed")) {
			Police_Verification_Details();
			}
		else {
			System.out.println("There is no Police Verification for Temporary CL");
			
		}
	}
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='General']")
	WebElement General_menu;
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='POLICE VERIFICATION']")
	WebElement PoliceVerification;
	@FindBy(how = How.XPATH, using = "//input[@id='applicationNumber']")
	WebElement Application_Number;
	@FindBy(how = How.XPATH, using = "//body/div[@class='main']/div[@class='container padding0px']/div[@id='bdheight']/form[@id='policeVerif']/div[@class='panel panel-primary']/div[@class='panel-body']/div[@class='col-md-12 padding0px']/fieldset[@class='scheduler-border']/div[@class='col-md-12 top-space']/button[1]")
	WebElement GetDetails_button;
	@FindBy(how = How.XPATH, using = "//input[@id='policetoken']")
	WebElement Token_Number;
	@FindBy(how = How.XPATH, using = "//input[@id='verifyDate']")
	WebElement Police_Verified_Date;
	@FindBy(how = How.XPATH, using = "//select[@id='verifystatus']")
	WebElement Verification_Result;
	@FindBy(how = How.XPATH, using = "//div[@class='col-md-2 text-center']//button[@id='llDetails']")
	WebElement Submit_button;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='POLICE VERIFICATION']")
	WebElement PoliceVerification_button;
	@FindBy(how = How.XPATH, using = "//input[@id='policeVerif_0']")
	WebElement exit;
	
	
	public void Police_Verification_Details() throws IOException, InterruptedException {
//		stepstatus = basepage.setOptionInSelectBox(General_button, "POLICE VERIFICATION");
//		reportEvent(stepstatus, "Able to select Police verification option", "Unable to select Police verification option", driver, true);
		
		stepstatus = basepage.clickElement(General_menu);
		reportEvent(stepstatus, "Able to Click on General_button", "Unable to Click on General_button", driver, true);
		
		stepstatus = basepage.clickElement(PoliceVerification);
		reportEvent(stepstatus, "Able to Click on PoliceVerification button", "Unable to Click on PoliceVerification button", driver, true);
		
		
		stepstatus = basepage.setText(Application_Number, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to enter application number", "Unable to enter application number", driver, true);
		
		stepstatus = basepage.clickElement(GetDetails_button);
		reportEvent(stepstatus, "Able to Click on GetDetails_button ", "Unable to Click on GetDetails_button ", driver, true);
		
		stepstatus = basepage.setText(Token_Number, getdata("TokenNumber"));
		reportEvent(stepstatus, "Able to enter Token number", "Unable to enter Token number", driver, true);
		
		stepstatus = basepage.setText(Police_Verified_Date, getdata("PoliceVerifiedDate"));
		reportEvent(stepstatus, "Able to enter PoliceVerifiedDate", "Unable to enter PoliceVerifiedDate", driver, true);
		
		stepstatus = basepage.setOptionInSelectBox(Verification_Result,"Yes");
		reportEvent(stepstatus, "Able to select Verification Result Yes/NO", "Unable to select Verification Result Yes/NO", driver, true);
		
		stepstatus = basepage.clickElement(Submit_button);
		reportEvent(stepstatus, "Able to Click on submit button", "Unable to Click on submit button", driver, true);
		
		stepstatus = basepage.clickElement(exit);
		reportEvent(stepstatus, "Able to click exit", "Unable to click exit", driver, true);
		Flows flow = new Flows(driver);
		flow.RTOLevel_Status();
		
		}
	
	
}
