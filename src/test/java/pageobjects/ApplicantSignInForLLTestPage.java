package pageobjects;

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
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;



public class ApplicantSignInForLLTestPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	String nextFlow;
	String password;
	int remainingFlows=0;
	boolean stepstatus;
	
	public ApplicantSignInForLLTestPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}

	public void navigatetonewwindow() throws IOException {
		String env = getdata("ApplicationEnvironment");
		// System.out.println(env);
		if (env.equalsIgnoreCase("SarathiCOV")) {
			loaddata();
			navigate(driver, prop.getProperty("Stall_Staging"));
		} else if (env.equalsIgnoreCase("SarathiProd")) {
			loaddata();
			navigate(driver, prop.getProperty("Stall_Prod"));
		} else {
			System.out.println("URL is not matched.Please try again");
		}

		driver.findElement(By.xpath("//input[@name='llappln']")).sendKeys(getdata("ApplicationNo"));
		driver.findElement(By.xpath("//input[@name='llappln']")).sendKeys(Keys.TAB);
		code = getdata("RTOCode");
		System.out.println("Code we got is: " + code);


		if (driver.getPageSource().contains("Date of Birth")) {
			driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(getdata("DateofBirth"));
			driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(Keys.ESCAPE);
		} else {
			System.out.println("Date of Birth field is not available for the State");
		}
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password.trim());
		wait(2);
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(Keys.ESCAPE);
		// driver.findElement(By.xpath("(//input)[@value='Login'][1]")).click();
		driver.findElement(By.xpath("(//input[@value='Proceed'])[2]")).click();

		driver.findElement(By.xpath("//input[@value = 'CONTINUE']")).click();
	}


	public String Getlogotp(String url) throws IOException {
		// wait(3);
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
				if (strCurrentLine.contains("Generated OTP random code:")) {
					if (strCurrentLine.contains("Generated OTP random code:")) {
						// System.out.println(strCurrentLine.substring(177,184).trim());
						getotp = strCurrentLine.substring(88, 94).trim();
						// System.out.println(getotp);
					}
					count++;
				} else {

				}
			}
			// System.out.println(count);
			System.out.println(getotp);
			driver.switchTo().window(tabs.get(0));
			driver.findElement(By.xpath("//input[@name='sarathiOtp']")).sendKeys(getotp);
			driver.findElement(By.xpath("//input[@name='sarathiOtp']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//input[@value='Authenticate With Sarathi OTP']")).click();
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getotp;
	}

	@FindBy(how = How.XPATH, using = "//select[@name='language']")
	WebElement Language;
	@FindBy(how = How.XPATH, using = "//input[@name='disclaimer']")
	WebElement Check;
	@FindBy(how = How.XPATH, using = "//input[@id='subm']")
	WebElement proceedbutton;

	public void SelectLanguageandPin() throws IOException {
		stepstatus = basepage.setOptionInSelectBox(Language, "ENGLISH");
		WebElement ele = driver.findElement(By.xpath("//input[@name='otp']"));

		if (ele.getAttribute("value").isEmpty()) {
			driver.findElement(By.xpath("//input[@name='otp']")).sendKeys(pinnumber.substring(2).trim());
			driver.findElement(By.xpath("//input[@name='disclaimer1']")).click();
			driver.findElement(By.xpath("//input[@name='disclaimer2']")).click();
			JsclickElement(proceedbutton, driver);
		} else {
			driver.findElement(By.xpath("//input[@name='disclaimer']")).click();
			JsclickElement(proceedbutton, driver);
		}

		// driver.findElement(By.xpath("//input[@id='subm']")).click();
		String env = getdata("ApplicationEnvironment");
		if (env.equalsIgnoreCase("SarathiCOV")) {
			loaddata();
			String ExamStatus = getdata("TestResult");
			if (ExamStatus.equalsIgnoreCase("PASS")) {
				System.out.println("Selected Result as PASS");

				GetAnswerfortheQuestion(prop.getProperty("SarathiCOVeKYCLogURL"));

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

	@FindBy(how = How.XPATH, using = "(//h3)[1]")
	WebElement headertitle;

	public String GetAnswerfortheQuestion(String url) throws IOException {
		// wait(1);
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
						result = strCurrentLine.substring(157).split(",");
						System.out.println(result);

					}
					count++;
				} else {
			
				}
			}

			driver.switchTo().window(tabs.get(0));
			WebElement iframe = driver.findElement(By.xpath("//iframe[@id ='stallexam']"));
			basepage.SwitchtoFrameByElementReference(iframe, driver);
			System.out.println("sucessfully entered into frame");
			outerloop: for (String qns : result) {
				if (driver.getPageSource().contains("This Learner Licence Approved Successfully.") == false) {
					System.out.println("Questions: " + qns);
					String re = qns.replace("[", "");
					question = re.replace("]", "");
					System.out.println("Question Number is: " + question.trim());
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
			basepage.SwitchtoFrameByElementReference(iframe, driver);
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
			basepage.SwitchtoFrameByElementReference(iframe, driver);
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


}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	