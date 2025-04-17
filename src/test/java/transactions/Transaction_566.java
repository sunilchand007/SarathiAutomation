 package transactions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.CL_ConvertTempCLToPermCLPage;
import pageobjects.CL_RegProvCL_AcknowledgementPage;
import pageobjects.CL_RegularizeProvisionalCLPage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Utilitymethods;

public class Transaction_566 extends BaseClass{
	
	WebDriver driver;
	StateSelectionPage stateSelectionPage;
	StateSpecificHomePage stateSpecificHomePage;
	
	@Test
	public void regularizeProvisionalCL() throws IOException, ClassNotFoundException, SQLException {
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();

		stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.closeContactlessLicenceServicesPopup();
		stateSpecificHomePage.Mouserhoveron_ConductorLicence();
		stateSpecificHomePage.Clickon_RegularizeProvisionalCL();
		CL_RegularizeProvisionalCLPage RegularizeProvisional=new CL_RegularizeProvisionalCLPage(driver);
		RegularizeProvisional.enter_TemporaryCL(getdata("TempCLNumber"));
		RegularizeProvisional.enter_Captcha("123456");
		RegularizeProvisional.clickon_ProceedBtn();
		CL_ConvertTempCLToPermCLPage ConvertTempCLToPermCL=new CL_ConvertTempCLToPermCLPage(driver);
		ConvertTempCLToPermCL.enter_Remarks(getdata("Remarks"));
		ConvertTempCLToPermCL.clickon_SubmitBtn();
		CL_RegProvCL_AcknowledgementPage acknowledgement=new CL_RegProvCL_AcknowledgementPage(driver);
		acknowledgement.Capture_RegProvCL_AcknowledgementDetails();
		
		Utilitymethods utilities = new Utilitymethods(driver);
		utilities.Validating_Flows();		
	}

}
