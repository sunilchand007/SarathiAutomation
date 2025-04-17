package pageobjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import actions.Action_215;
import frameworkLibrary.BasePage;
import utility.Flows;
import utility.Utilitymethods;

public class NewDLSlotBookingPageOLD extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

ApplicationStatusStage01Page applicationStatusstage01;
Action_215 action_215;

	public NewDLSlotBookingPageOLD(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelements
	@FindBy(how = How.XPATH, using = "//span[1][text()='Apply Online']")
	WebElement Applyonline;
	@FindBy(how = How.XPATH, using = "//a[text()='Application Status']")
	WebElement Applicationstatus;
	@FindBy(how = How.XPATH, using = "//input[@name='applNum']")
	WebElement Application_Number;
	@FindBy(how = How.XPATH, using = "//input[@name='dateOfBirth']")
	WebElement DateofBirth;
	@FindBy(how = How.XPATH, using = "//input[@id='dlslotipform____SAVE___']")
	WebElement Submit;
	@FindBy(how = How.XPATH, using = "//button[@id='applViewStages_0']")
	WebElement Proceed;
	@FindBy(how = How.XPATH, using = "//input[@class='chk']")
	WebElement SelectCOVCheckbox;
	@FindBy(how = How.XPATH, using = "//button[@id='prcdbook']")
	WebElement Proceedbook;
	@FindBy(how = How.XPATH, using = "//button[@id='slotbtn']")
	WebElement Bookslot;
	@FindBy(how = How.XPATH, using = "//button[@id='slotcnfrmbtn']")
	WebElement Confirm_slotbook;
	@FindBy(how = How.XPATH, using = "//input[@id='home']")
	WebElement Home;
	@FindBy(how = How.XPATH, using = "//input[@value='DL TEST SLOT BOOKING']")
	WebElement Clickradio;
	@FindBy(how = How.XPATH, using = "//input[@value='LL/DL SERVICES SLOT BOOK']")
	WebElement ClickradioDLService;
	@FindBy(how = How.XPATH, using = "//input[@id='slotcnfrmbtn']")
	WebElement Confirm_slotbookDLService;
	@FindBy(how = How.XPATH, using = "//button[@id='slotcnfrmbtn']")
	WebElement Confirm_slotbookNewDL;

	@FindBy(how = How.XPATH, using = "//input[@id='dlslotipform_subtype1']")
	WebElement ClickradioApplnum;
	@FindBy(how = How.XPATH, using = "//input[@id='captcha']")
	WebElement Verificationcode;
	
	public void Clickon_Confirm_slotbookingforDLService() throws IOException {
		String env = getdata("ApplicationEnvironment");
		if (env.equalsIgnoreCase("SarathiCOV")) {
			loaddata();
			GetSecutiryCodeforDLSerivce(prop.getProperty("SarathiCOVSlotsSecurityCodeLogURL"));
			stepstatus = basepage.clickElement(Confirm_slotbookDLService);
			wait(1);
			String title = driver.getTitle();
			if (title.equals("Home")) {
				setdata("IPAddress", getIPAddress());
				setdata("StatusofLLSlotBooking", "Success");
			} else {
				setdata("StatusofLLSlotBooking", "Fail");
			}
		} else if (env.equalsIgnoreCase("SarathiProd")) {
			loaddata();
			GetSecutiryCodeforDLSerivce(prop.getProperty("SarathiprodSlotsSecurityCodeLogURL"));
			stepstatus = basepage.clickElement(Confirm_slotbookDLService);
			wait(1);
			String title = driver.getTitle();
			if (title.equals("Home")) {
				setdata("IPAddress", getIPAddress());
				setdata("StatusofLLSlotBooking", "Success");
			} else {
				setdata("StatusofLLSlotBooking", "Fail");
			}
		} else {
			System.out.println("Log URL is not matched.Please try again");
		}

		// reportEvent(stepstatus, "Able to click Confirm_slotbook", "Unable to click
		// Confirm_slotbook", driver, true);
	}
	
	public void Clickon_Confirm_slotbookingforNewDL() throws IOException {
		String env = getdata("ApplicationEnvironment");
		if (env.equalsIgnoreCase("SarathiCOV")) {
			loaddata();
			GetSecutiryCodeforNewDL(prop.getProperty("SarathiCOVSlotsSecurityCodeLogURL"));
			stepstatus = basepage.clickElement(Confirm_slotbookNewDL);
			wait(1);
			String title = driver.getTitle();
			if (title.equals("Home")) {
				setdata("IPAddress", getIPAddress());
				setdata("StatusofLLSlotBooking", "Success");
			} else {
				setdata("StatusofLLSlotBooking", "Fail");
			}
		} else if (env.equalsIgnoreCase("SarathiProd")) {
			loaddata();
			GetSecutiryCodeforNewDL(prop.getProperty("SarathiprodSlotsSecurityCodeLogURL"));
			stepstatus = basepage.clickElement(Confirm_slotbookNewDL);
			wait(1);
			String title = driver.getTitle();
			if (title.equals("Home")) {
				setdata("IPAddress", getIPAddress());
				setdata("StatusofLLSlotBooking", "Success");
			} else {
				setdata("StatusofLLSlotBooking", "Fail");
			}
		} else {
			System.out.println("Log URL is not matched.Please try again");
		}

		// reportEvent(stepstatus, "Able to click Confirm_slotbook", "Unable to click
		// Confirm_slotbook", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//input[@name='HOME']")
	WebElement HOMEbutton;

	public void Clickon_HOMEbutton() {
		stepstatus = basepage.clickElement(HOMEbutton);
		reportEvent(stepstatus, "Able to click HOMEbutton", "Unable to  click HOMEbutton", driver, true);
	}
	public void ClickradioApplnum() {
		stepstatus = basepage.clickElement(ClickradioApplnum);
		reportEvent(stepstatus, "Able to click radio button Applnum", "Unable to  click radio button Applnum", driver, true);
	}
	
	public void Verificationcode(){
		stepstatus = basepage.setText(Verificationcode,"123456");
		reportEvent(stepstatus, "Able to Enter Verification code In DLService Submission", "Unable to Enter Verification code In DLService Submission", driver, true);
	}

	public void Clickon_ProceedforDLServices() throws IOException {
		if (basepage.clickElement(ClickradioDLService)) {
			stepstatus = basepage.clickElement(Proceed);
			String PageTitle = driver.getTitle();
			System.out.println("Title of the page is" + PageTitle);
			if (PageTitle.equalsIgnoreCase("Sending SMS")) {
				loaddata();
				GetSecutiryCode(prop.getProperty("SarathiCOVSlotsSecurityCodeLogURL"));
				Clickon_Selectcov();
				Clickon_ProceedtoBookSlotatDlService();

			} else {
				Clickon_Selectcov();
				Clickon_ProceedtoBookSlotatDlService();
			}

		}
	}

	@FindBy(how = How.XPATH, using = "//input[@value='  PROCEED TO BOOK  ']")
	WebElement ProceedtoBookSlotatDlService;

	public void Clickon_ProceedtoBookSlotatDlService() {
		stepstatus = basepage.clickElement(ProceedtoBookSlotatDlService);
		reportEvent(stepstatus, "Able to click ProceedtoBookSlot button", "Unable to click ProceedtoBookSlot button",driver, true);

	}
	public void Booking_SlotforDLServices() {
		List<WebElement> GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[contains(@class,'cal_green')]"));
		int TotalAvailbleGreenColorDates = GreenColorDates.size();
		System.out.println("Available Dates: " + TotalAvailbleGreenColorDates);
		WebElement TotalGreenColorDates;
		String Datestext;
		List<WebElement> Timeslots;
		int timeslots;
		WebElement eletimeslot;
		String timeslottxt;
		WebElement seatslabel;
		String seatstxt;
		if (TotalAvailbleGreenColorDates == 1) {
			System.out.println("Last Working day of the month");
			WebElement lstdaymnth = driver.findElement(By.xpath("//table/tbody/tr/td[contains(@class,'cal_green')]"));
			String textlstday = lstdaymnth.getText();
			System.out.println("Last Working day of the month is: " + textlstday);
			lstdaymnth.click();
			Timeslots = driver.findElements(
					By.xpath("//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr/td[1]"));
			timeslots = Timeslots.size();
			System.out.println(timeslots);

			loop: for (int j = 0; j < timeslots; j++) {
				eletimeslot = Timeslots.get(j);
				timeslottxt = eletimeslot.getText();
				seatslabel = driver.findElement(
						By.xpath("//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr[" + 1 + "+" + j + "]/td[2]/label"));
				seatstxt = seatslabel.getText();
				if (!seatstxt.equalsIgnoreCase("0")) {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
					driver.findElement(
							By.xpath("//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr[" + 1 + "+" + j + "]/td[2]/input"))
							.click();

					break loop;
				} else {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
				}
			}
			try {
				boolean verifybtnenabled = driver.findElement(By.xpath("//button[@id='slotbtn']")).isEnabled();
				if (verifybtnenabled == false) {
					outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
						GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[contains(@class,'cal_green')]/a"));
						TotalGreenColorDates = GreenColorDates.get(i);
						Datestext = TotalGreenColorDates.getText();
						System.out.println(Datestext);
						GreenColorDates.get(i).click();
						Timeslots = driver.findElements(By.xpath(
								"//table[contains(@class,'table table-bordered table-striped']//following-sibling::tr/td[1]"));
						timeslots = Timeslots.size();
						System.out.println(timeslots);

						for (int j = 0; j < timeslots; j++) {
							eletimeslot = Timeslots.get(j);
							timeslottxt = eletimeslot.getText();
							seatslabel = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered table-striped']//following-sibling::tr[" + 1 + "+" + j + "]/td[2]/label"));
							seatstxt = seatslabel.getText();
							if (!seatstxt.equalsIgnoreCase("0")) {
								System.out.println(timeslottxt + " Availble Seats is : " + seatstxt);
								driver.findElement(By.xpath("//table[contains(@class,'table table-bordered table-striped']//following-sibling::tr["
												+ 1 + "+" + j + "]/td[2]/input"))
										.click();

								break outerloop;
							} else {
								System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
							}

						}

					}

				} else {
					System.out.println("Processing your Slot booking");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
				
				GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[contains(@class,'cal_green')]/a"));
				TotalGreenColorDates = GreenColorDates.get(i);
				System.out.println("GreenColorDates are "+ i );
				Datestext = TotalGreenColorDates.getText();
				System.out.println(Datestext);
				System.out.println("Next available date is : "+ Datestext);
				GreenColorDates.get(i).click();
				Timeslots = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr/td[1]"));
			//	Timeslots = driver.findElements(By.xpath("//*[@id='onlinetestslotform']/div[1]/div[2]/div[2]/fieldset/div[3]/table//following-sibling::tr/td[2]"));
				
				timeslots = Timeslots.size();
				System.out.println("Available timeslots are : " + timeslots);

				for (int j = 0; j < timeslots; j++) {
					eletimeslot = Timeslots.get(j);
					timeslottxt = eletimeslot.getText();
					seatslabel = driver.findElement(
							By.xpath("//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr[" + 1 + "+" + j + "]/td[2]/label"));
					seatstxt = seatslabel.getText();
					if (!seatstxt.equalsIgnoreCase("0")) {
						System.out.println(timeslottxt + " Available Seats is: " + seatstxt);
						driver.findElement(By.xpath("//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr[" + 1 + "+" + j + "]/td[2]/input")).click();

						break outerloop;
					} else {
						System.out.println(timeslottxt + " Available Seats is: " + seatstxt);
					}

				}

			}

		}
	}
		/*List<WebElement> GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green NALOC']"));
		int TotalAvailbleGreenColorDates = GreenColorDates.size();
		System.out.println("Available Dates: " + TotalAvailbleGreenColorDates);
		WebElement TotalGreenColorDates;
		String Datestext;
		List<WebElement> Timeslots;
		int timeslots;
		WebElement eletimeslot;
		String timeslottxt;
		WebElement seatslabel;
		String seatstxt;
		if (TotalAvailbleGreenColorDates == 1) {
			System.out.println("Last Working day of the month");
			WebElement lstdaymnth = driver.findElement(By.xpath("//table/tbody/tr/td[@class='cal_green']"));
			String textlstday = lstdaymnth.getText();
			System.out.println("Last Working day of the month is: " + textlstday);
			lstdaymnth.click();
			Timeslots = driver.findElements(
					By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr/td[1]"));
			timeslots = Timeslots.size();
			System.out.println(timeslots);

			loop: for (int j = 0; j < timeslots; j++) {
				eletimeslot = Timeslots.get(j);
				timeslottxt = eletimeslot.getText();
				seatslabel = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr[" + 1 + "+" + j + "]/td[2]/label"));
				seatstxt = seatslabel.getText();
				if (!seatstxt.equalsIgnoreCase("0")) {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
					driver.findElement(
							By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr[" + 1 + "+" + j + "]/td[2]/input"))
							.click();

					break loop;
				} else {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
				}
			}
			try {
				boolean verifybtnenabled = driver.findElement(By.xpath("//button[@id='slotbtn']")).isEnabled();
				if (verifybtnenabled == false) {
					outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
						GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green']/a"));
						TotalGreenColorDates = GreenColorDates.get(i);
						Datestext = TotalGreenColorDates.getText();
						System.out.println(Datestext);
						GreenColorDates.get(i).click();
						Timeslots = driver.findElements(By.xpath(
								"//table[@class='table table-bordered table-striped']//following-sibling::tr/td[1]"));
						timeslots = Timeslots.size();
						System.out.println(timeslots);

						for (int j = 0; j < timeslots; j++) {
							eletimeslot = Timeslots.get(j);
							timeslottxt = eletimeslot.getText();
							seatslabel = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr[" + 1 + "+" + j + "]/td[2]/label"));
							seatstxt = seatslabel.getText();
							if (!seatstxt.equalsIgnoreCase("0")) {
								System.out.println(timeslottxt + " Availble Seats is : " + seatstxt);
								driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr["
												+ 1 + "+" + j + "]/td[2]/input"))
										.click();

								break outerloop;
							} else {
								System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
							}

						}

					}

				} else {
					System.out.println("Processing your Slot booking");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
				
				GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green NALOC']/a"));
				TotalGreenColorDates = GreenColorDates.get(i);
				Datestext = TotalGreenColorDates.getText();
				System.out.println(Datestext);
				GreenColorDates.get(i).click();
				Timeslots = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr/td[1]"));
				timeslots = Timeslots.size();
				System.out.println(timeslots);

				for (int j = 0; j < timeslots; j++) {
					eletimeslot = Timeslots.get(j);
					timeslottxt = eletimeslot.getText();
					seatslabel = driver.findElement(
							By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr[" + 1
									+ "+" + j + "]/td[2]/label"));
					seatstxt = seatslabel.getText();
					if (!seatstxt.equalsIgnoreCase("0")) {
						System.out.println(timeslottxt + " Available Seats is: " + seatstxt);
						driver.findElement(
								By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr["
										+ 1 + "+" + j + "]/td[2]/input"))
								.click();

						break outerloop;
					} else {
						System.out.println(timeslottxt + " Available Seats is: " + seatstxt);
					}

				}

			}

		}
	}*/
	// Related methods to perform operation on webelements
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

	public void Do_ScrollDown() {
		stepstatus = basepage.scrooldown(driver);
		reportEvent(stepstatus, "Able to do Scrolldown", "Unable to do Scrolldown", driver, true);
	}

	
	@FindBy(how = How.XPATH, using = "//a[text()='SarathiOnWeb']")
	WebElement Sarathionweb;
	@FindBy(how = How.XPATH, using = "//input[@value='Refresh']")
	WebElement Refreshbtn;
	public void Clickon_Proceed_Button() throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		if (basepage.isDisplayed(Clickradio) == true && basepage.clickElement(Clickradio) == true) {
			stepstatus = basepage.clickElement(Proceed);
			if(driver.getPageSource().contains("Previous flows need to be completed to go for slot booking")) {
				clickElement(Sarathionweb);
				action_215 = new Action_215(driver);
				action_215.applicationstatus();
				Refreshbtn.click();
				Flows validate = new Flows(driver);
				try {
					validate.VerifyFlows();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println("Continueing normal flow");
			}
			
			
			String PageTitle = driver.getTitle();
			System.out.println(PageTitle);
			if (PageTitle.equalsIgnoreCase("Sending SMS")) {
				String env = prop.getProperty("ApplicationURL");
				if (env.equalsIgnoreCase("SarathiCOV")) {
					loaddata();
					GetSecutiryCode(prop.getProperty("SarathiCOVSlotsSecurityCodeLogURL"));
				} else if (env.equalsIgnoreCase("SarathiProd")) {
					loaddata();
					GetSecutiryCode(prop.getProperty("SarathiprodSlotsSecurityCodeLogURL"));
				} else {
					System.out.println("Log URL is not matched.Please try again");
				}
				Clickon_Selectcov();
				Clickon_ProceedtoBookSlot_Button();

			} else if(PageTitle.equalsIgnoreCase("Home")) {
				System.out.println("inside page title home ");
				String env = prop.getProperty("ApplicationURL");
				if (env.equalsIgnoreCase("SarathiCOV")) {
					driver.findElement(By.xpath("//input[@id='dlslotipform_subtype1']")).click();
					driver.findElement(By.xpath("//input[@id='captcha']")).sendKeys("123456");
					driver.findElement(By.xpath("//input[@value = '  SUBMIT  ']")).click();
					Clickon_Selectcov();
					Clickon_ProceedtoBookSlot_Button();
				} else if (env.equalsIgnoreCase("SarathiProd")) {
					System.out.println("inside preprod home to select cov");
					//input[@id='dlslotipform_subtype1']
					ClickradioApplnum();
					Verificationcode();
					Clickon_Submit_Button();
					Clickon_Selectcov();
					Clickon_ProceedtoBookSlot_Button();
					Booking_Slot();
					Clickon_Bookslotbutton();
					Clickon_Confirm_slotbookingforNewDL();
					
					
				}

				else {
					System.out.println("check environment");
				}
				
			}
			
			
			else {
				Clickon_Selectcov();
				Clickon_ProceedtoBookSlot_Button();
			}

		}

	}

	@FindBy(how = How.XPATH, using = "//button[@id='prcdbook']")
	WebElement ProceedtoBookSlot;

	public void Clickon_ProceedtoBookSlot_Button() {
		stepstatus = basepage.clickElement(ProceedtoBookSlot);
		reportEvent(stepstatus, "Able to click ProceedtoBookSlot button", "Unable to click ProceedtoBookSlot button",
				driver, true);

	}

	public String GetSecutiryCode(String url) throws IOException {
		wait(3);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // switches to new tab
		driver.get(url);
		// driver.navigate().refresh();
		String output = driver.findElement(By.cssSelector("body")).getText();
		File DestFile = new File(".\\logfile.txt");
		PrintWriter writer = new PrintWriter(DestFile);
		writer.print("");
		writer.close();
		FileUtils.writeStringToFile(DestFile, output);
		String FILENAME = ".\\logfile.txt";
		String getotp = null;
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String strCurrentLine;
			int count = 0;
			while ((strCurrentLine = br.readLine()) != null) {
				if (strCurrentLine.contains("One Time Password is")) {
					if (strCurrentLine.contains("One Time Password is")) {
						getotp = strCurrentLine.substring(105, 111).trim();
						 System.out.println(getotp);
					}
					count++;
				} else {
					System.out.println("#######################Pleasae Check OTP Section###########################");
				}
			}
			// System.out.println(count);
			System.out.println(getotp);
			driver.switchTo().window(tabs.get(0));
			driver.findElement(By.xpath("//input[@id='securityForm_smsCode']")).sendKeys(getotp);
			driver.findElement(By.xpath("//input[@id='securityForm_smsCode']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//input[@id='securityForm__submitSecurityCode']")).click();
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getotp;
	}

	 public String GetSecutiryCodeforDLSerivce(String url) throws IOException {
		wait(3);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); 
		// switches to new tab
		driver.get(url);
		// driver.navigate().refresh();
		String output = driver.findElement(By.cssSelector("body")).getText();
		File DestFile = new File(".\\logfile.txt");
		PrintWriter writer = new PrintWriter(DestFile);
		writer.print("");
		writer.close();
		FileUtils.writeStringToFile(DestFile, output);
		String FILENAME = ".\\logfile.txt";
		String getotp = null;
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String strCurrentLine;
			int count = 0;
			while ((strCurrentLine = br.readLine()) != null) {
				if (strCurrentLine.contains("::securityCd::")) {
				if (strCurrentLine.contains("::securityCd::")) {
						getotp = strCurrentLine.substring(148, 154).trim();
						// System.out.println(getotp);
					}
					count++;
				} else {
					// System.out.println("#######################Pleasae Check OTP
					// Section###########################");
				}
			}
			// System.out.println(count);
			System.out.println(getotp);
			driver.switchTo().window(tabs.get(0));
			driver.findElement(By.xpath("//input[@id='smsCode']")).sendKeys(getotp);
			driver.findElement(By.xpath("//input[@id='smsCode']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//input[@value='  CONFIRM TO SLOTBOOK  ']")).click();
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getotp;
	}
	 public String GetSecutiryCodeforNewDL(String url) throws IOException {
			wait(3);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1)); 
			// switches to new tab
			driver.get(url);
			// driver.navigate().refresh();
			String output = driver.findElement(By.cssSelector("body")).getText();
			File DestFile = new File(".\\logfile.txt");
			PrintWriter writer = new PrintWriter(DestFile);
			writer.print("");
			writer.close();
			FileUtils.writeStringToFile(DestFile, output);
			String FILENAME = ".\\logfile.txt";
			String getotp = null;
			try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
				String strCurrentLine;
				int count = 0;
				while ((strCurrentLine = br.readLine()) != null) {
					if (strCurrentLine.contains("One time password")) {
					if (strCurrentLine.contains("One time password")) {
							getotp = strCurrentLine.substring(151, 157).trim();
							// System.out.println(getotp);
						}
						count++;
					} else {
						// System.out.println("#######################Pleasae Check OTP
						// Section###########################");
					}
				}
				// System.out.println(count);
				System.out.println(getotp);
				driver.switchTo().window(tabs.get(0));
				driver.findElement(By.xpath("//input[@id='smsCode']")).sendKeys(getotp);
				driver.findElement(By.xpath("//input[@id='smsCode']")).sendKeys(Keys.TAB);
				driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
				driver.switchTo().window(tabs.get(1)).close();
				driver.switchTo().window(tabs.get(0));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return getotp;
		}
	public void Clickon_Selectcov() {
		// stepstatus = basepage.clickElement(SelectCOVCheckbox);
		
       String env = prop.getProperty("ApplicationURL");
		
		System.out.println("Testing environment is :  "  + env);
		// getdata("ApplicationEnvironment");
		if (env.equalsIgnoreCase("SarathiCOV")) {
			List<WebElement> Allchecks = driver.findElements(By.xpath("//input[@class='chk NALOC']"));
			int size = Allchecks.size();
			System.out.println("Total Checkbox Availble to click" + size);
			for (WebElement cks : Allchecks) {
				setCheckBox(cks, "ON");
			}
		}else if (env.equalsIgnoreCase("SarathiProd")) {
			List<WebElement> Allchecks = driver.findElements(By.xpath("//input[@class='chk NALOC']"));
			int size = Allchecks.size();
			System.out.println("Total Checkbox Availble to click" + size);
			for (WebElement cks : Allchecks) {
				setCheckBox(cks, "ON");
			}
			
		}
		

		// reportEvent(stepstatus, "Able to click SelectCOVCheckbox", "Unable to click
		// SelectCOVCheckbox", driver, true);
	}

	public void Clickon_Proceedbook() {
		stepstatus = basepage.clickElement(Proceedbook);
		reportEvent(stepstatus, "Able to click Proceedbook", "Unable to click Proceedbook", driver, true);
	}

	public void Create_RandomDate() {
		stepstatus = basepage.Random_Datepicker(driver);
		reportEvent(stepstatus, "Able to click Randomdate", "Unable to  click Randomdate", driver, true);
	}

	public void Clickon_Slotbookingbutton(String ObjectXpath, String ObjectXpath1) {
		stepstatus = basepage.Slot_booking(driver, ObjectXpath, ObjectXpath1);
		reportEvent(stepstatus, "Able to do slotbooking", "Unable to do slotbooking", driver, true);
	}

	public void Clickon_Bookslotbutton() {
		stepstatus = basepage.clickElement(Bookslot);
		reportEvent(stepstatus, "Able to click Bookslotbutton", "Unable to  click Bookslotbutton", driver, true);
	}

	public void Clickon_Confirm_slotbookingbutton() throws IOException {
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		if (PageTitle.equalsIgnoreCase("Sending SMS")) {
			/*
			String env = getdata("ApplicationEnvironment");
			if (env.equalsIgnoreCase("SarathiCOV")) {
				loaddata();
				GetSecutiryCode(prop.getProperty("SarathiCOVSlotsSecurityCodeLogURL"));
			} else if (env.equalsIgnoreCase("SarathiProd")) {
				loaddata();
				GetSecutiryCode(prop.getProperty("SarathiprodSlotsSecurityCodeLogURL"));
			} else {
				System.out.println("Log URL is not matched.Please try again");
			}*/
			
			Utilitymethods utilitymethods = new Utilitymethods(driver);
		String otp= 	utilitymethods.Getlogotp("One Time Password is", 109 , 115);
			driver.findElement(By.xpath("//input[@id='securityForm_smsCode']")).sendKeys("");
			driver.findElement(By.xpath("//input[@id='securityForm_0']")).click();
			stepstatus = basepage.clickElement(Confirm_slotbook);
			wait(2);
		} else {
			stepstatus = basepage.clickElement(Confirm_slotbook);
			wait(2);
		}

	}

	@FindBy(how = How.XPATH, using = "//input[@name='NEXT']")
	WebElement Next;
	@FindBy(how = How.XPATH, using = "//input[@value='SUBMIT']")
	WebElement submit;
	public void Clickon_Next() {
		stepstatus = basepage.clickElement(Next);
		reportEvent(stepstatus, "Able to click Next", "Unable to  click Next", driver, true);
	}
	public void Clickon_Submit() {
		stepstatus = basepage.clickElement(submit);
		reportEvent(stepstatus, "Able to click submit", "Unable to  click submit", driver, true);
	}

	public void Booking_Slot() {
		List<WebElement> GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[contains(@class,'cal_green')]"));
		int TotalAvailbleGreenColorDates = GreenColorDates.size();
		System.out.println("Available Dates: " + TotalAvailbleGreenColorDates);
		WebElement TotalGreenColorDates;
		String Datestext;
		List<WebElement> Timeslots;
		int timeslots;
		WebElement eletimeslot;
		String timeslottxt;
		WebElement seatslabel;
		String seatstxt;
		if (TotalAvailbleGreenColorDates == 1) {
			System.out.println("Last Working day of the month");
			WebElement lstdaymnth = driver.findElement(By.xpath("//table/tbody/tr/td[contains(@class,'cal_green')]"));
			String textlstday = lstdaymnth.getText();
			System.out.println("Last Working day of the month is: " + textlstday);
			lstdaymnth.click();
			Timeslots = driver.findElements(
					By.xpath("//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr/td[1]"));
			timeslots = Timeslots.size();
			System.out.println(timeslots);

			loop: for (int j = 0; j < timeslots; j++) {
				eletimeslot = Timeslots.get(j);
				timeslottxt = eletimeslot.getText();
				seatslabel = driver.findElement(
						By.xpath("//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr[" + 1 + "+" + j + "]/td[2]/label"));
				seatstxt = seatslabel.getText();
				if (!seatstxt.equalsIgnoreCase("0")) {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
					driver.findElement(
							By.xpath("//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr[" + 1 + "+" + j + "]/td[2]/input"))
							.click();

					break loop;
				} else {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
				}
			}
			try {
				boolean verifybtnenabled = driver.findElement(By.xpath("//button[@id='slotbtn']")).isEnabled();
				if (verifybtnenabled == false) {
					outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
						GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[contains(@class,'cal_green')]/a"));
						TotalGreenColorDates = GreenColorDates.get(i);
						Datestext = TotalGreenColorDates.getText();
						System.out.println(Datestext);
						GreenColorDates.get(i).click();
						Timeslots = driver.findElements(By.xpath(
								"//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr/td[1]"));
						timeslots = Timeslots.size();
						System.out.println(timeslots);

						for (int j = 0; j < timeslots; j++) {
							eletimeslot = Timeslots.get(j);
							timeslottxt = eletimeslot.getText();
							seatslabel = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr[" + 1 + "+" + j + "]/td[2]/label"));
							seatstxt = seatslabel.getText();
							if (!seatstxt.equalsIgnoreCase("0")) {
								System.out.println(timeslottxt + " Availble Seats is : " + seatstxt);
								driver.findElement(By.xpath("//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr["
												+ 1 + "+" + j + "]/td[2]/input"))
										.click();

								break outerloop;
							} else {
								System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
							}

						}

					}

				} else {
					System.out.println("Processing your Slot booking");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
				
				GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[contains(@class,'cal_green')]/a"));
				TotalGreenColorDates = GreenColorDates.get(i);
				System.out.println("GreenColorDates are "+ i );
				Datestext = TotalGreenColorDates.getText();
				System.out.println(Datestext);
				System.out.println("Next available date is : "+ Datestext);
				GreenColorDates.get(i).click();
				Timeslots = driver.findElements(By.xpath("//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr/td[1]"));
			//	Timeslots = driver.findElements(By.xpath("//*[@id='onlinetestslotform']/div[1]/div[2]/div[2]/fieldset/div[3]/table//following-sibling::tr/td[2]"));
				
				timeslots = Timeslots.size();
				System.out.println("Available timeslots are : " + timeslots);

				for (int j = 0; j < timeslots; j++) {
					eletimeslot = Timeslots.get(j);
					timeslottxt = eletimeslot.getText();
					seatslabel = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered table-striped')]/tbody/tr[2]/td[2]/span"));
					seatstxt = seatslabel.getText();
					if (!seatstxt.equalsIgnoreCase("0")) {
						System.out.println(timeslottxt + " Available Seats is: " + seatstxt);
						driver.findElement(By.xpath("//table[contains(@class,'table table-bordered table-striped')]//following-sibling::tr[" + 1 + "+" + j + "]/td[2]/input")).click();

						break outerloop;
					} else {
						System.out.println(timeslottxt + " Available Seats is: " + seatstxt);
					}

				}

			}

		}
	}
		
	
		/*if (TotalAvailbleGreenColorDates == 1) {
			System.out.println("Last Working day of the month");
			WebElement lstdaymnth = driver.findElement(By.xpath("//table/tbody/tr/td[@class='cal_green']"));
			String textlstday = lstdaymnth.getText();
			System.out.println("Last Working day of the month is: " + textlstday);
			lstdaymnth.click();
			Timeslots = driver.findElements(By.xpath(
					"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr/td[1]"));
			timeslots = Timeslots.size();
			System.out.println(timeslots);

			loop: for (int j = 0; j < timeslots; j++) {
				eletimeslot = Timeslots.get(j);
				timeslottxt = eletimeslot.getText();
				seatslabel = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr[" + 1 + "+" + j + "]/td[2]/label"));
				seatstxt = seatslabel.getText();
				if (!seatstxt.equalsIgnoreCase("0")) {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
					driver.findElement(By.xpath("//table table-bordered table-striped table-hover NALOC']//following-sibling::tr["+ 1 + "+" + j + "]/td[2]/input")).click();

					break loop;
				} else {
					System.out.println(timeslottxt + " Availble Seats is : " + seatstxt);
				}

			}
			try {
				boolean verifybtnenabled = driver.findElement(By.xpath("//button[@id='slotbtn']")).isEnabled();
				if (verifybtnenabled == false) {
					outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
						GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green']/a"));
						TotalGreenColorDates = GreenColorDates.get(i);
						Datestext = TotalGreenColorDates.getText();
						System.out.println(Datestext);
						GreenColorDates.get(i).click();
						Timeslots = driver.findElements(By.xpath(
								"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr/td[1]"));
						timeslots = Timeslots.size();
						System.out.println(timeslots);

						for (int j = 0; j < timeslots; j++) {
							eletimeslot = Timeslots.get(j);
							timeslottxt = eletimeslot.getText();
							seatslabel = driver.findElement(By.xpath(
									"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr["
											+ 1 + "+" + j + "]/td[2]/span"));
							seatstxt = seatslabel.getText();
							if (!seatstxt.equalsIgnoreCase("0")) {
								System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
								driver.findElement(By.xpath(
										"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr["
												+ 1 + "+" + j + "]/td[2]/input"))
										.click();

								break outerloop;
							} else {
								System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
							}

						}

					}

				} else {
					System.out.println("Processing your Slot booking");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
				GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green']/a"));
				TotalGreenColorDates = GreenColorDates.get(i);
				Datestext = TotalGreenColorDates.getText();
				System.out.println(Datestext);
				GreenColorDates.get(i).click();
				Timeslots = driver.findElements(By.xpath(
						"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr/td[1]"));
				timeslots = Timeslots.size();
				System.out.println(timeslots);

				for (int j = 0; j < timeslots; j++) {
					eletimeslot = Timeslots.get(j);
					timeslottxt = eletimeslot.getText();
					seatslabel = driver.findElement(By.xpath(
							"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr["
									+ 1 + "+" + j + "]/td[2]/span"));
					seatstxt = seatslabel.getText();
					if (!seatstxt.equalsIgnoreCase("0")) {
						System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
						driver.findElement(By.xpath(
								"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr["
										+ 1 + "+" + j + "]/td[2]/input"))
								.click();

						break outerloop;
					} else {
						System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
					}

				}

			}

		}
	}*/

	/* New Properties */

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

	@FindBy(how = How.XPATH, using = "//a[text()=' Appointments ']")
	WebElement Appointments;

	public void Mouserhoveron_Appointments() {
		driver.findElement(By.xpath("//button[@class = 'close popupclose']")).click();
		stepstatus = basepage.mouseHover(Appointments, driver);
		reportEvent(stepstatus, "Able to do Mousehover action on Appointments",
				"Unable to do Mousehover action on Appointments", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='DL Test Slot Booking']")
	WebElement slotbookingDLTest;

	public void Clickon_Slot_Booking_DL_Test() {
		stepstatus = basepage.clickElement(slotbookingDLTest);
		reportEvent(stepstatus, "Able to click Slot_Booking_DL_Test", "Unable to click Slot_Booking_DL_Test", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='DL services Slot Booking']")
	WebElement slotbookingLLDLService;

	public void Clickon_Slot_Booking_DL_services() {
		stepstatus = basepage.clickElement(slotbookingLLDLService);
		reportEvent(stepstatus, "Able to click Slot Booking DL services", "Unable to click Slot Booking DL services",
				driver, true);
	}

	public void Menuitem_Slot_Booking_DLTest() {
		Mouserhoveron_Appointments();
		Clickon_Slot_Booking_DL_Test();
		driver.findElement(By.xpath("//input[@name='subtype']")).click();
		driver.findElement(By.xpath("//input[@id='applno']")).sendKeys(getdata("ApplicationNo"));
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(getdata("DateofBirth"));
		// JFrame Dialog = new JFrame();
		// String name = JOptionPane.showInputDialog(Dialog, "Enter Captcha");
		// driver.findElement(By.xpath("//input[@id='captcha']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@value='  SUBMIT  ']")).click();
		try {
			Clickon_Selectcov();
			Clickon_ProceedtoBookSlot_Button();
			Booking_Slot();
			Clickon_Bookslotbutton();
			Clickon_Confirm_slotbookingbutton();
			Clickon_Next();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void Menuitem_Slot_Booking_DL_services() {
		Mouserhoveron_Appointments();
		Clickon_Slot_Booking_DL_services();
		//driver.findElement(By.xpath("//input[@name='subtype']")).click();
		driver.findElement(By.xpath("//input[@id='applno1']")).sendKeys(getdata("ApplicationNo"));
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(getdata("DateofBirth"));
		// JFrame Dialog = new JFrame();
		// String name = JOptionPane.showInputDialog(Dialog, "Enter Captcha");
		// driver.findElement(By.xpath("//input[@id='captcha']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@value='  SUBMIT  ']")).click();

		Clickon_ProceedtoBookSlotatDlService();
		Booking_SlotforDLServices();
		Clickon_Bookslotbutton();
		try {
			Clickon_Confirm_slotbookingforDLService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* Enquiry of slots */

	@FindBy(how = How.XPATH, using = "//a[text()='Enquiry DL Test Slot']")
	WebElement slotsenq;

	public void Clickon_Enquiry_DLTest_Slot() {
		stepstatus = basepage.clickElement(slotsenq);
		reportEvent(stepstatus, "Able to click Enquiry DL Test Slot", "Unable to click Enquiry DL Test Slot", driver,
				true);
	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Enquiry on DL Services Slot']")
	WebElement slotsenq1;

	public void Clickon_Enquiry_DLServices_Slot() {
		stepstatus = basepage.clickElement(slotsenq1);
		reportEvent(stepstatus, "Able to click Enquiry DL Services Slot", "Unable to click Enquiry DL Services Slot", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='stCode']")
	WebElement stcode;

	public void SelectStateCode(String Option) {
		stepstatus = basepage.setValueInSelectBox(stcode, Option);
		reportEvent(stepstatus, "Able to Select Statename", "Unable to Select Statename", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='rtoCode']")
	WebElement RTOcode;

	public void SelectRTOCode(String Option) {
		stepstatus = basepage.setValueInSelectBox(RTOcode, Option);
		reportEvent(stepstatus, "Able to Select RTOcode", "Unable to Select RTOcode", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='RTO']")
	WebElement RTOradio;
	@FindBy(how = How.XPATH, using = "//input[@value='CAMP']")
	WebElement CAMP;
	@FindBy(how = How.XPATH, using = "//select[@name='slotTypes']")
	WebElement stypes;

	public void Menuitem_Enquiry_DLTest_Slot() {
		Mouserhoveron_Appointments();
		Clickon_Enquiry_DLTest_Slot();
		SelectStateCode(getdata("State"));
		wait(1);
		SelectRTOCode(getdata("RTOCode"));
		wait(1);
		if (getdata("SelectType").trim().equalsIgnoreCase("RTO")) {
			setCheckBox(RTOradio, "ON");
			wait(2);
			driver.findElement(By.xpath("//input[@name='COVorTRANS']")).click();
			setValueInSelectBox(stypes, "0@NormalQuota");
			WebElement eleref = driver.findElement(By.xpath("//input[normalize-space(@value)='PROCEED']"));
			eleref.click();

			wait(1);
			String Note = driver.findElement(By.xpath("//div[@style='color:maroon;text-align:left;font-family:bold']"))
					.getText();
			System.out.println("Note: " + Note);
			setdata("Note", Note);
			List<WebElement> data = driver.findElements(By.xpath("//table[@id='headerTab']/tbody/tr"));
			int size = data.size();
			for (int i = 0; i < size; i++) {
				data = driver.findElements(By.xpath("//table[@id='headerTab']/tbody/tr"));
				String rowdata = data.get(i).getText();
				System.out.println("=============================");
				System.out.println(rowdata);
			}

		} else if (getdata("SelectType").trim().equalsIgnoreCase("CAMP")) {
			setCheckBox(CAMP, "ON");
		} else {
			System.out.println("Wrong Input");
		}
	}
	
	public void Menuitem_Enquiry_DLServices_Slot() {
		Mouserhoveron_Appointments();
		Clickon_Enquiry_DLServices_Slot();
		SelectStateCode(getdata("State"));
		wait(1);
		SelectRTOCode(getdata("RTOCode"));
		wait(1);
		if (getdata("SelectType").trim().equalsIgnoreCase("RTO")) {
			//setCheckBox(RTOradio, "ON");
			wait(2);
			driver.findElement(By.xpath("//input[@name='COVorTRANS']")).click();
			WebElement eleref = driver.findElement(By.xpath("//input[normalize-space(@value)='PROCEED']"));
			eleref.click();
			wait(1);
			String Note = driver.findElement(By.xpath("//div[@style='color:maroon;text-align:left;font-family:bold']"))
					.getText();
			System.out.println("Note: " + Note);
			setdata("Note", Note);
			List<WebElement> data = driver.findElements(By.xpath("//table[@id='headerTab']/tbody/tr"));
			int size = data.size();
			for (int i = 0; i < size; i++) {
				data = driver.findElements(By.xpath("//table[@id='headerTab']/tbody/tr"));
				String rowdata = data.get(i).getText();
				System.out.println("=============================");
				System.out.println(rowdata);
			}

		} else if (getdata("SelectType").trim().equalsIgnoreCase("CAMP")) {
			setCheckBox(CAMP, "ON");
		} else {
			System.out.println("Wrong Input");
		}
	}
	

	@FindBy(how = How.XPATH, using = "//a[text()='Cancel DL Test Slot']")
	WebElement cancelDLSlot;

	public void Clickon_Cancel_DL_Test_Slot() {
		stepstatus = basepage.clickElement(cancelDLSlot);
		reportEvent(stepstatus, "Able to click cancelDLSlot", "Unable to click cancelDLSlot", driver, true);
	}
	@FindBy(how = How.XPATH, using = "(//button[@id = 'btnOk'])[1]")
	WebElement Alert_atleastonecov;

	public void Clickon_Alert_atleastonecov() {
		stepstatus = basepage.clickElement(Alert_atleastonecov);
		reportEvent(stepstatus, "Able to click ON ALERT", "Unable to click ON ALERT", driver, true);
	}
	
	
	
	
	
	public void Menuitem_Cancel_DL_Test_Slot() throws IOException {
		Mouserhoveron_Appointments();
		Clickon_Cancel_DL_Test_Slot();
		driver.findElement(By.xpath("//input[@id='applno']")).sendKeys(getdata("ApplicationNo"));
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(getdata("DateofBirth"));
		driver.findElement(By.xpath("//input[@value='  SUBMIT  ']")).click();
		//GetSecutiryCode(prop.getProperty("SarathiCOVSlotsSecurityCodeLogURL"));
		//wait(2);
		driver.findElement(By.xpath("//input[@value='  CANCEL APPOINTMENTS  ']")).click();
		
		 Clickon_Alert_atleastonecov();
		wait(2);
		driver.findElement(By.xpath("(//input[@name = 'clickMe'])[1]")).click();
		driver.findElement(By.xpath("(//input[@name = 'clickMe'])[2]")).click();
		driver.findElement(By.xpath("//input[@value='  CANCEL APPOINTMENTS  ']")).click();
	    driver.findElement(By.xpath("(//button[@id = 'btnYes'])[1]")).click();
	   
		String Sucessdata = driver.findElement(By.xpath("//h3/text()[1]")).getText();
		setdata("Status", Sucessdata);

	}
	
	@FindBy(how = How.XPATH, using = "//a[text()='Cancel DL Services Slot']")
	WebElement cancelDLServiceSlot;

	public void Clickon_Cancel_DLService_Test_Slot() {
		stepstatus = basepage.clickElement(cancelDLServiceSlot);
		reportEvent(stepstatus, "Able to click cancelDLServiceSlot", "Unable to click cancelDLServiceSlot", driver, true);
	}
	
	public void Menuitem_Cancel_DLServices_Test_Slot() throws IOException  {
		Mouserhoveron_Appointments();
		Clickon_Cancel_DLService_Test_Slot();
		driver.findElement(By.xpath("//input[@id='applno']")).sendKeys(getdata("ApplicationNo"));
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(getdata("DateofBirth"));
		driver.findElement(By.xpath("//input[@value='  SUBMIT  ']")).click();
		GetSecutiryCode(prop.getProperty("SarathiCOVSlotsSecurityCodeLogURL"));
		driver.findElement(By.xpath("(//input[@name = 'clickMe'])[1]")).click();
		//Clickon_Alert_atleastonecov();
		wait(1);
	   //   driver.findElement(By.xpath("//input[@value='  CANCEL APPOINTMENTS  ']")).click();
		
		//Clickon_Alert_atleastonecov();
		//GetSecutiryCode(prop.getProperty("SarathiCOVSlotsSecurityCodeLogURL"));
		wait(2);
		//driver.findElement(By.xpath("(//input[@name = 'clickMe'])[1]")).click();
		driver.findElement(By.xpath("//input[@value='  CANCEL APPOINTMENTS  ']")).click();
		 driver.findElement(By.xpath("(//button[@id = 'btnYes'])[1]")).click();
		//driver.findElement(By.xpath("(//button)[1][text()='YES']")).click();
		String Sucessdata = driver.findElement(By.xpath("//h3/text()[1]")).getText();
		setdata("Status", Sucessdata);

	}

}
