package others;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import frameworkLibrary.BaseClass;
import pageobjects.CommonPortal_ServiceEnablingPage;

public class CommonPortal extends BaseClass {
	WebDriver driver;

	CommonPortal_ServiceEnablingPage Enable;

	@BeforeMethod
	public void BrowserLaunch() throws IOException {
		loaddata();
		String BrowserName = getdata("Browser");
		switch (BrowserName.toLowerCase()) {
		case "firefox": {
			System.setProperty("webdriver.gecko.driver", "BrowserServers\\geckodriver.exe");
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("permissions.default.camera", 1);
			/*DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);*/
			driver = new FirefoxDriver();
			String env = getdata("ApplicationEnvironment");
			if (env.equalsIgnoreCase("SarathiCOV")) {
				driver.get(prop.getProperty("SarathiCOV"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println("Welcome to SarathiCOV");
			} else if (env.equalsIgnoreCase("SarathiProd")) {
				driver.get(prop.getProperty("SarathiProd"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println("Welcome to Sarathiprod");
			} else if (env.equalsIgnoreCase("CommonPortal")) {
				driver.get(prop.getProperty("CommonPortal"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println("Welcome to CommonPortal");
			} else {
				System.out.println("Application URL is not matched.Please try again");
			}
			break;
		}

		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "BrowserServers\\chromedriver.exe");
			ChromeOptions capability = new ChromeOptions();
			capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			capability.addArguments("use-fake-device-for-media-stream");
			capability.addArguments("use-fake-ui-for-media-stream");
			Map<String, Object> preferences = new Hashtable<String, Object>();
			capability.setExperimentalOption("prefs", preferences);
			preferences.put("plugins.always_open_pdf_externally", true);
			driver = new ChromeDriver(capability);
			String env = getdata("ApplicationEnvironment");
			if (env.equalsIgnoreCase("SarathiCOV")) {
				driver.get(prop.getProperty("SarathiCOV"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println("Welcome to SarathiCOV");
			} else if (env.equalsIgnoreCase("SarathiProd")) {
				driver.get(prop.getProperty("SarathiProd"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println("Welcome to Sarathiprod");
			} else if (env.equalsIgnoreCase("CommonPortal")) {
				driver.get(prop.getProperty("CommonPortal"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println("Welcome to CommonPortal");
			}

			else {
				System.out.println("Application URL is not matched.Please try again");
			}

			break;
		}
		default: {
			System.out.println("Please select the correct browser");
		}
		}
	}

	@Test(invocationCount = 12)
	public void ServiceEnabling() throws IOException, InterruptedException {

		Enable = new CommonPortal_ServiceEnablingPage(driver);
		Enable.Skip();
		Enable.HovertoMasterManagement();
		Enable.ClickonServiceEnabling();
		Enable.Enable_Service();

	}

	@AfterMethod
	public void Close() {

		System.out.println("AfterMethod");
		// quitdriver(driver);
	}

}
