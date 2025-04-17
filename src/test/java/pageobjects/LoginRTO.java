package pageobjects;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.GetTitle;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class LoginRTO extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public LoginRTO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement Username;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement Password;

	@FindBy(how = How.XPATH, using = "//input[@id='logmode']")
	WebElement Captcha;

	@FindBy(how = How.XPATH, using = "//input[@id='frmsubmt']")
	WebElement Next;

	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	WebElement Singin;
	
	@FindBy(how = How.XPATH, using = "//*[@id='mob']")
	WebElement MobileClick;
	
	@FindBy(how = How.XPATH, using = "//*[@id='txtmobileno']")
	WebElement mobile;
	
	@FindBy(how = How.XPATH, using = "//*[@id='pwdlesslogin_id']")
	WebElement pwdlesslogin;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='chkconcent_login']")
	WebElement chkconcentlogin;
	
	@FindBy(how = How.XPATH, using = "//*[@id='userNameNextButton']")
	WebElement ClickonSignIn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='txtOtp']")
	WebElement OTP;
	
	@FindBy(how = How.XPATH, using = "//*[@id='otpSubmitButton']")
	WebElement otpSubmitButton;
	
	
	
	public void ClickonotpSubmitButton() {
		stepstatus = basepage.clickElement(otpSubmitButton);

		reportEvent(stepstatus, "Able to Click on otpSubmitButton ", "Unable to Click on otpSubmitButton",
		 driver);
		wait(5);
		VerifyRTOSelection();
	}
	
	public void SetOTP() {
		stepstatus = basepage.setText(OTP, "110011");

		 reportEvent(stepstatus, "Able to Enter OTP", "Unable to Enter OTP",
		 driver, true);
	}
	
	public void ClickonSignIn() {
		stepstatus = basepage.clickElement(ClickonSignIn);

		reportEvent(stepstatus, "Able to Click on ClickonSignIn ", "Unable to Click on ClickonSignIn",
		 driver);
		
	}
	
	public void chkconcentlogin() {
		stepstatus = basepage.clickElement(chkconcentlogin);

		reportEvent(stepstatus, "Able to Click on chkconcentlogin ", "Unable to Click on chkconcentlogin",
		 driver);
		
	}
	public void ClickonPWDLessAuthentification() {
		stepstatus = basepage.clickElement(pwdlesslogin);

		reportEvent(stepstatus, "Able to Click on pwdlesslogin ", "Unable to Click on pwdlesslogin",
		 driver);
		
	}
	public void ClickonMobile() {
		stepstatus = basepage.clickElement(MobileClick);

		reportEvent(stepstatus, "Able to Click on Mobile ", "Unable to Click on Mobile",
		 driver);
		
	}
	public void setMobileNumber(String Mobile) {
		stepstatus = basepage.setText(mobile, Mobile);

		reportEvent(stepstatus, "Able to enter Mobile Number", "Unable to enter Mobile Number",
		 driver);

	}
	
	// related methods to perform operation on webelements
	public void setUserName(String Strusername) {
		stepstatus = basepage.setText(Username, Strusername);

		reportEvent(stepstatus, "Able to enter username", "Unable to enter username",
		 driver);

		// reportEvent(stepstatus, "Able to enter username", "Unable to enter username",
		// driver);

		 reportEvent(stepstatus, "Able to enter username", "Unable to enter username",
		 driver);

	}

	public void setpassword(String Strpassword) {
		stepstatus = basepage.setText(Password, Strpassword);
		 reportEvent(stepstatus, "Able to enter password", "Unable to enter password",
		 driver);
		if (driver.getPageSource().contains("Next")) {
			ClickonNext();
			// SetCaptcha();
			JFrame Dialog = new JFrame();
			String name = JOptionPane.showInputDialog(Dialog, "Enter Captcha");
			driver.findElement(By.xpath("//input[@id='logmode']")).sendKeys(name);
		} else {
			SetCaptcha();
		}

	}

	@FindBy(how = How.XPATH, using = "//div[@id='servervalid']/span")
	WebElement ifalreadySingin;
	@FindBy(how = How.XPATH, using = "//input[@value='LOGOUT']")
	WebElement Logout;
	@FindBy(how = How.XPATH, using = "//input[@value='Go to Login']")
	WebElement gotoLogin;
	@FindBy(how = How.XPATH, using = "//input[@value='LOGIN']")
	WebElement gotoLogin1;

	public void ClickonLogin() {
		stepstatus = basepage.clickElement(Singin);

	//	driver.findElement(By.xpath("//input[@id='reglater']")).click();

	//	driver.findElement(By.xpath("//input[@id='reglater']")).click();

		String Title = driver.getTitle();
		System.out.println("Title of the page is : " + Title);
		if(Title.equalsIgnoreCase("JP")) {
		
			driver.findElement(By.xpath("//input[@id='reglater']")).click();
		}else {
			
			System.out.println("There is no janparichay Registration Page ");
		}

		stepstatus = basepage.clickElement(Singin);
		if (isDisplayed(ifalreadySingin) == true)
		{
			if (isDisplayed(gotoLogin1)==true)
			{	
				clickElement(gotoLogin1);
				//driver.findElement(By.xpath("//input[@id='reglater']")).click();
			}
			else if(isDisplayed(Logout)==true)
			{
				clickElement(Logout);
				clickElement(gotoLogin);
				LoginRTO RTO = new LoginRTO(driver);
				RTO.setUserName(getdata("UserName"));
				RTO.setpassword(getdata("Password"));
				RTO.ClickonLogin();
			}
			
				
			// stepstatus = basepage.clickElement(Singin);
		}

		VerifyRTOSelection();
	}

	public void SetCaptcha() {
		stepstatus = basepage.setText(Captcha, "123456");

		// reportEvent(stepstatus, "Able to Enter Captcha", "Unable to Enter Captcha",
		// driver, true);
	}

	public void ClickonNext() {
		stepstatus = basepage.clickElement(Next);
		// reportEvent(stepstatus, "Able to click on Next BUtton", "Unable to click on
		// Next Button", driver, true);
	}

	public void VerifyRTOSelection() {

		String rtoselectiontitle = driver.getTitle();

		if (rtoselectiontitle.equalsIgnoreCase("UserRTOLogin")) {
			code = getdata("RTOCode");
			System.out.println(code);
			List<WebElement> camplst = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[6]"));
			int camplstsize = camplst.size();

			for (int i = 0; i < camplstsize; i++) {

				String text = driver
						.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i + "]/td[6]"))
						.getText();
				if (text.equalsIgnoreCase("--------")) {
					System.out.println("Non Camp Details Matched");
					String rtotxt = driver.findElement(By.xpath(
							"//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i + "]/td[5]/preceding-sibling::td[3]"))
							.getText();

					String categorytext = driver
							.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i + "]/td[4]"))
							.getText();

					if (categorytext.equalsIgnoreCase("RTO AUTHORITY")) {
						System.out.println("RTO AUTHORITY Details Matched");
						categorytext = driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i
								+ "]/td[5]/preceding-sibling::td[1]")).getText();

						if (rtotxt.equalsIgnoreCase(code)) {
							System.out.println("RTO Code Matched");
							driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i
									+ "]/td[5]/preceding-sibling::td[4]/input")).click();
							break;

						}
					}

				}

			}
			driver.findElement(By.xpath("//input[@value='Login']")).click();
		} else if (rtoselectiontitle.equalsIgnoreCase("Home")) {
			System.out.println("There is no RTO Selection Page");
		} 
		else if (rtoselectiontitle.equalsIgnoreCase("::Welcome to Application ePayment::")) {
			code = getdata("RTOCode");
			System.out.println(code);
			List<WebElement> camplst = driver.findElements(By.xpath("//table[@id='PaymentTable']/tbody/tr/td[6]"));
			int camplstsize = camplst.size();

			for (int i = 0; i < camplstsize; i++) {

				String text = driver
						.findElement(By.xpath("//table[@id='PaymentTable']/tbody/tr[" + 1 + "+" + i + "]/td[6]"))
						.getText();
				if (text.equalsIgnoreCase("--------")) {
					System.out.println("Non Camp Details Matched");
					String rtotxt = driver.findElement(By.xpath(
							"//table[@id='PaymentTable']/tbody/tr[" + 1 + "+" + i + "]/td[5]/preceding-sibling::td[3]"))
							.getText();

					String categorytext = driver
							.findElement(By.xpath("//table[@id='PaymentTable']/tbody/tr[" + 1 + "+" + i + "]/td[4]"))
							.getText();

					if (categorytext.equalsIgnoreCase("RTO AUTHORITY")) {
						System.out.println("RTO AUTHORITY Details Matched");
						categorytext = driver.findElement(By.xpath("//table[@id='PaymentTable']/tbody/tr[" + 1 + "+" + i
								+ "]/td[5]/preceding-sibling::td[1]")).getText();

						if (rtotxt.equalsIgnoreCase(code)) {
							System.out.println("RTO Code Matched");
							driver.findElement(By.xpath("//table[@id='PaymentTable']/tbody/tr[" + 1 + "+" + i
									+ "]/td[5]/preceding-sibling::td[4]/input")).click();
							break;

						}
					}

				}

			}
			driver.findElement(By.xpath("//input[@value='Proceed']")).click();
			
		}else {
			System.out.println("Title Mismatched");
		}

		/*
		 * if (driver.getPageSource().contains("User RTO Login")) { code =
		 * getdata("RTOCode"); List<WebElement> camplst =
		 * driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[5]")); int
		 * camplstsize = camplst.size();
		 * 
		 * for (int i = 0; i < camplstsize; i++) {
		 * 
		 * String text = driver
		 * .findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i +
		 * "]/td[5]")) .getText(); if (text.equalsIgnoreCase("--------")) {
		 * System.out.println("Camp Details Matched"); String rtotxt =
		 * driver.findElement(By.xpath( "//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" +
		 * i + "]/td[5]/preceding-sibling::td[3]")) .getText(); if
		 * (rtotxt.equalsIgnoreCase(code)) { System.out.println("RTO Code Matched");
		 * driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" +
		 * i + "]/td[5]/preceding-sibling::td[4]/input")).click(); break; }
		 * 
		 * }
		 * 
		 * } driver.findElement(By.xpath("//input[@value='Login']")).click(); } else {
		 * System.out.println("There is no RTO Selection"); }
		 */
	}

}
