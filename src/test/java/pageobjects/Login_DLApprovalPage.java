package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class Login_DLApprovalPage extends BasePage {
	BasePage basepage = new BasePage();

	WebDriver driver;

	public Login_DLApprovalPage(WebDriver driver) {
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
	WebElement Radiobutton;
	@FindBy(how = How.XPATH, using = "//input[@id='login']")
	WebElement login;
	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li[4]/a")
	WebElement DL;
	@FindBy(how = How.XPATH, using = "//a[text()='APPROVE NEW DL']")
	WebElement ApprovalDL;
	@FindBy(how = How.XPATH, using = "//input[@id='applicationNumber']")
	WebElement Applicationnumber;
	@FindBy(how = How.XPATH, using = "//input[@id='DLAproval_execute_dlapproval_proceed']")
	WebElement Proceed;
	@FindBy(how = How.XPATH, using = "//input[@value='Approve']")
	WebElement Approve;
	@FindBy(how = How.XPATH, using = "//div[@class='col-md-12 text-center']/h4")
	WebElement DLNumber;

	// related methods to perform operation on webelements
	boolean stepstatus;

	public void Clickon_Login_Button() {
		stepstatus = clickElement(Login);
		reportEvent(stepstatus, "Able to click on Login button", "Unable to click on Login button", driver, true);
	}

	public void setUserName(String Strusername) {
		stepstatus = setText(Username, Strusername);
		reportEvent(stepstatus, "Able to enter username", "Unable to enter username", driver, true);
	}

	public void setpassword(String Strpassword) {
		stepstatus = setText(Password, Strpassword);
		reportEvent(stepstatus, "Able to enter password", "Unable to enter password", driver, true);
	}

	public void ClickonLogin() {
		stepstatus = clickElement(Singin);
		reportEvent(stepstatus, "Able to click on Sign-In BUtton", "Unable to click on Sign-In Button", driver, true);
	}
	public void SelectRTOtype() {
		stepstatus = clickElement(Radiobutton);
		reportEvent(stepstatus, "Able to click on Radiobutton", "Unable to click on Radiobutton", driver, true);
	}

	public void Clickonlogin() {
		stepstatus = clickElement(login);
		reportEvent(stepstatus, "Able to click on login-In BUtton", "Unable to click on login Button", driver, true);
	}

	public void ClickonDL() {
		stepstatus = clickElement(DL);
		reportEvent(stepstatus, "Able to click on DL LINK", "Unable to click on DL LINK", driver, true);
	}

	public void ClickonApprovalDL() {
		stepstatus = clickElement(ApprovalDL);
		reportEvent(stepstatus, "Able to click on Approval DL LINK", "Unable to click on ApprovalDL LINK", driver,
				true);
	}

	public void Set_Applicationnumber(String value) {
		stepstatus = setText(Applicationnumber, value);
		reportEvent(stepstatus, "Able to Enter Applicationnumber", "Unable to Enter Applicationnumber", driver, true);
	}

	public void ClickonProceed() {
		stepstatus = clickElement(Proceed);
		reportEvent(stepstatus, "Able to click on Proceed", "Unable to click on Proceed", driver, true);
	}

	public void ClickonApprove() {
		stepstatus = clickElement(Approve);
		reportEvent(stepstatus, "Able to click on Approve", "Unable to click on Approve", driver, true);
		
	}

}
