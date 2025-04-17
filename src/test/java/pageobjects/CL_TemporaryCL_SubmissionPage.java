package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import frameworkLibrary.BasePage;

public class CL_TemporaryCL_SubmissionPage extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public CL_TemporaryCL_SubmissionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelements

	@FindBy(how = How.XPATH, using = "//select[@name='stName']")
	WebElement Selectstatename;

	public void Selectstatename(String Option) {
		stepstatus = basepage.setValueInSelectBox(Selectstatename, Option);
		reportEvent(stepstatus, "Able to Select Statename", "Unable to Select Statename", driver, true);
	}

	

	@FindBy(how = How.XPATH, using = "//span[1][text()='Apply Online']")
	WebElement Applyonline;

	public void Clickon_Applyonline() {
		stepstatus = basepage.clickElement(Applyonline);
		reportEvent(stepstatus, "Able to click Apply online Link", "Unable to click Apply online Link", driver, true);
	}

	
	
	@FindBy(how = How.XPATH, using = "//a[text()='Temporary Conductor Licence']")
	WebElement TemporaryConductorLicence;

	public void Clickon_TemporaryConductorLicence() {
		stepstatus = basepage.clickElement(TemporaryConductorLicence);
		reportEvent(stepstatus, "Able to click TemporaryConductorLicence Link", "Unable to click TemporaryConductorLicence Link",
				driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Continue']")
	WebElement Continue;

	public void Clickon_Continue() {
		stepstatus = basepage.clickElement(Continue);
		reportEvent(stepstatus, "Able to click Continue Button", "Unable to click Continue Button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='newclState']")
	WebElement CLState;

	public void Clickon_CLState(String value) {
		wait(2);
		stepstatus = basepage.setValueInSelectBox(CLState, value);
		reportEvent(stepstatus, "Able to Select CLState", "Unable to Select CLState", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='newclRto']")
	WebElement CLRTO;

	public void Clickon_CLRTO(String value) {
		wait(2);
		stepstatus = basepage.setValueInSelectBox(CLRTO, value);
		reportEvent(stepstatus, "Able to Select CLRTO", "Unable to Select CLRTO", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclFname']")
	WebElement CLFirstname;

	public void Enter_CLFirstname(String value) {
		stepstatus = basepage.setText(CLFirstname, value);
		reportEvent(stepstatus, "Able to Enter CLFirstname", "Unable to Enter CLFirstname", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclMname']")
	WebElement CLMiddlename;

	public void Enter_CLMiddlename(String value) {
		stepstatus = basepage.setText(CLMiddlename, value);
		reportEvent(stepstatus, "Able to Enter CLMiddlename", "Unable to Enter CLMiddlename", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclLname']")
	WebElement CLLastname;

	public void Enter_CLLastname(String value) {
		stepstatus = basepage.setText(CLLastname, value);
		reportEvent(stepstatus, "Able to Enter CLLastname", "Unable to Enter CLLastname", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='newclRelation']")
	WebElement CLRelationname;

	public void Select_CLRelationname(String value) {
		stepstatus = basepage.setOptionInSelectBox(CLRelationname, value);
		reportEvent(stepstatus, "Able to Select CLRelationname", "Unable to Select CLRelationname", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclRFname']")
	WebElement CLRFirstname;

	public void Enter_CLRFirstname(String value) {
		stepstatus = basepage.setText(CLRFirstname, value);
		reportEvent(stepstatus, "Able to Enter CLRFirstname", "Unable to Enter CLRFirstname", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclRMname']")
	WebElement CLRMiddlename;

	public void Enter_CLRMiddlename(String value) {
		stepstatus = basepage.setText(CLRMiddlename, value);
		reportEvent(stepstatus, "Able to Enter CLRMiddlename", "Unable to Enter CLRMiddlename", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclRLname']")
	WebElement CLRLastname;

	public void Enter_CLRLastname(String value) {
		stepstatus = basepage.setText(CLRLastname, value);
		reportEvent(stepstatus, "Able to Enter CLRLastname", "Unable to Enter CLRLastname", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='col-md-3 control-label labeled text-left']/input[1]")
	WebElement CLGender;

	public void Select_CLGender() {
		stepstatus = basepage.clickElement(CLGender);
		reportEvent(stepstatus, "Able to Select CLGender", "Unable to Select CLGender", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclAge']")
	WebElement CLAge;

	public void Select_CLAge(String value) {
		stepstatus = basepage.setText(CLAge, value);
		reportEvent(stepstatus, "Able to Enter CLAge", "Unable to Enter CLAge", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='newclEduQ']")
	WebElement CLEducation;

	public void Select_CLEducation(String Value) {
		stepstatus = basepage.setOptionInSelectBox(CLEducation, Value);
		reportEvent(stepstatus, "Able to Enter CLEducation", "Unable to Enter CLEducation", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Mobile Number']")
	WebElement CLMobilenumber;

	public void Enter_CLMobilenumber(String Value) {
		if(isEnabled(CLMobilenumber)==true) {
		stepstatus = basepage.setText(CLMobilenumber, Value);
		reportEvent(stepstatus, "Able to Enter CLMobilenumber", "Unable to Enter CLMobilenumber", driver, true);
	}else
	{System.out.println("Mobile Number is already fetched through the Authentication");}
		
		
		}

	@FindBy(how = How.XPATH, using = "//a[text()='Address Details']")
	WebElement Address;

	public void Clickon_AddressTab() {
		stepstatus = basepage.clickElement(Address);
		reportEvent(stepstatus, "Able to click Address", "Unable to Enter Address", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='newclPresState']")
	WebElement StateSelectionin_AddressTab;

	public void Select_StateSelectionin_AddressTab() {
        wait(2);
		WebElement stoption = driver.findElement(By.xpath("//select[@name='newclPresState']"));
		Select st = new Select(stoption);
		List<WebElement> options = st.getOptions();
		WebElement ele = st.getFirstSelectedOption();
		System.out.println(ele.getText());
		if (ele.getText().contains("SELECT")) {
			for (int i = 0; i <= options.size() - 1; i++) {
				try {
					stoption = driver.findElement(By.xpath("//select[@name='newclPresState']"));
					st = new Select(stoption);
					options = st.getOptions();
					if (!options.get(1).getText().contains("SELECT")) {
						loaddata();
						System.out.println(prop.getProperty(getdata("State")));
						st.selectByVisibleText(prop.getProperty(getdata("State")));
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		} else {

			System.out.println("State is already selected.");
		}

	}

	@FindBy(how = How.XPATH, using = "//select[@name='newclPresDistrict']")
	WebElement DistrictSelectionin_AddressTab;

	public void Select_DistrictSelectionin_AddressTab(String value) {
		wait(2);
		stepstatus = basepage.setOptionInSelectBox(DistrictSelectionin_AddressTab, value);
		reportEvent(stepstatus, "Able to Select DistrictSelectionin_AddressTab",
				"Unable to Select DistrictSelectionin_AddressTab", driver, true);
	}

	public void TypeDist() {
		wait(2);
		WebElement Dist = driver.findElement(By.xpath("//select[@name='newclPresDistrict']"));
		Select District = new Select(Dist);
		List<WebElement> options = District.getOptions();
		for (int i = 0; i <= options.size() - 1; i++) {
			try {
				Dist = driver.findElement(By.xpath("//select[@name='newclPresDistrict']"));
				District = new Select(Dist);
				options = District.getOptions();
				if (!options.get(1).getText().contains("SELECT")) {
					System.out.println(options.get(1).getText());
					District.selectByIndex(1);
					// District.selectByValue("530");
					wait(2);
					WebElement SubDist = driver.findElement(By.xpath("//select[@name='newclPresSubDistrict']"));
					Select subdist = new Select(SubDist);
					List<WebElement> Subdistoptions = subdist.getOptions();
					System.out.println(Subdistoptions.get(1).getText());
					Subdistoptions.get(1).getText();
					if (subdist.getOptions().size() > 1
							&& !subdist.getOptions().get(1).getText().toLowerCase().contains("SELECT SUB DISTRICT")) {
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

	@FindBy(how = How.XPATH, using = "//select[@name='newclPresSubDistrict']")
	WebElement TahsilSelectionin_AddressTab;

	public void Select_TahsilSelectionin_AddressTab(String value) {
		stepstatus = basepage.setOptionInSelectBox(TahsilSelectionin_AddressTab, value);
		reportEvent(stepstatus, "Able to Select TahsilSelectionin_AddressTab",
				"Unable to Select TahsilSelectionin_AddressTab", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclPresHouseNo']")
	WebElement HouseNumber;

	public void Enter_HouseNumber(String value) {
		stepstatus = basepage.setText(HouseNumber, value);
		reportEvent(stepstatus, "Able to Enter HouseNumber", "Unable to Enter HouseNumber", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclPresStreet']")
	WebElement StreetAddress;

	public void Enter_StreetAddress(String value) {
		stepstatus = basepage.setText(StreetAddress, value);
		reportEvent(stepstatus, "Able to Enter StreetAddress", "Unable to Enter StreetAddress", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclPresPincode']")
	WebElement Pincode;

	public void Enter_Pincode(String value) {
		stepstatus = basepage.setText(Pincode, value);
		reportEvent(stepstatus, "Able to Enter Pincode", "Unable to Enter Pincode", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='clCopy']")
	WebElement Checkbox;

	public void Clickon_Checkbox() {
		stepstatus = basepage.clickElement(Checkbox);
		reportEvent(stepstatus, "Able to Click Checkbox", "Unable to Click Checkbox", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//li[3][@role='presentation']/a")
	WebElement MedicalDetailsTab;

	public void Clickon_MedicalDetailsTab() {
		stepstatus = basepage.clickElement(MedicalDetailsTab);
		reportEvent(stepstatus, "Able to Click MedicalDetailsTab", "Unable to Click MedicalDetailsTab", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclFirstAidInstituteName']")
	WebElement FAIssuing_InstitutionName_In_First_Aid_Details;

	public void Enter_FAIssuing_InstitutionName_In_First_Aid_Details(String Value) {
		stepstatus = basepage.setText(FAIssuing_InstitutionName_In_First_Aid_Details, Value);
		reportEvent(stepstatus, "Able to Enter FAIssuing_InstitutionName_In_First_Aid_Details",
				"Unable to Enter FAIssuing_InstitutionName_In_First_Aid_Details", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclFirstAidCertificateNo']")
	WebElement Certification_Number_In_First_Aid_Details;

	public void Enter_Certification_Number_In_First_Aid_Details(String Value) {
		stepstatus = basepage.setText(Certification_Number_In_First_Aid_Details, Value);
		reportEvent(stepstatus, "Able to Enter Certification_Number_In_First_Aid_Details",
				"Unable to Enter Certification_Number_In_First_Aid_Details", driver, true);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='newclFirstAidPlaceofIssue']")
	WebElement PlaceofIssued_In_First_Aid_Details;

	public void Enter_PlaceofIssued_In_First_Aid_Details(String Value) {
		stepstatus = basepage.setText(PlaceofIssued_In_First_Aid_Details, Value);
		reportEvent(stepstatus, "Able to Enter PlaceofIssued_In_First_Aid_Details",
				"Unable to Enter PlaceofIssued_In_First_Aid_Details", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclFirstAidIssueDate']")
	WebElement Issued_Date_In_First_Aid_Details;

	public void Enter_Issued_Date_In_First_Aid_Details(String Value) {
		stepstatus = basepage.setText(Issued_Date_In_First_Aid_Details, Value);
		reportEvent(stepstatus, "Able to Enter Issued_Date_In_First_Aid_Details",
				"Unable to Enter Issued_Date_In_First_Aid_Details", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='newclFirstAidEndDate']")
	WebElement End_Date_In_First_Aid_Details;

	public void Enter_End_Date_In_First_Aid_Details(String Value) {
		stepstatus = basepage.setText(End_Date_In_First_Aid_Details, Value);
		reportEvent(stepstatus, "Able to Enter End_Date_In_First_Aid_Details",
				"Unable to Enter End_Date_In_First_Aid_Details", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclMedicalFitnessCertificateNo']")
	WebElement Fitness_CertificateNo_In_MedicalFitness;

	public void Enter_Fitness_CertificateNo_In_MedicalFitness(String Value) {
		stepstatus = basepage.setText(Fitness_CertificateNo_In_MedicalFitness, Value);
		reportEvent(stepstatus, "Able to Enter Fitness_CertificateNo_In_MedicalFitness",
				"Unable to Enter Fitness_CertificateNo_In_MedicalFitness", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclMedicalFitnessDoctorName']")
	WebElement Doctor_Name_In_MedicalFitness;

	public void Enter_Doctor_Name_In_MedicalFitness(String Value) {
		stepstatus = basepage.setText(Doctor_Name_In_MedicalFitness, Value);
		reportEvent(stepstatus, "Able to Enter Doctor_Name_In_MedicalFitness",
				"Unable to Enter Doctor_Name_In_MedicalFitness", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclMedicalFitnessRegNoofDoctor']")
	WebElement RegistrationNo_of_Doctor_In_MedicalFitness;

	public void Enter_RegistrationNo_of_Doctor_In_MedicalFitness(String Value) {
		stepstatus = basepage.setText(RegistrationNo_of_Doctor_In_MedicalFitness, Value);
		reportEvent(stepstatus, "Able to Enter RegistrationNo_of_Doctor_In_MedicalFitness",
				"Unable to Enter RegistrationNo_of_Doctor_In_MedicalFitness", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='newclMedicalFitnessClinicNameandPlace']")
	WebElement ClinicName_and_Place_In_MedicalFitness;

	public void Enter_ClinicName_and_Place_In_MedicalFitness(String Value) {
		stepstatus = basepage.setText(ClinicName_and_Place_In_MedicalFitness, Value);
		reportEvent(stepstatus, "Able to Enter ClinicName_and_Place_In_MedicalFitness",
				"Unable to Enter ClinicName_and_Place_In_MedicalFitness", driver, true);
	}

	
	@FindBy(how = How.XPATH, using = "//input[@name='newclMedicalFitnessIssueDate']")
	WebElement IssueeDate_In_MedicalFitness;

	public void Enter_IssueeDate_In_MedicalFitness(String Value) {
		stepstatus = basepage.setText(IssueeDate_In_MedicalFitness, Value);
		reportEvent(stepstatus, "Able to Enter IssueeDate_In_MedicalFitness",
				"Unable to Enter IssueeDate_In_MedicalFitness", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[1][@name='newclFirstAidisPermorTemp']")
	WebElement Question;

	public void Clickon_Question() {
		stepstatus = basepage.clickElement(Question);
		reportEvent(stepstatus, "Able to Click Question", "Unable to Click Question", driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='captcha']")
	WebElement Captcha;
	
	public void Enter_Captcha(String value ) {
	   
		stepstatus = basepage.setText(Captcha, value);
		reportEvent(stepstatus, "Able to Enter captcha", "Unable to Enter captcha", driver, true);
		
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[1][@name='method:execute']")
	WebElement Submitbutton;

	public void Clickon_Submitbutton() {
		
		stepstatus = basepage.clickElement(Submitbutton);
		reportEvent(stepstatus, "Able to submit new CL", "Unable to submit new CL", driver, true);

		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}
		
		wait(2);
		if (basepage.alertExist(driver)) {
			basepage.acceptAlert(driver);
		} else {

			basepage.dismissAlert(driver);
		}
	}

	@FindBy(how = How.XPATH, using = "//button[@name='dlservices.exit']")
	WebElement Exit;

	public void Clickon_Exitbutton() {
		stepstatus = basepage.clickElement(Exit);
		reportEvent(stepstatus, "Able to Click Exit", "Unable to Click Exit", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Login']")
	WebElement Login;

	public void Clickon_Login_Button() {
		stepstatus = basepage.clickElement(Login);
		reportEvent(stepstatus, "Able to click on Login button", "Unable to click on Login button", driver, true);
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
		reportEvent(stepstatus, "Able to click on Radiobutton1", "Unable to click on Radiobutton1", driver, true);
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
	WebElement Application_Number;

	public void Set_Application_Number(String value) {
		stepstatus = basepage.setText(Application_Number, value);
		reportEvent(stepstatus, "Able to Enter Application_Number", "Unable to Enter Application_Number", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='_scrutiny_proceed']")
	WebElement Proceed;

	public void Clickon_Proceed_button() {
		stepstatus = basepage.clickElement(Proceed);
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

	@FindBy(how = How.XPATH, using = "//i[text()='Affidavit by Magistrate/Notary Public']")
	WebElement Firstprooflink;
	@FindBy(how = How.XPATH, using = "//i[text()='Passport']")
	WebElement Secondprooflink;
	@FindBy(how = How.XPATH, using = "//input[@id='documentsapproval_0']")
	WebElement windowSubmit;

	public void Clickon_prooflinks() {
		wait(2);
		basepage.SwitchtoWindowByTitle("Documents Approved by Approval Authority", driver);
		wait(1);
		basepage.clickElement(Firstprooflink);
		basepage.SwitchtoWindowByURL(
				"http://164.100.129.145/dms-sarthi/search-dms?applno=262619_2215345_551_5-passpic&status=NP&j_key=vVl%2FAz1yGsjOAG18WDeScg%3D%3D&j_securityKey=6D6C069D681B40DBF95CAD7B3ED71BE1A46F0A7036BC711860B00BAAE50FE8A4%21TZFIMZbTiUtqXMfARJ1DGgyNicWFwYkwTA0ip%2FQ8Wns%3D",
				driver);
		basepage.closeWindowByURL(
				"http://164.100.129.145/dms-sarthi/search-dms?applno=262619_2215345_551_5-passpic&status=NP&j_key=vVl%2FAz1yGsjOAG18WDeScg%3D%3D&j_securityKey=6D6C069D681B40DBF95CAD7B3ED71BE1A46F0A7036BC711860B00BAAE50FE8A4%21TZFIMZbTiUtqXMfARJ1DGgyNicWFwYkwTA0ip%2FQ8Wns%3D",
				driver);
		basepage.SwitchtoWindowByTitle("Documents Approved by Approval Authority", driver);
		basepage.clickElement(Secondprooflink);
		basepage.SwitchtoWindowByURL(
				"http://164.100.129.145/dms-sarthi/search-dms?applno=262619_2215344_551_1-passpic&status=NP&j_key=vVl%2FAz1yGsjOAG18WDeScg%3D%3D&j_securityKey=6D6C069D681B40DBF95CAD7B3ED71BE1A46F0A7036BC711860B00BAAE50FE8A4%21TZFIMZbTiUtqXMfARJ1DGgyNicWFwYkwTA0ip%2FQ8Wns%3D",
				driver);
		basepage.closeWindowByURL(
				"http://164.100.129.145/dms-sarthi/search-dms?applno=262619_2215344_551_1-passpic&status=NP&j_key=vVl%2FAz1yGsjOAG18WDeScg%3D%3D&j_securityKey=6D6C069D681B40DBF95CAD7B3ED71BE1A46F0A7036BC711860B00BAAE50FE8A4%21TZFIMZbTiUtqXMfARJ1DGgyNicWFwYkwTA0ip%2FQ8Wns%3D",
				driver);
		basepage.SwitchtoWindowByTitle("Documents Approved by Approval Authority", driver);
		basepage.clickElement(windowSubmit);
		basepage.closeWindowByTitle("Documents Approved by Approval Authority", driver);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='approveButton']")
	WebElement Scrutinybutton;

	public void Clickon_Scrutinybutton() {
		stepstatus = basepage.clickElement(Scrutinybutton);
		reportEvent(stepstatus, "Able to click on Scrutinybutton", "Unable to click on Scrutinybutton", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='BIOMETRICS']")
	WebElement Biometrics;

	public void Clickon_BiometricsLink() {
		stepstatus = basepage.clickElement(Biometrics);
		reportEvent(stepstatus, "Able to click on Biometrics Link", "Unable to click on Biometrics Link", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='appnumber']")
	WebElement Application_Num;

	public void Set_Application_Num(String Value) {
		stepstatus = basepage.setText(Application_Num, Value);
		reportEvent(stepstatus, "Able to Enter Application_Number", "Unable to Enter Application_Number", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//button[@id='thumbdetform__populateData']")
	WebElement Getdetails;

	public void Clickon_Getdetails() {
		stepstatus = basepage.clickElement(Getdetails);
		reportEvent(stepstatus, "Able to Click Getdetails button ", "Unable to Click Getdetails button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "html/body/div/div/div[3]/div/div[1]/div[2]/div/div/form/div[4]/div/div/div[2]/div[1]/div/fieldset/div/div[1]/div/canvas")
	WebElement CanvasSignature;

	public void Set_CanvasSignature(String ObjectXpath) {
		wait(2);
		stepstatus = basepage.CaptureSignature(driver, CanvasSignature, ObjectXpath);
		reportEvent(stepstatus, "Able to do CanvasSignature ", "Unable to do CanvasSignature", driver, true);
		wait(2);
		basepage.scrooldown(driver);
	}

	@FindBy(how = How.XPATH, using = "//button[@id='capBtn']")
	WebElement CaptureSignature;

	public void Clickon_Capturesignaturebutton() {
		stepstatus = basepage.clickElement(CaptureSignature);
		reportEvent(stepstatus, "Able to Click Getdetails button ", "Unable to Click Getdetails button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='dojoTab']/div/span[text()='Photo Capture']")
	WebElement PhotoCapture;

	public void Set_PhotoCapture() {
		stepstatus = basepage.clickElement(PhotoCapture);
		reportEvent(stepstatus, "Able to do PhotoCapture ", "Unable to do PhotoCapture", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//li[@class='crop']")
	WebElement CropSelected;

	public void Clickon_CropSelected() {
		wait(1);
		stepstatus = basepage.clickElement(CropSelected);
		reportEvent(stepstatus, "Able to click on CropSelected ", "Unable to click on CropSelected", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//li[@class='trigger']")
	WebElement Phototrigger;

	public void Clickon_Phototriggerbutton() {
		stepstatus = basepage.clickElement(Phototrigger);
		reportEvent(stepstatus, "Able to click on Phototrigger button ", "Unable to click on Phototrigger button",
				driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='photoCaptre']")
	WebElement Snapok;

	public void Clickon_Snapokbutton() {
		stepstatus = basepage.clickElement(Snapok);
		reportEvent(stepstatus, "Able to click on Snapok button ", "Unable to click on Phototrigger button", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='col-md-12 top-space text-center']/input[1]")
	WebElement Save;

	public void Clickon_Savebutton() {
		stepstatus = basepage.clickElement(Save);
		reportEvent(stepstatus, "Able to click on Save button ", "Unable to click on Save button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li[9]/a")
	WebElement CLLink;

	public void Clickon_CLLink() {
		stepstatus = basepage.clickElement(CLLink);
		reportEvent(stepstatus, "Able to click on CLLink ", "Unable to click on CLLink", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='CL TEST']")
	WebElement CLTest;

	public void Clickon_CLTest() {
		stepstatus = basepage.clickElement(CLTest);
		reportEvent(stepstatus, "Able to click on CLTest ", "Unable to click on CLTest", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='app_no']")
	WebElement CLApplicationno;

	public void Enter_CLApplicationno(String value) {
		stepstatus = basepage.setText(CLApplicationno, value);
		reportEvent(stepstatus, "Able to Enter CLApplicationno ", "Unable to Enter CLApplicationno", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='fetch']")
	WebElement fetchdetails;

	public void Clickon_fetchdetails() {
		stepstatus = basepage.clickElement(fetchdetails);
		reportEvent(stepstatus, "Able to click on fetchdetails ", "Unable to click on fetchdetails", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='app_result']")
	WebElement TestResult;

	public void Select_TestResult(String value) {
		stepstatus = basepage.setOptionInSelectBox(TestResult, value);
		reportEvent(stepstatus, "Able to select TestResult ", "Unable to select TestResult", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='method:insertRecords']")
	WebElement Subbutton;

	public void Clickon_Subbutton() {
		stepstatus = basepage.clickElement(Subbutton);
		reportEvent(stepstatus, "Able to click on Subbutton ", "Unable to click on Subbutton", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='APPROVE NEW CL']")
	WebElement ApproveofNewCL;

	public void Clickon_ApproveofNewCL() {
		stepstatus = basepage.clickElement(ApproveofNewCL);
		reportEvent(stepstatus, "Able to click on ApproveofNewCL ", "Unable to click on ApproveofNewCL", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='applicationNumber']")
	WebElement Appno;

	public void Enter_CLAppno(String value) {
		stepstatus = basepage.setText(Appno, value);
		reportEvent(stepstatus, "Able to Enter Appno ", "Unable to Enter Appno", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='proceed']")
	WebElement proceed;

	public void Clickon_proceedCLAppno() {
		stepstatus = basepage.clickElement(proceed);
		reportEvent(stepstatus, "Able to click on Proceed button ", "Unable to click on Proceed button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='Approve']")
	WebElement ApproveNewCL;

	public void Clickon_ApproveNewCL() {
		stepstatus = basepage.clickElement(ApproveNewCL);
		reportEvent(stepstatus, "Able to click on ApproveNewCL button ", "Unable to click on ApproveNewCL button",
				driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='pendingList']")
	WebElement Selectoptionsforpendingforwantof;

	public void Select_Selectoptionsforpendingforwantof(String option) {
		stepstatus = basepage.setOptionInSelectBox(Selectoptionsforpendingforwantof, option);
		reportEvent(stepstatus, "Able to Selectoptionsforpendingforwantof ",
				"Unable to Selectoptionsforpendingforwantof", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='addToRightLabel']")
	WebElement Rightarrow;

	public void Clickon_Rightarrow() {
		stepstatus = basepage.clickElement(Rightarrow);
		reportEvent(stepstatus, "Able to click on Rightarrow button ", "Unable to click on Rightarrow button", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='pending']")
	WebElement Pendingforwantof;

	public void Clickon_Pendingforwantof() {
		stepstatus = basepage.clickElement(Pendingforwantof);
		reportEvent(stepstatus, "Able to click on Pendingforwantof button ",
				"Unable to click on Pendingforwantof button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='Reject']")
	WebElement Reject;

	public void Clickon_Reject() {
		stepstatus = basepage.clickElement(Reject);
		reportEvent(stepstatus, "Able to click on Reject button ", "Unable to click on Reject button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='Exit']")
	WebElement exit;

	public void Clickon_Exit() {
		stepstatus = basepage.clickElement(exit);
		reportEvent(stepstatus, "Able to click on exit button ", "Unable to click on exit button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='Home']")
	WebElement home;

	public void Clickon_home() {
		stepstatus = basepage.clickElement(home);
		reportEvent(stepstatus, "Able to click on Home button ", "Unable to click on Home button", driver, true);
	}

}

