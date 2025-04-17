package pageobjects;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import frameworkLibrary.BasePage;

public class IssueOfIdpPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public IssueOfIdpPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@value='Proceed']")
	WebElement ProceedinIssueofInterNationalDrivingPermit;
	@FindBy(how = How.XPATH, using = "//input[@name='pofbirth']")
	WebElement BirthPlace;
	@FindBy(how = How.XPATH, using = "//select[@name='country']")
	WebElement BirthCountry;
	@FindBy(how = How.XPATH, using = "//input[@name='passno']")
	WebElement PassportNumber;
	@FindBy(how = How.XPATH, using = "//input[@name='passvaltill']")
	WebElement PassportValidtill;
	@FindBy(how= How.XPATH, using ="//input[@id='chooseNO']")
	WebElement RadioNo1;
	@FindBy(how= How.XPATH, using ="//input[@id='form11bDisNO']")
	WebElement RadioNo2;
	@FindBy(how = How.XPATH, using = "//select[@name='tovisit']")
	WebElement CountryforwhichVISAisgranted;
	@FindBy(how = How.XPATH, using = "//input[@name='visano']")
	WebElement VisaNumber;
	@FindBy(how = How.XPATH, using = "//input[@name='visavaltill']")
	WebElement VisaValidtill;
	@FindBy(how = How.XPATH, using = "//select[@name='cov_req']")
	WebElement COVgradesforwhichIDPisrequested;
	@FindBy(how = How.XPATH, using = "//input[@value='Confirm']")
	WebElement ConfirminIssueofInterNationalDrivingPermit;
	@FindBy(how = How.XPATH, using = "//input[@name='disclaimer']")
	WebElement DisclaimerinIssueofInterNationalDrivingPermit;
	@FindBy(how = How.XPATH, using = "//span[@id='captchaViewer']/text()")
	WebElement CaptchainIssueofInterNationalDrivingPermit;
	@FindBy(how = How.XPATH, using = "//input[@name='captchaByApplicant']")
	WebElement EnterCaptchainIssueofInterNationalDrivingPermit;
	@FindBy(how = How.XPATH, using = "//input[@id='subToDB']")
	WebElement SubmitinIssueofInterNationalDrivingPermit;
	@FindBy(how = How.XPATH, using = "//input[@id='Declaration1']")
	WebElement Declaration1;
	@FindBy(how = How.XPATH, using = "//input[@id='Declaration2']")
	WebElement Declaration2;
	@FindBy(how = How.XPATH, using = "//input[@id='Declaration3']")
	WebElement Declaration3;
	@FindBy(how = How.XPATH, using = "//input[@id='captchaByApplicant']")
	WebElement CaptchaBoxinDLSerReqSub;
	@FindBy(how = How.XPATH, using = "//input[@name='disclaimer']")
	WebElement Disclaimer;
	@FindBy(how = How.XPATH, using = "//input[@id='subToDB']")
	WebElement SubmitbuttonforServiceReq;
	@FindBy(how = How.XPATH, using = "//input[@id='bioaltmobileno']")
	WebElement EmergencyNumber;
	
	public void IssueOfIDP()throws IOException, InterruptedException {

	System.out.println("***********Welcome to Issue of International Driving Permit_in_DL_Service************");
	
	}
	public void EnterBirthPlace(){
	stepstatus = basepage.setText(BirthPlace, "Hyderabad");
	reportEvent(stepstatus, "Able to Enter BirthPlace", "Unable to Unable to Enter BirthPlace", driver, true);
	}

	public void EnterBirthCountry(){
	
	stepstatus = basepage.setOptionInSelectBox(BirthCountry, "INDIA");
	reportEvent(stepstatus, "Able to Select BirthCountry", "Unable to Select BirthCountry ", driver, true);
	}
	public void EnterPassportNumber(){
	stepstatus = basepage.setText(PassportNumber, "QWERTY1618");
	reportEvent(stepstatus, "Able to Enter PassportNumber", "Unable to Unable to Enter PassportNumber", driver,
			true);
	}
	public void EnterPassportValidity(){
	stepstatus = basepage.setText(PassportValidtill, "01-10-2039");
	reportEvent(stepstatus, "Able to Enter PassportValidtill", "Unable to Unable to Enter PassportValidtill",
			driver, true);
	}
	public void HaveyoubeendisqualifiedRadiobutton(){
	stepstatus = basepage.clickElement(RadioNo1);
	reportEvent(stepstatus, "Able to click on radio button in reason1",
			"Unable to click on radio button1 in reason1 ", driver, true);
	}
	public void HaveyoubeenbarredRadiobutton(){
	stepstatus = basepage.clickElement(RadioNo2);
	reportEvent(stepstatus, "Able to click on radio button in reason2",
			"Unable to click on radio button1 in reason2 ", driver, true);
	}
	public void SelectCountryforIDP(){
	stepstatus = basepage.setOptionInSelectBox(CountryforwhichVISAisgranted, "UNITED STATES OF AMERICA");
	reportEvent(stepstatus, "Able to Select CountryforwhichVISAisgranted",
			"Unable to Select CountryforwhichVISAisgranted ", driver, true);
	}
	public void EnterVisaNumber(){
	stepstatus = basepage.setText(VisaNumber, "ASDFGHJKL36");
	reportEvent(stepstatus, "Able to Enter PassportValidtill", "Unable to Unable to Enter PassportValidtill",
			driver, true);
	}
	public void EnterVisaValidity(){
	stepstatus = basepage.setText(VisaValidtill, "01-06-2028");
	reportEvent(stepstatus, "Able to Enter PassportValidtill", "Unable to Unable to Enter PassportValidtill",
			driver, true);
	}
	
	public void SelectCOVGradeidp() {
		WebElement ele = driver.findElement(By.xpath("//select[@name='cov_req']"));
		Select s = new Select(ele);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i <= options.size() - 1; i++) {

			try {
				ele = driver.findElement(By.xpath("//select[@name='cov_req']"));
				s = new Select(ele);
				options = s.getOptions();
				if (!options.get(1).getText().contains("Select")) {

					System.out.println(options.get(1).getText());
					s.selectByVisibleText(options.get(1).getText());
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}
	
	public void ClickConfirmButtonForIDP(){
	stepstatus = basepage.clickElement(ConfirminIssueofInterNationalDrivingPermit);
	reportEvent(stepstatus, "Able to click on ConfirminIssueofInterNationalDrivingPermit",
			"Unable to click on ConfirminIssueofInterNationalDrivingPermit", driver, true);
	}
	
	public void Form_1_Check() {
		ConnecttoExcel(prop.getProperty("form1_required_dlservreq"), prop.getProperty("DataFile_State"));
		
		if (outcome.equalsIgnoreCase("Y")) {
			Fill_Form1Details();
		} else if (outcome.equalsIgnoreCase("N")) {
			System.out.println("There is no Form1 check for this state");
		} else {
			System.out.println("******************FORM1**********************");
		}

	}

	public void Fill_Form1Details() {
		ClickonForm1_buttton();
		SwitchtoWindowByTitle("formOne", driver);
		List<WebElement> radio = driver.findElements(By.xpath("//label[text()='NO']/preceding-sibling::input[1]"));
		System.out.println(radio);
		
		for (WebElement subradio : radio) {

			String state = getdata("State");
			if (state.equalsIgnoreCase("OD")) {
				subradio.click();
			} else {

				subradio.click();
				
			}

		}
		driver.findElement(By.xpath("//input[@id = 'scopebY']")).click();
		ClickonDeclareCheckbox();
		ClickonSubmitbuttonatForm1();
		closeWindowByTitle("FormOneSuccess", driver);
		SwitchtoWindowByTitle("DL Services", driver);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Self Declaration (Form1)']")
	WebElement Form_one;

	public void ClickonForm1_buttton() {
		stepstatus = basepage.clickElement(Form_one);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='declaringcheck']")
	WebElement DeclareForm1;

	public void ClickonDeclareCheckbox() {
		stepstatus = basepage.clickElement(DeclareForm1);
	}

	@FindBy(how = How.XPATH, using = "//button[@id='getFormOneDetails_newll_submit']")
	WebElement SubmitbuttonatForm1;

	public void ClickonSubmitbuttonatForm1() {
		stepstatus = basepage.clickElement(SubmitbuttonatForm1);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {
			basepage.dismissAlert(driver);
		}
	}
	
	public void CheckBoxDisclaimers(){
		
	
		stepstatus=basepage.clickElement(Declaration1);
		reportEvent(stepstatus, "Able to click on Declaration1", "Unable to click on Declaration1", driver, true);
		stepstatus=basepage.clickElement(Declaration3);
		reportEvent(stepstatus, "Able to click on Declaration3", "Unable to click on Declaration3", driver, true);
		stepstatus = basepage.clickElement(Disclaimer);
		reportEvent(stepstatus, "Able to click on Disclaimer", "Unable to click on Disclaimer", driver, true);
		
		}
		
		@FindBy(how = How.XPATH, using = "//input[@id='orgDonorYES']")
		WebElement OrganDonor ;
		public void SelectOrganDonor(){
			
			stepstatus = basepage.clickElement(OrganDonor);
			reportEvent(stepstatus, "Able to click on OrganDonor", "Unable to click on OrganDonor", driver, true);	

		}
		
		public void EnterCaptcha(){
		stepstatus = basepage.setText(CaptchaBoxinDLSerReqSub,"123456");
		reportEvent(stepstatus, "Able to Enter Captcha In DLService Submission", "Unable to Enter Captcha In DLService Submission", driver, true);
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
		public void EnterEmergencyNumber(){
			stepstatus = basepage.setText(EmergencyNumber,"1234567890");	
			reportEvent(stepstatus, "Able to Enter Emergency Number", "Unable to Enter Emergency Number", driver, true);		
				
			}
	
	
	
	
		public void ClickOnDisclaimer(){
	stepstatus = basepage.clickElement(DisclaimerinIssueofInterNationalDrivingPermit);
	reportEvent(stepstatus, "Able to click on DisclaimerinIssueofInterNationalDrivingPermit",
			"Unable to click on DisclaimerinIssueofInterNationalDrivingPermit", driver, true);
		
	wait(15);
		}
		
}


			


			
			
			
