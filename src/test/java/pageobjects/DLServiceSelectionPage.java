package pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class DLServiceSelectionPage extends BasePage{
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;
 
    NewLLSubmissionPage NewLLRegistrtionPage;
	public DLServiceSelectionPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(how = How.XPATH, using = "//input[@value='CHANGE OF NAME IN DL'][1]")
	WebElement CheckboxChangeofnameinDL;	
	@FindBy(how = How.XPATH, using = "//input[@value='close']")
	WebElement CloseAlert;
	@FindBy(how = How.XPATH, using = "//input[@value='ENDORSEMENT TO DRIVE HAZARDOUS MATERIAL'][1]")
	WebElement CheckboxENDORSEMENTTODRIVEHAZARDOUSMATERIALinDL;
	@FindBy(how = How.XPATH, using = "//input[@value='ENDORSEMENT TO DRIVE IN HILL REGION'][1]")
	WebElement CheckboxENDORSEMENTTODRIVEInHillRegioninDL;
	@FindBy(how = How.XPATH, using = "(//input[@value='CHANGE OF PHOTO AND SIGNATURE IN DL'])[1]")
	WebElement CheckboxChangeofBiometricsinDL;
	@FindBy(how = How.CSS, using = "input[value='ADDITIONAL ENDORSEMENT TO DL'][type='checkbox']")
	WebElement CheckboxAdditionalEndorsementinDL;
	@FindBy(how = How.XPATH, using = "(//input[@value='ISSUE OF PSV BADGE TO A DRIVER'])[1]")
	WebElement selectserviceforIssueofPSVBadgeToDriverinDL;
	public void selectserviceforIssueofPSVBadgeToDriverinDL() throws IOException, InterruptedException {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
		stepstatus= basepage.clickElement(selectserviceforIssueofPSVBadgeToDriverinDL);
		reportEvent(stepstatus, "Able to click on selectserviceforIssueofPSVBadgeToDriverinDL ", "Unable to click on selectserviceforIssueofPSVBadgeToDriverinDL", driver, true);
	}
	public void selectserviceforAdditionalEndorsementToDL() throws IOException, InterruptedException {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
		stepstatus= basepage.clickElement(CheckboxAdditionalEndorsementinDL);
		reportEvent(stepstatus, "Able to click on CheckboxAdditionalEndorsementinDL ", "Unable to click on CheckboxAdditionalEndorsementinDL", driver, true);
		
			if (basepage.alertExist(driver)) {
				basepage.acceptAlert(driver);
				} else {
					basepage.dismissAlert(driver);
				}
	}
	
	public void selectserviceforChangeofBiometrics() throws IOException, InterruptedException {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
		stepstatus= basepage.clickElement(CheckboxChangeofBiometricsinDL);
		reportEvent(stepstatus, "Able to click on CheckboxChangeofBiometricsinDL ", "Unable to click on CheckboxChangeofBiometricsinDL", driver, true);
	}
	public void selectserviceforENDORSEMENTTODRIVEInHillRegion() throws IOException, InterruptedException {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
		stepstatus= basepage.clickElement(CheckboxENDORSEMENTTODRIVEInHillRegioninDL);
		reportEvent(stepstatus, "Able to click on CheckboxENDORSEMENTTODRIVEInHillRegioninDL ", "Unable to click on CheckboxENDORSEMENTTODRIVEInHillRegioninDL", driver, true);
	}
	
	public void selectserviceforENDORSEMENTTODRIVEHAZARDOUSMATERIAL() throws IOException, InterruptedException {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
		stepstatus= basepage.clickElement(CheckboxENDORSEMENTTODRIVEHAZARDOUSMATERIALinDL);
		reportEvent(stepstatus, "Able to click on CheckboxENDORSEMENTTODRIVEHAZARDOUSMATERIALinDL ", "Unable to click on CheckboxENDORSEMENTTODRIVEHAZARDOUSMATERIALinDL", driver, true);
	}
	public void selectserviceforChangeofName() throws IOException, InterruptedException {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
		stepstatus= basepage.clickElement(CheckboxChangeofnameinDL);
		reportEvent(stepstatus, "Able to click on CheckboxChangeofnameinDL ", "Unable to click on CheckboxChangeofnameinDL", driver, true);
	}

	@FindBy(how = How.XPATH, using = "	//input[@value='ISSUE OF DUPLICATE DL'][1]")
	WebElement IssueofDuplicateDL;	
	
	public void selectserviceforDupliDL() throws IOException, InterruptedException {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
		stepstatus= basepage.clickElement(IssueofDuplicateDL);
		reportEvent(stepstatus, "Able to click on Issue of Duplicate DL ", "Unable to click on Issue of Duplicate DL", driver, true);
		//Close Alert//found only when Issue of Duplicate DL is Selected.
		wait(3);
		stepstatus = basepage.clickElement(CloseAlert);
		reportEvent(stepstatus, "Able to  CloseAlert", "Unable to CloseAlert", driver, true);
		
	}
	@FindBy(how = How.XPATH, using = "	//input[@value='DL EXTRACT'][1]")
	WebElement DLEXTRACT;
	public void selectserviceforDLExtract() {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
		stepstatus=basepage.clickElement(DLEXTRACT);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
		reportEvent(stepstatus, "Able to click on  DL Extract ", "Unable to click on DL Extract", driver, true);
//		stepstatus = basepage.clickElement(CloseAlert);
//		reportEvent(stepstatus, "Able to click on Confirm", "Unable to click on Confirm", driver, true);
		
	} 
	@FindBy(how = How.XPATH, using = "//input[@value='CHANGE OF ADDRESS IN DL']")
	WebElement ChangeofAddressinDL;
	public void selectserviceforChangeOfAddress() throws IOException, InterruptedException {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
	stepstatus = basepage.clickElement(ChangeofAddressinDL);
	reportEvent(stepstatus, "Able to click on ChangeofAddressinDL", "Unable to click on ChangeofAddressinDL",
			driver, true);

	}
	
	@FindBy(how = How.XPATH, using = "//input[@value='RENEWAL OF DL'][1]")
	WebElement RenewalofDL;
	public void selectserviceforRenewalOfDL(){

		stepstatus = basepage.clickElement(RenewalofDL);
		reportEvent(stepstatus, "Able to click on Renewal of DL", "Unable to click on Renewal of DL", driver, true);
	}



	@FindBy(how = How.XPATH, using = "//input[@value='ISSUE INTERNATIONAL DRIVING PERMIT']")
	WebElement IssueofInterNationalDrivingPermit;
	public void selectserviceforIssueOfIDP(){

		stepstatus = basepage.clickElement(IssueofInterNationalDrivingPermit);
		reportEvent(stepstatus, "Able to click on ISSUE OF IDP of DL", "Unable to click on ISSUE OF IDP Renewal of DL", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//input[@value='REPLACEMENT OF DL'][1]")
	WebElement ReplacementofDL;
	public void selectserviceforReplaceofDL() throws IOException, InterruptedException {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
	stepstatus = basepage.clickElement(ReplacementofDL);
	reportEvent(stepstatus, "Able to click on ReplacementofDL", "Unable to click on ReplacementofDL",
			driver, true);

	}
	@FindBy(how = How.XPATH, using = "//select[@id='stateCodeDLTr']")
	WebElement StateSelectionforAEDL;
	public void selectStateInAEDL() throws IOException, InterruptedException {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
	
	stepstatus = basepage.setOptionInSelectBox(StateSelectionforAEDL, prop.getProperty(getdata("State")));
	reportEvent(stepstatus, "Able to Select state in AEDL", "Unable to Select state in AEDL",
			driver, true);

	}
	@FindBy(how = How.XPATH, using = "//select[@id='rtoCodeDLTr']")
	WebElement RTOSelectionforAEDL;
	public void selectRTOInAEDL() throws IOException, InterruptedException {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
		
	stepstatus = basepage.setOptionInSelectBox(RTOSelectionforAEDL, getdata("RTO Selection"));
	reportEvent(stepstatus, "Able to Select RTO in AEDL", "Unable to Select RTO in AEDL",
			driver, true);

	}
	@FindBy(how = How.XPATH, using = "//input[@id='applEntLLNum']")
	WebElement InputLLNuminAEDL;
	public void InputLLNuminAEDL() throws IOException, InterruptedException {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
	stepstatus = basepage.setText(InputLLNuminAEDL, getdata("LL Number"));
	reportEvent(stepstatus, "Able to Select RTO in AEDL", "Unable to Select RTO in AEDL",
			driver, true);

	}
	@FindBy(how = How.XPATH, using = "//input[@value='Proceed']")
	WebElement ProceedinRevalidationofExpiredDL;
	public void SelectServiceRevalidationOfDL() throws IOException, InterruptedException {

		System.out.println("***********Welcome to ReValidation of DL************");
	
	WebElement check = driver.findElement(By.xpath("//input[@value='RENEWAL OF DL']"));
	String sts = check.getAttribute("disabled");
	System.out.println(sts);
	if (sts.equals("true")) {
		System.out.println("Check box is Disabled");
		stepstatus = basepage.clickElement(ProceedinRevalidationofExpiredDL);
		reportEvent(stepstatus, "Able to click on Proceed",
				"Unable to click on Proceedi", driver, true);
	} else {
		System.out.println("Enabled");
		stepstatus = basepage.clickElement(ProceedinRevalidationofExpiredDL);
		reportEvent(stepstatus, "Able to click on Proceedi", "Unable to click on Proceed", driver, true);
	}
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='trsaction_enve_proceed']")
	WebElement ProceedinServiceSelectionPage;	
	
	public void ClickProceedinServiceSelectionPage() throws IOException, InterruptedException {
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
		stepstatus= basepage.clickElement(ProceedinServiceSelectionPage);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
		
		reportEvent(stepstatus, "Able to click on ProceedinServiceSelectionPage ", "Unable to click on ProceedinServiceSelectionPage", driver, true);
	}

	
	
}