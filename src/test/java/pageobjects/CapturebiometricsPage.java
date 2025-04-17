package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class CapturebiometricsPage extends BasePage {
	

	// Initilization
	WebDriver driver;

	public CapturebiometricsPage(WebDriver driver) {
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

	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li[6]/a")
	WebElement General;
	@FindBy(how = How.XPATH, using = "//a[text()='CAPTURE PHOTO & SIGNATURE']")
	WebElement Biometrics;
	@FindBy(how = How.XPATH, using = "//input[@name='appnumber']")
	WebElement Application_Number;
	@FindBy(how = How.XPATH, using = "//button[@id='thumbdetform__populateData']")
	WebElement Getdetails;
	@FindBy(how = How.XPATH, using = "html/body/div/div/div[3]/div/div[1]/div[2]/div/div/form/div[4]/div/div/div[2]/div[1]/div/fieldset/div/div[1]/div/canvas")
	WebElement CanvasSignature;
	@FindBy(how = How.XPATH, using = "//button[@id='capBtn']")
	WebElement CaptureSignature;
	@FindBy(how = How.XPATH, using = "//input[@id='photos']")
	WebElement PhotoCapture;
	@FindBy(how = How.XPATH, using = "//input[@value='Start Camera']")
	WebElement startcamera;
	@FindBy(how = How.XPATH, using = "//input[@value='Take Snapshot']")
	WebElement takesnap;
	@FindBy(how = How.XPATH, using = "//input[@value='Start Crop']")
	WebElement startcrop;
	@FindBy(how = How.XPATH, using = "//input[@value='End Crop']")
	WebElement endcrop;

	@FindBy(how = How.XPATH, using = "//li[@class='crop']")
	WebElement CropSelected;
	@FindBy(how = How.XPATH, using = "//li[@class='trigger']")
	WebElement Phototrigger;
	@FindBy(how = How.XPATH, using = "//input[@id='photoCaptre']")
	WebElement Snapok;
	@FindBy(how = How.XPATH, using = "//div[@class='col-md-12 top-space text-center']/input[1]")
	WebElement Save;

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

	@FindBy(how = How.XPATH, using = "//input[@name='logmode']")
	WebElement Captcha;

	public void SetCaptcha() {
		stepstatus = setText(Captcha, "123456");
		Highlight(driver, "//input[@name='logmode']");
		reportEvent(stepstatus, "Able to Enter Captcha", "Unable to Enter Captcha", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	WebElement submit;

	public void Clickonsubmit() {
		stepstatus = clickElement(submit);
		Highlight(driver, "//input[@name='submit']");
		reportEvent(stepstatus, "Able to click on submit BUtton", "Unable to click on submit Button", driver, true);
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

	public void Clickon_General_button() {
		stepstatus = clickElement(General);
		reportEvent(stepstatus, "Able to click on General BUtton", "Unable to click on General Button", driver, true);
	}

	public void Clickon_BiometricsLink() {
		stepstatus = clickElement(Biometrics);
		reportEvent(stepstatus, "Able to click on Biometrics Link", "Unable to click on Biometrics Link", driver, true);
	}

	public void Set_Application_Number(String Value) {
		stepstatus = setText(Application_Number, Value);
		reportEvent(stepstatus, "Able to Enter Application_Number", "Unable to Enter Application_Number", driver, true);
	}

	public void Clickon_Getdetails() {
		stepstatus = clickElement(Getdetails);
		reportEvent(stepstatus, "Able to Click Getdetails button ", "Unable to Click Getdetails button", driver, true);
	}

	public void Set_CanvasSignature(String ObjectXpath) {
		wait(2);
		scrooldown(driver);
		stepstatus = CaptureSignature(driver, CanvasSignature, ObjectXpath);
		reportEvent(stepstatus, "Able to do CanvasSignature ", "Unable to do CanvasSignature", driver, true);
		wait(2);

	}

	public void Clickon_Capturesignaturebutton() {
		stepstatus = clickElement(CaptureSignature);
		reportEvent(stepstatus, "Able to Click Getdetails button ", "Unable to Click Getdetails button", driver, true);
	}

	public void Set_PhotoCapture() {
		scrooldown(driver);
		stepstatus = clickElement(PhotoCapture);
		reportEvent(stepstatus, "Able to do PhotoCapture ", "Unable to do PhotoCapture", driver, true);
	}

	public void StartCamera() {
		wait(2);
		stepstatus = clickElement(startcamera);
		reportEvent(stepstatus, "Able to click on Start Camera ", "Unable to click on Start Camera", driver, true);
	}

	public void TakeSnapshot() {
		wait(2);
		stepstatus = JsclickElement(takesnap, driver);
		reportEvent(stepstatus, "Able to click on TakeSnapshot", "Unable click on TakeSnapshot", driver, true);
	}

	public void StartCrop() {
		wait(1);
		stepstatus = clickElement(startcrop);
		reportEvent(stepstatus, "Able to click on Start Crop", "Unable click on Start Crop", driver, true);
	}

	public void EndCrop() {
		wait(1);

		stepstatus = clickElement(endcrop);
		reportEvent(stepstatus, "Able to click on End Crop", "Unable click on End Crop", driver, true);

	}

	public void Clickon_CropSelected() {
		wait(1);
		stepstatus = clickElement(CropSelected);
		reportEvent(stepstatus, "Able to click on CropSelected ", "Unable to click on CropSelected", driver, true);
	}

	public void Clickon_Phototriggerbutton() {
		stepstatus = clickElement(Phototrigger);
		reportEvent(stepstatus, "Able to click on Phototrigger button ", "Unable to click on Phototrigger button",
				driver, true);
	}

	public void Clickon_Snapokbutton() {
		stepstatus = clickElement(Snapok);
		reportEvent(stepstatus, "Able to click on Snapok button ", "Unable to click on Phototrigger button", driver,
				true);
	}

	public void Clickon_Savebutton() {
		stepstatus = clickElement(Save);
		String title = driver.getTitle();
		if (title.equals("Success Biometrics Home")) {
			setdata("StatusofCaptureSigandPhoto", "Success");
		} else {
			setdata("StatusofCaptureSigandPhoto", "Fail");
		}
		// reportEvent(stepstatus, "Able to click on Save button ", "Unable to click on
		// Save button", driver, true);
	}

}
