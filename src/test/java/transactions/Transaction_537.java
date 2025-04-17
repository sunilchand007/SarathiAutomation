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
import pageobjects.ChangeOfAddressInDLPage;
import pageobjects.DLExtractpage;
import pageobjects.DLServiceSelectionPage;
import pageobjects.DetailsofDLHolderPage;
import pageobjects.DrivingLicenceMenuPage;
import pageobjects.InstructionsforDLServicePage;
import pageobjects.RevalidationofDLPage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Flows;
import utility.Utilitymethods;

public class Transaction_537 extends BaseClass {
	
	WebDriver driver;
	boolean stepstatus;

	Flows flows;
	Utilitymethods utilitymethods;

	@BeforeMethod
	public void LaunchApplication() throws IOException {
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
	}

	@Test(invocationCount= 1 )
	public void ReValidationofDLService() throws IOException, InterruptedException, ClassNotFoundException, SQLException{
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
		
		wait(3);
		ApplicationForServicesonDL2Page applicationForServicesonDL2page= new ApplicationForServicesonDL2Page(driver);
		applicationForServicesonDL2page.SelectYesOrNofromDropdown();
//		applicationForServicesonDL2page.ClearPincode();
		applicationForServicesonDL2page.SelectRTO();
		applicationForServicesonDL2page.Confirmbutton();
		if(alertExist(driver)) {
			acceptAlert(driver);
			wait(2);
			
		}else {
			System.out.println("There is no Alert");
		}
		DetailsofDLHolderPage detailsofDLHolder= new DetailsofDLHolderPage(driver);
		detailsofDLHolder.Selectbloodgrp();
		detailsofDLHolder.SelectawareSurrender();
//		detailsofDLHolder.SelectMethodOfDispatch();
		detailsofDLHolder.ConfirmbuttoninDLServsubmission();
		 utilitymethods = new Utilitymethods(driver);
		 utilitymethods.authentication();
		DLServiceSelectionPage dLServiceSelectionPage= new DLServiceSelectionPage(driver);
		dLServiceSelectionPage.SelectServiceRevalidationOfDL();
		RevalidationofDLPage revalidationofDLPage= new RevalidationofDLPage(driver);
//		revalidationofDLPage.Fill_Form1Details();
		if (driver.getPageSource().contains(" Please fill the Self declaration as to Physical Fitness Details")) {
			ChangeOfAddressInDLPage changeOfAddressInDLPage= new ChangeOfAddressInDLPage(driver);
			changeOfAddressInDLPage.Form_1_Check();
		} else {
			
			System.out.println("There is no Self declaration option");
		}
		revalidationofDLPage.CheckBoxDisclaimers();
		revalidationofDLPage.SelectOrganDonor();
		revalidationofDLPage.EnterCaptcha();
		revalidationofDLPage.ClickSubmitForServiceReqRevalidationofDL();
		Flows flows = new Flows(driver);
		flows.VerifyFlows();
		flows.RTOLevel_Status();
		
	}
	
		@AfterMethod
	public void AfterExecution(){
		//	driver.quit();
		}
		
		
		
	}
	