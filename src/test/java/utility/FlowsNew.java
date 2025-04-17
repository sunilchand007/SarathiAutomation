package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import actions.Action_123;
import actions.Action_132;
import actions.Action_134;
import actions.Action_135;
import frameworkLibrary.BasePage;
import pageobjects.ApplicationStatusStage01Page;
import pageobjects.ApplicationStatusStage02Page;
import pageobjects.RTO_LoginHomePage;
import pageobjects.VerifyApplicationCurrentStatusPage;

public class FlowsNew extends BasePage{

	WebDriver driver;
	  ApplicationStatusStage01Page applicationStatusstage01;
	  
	public FlowsNew (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void verify_flows_of_Alltranscations() throws IOException, InterruptedException {
		
		ApplicationStatusStage02Page applicationStatusstage02 = new ApplicationStatusStage02Page(driver);
		int remainingFlows = applicationStatusstage02.numberOfRemainingFlows();
		System.out.println("Count of Remaining Flows are  " + remainingFlows);
	
		for (int i = 1; i <= remainingFlows; i++) {
			String nextFlow = applicationStatusstage02.getAndEnterNextFlow();
			System.out.println("The Next Flow for LL is  " + nextFlow);
			applicationStatusstage02.Clickon_Proceed_Button();
		
		if (nextFlow.contains("UPLOAD PHOTO AND SIGNATURE")) {
			Action_135  action_135 = new Action_135(driver);
		    action_135.uplaodphotoandsignature();
		    applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
		    applicationStatusstage01.enterdetails_In_Applicationstaus();
			
		} else if (nextFlow.contains("UPLOAD DOCUMENTS")) {
			Action_123 action_123 = new Action_123(driver);
			action_123.uploadDocuments();
			applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
		    applicationStatusstage01.enterdetails_In_Applicationstaus();
			
	}
		else if (nextFlow.contains("FEE PAYMENT")) {
			Action_134 action_134 = new  Action_134(driver);
			action_134.feePayment();
			applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
		    applicationStatusstage01.enterdetails_In_Applicationstaus();
			
		}else if (nextFlow.contains("LL TEST SLOT BOOKING")) {
			Action_132 action_132 = new Action_132(driver);
			action_132.LLslotbooking();
			applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
		    applicationStatusstage01.enterdetails_In_Applicationstaus();
			
			// RTO FLows
			VerifyApplicationCurrentStatusPage verifyApplicationCurrentStatus = new VerifyApplicationCurrentStatusPage(
					driver);
			verifyApplicationCurrentStatus.Verify_ApplicationCurrentStatus();
			// Misc>>Application Status
			RTO_LoginHomePage rTO_LoginHomePage = new RTO_LoginHomePage(driver);
			rTO_LoginHomePage.Clickon_Misc();
			rTO_LoginHomePage.Click_on_applicationstatus();
			rTO_LoginHomePage.EnterApplicationNumber(getdata("ApplicationNo"));
			rTO_LoginHomePage.Click_on_viewflows();
			rTO_LoginHomePage.Click_on_processflow();
			
		}
	}
}
	
	
}
