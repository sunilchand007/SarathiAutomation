package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class LLApprovalbatch extends BasePage {
	BasePage basepage = new BasePage();

	WebDriver driver;

	public LLApprovalbatch(WebDriver driver) {
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
	@FindBy(how = How.XPATH, using = "//a[text()='LL APPROVAL BATCH']")
	WebElement LLAprovalbatch;
	@FindBy(how = How.XPATH, using = "//input[@id='radio33']")
	WebElement Radiobutton;
	@FindBy(how = How.XPATH, using = "//input[@name='applno']")
	WebElement Application_Number;
	@FindBy(how = How.XPATH, using = "//input[@id='submit']")
	WebElement Submitbutton;
	@FindBy(how = How.XPATH, using = "//table[@id='llApprovalPendApplications']/thead/tr/th[5]/input[1]")
	WebElement Selectall;
	@FindBy(how = How.XPATH, using = "//input[@id='Approve']")
	WebElement Issueallbutton;

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

	public void ClickonLLAprovalbatchLink() {
		stepstatus = basepage.clickElement(LLAprovalbatch);
		reportEvent(stepstatus, "Able to click LLAprovalbatch Link", "Unable to click LLAprovalbatch Link", driver,
				true);
	}

	public void ClickonRadiobutton() {
		stepstatus = basepage.clickElement(Radiobutton);
		reportEvent(stepstatus, "Able to click Radiobutton", "Unable to click Radiobutton", driver, true);
	}

	public void Set_Application_Number(String value) {
		stepstatus = basepage.setText(Application_Number, value);
		reportEvent(stepstatus, "Able to Enter Application_Number", "Unable to Enter Application_Number", driver, true);
	}

	public void Clickon_Submitbutton() {
		stepstatus = basepage.clickElement(Submitbutton);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			reportEvent(stepstatus, "Able to click on Submitbutton", "Unable to click Submitbutton", driver);
		} else {
			basepage.dismissAlert(driver);
		}
	}

	public void Clickon_Selectallcheckbox() {
		stepstatus = basepage.clickElement(Selectall);
		reportEvent(stepstatus, "Able to click Selectall checkboc", "Unable to click Selectall checkbox", driver, true);
	}

	public void Clickon_Issueallbutton() {
		stepstatus = basepage.clickElement(Issueallbutton);
		// reportEvent(stepstatus, "Able to click Issueallbutton ", "Unable to click
		// Issueallbutton", driver, true);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
			setdata("Status", "Pass");
		} else {
			basepage.dismissAlert(driver);
		}
	}

	/* LL EDIT Approval */
	@FindBy(how = How.XPATH, using = "//input[@name='Midmark2']")
	WebElement ModifiedText;
	@FindBy(how = How.XPATH, using = "//input[@name='modbloodgrpName']")
	WebElement Modifiedbdgrp;
	@FindBy(how = How.XPATH, using = "//input[@value='Approve']")
	WebElement Approve_LLEdit;

	public void LLEditApprove() {

		if (getAttributeValue(ModifiedText, "value").trim().equalsIgnoreCase(getdata("IM2").trim())) {
			System.out.println("First Condition Matched");
			if (getAttributeValue(Modifiedbdgrp, "value").trim().equalsIgnoreCase(getdata("Bloodgrp").trim())) {
				System.out.println("Second Condition Matched");
				clickElement(Approve_LLEdit);

			}

		} else {
			System.out.println("Modifications not matched please check");
		}

	}

}
