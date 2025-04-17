package others;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pageobjects.LLFEEPaymentPageeOld;
import utility.Flows;

import frameworkLibrary.BaseClass;

public class HomePageMenuItem_FeePayments extends BaseClass {
	WebDriver driver;

	Flows validate;


	@BeforeMethod
	public void Predatacheck() throws IOException {
		loaddata();
		System.setProperty("webdriver.chrome.driver", "BrowserServers\\chromedriver.exe");
		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		capability.addArguments("use-fake-device-for-media-stream");
		capability.addArguments("use-fake-ui-for-media-stream");
		capability.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);
		Map<String, Object> preferences = new Hashtable<String, Object>();
		capability.setExperimentalOption("prefs", preferences);
		preferences.put("plugins.always_open_pdf_externally", true);
		driver = new ChromeDriver(capability);
		String env = getdata("ApplicationEnvironment");
		if (env.equalsIgnoreCase("SarathiCOV")) {
			driver.get(prop.getProperty("SarathiCOV"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Welcome to SarathiCOV");
		} else if (env.equalsIgnoreCase("SarathiProd")) {
			driver.get(prop.getProperty("SarathiProd"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Welcome to Sarathiprod");
		} else if (env.equalsIgnoreCase("CAS_SarathiCOV")) {
			driver.get(prop.getProperty("CAS_SarathiCOV"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Welcome to CAS_SarathiCOV");
		} else if (env.equalsIgnoreCase("CAS_SarathiProd")) {
			driver.get(prop.getProperty("CAS_SarathiProd"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Welcome to CAS_SarathiProd");
		} else {
			System.out.println("Application URL is not matched.Please try again");
		}

	}

	@Test(invocationCount = 1)
	public void TC_Fee_Payments() throws IOException, InterruptedException {
		LLFEEPaymentPageeOld LLFEEPaymentPage = new LLFEEPaymentPageeOld(driver);
		LLFEEPaymentPage.SelectState();
		LLFEEPaymentPage.MenuItem_FeePayments();
	
	}

	@Test(invocationCount = 1)
	public void TC_Verify_Pay_Status() {
		LLFEEPaymentPageeOld LLFEEPaymentPage = new LLFEEPaymentPageeOld(driver);
		LLFEEPaymentPage.SelectState();
		LLFEEPaymentPage.MenuItem_VerifyPayStatus();

	}

	@Test(invocationCount = 1)
	public void TC_Update_Pay_Status() {
		LLFEEPaymentPageeOld LLFEEPaymentPage = new LLFEEPaymentPageeOld(driver);
		LLFEEPaymentPage.SelectState();
		LLFEEPaymentPage.MenuItem_Update_Pay_Status();
		
	}

	@Test(invocationCount = 1)
	public void TC_CapturePhotoPlugIn() {
		/* Out of Scope */
	}

	@AfterMethod
	public void CloseBrowser() {
		// driver.quit();
		System.out.println("**************After Method***************");
	}

}