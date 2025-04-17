package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class HoldingForeignDL extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public HoldingForeignDL(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//select[@name='stName']")
	WebElement Selectstatename;

	public void Selectstatename(String Option) {
		stepstatus = basepage.setOptionInSelectBox(Selectstatename, Option);
		reportEvent(stepstatus, "Able to Select Statename", "Unable to Select Statename", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//span[1][text()='Apply Online']")
	WebElement Applyonline;

	public void clickonapplyonline() {
		stepstatus = basepage.clickElement(Applyonline);
		reportEvent(stepstatus, "Able to click Apply online Link", "Unable to click Apply online Link", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//li[@class='menu-list']/a[text()='New Driving Licence']")
	WebElement NewDrivinglicence;

	public void clickon_NewDrivinglicence() {
		stepstatus = basepage.clickElement(NewDrivinglicence);
		reportEvent(stepstatus, "Able to click NewDrivinglicence Link", "Unable to click NewDrivinglicence Link",
				driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Continue']")
	WebElement Contuine;

	public void clickon_Contuinebutton() {
		stepstatus = basepage.clickElement(Contuine);
		reportEvent(stepstatus, "Able to click Contuinebutton", "Unable to click Contuinebutton", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='llHolder2']")
	WebElement HoldingForeignDL;

	public void Clickon_HoldingForeignDL() {
		stepstatus = basepage.clickElement(HoldingForeignDL);
		reportEvent(stepstatus, "Able to click HoldingForeignDL", "Unable to click HoldingForeignDL", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='newLLApplForm_LicenseNO']")
	WebElement LicenseNo;

	public void Enter_LicenseNo(String value) {
		stepstatus = basepage.setText(LicenseNo, value);
		reportEvent(stepstatus, "Able to Enter  LicenseNo", "Unable to Enter LicenseNo", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='frIssueauthority']")
	WebElement IssueAuthority;

	public void Enter_IssueAuthority(String value) {
		stepstatus = basepage.setText(IssueAuthority, value);
		reportEvent(stepstatus, "Able to Enter  IssueAuthority", "Unable to Enter IssueAuthority", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='frissuedt']")
	WebElement Dateofissue;

	public void Enter_Dateofissueity(String value) {
		stepstatus = basepage.setText(Dateofissue, value);
		reportEvent(stepstatus, "Able to Enter  Dateofissue", "Unable to Enter Dateofissue", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='frvldfrom']")
	WebElement ValidFrom;

	public void Enter_ValidFrom(String value) {
		stepstatus = basepage.setText(ValidFrom, value);
		reportEvent(stepstatus, "Able to Enter  ValidFrom", "Unable to Enter ValidFrom", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='frvldto']")
	WebElement ValidTo;

	public void Enter_ValidTo(String value) {
		stepstatus = basepage.SetTextAndEscape(ValidTo, value);
		reportEvent(stepstatus, "Able to Enter  ValidTo", "Unable to Enter ValidTo", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='newLLApplForm_frclassofvehicle']")
	WebElement ClassofVehicles_Skills;

	public void Enter_ClassofVehicles_Skills(String value) {
		stepstatus = basepage.setText(ClassofVehicles_Skills, value);
		reportEvent(stepstatus, "Able to Enter ClassofVehicles_Skills", "Unable to Enter ClassofVehicles_Skills",
				driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='newLLApplForm_pno']")
	WebElement PassportNo;

	public void Enter_PassportNo(String value) {
		stepstatus = basepage.setText(PassportNo, value);
		reportEvent(stepstatus, "Able to Enter PassportNo", "Unable to Enter PassportNo", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='dlissuecntry']")
	WebElement DLIssueCountry;

	public void SelectDLIssueCountry(String Option) {
		stepstatus = basepage.setOptionInSelectBox(DLIssueCountry, Option);
		reportEvent(stepstatus, "Able to Select DLIssueCountry", "Unable to Select DLIssueCountry", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='fname']")
	WebElement FirstName;

	public void SetFirstName(String Value) {
		stepstatus = basepage.setText(FirstName, Value);
		reportEvent(stepstatus, "Able to Enter Firstname", "Unable to Enter Firstname", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='mname']")
	WebElement Middlename;

	public void SetMiddlename(String Value) {
		stepstatus = basepage.setText(Middlename, Value);
		reportEvent(stepstatus, "Able to Enter Middlename", "Unable to Enter Middlename", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='lname']")
	WebElement LastName;

	public void SetLastName(String Value) {
		stepstatus = basepage.setText(LastName, Value);
		reportEvent(stepstatus, "Able to Enter Lastname", "Unable to Enter Lastname", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='relationType']")
	WebElement RelationType;

	public void SetRelationType(String option) {
		stepstatus = basepage.setOptionInSelectBox(RelationType, option);
		reportEvent(stepstatus, "Able to Select RelationType", "Unable to Select RelationType", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='swdfName']")
	WebElement RelationFirstName;

	public void SetRelationFirstName(String Value) {
		stepstatus = basepage.setText(RelationFirstName, Value);
		reportEvent(stepstatus, "Able to Enter RelationFirstName", "Unable to Enter RelationFirstName", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='swdmName']")
	WebElement RelationMiddleName;

	public void SetRelationMiddleName(String Value) {
		stepstatus = basepage.setText(RelationMiddleName, Value);
		reportEvent(stepstatus, "Able to Enter RelationMiddleName", "Unable to Enter RelationMiddleName", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='swdlName']")
	WebElement RelationLastName;

	public void SetRelationLastName(String Value) {
		stepstatus = basepage.setText(RelationLastName, Value);
		reportEvent(stepstatus, "Able to Enter RelationLastName", "Unable to Enter RelationLastName", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='gender1']")
	WebElement Gender;

	public void SetGender() {
		stepstatus = basepage.clickElement(Gender);
		reportEvent(stepstatus, "Able to Select Gender", "Unable to Select Gender", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='age']")
	WebElement Age;

	public void SetAge(String age) {
		stepstatus = basepage.setText(Age, age);
		reportEvent(stepstatus, "Able to Enter Age", "Unable to Enter Age", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='placeOfBirth']")
	WebElement PlaceofBirth;

	public void SetPlaceofBirth(String value) {
		stepstatus = basepage.setText(PlaceofBirth, value);
		reportEvent(stepstatus, "Able to Enter PlaceofBirth", "Unable to Enter PlaceofBirth", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='eduQual']")
	WebElement Qualification;

	public void SetQualification(String option) {
		stepstatus = basepage.setOptionInSelectBox(Qualification, option);
		reportEvent(stepstatus, "Able to Select Qualification", "Unable to Select Qualification", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='bloodGroup']")
	WebElement Bloodgroup;

	public void SetBloodgroup(String option) {
		stepstatus = basepage.setOptionInSelectBox(Bloodgroup, option);
		reportEvent(stepstatus, "Able to Select Bloodgroup", "Unable to Select Bloodgroup", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//*[@name='mobileNumber']")
	WebElement MobileNumber;

	public void Enter_MobileNumber(String value) {
		stepstatus = basepage.setText(MobileNumber, value);
		reportEvent(stepstatus, "Able to Enter PlaceofBirth", "Unable to Enter PlaceofBirth", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//*[text()='Address Details']")
	WebElement AddressDetails;

	public void clickon_AddressDetails() {
		stepstatus = basepage.clickElement(AddressDetails);
		reportEvent(stepstatus, "Able to click AddressDetails ", "Unable to click AddressDetails", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='presState']")
	WebElement Statee;

	public void SetStatee(String option) {
		stepstatus = basepage.setOptionInSelectBox(Statee, option);
		reportEvent(stepstatus, "Able to Select Statee", "Unable to Select Statee", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='presDistrict']")
	WebElement District;

	public void SetDistrict(String option) {
		stepstatus = basepage.setOptionInSelectBox(District, option);
		reportEvent(stepstatus, "Able to Select District", "Unable to Select District", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='presSubDistrict']")
	WebElement Tahsil;

	public void SetTahsil(String option) {
		stepstatus = basepage.setOptionInSelectBox(Tahsil, option);
		reportEvent(stepstatus, "Able to Select Tahsil", "Unable to Select Tahsil", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='presCity']")
	WebElement Village;

	public void SetVillage(String option) {
		stepstatus = basepage.setOptionInSelectBox(Village, option);
		reportEvent(stepstatus, "Able to Select Village", "Unable to Select Village", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='presHouseNo']")
	WebElement Houseno;

	public void SetHouseno(String value) {
		stepstatus = basepage.setText(Houseno, value);
		reportEvent(stepstatus, "Able to Enter Houseno", "Unable to Enter Houseno", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='presLocation']")
	WebElement LandMark;

	public void SetLandMark(String value) {
		stepstatus = basepage.setText(LandMark, value);
		reportEvent(stepstatus, "Able to Enter LandMark", "Unable to Enter LandMark", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='permLocationIDP']")
	WebElement LandMarkCopy;

	public void SetLandMarkCopy(String value) {
		stepstatus = basepage.setText(LandMarkCopy, value);
		reportEvent(stepstatus, "Able to Enter LandMarkCopy", "Unable to Enter LandMarkCopy", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='presPinCode']")
	WebElement Pincode;

	public void SetPincode(String Pin) {
		stepstatus = basepage.setText(Pincode, Pin);
		reportEvent(stepstatus, "Able to Select Pincode", "Unable to Select Pincode", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='llFromState1']")
	WebElement State;
	@FindBy(how = How.XPATH, using = "//select[@name='llFromRTO1']")
	WebElement RTO;

	public void SetState(String option) {
		stepstatus = basepage.setOptionInSelectBox(State, option);
		reportEvent(stepstatus, "Able to Select State", "Unable to Select State", driver, true);
	}

	public void SetRTO(String option) {
		stepstatus = basepage.setOptionInSelectBox(RTO, option);
		reportEvent(stepstatus, "Able to Select RTO", "Unable to Select RTO", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='=>']")
	WebElement Rightarrow;

	public void ClickRightarrow() {
		stepstatus = basepage.clickElement(Rightarrow);
		reportEvent(stepstatus, "Able to Click Rightarrow", "Unable to Click Rightarrow", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='checkCovs']")
	WebElement SelectCOV;

	public void SetCOV(String option) {
		stepstatus = basepage.setOptionInSelectBox(SelectCOV, option);
		reportEvent(stepstatus, "Able to SelectCOV", "Unable to SelectCOV", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='sub']")
	WebElement Submit;

	public void SetSubmitthree() {
		stepstatus = basepage.clickElement(Submit);
		reportEvent(stepstatus, "Able to Click Submit Button", "Unable to Click Submit Button", driver);
	}

	@FindBy(how = How.XPATH, using = "//button[@name='dlservices.exit']")
	WebElement Exit;

	public void Clickon_Exitbutton() {
		stepstatus = basepage.clickElement(Exit);
		reportEvent(stepstatus, "Able to Click Exit", "Unable to Click Exit", driver, true);
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement Username;

	public void setUserName(String Strusername) {
		stepstatus = basepage.setText(Username, Strusername);
		reportEvent(stepstatus, "Able to enter username", "Unable to enter username", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement Password;

	public void setpassword(String Strpassword) {
		stepstatus = basepage.setText(Password, Strpassword);
		reportEvent(stepstatus, "Able to enter password", "Unable to enter password", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	WebElement Singin;

	public void ClickonLogin() {
		stepstatus = basepage.clickElement(Singin);
		reportEvent(stepstatus, "Able to click on Sign-In BUtton", "Unable to click on Sign-In Button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='crd1'][1]")
	WebElement Radiobutton;

	public void SelectRTOtype() {
		
		
		
		stepstatus = basepage.clickElement(Radiobutton);
		reportEvent(stepstatus, "Able to click on Radiobutton", "Unable to click on Radiobutton", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='crd2']")
	WebElement Radiobutton1;

	public void SelectRTOtypo() {
		stepstatus = basepage.clickElement(Radiobutton1);
		reportEvent(stepstatus, "Able to click on Radiobutton", "Unable to click on Radiobutton", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='login']")
	WebElement login;

	public void Clickonlogin() {
		stepstatus = basepage.clickElement(login);
		reportEvent(stepstatus, "Able to click on login-In BUtton", "Unable to click on login Button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li[6]/a")
	WebElement General;

	public void Clickon_General_button() {
		stepstatus = basepage.clickElement(General);
		reportEvent(stepstatus, "Able to click on General BUtton", "Unable to click on General Button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='SCRUTINY']")
	WebElement Scrutiny;

	public void Clickon_Scrutiny_Link() {
		stepstatus = basepage.clickElement(Scrutiny);
		reportEvent(stepstatus, "Able to click on Scrutiny BUtton", "Unable to click on Scrutiny Button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='applicationNumber']")
	WebElement RTOApplication_Number;

	public void Set_RTOApplication_Number(String value) {
		stepstatus = basepage.setText(RTOApplication_Number, value);
		reportEvent(stepstatus, "Able to Enter Application_Number", "Unable to Enter Application_Number", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='_scrutiny_proceed']")
	WebElement RTOProceed;

	public void Clickon_RTOProceed_button() {
		stepstatus = basepage.clickElement(RTOProceed);
		reportEvent(stepstatus, "Able to click on Proceed BUtton", "Unable to click on Proceed Button", driver, true);
		basepage.scrooldown(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Verification of Documents']")
	WebElement VerificationofDocuments;

	public void Clickon_VerificationofDocuments_Link() {
		stepstatus = basepage.clickElement(VerificationofDocuments);
		reportEvent(stepstatus, "Able to click on VerificationofDocuments_Link",
				"Unable to click on VerificationofDocuments_Link", driver);
		wait(2);
		if (basepage.alertExist(driver)) {

			basepage.acceptAlert(driver);
		} else {
			basepage.dismissAlert(driver);
		}

	}

	@FindBy(how = How.XPATH, using = "//i[text()='Medical Certificate-Form1 (Self Decleration)']")
	WebElement Firstprooflink;
	@FindBy(how = How.XPATH, using = "//i[text()='Birth Certificate issued by Municipality']")
	WebElement Secondprooflink;
	@FindBy(how = How.XPATH, using = "//i[text()='Passport']")
	WebElement Thirdprooflink;
	@FindBy(how = How.XPATH, using = "//input[@id='documentsapproval_0']")
	WebElement windowSubmit;

	public void Clickon_prooflinks() {
		
		List<WebElement> ele = driver.findElements(By.xpath("//table/tbody/tr/td[2]/following-sibling::td[1]/i"));

		for (WebElement links : ele) {

			String txt = links.getText();
			System.out.println(txt);
			wait(2);
			links.click();

		}

//		wait(2);
//		basepage.SwitchtoWindowByTitle("Documents Approved by Approval Authority", driver);
//		wait(1);
//		basepage.clickElement(Firstprooflink);
//		basepage.SwitchtoWindowByTitle(":::Image Displaying:::", driver);
//		basepage.closeWindowByTitle(":::Image Displaying:::", driver);
//
//		basepage.SwitchtoWindowByTitle("Documents Approved by Approval Authority", driver);
//		basepage.clickElement(Secondprooflink);
//		basepage.SwitchtoWindowByTitle(":::Image Displaying:::", driver);
//		basepage.closeWindowByTitle(":::Image Displaying:::", driver);
//
//		basepage.SwitchtoWindowByTitle("Documents Approved by Approval Authority", driver);
//		basepage.clickElement(Thirdprooflink);
//		basepage.SwitchtoWindowByTitle(":::Image Displaying:::", driver);
//		basepage.closeWindowByTitle(":::Image Displaying:::", driver);
//
//		basepage.SwitchtoWindowByTitle("Documents Approved by Approval Authority", driver);
//		basepage.clickElement(windowSubmit);
//		basepage.closeWindowByTitle("Documents Approved by Approval Authority", driver);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='approveButton']")
	WebElement Scrutinybutton;

	public void Clickon_Scrutinybutton() {
		stepstatus = basepage.clickElement(Scrutinybutton);
		reportEvent(stepstatus, "Able to click on Scrutinybutton", "Unable to click on Scrutinybutton", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Login']")
	WebElement Login;

	public void Clickon_Login_Button() {
		stepstatus = basepage.clickElement(Login);
		reportEvent(stepstatus, "Able to click on Login button", "Unable to click on Login button", driver, true);
	}

	
}
