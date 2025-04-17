package transactions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.Action_135;
import actions.Action_200;
import actions.Action_215;
import frameworkLibrary.BaseClass;
import pageobjects.ApplicationStatusStage01Page;
import pageobjects.ApplicationStatusStage02Page;
import pageobjects.AuthenticationPage;
import pageobjects.NewLLAcknowledgementPage;
import pageobjects.NewLLCategoryAndHoldingPage;
import pageobjects.NewLLInstructionsPage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.FlowsNew;
import utility.Utilitymethods;


public class Transaction_501 extends BaseClass {

	//WebDriver driver;
	Action_200 action_200;
	Action_135 action_135;
	Utilitymethods utilitymethods;
	StateSelectionPage stateSelectionPage;
	StateSpecificHomePage stateSpecificHomePage;
	NewLLInstructionsPage newLLInstructions;
	AuthenticationPage authenticationPage;
	ApplicationStatusStage01Page applicationStatusstage01;
	ApplicationStatusStage02Page applicationStatusstage02;
	Action_215 action_215;
	
	// This method tests all the scenerios for Transcation 501 as configured in
	// Excel
	

	
	/*
	 * @BeforeMethod public void LaunchApplication() throws IOException {
	 * 
	 * utilitymethods = new Utilitymethods(driver); driver =
	 * utilitymethods.Launch_ApplicationUrl(); stateSelectionPage = new
	 * StateSelectionPage(driver);
	 * stateSelectionPage.Selectstatename(getdata("State")); stateSpecificHomePage =
	 * new StateSpecificHomePage(driver);
	 * stateSpecificHomePage.closeContactlessLicenceServicesPopup();
	 * 
	 * }
	 * 
	 */

	@Test(invocationCount = 1)

	public void issueOfLearnerLicence() throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		
		String status = getdata("Testcase");
		System.out.println("status of execution is :" + status);
		if (status.equalsIgnoreCase("FreshLL")) {
			System.out.println("Inside freshLL");
			// utilitymethods = new Utilitymethods(driver);
			// utilitymethods.ArrangeDataSet();
			
			action_200 = new Action_200(driver);
			action_200.FILL_APPLICATION_DETAILS_FOR_LL();
		}else {
			action_215 = new Action_215(driver);
			action_215.applicationstatus();
		}
		 FlowsNew flowsNew = new FlowsNew(driver);
		 flowsNew.verify_flows_of_Alltranscations();
	}
}
