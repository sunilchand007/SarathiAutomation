package pageobjects;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import frameworkLibrary.BasePage;
import utility.Utilitymethods;

public class LLBacklogPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public LLBacklogPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelementss
	
	@FindBy(how = How.XPATH, using = "//select[@id='prDistrict']")
	WebElement District;
	@FindBy(how = How.XPATH, using = "//select[@id='prSubDistrict']")
	WebElement Tahsil;
	@FindBy(how = How.XPATH, using = "//input[@id='prPinCode']")
	WebElement Pincode;
	@FindBy(how = How.XPATH, using = "//input[@name='haveLicDetails']")
	WebElement HaveLicenceDetails;
	@FindBy(how = How.XPATH, using = "//label[text()='LL']/preceding-sibling::input")
	WebElement LLRadio;
	@FindBy(how = How.XPATH, using = "//label[text()='LL']")
	WebElement LLText;
	@FindBy(how = How.XPATH, using = "//label[text()='DL']/preceding-sibling::input[1]")
	WebElement DLRadio;
	@FindBy(how = How.XPATH, using = "//label[text()='DL']")
	WebElement DLText;
	@FindBy(how = How.XPATH, using = "//select[@name='have_state']")
	WebElement HaveState;
	@FindBy(how = How.XPATH, using = "//select[@name='have_rto']")
	WebElement HaveRTO;
	@FindBy(how = How.XPATH, using = "//input[@name='have_ll_dl_no']")
	WebElement Textboxfor_LLDL;
	@FindBy(how = How.XPATH, using = "//button[@value='LOAD LICENCE DETAILS']")
	WebElement LoadDetails;
	@FindBy(how = How.XPATH, using = "//input[@id='haveLicDetails']")
	WebElement LLorDLAvailable;
	@FindBy(how = How.XPATH, using = "//input[@id='have_lic_type2']")
	WebElement ClickonDL;
	
	
	public void ClickonDL() {
		stepstatus = basepage.clickElement(ClickonDL);
		reportEvent(stepstatus, "Able to click on ClickonDL button", "Unable to click on ClickonDL button", driver, true);
	}
	// related methods to perform operation on webelements
	public void Clickon_LLorDL_Available() {
		stepstatus = basepage.clickElement(LLorDLAvailable);
		reportEvent(stepstatus, "Able to click on LLorDLAvailable button", "Unable to click on LLorDLAvailable button", driver, true);
	}
	public void m1(String sv) {

		switch (sv) {

		case "S4Preprod":
			System.out.println("one");
			break;
		case "S4testing":
			System.out.println("two");
			break;
		case "SarathiCOV":
			System.out.println("three");
			break;
		default:
			System.out.println("no match");

		}
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
	WebElement Next;
	public void ClickonNext() {
		stepstatus = basepage.clickElement(Next);
		reportEvent(stepstatus, "Able to click on Next BUtton", "Unable to click on Next Button", driver, true);
	}

	
	@FindBy(how = How.XPATH, using = "//input[@id='logmode']")
	WebElement otptext;
	public void setotptext(String Strpassword) {
		stepstatus = basepage.setText(otptext, Strpassword);
		reportEvent(stepstatus, "Able to enter otptext", "Unable to enter otptext", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	WebElement Singin;
	public void ClickonLogin() {
		stepstatus = basepage.clickElement(Singin);
		reportEvent(stepstatus, "Able to click on Sign-In BUtton", "Unable to click on Sign-In Button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//table/tbody/tr[2]/td/input")
	WebElement Radiobutton;
	public void SelectRTOtype() {
		stepstatus = basepage.clickElement(Radiobutton);
		reportEvent(stepstatus, "Able to click on Radiobutton", "Unable to click on Radiobutton", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='login']")
	WebElement login;

	public void Clickonlogin() {
		stepstatus = basepage.clickElement(login);
		reportEvent(stepstatus, "Able to click on login-In BUtton", "Unable to click on login Button", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li[2]/a")
	WebElement LL;
	public void Clickon_LL_Link() {
		stepstatus = basepage.clickElement(LL);
		reportEvent(stepstatus, "Able to click on LL Link", "Unable to click on LL Link", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//a[text()='LL BACKLOG']")
	WebElement LLBacklog;
	public void Clickon_LLBacklog() {
		stepstatus = basepage.clickElement(LLBacklog);
		reportEvent(stepstatus, "Able to click on LLBacklog", "Unable to click on LLBacklog", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='llIssueDate']")
	WebElement Issuedate;
	public void Set_Issuedate(String value) {
		try {
			stepstatus = basepage.SetTextAndTAB(Issuedate, value);
			if (alertExist(driver)) {
				String text = alertGetText(driver);
				if (text.equalsIgnoreCase(
						"Your LL Application Issue Date is expired  ! if you want to continue Press OK !")) {
					acceptAlert(driver);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception Occured");

		}

		// reportEvent(stepstatus, "Able to Enter Issue Date", "Unable to Enter Issue
		// Date", driver, true);

	}

	@FindBy(how = How.XPATH, using = "//input[@id='llNo']")
	WebElement OriginalLLno;
	public void Set_OriginalLLno(String value) {
		
		stepstatus = basepage.setText(OriginalLLno, value);
		System.out.println("boolean status of OriginalLLno : " +stepstatus);
		reportEvent(stepstatus, "Able to Enter OriginalLLno", "Unable to Enter OriginalLLno", driver, true);
	}
	

	@FindBy(how = How.XPATH, using = "//a[text()='LL BACKLOG APPROV']")
	WebElement LLBacklogApprove;
	@FindBy(how = How.XPATH, using = "//input[@id='applicationNumber']")
	WebElement LLBacklogApplicationno;
	@FindBy(how = How.XPATH, using = "//input[@id='proceed']")
	WebElement LLBacklogApplicationnoProceed;
	@FindBy(how = How.XPATH, using = "//input[@id='approve']")
	WebElement LLBacklogApprovebutton;
	@FindBy(how = How.XPATH, using = "//select[@id='have_state']")
	WebElement Selectstate;
	@FindBy(how = How.XPATH, using = "//select[@id='have_rto']")
	WebElement SelectRTO;
	@FindBy(how = How.XPATH, using = "//input[@id='have_ll_dl_no']")
	WebElement EnterDLNumber;
	@FindBy(how = How.XPATH, using = "//button[@id='LLbacklogForm_0']")
	WebElement ClickonLoadLicenceDetails;
	
	
	public void ClickonLoadLicenceDetails() {
		stepstatus = basepage.clickElement(ClickonLoadLicenceDetails);
		reportEvent(stepstatus, "Able to Click ClickonLoadLicenceDetails LLBacklogApprove", "Unable to Click ClickonLoadLicenceDetails LLBacklogApprove", driver, true);
	}
	public void Enter_License_no(String DLNumber) {
		stepstatus = basepage.setText(EnterDLNumber, DLNumber);
		reportEvent(stepstatus, "Able to Eneter DLNumber LLBacklogApplicationno", "Unable to Enter DLNumber LLBacklogApplicationno",
				driver, true);
	}
	public void SelectRTO(String Value) {
		stepstatus = basepage.setOptionInSelectBox(SelectRTO, Value);
		reportEvent(stepstatus, "Able to Select RTO LLBacklogApprove", "Unable to Select RTO LLBacklogApprove", driver, true);
	}
	public void Selectstate(String Value) {
		stepstatus = basepage.setValueInSelectBox(Selectstate, Value);
		reportEvent(stepstatus, "Able to Select state LLBacklogApprove", "Unable to Select state LLBacklogApprove", driver, true);
	}
	
	public void Clickon_LLBacklogApprove() {
		stepstatus = basepage.clickElement(LLBacklogApprove);
		reportEvent(stepstatus, "Able to Click LLBacklogApprove", "Unable to Click LLBacklogApprove", driver, true);
	}

	public void Enter_LLBacklogApplicationno(String Applicationno) {
		stepstatus = basepage.setText(LLBacklogApplicationno, Applicationno);
		reportEvent(stepstatus, "Able to Click LLBacklogApplicationno", "Unable to Click LLBacklogApplicationno",
				driver, true);
	}

	public void Clickon_LLBacklogApplicationnoProceed() {
		stepstatus = basepage.clickElement(LLBacklogApplicationnoProceed);
		reportEvent(stepstatus, "Able to Click LLBacklogApplicationnoProceed",
				"Unable to Click LLBacklogApplicationnoProceed", driver, true);
	}

	
	@FindBy(how = How.XPATH, using = "//button[@id='generateotp']")
	WebElement OTP;

	public void Verify_GenerateOTPforApproval() throws IOException {
		if (isDisplayed(OTP) && isEnabled(OTP) == true) {
			driver.findElement(By.xpath("//button[@id='generateotp']")).click();
			wait(20);
			if (alertExist(driver)) 
			{
				acceptAlert(driver);
				System.out.println();
			}
				else{ basepage.dismissAlert(driver);
			}
			wait(5);
			String env = prop.getProperty("ApplicationURL");
			System.out.println("Environment for log in verify generateotpforapproval:"+env);
			if (env.equalsIgnoreCase("SarathiCOV")) {
				loaddata();
				System.out.println("Loading to new window");
				  Utilitymethods utilitymethods = new Utilitymethods(driver);
				String otp = utilitymethods.Getlogotp("OTP (One Time Password) For Approval of Your Application", 192,199);
				driver.findElement(By.xpath("//input[@name='otpNumberForDlBacklog']")).sendKeys(otp);
				driver.findElement(By.xpath("//input[@name='otpNumberForDlBacklog']")).sendKeys(Keys.TAB);
				//Getlogotp("https://sarathicov.nic.in:8443/applogs/EmailandSMS.log");
				wait(2);
				//Clickon_LLBacklogApprove();
			} else if (env.equalsIgnoreCase("SarathiProd")) {
				loaddata();
				  Utilitymethods utilitymethods = new Utilitymethods(driver);
					String otp = utilitymethods.Getlogotp("OTP (One Time Password) For Approval of Your Application", 192,199);
					driver.findElement(By.xpath("//input[@name='otpNumberForDlBacklog']")).sendKeys(otp);
					driver.findElement(By.xpath("//input[@name='otpNumberForDlBacklog']")).sendKeys(Keys.TAB);
				//Getlogotp(prop.getProperty("SarathiprodeKYCLogURL"));
				wait(2);
				//Clickon_LLBacklogApprove();
			} else if (env.equalsIgnoreCase("CAS_SarathiCOV")) {
				System.out.println("inside this");
				loaddata();
				//Getlogotp("http://164.100.69.249:8080/staginglogs/applogs/EmailandSMS.log");
				wait(2);
				//Clickon_LLBacklogApprove();
			} else if (env.equalsIgnoreCase("CAS_SarathiProd")) {
				loaddata();
				//Getlogotp("https://sarathi.preprod.nic.in/applogs/EmailandSMS.log");
				wait(2);
				//Clickon_LLBacklogApprove();
			} else {
				System.out.println("Log URL is not matched.Please try again");
			}
		} else {
			System.out.println("There is no OTP option to Approve Backlog");
			wait(5);
			//Clickonapprovefor_non_Generateotpforapproval();
			//driver.findElement(By.xpath("//div[@id='dlbacklogApproveId']/following::input[1]")).click();
		}

	}
	
	
	
	
	
	
	public void Clickon_LLBacklogApprovebutton() {
		stepstatus = basepage.clickElement(LLBacklogApprovebutton);
		reportEvent(stepstatus, "Able to Click LLBacklogApprovebutton", "Unable to Click LLBacklogApprovebutton",
				driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
	WebElement Logout;

	public void Clickon_Logout() {
		stepstatus = basepage.clickElement(Logout);
		reportEvent(stepstatus, "Able to click on Logout", "Unable to click on Logout", driver, true);
	}

	public void ArrangeDataSet() {

		Faker faker = new Faker(new Locale("en-IND"));
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		String relationfirstname = faker.name().firstName();
		String relationlastname = faker.name().lastName();

		setdata("Name", firstname);
		setdata("Lastname", lastname);
		setdata("Relationfirstname", relationfirstname);
		setdata("Relationlastname", relationlastname);

	}

	public void Clickon_LLLink() {
		stepstatus = basepage.clickElement(LL);
		reportEvent(stepstatus, "Able to click on LL", "Unable to click on LL", driver, true);
	}

	
	@FindBy(how = How.XPATH, using = "//input[@id='numLicNo']")
	WebElement NumaricLLNo;
	public void Set_NumaricLLNo(String value) {
		stepstatus = basepage.SetTextAndTAB(NumaricLLNo, value);
		wait(20);
		if (basepage.alertExist(driver)) {
			String alerttext = basepage.alertGetText(driver);
			System.out.println(alerttext);
			basepage.acceptAlert(driver);
			wait(1);

		} else {

			System.out.println("Fail");
		}

		
		
		
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='fname']")
	WebElement nameoftheLicenceFirstName;
	
	public void nameoftheLicenceFirstName(String ApplicantFirstName) {
		stepstatus = basepage.setText(nameoftheLicenceFirstName, ApplicantFirstName);
		reportEvent(stepstatus, "Able to Enter nameoftheLicenceFirstName", "Unable to Enter nameoftheLicenceFirstName", driver, true);

	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='lname']")
	WebElement NameofLicenceLastname;
	
	public void NameofLicenceLastname(String ApplicantLastName) {
		wait(2);
		stepstatus = basepage.setText(NameofLicenceLastname, ApplicantLastName);
		reportEvent(stepstatus, "Able to Enter NameofLicenceLastname", "Unable to Enter NameofLicenceLastname",
				driver, true);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='gender1']")
	WebElement Gender;

		  public void selectGender() {
			  
			  stepstatus = basepage.clickElement(Gender);
				reportEvent(stepstatus, "Able to Select Gender", "Unable to Select Gender", driver, true);
		  }
			
		  @FindBy(how = How.XPATH, using = "//select[@id='relation']")
			WebElement Relation;
		  public void selectRelation(String Relationname) {
			  stepstatus = basepage.setOptionInSelectBox(Relation, Relationname );
				reportEvent(stepstatus, "Able to Enter NameofLicenceLastname", "Unable to Enter NameofLicenceLastname",
						driver, true);
		  }

		  @FindBy(how = How.XPATH, using = "//input[@id='rfname']")
			WebElement relationfirstname;

           public void enterRelationfirstname(String Relationfirstname) {
        	   stepstatus = basepage.setText(relationfirstname, Relationfirstname);
   			reportEvent(stepstatus, "Able to Enter Relationfirstname", "Unable to Enter Relationfirstname", driver,
   					true);

           }
           
           @FindBy(how = How.XPATH, using = "//input[@id='rlname']")
       	WebElement relationlastname;
           
           public void enterRelationlastname(String Relationlastname) {
			stepstatus = basepage.setText(relationlastname, Relationlastname);
			reportEvent(stepstatus, "Able to Enter Relationlastname", "Unable to Enter Relationlastname", driver, true);
           }
           
           
           @FindBy(how = How.XPATH, using = "//input[@id='age']")
       	WebElement Age;
           public void enterAge(String age) {
			stepstatus = basepage.setText(Age, age);
			reportEvent(stepstatus, "Able to Enter Age", "Unable to Enter Age", driver, true);
           }
           @FindBy(how = How.XPATH, using = "//select[@name='bloodgrp']")
       	WebElement bgrp;
			public void selectBloodGroup(String bloodgroup) {
			stepstatus = basepage.setOptionInSelectBox(bgrp, bloodgroup);
			reportEvent(stepstatus, "Able to Enter Bgrp", "Unable to Enter Bgrp", driver, true);
			}
			
			@FindBy(how = How.XPATH, using = "//select[@id='eduqua']")
			WebElement Qualification;
			public void selectQualification(String qualification) {
			stepstatus = basepage.setOptionInSelectBox(Qualification, qualification);
			reportEvent(stepstatus, "Able to Select Qualification", "Unable to Select Qualification", driver, true);
			 
			}
			
			@FindBy(how = How.XPATH, using = "//input[@id='mobile']")
			WebElement Mobilephone;
			public void enterMobilenumber(String mobilephone) {
			stepstatus = basepage.setText(Mobilephone, mobilephone);
			reportEvent(stepstatus, "Able to Enter Mobilephone", "Unable to Enter Mobilephone", driver, true);

			}
			@FindBy(how = How.XPATH, using = "//input[@id='prHouseNo']")
			WebElement Flat_Houseno;
			

			 public void Flat_Houseno() {
			stepstatus = basepage.setText(Flat_Houseno, "178AB");
			reportEvent(stepstatus, "Able to Enter Flat_Houseno", "Unable to Enter Flat_Houseno", driver, true);
			 }
			 
			 
			 @FindBy(how = How.XPATH, using = "//input[@id='prStreet']")
				WebElement Street_Locality;
			public void Street_Locality() {
			stepstatus = basepage.setText(Street_Locality, "WallStreet");
			reportEvent(stepstatus, "Able to Enter Street_Locality", "Unable to Enter Street_Locality", driver, true);
			}
			
			@FindBy(how = How.XPATH, using = "//input[@id='prPinCode']")
			WebElement PincodeinLLBacklog;
			public void PincodeinLLBacklog(String pin) {
			stepstatus = basepage.setText(PincodeinLLBacklog, pin);
			reportEvent(stepstatus, "Able to Enter Pincode", "Unable to Enter Pincode", driver, true);
			}
			
			@FindBy(how = How.XPATH, using = "//input[@id='copy']")
			WebElement CopytoPermanentAddressCheckbox;
			
			
			public void CopytoPermanentAddressCheckbox() {
			stepstatus = basepage.clickElement(CopytoPermanentAddressCheckbox);
			reportEvent(stepstatus, "Able to Click CopytoPermanentAddressCheckbox",
					"Unable to Click CopytoPermanentAddressCheckbox", driver, true);
			 }
		
			

			@FindBy(how = How.XPATH, using = "//select[@id='selectCov']")
			WebElement SelectClassofVechile;
			/* Adding First COV */
			public void selectCov1(String cov1) {
			
			stepstatus = basepage.setOptionInSelectBox(SelectClassofVechile, cov1);
			reportEvent(stepstatus, "Able to Select ClassofVechile", "Unable to Select ClassofVechile", driver, true);
			 }
			
			/* Adding Second COV */
			public void selectCov2(String cov2) {
		
			stepstatus = basepage.setOptionInSelectBox(SelectClassofVechile, cov2);
			reportEvent(stepstatus, "Able to Select ClassofVechile", "Unable to Select ClassofVechile", driver, true);
			 }
			
			
			@FindBy(how = How.XPATH, using = "//button[text()='=>']")
			WebElement RightarrowClick;
			 public void clickRightarrow() {
			stepstatus = basepage.clickElement(RightarrowClick);
			reportEvent(stepstatus, "Able to Click RightarrowClick", "Unable to Click RightarrowClick", driver, true);
			 } 
			 
			 
			 @FindBy(how = How.XPATH, using = "//button[@id='LLbacklogForm_2']")
				WebElement Submit;

			public void submit() {
			stepstatus = basepage.clickElement(Submit);
			reportEvent(stepstatus, "Able to Click Submit", "Unable to Click Submit", driver);

		}

			public void setApplication_and_LLnumber_inExcel() {
				WebElement refno = driver
						.findElement(By.xpath("//form[@id='LLBacklogAction']/center/h4[2][normalize-space(text())]"));
				String text = refno.getText();
				System.out.println(text);
				setdata("ApplicationNo", text.substring(24).trim());
				WebElement LLtext = driver
						.findElement(By.xpath("//form[@id='LLBacklogAction']/center/h4[3][normalize-space(text())]"));
				String LLno = LLtext.getText();
				System.out.println(LLno);
			    setdata("LLNumber", LLno.substring(17).trim());
				LLBacklogNumber = LLno.substring(17).trim();
			}
	
	
	
	@FindBy(how = How.XPATH, using = "//select[@name='prState']")
	WebElement CheckState;

	public void SetState() {
		
		
		WebElement stoption = driver.findElement(By.xpath("//select[@name='prState']"));
		Select st = new Select(stoption);
		List<WebElement> options = st.getOptions();
		WebElement ele = st.getFirstSelectedOption();
		System.out.println(ele.getText());
		if (ele.getText().contains("SELECT")) {
			
			st.selectByValue(getdata("State"));
			
			
			/*for (int i = 0; i <= options.size() - 1; i++) {
				try {
					stoption = driver.findElement(By.xpath("//select[@name='prState']"));
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

			}*/
		} else {

			System.out.println("State is already selected.");
		}
	}

	public void TypeDist() {

		WebElement Dist = driver.findElement(By.xpath("//select[@name='prDistrict']"));
		Select District = new Select(Dist);
		List<WebElement> options = District.getOptions();
		for (int i = 0; i <= options.size() - 1; i++) {
			try {
				Dist = driver.findElement(By.xpath("//select[@name='prDistrict']"));
				District = new Select(Dist);
				options = District.getOptions();
				if (!options.get(1).getText().contains("Select")) {
					System.out.println(options.get(1).getText());
					District.selectByVisibleText(options.get(1).getText());
					Thread.sleep(3000);
					WebElement SubDist = driver.findElement(By.xpath("//select[@name='prSubDistrict']"));
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

}
