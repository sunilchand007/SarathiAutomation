package pageobjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;
import utility.Flows;

public class NewDLSubmissionPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;

	boolean stepstatus;

	public NewDLSubmissionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelements
	@FindBy(how = How.XPATH, using = "//span[1][text()='Apply Online']")
	WebElement Applyonline;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Continue']")
	WebElement Contuine;
	@FindBy(how = How.XPATH, using = "//input[@id='learningLicence']")
	WebElement LearnersLicenceNumber;
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement Submit;

	// Related methods to perform operation on webelements
	@FindBy(how = How.XPATH, using = "//select[@name='stName']")
	WebElement Selectstatename;

	public void Selectstatename() throws IOException {

		stcode = getdata("State");
		System.out.println(stcode = getdata("State"));
		if (stcode.equalsIgnoreCase("AN")) {
			stepstatus = basepage.setOptionInSelectBox(Selectstatename, prop.getProperty("AN"));
		} else if (stcode.equalsIgnoreCase("AP")) {
			stepstatus = basepage.setOptionInSelectBox(Selectstatename, prop.getProperty("AP"));
		} else if (stcode.equalsIgnoreCase("AR")) {
			stepstatus = basepage.setOptionInSelectBox(Selectstatename, prop.getProperty("AR"));
		} else {
			System.out.println("Selected State is not available.Please check and Try Again.");
		}

		// stepstatus = basepage.setOptionInSelectBox(Selectstatename, Option);
		reportEvent(stepstatus, "Able to Select Statename", "Unable to Select Statename", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//button[@class='close popupclose']")
	WebElement Displaypop;
	public void Selectstatename(String Option) {
		stepstatus = basepage.setOptionInSelectBox(Selectstatename, Option);
		wait(3);
		if(isDisplayed(Displaypop)==true) {
			Displaypop.click();
			System.out.println("POP-UP Closed");
		}else {
			System.out.println("There is no POP-UP");
		}
		reportEvent(stepstatus, "Able to Select Statename", "Unable to Select Statename", driver, true);
	}


	@FindBy(how = How.XPATH, using = "//select[@name='licenceFromState']")
	WebElement State;

	public void Set_State(String option) {
		stepstatus = basepage.setOptionInSelectBox(State, option);
		reportEvent(stepstatus, "Able to Selected State", "Unable to Selected State", driver, true);
	}

	public void clickonapplyonline() {
		stepstatus = basepage.clickElement(Applyonline);
		reportEvent(stepstatus, "Able to click Apply online Link", "Unable to click Apply online Link", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='New Driving Licence']")
	WebElement NewDrivinglicence;
	public void clickon_NewDrivinglicence() {
		stepstatus = basepage.clickElement(NewDrivinglicence);
		reportEvent(stepstatus, "Able to click NewDrivinglicence Link", "Unable to click NewDrivinglicence Link",
				driver, true);
	}

	public void clickon_Contuinebutton() {
		stepstatus = basepage.clickElement(Contuine);
		ConnecttoExcel(prop.getProperty("eKYC"), prop.getProperty("DataFile_State"));
		if (outcome.equalsIgnoreCase("N")) {
			NewLLSubmissionPage NewLLRegistrtionPage = new NewLLSubmissionPage(driver);
		
		} else if (outcome.equalsIgnoreCase("E")) {
			System.out.println("Processsing Further");
		} else {
			System.out.println("************Before_ApplicationSubmission_Checks_Camp=Y******************");
		}

		reportEvent(stepstatus, "Able to click Contuinebutton", "Unable to click Contuinebutton", driver, true);
	}

	public void Set_LearnersLicenceNumber(String Value) {
		stepstatus = basepage.setText(LearnersLicenceNumber, Value);
		reportEvent(stepstatus, "Able to Enter LearnersLicenceNumber", "Unable to Enter LearnersLicenceNumber", driver,
				true);
	}
	@FindBy(how = How.XPATH, using = "//input[@id='DOB']")
	WebElement DateofBirth;
	public void Set_DateofBirth(String Value) {
		stepstatus = basepage.setText(DateofBirth, Value);
		reportEvent(stepstatus, "Able to Enter DateofBirth", "Unable to Enter DateofBirth", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//input[@name = 'entcaptxt']")
	WebElement captcha;
	public void Set_Captcha(String Value) {
		stepstatus = basepage.SetTextAndTAB(captcha, Value);
		reportEvent(stepstatus, "Able to Enter captcha", "Unable to Enter captcha", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "(//input[@id='ok'])[1]")
	WebElement Ok;
	public void clickon_Okbutton() {
		stepstatus = basepage.clickElement(Ok);
		wait(3);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}
		
	reportEvent(stepstatus, "Able to Click Ok button", "Unable to Click Ok button", driver, true);
	}

	public void clickon_Selectallcheckbox() {
		basepage.scrooldown(driver);
		wait(4);
		stepstatus = basepage.clickElement(Selectall);
		reportEvent(stepstatus, "Able to click Selectallcheckbox", "Unable to click Selectallcheckbox", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='willingToDonatetrue']")
	WebElement Organdonarradio;

	
	public void Verify_OrganDonarRadio_button() {
	/*	if(isSelected(Organdonarradio)==true) {
			System.out.println("Radio button selected");
			
		}else {*/
			stepstatus = basepage.clickElement(Organdonarradio);
		//}
	}
	

	public void clickon_Submitbutton() {
		stepstatus = basepage.clickElement(Submit);
		wait(15);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}
		waitforAlerttobepresent(driver);
	}
	@FindBy(how = How.XPATH, using = "//input[@id='selectAll']")
	WebElement Selectall;
	public void Set_DL_Application_Number() {
		stepstatus = basepage.clickElement(Selectall);
		reportEvent(stepstatus, "Able to click Selectallcheckbox", "Unable to click Selectallcheckbox", driver, true);
	}


	


	/* Menu Item DL Club */

	

	

	
	

	@FindBy(how = How.XPATH, using = "//input[@name='appliNumber']")
	WebElement Dlclubapplicationno;

	public void Enter_DLClub_ApplicationNo() {
		stepstatus = basepage.SetTextAndTAB(Dlclubapplicationno, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to Enter Dlclubapplicationno  ", "Unable to Enter Dlclubapplicationno", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Club']")
	WebElement Clubbtn;

	public void Clickon_Clubbutton() {
		scrooldown(driver);
		stepstatus = basepage.clickElement(Clubbtn);
		if (alertExist(driver)) {
			if (alertGetText(driver)
					.equalsIgnoreCase("LL found for the Non-Base DL number.Do you want to link with DL number")) {
				acceptAlert(driver);

			}
		}

	}

	@FindBy(how = How.XPATH, using = "//input[@value='Approve']")
	WebElement Approvebtn;
	@FindBy(how = How.XPATH, using = "//ul[@class='actionMessage']/li/span")
	WebElement Sucessmesg;

	public void Clickon_Approvebutton() {
		scrooldown(driver);
		stepstatus = basepage.clickElement(Approvebtn);

		if (alertExist(driver)) {
			if (alertGetText(driver)
					.equalsIgnoreCase("LL found for the Non-Base DL number.Do you want to link with DL number")) {
				acceptAlert(driver);
			}

			else if (alertGetText(driver).equalsIgnoreCase("Do you want to link LLs")) {
				acceptAlert(driver);
			} else if (alertGetText(driver).contains("Verify")) {
				acceptAlert(driver);
			}

		}

	}
	
	public void Clickon_Approve() {
		scrooldown(driver);
		stepstatus = basepage.clickElement(Approvebtn);
	}

	public void capturemesg() {
		scrooldown(driver);
		if (isDisplayed(Sucessmesg) == true) {
			setdata("OnDLClubApproveMesg", Sucessmesg.getText().trim());
		}
	}

	/* Menu Item DL Print */




	


	

	
	
	
	/* Menu Item DLExtractrePrint */

	
	
	

	/*Menu Item Driving Licence Test Sheet*/
	

	



	/*Menu Item Driving Licence Test Sheet*/
	


	
	@FindBy(how = How.XPATH, using = "//input[@id='approveButton']")
	WebElement EndorsementApproval;
	public void Clickon_CL_EndorsementApproval() {
		scrooldown(driver);
		stepstatus = basepage.clickElement(EndorsementApproval);
		reportEvent(stepstatus, "Able to click on Approve", "Unable to click on Approve", driver, true);
		
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
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='Tempclsearch_clsearchopt1']")
	WebElement Application_radiobutton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='webrefnum']")
	WebElement Application_No;

	@FindBy(how = How.XPATH, using = "//input[@id='Tempclsearch_0']")
	WebElement View_Applications_button;
	@FindBy(how = How.XPATH, using = "//*[@id=\"licDetTable\"]/tbody/tr/td[6]/a")
	WebElement CL_Print_Link;
	
	
	public void ProvisionalCL_Print() {
		
		stepstatus = basepage.clickElement(Application_radiobutton);
		reportEvent(stepstatus, "Able to click Application_radiobutton", "Unable to click Application_radiobutton", driver, true);
		stepstatus = basepage.setText(Application_No, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to enter Application_No", "Unable to enter Application_No", driver, true);
		
		stepstatus = basepage.clickElement(View_Applications_button);
		reportEvent(stepstatus, "Able to click View_Applications_button", "Unable to click View_Applications_button", driver, true);
		
		stepstatus = basepage.clickElement(CL_Print_Link);
		reportEvent(stepstatus, "Able to click CL_Print_Link", "Unable to click CL_Print_Link", driver, true);
		
	}
	
	
	
}