package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class LLPrintpage extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public LLPrintpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelementss
	@FindBy(how = How.XPATH, using = "//a[text()='Login']")
	WebElement Login;
	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement Username;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement Password;
	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	WebElement Singin;
	@FindBy(how = How.XPATH, using = "//input[@id='crd1'][1]")
	WebElement Radibutton;
	@FindBy(how = How.XPATH, using = "//input[@id='login']")
	WebElement login;
	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li[2]/a")
	WebElement LL;
	@FindBy(how = How.XPATH, using = "//a[text()='LL PRINTING']")
	WebElement LLPrint;
	@FindBy(how = How.XPATH, using = "//input[@id='searchprocess_llsearchopt1']")
	WebElement Radiobutton;
	@FindBy(how = How.XPATH, using = "//input[@id='clsearch_clsearchopt1']")
	WebElement Radio;
	@FindBy(how = How.XPATH, using = "//input[@name='Webrefnum']")
	WebElement Application_Number;
	@FindBy(how = How.XPATH, using = "//input[@value='View Applications']")
	WebElement ViewApplications;
	@FindBy(how = How.XPATH, using = "//table[@id='licDetTable']/tbody/tr/td[7]/a")
	WebElement printLLNum;
	@FindBy(how = How.XPATH, using = "//table[@id='licDetTable']/tbody/tr/td[6]/a")
	WebElement printCL;
	@FindBy(how = How.XPATH, using = "//a[text()='Home']")
	WebElement Home;
	@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
	WebElement Logout;
	public void Clickon_Logout_Button() {
		stepstatus = basepage.clickElement(Logout);
		reportEvent(stepstatus, "Able to click on Logout button", "Unable to click on Logout button", driver, true);
	}

	public void Clickon_Login_Button() {
		stepstatus = basepage.clickElement(Login);
		reportEvent(stepstatus, "Able to click on Login button", "Unable to click on Login button", driver, true);
	}

	public void setUserName(String Strusername) {
		stepstatus = basepage.setText(Username, Strusername);
		reportEvent(stepstatus, "Able to enter username", "Unable to enter username", driver, true);
	}

	public void setpassword(String Strpassword) {
		stepstatus = basepage.setText(Password, Strpassword);
		reportEvent(stepstatus, "Able to enter password", "Unable to enter password", driver, true);
	}

	public void ClickonLogin() {
		stepstatus = basepage.clickElement(Singin);
		reportEvent(stepstatus, "Able to click on Sign-In BUtton", "Unable to click on Sign-In Button", driver, true);
	}

	public void SelectRTOtype() {
		stepstatus = basepage.clickElement(Radibutton);
		reportEvent(stepstatus, "Able to click on Radiobutton", "Unable to click on Radiobutton", driver, true);
	}

	public void Clickonlogin() {
		stepstatus = basepage.clickElement(login);
		reportEvent(stepstatus, "Able to click on login-In BUtton", "Unable to click on login Button", driver, true);
	}

	public void ClickonLLLink() {
		stepstatus = basepage.clickElement(LL);
		reportEvent(stepstatus, "Able to click LL_LINK", "Unable to click on LL_LINK", driver, true);
	}

	public void ClickonLLPrinting() {
		stepstatus = basepage.clickElement(LLPrint);
		reportEvent(stepstatus, "Able to click LLPrint Link", "Unable to click LLPrint Link", driver,
				true);
	}
	public void ClickonRadiobutton() {
		stepstatus = basepage.clickElement(Radiobutton);
		reportEvent(stepstatus, "Able to click Radiobutton", "Unable to click Radiobutton", driver, true);
	}
	
	public void ClickonRadio() {
		stepstatus = basepage.clickElement(Radio);
		reportEvent(stepstatus, "Able to click Radiobutton", "Unable to click Radiobutton", driver, true);
	}

	public void Set_Application_Number(String value) {
		stepstatus = basepage.setText(Application_Number, value);
		reportEvent(stepstatus, "Able to Enter Application_Number", "Unable to Enter Application_Number", driver, true);
	}

	public void Clickon_ViewApplications() {
		stepstatus = basepage.clickElement(ViewApplications);
			basepage.acceptAlert(driver);
			reportEvent(stepstatus, "Able to click on ViewApplications", "Unable to click ViewApplications", driver);
			scrooldown(driver);
	}
	public void ClickonLicNummbertoPrint() {
		stepstatus = basepage.clickElement(printLLNum);
		wait(3);	
		reportEvent(stepstatus, "Able to click LLnumber to Print", "Unable to click LLnumber to Print", driver, true);
	}
	public void ClickonLicNummber() {
		stepstatus = basepage.clickElement(printCL);
		wait(3);	
		reportEvent(stepstatus, "Able to click LLnumber to Print", "Unable to click LLnumber to Print", driver, true);
	}
	public void ClickonHome() {
		
		stepstatus = basepage.clickElement(Home);
		reportEvent(stepstatus, "Able to click Home", "Unable to Home", driver, true);
	}
}
