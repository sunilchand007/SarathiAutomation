package pageobjects;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;
import utility.Utilitymethods;

public class AuthenticationPage extends BasePage{

	WebDriver driver;
	boolean stepstatus;
	Authentication_With_EYCPage authentication_With_EYCPage;
	AuthenticationPage authenticationPage;
	Authentication_With_NonEYCPage authentication_With_NonEYCPage;
	Utilitymethods utilitymethods;
	public AuthenticationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='aadhaarHoldingType1']")
	WebElement ApplicantholdAadhaarnumber;

	public void clickRadiobuttonSubmitviaAadhaarAuthenticationAadhaarnumber() {
		stepstatus = clickElement(ApplicantholdAadhaarnumber);
		reportEvent(stepstatus, "Able to click ApplicantholdAadhaarnumber",
				"Unable to click ApplicantholdAadhaarnumber", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='submt']")
	WebElement Submittwo;

	public void clickonapplyonSubmittwobutton() {
		stepstatus = clickElement(Submittwo);
		reportEvent(stepstatus, "Able to click Submittwobutton", "Unable to click Submittwobutton", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='aadhaarHoldingType0']")
	WebElement ApplicantdoesnotholdAadhaarnumber;

	public void clickonapplyonApplicantdoesnotholdAadhaarnumber() {
		stepstatus = clickElement(ApplicantdoesnotholdAadhaarnumber);
		reportEvent(stepstatus, "Able to click ApplicantdoesnotholdAadhaarnumber",
				"Unable to click ApplicantdoesnotholdAadhaarnumber", driver, true);
	}
	
	public void adharauthentication() {

		authenticationPage = new AuthenticationPage(driver);
		String state = getdata("state");
		if (state != "AP") {
			authenticationPage.clickRadiobuttonSubmitviaAadhaarAuthenticationAadhaarnumber();
			authenticationPage.clickonapplyonSubmittwobutton();

			String OpTion = getdata("TypeofOption");
			if (OpTion.equalsIgnoreCase("Aadhar")) {
				authentication_With_EYCPage = new Authentication_With_EYCPage(driver);
				authentication_With_EYCPage.SelectAadharNumber();
			} else if (OpTion.equalsIgnoreCase("Virtual ID")) {

				authentication_With_EYCPage.SelectVirtualNumber();
			} else {
				System.out.println("Selected Option is not availble in EKyc Aadhar authentication ");
			}
		}

		else {

			String OpTion = getdata("TypeofOption");
			if (OpTion.equalsIgnoreCase("Aadhar")) {
				authentication_With_EYCPage.SelectAadharNumber();
			} else if (OpTion.equalsIgnoreCase("Virtual ID")) {
				authentication_With_EYCPage.SelectVirtualNumber();
			} else {
				System.out.println("Selected Option is not availble in EKyc Aadhar authentication ");
			}
		}

		authentication_With_EYCPage.Enter_AadharorVirtualNumber(getdata("AadharandorVirtualNumber"));
		authentication_With_EYCPage.ClickonGenerateotpButton();
		JFrame Dialog = new JFrame();
		String OTP = JOptionPane.showInputDialog(Dialog, "Enter OTP Here");
		driver.findElement(By.xpath("//input[@name='otpNumber']")).sendKeys(OTP);
		List<WebElement> checkele = driver.findElements(By.xpath("//input[@type='checkbox']"));
		@SuppressWarnings("unused")
		int checksize = checkele.size();
		for (WebElement elecheck : checkele) {
			if (!elecheck.isSelected()) {
				elecheck.click();
			}
		}
		authentication_With_EYCPage.ClickonAuthenticate();
		authentication_With_EYCPage.Clickon_Proceedbutton();

	}
	
	public void nonadharauthentication() throws IOException {
		authenticationPage = new AuthenticationPage(driver);
		authenticationPage.clickonapplyonApplicantdoesnotholdAadhaarnumber();
		authenticationPage.clickonapplyonSubmittwobutton();
		authentication_With_NonEYCPage = new Authentication_With_NonEYCPage(driver);
		authentication_With_NonEYCPage.SetMobilenumber(getdata("Phone"));
		authentication_With_NonEYCPage.EnterCaptcha();
		wait(5);
	    utilitymethods = new Utilitymethods(driver);
		authentication_With_NonEYCPage.ClickongenerateOTP();
		wait(5);
		
		driver.findElement(By.xpath("//input[@name='otpNumberSarathi']")).sendKeys("123456");

		authentication_With_NonEYCPage.enterCaptchaafter_Entering_Otp("123456");
		wait(5);
		authentication_With_NonEYCPage.submitOtp();
	}
	
	
	public void mobileauthentication() throws IOException {
		System.out.println("Inside mobile authentication");
		authentication_With_NonEYCPage = new Authentication_With_NonEYCPage(driver);
		authentication_With_NonEYCPage.SetMobilenumber(getdata("Phone"));
		authentication_With_NonEYCPage.EnterCaptcha();
		authentication_With_NonEYCPage.ClickongenerateOTP();
		wait(10);
               
		driver.findElement(By.xpath("//input[@name='otpNumberSarathi']")).sendKeys("123456");
			authentication_With_NonEYCPage.enterCaptchaafter_Entering_Otp("123456");
			authentication_With_NonEYCPage.submitOtp();
		}



		
	
	
	public void authentication() throws IOException, ClassNotFoundException, SQLException {
		/*
		 * String Typeofauthentication = getdata("Typeofauthentication");
		 * 
		 * if (Typeofauthentication.equalsIgnoreCase("Ekyc")) { adharauthentication();
		 * 
		 * } else if (Typeofauthentication.equalsIgnoreCase("Nonekyc")) {
		 * nonadharauthentication();
		 * 
		 * }
		 * 
		 * else if (Typeofauthentication.equalsIgnoreCase("mobileauthentication")) {
		 * 
		 * mobileauthentication();
		 * 
		 * } else {
		 * 
		 * System.out.println("noauthentication"); // stepstatus =
		 * clickElement(Submitwithoutaadharauthentification); //reportEvent(stepstatus,
		 * "Able to Click on Submit without Aadhar Authentiication"
		 * ,"Unable to Click on Submit without Aadhar Authentiication", driver, true); }
		 */

		String text = "Applicants using Aadhaar authentication can take the LL Test from their home or any preferred location, no need to visit RTO. Password for Online LL Test will be sent as SMS to the registered mobile number linked with Aadhaar. Successful applicant can download his/her Learner License.";
		
		if (driver.getPageSource().contains(text) && getdata("AadharOption").equalsIgnoreCase("Applicant holds Aadhaar Number"))    {
			  System.out.println("aadhar authenticaton");
			  
			  adharauthentication();
		  }
		  
		  else if (driver.getPageSource().contains(text) && getdata("AadharOption").equalsIgnoreCase("Applicant does not hold Aadhaar Number")){
				  System.out.println("non aadhar authentication");
				  
			  nonadharauthentication();
		  }
		  
		  else if (driver.getPageSource().contains("Sarathi Mobile ")) {
		  
		  mobileauthentication();
		  
		  } 
		  
		  else {
		  
		  System.out.println("noauthentication"); 
		  }
		 // stepstatus = clickElement(Submitwithoutaadharauthentification); 
		  
		//reportEvent(stepstatus,"Able to Click on Submit without Aadhar Authentiication","Unable to Click on Submit without Aadhar Authentiication", driver, true); }
		
	}
}
