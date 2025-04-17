package pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkLibrary.BasePage;

public class ScrutinyPage extends BasePage {
	BasePage basepage = new BasePage();

	// Initilization
	WebDriver driver;
	String originalHandle;

	public ScrutinyPage(WebDriver driver) {
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
	@FindBy(how = How.XPATH, using = "//input[@id='crd2']")
	WebElement Radiobutton1;
	@FindBy(how = How.XPATH, using = "//input[@id='login']")
	WebElement login;
	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li[6]/a")
	WebElement General;
	
	@FindBy(how = How.XPATH, using = "//input[@name='applicationNumber']")
	WebElement Application_Number;
	@FindBy(how = How.XPATH, using = "//input[@id='_scrutiny_proceed']")
	WebElement Proceed;
	@FindBy(how = How.XPATH, using = "//input[1][@value='1']")
	WebElement Visible;
	@FindBy(how = How.XPATH, using = "//a[text()='Verification of Documents']")
	WebElement VerificationofDocuments;
	@FindBy(how = How.XPATH, using = "//i[text()='Medical Certificate-Form1 (Self Decleration)']")
	WebElement Firstprooflink;
	@FindBy(how = How.XPATH, using = "//i[text()='Birth Certificate issued by Municipality']")
	WebElement Secondprooflink;
	@FindBy(how = How.XPATH, using = "//i[text()='Passport']")
	WebElement Thirdprooflink;
	@FindBy(how = How.XPATH, using = "//input[@id='documentsapproval_0']")
	WebElement windowSubmit;
	@FindBy(how = How.XPATH, using = "//input[@id='approveButton']")
	WebElement Scrutinybutton;

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

	public void SelectRTOtypo() {
		stepstatus = basepage.clickElement(Radiobutton1);
		reportEvent(stepstatus, "Able to click on Radiobutton1", "Unable to click on Radiobutton1", driver, true);
	}

	public void Clickonlogin() {
		stepstatus = basepage.clickElement(login);
		reportEvent(stepstatus, "Able to click on login-In BUtton", "Unable to click on login Button", driver, true);
	}

	public void Clickon_General_button() {
		stepstatus = basepage.clickElement(General);
		reportEvent(stepstatus, "Able to click on General BUtton", "Unable to click on General Button", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//input[@value='Scrutiny']")
	WebElement Scrutiny;
	public void Clickon_Scrutiny_Link() {
		stepstatus = basepage.clickElement(Scrutiny);
		reportEvent(stepstatus, "Able to click on Scrutiny BUtton", "Unable to click on Scrutiny Button", driver, true);
	}

	public void Set_Application_Number(String value) {
		stepstatus = basepage.setText(Application_Number, value);
		reportEvent(stepstatus, "Able to Enter Application_Number", "Unable to Enter Application_Number", driver, true);
	}

	public void Clickon_Proceed_button() {
		stepstatus = basepage.clickElement(Proceed);
		reportEvent(stepstatus, "Able to click on Proceed BUtton", "Unable to click on Proceed Button", driver, true);
		basepage.scrooldown(driver);
	}

	public void Clickon_Yes() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(Visible));
		wait.until(ExpectedConditions.elementToBeClickable(Visible));

		stepstatus = basepage.JsclickElement(Visible, driver);
		reportEvent(stepstatus, "Able to click on Yes ", "Unable to click on Yes", driver, true);

	}

	@FindBy(how = How.XPATH, using = "(//input[@id='radio1'])[2]")
	WebElement photosigradio;

	public void Clickon_VerificationofDocuments_Link() {
		originalHandle = driver.getWindowHandle();
		if (isDisplayed(photosigradio)==true) {
			photosigradio.click();
		}else {
			System.out.println("There is no photosigradio check ");
		}

		if (isDisplayed(VerificationofDocuments) == true) {
			stepstatus = basepage.clickElement(VerificationofDocuments);
			wait(3);
			if (basepage.alertExist(driver)) {
				basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
		} else {
			Clickon_Scrutinybutton();
		}

	}

	public void Clickon_prooflinks() {
		wait(1);
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				List<WebElement> totalproofdocuments = driver
						.findElements(By.xpath("//table[@class='table table-bordered ']/tbody/tr/td[3]/i"));
				int count = totalproofdocuments.size();
				for (int i = 0; i < count; i++) {
					totalproofdocuments = driver
							.findElements(By.xpath("//table[@class='table table-bordered ']/tbody/tr/td[3]/i"));
					count = totalproofdocuments.size();
					System.out.println(count);
					totalproofdocuments.get(i).click();
					wait(2);
					for (String Childofchild : driver.getWindowHandles()) {
						if (!Childofchild.equals(originalHandle) && !Childofchild.equals(handle)) {
							driver.switchTo().window(Childofchild);
							driver.close();
							wait(1);
							driver.switchTo().window(handle);
						}

					}
				}

				WebElement ele = driver.findElement(By.xpath("//input[@value='Submit']"));
				clickElement(ele);
				driver.switchTo().window(originalHandle);
			}
		}

	}

	public void Clickon_Scrutinybutton() {
		stepstatus = basepage.clickElement(Scrutinybutton);
		wait(3);
		String title = driver.getTitle();
		if (title.equals("Scrutinized")) {
			setdata("StatusofScrutiny", "Success");
		} else {
			setdata("StatusofScrutiny", "Fail");
		}
		// reportEvent(stepstatus, "Able to click on Scrutinybutton", "Unable to click
		// on Scrutinybutton", driver, true);
	}

	// Through Application Status

	@FindBy(how = How.XPATH, using = "//a[text()='Misc ']")
	WebElement clickonmisc;

	public void clickon_Misc() {
		stepstatus = basepage.clickElement(clickonmisc);
		reportEvent(stepstatus, "Able to clickonmisc", "Unable to click on misc", driver, true);
	}

	// new
	@FindBy(how = How.XPATH, using = "//a[text()='APPLICATION STATUS']")
	WebElement clickonapplicationstatus;

	public void click_on_applicationstatus() {
		stepstatus = basepage.clickElement(clickonapplicationstatus);
		reportEvent(stepstatus, "Able to clickonapplicationstatus", "Unable to click on applicationstatus", driver,
				true);
	}

	// new
	@FindBy(how = How.XPATH, using = "(//input[@name='papplno'])[1]")
	WebElement setapplno;

	public void setAPPLNO_IN_LOGIN(String value) {
		stepstatus = basepage.setText(setapplno, value);
		reportEvent(stepstatus, "Able to set text", "Unable to set text", driver, true);
	}

	// new
	@FindBy(how = How.XPATH, using = "(//input[@name='View Flows'])")
	WebElement clickonviewflows;

	public void click_on_viewflows() {
		stepstatus = basepage.clickElement(clickonviewflows);
		reportEvent(stepstatus, "Able to click on view flows ", "Unable to click on view flows", driver, true);
	}

	// new
	@FindBy(how = How.XPATH, using = "//input[@value='Process Flow']")
	WebElement clickonprocessflows;

	public void click_on_processflow() {
		stepstatus = basepage.clickElement(clickonprocessflows);
		reportEvent(stepstatus, "Able to click on process flows ", "Unable to click on process flows", driver, true);
	}

}
