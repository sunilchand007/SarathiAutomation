package utility;

import java.io.IOException;
import java.time.Duration;
import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	 private static WebDriver driver;

  
    public static WebDriver getDriver(String browser) throws IOException {
    	
		System.out.println("Loaded data ");
		if (driver==null) {
			switch (browser.toLowerCase()) {
			case "chrome":
				System.out.println("inside chrome condition");
				//	System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
					WebDriverManager.chromedriver().setup();
					ChromeOptions capability = new ChromeOptions();
					//capability.setBinary("C:\\Users\\User\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
					capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
					capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
					capability.addArguments("--window-size=1920,1080");
					capability.addArguments("--disable-gpu");
					capability.addArguments("--start-maximized");
//					capability.addArguments("--headless");
					capability.addArguments("use-fake-device-for-media-stream");
					capability.addArguments("use-fake-ui-for-media-stream");
					capability.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR,
							UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);
					Map<String, Object> preferences = new Hashtable<String, Object>();
					capability.setExperimentalOption("prefs", preferences);
					preferences.put("plugins.always_open_pdf_externally", true);
					String downloadFilepath1 = "C:\\Users\\user\\Downloads";
					preferences.put("profile.default_content_settings.popups", 0);
					preferences.put("download.prompt_for_download", false);
					preferences.put("download.default_directory", downloadFilepath1);
					driver = new ChromeDriver(capability);
					break;
					
			case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                FirefoxOptions options = new FirefoxOptions();
    			options.addArguments("--headless");
                break;
                
			case "Edge":
				WebDriverManager.edgedriver().setup();
				EdgeOptions edgeoptions = new EdgeOptions();
				edgeoptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				edgeoptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
				edgeoptions.addArguments("--window-size=1920,1080");
				edgeoptions.addArguments("--disable-gpu");
				edgeoptions.addArguments("--start-maximized");
				// capability.addArguments("--headless");
				edgeoptions.addArguments("use-fake-device-for-media-stream");
				edgeoptions.addArguments("use-fake-ui-for-media-stream");
				edgeoptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR,
						UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);
				Map<String, Object> edgepreferences = new Hashtable<String, Object>();
				edgeoptions.setExperimentalOption("prefs", edgepreferences);
				edgepreferences.put("plugins.always_open_pdf_externally", true);
				String downloadFilepath2 = "C:\\Users\\user\\Downloads";
				edgepreferences.put("profile.default_content_settings.popups", 0);
				edgepreferences.put("download.prompt_for_download", false);
				edgepreferences.put("download.default_directory", downloadFilepath2);
				driver = new EdgeDriver(edgeoptions);
                break;
                
			default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
			}
			
	}
		return driver;
    
    }
    
    
    public static void openUrl(String url) {
    	System.out.println("inside open url");
        if (driver != null) {
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        } else {
            throw new IllegalStateException("WebDriver not initialized. Call getDriver() first.");
        }
    }
    
    
    
    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
 
        }
        
    }
}
