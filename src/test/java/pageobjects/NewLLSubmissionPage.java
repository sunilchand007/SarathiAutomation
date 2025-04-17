package pageobjects;

import java.time.Duration;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkLibrary.BasePage;

public class NewLLSubmissionPage extends BasePage{
	boolean stepstatus;
	WebDriver driver;
	public NewLLSubmissionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='licenceFromRTO']")
	WebElement RTO_Office;

	public void Set_RTO_Office(String option) {
		wait(15);
		try {
			if(isEnabled(RTO_Office)==true) {
			
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.xpath("//select[@name='licenceFromRTO']"),By.tagName("option")));
				stepstatus = setValueInSelectBox(RTO_Office, option);
				reportEvent(stepstatus, "Able to Selected RTO_Office", "Unable to Selected RTO_Office", driver, true);
			}
			else {
				
				System.out.println("RTO office is disabled ");
			}
		}
          catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='fname']")
	WebElement FirstName;

	public void SetFirstName(String Value) {

		if (FirstName.getAttribute("value").isEmpty()) {
			stepstatus = setText(FirstName, Value);
			reportEvent(stepstatus, "Able to Enter Firstname", "Unable to Enter Firstname", driver, true);
		} else {
			System.out.println("First Name Value is not Empty");
		}

	}

	@FindBy(how = How.XPATH, using = "//input[@name='mname']")
	WebElement Middlename;

	public void SetMiddlename(String Value) {
		stepstatus = setText(Middlename, Value);
		reportEvent(stepstatus, "Able to Enter Middlename", "Unable to Enter Middlename", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='lname']")
	WebElement LastName;

	public void SetLastName(String Value) {
		if (LastName.getAttribute("value").isEmpty()) {
			stepstatus = setText(LastName, Value);
			reportEvent(stepstatus, "Able to Enter Lastname", "Unable to Enter Lastname", driver, true);
		} else {
			System.out.println("LastName field is not Empty");
		}

	}

	@FindBy(how = How.XPATH, using = "//select[@id='relationType']")
	WebElement RelationType;

	public void SetRelationType(String option) {
		if (isEnabled(RelationType) == true) {
			stepstatus = setOptionInSelectBox(RelationType, option);
			reportEvent(stepstatus, "Able to Select RelationType", "Unable to Select RelationType", driver, true);
		} else {
			System.out.println(" RelationType field is not Empty");
		}
	}

	@FindBy(how = How.XPATH, using = "//input[@id='swdfName']")
	WebElement RelationFirstName;

	public void SetRelationFirstName(String Value) {
		if (RelationFirstName.getAttribute("value").isEmpty()) {
			stepstatus = setText(RelationFirstName, Value);
			reportEvent(stepstatus, "Able to Enter RelationFirstName", "Unable to Enter RelationFirstName", driver,
					true);
		} else {
			System.out.println(" RelationFirstName field is not Empty");
		}

	}

	@FindBy(how = How.XPATH, using = "//input[@id='swdmName']")
	WebElement RelationMiddleName;

	public void SetRelationMiddleName(String Value) {
		stepstatus = setText(RelationMiddleName, Value);
		reportEvent(stepstatus, "Able to Enter RelationMiddleName", "Unable to Enter RelationMiddleName", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='swdlName']")
	WebElement RelationLastName;

	public void SetRelationLastName(String Value) {
		if (RelationLastName.getAttribute("value").isEmpty()) {
			stepstatus = setText(RelationLastName, Value);
			reportEvent(stepstatus, "Able to Enter RelationLastName", "Unable to Enter RelationLastName", driver, true);
		} else {
			System.out.println(" RelationLastName field is not Empty");
		}

	}

	@FindBy(how = How.XPATH, using = "//input[@id='gender1']")
	WebElement Gender;

	public void SetGender() {
		if (isEnabled(Gender) == true) {
			stepstatus = clickElement(Gender);
			reportEvent(stepstatus, "Able to Select Gender", "Unable to Select Gender", driver, true);
		} else {
			System.out.println(" Gender field is not Empty");
		}

	}

	
	
	@FindBy(how = How.XPATH, using = "//input[@id='placeOfBirth']")
	WebElement PlaceofBirth;

	public void SetPlaceofBirth(String value) {
		stepstatus = setText(PlaceofBirth, value);
		reportEvent(stepstatus, "Able to Enter PlaceofBirth", "Unable to Enter PlaceofBirth", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='age']")
	WebElement Age;

	public void SetAge(String age) {
		
		if (Age.getAttribute("value").isEmpty()) {
			//stepstatus = setText(Age, age);
			stepstatus = SetTextAndTAB(Age, age);
			wait(30);
			//reportEvent(stepstatus, "Able to Enter Age", "Unable to Enter Age", driver, true);
			boolean alertstatus = alertExist(driver);
			System.out.println("alert status " + alertstatus);
			if(alertExist(driver)) {
				System.out.println("Inside alert condition");
				String alertText_age= alertGetText(driver);
				System.out.println("alert Text after Entering age:" +alertText_age);
				wait(30);
				System.exit(0);
			}
			
		} else {
			System.out.println("Age field is not Empty");
		}
	
	}
		

	
	@FindBy(how = How.XPATH, using = "//select[@name='eduQual']")
	WebElement Qualification;

	public void SetQualification(String option) {
		stepstatus = setOptionInSelectBox(Qualification, option);
		reportEvent(stepstatus, "Able to Select Qualification", "Unable to Select Qualification", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='bloodGroup']")
	WebElement Bloodgroup;

	public void SetBloodgroup(String option) {
		stepstatus = setOptionInSelectBox(Bloodgroup, option);
		reportEvent(stepstatus, "Able to Select Bloodgroup", "Unable to Select Bloodgroup", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='phoneNumber']")
	WebElement Phonenumber_Landno;

	public void SetPhonenumber_Landno(String Phonenumber) {
		stepstatus = setText(Phonenumber_Landno, Phonenumber);
		reportEvent(stepstatus, "Able to Enter Phonenumber_Landno", "Unable to Enter Phonenumber_Landno", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='email']")
	WebElement Emailid;

	public void SetEmailid(String email) {
		stepstatus = setText(Emailid, email);
		reportEvent(stepstatus, "Able to Enter Emailid", "Unable to Enter Emailid", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='altMobileNumber']")
	WebElement EmrgPhoneno;

	public void SetEmrgPhoneno(String op) {
		stepstatus = setText(EmrgPhoneno, op);
		reportEvent(stepstatus, "Able to Enter EmrgPhoneno", "Unable to Enter EmrgPhoneno", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='idMarks1']")
	WebElement IdentificationMarks1;

	public void SetIdentificationMarks1(String op) {
		stepstatus = setText(IdentificationMarks1, op);
		reportEvent(stepstatus, "Able to Enter IdentificationMarks1", "Unable to Enter IdentificationMarks1", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='idMarks2']")
	WebElement IdentificationMarks2;

	public void SetIdentificationMarks2(String op) {
		stepstatus = setText(IdentificationMarks2, op);
		reportEvent(stepstatus, "Able to Enter IdentificationMarks2", "Unable to Enter IdentificationMarks2", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='presState']")
	WebElement CheckState;

	public void SetState() {
		WebElement stoption = driver.findElement(By.xpath("//select[@name='presState']"));
		Select st = new Select(stoption);
		List<WebElement> options = st.getOptions();
		WebElement ele = st.getFirstSelectedOption();
		System.out.println(ele.getText());
		if (ele.getText().contains("Select")) {
			for (int i = 0; i <= options.size() - 1; i++) {
				try {
					stoption = driver.findElement(By.xpath("//select[@name='presState']"));
					st = new Select(stoption);
					options = st.getOptions();
					if (!options.get(1).getText().contains("Select")) {
						System.out.println(options.get(1).getText());
						st.selectByVisibleText(options.get(1).getText());
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

	@FindBy(how = How.XPATH, using = "//select[@name='presDistrict']")
	WebElement District;

	public void SetDistrict(String option) {
		stepstatus = setOptionInSelectBox(District, option);
		reportEvent(stepstatus, "Able to Select District", "Unable to Select District", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='presSubDistrict']")
	WebElement Tahsil;

	public void SetTahsil(String option) {
		stepstatus = setOptionInSelectBox(Tahsil, option);
		reportEvent(stepstatus, "Able to Select Tahsil", "Unable to Select Tahsil", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='presCity']")
	WebElement Village;

	public void SetVillage(String option) {
		stepstatus = setOptionInSelectBox(Village, option);
		reportEvent(stepstatus, "Able to Select Village", "Unable to Select Village", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='presHouseNo']")
	WebElement Houseno;

	public void SetHouseno(String value) {
		stepstatus = setText(Houseno, value);
		reportEvent(stepstatus, "Able to Enter Houseno", "Unable to Enter Houseno", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='presLocation']")
	WebElement Location;

	public void SetLocation(String value) {
		if (alertExist(driver)) {
			acceptAlert(driver);
		} else {
			dismissAlert(driver);
		}
		stepstatus = setText(Location, value);
		reportEvent(stepstatus, "Able to Enter Location", "Unable to Enter Location", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='stayPeriodYears']")
	WebElement Stayyears;

	public void SetStayyears(String value) {
		stepstatus = setText(Stayyears, value);
		reportEvent(stepstatus, "Able to Select Stayyears", "Unable to Select Stayyears", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='stayPeriodMonths']")
	WebElement StayMonths;

	public void SetStayMonths(String value) {
		stepstatus = setText(StayMonths, value);
		reportEvent(stepstatus, "Able to Select StayMonths", "Unable to Select StayMonths", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='presPinCode']")
	WebElement Pincode;

	public void SetPincode(String Pin) {
		if (isEnabled(Pincode)) {

			stepstatus = SetTextAndTAB(Pincode, Pin);
			wait(1);
			if (alertExist(driver)) {
				acceptAlert(driver);
				UserManualPinCodeInput();
			} else {
				System.out.println("There is no Alert present");
				reportEvent(stepstatus, "Able to Select Pincode", "Unable to Select Pincode", driver, true);
			}

		} else {
			System.out.println("Pincode Already Taken");
		}
	}

	public void UserManualPinCodeInput() {

		JFrame Dialog = new JFrame();
		JOptionPane.showMessageDialog(Dialog, "Key for Pincode: 425412");
		String input = JOptionPane.showInputDialog(Dialog, "Enter Valid Pincode for Selected District");
		stepstatus = SetTextAndTAB(Pincode, input);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='presSameAsPerm']")
	WebElement Copytopermenentaddress;

	public void SetCopytopermenentaddress() {
		if (isSelected(Copytopermenentaddress) == false) {
			stepstatus = clickElement(Copytopermenentaddress);
			reportEvent(stepstatus, "Able to Click Copytopermenentaddress", "Unable to Click Copytopermenentaddress",
					driver, true);
		} else {
			System.out.println("Copytopermenentaddress field is not Empty");
		}

	}

	@FindBy(how = How.XPATH, using = "//input[@value='<=']")
	WebElement Leftarrow;

	public void ClickLeftarrow() {
		stepstatus = clickElement(Leftarrow);
		reportEvent(stepstatus, "Able to Click Leftarrow", "Unable to Click Leftarrow", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='covsList']")
	WebElement SelectCOV;

	public void SetCOV(String option) {
		stepstatus = setOptionInSelectBox(SelectCOV, option);
		reportEvent(stepstatus, "Able to SelectCOV", "Unable to SelectCOV", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='covsList']")
	WebElement SelectCOV1;

	public void SetCOV1(String option) {
		stepstatus = setOptionInSelectBox(SelectCOV1, option);
		reportEvent(stepstatus, "Able to SelectCOV", "Unable to SelectCOV", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='covsList']")
	WebElement SelectCOV2;

	public void SetCOV2(String option) {
		stepstatus = setOptionInSelectBox(SelectCOV2, option);
		reportEvent(stepstatus, "Able to SelectCOV", "Unable to SelectCOV", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@id='fullCovsList']")
	WebElement list;

	public void ListofCOVS() {
		stepstatus = setOptionInSelectBox(list, getdata("COV1"));
		wait(1);
		stepstatus = setOptionInSelectBox(list, getdata("COV2"));
	}

	@FindBy(how = How.XPATH, using = "//input[@id='addToRightLabel']")
	WebElement RightarrowinexpiredLLissuueagain;

	public void Rightarrow() {
		stepstatus = clickElement(RightarrowinexpiredLLissuueagain);
		reportEvent(stepstatus, "Able to Click Rightarrow", "Unable to Click Rightarrow", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='newLLApplForm_0']")
	WebElement Rightarrow;

	public void SetRightarrow() {
		stepstatus = clickElement(Rightarrow);
		reportEvent(stepstatus, "Able to Click Rightarrow", "Unable to Click Rightarrow", driver, true);
	}

	@FindBy(how = How.XPATH, using = "(//input[@name='willingToDonatee'])[2]")
	WebElement WillingToDonate;

	public void ClickonWillingToDonate() {
		stepstatus = clickElement(WillingToDonate);
		reportEvent(stepstatus, "Able to Click WillingToDonate", "Unable to Click WillingToDonate", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id = 'entcaptxt']")
	WebElement Entercaptcha_in_newllpage;

	public void Entercaptcha_in_newllpage(String value) {
		stepstatus = setText(Entercaptcha_in_newllpage, value);
		reportEvent(stepstatus, "Able to Entercaptcha_in_newllpage", "unable to Entercaptcha_in_newllpage", driver, true);
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement Submitthree;

	public void SetSubmitthree() {
		System.out.println("Inside submitthree");
		stepstatus = clickElement(Submitthree);

		if (alertExist(driver)) {
			acceptAlert(driver);
		} else {
			dismissAlert(driver);
		}
		
		
		if (alertExist(driver)) {
			acceptAlert(driver);
		} else {
			dismissAlert(driver);
		}
		
		
		if (alertExist(driver)) {
			acceptAlert(driver);
		} else {
			dismissAlert(driver);
		}
		reportEvent(stepstatus, "Able to Click Submit", "Unable to Click Submit", driver, true);

	}

	
	public void Alert() {

		if (alertExist(driver)) {
			acceptAlert(driver);
			alertGetText(driver);
		} else {
			dismissAlert(driver);
			alertGetText(driver);
		}
	}

	@FindBy(how = How.XPATH, using = "//button[@name='dlservices.exit']")
	WebElement Exit;

	public void Clickon_Exitbutton() {
		stepstatus = clickElement(Exit);
		reportEvent(stepstatus, "Able to Click Exit", "Unable to Click Exit", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//input[@id='submitform']")
	WebElement Form_one;

	public void ClickonForm1_buttton() {
		stepstatus = clickElement(Form_one);
	}
	public void TypeDist() {

		WebElement Dist = driver.findElement(By.xpath("//select[@name='presDistrict']"));
		Select District = new Select(Dist);
		List<WebElement> options = District.getOptions();
		for (int i = 0; i <= options.size() - 1; i++) {
			try {
				Dist = driver.findElement(By.xpath("//select[@name='presDistrict']"));
				District = new Select(Dist);
				options = District.getOptions();
				if (!options.get(1).getText().contains("Select")) {
					// System.out.println(options.get(1).getText());
					District.selectByVisibleText(options.get(1).getText());
					// District.selectByValue("530");
					Thread.sleep(2000);
					WebElement SubDist = driver.findElement(By.xpath("//select[@id='presSubDistrict']"));
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
	@FindBy(how = How.XPATH, using = "//input[@id='mobileNumber']")
	WebElement Mobilenumber;
	
	public void SetMobilenumber(String value) {
		if(isDisplayed(Mobilenumber)== false) {
		stepstatus = setText(Mobilenumber, value);
		reportEvent(stepstatus, "Able to Enter Mobilenumber in textbox", "Unable to Enter Mobilenumber in textbox", driver, true);
	}
		else {
			
			System.out.println("Mobile number is displayed automatically");
		}
		
	}
}
