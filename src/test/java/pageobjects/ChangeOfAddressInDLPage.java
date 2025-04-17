package pageobjects;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import frameworkLibrary.BasePage;

public class ChangeOfAddressInDLPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public ChangeOfAddressInDLPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	/* Applying Change Of Address in DL */
	@FindBy(how = How.XPATH, using = "//input[@value='CHANGE OF ADDRESS IN DL']")
	WebElement ChangeofAddressinDL;
	@FindBy(how = How.XPATH, using = "//input[@value='Proceed']")
	WebElement ProceedinDLService;
	@FindBy(how = How.XPATH, using = "//input[@value='Permanent']")
	WebElement Permanent;
	@FindBy(how = How.XPATH, using = "//input[@value='Present']")
	WebElement PresentAddress;
	@FindBy(how = How.XPATH, using = "//input[@value='Both']")
	WebElement BothAddresses;
	@FindBy(how = How.XPATH, using = "//select[@name='prmStateCoa']")
	WebElement StateinDLService;
	@FindBy(how = How.XPATH, using = "//select[@name='prmDistCoa']")
	WebElement DistrictinDLService;
	@FindBy(how = How.XPATH, using = "//select[@name='prmMandalCoa']")
	WebElement Tahsil;
	@FindBy(how = How.XPATH, using = "//input[@name='prmPincodeCoa']")
	WebElement PincodeinDLService;
	@FindBy(how = How.XPATH, using = "//input[@value='Confirm']")
	WebElement ConfirminDLService;
	@FindBy(how = How.XPATH, using = "//input[@name='disclaimer']")
	WebElement DisclaimerinDLService;
	@FindBy(how = How.XPATH, using = "//span[@id='captchaViewer']/text()")
	WebElement CaptchainDLService;
	@FindBy(how = How.XPATH, using = "//input[@name='captchaByApplicant']")
	WebElement EnterCaptchainDLService;
	@FindBy(how = How.XPATH, using = "//input[@name='sub']")
	WebElement SubmitinDLService;
	@FindBy(how = How.XPATH, using = "//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]")
	WebElement ApplicationnoinDLService;
	@FindBy(how = How.XPATH, using = "//input[@id='captchaByApplicant']")
	WebElement CaptchaBoxinDLSerReqSub;
	@FindBy(how = How.XPATH, using = "//input[@id='bioaltmobileno']")
	WebElement EmergencyNumber;

		public void ChangeofAddressinDL (){

	System.out.println("***********Welcome to Change_of_Address_in_DL_Service************");
		}
		
		public void ClickOnPermanentbutton(){
			
	stepstatus = basepage.clickElement(Permanent);
	reportEvent(stepstatus, "Able to click on Permanent", "Unable to click on Permanent", driver, true);
	if (basepage.alertExist(driver)) {
		basepage.acceptAlert(driver);
	} else {
		basepage.dismissAlert(driver);
	}
		}
		
		
		public void SelectState(){	
	stepstatus = basepage.setOptionInSelectBox(StateinDLService, prop.getProperty(getdata("State")));
	reportEvent(stepstatus, "Able to Select StateinDLService", "Unable to Select StateinDLService", driver,true);
		}
		
		public void SelectDistrictdetails() {
			WebElement Dist = driver.findElement(By.xpath("//select[@name='prmDistCoa']"));
			Select District = new Select(Dist);
			List<WebElement> options = District.getOptions();
			for (int i = 0; i <= options.size() - 1; i++) {
				try {
					Dist = driver.findElement(By.xpath("//select[@name='prmDistCoa']"));
					District = new Select(Dist);
					options = District.getOptions();
					if (!options.get(1).getText().contains("Select")) {
						System.out.println(options.get(1).getText());
						District.selectByIndex(1);
						Thread.sleep(2000);
						WebElement SubDist = driver.findElement(By.xpath("//select[@name='prmMandalCoa']"));
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
	
			public void EnterPincode(){
	stepstatus = basepage.SetTextAndTAB(PincodeinDLService, "500081");
	reportEvent(stepstatus, "Able to Enter PincodeinDLService", "Unable to Enter PincodeinDLService", driver,
			true);
			}
			  
/*	driver.findElement(By.xpath("//input[@name='prmPincodeCoa']")).sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//input[@name='prmPincodeCoa']")).sendKeys(Keys.ENTER);
	
	*/
			public void ClickConfirminDLService(){
			stepstatus = basepage.clickElement(ConfirminDLService);
	reportEvent(stepstatus, "Able to click on Confirm", "Unable to click on Confirm", driver, true);
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

			@FindBy(how = How.XPATH, using = "//input[@name='Form1']")
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
			
			@FindBy(how = How.XPATH, using = "	//input[@id='Declaration1']")
			WebElement Declaration1;
			@FindBy(how = How.XPATH, using = "	//input[@id='Declaration2']")
			WebElement Declaration2;
			@FindBy(how = How.XPATH, using = "	//input[@id='Declaration3']")
			WebElement Declaration3;
			@FindBy(how = How.XPATH, using = "//input[@name='disclaimer']")
			WebElement Disclaimer;
			
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
			
			public void EnterEmergencyNumber(){
			stepstatus = basepage.setText(EmergencyNumber,"1234567890");	
			reportEvent(stepstatus, "Able to Enter Emergency Number", "Unable to Enter Emergency Number", driver, true);		
				
			}
			
				public void ClickOnSubmitButton(){
				stepstatus = basepage.clickElement(SubmitinDLService);

				if (alertExist(driver)) {
					acceptAlert(driver);
					
		
				}
				wait(5);
				if (alertExist(driver)) {
					acceptAlert(driver);
		
				}
				EnterEmergencyNumber();
				wait(3);
				stepstatus = basepage.clickElement(SubmitinDLService);
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
	
			
		}

