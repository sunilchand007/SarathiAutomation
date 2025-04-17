package transactions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.*;
import utility.Utilitymethods;

public class Transaction_574 extends BaseClass {
	WebDriver driver;
	Transaction_591 llbacklog;
	@BeforeMethod

	public void LaunchApplication() throws IOException {

		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();

	}
	
	@Test(invocationCount = 1)
	public void llservicesTransactions() throws IOException, ClassNotFoundException, SQLException, InterruptedException {
	
		llbacklog = new Transaction_591();
		llbacklog.llBacklogEntry();
		StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.closeContactlessLicenceServicesPopup();
		stateSpecificHomePage.Mouserhoveron_LearnerLicence();
		stateSpecificHomePage.Clickon_Servicesfor_DuplicateLL_Addresschange_etc();
		NewLLInstructionsPage newLLInstructions = new NewLLInstructionsPage(driver);
		newLLInstructions.clickonContinue();
		DisplayLLServicesPage displayLLServicesPage = new DisplayLLServicesPage(driver);
		displayLLServicesPage.SetTextinLearnersLicencenumber(getdata("LLNumber"));
		displayLLServicesPage.SetTextinDateofBirth(getdata("DateofBirth"));
		displayLLServicesPage.ClickonProceedbutton();
		displayLLServicesPage.ClickonConfirmbtn();
		displayLLServicesPage.ClickonGobutton();
		String testcase = getdata("Testcase");
		if(testcase.equalsIgnoreCase("ChangeofAddress")) {
			//504
			displayLLServicesPage.clickChangeofAddressinLLCheckbox();
		}
		
		else if(testcase.equalsIgnoreCase("duplicateLL")){
			//502
			displayLLServicesPage.clickDuplicateLLinLLCheckbox();
		} 
		
		else if(testcase.equalsIgnoreCase("change of name")){
			//574
			displayLLServicesPage.clickchangeofnameLLinLLCheckbox();
		} 
		//common 
		displayLLServicesPage.ClickonSubmitbuttoninSelectService();
		ShowSelectedLLservicesPage01 showSelectedLLservicesPage01= new ShowSelectedLLservicesPage01(driver);
		showSelectedLLservicesPage01.enterOtp();
		showSelectedLLservicesPage01.clickSubmitbutton_afterOtp();
		
		if(testcase.equalsIgnoreCase("ChangeofAddress")) {

			//change of address 
			ShowSelectedLLservicesPage02 showSelectedLLservicesPage02= new ShowSelectedLLservicesPage02(driver);
			showSelectedLLservicesPage02.click_Present_address_radiobutton();
			showSelectedLLservicesPage02.select_Dropdown_subdistrict("Bilsi");
			showSelectedLLservicesPage02.enterLoacation("dfdsf");
			showSelectedLLservicesPage02.enterPincode("243601");
			showSelectedLLservicesPage02.clickconfirmbutton();
		}
		
		else if(testcase.equalsIgnoreCase("duplicateLL")){
			//duplicate LL 
			
			showSelectedLLservicesPage01.selectreasonforduplicateLL("30");
			showSelectedLLservicesPage01.clickconfirmbutton_after_selecting_reason();
		} 
		
		else if(testcase.equalsIgnoreCase("change of name")){
		
		} 
		
		wait(30);
		ShowSelectedLLservices_CaptchaPage showSelectedLLservices_CaptchaPage = new ShowSelectedLLservices_CaptchaPage (driver);
		
		//common
		driver.findElement(By.xpath("//input[@id='commonCaptcha']")).sendKeys("123456");
		showSelectedLLservices_CaptchaPage.clickSubmitbutton_aftercapctha();
		

	}
}
