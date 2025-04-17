package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
//import java.util.Locale;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import frameworkLibrary.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.AuthenticationPage;
import pageobjects.Authentication_With_EYCPage;
import pageobjects.Authentication_With_NonEYCPage;
import pageobjects.NewLLSubmissionPage;
import pageobjects.StateSelectionPage;

public class Utilitymethods extends BasePage {
	WebDriver driver;
	BasePage basepage = new BasePage();
	boolean stepstatus;
	NewLLSubmissionPage newLLSubmissionPage;
	Authentication_With_EYCPage authentication_With_EYCPage;
	AuthenticationPage authenticationPage;
	Authentication_With_NonEYCPage authentication_With_NonEYCPage;
	Flows flows;
	StateSelectionPage stateselection;
	public Utilitymethods(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//  Setdata in Excel i.e firstname, lastname ,relationfirstname,relationlastname
	public void ArrangeDataSet() {

		Faker faker = new Faker();
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		String relationfirstname = faker.name().firstName();
		String relationlastname = faker.name().lastName();
		setdata("Applicantfirstname", firstname);
		setdata("Applicantlastname", lastname);
		setdata("Relationfirstname", relationfirstname);
		setdata("Relationlastname", relationlastname);
		System.out.println("Arranged Testdata in Excel");
	}

	public WebDriver Launch_ApplicationUrl() throws IOException {
		System.out.println("Inside launch sarathiservice homepage");
		loaddata();
		System.out.println("Loaded data ");
		String Browserenv = "Edge";
		System.out.println("Browser Env is : " + Browserenv);
		if (Browserenv.equalsIgnoreCase("Chrome")) {
			System.out.println("inside chrome condition");
		//	System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions capability = new ChromeOptions();
			capability.setBinary("C:\\Users\\User\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
			capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			capability.addArguments("--window-size=1920,1080");
			capability.addArguments("--disable-gpu");
			capability.addArguments("--start-maximized");
//			capability.addArguments("--headless");
			capability.addArguments("use-fake-device-for-media-stream");
			capability.addArguments("use-fake-ui-for-media-stream");
			capability.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR,
					UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);
			Map<String, Object> preferences = new Hashtable<String, Object>();
			capability.setExperimentalOption("prefs", preferences);
			preferences.put("plugins.always_open_pdf_externally", true);
			String downloadFilepath = "C:\\Users\\user\\Downloads";
			preferences.put("profile.default_content_settings.popups", 0);
			preferences.put("download.prompt_for_download", false);
			preferences.put("download.default_directory", downloadFilepath);
			driver = new ChromeDriver(capability);
		} else if (Browserenv.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			driver = new FirefoxDriver();
		} else if (Browserenv.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions capability = new EdgeOptions();
			capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			capability.addArguments("--window-size=1920,1080");
			capability.addArguments("--disable-gpu");
			capability.addArguments("--start-maximized");
			// capability.addArguments("--headless");
			capability.addArguments("use-fake-device-for-media-stream");
			capability.addArguments("use-fake-ui-for-media-stream");
			capability.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR,
					UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);
			Map<String, Object> preferences = new Hashtable<String, Object>();
			capability.setExperimentalOption("prefs", preferences);
			preferences.put("plugins.always_open_pdf_externally", true);
			String downloadFilepath = "C:\\Users\\user\\Downloads";
			preferences.put("profile.default_content_settings.popups", 0);
			preferences.put("download.prompt_for_download", false);
			preferences.put("download.default_directory", downloadFilepath);
			driver = new EdgeDriver(capability);
		}

		else {
			System.out.println("unable to launch browser");
		}

		/*
		 * driver.get(prop.getProperty("CAS_SarathiCOV"));
		 * driver.manage().window().maximize();
		 * driver.findElement(By.xpath("//*[@id=\"details-button\"]")).click();
		 * driver.findElement(By.xpath("//*[@id=\"proceed-link\"]")).click();
		 */

		String env = getdata("ApplicationEnvironment");
		System.out.println("Testing environment is :  " + env); //

		if (env.equalsIgnoreCase("SarathiCOV")) {
			System.out.println("inside staging env");
			driver.get(prop.getProperty("SarathiCOV"));
			driver.manage().window().maximize();
            System.out.println("Welcome to SarathiCOV");
            //stateselection=new StateSelectionPage(driver);
            //stateselection.SarathiMobileAuthentication();
            
		} else if (env.equalsIgnoreCase("SarathiProd")) {
			System.out.println("inside preprod env");
			driver.get(prop.getProperty("SarathiProd"));
			driver.manage().window().maximize();

			System.out.println("Welcome to Sarathiprod");
		}

		else if (env.equalsIgnoreCase("CAS_SarathiCOV")) {
			driver.get(prop.getProperty("CAS_SarathiCOV"));
			driver.manage().window().maximize();

			System.out.println("Welcome to CAS_SarathiCOV");
		}

		else if (env.equalsIgnoreCase("CAS_SarathiProd")) {
			driver.get(prop.getProperty("CAS_SarathiProd"));
			driver.manage().window().maximize();

			System.out.println("Welcome to CAS_SarathiProd");
		}

		else if (env.equalsIgnoreCase("Production")) {
			driver.get(prop.getProperty("Sarathi_Production"));
			driver.manage().window().maximize();

			System.out.println("Welcome to Sarathi Production");
		}

		else if (env.equalsIgnoreCase("SarathiAudit")) {
			driver.get(prop.getProperty("SarathiAudit"));
			driver.manage().window().maximize();

			System.out.println("Welcome to SarathiNewstaging");

		}

		else if (env.equalsIgnoreCase("Sarathilocal")) {
			driver.get(prop.getProperty("Sarathilocal"));
			driver.manage().window().maximize();

			System.out.println("Welcome to SarathiNewstaging");
		} else {
			System.out.println("Application URL is not matched.Please try again");
		}

		return driver;

	}

	public void Form_1_Check() {
		System.out.println("Inside form1 check");
		newLLSubmissionPage = new NewLLSubmissionPage(driver);
		ConnecttoExcel(prop.getProperty("Form1"), prop.getProperty("DataFile_State"));
		System.out.println("connected to form1 excel");

		if (outcome.equalsIgnoreCase("Y")) {

			Fill_Form1Details();

			newLLSubmissionPage.SetSubmitthree();
			// waitforAlerttobepresent(driver);
		} else if (outcome.equalsIgnoreCase("N")) {
			newLLSubmissionPage.SetSubmitthree();
			// waitforAlerttobepresent(driver);
		} else {
			System.out.println("******************FORM1**********************");
		}

	}

	public void Validating_Flows() throws ClassNotFoundException, SQLException {
		flows = new Flows(driver);
		try {
			flows.VerifyFlows();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void Fill_Form1Details() {
		System.out.println("Inside fill form1details");
		newLLSubmissionPage = new NewLLSubmissionPage(driver);
		newLLSubmissionPage.ClickonForm1_buttton();
		SwitchtoWindowByTitle("formOne", driver);
		List<WebElement> radio = driver.findElements(By.xpath("//label[text()='NO']/preceding-sibling::input[1]"));
		System.out.println(radio);
		for (WebElement subradio : radio) {

			String state = getdata("State");
			if (state.equalsIgnoreCase("OD")) {
				subradio.click();

			} else {

				subradio.click();
				driver.findElement(By.xpath("//input[@id = 'scopebY']")).click();
			}

		}
//		newLLRegistrtionPage.ClickonDeclareCheckbox();
//		newLLRegistrtionPage.ClickonSubmitbuttonatForm1();
		closeWindowByTitle("FormOneSuccess", driver);
		SwitchtoWindowByTitle("Application For NewLL", driver);
	}

	public void CaptureDetails() {
		newLLSubmissionPage = new NewLLSubmissionPage(driver);
		wait(1);
		AppNum = App_NO(driver, "//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]");
		System.out.println(AppNum);
		DOB = DOB(driver, "//table/tbody/tr[2]/td[3]/following-sibling::td");
		System.out.println(DOB);
		String title = driver.getTitle();
		if (title.equals("New LL Acknowledgement")) {
			newLLSubmissionPage.setdata("ApplicationNo", AppNum.substring(3).trim());
			newLLSubmissionPage.setdata("DateofBirth", DOB.substring(3).trim());
			newLLSubmissionPage.setdata("StatusofApplication", "Success");

		} else {
			System.out.println("New LL Acknowledgement is not Generated");
			newLLSubmissionPage.setdata("StatusofApplication", "Fail");
			driver.close();
		}
	}

	public String ConnectDBandGetDBvalue(String DBquery, String Requiredcolumnvalue, String DBurl)
			throws ClassNotFoundException, SQLException, IOException {

		String getdata = null;
		System.out.println("Inside database connection method ");

		try {
			System.out.println("Connecting to Database..." + "\n" + df.format(new Date()) + ""
					+ "\n-----------------------------------------------------------------------------");
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(DBurl, "readonly", "readonly");
			System.out.println("Connected to Database");
		} catch (SQLException | ClassNotFoundException ex) {
			System.err.println("Failed to connect to DB");
			ex.printStackTrace();
		}

		if (conn != null) {

			System.out.println(DBquery);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(DBquery);
			System.out.println("Result set of the query " + rs);
			while (rs.next()) {
				getdata = rs.getString(Requiredcolumnvalue);
				System.out.println(getdata);

			}

		}
		return getdata;

	}

	public String Getlogotp(String currentline, int startindex, int endindex) throws IOException {

		wait(3);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		System.out.println("Inside getlogotp");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // switches to new tab

		// launching log url

		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		String env = prop.getProperty("ApplicationURL");
		System.out.println("Environment is " + env);

		if (env.equalsIgnoreCase("SarathiCOV")) {
			
			if (PageTitle.equalsIgnoreCase("Sending SMS") || PageTitle.equalsIgnoreCase("Home")) {

				driver.get(prop.getProperty("staging_slotslog"));
			} else {

				driver.get(prop.getProperty("staging_emailandsmslog"));
			}

		}

		else if (env.equalsIgnoreCase("SarathiProd")) {

			if (PageTitle.equalsIgnoreCase("Sending SMS")) {

				driver.get(prop.getProperty("preprod_slotslog"));
			} else {

				driver.get(prop.getProperty("preprod_emailandsmslog"));
			}

		}

		else {
			System.out.println("Log URL is not matched.Please try again");
		}

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
				if (strCurrentLine.contains(currentline)) {
					if (strCurrentLine.contains(currentline)) {

						getotp = strCurrentLine.substring(startindex, endindex).trim();
						System.out.println(getotp);
					}
					count++;
				} else {
					// System.out.println("#######################Pleasae Check OTP
					// Section###########################");
				}
			}
			//
			System.out.println(count);

			System.out.println("OTP is " + getotp);
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return getotp;
	}


	public void adharauthentication() {

		authenticationPage = new AuthenticationPage(driver);
		String state = getdata("state");
		if (state != "AP") {
			authenticationPage.clickRadiobuttonSubmitviaAadhaarAuthenticationAadhaarnumber();
			authenticationPage.clickonapplyonSubmittwobutton();

			String OpTion = getdata("TypeofOption");
			if (OpTion.equalsIgnoreCase("Aadhar")) {
				authentication_With_EYCPage = new Authentication_With_EYCPage(driver);
				authentication_With_EYCPage.SelectAadharNumber();
			} else if (OpTion.equalsIgnoreCase("Virtual ID")) {

				authentication_With_EYCPage.SelectVirtualNumber();
			} else {
				System.out.println("Selected Option is not availble in EKyc Aadhar authentication ");
			}
		}

		else {

			String OpTion = getdata("TypeofOption");
			if (OpTion.equalsIgnoreCase("Aadhar")) {
				authentication_With_EYCPage.SelectAadharNumber();
			} else if (OpTion.equalsIgnoreCase("Virtual ID")) {
				authentication_With_EYCPage.SelectVirtualNumber();
			} else {
				System.out.println("Selected Option is not availble in EKyc Aadhar authentication ");
			}
		}

		authentication_With_EYCPage.Enter_AadharorVirtualNumber(getdata("AadharandorVirtualNumber"));
		authentication_With_EYCPage.ClickonGenerateotpButton();
		JFrame Dialog = new JFrame();
		String OTP = JOptionPane.showInputDialog(Dialog, "Enter OTP Here");
		driver.findElement(By.xpath("//input[@name='otpNumber']")).sendKeys(OTP);
		List<WebElement> checkele = driver.findElements(By.xpath("//input[@type='checkbox']"));
		@SuppressWarnings("unused")
		int checksize = checkele.size();
		for (WebElement elecheck : checkele) {
			if (!elecheck.isSelected()) {
				elecheck.click();
			}
		}
		authentication_With_EYCPage.ClickonAuthenticate();
		authentication_With_EYCPage.Clickon_Proceedbutton();

	}

	public void nonadharauthentication() throws IOException {
		authenticationPage = new AuthenticationPage(driver);
		authenticationPage.clickonapplyonApplicantdoesnotholdAadhaarnumber();
		authenticationPage.clickonapplyonSubmittwobutton();
		authentication_With_NonEYCPage = new Authentication_With_NonEYCPage(driver);
		authentication_With_NonEYCPage.SetMobilenumber(getdata("Phone"));
		authentication_With_NonEYCPage.EnterCaptcha();
		wait(5);
		authentication_With_NonEYCPage.ClickongenerateOTP();
		wait(5);

//    	String otp = Getlogotp("OTP (One Time Password) For Self Authentication ", 213,220);
//		driver.findElement(By.xpath(" //input[@name='otpNumberSarathi']")).sendKeys(otp);
		driver.findElement(By.xpath(" //input[@name='otpNumberSarathi']")).sendKeys("123456");

    	//String otp = Getlogotp("OTP (One Time Password) For Self Authentication ", 213,220);
		//driver.findElement(By.xpath(" //input[@name='otpNumberSarathi']")).sendKeys(otp);

		// String otp = Getlogotp("OTP (One Time Password) For Self Authentication ",
		// 213,220);
		driver.findElement(By.xpath(" //input[@name='otpNumberSarathi']")).sendKeys("123456");

		authentication_With_NonEYCPage.enterCaptchaafter_Entering_Otp("123456");
		wait(5);
		authentication_With_NonEYCPage.submitOtp();
	}

	public void mobileauthentication() throws IOException {
		System.out.println("Inside mobile authentication");
		authentication_With_NonEYCPage = new Authentication_With_NonEYCPage(driver);
		authentication_With_NonEYCPage.SetMobilenumber(getdata("Phone"));
		authentication_With_NonEYCPage.EnterCaptcha();
		authentication_With_NonEYCPage.ClickongenerateOTP();
		wait(10);
		String env = prop.getProperty("ApplicationURL");
		System.out.println("Environment is " + env);
		if (env.equalsIgnoreCase("SarathiCOV")) {

				
//			String otp = Getlogotp("OTP (One Time Password) For Self Authentication ", 213,220);
//			driver.findElement(By.xpath("//input[@name='otpNumberSarathi']")).sendKeys(otp);
			driver.findElement(By.xpath("//input[@name='otpNumberSarathi']")).sendKeys("123456");

				
			String otp = Getlogotp("OTP (One Time Password) For Self Authentication ", 213,220);
			driver.findElement(By.xpath(" //input[@name='otpNumberSarathi']")).sendKeys(otp);


			// String otp = Getlogotp("OTP (One Time Password) For Self Authentication ",
			// 213,220);
			driver.findElement(By.xpath(" //input[@name='otpNumberSarathi']")).sendKeys("123456");
		} else if (env.equalsIgnoreCase("SarathiProd")) {
			// String otp = Getlogotp("OTP (One Time Password) For Self Authentication ",
			// 204,211);
			driver.findElement(By.xpath(" //input[@name='otpNumberSarathi']")).sendKeys("123456");

		}

		else if (env.equalsIgnoreCase("SarathiProd")) {
//			String otp = Getlogotp("OTP (One Time Password) For Self Authentication ", 204,211);
//			driver.findElement(By.xpath("//input[@name='otpNumberSarathi']")).sendKeys(otp);	
			driver.findElement(By.xpath("//input[@name='otpNumberSarathi']")).sendKeys("123456");
			}

		else if (env.equalsIgnoreCase("SarathiProd")) {
			String otp = Getlogotp("OTP (One Time Password) For Self Authentication ", 204,211);
			driver.findElement(By.xpath(" //input[@name='otpNumberSarathi']")).sendKeys(otp);		
			}


		authentication_With_NonEYCPage.enterCaptchaafter_Entering_Otp("123456");
		authentication_With_NonEYCPage.submitOtp();
	}

	public void authentication() throws IOException, ClassNotFoundException, SQLException {
		/*
		 * String Typeofauthentication = getdata("Typeofauthentication");
		 * 
		 * if (Typeofauthentication.equalsIgnoreCase("Ekyc")) { adharauthentication();
		 * 
		 * } else if (Typeofauthentication.equalsIgnoreCase("Nonekyc")) {
		 * nonadharauthentication();
		 * 
		 * }
		 * 
		 * else if (Typeofauthentication.equalsIgnoreCase("mobileauthentication")) {
		 * 
		 * mobileauthentication();
		 * 
		 * } else {
		 * 
		 * System.out.println("noauthentication"); // stepstatus =
		 * clickElement(Submitwithoutaadharauthentification); //reportEvent(stepstatus,
		 * "Able to Click on Submit without Aadhar Authentiication"
		 * ,"Unable to Click on Submit without Aadhar Authentiication", driver, true); }
		 */

		String text = "Applicants using Aadhaar authentication can take the LL Test from their home or any preferred location, no need to visit RTO. Password for Online LL Test will be sent as SMS to the registered mobile number linked with Aadhaar. Successful applicant can download his/her Learner License.";
		
		if (driver.getPageSource().contains(text) && getdata("AadharOption").equalsIgnoreCase("Applicant holds Aadhaar Number"))    {
			  System.out.println("aadhar authenticaton");
			  
			  adharauthentication();
		  }
		  
		  else if (driver.getPageSource().contains(text) && getdata("AadharOption").equalsIgnoreCase("Applicant does not hold Aadhaar Number")){
				  System.out.println("non aadhar authentication");
				  
			  nonadharauthentication();
		  }
		  
		  else if (driver.getPageSource().contains("Sarathi Mobile ")) {
		  
		  mobileauthentication();
		  
		  } 
		  
		  else {
		  
		  System.out.println("noauthentication"); 
		  }
		 // stepstatus = clickElement(Submitwithoutaadharauthentification); 
		  
		//reportEvent(stepstatus,"Able to Click on Submit without Aadhar Authentiication","Unable to Click on Submit without Aadhar Authentiication", driver, true); }
		
	}
}

	

