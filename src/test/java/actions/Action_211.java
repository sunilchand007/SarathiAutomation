package actions;



import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.LLEditEntryPage;
import pageobjects.LLEdit_AcknowledgementPage;
import pageobjects.LLEdit_CorrectionInValiditiesPage;
import pageobjects.LLEdit_CorrectionOfAddressPage;
import pageobjects.LLEdit_CorrectionOfCOVPage;
import pageobjects.LLEdit_CorrectionOfDobPage;
import pageobjects.LLEdit_CorrectionOfMiscPage;
import pageobjects.LLEdit_CorrectionOfNamePage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Flows;
import utility.Utilitymethods;

public class Action_211 extends BaseClass{
	WebDriver driver;
	StateSpecificHomePage stateSpecificHomePage;
	Action_215 action_215;
	LLEditEntryPage llEditEntryPage;
	Flows flows;
	StateSelectionPage stateSelectionPage;
	LLEdit_CorrectionOfNamePage correctionOfName;
	Utilitymethods utilitymethods;
	
	@BeforeMethod
    public void LaunchApplication() throws IOException {
		
		utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();

	}
	
	@Test (invocationCount = 1)
	public void llEditEntryTransaction() throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		String testCase = "Fresh LL Edit";
			if(testCase.equals("Fresh LL Edit")) {
				freshLLEditEntry();
				
			}else if(testCase.equals("Application Status")) {
				action_215 = new Action_215(driver);
				action_215.applicationstatus();
			}else if(testCase.equals("RTO Side status")) {
				flows = new Flows(driver);
				flows.Login();
				flows.RTOLevel_Status();
			
		}
		
	}
	
	public void freshLLEditEntry() throws ClassNotFoundException, SQLException, IOException, InterruptedException {
		stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.closeContactlessLicenceServicesPopup();
		stateSpecificHomePage.Mouserhoveron_LearnerLicence();
		stateSpecificHomePage.clickon_LLEditEntry();
		llEditEntryPage = new LLEditEntryPage(driver);
		llEditEntryPage.editLlNumber(getdata("LLNumber"));
		llEditEntryPage.editLlDob(getdata("DateofBirth"));
		llEditEntryPage.click_tocloseDOBcalendar();
		llEditEntryPage.editSelectStatename(getdata("State"));
		llEditEntryPage.editRtoSelected(getdata("RTOCode"));
		llEditEntryPage.editLlCaptcha(getdata("Captcha"));
		llEditEntryPage.clickOnOtpGeneratedForEditLLButton();
		wait(1);
		acceptAlert(driver);
		llEditEntryPage.editLlOtp(getdata("Captcha"));
		llEditEntryPage.clickOnOtpLabel();
		llEditEntryPage.clickOnSubmitLL();
		wait(1);
		
		
		String llEditServiceType = "llEditCODOB_n_COV";
	//llEditCOA  llEditCON llEditCODob llEditCOPnS  llEditCOCOV  llEditCOVal  llEditCOMisc  
//		     llEditCOAnN  llEditCONnMisc  llEditCOAnMisc   llEditCODnC
		if(llEditServiceType.equals("llEditCOA")) {
			llEditEntryPage.clickOnCorrectionOfMisc();
			wait(1);
			correctionOfAddress();
			subAndVerify();
		}else if(llEditServiceType.equals("llEditCON")) {
			llEditEntryPage.clickOnCorrectionOfMisc();
			wait(1);
			correctionOfName();
			subAndVerify();
		}else if(llEditServiceType.equals("llEditCODob")) {
			llEditEntryPage.clickOnCorrectionOfMisc();
			wait(1);
			correctionOfDob();
			subAndVerify();
			
		}else if(llEditServiceType.equals("llEditCOCOV")) {
			llEditEntryPage.clickOnCorrectionOfMisc();
			wait(1);
			correctionOfCov();
			subAndVerify();
			
		}else if(llEditServiceType.equals("llEditCOMisc")) {
			
			correctionOfMisc();
			subAndVerify();
			
		}else if(llEditServiceType.equals("llEditCOAnN")) {
			llEditEntryPage.clickOnCorrectionOfMisc();
			wait(1);
			correctionOfAddress();
			correctionOfName();
			subAndVerify();
		}else if(llEditServiceType.equals("llEditCONnMisc")) {
			wait(1);
			correctionOfName();
			correctionOfMisc();
			subAndVerify();
		}
		else if(llEditServiceType.equals("llEditCOAnMisc")) {
			wait(1);
			correctionOfAddress();
			correctionOfMisc();
			subAndVerify();
		}else if(llEditServiceType.equals("llEditCOVal")) {
			llEditEntryPage.clickOnCorrectionOfMisc();
			wait(1);
			correctionInValidities();
			subAndVerify();
		}else if(llEditServiceType.equals("llEditCODOB_n_COV")) {
			llEditEntryPage.clickOnCorrectionOfMisc();
			wait(1);
			correctionOfDob();
			correctionOfCov();
			subAndVerify();
		}
		
	}
	
	private void subAndVerify() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		llEditEntryPage.remarksAddedForSubmission(getdata("Remarks"));
		llEditEntryPage.clickOnLLEditEntrySubmit();
		wait(2);
		if(alertExist(driver)) {
			acceptAlert(driver);
		}else 
		{
		System.out.println("No alerts found");	
		}
		wait(2);
		LLEdit_AcknowledgementPage acknowledgementPage = new LLEdit_AcknowledgementPage(driver);
		acknowledgementPage.LLEditEntry_Acknowledgement();
		
		wait(1);
		flows = new Flows(driver);
		flows.VerifyFlows();
//		applicationstatus.applicationstatusforallTransactions();
	}
	
	public void correctionOfAddress() {
		LLEdit_CorrectionOfAddressPage correctionOfAddress = new LLEdit_CorrectionOfAddressPage(driver);
		correctionOfAddress.clickOnCorrectionOfAddressCheckbox();
		correctionOfAddress.selectPermAddrModifiedState(getdata("State"));
		correctionOfAddress.selectPermAddrModifiedDist(getdata("District"));
		correctionOfAddress.selectPermAddrModifiedSubDist(getdata("SubDistrict"));
//		correctionOfAddress.permAddress(getdata("PermAddress"));
		correctionOfAddress.permHouseNumber(getdata("HouseNumber"));
		correctionOfAddress.permStreet(getdata("Street"));
		correctionOfAddress.permPincode(getdata("Pincode"));
		correctionOfAddress.clickOnPermanentAddressCheckbox();
	}
	
	public void correctionOfName() {
		
		correctionOfName = new LLEdit_CorrectionOfNamePage(driver);
		correctionOfName.clickOnCorrectionOfNameCheckbox();
		utilitymethods.ArrangeDataSet();
		correctionOfName.firstName(getdata("Applicantfirstname"));
        correctionOfName.middleName(getdata("Applicantlastname"));
		correctionOfName.lastName(getdata("Applicantlastname"));
		correctionOfName.selectRelation(getdata("Relation"));
		correctionOfName.relFirstName(getdata("Relationfirstname"));
//		correctionOfName.relMiddleName(getdata("RelMiddleName"));
		correctionOfName.relLastName(getdata("Relationlastname"));
		
	}
	
	public void correctionOfDob() {
		
		LLEdit_CorrectionOfDobPage correctionOfDob = new LLEdit_CorrectionOfDobPage(driver);
		correctionOfDob.clickOnCorrectionOfDobCheckbox();
		correctionOfDob.clickOnDob();
		//correctionOfDob.selectDate(getdata("Jan"),getdata("2024"));
		wait(1);
//		correctionOfDob.dob(getdata("ChangeDateofBirth"));
//		driver.findElement(By.xpath("//*[@id='validateRequestll_lldledit_enterDob']")).click();
	}
	
	public void correctionOfCov() {
		
		LLEdit_CorrectionOfCOVPage correctionOfCOV = new LLEdit_CorrectionOfCOVPage(driver);
		correctionOfCOV.clickOnSelectAddCov();
		correctionOfCOV.selectCov(getdata("COV"));
		correctionOfCOV.clickOnAddCov();
		
	}
	
	public void correctionInValidities() {
		
		LLEdit_CorrectionInValiditiesPage correctionInValidities = new LLEdit_CorrectionInValiditiesPage(driver);
		correctionInValidities.clickOnSelectChangeInValidities();
		
		correctionInValidities.clickOnSelectChangeInVal();
		/*
		 * if(alertExist(driver)) { dismissAlert(driver); }
		 */
//		correctionInValidities.llFromValidity(getdata("FromValidity"));
		//driver.findElement(By.xpath("//*[@id='validateRequestll_lldledit_valFrm']")).click();
		correctionInValidities.llToValidity(getdata("ValidityTo"));
		//driver.findElement(By.xpath("//*[@id='validateRequestll_lldledit_valFrm']")).click();
		if(alertExist(driver)) { 
			dismissAlert(driver);
			}
		
	}
	
	public void correctionOfMisc() {
		LLEdit_CorrectionOfMiscPage correctionOfMisc = new LLEdit_CorrectionOfMiscPage(driver);
		correctionOfMisc.selectQualification(getdata("Qualification"));
		correctionOfMisc.selectBloodGrp(getdata("Bloodgroup"));
//		correctionOfMisc.selectRelation(getdata("Relation"));
		
	}
	
	
}
