package transactions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.Action_215;
import frameworkLibrary.BaseClass;
import pageobjects.Form1Page;
import pageobjects.NewDLSubmissionPage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Utilitymethods;

public class Transaction_511 extends BaseClass {
	WebDriver driver;
	
	
	
	NewDLSubmissionPage NewDLSubmissionPage;

	Transaction_591 llbacklog;
	Action_215 action_215;
	Utilitymethods utilitymethods;
	@BeforeMethod
	
     public void LaunchApplication() throws IOException {
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();

	}
	
	
	public void NewDL() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.closeContactlessLicenceServicesPopup();
		NewDLSubmissionPage = new NewDLSubmissionPage(driver);
		//NewDLSubmissionPage.Mouserhoveron_DrivingLicence();
		NewDLSubmissionPage.clickon_NewDrivinglicence();
		NewDLSubmissionPage.clickon_Contuinebutton();
		NewDLSubmissionPage.Set_LearnersLicenceNumber(getdata("LLNumber"));
		NewDLSubmissionPage.Set_DateofBirth(getdata("DateofBirth"));
		NewDLSubmissionPage.Set_Captcha("123456");
		wait(30);
		NewDLSubmissionPage.clickon_Okbutton();
		
		 utilitymethods = new Utilitymethods(driver);
		 utilitymethods.authentication();;	
			
		
			
			
		
		/*Boolean Mobilenumber = driver.findElement(By.xpath("//input[@name='mobileNumber']")).isDisplayed();
		System.out.println(Mobilenumber);

		if (Mobilenumber.equals(true)) {
			System.out.println("Inside if condition  --->sending text to mobile number field ");
			driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys(getdata("Mobilenumber"));
		} else {

			System.out.println("Mobile number field is in disble mode ");
		}*/
		//driver.findElement(By.xpath("//input[1][@name='willingToDonate']")).click();
		NewDLSubmissionPage.clickon_Selectallcheckbox();
		NewDLSubmissionPage.Verify_OrganDonarRadio_button();
		String Psvbadgecheckbox = "N";
		if(Psvbadgecheckbox.equalsIgnoreCase("Y")) {
			driver.findElement(By.id("badgecovs")).click();
		}
		else {
			System.out.println("There is no PSV BADGE checkbox");
		}
		
		String Dispatchstatus = getdata("Dispatchstatus");
		if(Dispatchstatus.equalsIgnoreCase("Y")) {
			driver.findElement(By.xpath("//input[@id='dldispatchP']")).click();	
		}
		else {
			System.out.println("There is no dispatch option");
		}
		
		String form1Req =getdata("form1Req");;
		if(form1Req.equalsIgnoreCase("Y")) {
			Form1Page form1 = new Form1Page(driver);
			form1.Fill_Form1Details(form1Req);
			
		}
		else {
			
			System.out.println("There is no Form1 for this state ");
		}
		
		
		  NewDLSubmissionPage.clickon_Submitbutton();
		  wait(10);
		  
		  NewDLApplicationNo = DL_App_NO(driver,
		  "//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]");
		  NewDLSubmissionPage.setdata("ApplicationNo",
		  NewDLApplicationNo.substring(3)); 
		  
		  utilitymethods = new Utilitymethods(driver);
		  utilitymethods.Validating_Flows();
	}
	
	@Test(invocationCount = 12)
	public void NewDL_Public() throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		String Testcase = getdata("Testcase");
		System.out.println("Testcase is : " + Testcase );
		
		if (Testcase.equalsIgnoreCase("LLbacklog")) {
			System.out.println("inside LL backlog");
			llbacklog = new Transaction_591();
			llbacklog.llBacklogEntry();
		}

		else if (Testcase.equalsIgnoreCase("LLbacklog _New Driving Licence")) {
			llbacklog = new Transaction_591();
			llbacklog.llBacklogEntry();
			NewDL();
		}

		else if (Testcase.equalsIgnoreCase("New Driving Licence")) {
			NewDL();
		}

		else if (Testcase.equalsIgnoreCase("Applicationstatus")) {
			
			action_215 = new Action_215(driver);
			action_215.applicationstatus();
		} 
		
		else {
			System.out.println(" Please check the Testcase");
		}
	}

	

	@Test(invocationCount = 7,enabled = false)
	public void DLBacklog() throws IOException, ClassNotFoundException, SQLException, InterruptedException {

	//	dl = new DLModule(driver);
	//	dl.Initiating_DLBacklog();

	}
	
	
	@Test(invocationCount = 1 , enabled = false)
	public void TC_DL_DLClub() throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		//dl = new DLModule(driver);
		//dl.SelectState();
		//dl.Menuitem_DLClub();
		//dl.Validating_Flows();

	}

	@Test(invocationCount = 1 , enabled = false)
	public void TC_DL_Print_Driving_Licence()
			throws ClassNotFoundException, IOException, SQLException, InterruptedException {

		//dl = new DLModule(driver);
		//dl.SelectState();
		//dl.Menuitem_Print_Driving_Licence();

	}

	@Test(invocationCount = 1,enabled = false)
	public void TC_DL_DL_Extract_Reprint()
			throws ClassNotFoundException, IOException, SQLException, InterruptedException {

		//dl = new DLModule(driver);
		//dl.SelectState();
		//dl.Menuitem_DL_Extract_Reprint();

	}

	@Test(invocationCount = 1,enabled = false)
	public void TC_DL_Display_IDP_Details()
			throws ClassNotFoundException, IOException, SQLException, InterruptedException {

		//dl = new DLModule(driver);
		//dl.SelectState();
		//dl.Menuitem_Display_IDP_Details();

	}

	@Test(invocationCount = 1,enabled = false)
	public void TC_DL_Driving_Licence_Test_Sheet()
			throws ClassNotFoundException, IOException, SQLException, InterruptedException {

		//dl = new DLModule(driver);
		//dl.SelectState();
		//dl.Menuitem_Driving_Licence_Test_Sheet();

	}

	@Test(invocationCount = 18,enabled = false)
	public void RTOApplicationStatus() throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		System.setProperty("webdriver.gecko.driver", "BrowserServers\\geckodriver.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.desktop-notification", 1);
		//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		//capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		//capabilities.setCapability("firefox_binary",
			//	new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe").getAbsolutePath());
		profile.setPreference("media.navigator.permission.disabled", true);
		profile.setPreference("media.navigator.streams.fake", true);
		WebDriver ff = new FirefoxDriver();
		ff.get("https://sarathiprod.nic.in/cas/login?service=https%3A%2F%2Fsarathiprod.nic.in%2Fsarathiservice%2Fsarathilogin.do");
		ff.manage().window().maximize();
		//ff.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//LoginRTO RTO = new LoginRTO(ff);
		//RTO.setUserName(getdata("UserName"));
		//RTO.setpassword(getdata("Password"));
		//RTO.ClickonLogin();
		ff.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[6]/a")).click();
		ff.findElement(By.xpath("//a[text()='CAPTURE PHOTO AND SIGNATURE']")).click();
		ff.findElement(By.xpath("//input[@name='appnumber']")).sendKeys(getdata("ApplicationNo"));
		ff.findElement(By.xpath("//button[@id='thumbdetform__populateData']")).click();

		//CapturebiometricsPage Capturebiometrics = new CapturebiometricsPage(ff);
	//	Capturebiometrics.Set_CanvasSignature("#thecanvas");
		//Capturebiometrics.Clickon_Capturesignaturebutton();
		//Capturebiometrics.Set_PhotoCapture();
		wait(1);
		// ff.findElement(By.xpath("//button[@id='capBtn']")).click();
		wait(1);
		// ff.findElement(By.xpath("//div[@class='dojoTab']/div/span[text()='Photo
		// Capture']")).click();
		wait(1);

		try {
			// ff.findElement(By.xpath("//li[@class='crop']")).click();
			// wait(2);
			scrooldown(ff);
			ff.findElement(By.xpath("//li[@class='trigger']")).click();
			wait(3);
			ff.findElement(By.xpath("//input[@id='photoCaptre']")).click();
			wait(3);
			ff.findElement(By.xpath("//div[@class='col-md-12 top-space text-center']/input[1]")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

	//	Commom_RTO_Menu menuitem = new Commom_RTO_Menu(ff);
		//menuitem.Clickon_Misc();
		//menuitem.Click_on_applicationstatus();
		//menuitem.EnterApplicationNumber(getdata("ApplicationNo"));
		//menuitem.Click_on_viewflows();
		//menuitem.Click_on_processflow();
		scrooldown(ff);
		ff.findElement(By.xpath("//div[@id='dlbacklogApproveId']/following::input[1]")).click();
		ff.close();

	}

	

	
	
	@AfterMethod
	public void after() {
		System.out.println("After Method");
		//driver.close();
	}

}
