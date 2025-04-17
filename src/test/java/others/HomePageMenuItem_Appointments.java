package others;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.ApplicationFeePaymentSuccessAckPage;

import pageobjects.LLSlotBookingPageeOLD;
import pageobjects.NewDLSlotBookingPageOLD;
import pageobjects.NewLLInstructionsPage;
import pageobjects.SBHIntroPage;
import pageobjects.SBHhomePage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import pageobjects.UploadDocumentsStage01Page;
import pageobjects.UploadDocumentsStage02Page;
import pageobjects.UploadDocumentsStage03Page;
import pageobjects.UploadPhoto_SignaturePageOLD;
import utility.Flows;
import utility.Utilitymethods;

public class HomePageMenuItem_Appointments extends BaseClass {
	WebDriver driver;

	Flows validate;


	
	@BeforeMethod
	public void LaunchApplication() throws IOException {
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();

	}



	@Test(invocationCount = 1)
	public void TC_Slot_Booking_LLTest() throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		
		StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.closeContactlessLicenceServicesPopup();
		stateSpecificHomePage.Mouserhoveron_LearnerLicence();
		stateSpecificHomePage.Clickon_Application_for_New_LearnerLicence();
		NewLLInstructionsPage newLLInstructions = new NewLLInstructionsPage (driver);
		newLLInstructions.clickonContinue();
	
		
		//int remainingFlows=applicationStatus.numberOfRemainingFlows();
		//System.out.println("Count of Remaining Flows are  "+ remainingFlows);
		//for (int i=1; i<=remainingFlows;i++){
		//	String nextFlow =applicationStatus.getAndEnterNextFlow();
		//	System.out.println("The Next Flow for LL is  "+ nextFlow);
		//	applicationStatus.Clickon_Proceed_Button();
		//	if(nextFlow.contains("UPLOAD PHOTO AND SIGNATURE")){
		UploadPhoto_SignaturePageOLD uploadPhotoandSign= new UploadPhoto_SignaturePageOLD(driver);
					uploadPhotoandSign.Clickon_Browse_Button1();
					uploadPhotoandSign.Clickon_Browse_Button2();
					uploadPhotoandSign.Clickon_UploadandViewfiles();
					uploadPhotoandSign.Clickon_SavephotoandSignature();
					uploadPhotoandSign.Clickon_Next();
		//	}else if(nextFlow.contains("UPLOAD DOCUMENTS")){
					System.out.println("Inside Upload Documents Flow");
					UploadDocumentsStage01Page uploadDocumentsStage01= new UploadDocumentsStage01Page(driver);
					uploadDocumentsStage01.click_on_SubmitButtoninUploadDocument01();
					UploadDocumentsStage02Page uploadDocumentsStage02=new UploadDocumentsStage02Page(driver);
					uploadDocumentsStage02.click_on_SubmitButtoninUploadDocument02();
					UploadDocumentsStage03Page uploadDocumentsStage03=new UploadDocumentsStage03Page(driver);
					uploadDocumentsStage03.uploadDocuments();
			//}else if (nextFlow.contains("FEE PAYMENT")){
				System.out.println("Inside  Fee Payments Flow");
			//	ApplicationFeeLLDLTest applicationFeeLLDLTest = new ApplicationFeeLLDLTest(driver);
				//applicationFeeLLDLTest.Enter_Application_Number(getdata("ApplicationNo"));
			//	applicationFeeLLDLTest.Enter_DateofBirth(getdata("DateofBirth"));
			//	applicationFeeLLDLTest.Clickon_Calculate_Fee();
			//	applicationFeeLLDLTest.SelectBank(getdata("SelectBankforFeePayment"));
			//	applicationFeeLLDLTest.SetCaptcha();
			//	applicationFeeLLDLTest.Clickon_Paynow_Button();
			// applicationFeepaymentTranscationDetails = new ApplicationFeepaymentTranscationDetails(driver);
			//	applicationFeepaymentTranscationDetails.Clickon_Checkbox();
				//applicationFeepaymentTranscationDetails.Clickon_Proceedforpayment();
				SBHIntroPage sBHIntro = new SBHIntroPage(driver);
				sBHIntro.Clickon_ContinuetoLogin_Button();
				SBHhomePage sBHhome = new SBHhomePage(driver);
				sBHhome.Clickon_Pressheretocontinue_Button();
				ApplicationFeePaymentSuccessAckPage applicationFeePaymentSuccessAck= new ApplicationFeePaymentSuccessAckPage(driver);
				applicationFeePaymentSuccessAck.Clickon_NextbuttoninApplicationFeePaymentSuccessAck();
		//	}else if (nextFlow.contains("LL TEST SLOT BOOKING")){
				LLSlotBookingPageeOLD LLSlotBooking = new LLSlotBookingPageeOLD(driver);
				LLSlotBooking.Menuitem_Slot_Booking_LLTest();
			}
			
		//	}
	//	}
	

	@Test(invocationCount = 3)
	public void TC_Slot_Booking_DL_Test() {
		NewDLSlotBookingPageOLD NewDLSlotBooking = new NewDLSlotBookingPageOLD(driver);
		NewDLSlotBooking.SelectState();
		NewDLSlotBooking.Menuitem_Slot_Booking_DLTest();

	}

	@Test(invocationCount = 1)
	public void TC_Slot_Booking_DL_services() {
		NewDLSlotBookingPageOLD NewDLSlotBooking = new NewDLSlotBookingPageOLD(driver);
		NewDLSlotBooking.SelectState();
		NewDLSlotBooking.Menuitem_Slot_Booking_DL_services();
	}

	@Test(invocationCount = 1)
	public void TC_Enquiry_LL_Test_Slot() {
		LLSlotBookingPageeOLD LLSlotBooking = new LLSlotBookingPageeOLD(driver);
		LLSlotBooking.SelectState();
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.closeContactlessLicenceServicesPopup();
		LLSlotBooking.Menuitem_Enquiry_LLTest_Slot();

	}

	@Test(invocationCount = 1)
	public void TC_Enquiry_DL_Test_Slot() {
		NewDLSlotBookingPageOLD NewDLSlotBooking = new NewDLSlotBookingPageOLD(driver);
		NewDLSlotBooking.SelectState();
		NewDLSlotBooking.Menuitem_Enquiry_DLTest_Slot();

	}

	@Test(invocationCount = 1)
	public void TC_Enquiry_on_DL_Services_Slot() {
		NewDLSlotBookingPageOLD NewDLSlotBooking = new NewDLSlotBookingPageOLD(driver);
		NewDLSlotBooking.SelectState();
		NewDLSlotBooking.Menuitem_Enquiry_DLServices_Slot();
	}

	@Test(invocationCount = 1)
	public void TC_Cancel_LL_Test_Slot() {
		LLSlotBookingPageeOLD LLSlotBooking = new LLSlotBookingPageeOLD(driver);
		LLSlotBooking.SelectState();
		LLSlotBooking.Menuitem_Cancel_LL_Test_Slot();
	}

	@Test(invocationCount = 3)
	public void TC_Cancel_DL_Test_Slot() throws IOException {
		NewDLSlotBookingPageOLD NewDLSlotBooking = new NewDLSlotBookingPageOLD(driver);
		NewDLSlotBooking.SelectState();
		NewDLSlotBooking.Menuitem_Cancel_DL_Test_Slot();
	}

	@Test(invocationCount = 1)
	public void TC_Cancel_DL_Services_Slot() throws IOException {
		NewDLSlotBookingPageOLD NewDLSlotBooking = new NewDLSlotBookingPageOLD(driver);
		NewDLSlotBooking.SelectState();
		NewDLSlotBooking.Menuitem_Cancel_DLServices_Test_Slot();
	}

	@AfterMethod
	public void CloseBrowser() {
		// driver.quit();
		System.out.println("**************After Method***************");
	}

}