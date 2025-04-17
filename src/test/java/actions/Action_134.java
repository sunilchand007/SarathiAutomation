package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;
import pageobjects.ApplicationFeePaymentSuccessAckPage;
import pageobjects.ApplicationFeeforLLDLTestPage;
import pageobjects.FeepaymentTermsandconditionsPage;
import pageobjects.SBHIntroPage;
import pageobjects.SBHhomePage;

public class Action_134 extends BasePage{
	WebDriver driver;
	
	public Action_134(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void feePayment() {
		System.out.println("Inside  Fee Payments Flow");
		ApplicationFeeforLLDLTestPage applicationFeeforLLDLTestPage = new ApplicationFeeforLLDLTestPage(driver);
		applicationFeeforLLDLTestPage.Enter_Application_Number(getdata("ApplicationNo"));
		applicationFeeforLLDLTestPage.Enter_DateofBirth(getdata("DateofBirth"));
		applicationFeeforLLDLTestPage.Clickon_Calculate_Fee();
		applicationFeeforLLDLTestPage.SelectBank(getdata("SelectBankforFeePayment"));
		applicationFeeforLLDLTestPage.EnterCaptcha();
		applicationFeeforLLDLTestPage.Clickon_Paynow_Button();
		FeepaymentTermsandconditionsPage feepaymentTermsandconditionsPage = new FeepaymentTermsandconditionsPage(driver);
		feepaymentTermsandconditionsPage.ClickonCheckbox_Termsandconditions();
		feepaymentTermsandconditionsPage.Clickon_Proceedforpayment();
		SBHIntroPage sBHIntro = new SBHIntroPage(driver);
		sBHIntro.Clickon_ContinuetoLogin_Button();
		SBHhomePage sBHhome = new SBHhomePage(driver);
		sBHhome.Clickon_Pressheretocontinue_Button();
		ApplicationFeePaymentSuccessAckPage applicationFeePaymentSuccessAck = new ApplicationFeePaymentSuccessAckPage(driver);
		applicationFeePaymentSuccessAck.Clickon_NextbuttoninApplicationFeePaymentSuccessAck();
	}
}
