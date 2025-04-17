package actions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import frameworkLibrary.BasePage;
import pageobjects.CapturebiometricsPage;
import pageobjects.LoginPage;
import pageobjects.RTO_LoginHomePage;

public class Action_115 extends BasePage{

	CapturebiometricsPage Capturebiometrics;
	WebDriver driver;
	
	public void CapturePhotoandSignature() {
		Capturebiometrics = new CapturebiometricsPage(driver);
		Capturebiometrics.Set_CanvasSignature("#thecanvas");
		Capturebiometrics.Clickon_Capturesignaturebutton();
		//wait(10);
		Capturebiometrics.StartCamera();
		Capturebiometrics.TakeSnapshot();
		Capturebiometrics.StartCrop();
		Capturebiometrics.EndCrop();
		Capturebiometrics.Clickon_Snapokbutton();
		Capturebiometrics.Clickon_Savebutton();
	}
	
	

	@Deprecated
	public void OldCaptureBiometricsatFirefox() {
		System.setProperty("webdriver.gecko.driver", "BrowserServers\\geckodriver.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.desktop-notification", 1);
		FirefoxOptions capabilities = new FirefoxOptions();

		capabilities.setCapability("firefox_binary",new File("C:\\Users\\User\\Desktop\\FirefoxPortable\\FirefoxPortable.exe").getAbsolutePath());
		profile.setPreference("media.navigator.permission.disabled", true);
		profile.setPreference("media.navigator.streams.fake", true);
		driver = new FirefoxDriver(capabilities);
		driver.get("https://sarathi.preprod.nic.in/cas/login?service=https%3A%2F%2Fsarathi.preprod.nic.in%2Fsarathiservice%2Fsarathilogin.do");
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(getdata("Username"));
		loginPage.setpassword(getdata("Password"));
		loginPage.ClickonLogin();
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[6]/a")).click();
		driver.findElement(By.xpath("//a[text()='CAPTURE PHOTO AND SIGNATURE']")).click();
	//	driver.findElement(By.xpath("//input[@name='appnumber']")).sendKeys(getdata("ApplicationNo"));
		driver.findElement(By.xpath("//button[@id='thumbdetform__populateData']")).click();

		CapturebiometricsPage Capturebiometrics = new CapturebiometricsPage(driver);
		Capturebiometrics.Set_CanvasSignature("#thecanvas");
		Capturebiometrics.Clickon_Capturesignaturebutton();
		Capturebiometrics.Set_PhotoCapture();
		wait(2);
		driver.findElement(By.xpath("//li[@class='crop']")).click();
		wait(1);
		driver.findElement(By.xpath("//li[@class='trigger']")).click();
		wait(1);
		driver.findElement(By.xpath("//input[@id='photoCaptre']")).click();
		wait(1);
		driver.findElement(By.xpath("//div[@class='col-md-12 top-space text-center']/input[1]")).click();
		RTO_LoginHomePage rto_loginHomePage = new RTO_LoginHomePage(driver);
		rto_loginHomePage.Clickon_Misc();
		rto_loginHomePage.Click_on_applicationstatus();
		rto_loginHomePage.EnterApplicationNumber(getdata("ApplicationNo"));
		rto_loginHomePage.Click_on_viewflows();
		rto_loginHomePage.Click_on_processflow();
		scrooldown(driver);
		driver.findElement(By.xpath("//div[@id='dlbacklogApproveId']/following::input[1]")).click();
		driver.quit();
	}
	
	
}
