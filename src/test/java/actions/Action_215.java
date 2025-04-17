package actions;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import frameworkLibrary.FrameworkVariables;

import pageobjects.ApplicationStatusStage01Page;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Flows;
import utility.FlowsNew;
import utility.Utilitymethods;

public class Action_215 extends BaseClass {
	WebDriver driver;

	Flows validate;
	ApplicationStatusStage01Page applicationStatusstage01;
	Utilitymethods utilitymethods;

	StateSelectionPage stateSelectionPage;
	StateSpecificHomePage stateSpecificHomePage;
	
	public Action_215(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@BeforeMethod
	public void LaunchApplication() throws IOException {
	 utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
	}
	
	
	@Test(invocationCount = 1)
	public void applicationstatus() throws ClassNotFoundException, SQLException, IOException, InterruptedException {
	
		stateSpecificHomePage.Clickon_Application_Status();
		applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
		applicationStatusstage01.enterdetails_In_Applicationstaus();
		
		
		}
		
				
					
	
	
	@AfterMethod
	public void CloseBrowser() {
	//	System.out.println("**************After Method***************");
		//quitdriver(driver);
	}
	
	
	@AfterSuite
	public void aftersuite() throws IOException, EmailException
	{
		closeExtentReport();
		BackupFile(FrameworkVariables.getInstance().getCurrentModuleName(), FrameworkVariables.getInstance().getCurrentModuleName()+"_TestBackupFile");
		launchResult();

	}

}
