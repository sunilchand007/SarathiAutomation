package transactions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.ApplicationForServicesonDL2Page;
import pageobjects.ApplicationForServicesonDLPage;
import pageobjects.ChangeOfAddressInDLPage;
import pageobjects.DLExtractpage;
import pageobjects.DLServiceSelectionPage;
import pageobjects.DrivingLicenceMenuPage;
import pageobjects.InstructionsforDLServicePage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Flows;
import utility.Utilitymethods;

public class Transaction_523  extends BaseClass {
	
	WebDriver driver;
	
	
	Utilitymethods utilitymethods;
	
	@BeforeMethod
	public void LaunchApplication() throws IOException {
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
	}
	
	@Test(invocationCount = 1)
	public void dLEXTRACT() throws IOException, InterruptedException, ClassNotFoundException, SQLException{
		
			StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
			 DLExtractpage dlextractpage=new DLExtractpage(driver);
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
				
//				applicationForServicesonDL2page.ClearPincode();
				wait(3);
				applicationForServicesonDL2page.SelectRTO();
				applicationForServicesonDL2page.Confirmbutton();
			    dlextractpage.selecthowtocollectDL();
					 
				if (driver.getPageSource().contains(" I am aware that by applying for this service,"
						+ " I will be issued a new Driving License Card, and I agree that I will surrender of my current Driving License card and not misuse it : ")) {
					dlextractpage.SelectYesOrNofromDropdown();	
				} else {
					
					System.out.println("There is no Surrender of DL Yes or No option");
				}
				dlextractpage.confirm();
				utilitymethods = new Utilitymethods(driver);
				 utilitymethods.nonadharauthentication();
			DLServiceSelectionPage dLServiceSelectionPage= new DLServiceSelectionPage(driver);
			 if(alertExist(driver)) {
					acceptAlert(driver);
				}else {
					System.out.println("There is no Confirmbutton");
				}
			 wait(2);
		    dLServiceSelectionPage.selectserviceforDLExtract();
			dLServiceSelectionPage.ClickProceedinServiceSelectionPage();
			dlextractpage.SelectReasonforExtractofDLDetails();
			dlextractpage.ClickConfirmButton();
			 if (driver.getPageSource().contains(" Please fill the Self declaration as to Physical Fitness Details")) {
					ChangeOfAddressInDLPage changeOfAddressInDLPage= new ChangeOfAddressInDLPage(driver);
					changeOfAddressInDLPage.Form_1_Check();
				} else {
					
					System.out.println("There is no Self declaration option");
				}
			 if(alertExist(driver)) {
					acceptAlert(driver);
				}else {
					System.out.println("There is no Confirmbutton");
				}
			dlextractpage.CheckBoxDisclaimers();
			dlextractpage.SelectOrganDonor();
			dlextractpage.EnterCaptcha();
			dlextractpage.ClickSubmitForServiceReq();
			Flows flows = new Flows(driver);
			flows.VerifyFlows();
			flows.RTOLevel_Status(); 
		 }
		
	 }

