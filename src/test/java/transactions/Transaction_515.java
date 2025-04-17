package transactions;

import java.io.IOException;
import java.sql.SQLException;

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
import pageobjects.DetailsofDLHolderPage;
import pageobjects.DrivingLicenceMenuPage;
import pageobjects.InstructionsforDLServicePage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Flows;
import utility.Utilitymethods;

public class Transaction_515 extends BaseClass {

	WebDriver driver;
	boolean stepstatus;
	Flows flows;
	ApplicationStatusStage01Page applicationStatusstage01;

	Utilitymethods utilitymethods;

	@BeforeMethod
	public void LaunchApplication() throws IOException {
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
	}
	 
	 
	
	@Test(invocationCount=1)
	public void ChangeofAddressinDLService() throws IOException, InterruptedException, ClassNotFoundException, SQLException{
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
		wait(6);
		 if(alertExist(driver)) {
				acceptAlert(driver);
				wait(2);
				
			}else {
				System.out.println("There is no Alert");
			}
		ApplicationForServicesonDL2Page applicationForServicesonDL2page= new ApplicationForServicesonDL2Page(driver);
		applicationForServicesonDL2page.SelectYesOrNofromDropdown();
		applicationForServicesonDL2page.ClearPincode();
		applicationForServicesonDL2page.SelectRTO();
		applicationForServicesonDL2page.Proceedbutton();
		DetailsofDLHolderPage detailsofDLHolder= new DetailsofDLHolderPage(driver);
		detailsofDLHolder.SelectMethodOfDispatch();
		detailsofDLHolder.SelectawareSurrender();
		
		applicationForServicesonDL2page.Confirmbutton();
//		applicationForServicesonDL2page.SurrenderDL();
		 if(alertExist(driver)) {
				acceptAlert(driver);
				wait(2);
				
			}else {
				System.out.println("There is no Alert");
			}
		
		detailsofDLHolder.Selectbloodgrp();
//		detailsofDLHolder.SelectawareSurrender();
		
//		detailsofDLHolder.ConfirmbuttoninDLServsubmission();
		 utilitymethods = new Utilitymethods(driver);
		 utilitymethods.authentication();
		 if(alertExist(driver)) {
			    wait(2);
				acceptAlert(driver);
				wait(2);
				
			}else {
				System.out.println("There is no Alert");
			}
		DLServiceSelectionPage dLServiceSelectionPage= new DLServiceSelectionPage(driver);
		dLServiceSelectionPage.selectserviceforChangeOfAddress();
		dLServiceSelectionPage.ClickProceedinServiceSelectionPage();
		ChangeOfAddressInDLPage changeOfAddressInDLPage= new ChangeOfAddressInDLPage(driver);
		changeOfAddressInDLPage.ClickOnPermanentbutton();
		wait(3);
		changeOfAddressInDLPage.SelectState();
		changeOfAddressInDLPage.SelectDistrictdetails();
		
		changeOfAddressInDLPage.EnterPincode();
		changeOfAddressInDLPage.ClickConfirminDLService();
		wait(3);
		if (driver.getPageSource().contains(" Please fill the Self declaration as to Physical Fitness Details") || 
				driver.getPageSource().contains(" Please fill the Self declaration as to Physical Fitness Details :    ")) {
			changeOfAddressInDLPage.Fill_Form1Details();
		} else {
			
			System.out.println("There is no Self declaration option");
		}
		
		changeOfAddressInDLPage.CheckBoxDisclaimers();
		changeOfAddressInDLPage.SelectOrganDonor();
		changeOfAddressInDLPage.EnterCaptcha();
		changeOfAddressInDLPage.ClickOnSubmitButton();
		Flows flows = new Flows(driver);
		flows.VerifyFlows();
		flows.RTOLevel_Status();
		
	}
	
	
		@AfterMethod
	public void AfterExecution(){
//			driver.quit();
		}
		
	 	
		
	}
	