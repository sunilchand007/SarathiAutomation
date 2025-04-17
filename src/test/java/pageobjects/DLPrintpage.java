package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class DLPrintpage extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public DLPrintpage(WebDriver driver) {
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
	@FindBy(how = How.XPATH, using = "//input[@value='plastic']")
	WebElement PaperCard;
	@FindBy(how = How.XPATH, using = "//input[@value='TODAY']")
	WebElement today;
	@FindBy(how = How.XPATH, using = "//input[@id='_printY']")
	WebElement YesDisplay;
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement Submit;
	@FindBy(how = How.XPATH, using = "//input[@value='PRINTALL']")
	WebElement PrintALL;
	@FindBy(how = How.XPATH, using = "//input[@value='Proceed']")
	WebElement Proceed;
	@FindBy(how = How.XPATH, using = "//a[text()='Home']")
	WebElement Home;

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

	public void ClickonPaperCard() {
		stepstatus = basepage.clickElement(PaperCard);
		reportEvent(stepstatus, "Able to click PaperCard", "Unable to click on PaperCard", driver, true);
	}

	public void ClickonTodaysDate() {
		stepstatus = basepage.clickElement(today);
		reportEvent(stepstatus, "Able to click on Todays date", "Unable to click on Todays date", driver, true);
	}

	public void ClickonYes() {
		stepstatus = basepage.clickElement(YesDisplay);
		reportEvent(stepstatus, "Able to click on Yes", "Unable to click on Yes", driver, true);
	}

	public void ClickonSubmit() {
		stepstatus = basepage.clickElement(Submit);
		reportEvent(stepstatus, "Able to Click Submit", "Unable to click Submit", driver, true);
	}

	public void Clickon_PrintALL() {
		stepstatus = basepage.clickElement(PrintALL);
		reportEvent(stepstatus, "Able to click on PrintALL", "Unable to click PrintALL", driver);

	}

	public void ClickonProceed() {
		stepstatus = basepage.clickElement(Proceed);
		wait(3);
		reportEvent(stepstatus, "Able to click Proceed", "Unable to click Proceed", driver, true);
	}

}
