package pageobjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import utility.Flows;

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

public class LLSlotBookingPageeOLD extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;
	ApplicationStatusStage01Page applicationStatusstage01;
	Action_215 action_215;

	public LLSlotBookingPageeOLD(WebDriver driver) {
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
	@FindBy(how = How.XPATH, using = "//input[@id='applNum']")
	WebElement Application_Number;
	@FindBy(how = How.XPATH, using = "//input[@name='dateOfBirth']")
	WebElement DateofBirth;
	@FindBy(how = How.XPATH, using = "//input[@id='submit']")
	WebElement Submit;
	@FindBy(how = How.XPATH, using = "//button[@id='applViewStages_0']")
	WebElement Proceed;
	@FindBy(how = How.XPATH, using = "//input[@id='dispappldetform_PROCEEDTOBOOK']")
	WebElement ProceedtoBookSlot;
	@FindBy(how = How.XPATH, using = "//button[@id='slotbtn']")
	WebElement Bookslot;
	@FindBy(how = How.XPATH, using = "//button[@id='slotcnfrmbtn']")
	WebElement Confirm_slotbook;
	@FindBy(how = How.XPATH, using = "//input[@value='NEXT']")
	WebElement Next;
	@FindBy(how = How.XPATH, using = "//input[@value='HOME']")
	WebElement Home;
	@FindBy(how = How.XPATH, using = "//input[@value='LL TEST SLOT BOOKING']")
	WebElement Clickradio;

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

	public void Do_ScrollDown() {
		stepstatus = basepage.scrooldown(driver);
		reportEvent(stepstatus, "Able to do Scrolldown", "Unable to do Scrolldown", driver, true);
	}

	@FindBy(how = How.XPATH, using = "(//div[@id='dialog'])[1]/div[2]")
	WebElement ValidationCheck;
	@FindBy(how = How.XPATH, using = "(//button[@id='btnOk'])[1]")
	WebElement Okbutton;
	@FindBy(how = How.XPATH, using = "//a[text()='SarathiOnWeb']")
	WebElement lnkSarathionWeb;
	@FindBy(how = How.XPATH, using = "//input[@value='Refresh']")
	WebElement Refreshbtn;

	public void Clickon_Proceed_Button() throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		if (basepage.clickElement(Clickradio)) {
			stepstatus = basepage.clickElement(Proceed);
			if (isDisplayed(ValidationCheck) && ValidationCheck.getText()
					.equalsIgnoreCase("Previous flows need to be completed to go for slot booking")) {
				Okbutton.click();
				lnkSarathionWeb.click();
				action_215 = new Action_215(driver);
				action_215.applicationstatus();
				Refreshbtn.click();
				Flows validate = new Flows(driver);
				try {
					validate.VerifyFlows();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Processing Further Steps");
			}

			String PageTitle = driver.getTitle();
			System.out.println(PageTitle);
			if (PageTitle.equalsIgnoreCase("Sending SMS")) {
				String env = getdata("ApplicationEnvironment");
				if (env.equalsIgnoreCase("SarathiCOV")) {
					loaddata();
					GetSecutiryCode(prop.getProperty("SarathiCOVSlotsSecurityCodeLogURL"));
				} else if (env.equalsIgnoreCase("SarathiProd")) {
					loaddata();
					GetSecutiryCode(prop.getProperty("SarathiprodSlotsSecurityCodeLogURL"));
				} else {
					System.out.println("Log URL is not matched.Please try again");
				}
				Clickon_ProceedtoBookSlot_Button();
			} else {
				Clickon_ProceedtoBookSlot_Button();
			}

		}
	}

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
				if (strCurrentLine.contains("securityCd")) {
					if (strCurrentLine.contains("securityCd")) {

						//getotp = strCurrentLine.substring(147, 153).trim();

					//	getotp = strCurrentLine.substring(148,154).trim();

						getotp = strCurrentLine.substring(145,151).trim();

						// System.out.println(getotp);
					}
					count++;
				} else {
					// System.out.println("#######################Please Check OTP
					// Section###########################");
				}
			}
			// System.out.println(count);
			System.out.println(getotp);
			driver.switchTo().window(tabs.get(0));
			driver.findElement(By.xpath("//input[@id='smsCode']")).sendKeys(getotp);
			// driver.findElement(By.xpath("//input[@id='securityForm_smsCode']")).sendKeys(Keys.TAB);
			// driver.findElement(By.xpath("//input[@id='securityForm__submitSecurityCode']")).click();
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getotp;
	}

	public void Booking_Slot() {
		List<WebElement> GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green NALOC']"));
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
			wait(1);
			WebElement lstdaymnth = driver.findElement(By.xpath("//table/tbody/tr/td[@class='cal_green NALOC']"));
		
			String textlstday = lstdaymnth.getText();
			System.out.println("Last Working day of the month is: " + textlstday);
			lstdaymnth.click();

			Timeslots = driver.findElements(By.xpath(
					"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr/td[1]"));
			timeslots = Timeslots.size();
			System.out.println(timeslots);

			loop: for (int j = 0; j < timeslots; j++) {
				Timeslots = driver.findElements(By.xpath(
						"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr/td[1]"));
				eletimeslot = Timeslots.get(j);
				timeslottxt = eletimeslot.getText();
				seatslabel = driver.findElement(By.xpath(
						"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr[" + 1
								+ "+" + j + "]/td[2]/label"));
				seatstxt = seatslabel.getText();
				if (!seatstxt.equalsIgnoreCase("0")) {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
					driver.findElement(By.xpath(
							"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr["
									+ 1 + "+" + j + "]/td[2]/input"))
							.click();

					break loop;
				} else {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);

				}
			}
			try {
				boolean verifybtnenabled = driver.findElement(By.xpath("//button[@id='slotbtn']")).isEnabled();
				if (verifybtnenabled == false) {
					driver.findElement(By.xpath("//a[normalize-space(text())='Next']")).click();
					outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
						GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green NALOC']"));
						

						TotalGreenColorDates = GreenColorDates.get(i);
						Datestext = TotalGreenColorDates.getText();
						System.out.println(Datestext);
						GreenColorDates.get(i).click();
						Timeslots = driver.findElements(By.xpath(
								"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr/td[1]"));
						timeslots = Timeslots.size();
						System.out.println(timeslots);

						for (int k = 0; k < timeslots; k++) {
							eletimeslot = Timeslots.get(k);
							timeslottxt = eletimeslot.getText();
							seatslabel = driver.findElement(By.xpath(
									"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr["
											+ 1 + "+" + k + "]/td[2]/label"));
							seatstxt = seatslabel.getText();
							if (!seatstxt.equalsIgnoreCase("0")) {
								System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
								driver.findElement(By.xpath(
										"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr["
												+ 1 + "+" + k + "]/td[2]/input"))
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
				//this is previous xpath 
//				Timeslots = driver.findElements(By.xpath(
//						"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr/td[1]"));
				Timeslots = driver.findElements(By.xpath("//input[@name = 'timeForDisp']"));
				timeslots = Timeslots.size();
				System.out.println(timeslots);

				for (int j = 0; j < timeslots; j++) {
					eletimeslot = Timeslots.get(j);
					timeslottxt = eletimeslot.getText();
					seatslabel = driver.findElement(By.xpath(
							"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr["
								+ 1 + "+" + j + "]/td[2]/label"));
					
					
					seatstxt = seatslabel.getText();
					if (!seatstxt.equalsIgnoreCase("0")) {
						System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
						driver.findElement(By.xpath(
								"//table[@class='table table-bordered table-striped table-hover NALOC']//following-sibling::tr["
										+ 1 + "+" + j + "]/td[2]/input"))
								.click();

						break outerloop;
					} else {
						System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
					}

				}

			}

		}
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
		String env = prop.getProperty("ApplicationURL");
		if (env.equalsIgnoreCase("SarathiCOV")) {
			loaddata();
			GetSecutiryCode(prop.getProperty("Staging_Slots_Log"));
			stepstatus = basepage.clickElement(Confirm_slotbook);
			wait(1);
			String title = driver.getTitle();
			if (title.equals("Home")) {
		//		setdata("IPAddress", getIPAddress());
				setdata("StatusofLLSlotBooking", "Success");
			} else {
				setdata("StatusofLLSlotBooking", "Fail");
			}
		} else if (env.equalsIgnoreCase("SarathiProd")) {
			loaddata();
			GetSecutiryCode(prop.getProperty("Preprod_Slots_Log"));
			stepstatus = basepage.clickElement(Confirm_slotbook);
			wait(1);
			String title = driver.getTitle();
			if (title.equals("Home")) {
		//		setdata("IPAddress", getIPAddress());
				setdata("StatusofLLSlotBooking", "Success");
			} else {
				setdata("StatusofLLSlotBooking", "Fail");
			}
		} else if (env.equalsIgnoreCase("Sarathinewstaging")) {
			loaddata();
			GetSecutiryCode(prop.getProperty("Sarathinewstagingslotslogurl"));
			stepstatus = basepage.clickElement(Confirm_slotbook);
			wait(1);
			String title = driver.getTitle();
			if (title.equals("Home")) {
		//		setdata("IPAddress", getIPAddress());
				setdata("StatusofLLSlotBooking", "Success");
			} else {
				setdata("StatusofLLSlotBooking", "Fail");
			}
		} else if (env.equalsIgnoreCase("Sarathilocal")) {
			loaddata();
			GetSecutiryCode(prop.getProperty("Sarathilocalslotslogurl"));
			stepstatus = basepage.clickElement(Confirm_slotbook);
			wait(1);
			String title = driver.getTitle();
			if (title.equals("Home")) {
		//		setdata("IPAddress", getIPAddress());
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

	public void Clickon_Next() {
		stepstatus = basepage.clickElement(Next);
		reportEvent(stepstatus, "Able to click Next", "Unable to  click Next", driver, true);
	}

	public void Clickon_Home() {
		stepstatus = basepage.clickElement(Home);
		reportEvent(stepstatus, "Able to click Home", "Unable to  click Home", driver, true);
	}

	public static String GetCurrentDatea() throws ParseException {

		Date myDate = new Date();
		String date = new SimpleDateFormat("dd").format(myDate);
		System.out.println(date);
		return date;
	}

	public void BookLLSlot() throws ParseException {

		List<WebElement> GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green']"));
		int TotalAvailbleGreenColorDates = GreenColorDates.size();
		System.out.println("Available Dates: " + TotalAvailbleGreenColorDates);
		for (WebElement TotalGreenColorDates : GreenColorDates) {

			String Datestext = TotalGreenColorDates.getText();
			if (Datestext.contains(GetCurrentDate())) {
				System.out.println("****Todays date is availble in the current list****");
				TotalGreenColorDates.click();

			} else {

				System.out.println("****Todays date is not available in the availble list****");
			}

		}

	}

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
		
		stepstatus = basepage.mouseHover(Appointments, driver);
		reportEvent(stepstatus, "Able to do Mousehover action on Appointments",
				"Unable to do Mousehover action on Appointments", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='LL Test Slot Booking']")
	WebElement slotbookingLLTest;

	public void Clickon_Slot_Booking_LL_Test() {
		stepstatus = basepage.clickElement(slotbookingLLTest);
		reportEvent(stepstatus, "Able to click Slot_Booking_LL_Test", "Unable to click Slot_Booking_LL_Test", driver,
				true);
	}

	public void Menuitem_Slot_Booking_LLTest() throws InterruptedException {
		driver.findElement(By.xpath("(//button[@class='close popupclose'])[2]")).click();
		Mouserhoveron_Appointments();
		Clickon_Slot_Booking_LL_Test();
		// driver.findElement(By.xpath("//input[@name='subtype']")).click();
		driver.findElement(By.xpath("//input[@id='applno1']")).sendKeys(getdata("ApplicationNo"));
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(getdata("DateofBirth"));
		// JFrame Dialog = new JFrame();
		// String name = JOptionPane.showInputDialog(Dialog, "Enter Captcha");
		// driver.findElement(By.xpath("//input[@id='captcha']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@value='  SUBMIT  ']")).click();
		try {
			Clickon_ProceedtoBookSlot_Button();
			Booking_Slot();
			Clickon_Bookslotbutton();
			if (driver.getPageSource().contains(
					"You have already taken appointment from this machine. Please take another appointment after 5 minutes.")) {
				System.out.println("Waiting for 5 min to start next process");
				Thread.sleep(300000 / 1000);
				Slots_After_5min_and_otpmissinffound_Subcases();
			} else {
				System.out.println("Inside logic of Menuitem_Slot_Booking_LLTest");
				Clickon_Confirm_slotbookingbutton();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FindBy(how = How.XPATH, using = "//a[text()='Slot Booking ']")
	WebElement hovertoSlotbooking;
	@FindBy(how = How.XPATH, using = "//li[@class='dropdown']/ul/li/a[text()='LLTest Slot Booking']")
	WebElement clickLLSlotBookingitem;

	public void Slots_After_5min_and_otpmissinffound_Subcases() {
		mouseHover(hovertoSlotbooking, driver);
		clickElement(clickLLSlotBookingitem);
		driver.findElement(By.xpath("//input[@id='applno1']")).sendKeys(getdata("ApplicationNo"));
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(getdata("DateofBirth"));
		// JFrame Dialog = new JFrame();
		// String name = JOptionPane.showInputDialog(Dialog, "Enter Captcha");
		// driver.findElement(By.xpath("//input[@id='captcha']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@value='  SUBMIT  ']")).click();
		try {
			Clickon_ProceedtoBookSlot_Button();
			Booking_Slot();
			Clickon_Bookslotbutton();
			Clickon_Confirm_slotbookingbutton();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Enquiry of slots */

	@FindBy(how = How.XPATH, using = "//a[text()='Enquiry LL Test Slot']")
	WebElement slotsenq;

	public void Clickon_Enquiry_LLTest_Slot() {
		stepstatus = basepage.clickElement(slotsenq);
		reportEvent(stepstatus, "Able to click Enquiry LL Test Slot", "Unable to click Enquiry LL Test Slot", driver,
				true);
	}

	@FindBy(how = How.XPATH, using = "//select[@name='stCode']")
	WebElement stcode;

	public void SelectStateCode(String Option) {
		stepstatus = basepage.setValueInSelectBox(stcode, Option);
		reportEvent(stepstatus, "Able to Select Statename", "Unable to Select Statename", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Cancel LL Test Slot']")
	WebElement cancelLLSlot;

	public void Clickon_Cancel_LL_Test_Slot() {
		stepstatus = basepage.clickElement(cancelLLSlot);
		reportEvent(stepstatus, "Able to click cancelLLSlot", "Unable to click cancelLLSlot", driver, true);
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

	public void Menuitem_Enquiry_LLTest_Slot() {
		
		
		Mouserhoveron_Appointments();
		Clickon_Enquiry_LLTest_Slot();
		SelectStateCode(getdata("State"));
		wait(1);
		SelectRTOCode(getdata("RTOCode"));
		wait(1);
		if (getdata("SelectType").trim().equalsIgnoreCase("RTO")) {
			setCheckBox(RTOradio, "ON");
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

	public void Menuitem_Cancel_LL_Test_Slot() {
		Mouserhoveron_Appointments();
		Clickon_Cancel_LL_Test_Slot();
		driver.findElement(By.xpath("//input[@id='applno']")).sendKeys(getdata("ApplicationNo"));
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(getdata("DateofBirth"));
		driver.findElement(By.xpath("//input[@value='  SUBMIT  ']")).click();
		driver.findElement(By.xpath("//input[@value='  CANCEL APPOINTMENT  ']")).click();
		wait(2);
		driver.findElement(By.xpath("(//button)[1][text()='YES']")).click();
		String Sucessdata = driver.findElement(By.xpath("//h3/text()[1]")).getText();
		setdata("Status", Sucessdata);

	}

}
