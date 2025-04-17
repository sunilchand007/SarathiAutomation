package pageobjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import frameworkLibrary.BasePage;

public class UploadDocumentsPageOLD extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public UploadDocumentsPageOLD(WebDriver driver) {
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
	@FindBy(how = How.XPATH, using = "//input[@name='applicationNum']")
	WebElement Application_Number;
	@FindBy(how = How.XPATH, using = "//input[@name='dateOfBirth']")
	WebElement DateofBirth;
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement Submit;
	@FindBy(how = How.XPATH, using = "//input[@id='submitbtn']")
	WebElement Submit1;
	@FindBy(how = How.XPATH, using = "//input[@value='UPLOAD DOCUMENTS']")
	WebElement Clickradio;
	@FindBy(how = How.XPATH, using = "//button[@id='applViewStages_0']")
	WebElement Proceed;
	@FindBy(how = How.XPATH, using = "//input[@name='method:displayDocuments']")
	WebElement Ok;
	@FindBy(how = How.XPATH, using = "//select[@name='documentType']")
	WebElement Document;
	@FindBy(how = How.XPATH, using = "//select[@name='relatedDocuments']")
	WebElement Proof;
	@FindBy(how = How.XPATH, using = "//div[@class='col-md-8']/div/input[1]")
	WebElement Choosefile;
	@FindBy(how = How.XPATH, using = "//input[@id='upload']")
	WebElement Upload;
	@FindBy(how = How.XPATH, using = "//input[@name='method:confirm']")
	WebElement Confirm;
	@FindBy(how = How.XPATH, using = "//button[@value='Next']")
	WebElement Next;
	@FindBy(how = How.XPATH, using = "//*[@id=\"accepted\"]")
	WebElement SelectCheckBoxInUploaddocument;
	
	public void SelectCheckBoxInUploaddocument() {
		stepstatus = basepage.clickElement(SelectCheckBoxInUploaddocument);
		reportEvent(stepstatus, "Able to click on Select CheckBox In Uploaddocument", "Unable to click on Select CheckBox In Uploaddocument", driver, true);
	}
	// Related methods to perform operation on webelements

	public String Getlogotp(String url) throws IOException {

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

				if (strCurrentLine.contains("OTP msg -->OTP (One Time Password) for Application Status is")) {
					if (strCurrentLine.contains("OTP msg -->OTP (One Time Password) for Application Status is")) {

						// System.out.println(strCurrentLine.substring(136,142).trim());
						getotp = strCurrentLine.substring(136, 142).trim();
						// System.out.println(getotp);

					}
					count++;
				} else {

				}

			}

			// System.out.println(count);
			System.out.println(getotp);

			driver.switchTo().window(tabs.get(0));

			driver.findElement(By.xpath("//input[@name='mobEnteredOtp']")).sendKeys(getotp);
			driver.findElement(By.xpath("//input[@name='Verify']")).click();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return getotp;
	}

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
		reportEvent(stepstatus, "Able to click submit button", "Unable to click submit button", driver);
	}

	public void Clickon_Submit1_Button() {
		stepstatus = basepage.clickElement(Submit1);
		reportEvent(stepstatus, "Able to click submit1 button", "Unable to click submit1 button", driver);
	}

	public void Do_ScrollDown() {
		stepstatus = basepage.scrooldown(driver);
		reportEvent(stepstatus, "Able to do Scrolldown", "Unable to do Scrolldown", driver, true);
	}

	public void Clickon_Proceed_Button() {

		if (basepage.isSelected(Clickradio)) {

			stepstatus = basepage.clickElement(Proceed);
			reportEvent(stepstatus, "Able to click Proceed button", "Unable to click Proceed button", driver, true);

		} else {

			stepstatus = basepage.clickElement(Clickradio);
			stepstatus = basepage.clickElement(Proceed);

		}

	}

	List<WebElement> options;

	public void Clickon_ok_Button() throws IOException, InterruptedException {
		// driver.findElement(By.xpath("//input[@name='checkMe']")).click();

		stepstatus = basepage.clickElement(Ok);
		if (driver.getPageSource().contains("All Documents are Uploaded Successfully")) {
			setdata("StatusofUploadDocumets", "All Documents are Uploaded Successfully");
		} else {
			System.out.println("Processing Upload Documents");
			WebElement DocumentType = driver.findElement(By.xpath("//select[@name='documentType']"));
			Select Doc = new Select(DocumentType);
			List<WebElement> options = Doc.getOptions();
			int op = options.size();
			System.out.println("No of Documents :" + op);
		
			for (int i = 0; i <= options.size(); i++) {
				try {
					DocumentType = driver.findElement(By.xpath("//select[@name='documentType']"));
					Doc = new Select(DocumentType);
					options = Doc.getOptions();

					if (!options.get(1).getText().contains("Select")) {
						
						System.out.println("Document to uplaod is "+options.get(1).getText());
						Doc.selectByIndex(1);
						wait(3);
						WebElement ProofDocument = driver.findElement(By.xpath("//select[@name='relatedDocuments']"));
						Select Proof = new Select(ProofDocument);
						List<WebElement> Proofoptions = Proof.getOptions();
					
						System.out.println( "Proof to uplaod : " + Proofoptions.get(1).getText());
						Proofoptions.get(1).getText();
						if (Proof.getOptions().size() > 1
								&& !Proof.getOptions().get(1).getText().toLowerCase().contains("select")) {
							Proof.selectByIndex(1);
							if (alertExist(driver)) {
								acceptAlert(driver);
								Clickon_Choosefile_Button1();
								if (driver.getPageSource().contains("All Documents are Uploaded Successfully")) {
									String ftext = Sucess.getText();
									if (ftext.equals("All Documents are Uploaded Successfully")) {
										setdata("StatusofUploadDocumets", "All Documents are Uploaded Successfully");
										break;
									} else {
										setdata("StatusofUploadDocumets", "Fail");
									}

								}
							} else {
								Clickon_Choosefile_Button1();
								if (driver.getPageSource().contains("All Documents are Uploaded Successfully")) {
									String ftext = Sucess.getText();
									if (ftext.equals("All Documents are Uploaded Successfully")) {
										setdata("StatusofUploadDocumets", "All Documents are Uploaded Successfully");
										break;
									} else {
										setdata("StatusofUploadDocumets", "Fail");
									}
								}
							}
						}

					} else {
						System.out.println("Else block....: " + options.get(1).getText());
					}

				} catch (StaleElementReferenceException f) {
					f.printStackTrace();
				} catch (IndexOutOfBoundsException e) {
					System.out.println(e.getMessage());
				} catch (NoSuchElementException e) {
					e.printStackTrace();
				} catch (Exception e) {
					System.out.println(e.getMessage());

				}

			}
		}

		Clickon_Next_Button();

	}

	public void Clickon_Choosefile_Button1() throws IOException {
		wait(1);
		driver.findElement(By.xpath("//div[@class='col-md-8']/div/input[1]"))
				.sendKeys(System.getProperty("user.dir") + "\\SampleUploadFiles\\Report.pdf");

		/* PDF 3kb file */

		// driver.findElement(By.xpath("//div[@class='col-md-8']/div/input[1]"))
		// .sendKeys(System.getProperty("user.dir") +
		// "\\SampleUploadFiles\\TestPDF3kb.pdf");

		/* PDF 1mb file */

		// driver.findElement(By.xpath("//div[@class='col-md-8']/div/input[1]"))
		// .sendKeys(System.getProperty("user.dir") +
		// "\\SampleUploadFiles\\TestPDF1mb.pdf");

		driver.findElement(By.xpath("//input[@id='upload']")).click();
		if (alertExist(driver)) {
			acceptAlert(driver);
			/*driver.findElement(By.xpath("//input[@name = 'certificateNumber']")).sendKeys("1");
			driver.findElement(By.xpath("//input[@id = 'issuedAuthDesg']")).sendKeys("Doctor harish");
			driver.findElement(By.xpath("//input[@id = 'issuedDate']")).sendKeys("01-01-2023");
			driver.findElement(By.xpath("//input[@id = 'remarksContact']")).sendKeys("8008569531");
			driver.findElement(By.xpath("//input[@id='upload']")).click();*/
		}
		else {
			
			System.out.println("There is no alert");
		}
		
		try {
			driver.findElement(By.xpath("//input[@id='confirm']")).click();
			wait(1);
			if (alertExist(driver)) {
				acceptAlert(driver);
				driver.findElement(By.xpath("//input[@id='confirm']")).click();
			} else {
				System.out.println("There is no alert present");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@FindBy(how = How.XPATH, using = "//label[text()='All Documents are Uploaded Successfully']")
	WebElement Sucess;

	public void Clickon_Next_Button() {
		stepstatus = basepage.clickElement(Next);
		reportEvent(stepstatus, "Able to click Next button", "Unable to click Next button", driver, true);

	}

	@FindBy(how = How.XPATH, using = "//select[@name='stName']")
	WebElement SelectStatename;

	public void SelectStatename(String Option) {
		stepstatus = basepage.setOptionInSelectBox(SelectStatename, Option);
		reportEvent(stepstatus, "Able to Select Statename", "Unable to Select Statename", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()=' Upload Document ']")
	WebElement UploadDoc;

	public void Mouserhoveron_UploadDocument() {
		stepstatus = basepage.mouseHover(UploadDoc, driver);
		reportEvent(stepstatus, "Able to do Mousehover action on Upload Document",
				"Unable to do Mousehover action on Upload Document", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Upload Documents/ Scanned Images']")
	WebElement UploadDocScaned;

	public void Clickon_Upload_Documents_Scanned_Images() {
		stepstatus = basepage.clickElement(UploadDocScaned);
		reportEvent(stepstatus, "Able to click Upload Documents/ Scanned Images Link",
				"Unable to click Upload Documents/ Scanned Images Link", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='View Documents']")
	WebElement ViewDoc;

	public void Clickon_View_Documents() {
		stepstatus = basepage.clickElement(ViewDoc);
		reportEvent(stepstatus, "Able to click View_Documents", "Unable to click View_Documents", driver, true);
	}

	public void SelectState() {
		try {
			loaddata();
			SelectStatename(prop.getProperty(getdata("State")));
		} catch (Exception e) {

		}

	}

	public void Menuitem_UploadDocument() {
		Mouserhoveron_UploadDocument();
		Clickon_Upload_Documents_Scanned_Images();
		Set_Application_Number(getdata("ApplicationNo"));
		Set_DateofBirth(getdata("DateofBirth"));
		Clickon_Submit_Button();
		try {
			Clickon_ok_Button();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void ViewDocument() throws IOException, InterruptedException {
		Mouserhoveron_UploadDocument();
		Clickon_View_Documents();
		Set_Application_Number(getdata("ApplicationNo"));
		Set_DateofBirth(getdata("DateofBirth"));
		Clickon_Submit_Button();
		String env = getdata("ApplicationEnvironment");
		if (env.equalsIgnoreCase("SarathiCOV")) {
			GetlogotpforViewDocument(prop.getProperty("SarathiCOVeKYCLogURL"));
		} else if (env.equalsIgnoreCase("SarathiProd")) {
			GetlogotpforViewDocument(prop.getProperty("SarathiprodeKYCLogURL"));
		} else {
			System.out.println("Log URL is not matched.Please try again");
		}
		Clickon_ok_Button();
	}

	public String GetlogotpforViewDocument(String url) throws IOException {
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
				if (strCurrentLine.contains("Generated OTP random code:")) {
					if (strCurrentLine.contains("Generated OTP random code:")) {
						// System.out.println(strCurrentLine.substring(177,184).trim());
						getotp = strCurrentLine.substring(88, 94).trim();
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
			driver.findElement(By.xpath("//input[@id='otptext']")).sendKeys(getotp);
			driver.findElement(By.xpath("//input[@id='otptext']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//button[@value='submit']")).click();
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getotp;
	}

}
