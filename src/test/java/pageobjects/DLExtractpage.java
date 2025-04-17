package pageobjects;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import actions.Action_215;
import frameworkLibrary.BasePage;
import utility.Flows;
import utility.Utilitymethods;

public class DLExtractpage extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;
	NewLLSubmissionPage NewLLRegistrtionPage;
	ApplicationStatusStage01Page applicationStatusstage01;
	Action_215 action_215;


	public DLExtractpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//select[@name='dlextractreasoncd']")
	WebElement ReasonforExtractofDLDetails;
	@FindBy(how = How.XPATH, using = "//input[@value='Confirm']")
	WebElement ConfirminIssueofDLExtract;
	@FindBy(how = How.XPATH, using = "//input[@name='disclaimer']")
	WebElement Disclaimer;
	@FindBy(how = How.XPATH, using = "	//input[@id='Declaration1']")
	WebElement Declaration1;
	@FindBy(how = How.XPATH, using = "	//input[@id='Declaration2']")
	WebElement Declaration2;
	@FindBy(how = How.XPATH, using = "	//input[@id='Declaration3']")
	WebElement Declaration3;
	@FindBy(how = How.XPATH, using = "//input[@id='captchaByApplicant']")
	WebElement CaptchaBoxinDLSerReqSub;
	@FindBy(how = How.XPATH, using = "//input[@id='subToDB']")
	WebElement SubmitbuttonforServiceReq;
	@FindBy(how = How.XPATH, using = "//input[@id='bioaltmobileno']")
	WebElement EmergencyNumber;
	@FindBy(how = How.XPATH, using = "//input[@id='aadhaarHoldingType0']")
	WebElement Submitwithoutaadharauthentification;
	@FindBy(how = How.XPATH, using = "//input[@id='submt']")
	WebElement Submit;
	@FindBy(how = How.XPATH, using = "//button[@id='generateSarathiotp']")
	WebElement Generateotp;
	@FindBy(how = How.XPATH, using = "//select[@name='surrOrgDL']")
	WebElement surrenderofDL;
	@FindBy(how = How.XPATH, using = "//input[@id='envaction_enve_confirm']")
	WebElement confirm;
	@FindBy(how = How.XPATH, using = "//select[@id='collectDL']")
	WebElement collectDL;
	@FindBy(how = How.XPATH, using = "(//button[@value = 'Generate OTP'])")
	WebElement GenerateOTP;
	@FindBy(how = How.XPATH, using = "//input[@id='verifySarathi']")
	WebElement AuthenticateWithSarathi;
	@FindBy(how = How.XPATH, using = "//input[@value='FEE PAYMENT']")
	WebElement Clickradio;
	@FindBy(how = How.XPATH, using = "//button[@id='applViewStages_0']")
	WebElement Proceed;
	@FindBy(how = How.XPATH, using = "//button[text()='x']")
	WebElement ClosePopUp;
	@FindBy(how = How.XPATH, using = "//a[text()='Cashier ']")
	WebElement Cashier;
	@FindBy(how = How.XPATH, using = "//input[@id='orgDonorYES']")
	WebElement OrganDonor;
	@FindBy(how = How.XPATH, using = "//input[@id='applNo']")
	WebElement Appno;
	@FindBy(how = How.XPATH, using = "//input[@id='print']") 
	WebElement printre;
	@FindBy(how = How.XPATH, using = "//a[normalize-space(text())='HOME']")
	WebElement HOME;
	@FindBy(how = How.XPATH, using = "//button[@id='calculateBtn']")
	WebElement Cal;
	@FindBy(how = How.XPATH, using = "//a[text()='RTO PAYMENTS']")
	WebElement RTOPay;
	@FindBy(how = How.XPATH, using = "//input[@id='applNo']")
	WebElement AppnoinFeePaymentPage;
	@FindBy(how = How.XPATH, using = "//input[@id='dob']")
	WebElement DOBinFeePaymentPage;
	@FindBy(how = How.XPATH, using = "//input[@id='first']")
	WebElement Paynow;
	@FindBy(how = How.XPATH, using = "//input[@name='button2']")
	WebElement Home;
	@FindBy(how = How.XPATH, using = "//input[@class='btn'][1]")
	WebElement Pressheretocontinue;
	@FindBy(how = How.XPATH, using = "//img[@alt='Continue to Login']")
	WebElement ContinuetoLogin;
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	WebElement Checkbox;
	@FindBy(how = How.XPATH, using = "//input[@name='button1']")
	WebElement Proceedforpayment;
	@FindBy(how = How.XPATH, using = "//input[@id='captchatext']")
	WebElement Captcha;
	@FindBy(how = How.XPATH, using = "//select[@id='bankslist']")
	WebElement Bank;
	@FindBy(how = How.XPATH, using = "//a[text()='Switchto']")
	WebElement SwitchTo;
	@FindBy(how = How.XPATH, using = "//button[@name='calculate']")
	WebElement calculatefee;
	@FindBy(how = How.XPATH, using = "//input[@value='Generate Receipt']")
	WebElement generatereceipt;
	@FindBy(how = How.XPATH, using = "//a[text()='Payments']")
	WebElement payments;
	@FindBy(how = How.XPATH, using = "(//a[@class='dropdown-toggle'])[1]")
	WebElement RTOpayments;
	@FindBy(how = How.XPATH, using = "//a[text()='RTO PAYMENTS']")
	WebElement RTOpayments2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"slotcnfrmbtn\"]")
	WebElement confirmtoslotbook;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'LOGOUT ')]")
	WebElement logout;
	@FindBy(how = How.XPATH, using = "//input[@class='btn btn-primary btn-success']")
	WebElement clickonurl;
	@FindBy(how = How.XPATH, using = "//select[@id='dlextractreasoncd']")
	WebElement ReasonForDLExtract;
	
	public void SelectReasonforExtractofDLDetails() {

		
		stepstatus = basepage.clickElement(ReasonForDLExtract);
		reportEvent(stepstatus, "Able to click on Confirm", "Unable to click on Confirm", driver, true);
	
	//	stepstatus = basepage.RobotKeysForSelectingOptionOne();
		reportEvent(stepstatus, "Able to Select ReasonforExtractofDLDetails",
				"Unable to Select ReasonforExtractofDLDetails", driver, true);
		
		

	}

	public void ClickConfirmButton() {
		stepstatus = basepage.clickElement(ConfirminIssueofDLExtract);
		reportEvent(stepstatus, "Able to click on Confirm", "Unable to click on Confirm", driver, true);
	}

	public void CheckBoxDisclaimers() {
		String TransactionName = getdata("TransactionName");
		if (TransactionName.equals("DL EXTRACT")) {
		stepstatus = basepage.clickElement(Disclaimer);
		reportEvent(stepstatus, "Able to click on Disclaimer", "Unable to click on Disclaimer", driver, true);
		stepstatus = basepage.clickElement(Declaration1);
		reportEvent(stepstatus, "Able to click on Declaration1", "Unable to click on Declaration1", driver, true);

//		stepstatus = basepage.clickElement(Declaration2);
//		reportEvent(stepstatus, "Able to click on Declaration2", "Unable to click on Declaration2", driver, true);

		stepstatus = basepage.clickElement(Declaration3);
		reportEvent(stepstatus, "Able to click on Declaration3", "Unable to click on Declaration3", driver, true);

	}else {
		stepstatus = basepage.clickElement(Disclaimer);
		reportEvent(stepstatus, "Able to click on Disclaimer", "Unable to click on Disclaimer", driver, true);
		stepstatus = basepage.clickElement(Declaration1);
		reportEvent(stepstatus, "Able to click on Declaration1", "Unable to click on Declaration1", driver, true);

		stepstatus = basepage.clickElement(Declaration2);
		reportEvent(stepstatus, "Able to click on Declaration2", "Unable to click on Declaration2", driver, true);

		stepstatus = basepage.clickElement(Declaration3);
		reportEvent(stepstatus, "Able to click on Declaration3", "Unable to click on Declaration3", driver, true);
	}
	}

	public void EnterCaptcha() {
		stepstatus = basepage.setText(CaptchaBoxinDLSerReqSub, "123456");
		reportEvent(stepstatus, "Able to Enter Captcha In DLService Submission",
				"Unable to Enter Captcha In DLService Submission", driver, true);
	}

	public void SelectOrganDonor() {

		stepstatus = basepage.clickElement(OrganDonor);
		reportEvent(stepstatus, "Able to click on OrganDonor", "Unable to click on OrganDonor", driver, true);

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
		reportEvent(stepstatus, "Able to Click DLSubmit ServiceReq button",
				"Unable to Click DLSubmit ServiceReq button", driver, true);
		String AckDL = driver.getTitle();
		System.out.println(AckDL);
		if (AckDL.equalsIgnoreCase("DL Services Acknowledgement")) {
			System.out.println("Title Matched");
			CaptureDetailsinDLServiceReqSubmission();
			capturedetailsType2();
		} else {
			System.out.println("Due to DL Service Request Code Changes Unable to Execute");
		}
	}

	public void EnterEmergencyNumber() {
		stepstatus = basepage.setText(EmergencyNumber, "1234567890");
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

	

	public void Submit() {
		stepstatus = basepage.clickElement(Submit);
		reportEvent(stepstatus, "Able to Click on Submit", "Unable to Click on Submit", driver, true);
	}

	public void GenerateOTP() {
		stepstatus = basepage.clickElement(Generateotp);
		reportEvent(stepstatus, "Able to Click on GenerateOTP", "Unable to Click on GenerateOTP", driver, true);
	}

	public void SelectYesOrNofromDropdown() {
		stepstatus = basepage.clickElement(surrenderofDL);
		Select select = new Select(surrenderofDL);
		select.selectByVisibleText("YES");
		System.out.println("Selected Yes");
		wait(10);
		// reportEvent(stepstatus, "Able to click on SelectYesfromDropdown", "Unable to
		// click on SelectYesfromDropdown", driver, true);

	}

	public void confirm() {
		stepstatus = basepage.clickElement(confirm);
		if (alertExist(driver)) {
			acceptAlert(driver);

		} else {
			System.out.println("There is no Confirmbutton");

		}
		reportEvent(stepstatus, "Able to Click on confirm", "Unable to Click on confirm", driver, true);
	}

	public void selecthowtocollectDL() {
		String Isdipreq = (getdata("IsDispatchHandReqd"));
		if (Isdipreq.equalsIgnoreCase("Y")) {
			stepstatus = basepage.clickElement(collectDL);
			Select select = new Select(collectDL);
			select.selectByVisibleText("By Post");
		} else {
			System.out.println("There is no How will you to collect DL");
		}
		
		 if(alertExist(driver)) {
				acceptAlert(driver);
			}else {
				System.out.println("There is no Confirmbutton");
			}
}

	public void Clickon_Cashier() {
		stepstatus = basepage.clickElement(Cashier);
		reportEvent(stepstatus, "Able to click Cashier", "Unable to click Cashier", driver, true);
	}

	public void mobileauthentication() throws IOException {
		DLExtractpage DLExtractpage = new DLExtractpage(driver);
//		NewLLRegistrtionPage.SetMobilenumber(getdata("Phone"));
		DLExtractpage.ClickonGenerateOTP();

		wait(10);
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		wait(5);
		utilitymethods.Getlogotp("OTP (One Time Password) For Self Authentication to Apply",
				 204, 210);
		DLExtractpage.ClickonAuthenticateWithSarathibutton();

	}
public void otpforLLorDLserviceslot() throws IOException {
	
	Utilitymethods utilitymethods = new Utilitymethods(driver);
	utilitymethods.Getlogotp("::securityCd::",
			 59, 65);
	wait(2);
	stepstatus = basepage.clickElement(confirmtoslotbook);
	reportEvent(stepstatus, "Able to click Confirm to slot book", "Unable to click confirm to slot book", driver, true);
	
}
	public void ClickonAuthenticateWithSarathibutton() {

		if (isEnabled(AuthenticateWithSarathi)) {
			System.out.println("Button Enabled");
			stepstatus = basepage.clickElement(AuthenticateWithSarathi);
			if (alertExist(driver)) {
				acceptAlert(driver);
				wait(2);

			} else {
				System.out.println("There is no Alertpresent");
			}
			reportEvent(stepstatus, "Able to click AuthenticateWithSarathi Button",
					"Unable to click AuthenticateWithSarathi Button", driver, true);

		}

		@SuppressWarnings("unused")
		String gettext = basepage.alertGetText(driver);
		if (basepage.alertExist(driver)) {

			basepage.acceptAlert(driver);
		} else {
			basepage.dismissAlert(driver);
		}
	}

	public void ClickonGenerateOTP() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", GenerateOTP);
		basepage.alertGetText(driver);
		if (basepage.alertExist(driver)) {
			String tct = alertGetText(driver);
			System.out.println(tct);
			basepage.acceptAlert(driver);
			wait(2);
			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
			executor1.executeScript("arguments[0].click();", GenerateOTP);

		} else {
			basepage.dismissAlert(driver);
		}
	}

	

	public void Enter_ApplicationNo() {
		stepstatus = basepage.SetTextAndTAB(Appno, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to Enter ApplicationNo ", "Unable to Enter ApplicationNo", driver, true);
	}

	public void Clickon_Calculate() {
		stepstatus = basepage.clickElement(Cal);
		scrooldown(driver);
	}
	
	public void Clickheretocalculatefee() {
		stepstatus = basepage.clickElement(calculatefee);
		scrooldown(driver);
	}
	public void Clickongeneratereceipt() {
		wait(2);
		stepstatus = basepage.clickElement(generatereceipt);
		scrooldown(driver);
	}
	

	public void Clickon_GenerateRecipt() {
		scrooldown(driver);
		stepstatus = basepage.clickElement(printre);
		reportEvent(stepstatus, "Able to click on generate receipt", "Unable to click on generate receipt", driver, true);
		stepstatus = basepage.clickElement(HOME);
	}

	

	public void Clickon_RTOPayments() {
		stepstatus = basepage.clickElement(RTOPay);
		reportEvent(stepstatus, "Able to click RTOPayments", "Unable to click RTOPayments", driver, true);
	}

	public void Set_AppNoinFeePaymentPage() {
		stepstatus = basepage.setText(AppnoinFeePaymentPage, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to Enter Application Number ", "Unable to Enter Application Number", driver);
	}

	public void Set_DOBinFeePaymentPage() {
		stepstatus = basepage.SetTextAndTAB(DOBinFeePaymentPage, getdata("DateofBirth"));
		reportEvent(stepstatus, "Able to Enter Date of Birth ", "Unable to Enter Date of Birth", driver);
	}

	public void SelectBank(String Option) {
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 20); WebElement aboutMe;
		 * aboutMe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//select[@name='bankslist']")));
		 */
		try {
			// scrooldown(driver);
			stepstatus = basepage.setOptionInSelectBox(Bank, Option);
			reportEvent(stepstatus, "Able to Select Bank", "Unable to Select Bank", driver, true);
		} catch (StaleElementReferenceException e) {
			// scrooldown(driver);
			stepstatus = basepage.setOptionInSelectBox(Bank, Option);
			reportEvent(stepstatus, "Able to Select Bank", "Unable to Select Bank", driver, true);
		}

	}

	public void SetCaptcha() {

		String env = prop.getProperty("ApplicationURL");
		if (env.equalsIgnoreCase("SarathiProd")) {
			driver.findElement(By.xpath("//input[@id='captchatext']")).sendKeys("123456");
		} else {
			stepstatus = basepage.setText(Captcha, Captcha.getAttribute("value"));
			reportEvent(stepstatus, "Able to Enter Captcha", "Unable to Enter Captcha", driver, true);
		}

//	WebElement ref = driver.findElement(By.xpath("//input[1][@id='abc']"));
//	String captcha = ref.getAttribute("value").replaceAll("\\s", "");
//	System.out.println("Captcha in feepayment page applicant side " + captcha);
//	stepstatus = basepage.setText(Captcha,captcha);
//	 reportEvent(stepstatus, "Able to Enter Captcha", "Unable to Enter Captcha", driver, true);
	}

	public void Clickon_Paynow_Button() {
		stepstatus = basepage.clickElement(Paynow);
		reportEvent(stepstatus, "Able to click Paynow button", "Unable to click Paynow button", driver, true);
	}

	public void Clickon_Checkbox() {
		stepstatus = basepage.clickElement(Checkbox);
		reportEvent(stepstatus, "Able to click Paynow button", "Unable to click Paynow button", driver, true);
	}

	public void Clickon_Proceedforpayment() {
		stepstatus = basepage.clickElement(Proceedforpayment);
		reportEvent(stepstatus, "Able to click Paynow button", "Unable to click Paynow button", driver, true);
		wait(7);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {
			basepage.dismissAlert(driver);
		}
	}

	public void Clickon_ContinuetoLogin_Button() {
		stepstatus = basepage.clickElement(ContinuetoLogin);
		reportEvent(stepstatus, "Able to click ContinuetoLogin button", "Unable to click ContinuetoLogin button",
				driver, true);
	}

	public void Clickon_Pressheretocontinue_Button() {
		stepstatus = basepage.clickElement(Pressheretocontinue);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			System.out.println(basepage.alertGetText(driver));
			String title = driver.getTitle();
			if (title.equals("::Payment Success ACK ::")) {
				setdata("StatusofFeePayment", "Success");
			} else {
				setdata("StatusofFeePayment", "Fail");
			}

		} else {
			basepage.dismissAlert(driver);
		}
	}

	public void Clickon_Home_Button() {
		stepstatus = basepage.clickElement(Home);
		reportEvent(stepstatus, "Able to click Home button", "Unable to click Home button", driver, true);
	}
	
	public void SwitchTORTOPayments() {
		stepstatus=basepage.clickElement(SwitchTo);
		reportEvent(stepstatus, "Able to Click on switchto", "Unable to Click on switchto", driver, true);
		stepstatus=basepage.clickElement(payments);
		reportEvent(stepstatus, "Able to Click on payments", "Unable to Click on payments", driver, true);
		LoginPage RTO = new LoginPage(driver);
		RTO.VerifyRTOSelection();
		stepstatus=basepage.clickElement(RTOpayments);
		reportEvent(stepstatus, "Able to Click on RTOpayments", "Unable to Click on RTOpayments", driver, true);
		stepstatus=basepage.clickElement(RTOpayments2);
		reportEvent(stepstatus, "Able to Click on RTOpayments2", "Unable to Click on RTOpayments2", driver, true);	
	}
	public void ClickOnLogout() {
		stepstatus = basepage.clickElement(logout);
		reportEvent(stepstatus, "Able to click logout button", "Unable to click logout button", driver, true);
	}
	public void ClickOnURL() {
		stepstatus = basepage.clickElement(clickonurl);
		reportEvent(stepstatus, "Able to click clickonurl", "Unable to click clickonurl", driver, true);
	}
	
	public void Clickon_Proceed_Button() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		if (basepage.clickElement(Clickradio)) {
			stepstatus = basepage.clickElement(Proceed);
			wait(5);
			try {
				if (alertExist(driver) == true) {
					System.out.println("RTO Payment is Processing");
					acceptAlert(driver);
					wait(3);
					String title = driver.getTitle();
					if (title.equalsIgnoreCase("Home")) {
						wait(2);
						if (isDisplayed(ClosePopUp) == true) {
							ClosePopUp.click();
						} else {
							System.out.println("There is no Dialog Model Popup");
						}
						// driver.findElement(By.xpath("//button[@id = 'applViewStages_0']")).click();
						Flows validate = new Flows(driver);
						 wait(4);
						validate.Login();
						wait(2);
						SwitchTORTOPayments();
//						Clickon_Cashier();
//						Clickon_RTOPayments();
						wait(2);
						Enter_ApplicationNo();
						wait(2);
						Clickheretocalculatefee();
						wait(2);
						String parentWindowHandle = driver.getWindowHandle();
						Clickongeneratereceipt();
						wait(3);
						Set<String> allWindowHandles = driver.getWindowHandles();
						 for (String windowHandle : allWindowHandles) {
					            if (!windowHandle.equals(parentWindowHandle)) {
					            	wait(3);
					                driver.switchTo().window(windowHandle);
					                break;
					            }
					        }
//						 driver.close();
						 wait(6);
						 driver.switchTo().window(parentWindowHandle);
						wait(4);
						ClickOnLogout();
						wait(2);
						ClickOnURL();
						wait(2);
						StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
						stateSelectionPage.Selectstatename(getdata("State"));
						StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
						stateSpecificHomePage.closeContactlessLicenceServicesPopup();
						wait(2);
						action_215 = new Action_215(driver);
						action_215.applicationstatus();
						Flows flows = new Flows(driver);
						flows.VerifyFlows();
						flows.RTOLevel_Status();
					}

				} else {
					System.out.println("Public Payment is Processing");

					Set_AppNoinFeePaymentPage();
					Set_DOBinFeePaymentPage();
					Clickon_Calculate();
                    wait(5);
					SelectBank(getdata("SelectBankforFeePayment"));
					wait(10);
					SetCaptcha();
					Clickon_Paynow_Button();
					Clickon_Checkbox();
					Clickon_Proceedforpayment();
					Clickon_ContinuetoLogin_Button();
					Clickon_Pressheretocontinue_Button();
					Clickon_Home_Button();

					/*
					 * WebElement applno = driver.findElement(By.xpath("//input[@name = 'apno']"));
					 * Boolean applnostatus = applno.isSelected(); WebElement dateofbirth
					 * =driver.findElement(By.xpath("//input[@name = 'dob']")); Boolean
					 * dateofbirthstatus =dateofbirth.isSelected(); if(applnostatus.equals(false) &&
					 * dateofbirthstatus.equals(false)) {
					 * 
					 * applno.sendKeys(getdata("ApplicationNo"));
					 * dateofbirth.sendKeys(getdata("DateofBirth"));
					 * driver.findElement(By.xpath("//button[@id='calculateBtn']")).click(); } else
					 * {
					 * 
					 * System.out.println("Application number and Date of birth are already fetched"
					 * ); } System.out.println("Next step is select bank"); wait(20);
					 * SelectBank("STATE BANK OF HYDERABAD"); wait(10); SetCaptcha();
					 * Clickon_Paynow_Button(); Clickon_Checkbox(); Clickon_Proceedforpayment();
					 * Clickon_ContinuetoLogin_Button(); Clickon_Pressheretocontinue_Button();
					 * Clickon_Home_Button();
					 */
				}

			} catch (UnhandledAlertException e) {
				System.out.println("Payment Exception");
			}

		}
	}

}
