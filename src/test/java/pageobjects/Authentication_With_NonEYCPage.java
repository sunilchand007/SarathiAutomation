package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class Authentication_With_NonEYCPage extends BasePage{
	
	WebDriver driver;
	boolean stepstatus;
	
	public Authentication_With_NonEYCPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
			
	@FindBy(how = How.XPATH, using = "//input[@id='entcaptxt']")
	WebElement Captcha;
	
	public void EnterCaptcha(){
		stepstatus = setText(Captcha,"123456");
		reportEvent(stepstatus, "Able to Enter Captcha", "Unable to Enter Captcha", driver, true);
		}

	@FindBy(how = How.XPATH, using = "//input[@id='mobileNumber']")
	WebElement Mobilenumber;

	public void SetMobilenumber(String value) {
		boolean mobilenumberstatus = isDisplayed(Mobilenumber);
		System.out.println("boolean status of mobile number "+mobilenumberstatus);
		if (mobilenumberstatus ==true) {
			
			stepstatus = setText(Mobilenumber, value);
			reportEvent(stepstatus, "Able to Enter Mobile Number", "Unable to Enter Mobile Number", driver, true);
		} else {
			System.out.println("Mobile Number Already Taken");
		}

	}
	
	
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'entcaptxt1']")
	WebElement setcaptcha_afterOTP;
	public void enterCaptchaafter_Entering_Otp(String captcha) {
		
		stepstatus = setText(setcaptcha_afterOTP, captcha);
		reportEvent(stepstatus, "Able to Enter Captcha after entering captcha ", "Unable to Enter Captcha after entering captcha ", driver, true);
	}
	
	
   @FindBy(how = How.XPATH, using = "//*[@id=\"generateSarathiotp\"]")
	WebElement GenerateOTP;

	public void ClickongenerateOTP() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", GenerateOTP);
		alertGetText(driver);
		if (alertExist(driver)) {
			String tct = alertGetText(driver);
			System.out.println(tct);
			acceptAlert(driver);
			wait(2);
			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
			executor1.executeScript("arguments[0].click();", GenerateOTP);

		} else {
			dismissAlert(driver);
		}
	}
			
			
			
	@FindBy(how = How.XPATH, using = "//input[@id='verifySarathi']")
	WebElement submitotp;

	public void submitOtp() {
	
		if (isEnabled(submitotp)) {
			System.out.println("Button Enabled");
			stepstatus = clickElement(submitotp);
			reportEvent(stepstatus, "Able to click AuthenticateWithSarathi Button",
					"Unable to click AuthenticateWithSarathi Button", driver, true);

		}

		@SuppressWarnings("unused")
		String gettext = alertGetText(driver);
		if (alertExist(driver)) {

			acceptAlert(driver);
		} else {
			dismissAlert(driver);
		}
	}
}
