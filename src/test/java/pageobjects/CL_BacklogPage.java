package pageobjects;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import frameworkLibrary.BasePage;
import utility.Utilitymethods;

public class CL_BacklogPage extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;
	Utilitymethods utilitymethods;

	public CL_BacklogPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='CL ']")
	WebElement CL;

	public void ClickonCL() {
		stepstatus = basepage.clickElement(CL);
		reportEvent(stepstatus, "Able to Click on CL", "Unable to Click on CL", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='CL-BKLOG']")
	WebElement CLBacklog;

	public void ClickonCLBacklog() {
		stepstatus = basepage.clickElement(CLBacklog);
		reportEvent(stepstatus, "Able to Click on CLBacklog", "Unable to Click on CLBacklog", driver, true);
	}

	
	  @FindBy(how = How.XPATH, using = "//input[@id='clIssueDate']") WebElement
	 Firstissuedate;
	  
	  public void SetFirstissuedate(String value) { stepstatus =
	 basepage.SetTextAndEscape(Firstissuedate, value); reportEvent(stepstatus,
	  "Able to Enter Firstissuedate", "Unable to Enter Firstissuedate", driver,
	  true); }
	 

	/*
	 * @FindBy(how = How.XPATH, using = "//input[@id='clIssueDate']") WebElement
	 * calendar;
	 * 
	 * @FindBy(how = How.XPATH, using = "//select[@aria-label='Select month']")
	 * WebElement monthdropdown;
	 * 
	 * @FindBy(how = How.XPATH, using = "//select[@aria-label='Select year']")
	 * WebElement yeardropdown;
	 * 
	 * public void SetFirstissuedate(String date, String month, String year) {
	 * 
	 * stepstatus = basepage.selectDate(driver, calendar, monthdropdown,
	 * yeardropdown, date, month, year); reportEvent(stepstatus,
	 * "Able to Enter OriginalDLno", "Unable to Enter OriginalCLno", driver, true);
	 * 
	 * }
	 */
	

	@FindBy(how = How.XPATH, using = "//input[@id='clOldClNo']")
	WebElement SetOriginalCLno;

	public void SetOriginalCLno(String value) {

		try {

			stepstatus = basepage.SetTextAndTAB(SetOriginalCLno, value);

		} catch (UnhandledAlertException f) {
			try {
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert data: " + alertText);
				alert.accept();
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clNumLicNo']")
	WebElement SetNumericCLno;

	public void SetNumericCLno(String value) {
		stepstatus = basepage.setText(SetNumericCLno, value);
		reportEvent(stepstatus, "Able to Enter OriginalDLno", "Unable to Enter OriginalCLno", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clFname']")
	WebElement Name;

	public void SetName(String value) {
		stepstatus = basepage.setText(Name, value);
		reportEvent(stepstatus, "Able to Enter Name", "Unable to Enter Name", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clMname']")
	WebElement MiddleName;

	public void SetMiddleName(String value) {
		stepstatus = basepage.setText(MiddleName, value);
		reportEvent(stepstatus, "Able to Enter MiddleName", "Unable to Enter MiddleName", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clLname']")
	WebElement LastName;

	public void SetLastName(String value) {
		stepstatus = basepage.setText(LastName, value);
		reportEvent(stepstatus, "Able to Enter LastName", "Unable to Enter LastName", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='clRelation']")
	WebElement Relation;

	public void SetRelation(String value) {
		stepstatus = basepage.setOptionInSelectBox(Relation, value);
		reportEvent(stepstatus, "Able to Enter Relation", "Unable to Enter Relation", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clRFname']")
	WebElement Relationfirstname;

	public void SetRelationfirstname(String value) {
		stepstatus = basepage.setText(Relationfirstname, value);
		reportEvent(stepstatus, "Able to Enter Relationfirstname", "Unable to Enter Relationfirstname", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clRMname']")
	WebElement RelationMiddlename;

	public void SetRelationMiddlename(String value) {
		stepstatus = basepage.setText(RelationMiddlename, value);
		reportEvent(stepstatus, "Able to Enter RelationMiddlename", "Unable to Enter RelationMiddlename", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clRLname']")
	WebElement RelationLastname;

	public void SetRelationLastname(String value) {
		stepstatus = basepage.setText(RelationLastname, value);
		reportEvent(stepstatus, "Able to Enter RelationLastname", "Unable to Enter RelationLastname", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clGender1']")
	WebElement Gender;

	public void ClickonGender() {
		stepstatus = basepage.clickElement(Gender);
		reportEvent(stepstatus, "Able to click on Gender", "Unable to click on Gender", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='clBlood']")
	WebElement Bloodgroup;

	public void SetBloodgroup(String value) {
		stepstatus = basepage.setOptionInSelectBox(Bloodgroup, value);
		reportEvent(stepstatus, "Able to Enter Bloodgroup", "Unable to Enter Bloodgroup", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clAge']")
	WebElement Age;
	@FindBy(how = How.XPATH, using = "//div//input[@id='clDateofBirth']")
	WebElement DateofBirth;

	public void SetAge(String value) {
		stepstatus = basepage.setText(Age, value);
		reportEvent(stepstatus, "Able to Enter Age", "Unable to Enter Age", driver, true);
		DOB = DateofBirth.getText();
		System.out.println(DOB);
//		DOB = DateofBirth.getText();
//		setdata("DateofBirth",DOB);
//		System.out.println("Date of Birth:" +DOB);

	}

	@FindBy(how = How.XPATH, using = "//select[@id='clEduQ']")
	WebElement Qualification;

	public void SetQualification(String value) {
		stepstatus = basepage.setOptionInSelectBox(Qualification, value);
		reportEvent(stepstatus, "Able to Enter Qualification", "Unable to Enter Qualification", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clMobile']")
	WebElement Mobilenumber;

	public void SetMobilenumber(String value) {
		stepstatus = basepage.setText(Mobilenumber, value);
		reportEvent(stepstatus, "Able to Enter Mobilenumber", "Unable to Enter Mobilenumber", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Address Details']")
	WebElement AddressTab;

	public void ClickAddressTab() {
		stepstatus = basepage.clickElement(AddressTab);
		reportEvent(stepstatus, "Able to Click AddressTab", "Unable to Click AddressTab", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='clPresState']")
	WebElement State;

	public void SetState(String value) {
		stepstatus = basepage.setValueInSelectBox(State, value);
		reportEvent(stepstatus, "Able to Enter State", "Unable to Enter State", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='clPresDistrict']")
	WebElement PresentDistrict;

	public void SetDistrict(String value) {
		stepstatus = basepage.setOptionInSelectBox(PresentDistrict, value);
		reportEvent(stepstatus, "Able to Enter District", "Unable to Enter District", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='clPresSubDistrict']")
	WebElement SubDistrict;

	public void SetSubDistrict(String value) {
		stepstatus = basepage.setOptionInSelectBox(SubDistrict, value);
		reportEvent(stepstatus, "Able to Enter SubDistrict", "Unable to Enter SubDistrict", driver, true);
	}

	public void TypeofDistdetails() {
		wait(2);
		WebElement Dist = driver.findElement(By.xpath("//select[@id='clPresDistrict']"));
		Select District = new Select(Dist);
		List<WebElement> options = District.getOptions();
		for (int i = 0; i <= options.size() - 1; i++) {
			try {
				Dist = driver.findElement(By.xpath("//select[@id='clPresDistrict']"));
				District = new Select(Dist);
				options = District.getOptions();
				if (!options.get(1).getText().contains("Select")) {
					System.out.println(options.get(1).getText());
					District.selectByIndex(1);
					Thread.sleep(5000);
					WebElement SubDist = driver.findElement(By.xpath("//select[@id='clPresSubDistrict']	"));
					Select subdist = new Select(SubDist);
					List<WebElement> Subdistoptions = subdist.getOptions();
					System.out.println(Subdistoptions.get(1).getText());
					Subdistoptions.get(1).getText();
					if (subdist.getOptions().size() > 1
							&& !subdist.getOptions().get(1).getText().toLowerCase().contains("Select")) {
						subdist.selectByIndex(1);
						break;
					}
				} else {
					System.out.println("Else block....: " + options.get(1).getText());
				}
			} catch (StaleElementReferenceException f) {
				f.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clPresHouseNo']")
	WebElement HouseNo;

	public void EnterHouseNo() {
		stepstatus = basepage.setText(HouseNo, "25/89/1");
		reportEvent(stepstatus, "Able to Enter HouseNo", "Unable to Enter HouseNo", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clPresStreet']")
	WebElement StreetName;

	public void EnterStreetName() {
		stepstatus = basepage.setText(StreetName, "Ashok Nagar");
		reportEvent(stepstatus, "Able to Enter StreetName", "Unable to Enter StreetName", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clPresPincode']")
	WebElement Pincode;

	public void SetPincode(String value) {
		stepstatus = basepage.setText(Pincode, value);
		reportEvent(stepstatus, "Able to Enter Pincode", "Unable to Enter Pincode", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clCopy']")
	WebElement Checkbox;

	public void ClickonCheckbox() {
		stepstatus = basepage.clickElement(Checkbox);
		reportEvent(stepstatus, "Able to click on Checkbox", "Unable to click on Checkbox", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Licence Details']")
	WebElement LicenceDetails;

	public void ClickonLicencedetails() {
		stepstatus = basepage.clickElement(LicenceDetails);
		reportEvent(stepstatus, "Able to click on Licencedetails", "Unable to click on Licencedetails", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clTestDate']")
	WebElement Testdate;

	public void EnterTestDate(String value) {
		stepstatus = basepage.SetTextAndEscape(Testdate, value);
		reportEvent(stepstatus, "Able to Enter Test date", "Unable to  Enter Test date", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='clBadgeNo']")
	WebElement BadgeNo;

	public void EnterBadgeNo(String value) {
		stepstatus = basepage.SetTextAndEscape(BadgeNo, value);
		reportEvent(stepstatus, "Able to Enter Badge No.", "Unable to  Enter Badge No.", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='CLbacklogForm__execute']")
	WebElement SubmitCL;

	public void ClickOnSubmit() throws IOException, InterruptedException {
		stepstatus = basepage.clickElement(SubmitCL);
		reportEvent(stepstatus, "Able to Click Submit", "Unable to click submit", driver, true);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {
			basepage.dismissAlert(driver);
		}
	}

	@FindBy(how = How.XPATH, using = "//div[@id='navbar']//a[text()='Logout']")
	WebElement Logout;

	public void Clickon_Logout() {
		// if(driver.getPageSource().contains("Application No 116524 is Approved"))
		wait(5);
		stepstatus = basepage.clickElement(Logout);
		reportEvent(stepstatus, "Able to click on Logout", "Unable to click on Logout", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Go to https://sarathi.preprod.nic.in/sarathiservice']")
	WebElement URL;

	public void Clickon_URL_ofstateHomePage() {
		wait(2);
		stepstatus = basepage.clickElement(URL);
		reportEvent(stepstatus, "Able to click on URL", "Unable to click on URL", driver, true);

	}

}
