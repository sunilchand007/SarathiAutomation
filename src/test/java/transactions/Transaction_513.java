package transactions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.ApplicationForServicesonDL2Page;
import pageobjects.ApplicationForServicesonDLPage;
import pageobjects.ApplicationStatusStage01Page;
import pageobjects.ChangeOfAddressInDLPage;
import pageobjects.DLServiceSelectionPage;
import pageobjects.DL_Backlog;
import pageobjects.DetailsofDLHolderPage;
import pageobjects.DrivingLicenceMenuPage;
import pageobjects.DuplicateDLPage;
import pageobjects.InstructionsforDLServicePage;
import pageobjects.NewLLSubmissionPage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Flows;
import utility.Utilitymethods;

public class Transaction_513 extends BaseClass {
	
	WebDriver driver;
	boolean stepstatus;
	
	Flows flows;
	Utilitymethods utilitymethods;
	DL_Backlog DL_Backlog;

	NewLLSubmissionPage NewLLSubmissionPage;
	ApplicationStatusStage01Page applicationStatusstage01;


	@BeforeMethod
	public void LaunchApplication() throws IOException {
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
	}

	@Test(invocationCount = 1)
	public void IssueofDuplicateDLService() throws IOException, InterruptedException, ClassNotFoundException, SQLException{
		String Testcase = "Applicationstatus";
		if(Testcase.equalsIgnoreCase("Applicationstatus")) {
//			DL_Backlog = new DL_Backlog(driver);
//			DL_Backlog.SetMobilenumber(getdata("Mobilenumber"));
//			driver.findElement(By.xpath("//input[@id='entcaptxt']")).sendKeys("123456");
//			driver.findElement(By.xpath("//button[@value='Generate OTP']")).click();
//			driver.findElement(By.xpath("//input[@id='otpNumberSarathi']")).sendKeys("123456");
//			driver.findElement(By.xpath("//input[@id='entcaptxt1']")).sendKeys("123456");
//			wait(3);
//			driver.findElement(By.xpath("//input[@value='Submit OTP']")).click();
			
			StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
			stateSelectionPage.Selectstatename(getdata("State"));
			StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
			stateSpecificHomePage.closeContactlessLicenceServicesPopup();
			DrivingLicenceMenuPage Dlmenu= new DrivingLicenceMenuPage(driver);
			Dlmenu.Mouserhoveron_DrivingLicence();
			Dlmenu.Clickon_ServicesonDL();
			InstructionsforDLServicePage instructionsforDLService= new InstructionsforDLServicePage(driver);
			instructionsforDLService.Clickon_ContinuebuttoninInstructionsPage();
			ApplicationForServicesonDLPage applicationForServicesonDL= new ApplicationForServicesonDLPage(driver);
			applicationForServicesonDL.SetDLnumber();
			applicationForServicesonDL.SetDateofbirth();
			applicationForServicesonDL.EnterCaptchatoFetchDetails();
			applicationForServicesonDL.checkboxPolicyTerms();
			applicationForServicesonDL.Clickon_Getdetails();
			 if(alertExist(driver)) {
					acceptAlert(driver);
					wait(2);
				}else {
					System.out.println("There is no Confirmbutton");
				}
			 wait(3);
			ApplicationForServicesonDL2Page applicationForServicesonDL2page= new ApplicationForServicesonDL2Page(driver);
			applicationForServicesonDL2page.SelectYesOrNofromDropdown();
			applicationForServicesonDL2page.ClearPincode();
			wait(3);
			applicationForServicesonDL2page.SelectRTO();
			wait(3);
			applicationForServicesonDL2page.Confirmbutton();
			wait(3);
			DetailsofDLHolderPage detailsofDLHolder= new DetailsofDLHolderPage(driver);
			detailsofDLHolder.Selectbloodgrp();
			detailsofDLHolder.SelectawareSurrender();
			detailsofDLHolder.SelectMethodOfDispatch();
			detailsofDLHolder.selecthowtocollectDL();
			detailsofDLHolder.ConfirmbuttoninDLServsubmission();
			 utilitymethods = new Utilitymethods(driver);
			 utilitymethods.authentication();
			DLServiceSelectionPage dLServiceSelectionPage= new DLServiceSelectionPage(driver);
			dLServiceSelectionPage.selectserviceforDupliDL();
			wait(3);
			dLServiceSelectionPage.ClickProceedinServiceSelectionPage();
			DuplicateDLPage duplicateDLPage= new DuplicateDLPage(driver);
			duplicateDLPage.IssueDupDL();
			
			duplicateDLPage.SelectReasonforDuplicateDL();
			duplicateDLPage.ClickConfirmButton();
			if (driver.getPageSource().contains(" Please fill the Self declaration as to Physical Fitness Details")) {
				ChangeOfAddressInDLPage changeOfAddressInDLPage= new ChangeOfAddressInDLPage(driver);
				changeOfAddressInDLPage.Form_1_Check();
			} else {
				
				System.out.println("There is no Self declaration option");
			}
			duplicateDLPage.CheckBoxDisclaimers();
			duplicateDLPage.SelectOrganDonor();
			duplicateDLPage.EnterCaptcha();
			duplicateDLPage.ClickSubmitForServiceReq();
			Flows flows = new Flows(driver);
			flows.VerifyFlows();
			
		}else {

			// Applicationstatus code
		//	llmodule = new LLModule(driver);
		//	llmodule.SelectState();
			/*
			 * driver.findElement(By.xpath("//span[text() = '---Select RTO Office---']")).
			 * click(); WebElement element =
			 * driver.findElement(By.xpath("//input[@class = 'select2-search__field']"));
			 * element.sendKeys("hyd"); element.sendKeys(Keys.RETURN);
			 */
			//llmodule.closeContactlessLicenceServicesPopup();
			applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
			applicationStatusstage01.enterdetails_In_Applicationstaus();
			Flows flows = new Flows(driver);
			flows.VerifyFlows();
			flows.RTOLevel_Status();
			driver.findElement(By.xpath("//button[@value = 'Home']")).click();
			// VALIDITY UPDATION
			//llmodule.LLvalidityupdation();
		}
		
	}
	
		@AfterMethod
	public void AfterExecution(){
			//driver.quit();
		}
		
		
		
	}
	