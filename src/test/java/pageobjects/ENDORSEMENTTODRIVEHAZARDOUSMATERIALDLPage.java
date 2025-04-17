package pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class ENDORSEMENTTODRIVEHAZARDOUSMATERIALDLPage extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;
	
	
	public ENDORSEMENTTODRIVEHAZARDOUSMATERIALDLPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//input[@name='issueDate']")
	WebElement TrainingCertificateISSUEDATE;
	@FindBy(how = How.XPATH, using = "//input[@name='disclaimer']")
	WebElement Disclaimer;
	@FindBy(how = How.XPATH, using = "//input[@name='certificate']")
	WebElement TrainingCertificateNumber;
	@FindBy(how = How.XPATH, using = "//SELECT[@NAME='drivingschool']")
	WebElement SelectISSUEDBY;
	@FindBy(how = How.XPATH, using = "//INPUT[@NAME='placeOfIssue']")
	WebElement PLACEOFISSUE;
	@FindBy(how = How.XPATH, using = "//INPUT[@NAME='languageKnown']")
	WebElement LANGUAGESKNOWN;
	@FindBy(how = How.XPATH, using = "//INPUT[@NAME='language'][1]")
	WebElement READANDWRITE;
	@FindBy(how = How.XPATH, using = "//INPUT[@VALUE='Confirm']")
	WebElement CONFIRM;
	@FindBy(how = How.XPATH, using = "	//input[@id='Declaration1']")
	WebElement Declaration1;
	@FindBy(how = How.XPATH, using = "	//input[@id='Declaration2']")
	WebElement Declaration2;
	@FindBy(how = How.XPATH, using = "	//input[@id='Declaration3']")
	WebElement Declaration3;
	@FindBy(how = How.XPATH, using = "//input[@id='orgDonorYES']")
	WebElement OrganDonor ;
	@FindBy(how = How.XPATH, using = "//input[@id='captchaByApplicant']")
	WebElement CaptchaBoxinDLSerReqSub;
	@FindBy(how = How.XPATH, using = "//input[@id='subToDB']")
	WebElement SubmitbuttonforServiceReq;
	@FindBy(how = How.XPATH, using = "//input[@id='bioaltmobileno']")
	WebElement EmergencyNumber;
	
	public void Enter_TrainingCertificateNumber() {
		stepstatus = basepage.SetTextAndTAB(TrainingCertificateNumber, getdata("CertificateNo"));
		reportEvent(stepstatus, "Able to Enter TrainingCertificateNumber ", "Unable to Enter TrainingCertificateNumber", driver, true);
	}
	
	
	public void Enter_TrainingCertificateISSUEDATE() {
		stepstatus = basepage.SetTextAndTAB(TrainingCertificateISSUEDATE, getdata("CertificateISSUEDATE"));
		reportEvent(stepstatus, "Able to Enter TrainingCertificateISSUEDATE ", "Unable to Enter TrainingCertificateISSUEDATE", driver, true);
	}
	public void SelectISSUEDBY(){
		stepstatus = basepage.setOptionInSelectBox(SelectISSUEDBY, "HZ5");
		reportEvent(stepstatus, "Able to Select ISSUEDBY", "Unable to Select ISSUEDBY", driver, true);
		}
	
	public void EnterPLACEOFISSUE(){
		stepstatus = basepage.setText(PLACEOFISSUE,"TENALI");
		reportEvent(stepstatus, "Able to Enter PLACEOFISSUE", "Unable to Enter PLACEOFISSUE", driver, true);
		}
	public void EnterLANGUAGESKNOWN(){
		stepstatus = basepage.setText(LANGUAGESKNOWN,"qwefsdf");
		reportEvent(stepstatus, "Able to Enter LANGUAGESKNOWN", "Unable to Enter LANGUAGESKNOWN", driver, true);
		}
	public void ClickonREADANDWRITE() {
		stepstatus = basepage.clickElement(READANDWRITE);
	}
	public void ClickonCONFIRM() {
		stepstatus = basepage.clickElement(CONFIRM);
	}
	public void CheckBoxDisclaimers(){
		
		stepstatus = basepage.clickElement(Disclaimer);
		reportEvent(stepstatus, "Able to click on Disclaimer", "Unable to click on Disclaimer", driver, true);
		stepstatus=basepage.clickElement(Declaration1);
		reportEvent(stepstatus, "Able to click on Declaration1", "Unable to click on Declaration1", driver, true);
		stepstatus = basepage.clickElement(Declaration2);
		reportEvent(stepstatus, "Able to click on Declaration2", "Unable to click on Declaration2", driver, true);
		stepstatus=basepage.clickElement(Declaration3);
		reportEvent(stepstatus, "Able to click on Declaration3", "Unable to click on Declaration3", driver, true);
		
		}
	public void SelectOrganDonor(){
		
		stepstatus = basepage.clickElement(OrganDonor);
		reportEvent(stepstatus, "Able to click on OrganDonor", "Unable to click on OrganDonor", driver, true);	
	}
	public void EnterCaptcha(){
		stepstatus = basepage.setText(CaptchaBoxinDLSerReqSub,"123456");
		reportEvent(stepstatus, "Able to Enter Captcha In DLService Submission", "Unable to Enter Captcha In DLService Submission", driver, true);
		}
	public void EnterEmergencyNumber(){
		stepstatus = basepage.setText(EmergencyNumber,"1234567890");	
		reportEvent(stepstatus, "Able to Enter Emergency Number", "Unable to Enter Emergency Number", driver, true);		
			
		}
	public void CaptureDetailsinDLServiceReqSubmission() {
		AppNum = App_NO(driver, "//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]");
		System.out.println(AppNum);
		DOB = DOB(driver, "//table/tbody/tr[2]/td[3]/following-sibling::td");
		System.out.println(DOB);
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("DL Services Acknowledgement")) {
			System.out.println("Editing in Excel");
			setdata("ApplicationNo", AppNum.substring(3).trim());
			setdata("DateofBirth", DOB.substring(3).trim());

		} else {
			System.out.println("DL Services Acknowledgement is not Generated");
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
	}
	public void ClickSubmitForServiceReq() throws IOException, InterruptedException {
		stepstatus = basepage.clickElement(SubmitbuttonforServiceReq);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			
		} else {
			basepage.dismissAlert(driver);
		}
		EnterEmergencyNumber();
		stepstatus = basepage.clickElement(SubmitbuttonforServiceReq);
		reportEvent(stepstatus, "Able to Click DLSubmit ServiceReq button", "Unable to Click DLSubmit ServiceReq button", driver, true);
		String AckDL=driver.getTitle();
		System.out.println(AckDL);
		if(AckDL.equalsIgnoreCase("DL Services Acknowledgement")){
			System.out.println("Title Matched");
			CaptureDetailsinDLServiceReqSubmission();
			capturedetailsType2();
		}
		else{
			System.out.println("Due to DL Service Request Code Changes Unable to Execute");
		}
	}
}
