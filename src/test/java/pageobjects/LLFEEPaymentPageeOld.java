package pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.shaded.snakeyaml.introspector.Property;

import frameworkLibrary.BasePage;
import utility.Flows;


public class LLFEEPaymentPageeOld extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public LLFEEPaymentPageeOld(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelements
	@FindBy(how = How.XPATH, using = "//span[1][text()='Apply Online']")
	WebElement Applyonline;
	@FindBy(how = How.XPATH, using = "//a[text()='Application Status']")
	WebElement Applicationstatus;
	@FindBy(how = How.XPATH, using = "//input[@name='applNum']")
	WebElement Application_Number;
	@FindBy(how = How.XPATH, using = "//input[@name='dateOfBirth']")
	WebElement DateofBirth;
	@FindBy(how = How.XPATH, using = "//input[@id='submit']")
	WebElement Submit;
	@FindBy(how = How.XPATH, using = "//input[@value='FEE PAYMENT']")
	WebElement Clickradio;
	@FindBy(how = How.XPATH, using = "//button[@id='applViewStages_0']")
	WebElement Proceed;
	
	
	
	
	
	@FindBy(how = How.XPATH, using = "//img[@alt='Continue to Login']")
	WebElement ContinuetoLogin;
	@FindBy(how = How.XPATH, using = "//input[@class='btn'][1]")
	WebElement Pressheretocontinue;
	@FindBy(how = How.XPATH, using = "//input[@name='success']")
	WebElement PrintReceipt;
	@FindBy(how = How.XPATH, using = "//input[@name='button2']")
	WebElement Home;
	@FindBy(how = How.XPATH, using = "//a[normalize-space(text()) = 'HOME']")
	WebElement Homeatmenu;
	@FindBy(how = How.XPATH, using = "//input[@value='Generate Receipt']")
	WebElement GenerateRecipt;
	@FindBy(how = How.XPATH, using = "//button[text()='x']")
	WebElement ClosePopUp;
	@FindBy(how = How.XPATH, using = "//select[@name='stName']")
	WebElement Selectstatename;
//*****FEE PAYMENT***////
	@FindBy(how = How.XPATH, using = "//input[@id='applNo']")
	WebElement AppnoinFeePaymentPage;
	@FindBy(how = How.XPATH, using = "//input[@id='dob']")
	WebElement DOBinFeePaymentPage;
	
	
	// Related methods to perform operation on webelements
	public void Selectstatename(String Option) {
		stepstatus = basepage.setOptionInSelectBox(Selectstatename, Option);
		reportEvent(stepstatus, "Able to Select Statename", "Unable to Select Statename", driver, true);
	}

	public void Clickon_Applyonline() {
		stepstatus = basepage.clickElement(Applyonline);
		reportEvent(stepstatus, "Able to click Apply online Link", "Unable to click Apply online Link", driver, true);
	}

	public void Clickon_Application_Status_Link() {
		stepstatus = basepage.clickElement(Applicationstatus);
		reportEvent(stepstatus, "Able to click on Applicationstatus Link", "Unable to cclick on Applicationstatus Link",
				driver, true);
	}

	public void Set_Application_Number(String value) {
		stepstatus = basepage.setText(Application_Number, value);
		reportEvent(stepstatus, "Able to Enter Application Number ", "Unable to Enter Application Number", driver,
				true);
	}

	public void Set_DateofBirth(String value) {
		stepstatus = basepage.setText(DateofBirth, value);
		reportEvent(stepstatus, "Able to Enter Date of Birth ", "Unable to Enter Date of Birth", driver, true);
	}

	public void Clickon_Submit_Button() {
		stepstatus = basepage.clickElement(Submit);
		reportEvent(stepstatus, "Able to click submit button", "Unable to click submit button", driver, true);
	}

	public void Do_ScrollDown() {
		stepstatus = basepage.scrooldown(driver);
		reportEvent(stepstatus, "Able to do Scrolldown", "Unable to do Scrolldown", driver, true);
	}

	public void Set_AppNoinFeePaymentPage() {
		stepstatus = basepage.setText(AppnoinFeePaymentPage, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to Enter Application Number ", "Unable to Enter Application Number", driver);
	}
	
	public void Set_DOBinFeePaymentPage() {
		stepstatus = basepage.SetTextAndTAB(DOBinFeePaymentPage, getdata("DateofBirth"));
		reportEvent(stepstatus, "Able to Enter Date of Birth ", "Unable to Enter Date of Birth", driver);
	}

	public void Clickon_Proceed_Button() throws IOException, InterruptedException {
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
						//driver.findElement(By.xpath("//button[@id = 'applViewStages_0']")).click();
						Flows validate = new Flows(driver);
						validate.Login();
						Clickon_Cashier();
						Clickon_RTOPayments();
						Enter_ApplicationNo();
						Clickon_Calculate();
						Clickon_GenerateRecipt();
					}

				} 
				
				else {
					System.out.println("Public Payment is Processing");

					Set_AppNoinFeePaymentPage();
					Set_DOBinFeePaymentPage();
					Clickon_Calculate();
					 ApplicationFeeforLLDLTestPage applicationFeeforLLDLTestPage = new ApplicationFeeforLLDLTestPage(driver);
					 applicationFeeforLLDLTestPage.SelectBank(getdata("SelectBankforFeePayment"));
					  applicationFeeforLLDLTestPage.EnterCaptcha();
					  applicationFeeforLLDLTestPage.Clickon_Paynow_Button();
					  FeepaymentTermsandconditionsPage feepaymentTermsandconditionsPage = new FeepaymentTermsandconditionsPage(driver);
					  feepaymentTermsandconditionsPage.ClickonCheckbox_Termsandconditions();
					  feepaymentTermsandconditionsPage.Clickon_Proceedforpayment(); SBHIntroPage
					  sBHIntro = new SBHIntroPage(driver);
					  sBHIntro.Clickon_ContinuetoLogin_Button(); 
					  SBHhomePage sBHhome = new SBHhomePage(driver); 
					  sBHhome.Clickon_Pressheretocontinue_Button();
					  ApplicationFeePaymentSuccessAckPage applicationFeePaymentSuccessAck= new ApplicationFeePaymentSuccessAckPage(driver); 
					  applicationFeePaymentSuccessAck.Clickon_NextbuttoninApplicationFeePaymentSuccessAck();
					 
						/*
						 * SelectBank(getdata("SelectBankforFeePayment")); wait(10); SetCaptcha();
						 * Clickon_Paynow_Button(); Clickon_Checkbox(); Clickon_Proceedforpayment();
						 * Clickon_ContinuetoLogin_Button(); Clickon_Pressheretocontinue_Button();
						 * Clickon_Home_Button();
						 */

					/*WebElement applno = driver.findElement(By.xpath("//input[@name = 'apno']"));
					Boolean applnostatus = applno.isSelected();
					WebElement dateofbirth =driver.findElement(By.xpath("//input[@name = 'dob']"));
					Boolean dateofbirthstatus =dateofbirth.isSelected();
					if(applnostatus.equals(false) && dateofbirthstatus.equals(false)) {
						
						applno.sendKeys(getdata("ApplicationNo"));
						dateofbirth.sendKeys(getdata("DateofBirth"));
						driver.findElement(By.xpath("//button[@id='calculateBtn']")).click();
					}
					else {
						
						System.out.println("Application number and Date of birth are already fetched");
					}
					System.out.println("Next step is select bank");
					wait(20);
					SelectBank("STATE BANK OF HYDERABAD");
					wait(10);
					SetCaptcha();
					Clickon_Paynow_Button();
					Clickon_Checkbox();
					Clickon_Proceedforpayment();
					Clickon_ContinuetoLogin_Button();
					Clickon_Pressheretocontinue_Button();
					Clickon_Home_Button();*/
				}

			} catch (UnhandledAlertException e) {
				System.out.println("Payment Exception");
			}

		}

	}

	public void ApplicationstatusFeepayment() {
		//Paymenht for MZ Changes
		Set_AppNoinFeePaymentPage();
		Set_DOBinFeePaymentPage();
		Clickon_Calculate();
		wait(10);
		 ApplicationFeeforLLDLTestPage applicationFeeforLLDLTestPage = new ApplicationFeeforLLDLTestPage(driver);
		 applicationFeeforLLDLTestPage.SelectBank(getdata("SelectBankforFeePayment"));
		  applicationFeeforLLDLTestPage.EnterCaptcha();
		  applicationFeeforLLDLTestPage.Clickon_Paynow_Button();
		  FeepaymentTermsandconditionsPage feepaymentTermsandconditionsPage = new FeepaymentTermsandconditionsPage(driver);
		  feepaymentTermsandconditionsPage.ClickonCheckbox_Termsandconditions();
		  feepaymentTermsandconditionsPage.Clickon_Proceedforpayment(); SBHIntroPage
		  sBHIntro = new SBHIntroPage(driver);
		  sBHIntro.Clickon_ContinuetoLogin_Button(); 
		  SBHhomePage sBHhome = new SBHhomePage(driver); 
		  sBHhome.Clickon_Pressheretocontinue_Button();
		  ApplicationFeePaymentSuccessAckPage applicationFeePaymentSuccessAck= new ApplicationFeePaymentSuccessAckPage(driver); 
		  applicationFeePaymentSuccessAck.Clickon_NextbuttoninApplicationFeePaymentSuccessAck();

			/*
			 * String env = prop.getProperty("ApplicationURL");
			 * if(env.equalsIgnoreCase("SarathiProd")) {
			 * driver.findElement(By.xpath("//input[@id='captchatext']")).sendKeys("123456")
			 * ; } else { stepstatus = basepage.setText(Captcha,
			 * Captcha.getAttribute("value"));
			 * reportEvent(stepstatus,"Able to Enter Captcha", "Unable to Enter Captcha",
			 * driver, true); }
			 */

		/*
		 * String ref =
		 * driver.findElement(By.xpath("//input[1][@id='abc']")).getAttribute("value");
		 * if(ref.equalsIgnoreCase("123456")) {
		 * driver.findElement(By.xpath("//input[@id='captchatext']")).sendKeys("123456")
		 * ; } else { stepstatus = basepage.setText(Captcha,
		 * Captcha.getAttribute("value")); reportEvent(stepstatus,
		 * "Able to Enter Captcha", "Unable to Enter Captcha", driver, true); }
		 */

		/*
		 * SelectBank(getdata("SelectBankforFeePayment")); SetCaptcha();
		 * Clickon_Paynow_Button(); Clickon_Checkbox(); Clickon_Proceedforpayment();
		 * Clickon_ContinuetoLogin_Button(); Clickon_Pressheretocontinue_Button();
		 * Clickon_Home_Button();
		 */

		
//		WebElement ref = driver.findElement(By.xpath("//input[1][@id='abc']"));
//		String captcha = ref.getAttribute("value").replaceAll("\\s", "");
//		System.out.println("Captcha in feepayment page applicant side " + captcha);
//		stepstatus = basepage.setText(Captcha,captcha);
//		 reportEvent(stepstatus, "Able to Enter Captcha", "Unable to Enter Captcha", driver, true);
	}

		
		
	

	//	clickElement(GenerateRecipt);


	

	
	

	

	

	

	public void Clickon_Home_Button() {
		stepstatus = basepage.clickElement(Home);
		reportEvent(stepstatus, "Able to click Home button", "Unable to click Home button", driver, true);
	}

	public void Clickon_Home() {
		stepstatus = basepage.clickElement(Homeatmenu);
		reportEvent(stepstatus, "Able to click Home button", "Unable to click Home button", driver, true);
	}

	public void Clickon_PrintReceipt() {
		stepstatus = basepage.clickElement(PrintReceipt);
		reportEvent(stepstatus, "Able to click PrintReceipt button", "Unable to click PrintReceipt button", driver,
				true);
		if (basepage.alertExist(driver)) {

			basepage.acceptAlert(driver);
			System.out.println("Payment Recived Sucessfully");
		} else {
			basepage.dismissAlert(driver);
		}

	}

	/* RTO Payment Properties */

	@FindBy(how = How.XPATH, using = "//a[text()='Cashier ']")
	WebElement Cashier;

	public void Clickon_Cashier() {
		stepstatus = basepage.clickElement(Cashier);
		reportEvent(stepstatus, "Able to click Cashier", "Unable to click Cashier", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='RTO PAYMENTS']")
	WebElement RTOPay;

	public void Clickon_RTOPayments() {
		stepstatus = basepage.clickElement(RTOPay);
		reportEvent(stepstatus, "Able to click RTOPayments", "Unable to click RTOPayments", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='applNo']")
	WebElement Appno;

	public void Enter_ApplicationNo() {
		stepstatus = basepage.SetTextAndTAB(Appno, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to Enter ApplicationNo ", "Unable to Enter ApplicationNo", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//button[@id='calculateBtn']")
	WebElement Cal;

	public void Clickon_Calculate() {
		stepstatus = basepage.clickElement(Cal);
		scrooldown(driver);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='print']")
	WebElement printre;
	@FindBy(how = How.XPATH, using = "//a[normalize-space(text())='HOME']")
	WebElement HOME;

	public void Clickon_GenerateRecipt() {
		scrooldown(driver);
		stepstatus = basepage.clickElement(printre);
		stepstatus = basepage.clickElement(HOME);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='stName']")
	WebElement SelectStatename;

	public void SelectStatename(String Option) {
		stepstatus = basepage.setOptionInSelectBox(SelectStatename, Option);
		reportEvent(stepstatus, "Able to Select Statename", "Unable to Select Statename", driver, true);
	}

	public void SelectState() {
		try {
			loaddata();
			SelectStatename(prop.getProperty(getdata("State")));
		} catch (Exception e) {

		}

	}

	
	

	

	
	
	
	

	public void MenuItem_FeePayments() throws IOException, InterruptedException {
		/*
		 * Mouserhoveron_FeePayments(); Clickon_FeePayment(); Clickon_EPayments();
		 * Clickon_ApplicationFee(); Enter_Application_Number(getdata("ApplicationNo"));
		 * Enter_DateofBirth(getdata("DOB")); Clickon_Calculate_Fee();
		 */
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
					Flows validate = new Flows(driver);
					validate.Login();
					Clickon_Cashier();
					Clickon_RTOPayments();
					Enter_ApplicationNo();
					Clickon_Calculate();
					Clickon_GenerateRecipt();
					validate.RTOLevel_Status();
				}

			} else {
				System.out.println("Public Payment is Processing");
				/*
				 * SelectBank(getdata("SelectBankforFeePayment")); SetCaptcha();
				 * Clickon_Paynow_Button(); Clickon_Checkbox(); Clickon_Proceedforpayment();
				 * Clickon_ContinuetoLogin_Button(); Clickon_Pressheretocontinue_Button();
				 */
				Clickon_Home_Button();
			}

		} catch (UnhandledAlertException e) {
			System.out.println("Payment Exception");
		}
	}

	public void MenuItem_VerifyPayStatus() {
		/*
		 * Mouserhoveron_FeePayments(); Clickon_Verify_Pay_Status();
		 * Enter_Application_No(getdata("ApplicationNo")); Enter_Dob(getdata("DOB"));
		 * SetCaptcha();
		 */
		driver.findElement(By.xpath("//input[@id='button1']")).click();

		if (driver.getPageSource().contains("Payment Details for Verification")) {
			String appno = driver.findElement(By.xpath("//table[@id='PaymentTable']/tbody/tr/td[2]")).getText();
			String status = driver.findElement(By.xpath("//table[@id='PaymentTable']/tbody/tr/td[3]")).getText();
			String totalpaid = driver.findElement(By.xpath("//table[@id='PaymentTable']/tbody/tr/td[4]")).getText();
			String refno = driver.findElement(By.xpath("//table[@id='PaymentTable']/tbody/tr/td[5]")).getText();
			setdata("Status", "Status of ApplicationNo: " + appno + " is " + status + " and totalpaid amount is "
					+ totalpaid + " reference no for the same is: " + refno);
		} else {
			setdata("Status", "Check Payment Details table for the Status");

		}

	}

	

	@FindBy(how = How.XPATH, using = "//input[@id='apno']")
	WebElement appNo;
	@FindBy(how = How.XPATH, using = "//input[@id='dob']")
	WebElement dob;

	public void Enter_Application_No(String value) {
		stepstatus = basepage.setText(appNo, value);
		reportEvent(stepstatus, "Able to Enter Application Number ", "Unable to Enter Application Number", driver,
				true);
	}

	public void Enter_Dob(String value) {
		stepstatus = basepage.SetTextAndTAB(dob, value);
		reportEvent(stepstatus, "Able to Enter Date of Birth ", "Unable to Enter Date of Birth", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Update Pay Status']")
	WebElement UpdatePayStatus;
	public void Clickon_UpdatePayStatus() {
		stepstatus = basepage.clickElement(UpdatePayStatus);
		reportEvent(stepstatus, "Able to click UpdatePayStatus", "Unable to click UpdatePayStatus", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='button1']")
	WebElement UpdateStatus;
	public void Clickon_UpdateStatus() {
		stepstatus = basepage.clickElement(UpdateStatus);
		reportEvent(stepstatus, "Able to click UpdateStatus", "Unable to click UpdateStatus", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@value='ok']")
	WebElement FailConfirmationOK;
	@FindBy(how = How.XPATH, using = "//input[@name='reason']")
	WebElement reason;
	public void MenuItem_Update_Pay_Status() {
		//Mouserhoveron_FeePayments();
		Clickon_UpdatePayStatus();
		Enter_Application_No(getdata("ApplicationNo"));
		Clickon_UpdateStatus();
		clickElement(FailConfirmationOK);
		setText(reason, "Bank not yet Configured");
		Clickon_UpdateStatus();
		}

}
