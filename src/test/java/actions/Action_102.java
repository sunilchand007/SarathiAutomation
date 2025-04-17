package actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworkLibrary.BasePage;
import pageobjects.DisplayLLPasswordPage;
import pageobjects.LogoutFromRTOPage;
import pageobjects.OnlineTestForLLPage;
import pageobjects.PickCandidateforLLTestPage;
import pageobjects.RTO_LoginHomePage;

public class Action_102 extends BasePage {
WebDriver driver ;


boolean stepstatus;
	public void onlineLLtest() throws IOException {
		
		// Stall
		RTO_LoginHomePage rTO_LoginHomePage = new RTO_LoginHomePage(driver);
		rTO_LoginHomePage.Clickon_Stall();
		rTO_LoginHomePage.Clickon_PickCandidate_for_LLTest();
		// PickCandidate
		PickCandidateforLLTestPage pickCandidateforLLTest = new PickCandidateforLLTestPage(driver);
		pickCandidateforLLTest.Enter_ApplicationNumber();
		pickCandidateforLLTest.Clickon_Submit();
		pickCandidateforLLTest.Clickon_Confirm();
		pickCandidateforLLTest.getPinNumber();
		rTO_LoginHomePage.Clickon_Stall();
		rTO_LoginHomePage.Clickon_DisplayLLTestPassword();
		DisplayLLPasswordPage displayLLPassword = new DisplayLLPasswordPage(driver);
		displayLLPassword.EnterApplicationNumberinDisplayPassword(getdata("ApplicationNo"));
		displayLLPassword.Clickon_SubmitinDisplayPassword();
		displayLLPassword.getLLTestPassword();
		LogoutFromRTOPage logoutFromRTO = new LogoutFromRTOPage(driver);
		logoutFromRTO.Clickon_Logout();
		OnlineTestForLLPage onlineTestForLL = new OnlineTestForLLPage(driver);
		onlineTestForLL.Mouserhoveron_LearnerLicence();
		onlineTestForLL.Clickon_OnlineLLTest();
	}
	@FindBy(how = How.XPATH, using = "//select[@name='app_result']")
	WebElement TestResult;
	public void Set_TestResult(String option) {
		stepstatus = setOptionInSelectBox(TestResult, option);
		reportEvent(stepstatus, "Able to Select TestResult", "Unable to Select TestResult", driver, true);
	}
	@FindBy(how = How.XPATH, using = "//input[@id='submitllOffLine']")
	WebElement Submitbutton;
	@FindBy(how = How.XPATH, using = "(//label)[3]")
	WebElement Afterofflinetestlicno;
	@FindBy(how = How.XPATH, using = "(//label)[4]")
	WebElement alterAfterofflinetestlicno;
	@FindBy(how = How.XPATH, using = "(//table[@class='table table-bordered table-hover'])[1]/tbody/tr[3]/td[2]/b/a")
	WebElement getlic;
	@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
	WebElement Logout;
	public void ClickonbSubmitutton() {
		stepstatus = clickElement(Submitbutton);
		if (isDisplayed(Afterofflinetestlicno) == true) {
			System.out.println("Processing Further Flows");
		}

		else if (isDisplayed(alterAfterofflinetestlicno) == true) {
			RTO_LoginHomePage rto_LoginHomePage = new RTO_LoginHomePage(driver);
			rto_LoginHomePage.Clickon_Misc();
			rto_LoginHomePage.Click_on_applicationstatus();
			rto_LoginHomePage.EnterApplicationNumber(getdata("ApplicationNo"));
			rto_LoginHomePage.Click_on_viewflows();
			System.out.println(getLinkText(getlic));
			setdata("LLNumber", getLinkText(getlic));
			wait(2);
			clickElement(Logout);
			//UpdateLLValidities();
		}

		else {
			NewLLNumber = Afterofflinetestlicno.getText();
			System.out.println(NewLLNumber.trim());
			setdata("LLNumber", NewLLNumber.trim());
			// UpdateLLValidities();

		}

	}
	
	
	@Deprecated
	public void RecordLLTestResults() throws IOException, InterruptedException {

		if (driver.getPageSource().contains("is customized for Online Learner Licence Test")) {
			
			
			//onlinetest.Clickon_Submit_TodisplayLLtestpasword();
			//String password = driver.findElement(By.xpath("//div[@class = 'col-md-3 customAlign']")).getText();
			//System.out.println(password);
			
			/*String env = prop.getProperty("ApplicationURL");
			if (env.equalsIgnoreCase("SarathiCOV")) {
				driver.navigate().to("https://sarathicov.nic.in:8443/sarathiservice/stateSelection.do");
			} else if (env.equalsIgnoreCase("SarathiProd")) {
				driver.navigate().to("https://sarathi.preprod.nic.in/sarathiservice/stateSelection.do");
			} else if (env.equalsIgnoreCase("CAS_SarathiCOV")) {
				driver.navigate().to("https://sarathicov.nic.in:8443/sarathiservice/stateSelection.do");
			} else if (env.equalsIgnoreCase("CAS_SarathiProd")) {
				driver.navigate().to("https://sarathiprod.nic.in/sarathiservice/stateSelection.do");
			} else {
				System.out.println("Navigation URL is not matched at Upload Photo and Signature Flow.Please try again");
			}
			loaddata();
			*/
			//llmodule = new LLModule(driver);
		//	llmodule.SelectState();
		navigatetonewwindow();
			SelectLanguageandPin();
		//	Login();
		//	RTOLevel_Status();
		} else {
		
			Set_TestResult(getdata("TestResult"));
			driver.findElement(By.xpath("//input[@id='llDate']")).sendKeys(GetCurrentDate());
			ClickonbSubmitutton();
			//RTOLevel_Status();
		}

	}
	//div[normalize-space(text())='LL Test Password']/following::div[1]
		String password;
	public void navigatetonewwindow() throws IOException {
		/*String env = prop.getProperty("ApplicationURL");
		 System.out.println(env);
		if (env.equalsIgnoreCase("SarathiCOV")) {
			loaddata();
			navigate(driver, prop.getProperty("Stall_Staging"));
		} else if (env.equalsIgnoreCase("SarathiProd")) {
			loaddata();
			navigate(driver, "https://sarathi.preprod.nic.in/sarathiservice/authenticationaction.do");
		} else {
			System.out.println("URL is not matched.Please try again");
		}*/
           
		driver.findElement(By.xpath("//a[text()=' Learner Licence ']")).click();
		driver.findElement(By.xpath("//a[text() = 'Online LLTest(STALL)']")).click();
		
		driver.findElement(By.xpath("//input[@name='llappln']")).sendKeys(getdata("ApplicationNo"));
	
		driver.findElement(By.xpath("//input[@name='llappln']")).sendKeys(Keys.TAB);
		System.out.println("Entered Application number");
		code = getdata("RTOCode");
		System.out.println("Code we got is: " + code);

//		ConnecttoExcelforS4customrto(prop.getProperty("Verifyappchecks"), prop.getProperty("DataFile_s4customrto"));
//		if (outcome.equalsIgnoreCase("A")) { // AAdhar OTP Page
//
//			env = getdata("ApplicationEnvironment");
//			if (env.equalsIgnoreCase("SarathiCOV")) {
//				loaddata();
//				Getlogotp(prop.getProperty("SarathiCOVeKYCLogURL"));
//			} else if (env.equalsIgnoreCase("SarathiProd")) {
//				loaddata();
//				Getlogotp(prop.getProperty("SarathiprodeKYCLogURL"));
//			} else {
//				System.out.println("Log URL is not matched.Please try again");
//			}
//
//		} else if (outcome.equalsIgnoreCase("F")) { // Application no , Date of birth , Password
		if (driver.getPageSource().contains("Date of Birth")) {
			driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(getdata("DateofBirth"));
			driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(Keys.ESCAPE);
			System.out.println("Date of birth entered");
		} else {
			System.out.println("Date of Birth field is not available for the State");
		}
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password.trim());
		wait(2);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(Keys.ESCAPE);
		System.out.println("Able to enter password");
		// driver.findElement(By.xpath("(//input)[@value='Login'][1]")).click();
		driver.findElement(By.xpath("(//input[@value='Proceed'])[2]")).click();
		System.out.println("Able to click proceed button");

		driver.findElement(By.xpath("//input[@value = 'CONTINUE']")).click();
		System.out.println("Able to click continue button");
	}
	//
//		} else if (outcome.equalsIgnoreCase("S")) { // Sarathi OTP
//			if (driver.getPageSource().contains("Date of Birth")) {
//				driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(getdata("DateofBirth"));
//				driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(Keys.ESCAPE);
//			} else {
//				System.out.println("Date of Birth field is not available for the State");
//			}
//			env = getdata("ApplicationEnvironment");
//			if (env.equalsIgnoreCase("SarathiCOV")) {
//				loaddata();
//				Getlogotp(prop.getProperty("SarathiCOVeKYCLogURL"));
//			} else if (env.equalsIgnoreCase("SarathiProd")) {
//				loaddata();
//				Getlogotp(prop.getProperty("SarathiprodeKYCLogURL"));
//			} else {
//				System.out.println("Log URL is not matched.Please try again");
//			}
//
//		} else if (outcome.equalsIgnoreCase("B")) { // Bio Metrics
//
//		} else if (outcome.equalsIgnoreCase("I")) { // Eye
//
//		} else if (outcome.equalsIgnoreCase("N")) { // Face Authentication
//
//		} else {
//			System.out.println("Please Check values");
//		}
//
//	}
	
	@FindBy(how = How.XPATH, using = "//select[@name='language']")
	WebElement Language;
	@FindBy(how = How.XPATH, using = "//input[@id='subm']")
	WebElement proceedbutton;
	public void SelectLanguageandPin() throws IOException {
		stepstatus = setOptionInSelectBox(Language, "ENGLISH");
		System.out.println("Able to select language");
		WebElement ele = driver.findElement(By.xpath("//input[@name='otp']"));

		if (ele.getAttribute("value").isEmpty()) {
			driver.findElement(By.xpath("//input[@name='otp']")).sendKeys(pinnumber.substring(2).trim());
			System.out.println("Able to enter pinnumber");
			driver.findElement(By.xpath("//input[@name='disclaimer1']")).click();
			System.out.println("Able to check checkbox1");
			driver.findElement(By.xpath("//input[@name='disclaimer2']")).click();
			System.out.println("Able to check checkbox2");
			JsclickElement(proceedbutton, driver);
			System.out.println("Able to click on prceed button ");
		} else {
			driver.findElement(By.xpath("//input[@name='disclaimer']")).click();
			System.out.println(" Able yo check only checkbox 1");
			JsclickElement(proceedbutton, driver);
			System.out.println("Able to click proceed button ");
		}

		// driver.findElement(By.xpath("//input[@id='subm']")).click();
		String env = getdata("ApplicationEnvironment");
		System.out.println("Applicationenvironment is :"+ env);
		if (env.equalsIgnoreCase("SarathiCOV")) {
			loaddata();
			String ExamStatus = getdata("TestResult");
			if (ExamStatus.equalsIgnoreCase("PASS")) {
				System.out.println("Selected Result as PASS");

				GetAnswerfortheQuestion(prop.getProperty("SarathiCOVeKYCLogURLS01"));

			} else if (ExamStatus.equalsIgnoreCase("FAIL")) {
				System.out.println("Selected Result as FAIL");
				TestFailureCase(prop.getProperty("SarathiCOVeKYCLogURL"));
			} else if (ExamStatus.equalsIgnoreCase("EXEMPT")) {
				System.out.println("Selected Result as EXEMPT");
			} else if (ExamStatus.equalsIgnoreCase("PossibleCases")) {
				System.out.println("Selected Possible Cases");
				PossibleCases(prop.getProperty("SarathiCOVeKYCLogURL"));
			}

		} else if (env.equalsIgnoreCase("SarathiProd")) {
			loaddata();
			String ExamStatus = getdata("TestResult");
			if (ExamStatus.equalsIgnoreCase("PASS")) {
				System.out.println("Selected Result as PASS");
				GetAnswerfortheQuestion(prop.getProperty("SarathiprodeKYCLogURL"));
			} else if (ExamStatus.equalsIgnoreCase("FAIL")) {
				System.out.println("Selected Result as FAIL");
				TestFailureCase(prop.getProperty("SarathiprodeKYCLogURL"));
			} else if (ExamStatus.equalsIgnoreCase("EXEMPT")) {
				System.out.println("Selectrd Result as EXEMPT");
			} else if (ExamStatus.equalsIgnoreCase("PossibleCases")) {
				System.out.println("Selected Possible Cases");
				PossibleCases(prop.getProperty("SarathiprodeKYCLogURL"));
			}

		} else {
			System.out.println("Log URL is not matched.Please try again");
		}

	}

	
	public String GetAnswerfortheQuestion(String url) throws IOException {
		// wait(1);
		System.out.println("Entered into GetAnswerfortheQuestion");
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
		String[] result = null;
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String strCurrentLine;
			int count = 0;
			System.out.println("count is : " + count);
			while ((strCurrentLine = br.readLine()) != null) {
				if (strCurrentLine.contains("question list from db------->>>>>>>>>>")) {
					if (strCurrentLine.contains("question list from db------->>>>>>>>>>")) {

						int indx = strCurrentLine.indexOf("[");
						System.out.println("Index is : " + indx );
						result = strCurrentLine.substring(157).split(",");
						System.out.println("Result is :" + result);

					}
					count++;
				} else {
					// System.out.println("#######################Pleasae Check OTP
					// Section###########################");
				}
			}

			driver.switchTo().window(tabs.get(0));
			WebElement iframe = driver.findElement(By.xpath("//iframe[@id ='stallexam']"));
			SwitchtoFrameByElementReference(iframe, driver);
			System.out.println("sucessfully entered into frame");
			outerloop: for (String qns : result) {
				if (driver.getPageSource().contains("This Learner Licence Approved Successfully.") == false) {
					System.out.println("Questions: " + qns);
					String re = qns.replace("[", "");
					question = re.replace("]", "");
					System.out.println("Question Number is: " + question.trim());
//					String sub =qns.substring(85);
//					System.out.println(sub);
					// String re = sub.replace("[", "");
					//question = re.replace("]", "");
					//System.out.println("Question Number is: " + question.trim());
					ConnecttoExcelforStallExamAnswer(prop.getProperty("Ansbank"), prop.getProperty("DataFile_Stall"));
					
					switch (Integer.valueOf(outcome)) {
					case 1:

						try {

							if (driver.getPageSource().contains("LL Stall Exam Result") == true) {
								if (driver.findElement(By.xpath("(//h3)[4]")).isDisplayed() == true) {
									NewLLNumber = driver.findElement(By.xpath("(//h3)[4]")).getText();
									System.out.println(NewLLNumber.substring(23).trim());
									setdata("LLNumber", NewLLNumber.substring(23).trim());
									break outerloop;
								} else {
									System.out.println("There is no Test at approval check");
									break outerloop;
								}

							} else {

								
								driver.findElement(By.xpath("//input[@id = 'stallradio1']")).click();
								driver.findElement(By.xpath("//input[@id='confirmbut']")).click();
								wait(2);
								break;
							}

						} catch (NoSuchElementException e) {

							System.out.println("Case 1 Exception");
							System.out.println(e);
							break outerloop;
							// String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
							// System.out.println(LicTxt.substring(23).trim());
							// setdata("LLNumber", LicTxt.substring(23).trim());
							// break;
						} catch (StaleElementReferenceException e) {
							System.out.println("Stale Element Ref");
						}

					case 2:
						try {

							if (driver.getPageSource().contains("LL Stall Exam Result") == true) {
								if (driver.findElement(By.xpath("(//h3)[4]")).isDisplayed() == true) {
									String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
									System.out.println(LicTxt.substring(23).trim());
									setdata("LLNumber", LicTxt.substring(23).trim());
									break outerloop;
								} else {
									System.out.println("There is no Test at approval check");
									break outerloop;
								}

							} else {
								

								driver.findElement(By.xpath("//input[@id = 'stallradio2']")).click();
								driver.findElement(By.xpath("//input[@id='confirmbut']")).click();
								wait(2);
								break;
							}

						} catch (NoSuchElementException e) {
							System.out.println("Case 2 Exception");
							System.out.println(e);
							break outerloop;
							// String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
							// System.out.println(LicTxt.substring(23).trim());
							// setdata("LLNumber", LicTxt.substring(23).trim());
							// break;
						} catch (StaleElementReferenceException e) {
							System.out.println("Stale Element Ref");
						}

					case 3:
						try {
							if (driver.getPageSource().contains("LL Stall Exam Result") == true) {
								if (driver.findElement(By.xpath("(//h3)[4]")).isDisplayed() == true) {
									String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
									System.out.println(LicTxt.substring(23).trim());
									setdata("LLNumber", LicTxt.substring(23).trim());
									break outerloop;
								} else {
									System.out.println("There is no Test at approval check");
									break outerloop;
								}

							} else {
								

								driver.findElement(By.xpath("//input[@id = 'stallradio3']")).click();
								driver.findElement(By.xpath("//input[@id='confirmbut']")).click();
								wait(2);
								break;
							}

						} catch (NoSuchElementException e) {
							System.out.println("Case 3 Exception");
							System.out.println(e);
							break outerloop;
							// String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
							// System.out.println(LicTxt.substring(23).trim());
							// setdata("LLNumber", LicTxt.substring(23).trim());
							// break;
						} catch (StaleElementReferenceException e) {
							System.out.println("Stale Element Ref");
						}

					case 4:
						try {
							if (driver.getPageSource().contains("LL Stall Exam Result") == true) {
								if (driver.findElement(By.xpath("(//h3)[4]")).isDisplayed() == true) {
									String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
									System.out.println(LicTxt.substring(23).trim());
									setdata("LLNumber", LicTxt.substring(23).trim());
									break outerloop;
								} else {
									System.out.println("There is no Test at approval check");
									break outerloop;
								}

							} else {
								
								driver.findElement(By.xpath("//input[@id = 'stallradio4']")).click();
								driver.findElement(By.xpath("//input[@id='confirmbut']")).click();
								wait(2);
								break;
							}

						} catch (NoSuchElementException e) {
							System.out.println("Case 4 Exception");
							System.out.println(e);
							break outerloop;
							// String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
							// System.out.println(LicTxt.substring(23).trim());
							// setdata("LLNumber", LicTxt.substring(23).trim());
							// break;
						} catch (StaleElementReferenceException e) {
							System.out.println("Stale Element Ref");
						}

					default:
						System.out.println("No Option available to Select");
						break;

					}
				} else {
					System.out.println("Else block Statement");
					String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
					System.out.println(LicTxt.substring(23).trim());
					setdata("LLNumber", LicTxt.substring(23).trim());
				}

			}
			driver.switchTo().defaultContent();
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outcome;
	}
	

	public String TestFailureCase(String url) throws IOException {
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
		String[] result = null;
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String strCurrentLine;
			int count = 0;
			while ((strCurrentLine = br.readLine()) != null) {
				if (strCurrentLine.contains("question list from db------->>>>>>>>>>")) {
					if (strCurrentLine.contains("question list from db------->>>>>>>>>>")) {

						int indx = strCurrentLine.indexOf("[");
						result = strCurrentLine.substring(indx).split(",");

						count++;
					} else {
						// System.out.println("#######################Pleasae Check OTP
						// Section###########################");
					}
				}

			}
			driver.switchTo().window(tabs.get(0));
			WebElement iframe = driver.findElement(By.xpath("//iframe[@id ='stallexam']"));
			SwitchtoFrameByElementReference(iframe, driver);
			System.out.println("sucessfully entered into frame");
			for (String qns : result) {
				// System.out.println("Questions: " + qns);
				String re = qns.replace("[", "");
				question = re.replace("]", "");
				System.out.println("Question Number is: " + question.trim());
				ConnecttoExcelforStallExamAnswer(prop.getProperty("Ansbank"), prop.getProperty("DataFile_Stall"));
				switch (Integer.valueOf(outcome)) {
				case 1:
					driver.findElement(By.xpath("//input[@value='1']")).click();
					driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
					wait(2);
					break;
				case 2:
					driver.findElement(By.xpath("//input[@value='1']")).click();
					driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
					wait(2);
					// driver.switchTo().window(tabs.get(1));
					// driver.navigate().refresh();
					break;
				case 3:
					driver.findElement(By.xpath("//input[@value='1']")).click();
					driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
					wait(2);
					break;
				case 4:
					driver.findElement(By.xpath("//input[@value='1']")).click();
					driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
					wait(2);
					break;

				default:
					System.out.println("No Option available to Select");
					break;

				}

			}
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outcome;
	}

	public String PossibleCases(String url) throws IOException {
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
		String[] result = null;
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String strCurrentLine;
			int count = 0;
			while ((strCurrentLine = br.readLine()) != null) {
				if (strCurrentLine.contains("question list from db------->>>>>>>>>>")) {
					if (strCurrentLine.contains("question list from db------->>>>>>>>>>")) {

						int indx = strCurrentLine.indexOf("[");
						result = strCurrentLine.substring(indx).split(",");

						count++;
					} else {
						// System.out.println("#######################Pleasae Check OTP
						// Section###########################");
					}
				}

			}
			driver.switchTo().window(tabs.get(0));
			WebElement iframe = driver.findElement(By.xpath("//iframe[@id ='stallexam']"));
			SwitchtoFrameByElementReference(iframe, driver);
			System.out.println("sucessfully entered into frame");
			for (String qns : result) {
				// System.out.println("Questions: " + qns);
				String re = qns.replace("[", "");
				question = re.replace("]", "");
				System.out.println("Question Number is: " + question.trim());
				ConnecttoExcelforStallExamAnswer(prop.getProperty("Ansbank"), prop.getProperty("DataFile_Stall"));
				switch (Integer.valueOf(outcome)) {
				case 1:
					driver.findElement(By.xpath("//input[@value='1']")).click(); // Right Answer With Confirm button
					driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
					wait(2);
					break;
				case 2:
					driver.findElement(By.xpath("//input[@value='2']")).click(); // Right Answer Without Confirm button
					wait(2);
					break;
				case 3:
					driver.findElement(By.xpath("//input[@value='1']")).click(); // Wrong Answer with Confirm button
					driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
					wait(2);
					break;
				default:
					System.out.println("No Option available to Select");
					break;

				}

			}
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outcome;
	}

}
