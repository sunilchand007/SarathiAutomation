package pageobjects;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;
import utility.Flows;


public class UploadPhoto_SignaturePageOLD extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;
	Flows validity;
	public UploadPhoto_SignaturePageOLD(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelements
	@FindBy(how = How.XPATH, using = "//select[@name='stName']")
	WebElement Selectstatename;
	@FindBy(how = How.XPATH, using = "//span[1][text()='Apply Online']")
	WebElement Applyonline;
	@FindBy(how = How.XPATH, using = "//a[text()='Application Status']")
	WebElement Applicationstatus;
	@FindBy(how = How.XPATH, using = "//input[@name='appnumber']")
	WebElement Application_Number;
	@FindBy(how = How.XPATH, using = "//input[@name='dob']")
	WebElement DateofBirth;
	@FindBy(how = How.XPATH, using = "//input[@id='submit']")
	WebElement Submit;
	@FindBy(how = How.XPATH, using = "//input[@value='Get Details']")
	WebElement GetDetails;
	@FindBy(how = How.XPATH, using = "//input[@value='UPLOAD PHOTO AND SIGNATURE']")
	WebElement Clickradio;
	@FindBy(how = How.XPATH, using = "//button[@id='applViewStages_0']")
	WebElement Proceed;
	@FindBy(how = How.XPATH, using = "//input[@id='upldFiles']")
	WebElement UploadandViewfiles;
	@FindBy(how = How.XPATH, using = "//input[@id='photoAndSignature']")
	WebElement SavephotoandSignature;
	@FindBy(how = How.XPATH, using = "//input[@value='Next'][1]")
	WebElement Next;

	// Related methods to perform operation on webelements
	public void Selectstatename(String Option) {
		stepstatus = basepage.setOptionInSelectBox(Selectstatename, Option);
		reportEvent(stepstatus, "Able to Select Statename", "Unable to Select Statename", driver, true);
	}

	public void Clickon_Applyonline() {
		stepstatus = basepage.clickElement(Applyonline);
		reportEvent(stepstatus, "Able to click Apply online Link", "Unable to click Apply online Link", driver, true);
	}

	public void Clickon_Application_Status_Link() {
		stepstatus = basepage.clickElement(Applicationstatus);
		reportEvent(stepstatus, "Able to click on Applicationstatus Link", "Unable to cclick on Applicationstatus Link",
				driver, true);
	}

	public void Set_Application_Number(String value) {
		stepstatus = basepage.setText(Application_Number, value);
		reportEvent(stepstatus, "Able to Enter Application Number ", "Unable to Enter Application Number", driver,
				true);
	}

	public void Set_DateofBirth(String value) {
		stepstatus = basepage.setText(DateofBirth, value);
		reportEvent(stepstatus, "Able to Enter Date of Birth ", "Unable to Enter Date of Birth", driver, true);
	}

	public void Clickon_Submit_Button() {
		stepstatus = basepage.clickElement(Submit);
		reportEvent(stepstatus, "Able to click submit button", "Unable to click submit button", driver, true);
	}

	public void Clickon_GetDetails() {
		stepstatus = basepage.clickElement(GetDetails);
		reportEvent(stepstatus, "Able to click GetDetails button", "Unable to click GetDetails button", driver, true);
	}

	public void Do_ScrollDown() {
		stepstatus = basepage.scrooldown(driver);
		reportEvent(stepstatus, "Able to do Scrolldown", "Unable to do Scrolldown", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//button[text()='x']")
	WebElement ClosePopUp;

	public void Clickon_Proceed_Button() {
		if (basepage.clickElement(Clickradio)) {
			stepstatus = basepage.clickElement(Proceed);
			wait(1);
			try {
				if (isDisplayed(ClosePopUp) == true) {
					clickElement(ClosePopUp);
				} else {
					System.out.println("There is no Dialog Model Popup");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@FindBy(how = How.XPATH, using = "//button[@id='BUploadPhoto']")
	WebElement Browsebutton1;
	
	public void Clickon_Browse_Button1() {
		wait(20);
		try {
			if (isEnabled(Browsebutton1) == true) {
				stepstatus = basepage.clickElement(Browsebutton1);
				reportEvent(stepstatus, "Able to click Browsebutton1 ", "Unable to click Browsebutton1 ", driver, true);
				wait(5);
				basepage.Upload("AutoIT\\TestfileImage.exe");
				basepage.RobotKeysFileUpload("");
				wait(5);
			} else {
				System.out.println("Browse one Button is disabled");
			}
		} catch (ElementClickInterceptedException e) {
			System.out.println("Exception Occured due to Browse button disabled");
		}

	}

	@FindBy(how = How.XPATH, using = "//button[@id='BUploadSign']")
	WebElement Browsebutton2;
	
	public void Clickon_Browse_Button2() {
		wait(20);
		try {
			if (isEnabled(Browsebutton2) == true) {
				stepstatus = basepage.clickElement(Browsebutton2);
				reportEvent(stepstatus, "Able to click Browsebutton2 ", "Unable to click Browsebutton2 ", driver, true);
				wait(5);
				basepage.Upload("AutoIT\\TestFileSignature.exe");
				wait(5);
			} else {
				System.out.println("Browse one Button2 is disabled");
			}
			
			
		} catch (Exception e) {
			System.out.println("Exception Occured due to Browse button disabled");

		}
		
		wait(5);

	}

	public void Clickon_UploadandViewfiles() {
      wait(5);
		if (isEnabled(UploadandViewfiles)) {
			
			stepstatus = basepage.clickElement(UploadandViewfiles);
			wait(2);
			// try {
			// if (isDisplayed(ClosePopUp) == true) {
			// clickElement(ClosePopUp);
			// } else {
			// System.out.println("There is no Dialog Model Popup");
			// }
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
			reportEvent(stepstatus, "Able to click UploadandViewfiles button ",
					"Unable to click UploadandViewfiles button ", driver, true);
		} else {
			reportEvent(stepstatus, "Able to click UploadandViewfiles button ",
					"Unable to click UploadandViewfiles button ", driver);

		}

	}

	@FindBy(how = How.XPATH, using = "(//h3)[3]")
	WebElement Sucess;

	public void Clickon_SavephotoandSignature() {
		wait(3);

		if (isEnabled(SavephotoandSignature)) {
			stepstatus = basepage.clickElement(SavephotoandSignature);
			wait(1);
			
			if (basepage.alertExist(driver)) {
				basepage.acceptAlert(driver);
			} else {
				basepage.dismissAlert(driver);
			}
			// try {
			// if (isDisplayed(ClosePopUp) == true) {
			// clickElement(ClosePopUp);
			// } else {
			// System.out.println("There is no Dialog Model Popup");
			// }
			// } catch (Exception e) {
			// e.printStackTrace();
			// }

			// if (isDisplayed(Sucess) == true) {
			// String stext = Sucess.getText();
			// if (stext.equals("Inserted Successfully...")) {
			// setdata("StatusofUploadPhotoandSignature", "Success");
			// } else {
			// setdata("StatusofUploadPhotoandSignature", "Fail");
			// }
			//
			// }

		} else {
			// stepstatus = basepage.clickElement(SavephotoandSignature);
			// reportEvent(stepstatus, "Able to click SavephotoandSignature button ",
			// "Unable to click SavephotoandSignature button ", driver);
			System.out.println("Button not Enabled");

		}

	}

	public void Clickon_Next() {
		stepstatus = basepage.clickElement(Next);
		reportEvent(stepstatus, "Able to click Next", "Unable to click Next", driver, true);
	}

	// new
	@FindBy(how = How.XPATH, using = "//a[text() ='Upload Photograph and Signature']")
	WebElement clickonuploadphotoandsignature;

	public void click_on_uploadphotoandsignature() {
		stepstatus = basepage.clickElement(clickonuploadphotoandsignature);
		reportEvent(stepstatus, "Able to click on  upload photo and signature",
				"Unable to click on upload and signature ", driver, true);
	}

	// new
	@FindBy(how = How.XPATH, using = "//input[@value='Get Details']")
	WebElement clickongetdetails;

	public void click_on_Getdetails() {
		stepstatus = basepage.clickElement(clickongetdetails);
		reportEvent(stepstatus, "Able to click on  getdetails", "Unable to click on get details ", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()=' Upload Document ']")
	WebElement UploadDoc;

	public void Mouserhoveron_UploadDocument() {
		stepstatus = basepage.mouseHover(UploadDoc, driver);
		reportEvent(stepstatus, "Able to do Mousehover action on Upload Document",
				"Unable to do Mousehover action on Upload Document", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Upload Photograph and Signature']")
	WebElement UploadPhotoSig;

	public void Clickon_Upload_Photograph_and_Signature() {
		stepstatus = basepage.clickElement(UploadPhotoSig);
		reportEvent(stepstatus, "Able to click Upload Photograph and Signature",
				"Unable to click Upload Photograph and Signature", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='stName']")
	WebElement SelectStatename;

	public void SelectStatename(String Option) {
		stepstatus = basepage.setOptionInSelectBox(SelectStatename, Option);
		reportEvent(stepstatus, "Able to Select Statename", "Unable to Select Statename", driver, true);
	}

	public void SelectState() {
		try {
			loaddata();
			SelectStatename(prop.getProperty(getdata("State")));
		} catch (Exception e) {

		}

	}

	public void Menuitem_Upload_Photograph_And_Signature() {
		Mouserhoveron_UploadDocument();
		Clickon_Upload_Photograph_and_Signature();
		Set_Application_Number(getdata("ApplicationNo"));
		Set_DateofBirth(getdata("DateofBirth"));
		Clickon_GetDetails();
		Clickon_Browse_Button1();
		Clickon_Browse_Button2();
		Clickon_UploadandViewfiles();
		Clickon_SavephotoandSignature();
		Clickon_Next();
		
	}

}
