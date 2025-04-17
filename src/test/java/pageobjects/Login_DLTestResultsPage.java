package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class Login_DLTestResultsPage extends BasePage {
	BasePage basepage = new BasePage();

	WebDriver driver;

	public Login_DLTestResultsPage(WebDriver driver) {
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
	@FindBy(how = How.XPATH, using = "//a[text()='DL_TEST']")
	WebElement DLTest;
	@FindBy(how = How.XPATH, using = "//input[@id='dtApplno']")
	WebElement Applicationnumber;
	@FindBy(how = How.XPATH, using = "//input[@id='dltestpreform_0']")
	WebElement Getdetails;
	@FindBy(how = How.XPATH, using = "//input[@id='testResult01']")
	WebElement Result;
	@FindBy(how = How.XPATH, using = "//input[@id='vehno0']")
	WebElement Vehno;
	@FindBy(how = How.XPATH, using = "//input[@id='confirmbox0']")
	WebElement Confirm;
	@FindBy(how = How.XPATH, using = "//input[@id='verify']")
	WebElement Confirmcheck;
	@FindBy(how = How.XPATH, using = "//input[@id='subBtn']")
	WebElement Submit;
	@FindBy(how = How.XPATH, using = "//table[@id='testresult']/tbody/tr/td[2]/span/following::td/div/select")
	WebElement TestResults;

	// related methods to perform operation on webelements
	boolean stepstatus;

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
		stepstatus = basepage.clickElement(Radiobutton);
		reportEvent(stepstatus, "Able to click on Radiobutton", "Unable to click on Radiobutton", driver, true);
	}

	public void Clickonlogin() {
		stepstatus = basepage.clickElement(login);
		reportEvent(stepstatus, "Able to click on login-In BUtton", "Unable to click on login Button", driver, true);
	}

	public void ClickonDLLINK() {
		stepstatus = basepage.clickElement(DL);
		reportEvent(stepstatus, "Able to click on DL LINK", "Unable to click on DL LINK", driver, true);
	}

	public void ClickonDLTest() {
		stepstatus = basepage.clickElement(DLTest);
		reportEvent(stepstatus, "Able to click on DLTest LINK", "Unable to click on DLTest LINK", driver, true);
	}

	public void Set_Applicationnumber(String value) {
		stepstatus = basepage.setText(Applicationnumber, value);
		reportEvent(stepstatus, "Able to Enter Application Number", "Unable to Enter Application Number", driver, true);
	}

	public void ClickonGetdetails() {
		stepstatus = basepage.clickElement(Getdetails);
		reportEvent(stepstatus, "Able to click on Getdetails", "Unable to click on Getdetails", driver, true);
	}

	public void ClickonResult() {
		stepstatus = basepage.clickElement(Result);
		reportEvent(stepstatus, "Able to click on Result", "Unable to click on Result", driver, true);
	}

	public void Set_TestResult(String Option) {
		stepstatus = basepage.setOptionInSelectBox(TestResults, Option);
		reportEvent(stepstatus, "Able to select Test Result", "Unable to Select Test Result", driver, true);
	}

	public void Set_Vehno(String value) {
		stepstatus = basepage.setText(Vehno, value);
		reportEvent(stepstatus, "Able to Enter Vehno", "Unable to Enter Vehno", driver, true);
	}

	public void ClickonConfirm() {
		stepstatus = basepage.clickElement(Confirm);
		reportEvent(stepstatus, "Able to click on Confirm", "Unable to click on Confirm", driver, true);
	}

	public void ClickonConfirmcheck() {
		stepstatus = basepage.clickElement(Confirmcheck);
		reportEvent(stepstatus, "Able to click on Confirmcheck", "Unable to click on Confirmcheck", driver, true);
	}

	public void ClickonSubmit() {
		stepstatus = basepage.clickElement(Submit);

		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {
			basepage.dismissAlert(driver);
		}

	}

}
