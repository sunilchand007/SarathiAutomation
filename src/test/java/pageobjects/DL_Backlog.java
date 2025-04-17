package pageobjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import frameworkLibrary.BasePage;
import utility.Flows;
import utility.Utilitymethods;

public class DL_Backlog extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;
	Utilitymethods utilitymethods;

	public DL_Backlog(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelementss
	@FindBy(how = How.XPATH, using = "//input[@name='username']")
	WebElement Username;
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement Password;
	@FindBy(how = How.XPATH, using = "//input[@id='frmsubmt']")
	WebElement Next;
	@FindBy(how = How.XPATH, using = "//input[@name='logmode']")
	WebElement Captcha;
	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	WebElement submit;
	@FindBy(how = How.XPATH, using = "//input[@id='crd1']")
	WebElement Radio;
	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	WebElement login;

	// @FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li[4]/a")
	// WebElement DL;
	@FindBy(how = How.XPATH, using = "//a[text()='DL ']")
	WebElement DL;
	@FindBy(how = How.XPATH, using = "//a[text()='DL BACKLOG']")
	WebElement DLBacklog;
	@FindBy(how = How.XPATH, using = "//input[@id='dlIssueDate']")
	WebElement Firstissuedate;
	@FindBy(how = How.XPATH, using = "//input[@id='ndlNo']")
	WebElement NumaricLLno;
	@FindBy(how = How.XPATH, using = "//input[@id='odlNo']")
	WebElement OriginalDLno;
	@FindBy(how = How.XPATH, using = "//input[@name='lastEndDate']")
	WebElement Lasttransdate;

	@FindBy(how = How.XPATH, using = "//input[@id='fname']")
	WebElement Name;
	@FindBy(how = How.XPATH, using = "//input[@id='mname']")
	WebElement MiddleName;
	@FindBy(how = How.XPATH, using = "//input[@id='lname']")
	WebElement LastName;

	@FindBy(how = How.XPATH, using = "//select[@id='relation']")
	WebElement Relation;
	@FindBy(how = How.XPATH, using = "//input[@id='rfname']")
	WebElement Relationfirstname;
	@FindBy(how = How.XPATH, using = "//input[@id='rmname']")
	WebElement RelationMiddlename;
	@FindBy(how = How.XPATH, using = "//input[@id='rlname']")
	WebElement RelationLastname;

	@FindBy(how = How.XPATH, using = "//input[@id='gender1']")
	WebElement Gender;
	@FindBy(how = How.XPATH, using = "//select[@id='blood']")
	WebElement Bloodgroup;
	@FindBy(how = How.XPATH, using = "//input[@id='age']")
	WebElement Age;
	@FindBy(how = How.XPATH, using = "//select[@id='eduqua']")
	WebElement Qualification;
	@FindBy(how = How.XPATH, using = "//input[@id='mobile']")
	WebElement Mobilenumber;
	
	@FindBy(how = How.XPATH, using = "//select[@id='prDistrict']")
	WebElement District;
	@FindBy(how = How.XPATH, using = "//select[@id='prSubDistrict']")
	WebElement SubDistrict;
	@FindBy(how = How.XPATH, using = "//input[@id='prHouseNo']")
	WebElement Flatorhouseno;
	@FindBy(how = How.XPATH, using = "//input[@id='prStreet']")
	WebElement Streetorlocality;
	@FindBy(how = How.XPATH, using = "//input[@id='prPinCode']")
	WebElement Pincode;
	@FindBy(how = How.XPATH, using = "//input[@id='copy']")
	WebElement Checkbox;
	@FindBy(how = How.XPATH, using = "//li[2][@role='presentation']/a")
	WebElement LicenseDetails;
	@FindBy(how = How.XPATH, using = "//select[@id='selectCov']")
	WebElement SelectCOV;
	@FindBy(how = How.XPATH, using = "//input[@id='addButton']")
	WebElement Addbutton;
	@FindBy(how = How.XPATH, using = "//select[@name='state1']")
	WebElement selectstate;
	@FindBy(how = How.XPATH, using = "//select[@name='issuAuthList']")
	WebElement RTO;
	@FindBy(how = How.XPATH, using = "//input[@id='covIssuDate']")
	WebElement COVIssueDate;
	@FindBy(how = How.XPATH, using = "//select[@id='selectCov']")
	WebElement SelectCOV2;
	@FindBy(how = How.XPATH, using = "//input[@id='addButton']")
	WebElement Addbutton2;

	@FindBy(how = How.XPATH, using = "//select[@name='state1']")
	WebElement Statetwo;
	@FindBy(how = How.XPATH, using = "//select[@name='issuAuthList']")
	WebElement RTOtwo;
	@FindBy(how = How.XPATH, using = "//input[@id='covIssuDate']")
	WebElement COVIssueDate2;
	@FindBy(how = How.XPATH, using = "//select[@id='selectCov']")
	WebElement SelectCOV3;
	@FindBy(how = How.XPATH, using = "//input[@id='addButton']")
	WebElement Addbutton3;

	@FindBy(how = How.XPATH, using = "//input[@name='badgeNO']")
	WebElement badgeNO;
	@FindBy(how = How.XPATH, using = "//input[@name='badgeDate']")
	WebElement badgeDate;

	@FindBy(how = How.XPATH, using = "//select[@name='state1']")
	WebElement Statethree;
	@FindBy(how = How.XPATH, using = "//select[@name='issuAuthList']")
	WebElement RTOthree;
	@FindBy(how = How.XPATH, using = "//input[@id='covIssuDate']")
	WebElement COVIssueDate3;
	@FindBy(how = How.XPATH, using = "//select[@id='selectCov']")
	WebElement SelectCOV4;
	@FindBy(how = How.XPATH, using = "//input[@id='addButton']")
	WebElement Addbutton4;

	@FindBy(how = How.XPATH, using = "//input[@id='submit']")
	WebElement Submit;
	@FindBy(how = How.XPATH, using = "//select[@id='reason']")
	WebElement DLReason;
	
	
	
	
	// related methods to perform operation on webelements

	public void setUserName(String Strusername) {
		stepstatus = basepage.setText(Username, Strusername);
		reportEvent(stepstatus, "Able to enter username", "Unable to enter username", driver, true);
	}

	public void setpassword(String Strpassword) {
		stepstatus = basepage.setText(Password, Strpassword);
		// reportEvent(stepstatus, "Able to enter password", "Unable to enter password",
		// driver);
		if (basepage.isDisplayed(Next)) {
			ClickonNext();
			SetCaptcha();
		} else {
			SetCaptcha();
		}

	}

	public void ClickonNext() {
		stepstatus = basepage.clickElement(Next);
		reportEvent(stepstatus, "Able to click on Next BUtton", "Unable to click on Next Button", driver, true);
	}

	public void SetCaptcha() {
		stepstatus = basepage.setText(Captcha, "123456");
		reportEvent(stepstatus, "Able to Enter Captcha", "Unable to Enter Captcha", driver, true);
	}

	public void Clickonsubmit() {
		stepstatus = basepage.clickElement(submit);
		if (basepage.alertExist(driver)) {
			acceptAlert(driver);
		} else {
			System.out.println("There is no Alert Present");
		}
		reportEvent(stepstatus, "Able to click on submit BUtton", "Unable to click on submit Button", driver, true);
	}

	public void ClickonRadio() {
		stepstatus = basepage.clickElement(Radio);
		reportEvent(stepstatus, "Able to click on Radio BUtton", "Unable to click on Radio Button", driver, true);
	}

	public void Clickonlogin() {
		stepstatus = basepage.clickElement(login);
		reportEvent(stepstatus, "Able to click on Radio BUtton", "Unable to click on Radio Button", driver, true);
	}

	////////////////// DLBacklogapproval//////////////

	@FindBy(how = How.XPATH, using = "//a[text()='DL BACKLOG APPROVAL']")
	WebElement DLBACKLOGAPPROVAL;
	@FindBy(how = How.XPATH, using = "//input[@id='dlNumber']")
	WebElement DLno;
	@FindBy(how = How.XPATH, using = "//input[@id='proceed']")
	WebElement Proceed;
	@FindBy(how = How.XPATH, using = "//button[@id='generateotp']")
	WebElement GenerateOTP;
	@FindBy(how = How.XPATH, using = "//input[@name='otpNumberForDlBacklog']")
	WebElement Enterotptext;

	@FindBy(how = How.XPATH, using = "//input[@value='Approve']")
	WebElement Approve;

	@FindBy(how = How.XPATH, using = "(//input[@id='Approve'])[2]")
	WebElement ApproveforGJ;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
	WebElement logout;
	

	public void ClickonDL() {
		stepstatus = basepage.clickElement(DL);
		reportEvent(stepstatus, "Able to Click on DL", "Unable to Click on DL", driver, true);
	}

	public void ClickonDLBacklog() {
		stepstatus = basepage.clickElement(DLBacklog);
		reportEvent(stepstatus, "Able to Click on DLBacklog", "Unable to Click on DLBacklog", driver, true);
	}

	public void Clickfname() {
		stepstatus = basepage.clickElement(Name);
		reportEvent(stepstatus, "Able to ClickfName", "Unable to ClickFname", driver, true);
	}
	
	public void SetFirstissuedate(String value) {
		stepstatus = basepage.SetTextAndEscape(Firstissuedate, value);
		reportEvent(stepstatus, "Able to Enter Firstissuedate", "Unable to Enter Firstissuedate", driver, true);
	}

	public void SetNumaricLLno(String value) {

		try {

			stepstatus = basepage.SetTextAndTAB(NumaricLLno, value);

		} catch (UnhandledAlertException f) {
			try {
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert data: " + alertText);
				alert.accept();
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}
	}

	public void SetOriginalDLno(String value) {
		stepstatus = basepage.setText(OriginalDLno, value);
		reportEvent(stepstatus, "Able to Enter OriginalDLno", "Unable to Enter OriginalDLno", driver, true);
	}

	public void SetLasttransdate(String value) {
		stepstatus = basepage.SetTextAndEscape(Lasttransdate, value);
		reportEvent(stepstatus, "Able to Enter Lasttransdate", "Unable to Enter Lasttransdate", driver, true);
	}

	public void Clickfname(String value) {
		stepstatus = basepage.clickElement(Name);
		reportEvent(stepstatus, "Able to ClickfName", "Unable to ClickFname", driver, true);
	}
	
	
	public void SetName(String value) {
		stepstatus = basepage.setText(Name, value);
		reportEvent(stepstatus, "Able to Enter Name", "Unable to Enter Name", driver, true);
	}

	public void SetMiddleName(String value) {
		stepstatus = basepage.setText(MiddleName, value);
		reportEvent(stepstatus, "Able to Enter MiddleName", "Unable to Enter MiddleName", driver, true);
	}

	public void SetLastName(String value) {
		stepstatus = basepage.setText(LastName, value);
		reportEvent(stepstatus, "Able to Enter LastName", "Unable to Enter LastName", driver, true);
	}

	public void SetRelation(String value) {
		stepstatus = basepage.setOptionInSelectBox(Relation, value);
		reportEvent(stepstatus, "Able to Enter Relation", "Unable to Enter Relation", driver, true);
	}

	public void SetRelationfirstname(String value) {
		stepstatus = basepage.setText(Relationfirstname, value);
		reportEvent(stepstatus, "Able to Enter Relationfirstname", "Unable to Enter Relationfirstname", driver, true);
	}

	public void SetRelationMiddlename(String value) {
		stepstatus = basepage.setText(RelationMiddlename, value);
		reportEvent(stepstatus, "Able to Enter RelationMiddlename", "Unable to Enter RelationMiddlename", driver, true);
	}

	public void SetRelationLastname(String value) {
		stepstatus = basepage.setText(RelationLastname, value);
		reportEvent(stepstatus, "Able to Enter RelationLastname", "Unable to Enter RelationLastname", driver, true);
	}

	public void ClickonGender() {
		stepstatus = basepage.clickElement(Gender);
		reportEvent(stepstatus, "Able to click on Gender", "Unable to click on Gender", driver, true);
	}

	public void SetBloodgroup(String value) {
		stepstatus = basepage.setOptionInSelectBox(Bloodgroup, value);
		reportEvent(stepstatus, "Able to Enter Bloodgroup", "Unable to Enter Bloodgroup", driver, true);
	}

	public void SetAge(String value) {
		stepstatus = basepage.setText(Age, value);
		reportEvent(stepstatus, "Able to Enter Age", "Unable to Enter Age", driver, true);
	}

	public void SetQualification(String value) {
		stepstatus = basepage.setOptionInSelectBox(Qualification, value);
		reportEvent(stepstatus, "Able to Enter Qualification", "Unable to Enter Qualification", driver, true);
	}

	public void SetMobilenumber(String value) {
		stepstatus = basepage.setText(Mobilenumber, value);
		reportEvent(stepstatus, "Able to Enter Mobilenumber", "Unable to Enter Mobilenumber", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@id='prState']")
	WebElement State;
	public void SetState(String value) {
		stepstatus = basepage.setOptionInSelectBox(State, value);
		reportEvent(stepstatus, "Able to Enter State", "Unable to Enter State", driver, true);
	}

	public void SetDistrict(String value) {
		stepstatus = basepage.setOptionInSelectBox(District, value);
		reportEvent(stepstatus, "Able to Enter District", "Unable to Enter District", driver, true);
	}

	public void SetSubDistrict(String value) {
		stepstatus = basepage.setOptionInSelectBox(SubDistrict, value);
		reportEvent(stepstatus, "Able to Enter SubDistrict", "Unable to Enter SubDistrict", driver, true);
	}

	public void TypeofDistdetails() {
		wait(2);
		WebElement Dist = driver.findElement(By.xpath("//select[@id='prDistrict']"));
		Select District = new Select(Dist);
		List<WebElement> options = District.getOptions();
		for (int i = 0; i <= options.size() - 1; i++) {
			try {
				Dist = driver.findElement(By.xpath("//select[@id='prDistrict']"));
				District = new Select(Dist);
				options = District.getOptions();
				if (!options.get(1).getText().contains("Select")) {
					System.out.println(options.get(1).getText());
					District.selectByIndex(1);
					Thread.sleep(5000);
					WebElement SubDist = driver.findElement(By.xpath("//select[@id='prSubDistrict']	"));
					Select subdist = new Select(SubDist);
					List<WebElement> Subdistoptions = subdist.getOptions();
					System.out.println(Subdistoptions.get(1).getText());
					Subdistoptions.get(1).getText();
					if (subdist.getOptions().size() > 1
							&& !subdist.getOptions().get(1).getText().toLowerCase().contains("Select")) {
						subdist.selectByIndex(1);
						break;
					}
				} else {
					System.out.println("Else block....: " + options.get(1).getText());
				}
			} catch (StaleElementReferenceException f) {
				f.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void SetFlatOrHouseNo(String value) {
		stepstatus=basepage.setText(Flatorhouseno, value);
		reportEvent(stepstatus, "Able to Enter flat or house number", "Unable to Enter flat or house number", driver, true);
		
	}
public void SetStreetOrLocality(String value) {
	stepstatus=basepage.setText(Streetorlocality,value );
	reportEvent(stepstatus, "Able to Enter Street or locality ", "Unable to Enter Street or locality", driver, true);
	}
	public void SetPincode(String value) {
		stepstatus = basepage.setText(Pincode, value);
		reportEvent(stepstatus, "Able to Enter Pincode", "Unable to Enter Pincode", driver, true);
	}

	public void ClickonCheckbox() {
		stepstatus = basepage.clickElement(Checkbox);
		reportEvent(stepstatus, "Able to click on Checkbox", "Unable to click on Checkbox", driver, true);
	}

	public void ClickonLicenseDetails() {
		stepstatus = basepage.clickElement(LicenseDetails);
		reportEvent(stepstatus, "Able to click on LicenseDetails", "Unable to click on LicenseDetails", driver, true);
	}

	public void SetSelectCOV(String value) {
		stepstatus = basepage.setOptionInSelectBox(SelectCOV, value);
		
		reportEvent(stepstatus, "Able to Enter SelectCOV1", "Unable to Enter SelectCOV1", driver, true);
	}

	public void ClickonAddbutton() {
		stepstatus = basepage.clickElement(Addbutton);
		reportEvent(stepstatus, "Able to click on Addbutton1", "Unable to click on Addbutton1", driver, true);
	}

	public void SelectState(String value) {
		stepstatus = basepage.setOptionInSelectBox(selectstate, value);
		reportEvent(stepstatus, "Able to Enter State", "Unable to Enter State", driver, true);
	}

	public void SetRTO(String value) {
		stepstatus = basepage.setValueInSelectBox(RTO, value);
		reportEvent(stepstatus, "Able to Enter RTO", "Unable to Enter RTO", driver, true);
	}

	public void SetCOVIssueDate(String value) {
		stepstatus = basepage.SetTextAndTAB(COVIssueDate, value);
		reportEvent(stepstatus, "Able to Enter COVIssueDate", "Unable to Enter COVIssueDate", driver, true);
	}

	public void SetSelectCOV2(String value) {

		stepstatus = basepage.setOptionInSelectBox(SelectCOV2, value);
		reportEvent(stepstatus, "Able to Enter SelectCOV2", "Unable to Enter SelectCOV2", driver, true);
	}

	public void ClickonAddbutton2() {
		stepstatus = basepage.clickElement(Addbutton2);
		reportEvent(stepstatus, "Able to click on Addbutton2", "Unable to click on Addbutton2", driver, true);
	}

	public void SetStatetwo(String value) {
		stepstatus = basepage.setOptionInSelectBox(Statetwo, value);
		reportEvent(stepstatus, "Able to Enter Statetwo", "Unable to Enter Statetwo", driver, true);
	}

	public void SetRTOtwo(String value) {
		stepstatus = basepage.setOptionInSelectBox(RTOtwo, value);
		reportEvent(stepstatus, "Able to Enter RTOtwo", "Unable to Enter RTOtwo", driver, true);
	}

	public void SetCOVIssueDate2(String value) {
		stepstatus = basepage.SetTextAndTAB(COVIssueDate2, value);
		reportEvent(stepstatus, "Able to Enter COVIssueDate2", "Unable to Enter COVIssueDate2", driver, true);
	}

	public void SetSelectCOV3(String value) {
		stepstatus = basepage.setOptionInSelectBox(SelectCOV3, value);
		reportEvent(stepstatus, "Able to Enter SelectCOV3", "Unable to Enter SelectCOV3", driver, true);
	}

	public void ClickonAddbutton3() {
		stepstatus = basepage.clickElement(Addbutton3);
		reportEvent(stepstatus, "Able to click on Addbutton3", "Unable to click on Addbutton3", driver, true);
	}

	public void setbadgeno(String value) {
		stepstatus = basepage.setText(badgeNO, value);
		reportEvent(stepstatus, "Able to enter badgeNO", "Unable to enter badgeNO", driver, true);
	}

	public void SetbadgeDate(String value) {
		stepstatus = basepage.setText(badgeDate, value);
		reportEvent(stepstatus, "Able to enter badgeNO", "Unable to enter badgeNO", driver, true);
	}

	public void SetStatethreeo(String value) {
		stepstatus = basepage.setOptionInSelectBox(Statethree, value);
		reportEvent(stepstatus, "Able to Enter Statethree", "Unable to Enter Statethree", driver, true);
	}

	public void SetRTOthree(String value) {
		stepstatus = basepage.setOptionInSelectBox(RTOthree, value);
		reportEvent(stepstatus, "Able to Enter RTOthree", "Unable to Enter RTOthree", driver, true);
	}

	public void SetCOVIssueDate3(String value) {
		stepstatus = basepage.SetTextAndTAB(COVIssueDate3, value);
		reportEvent(stepstatus, "Able to Enter COVIssueDate3", "Unable to Enter COVIssueDate3", driver, true);
	}

	public void SetSelectCOV4(String value) {
		stepstatus = basepage.setOptionInSelectBox(SelectCOV4, value);
		reportEvent(stepstatus, "Able to Enter SelectCOV4", "Unable to Enter SelectCOV4", driver, true);
	}

	public void ClickonAddbutton4() {
		stepstatus = basepage.clickElement(Addbutton4);
		reportEvent(stepstatus, "Able to click on Addbutton4", "Unable to click on Addbutton4", driver, true);
	}
	

	public void SelectDLreason(String value) {
		stepstatus = basepage.setOptionInSelectBox(DLReason, value);
		
		reportEvent(stepstatus, "Able to Select DL Reason", "Unable to Select DL Reason", driver, true);
	}
	
	
	
	
	
	public void ClickonSubmit() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		stepstatus = basepage.clickElement(Submit);
		wait(10);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {
			basepage.dismissAlert(driver);
		}
	wait(10);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {
			basepage.dismissAlert(driver);
		}
		reportEvent(stepstatus, "Able to Click DLSubmit button", "Unable to Click DLSubmit button", driver, true);
		String AckDL=driver.getTitle();
		System.out.println(AckDL);
		if(AckDL.equalsIgnoreCase("Acknowledgement For DL backlog")){
			System.out.println("Title Matched");
			CaptureDetailsinDLAppSubmission();
			capturedetailsType2();
			Flows validate = new Flows(driver);
			validate.VerifyFlows();
		}
		else if(driver.getPageSource().contains("DL Backlog Saved Successfully......")) {
			capturedetails();
//			Flows validate = new Flows(driver);
//			validate.VerifyFlows();
			
		}
		
			else
			System.out.println("Due to DL Backlog Code Changes Unable to Execute");
		
	}
	
		
		
		
		/*
		if (driver.getTitle().contains("Acknowledgement For DL backlog")) {
			System.out.println("Loaded into Ack Page");
			Utilitymethods utilitymethods = new Utilitymethods(driver);
			wait(10);
			utilitymethods.CaptureDetails();
			Flows validate = new Flows(driver);
			validate.VerifyFlows();
		} else if (driver.getPageSource().contains("DL Backlog Saved Successfully......")) {
			capturedetails();
			Flows validate = new Flows(driver);
			validate.VerifyFlows();
		}
		*/
		
		
	/*	if (basepage.alertExist(driver)) 
		{
			basepage.acceptAlert(driver);
			basepage.acceptAlert(driver);
			wait(2);
			System.out.println(driver.getTitle());
			if (driver.getTitle().contains("Acknowledgement For DL backlog")) {
				System.out.println("Loaded into Ack Page");
				Utilitymethods utilitymethods = new Utilitymethods(driver);
				wait(10);
				utilitymethods.CaptureDetails();
				Flows validate = new Flows(driver);
				validate.VerifyFlows();
			} else if (driver.getPageSource().contains("DL Backlog Saved Successfully......")) {
				capturedetails();
				Flows validate = new Flows(driver);
				validate.VerifyFlows();
			} else {
				System.out.println("Due to DL Backlog code Changes");
			}
		} else {
			wait(2);
			if (driver.getTitle().contains("Acknowledgement For DL backlog")) {
				capturedetailsType2();
				Flows validate = new Flows(driver);
				validate.VerifyFlows();

			} else if (driver.getPageSource().contains("DL Backlog Saved Successfully......")) {
				capturedetails();
				Flows validate = new Flows(driver);
				validate.VerifyFlows();

			} else {
				System.out.println("Due to DL Backlog code Changes");
			}

		}*/

	public void CaptureDetailsinDLAppSubmission() {
		DL_Backlog dl_backlog= new DL_Backlog(driver);
		AppNum = App_NO(driver, "//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]");
		System.out.println(AppNum);
		DOB = DOB(driver, "//table/tbody/tr[2]/td[3]/following-sibling::td");
		System.out.println(DOB);
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("Acknowledgement For DL backlog")) {
			System.out.println("Editing in Excel");
			dl_backlog.setdata("ApplicationNo", AppNum.substring(3).trim());
			dl_backlog.setdata("DateofBirth", DOB.substring(3).trim());

		} else {
			System.out.println("New DL Acknowledgement is not Generated");
		}
	}
	

	public void capturedetailsType2() {

		s10 = DL_Backlog(driver, "//table/tbody/tr[4]/td[3]/following-sibling::td");
		setdata("DL", s10.substring(5).trim());

		s11 = DL_Approvedappno(driver, "//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]");
		setdata("ApplicationNo", s11.substring(3).trim());

		s2 = DOB(driver, "//table/tbody/tr[2]/td[3]/following-sibling::td");
		setdata("DateofBirth", s2.substring(3).trim());

		setdata("Status", "Pass");
		// setdata("Iteration", "NA");
	}

	public void capturedetails() {
		s10 = DL_Backlog(driver, "//div[@class='panel-body']/h4");
		setdata("DL", s10.substring(16).trim());

		/*
		 * s10 = DL_Backlog(driver, "//table/tbody/tr[4]/td[3]/following-sibling::td");
		 * setdata("DL", s10.substring(5).trim());
		 */

		s11 = DL_Approvedappno(driver, "//h3[2]");
		setdata("ApplicationNo", s11.substring(23).trim());

		/*
		 * s11 = DL_Approvedappno(driver,
		 * "//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]");
		 * setdata("DLApprovedappno", s11.substring(3).trim());
		 */

		/*
		 * s2 = DOB(driver, "//table/tbody/tr[2]/td[3]/following-sibling::td");
		 * setdata("DateofBirth", s2.substring(3).trim());
		 */
		setdata("Status", "Pass");
		// setdata("Iteration", "NA");
	}

	public void ClickonGenerateOTP() {
		stepstatus = basepage.clickElement(GenerateOTP);
		wait(5);
		String text = null;
		if (basepage.alertExist(driver)) {
			text = basepage.alertGetText(driver);
			System.out.println("Otp Text is : " + text.substring(71, 77).trim());
			basepage.acceptAlert(driver);
		} else {
			basepage.dismissAlert(driver);
		}

		// Scanner sc = new Scanner(System.in);
		// System.out.println("Please Enter Text as shown: ");
		// String cap1 = sc.next();
		// wait(12);
		//
		// String s = JOptionPane.showInputDialog("Please Enter OTP");
		// System.out.println(s);
		// basepage.setText(Enterotptext, s);
		basepage.SetTextAndTAB(Enterotptext, text.substring(71, 77).trim());

		wait(5);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {
			basepage.dismissAlert(driver);
		}

	}

	
	public void ClickonDlbacklogapproval() {
		stepstatus = basepage.clickElement(DLBACKLOGAPPROVAL);
		reportEvent(stepstatus, "Able to click on DLBACKLOGAPPROVAL", "Unable to click on DLBACKLOGAPPROVAL", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='applicationNumber']")
	WebElement DLnoa;

	public void SetDLno(String vlaue) {
		stepstatus = basepage.setText(DLnoa, vlaue);
		reportEvent(stepstatus, "Able to Enter DLno", "Unable to DLno", driver, true);
	}

	public void SetDLno() {
		stepstatus = basepage.setText(DLno, s1.substring(16).trim());
		reportEvent(stepstatus, "Able to Enter DLno", "Unable to DLno", driver, true);
	}

	public void Clickonproceed() {
		stepstatus = basepage.clickElement(Proceed);
		reportEvent(stepstatus, "Able to click on Proceed", "Unable to click on Proceed", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//button[@id='generateotp']")
	WebElement OTP;

	public void Verify_GenerateOTPforApproval() throws IOException {
		if (isDisplayed(OTP) && isEnabled(OTP) == true) {
			driver.findElement(By.xpath("//button[@id='generateotp']")).click();
			wait(20);
			if (alertExist(driver)) 
			{
				acceptAlert(driver);
				System.out.println();
			}
				else{ basepage.dismissAlert(driver);
			}
			wait(5);
			String env = prop.getProperty("ApplicationURL");
			System.out.println("Environment for log in verify generateotpforapproval:"+env);
			if (env.equalsIgnoreCase("SarathiCOV")) {
				loaddata();
				System.out.println("Loading to new window");
				Getlogotp("https://sarathicov.nic.in:8443/applogs/EmailandSMS.log");
				wait(2);
				Clickonapprove();
			} else if (env.equalsIgnoreCase("SarathiProd")) {
				loaddata();
				Getlogotp(prop.getProperty("SarathiprodeKYCLogURL"));
//				Getlogotp("http://164.100.69.249/applicationlogs/preprodlogs/mainapplogs/EmailandSMS.log");
				
				wait(2);
				Clickonapprove();
			} else if (env.equalsIgnoreCase("CAS_SarathiCOV")) {
				System.out.println("inside this");
				loaddata();
				Getlogotp("https://sarathicov.nic.in:8443/applogs/EmailandSMS.log");
				wait(2);
				Clickonapprove();
			} else if (env.equalsIgnoreCase("CAS_SarathiProd")) {
				loaddata();
				Getlogotp("https://sarathi.preprod.nic.in/applogs/EmailandSMS.log");
				wait(2);
				Clickonapprove();
			} else {
				System.out.println("Log URL is not matched.Please try again");
			}
		} else {
			System.out.println("There is no OTP option to Approve Backlog");
			wait(5);
			Clickonapprovefor_non_Generateotpforapproval();
			//driver.findElement(By.xpath("//div[@id='dlbacklogApproveId']/following::input[1]")).click();
		}

	}

	public void Clickonapprove() {
		stepstatus = basepage.clickElement(Approve);
		reportEvent(stepstatus, "Able to click on Approve", "Unable to click on Approve", driver, true);
	}

	public void Clickonapprovefor_non_Generateotpforapproval() {
		stepstatus = basepage.clickElement(ApproveforGJ);
		reportEvent(stepstatus, "Able to Clickonapprovefor_non_Generateotpforapproval", "Unable to Clickonapprovefor_non_Generateotpforapproval", driver, true);
	}
	
	public void Logout() {

		stepstatus = basepage.clickElement(logout);
		reportEvent(stepstatus, "Able to click On logout", "UnAble to click On logout", driver, true);
		wait(3);
	}

	public void ArrangeDataSet() {

		Faker faker = new Faker(new Locale("en-IND"));
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		String relationfirstname = faker.name().firstName();
		String relationlastname = faker.name().lastName();

		setdata("Name", firstname);
		setdata("Lastname", lastname);
		setdata("RFName", relationfirstname);
		setdata("RLName", relationlastname);

	}

	public String Getlogotp(String url) throws IOException {
		wait(3);
		System.out.println("Inside LogOtp Method");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // switches to new tab
		driver.get(url);
		// driver.navigate().refresh();
		String output = driver.findElement(By.cssSelector("body")).getText();
		File DestFile = new File(".\\logfile.txt");
		PrintWriter writer = new PrintWriter(DestFile);
		writer.print("");
		writer.close();
		FileUtils.writeStringToFile(DestFile, output);
		String FILENAME = ".\\logfile.txt";
		String getotp = null;
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String strCurrentLine;
			int count = 0;
			while ((strCurrentLine = br.readLine()) != null) {
				if (strCurrentLine.contains("For+Approval+of+Your+Application+")) {
					if (strCurrentLine.contains("For+Approval+of+Your+Application+")) {
						//2023-09-15 12:38:26:928 INFO  nic.HelpDesk.Email.Service.SMS_Intg:212 [] - insSmsOTPAuthDet return value..1 for 9959316190: OTP (One Time Password) For Approval of Your Application 1070623 is: 519285.  Do not share it with anyone.MoRTH

						// System.out.println(strCurrentLine.substring(177,184).trim());
						//Below for Preprod
						
					getotp = strCurrentLine.substring(257,263).trim();
					//Below for COV
//					getotp = strCurrentLine.substring(265,271).trim();
					 System.out.println(getotp);
					//200,206 for preprod
					//192,199 for staging
					}
					count++;
				} else {
					// System.out.println("#######################Pleasae Check OTP
					// Section###########################");
				}
			}
			// System.out.println(count);
			System.out.println("The OTP for Approval is  " + getotp);
			driver.switchTo().window(tabs.get(0));
			driver.findElement(By.xpath("//input[@name='otpNumberForDlBacklog']")).sendKeys(getotp);
			driver.findElement(By.xpath("//input[@name='otpNumberForDlBacklog']")).sendKeys(Keys.TAB);
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getotp;
	}
}
