package others;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.Action_215;
import frameworkLibrary.BaseClass;
import pageobjects.ApplicationForServicesonDL2Page;
import pageobjects.ApplicationForServicesonDLPage;
import pageobjects.ApplicationStatusStage01Page;
import pageobjects.DLExtractpage;
import pageobjects.DLServiceSelectionPage;
import pageobjects.DL_Backlog;
import pageobjects.DrivingLicenceMenuPage;
import pageobjects.InstructionsforDLServicePage;
import pageobjects.NewDLSubmissionPage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import transactions.Transaction_592;
import utility.Flows;
import utility.Utilitymethods;

public class TestGeneric extends BaseClass {

	WebDriver driver;

	Flows validate;

	NewDLSubmissionPage NewDLSubmissionPage;

	Utilitymethods utilitymethods;
	Transaction_592 dlBacklog;

  ApplicationStatusStage01Page applicationStatusstage01;
  Action_215 action_215;

	
	@BeforeMethod
	public void LaunchApplication() throws IOException {
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
	}

	 @Test(invocationCount = 1)
	public void TC05() throws IOException, ClassNotFoundException, SQLException,InterruptedException {
	
		 String testcase ="dlbacklog";
		 
		 if(testcase.equalsIgnoreCase("dlbacklog")) {
			 dlBacklog = new Transaction_592();
			 dlBacklog.dLBacklog();
		     Flows flows = new Flows(driver);
			 flows.VerifyFlows();
		     driver.findElement(By.xpath("//a[text() = 'Logout']")).click();
		 }
		 else {
				// Applicationstatus code
				//llmodule = new LLModule(driver);
//				DL_Backlog = new DL_Backlog(driver);
//				DL_Backlog.SetMobilenumb(getdata("Mobilenumber"));
//				driver.findElement(By.xpath("//input[@id='entcaptxt']")).sendKeys("123456");
//				driver.findElement(By.xpath("//button[@value='Generate OTP']")).click();
//				driver.findElement(By.xpath("//input[@id='otpNumberSarathi']")).sendKeys("123456");
//				driver.findElement(By.xpath("//input[@id='entcaptxt1']")).sendKeys("123456");
//				wait(3);
//				driver.findElement(By.xpath("//input[@value='Submit OTP']")).click();
				
			//llmodule.SelectState();
				/*
				 * driver.findElement(By.xpath("//span[text() = '---Select RTO Office---']")).
				 * click(); WebElement element =
				 * driver.findElement(By.xpath("//input[@class = 'select2-search__field']"));
				 * element.sendKeys("hyd"); element.sendKeys(Keys.RETURN);
				 */
				//llmodule.closeContactlessLicenceServicesPopup();
			 action_215 = new Action_215(driver);
			 action_215.applicationstatus();
				Flows flows = new Flows(driver);
				flows.VerifyFlows();
				flows.RTOLevel_Status();
				driver.findElement(By.xpath("//button[@value = 'Home']")).click();
				// VALIDITY UPDATION
				//llmodule.LLvalidityupdation();
		 }
		
	 }
	
 
	@AfterMethod
	public void CloseBrowser() {
		 
		System.out.println("**************After Method***************");
		  //  driver.quit();
		   
	}

}
