package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class StateSelectionPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;

	boolean stepstatus;

	public StateSelectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='mobileNumber']")
	WebElement Mobilenumber;
	@FindBy(how = How.XPATH, using = "//input[@id='entcaptxt']")
	WebElement Captcha;
	@FindBy(how = How.XPATH, using = "//button[@id='generateSarathiotp']")
	WebElement GenerateOTP;
	@FindBy(how = How.XPATH, using = "//input[@id='otpNumberSarathi']")
	WebElement OTP;
	@FindBy(how = How.XPATH, using = "//input[@id='entcaptxt1']")
	WebElement captchaa;
	@FindBy(how = How.XPATH, using = "//input[@id='verifySarathi']")
	WebElement Submit;
	@FindBy(how = How.XPATH, using = "//button[@id='generateResendSarathiotp']")
	WebElement ResendOTP;
	@FindBy(how = How.XPATH, using = "//input[@id='resetDl']")
	WebElement Resetbtn;
    @FindBy(how = How.XPATH, using = "//input[@value='Cancel']")
	WebElement Cancelbtn;
		
	
	@FindBy(how = How.XPATH, using = "//select[@name='stName']")
	WebElement Selectstatename;

	public void Selectstatename( String value) {
		stepstatus = basepage.setValueInSelectBox(Selectstatename, value);
		reportEvent(stepstatus, "Able to Select Statename", "Unable to Select Statename", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='sarathi_login']//a[@id='login']")
	WebElement Login;

	public void clickLoginbutton() {
		wait(2);
		stepstatus = basepage.clickElement(Login);
		reportEvent(stepstatus, "Able to click Login", "Unable to click Login", driver, true);

	}
}
